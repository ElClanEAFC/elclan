<%-- 
    Document   : index
    Created on : 05/08/2021, 09:33:20 AM
    Author     : bcondori
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<!--===========inclui el archivo de la cabecera css o jquery====================-->
<jsp:include page="../includes/header.jsp" />  
<!--============================================================================
MODALES
=============================================================================-->
<div id="crearUsu"></div>
<!-----------------AGREGAR USUARIO---------------------------------------->

<!--============================================================================
FIN MODALES
=============================================================================-->
<body onload="primeraCarga();">
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
        data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
        <!-- ========incluir menu superior======= -->
        <jsp:include page="../includes/menu-superior.jsp" /> 
        <!--  ========incluir menu lateral========== -->
        <jsp:include page="../includes/menu.jsp" />
        <!--==========contenido del sistema=====================================-->
        <div class="page-wrapper">
            <!--===========inicio de menu del historial de navegacion===========-->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">Inicio</h4>
                        <div class="ms-auto text-end">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Inicio</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Pagina</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!--===========fin del menu del historial de navegacion=============-->
            <div class="container-fluid">
                <div class="row">
                    
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <!--<div class="col-md-12 badge bg-danger cabecera">
                                    <div class="row">
                                        <div class="col-10"></div>
                                        <div class="col-2">
                                            <ul>
                                                <li><a href="#" onclick="crearUsuario();" title="Agregar Usuarios"><i class="fas fa-plus-circle"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>-->
                                <div class="row">
                                    <!-- contenido -->
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-3">
                                                    <h4 class="card-title">Agregar Área</h4>
                                                    <hr>
                                                    <form>
                                                        <input type="hidden" name="codArea" id="codArea">
                                                        <label for="usuCelular">Nombre de area *</label>
                                                        <input type="text" name="nomArea" id="nomArea" class="form-control">
                                                        <br>
                                                        <!--<input type="submit" value="Guardar" id="btnArea" class="btn btn-success btn-lg text-white" onclick="guardarArea();">-->
                                                        <button class="btn btn-success btn-lg text-white" onclick="guardarArea();"  id="btnArea">Guardar</button>
                                                    </form>
                                                </div>
                                                <div class="col-1"><br></div>
                                                <div class="col-6">
                                                    <h4 class="card-title">Lista Áreas</h4>
                                                    <hr>
                                                    <div class="table-responsive">
                                                        <table id="tablaUsuarios" class="table  table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>Nª</th>
                                                                    <th>Nombre Area</th>
                                                                    <th>U. Creacion</th>
                                                                    <th>F. Creacion</th>
                                                                    <th>Opciones</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="lisAreas">
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
        

                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ===========footer ============================================= -->
            <footer class="footer text-center">
                All Rights Reserved a  <a href="#">El clan</a>.
            </footer>
        </div>
        <!--================fin del contenido===================================-->
    </div>
    <!-- =========================footer - los script===========================-->
     <jsp:include page="../includes/footer.jsp" />  

</body>
<script>
function segundaCarga(){
    listarAreas();
}    
function crearUsuario(){
    window.location("crearUsuario.jsp");
}
function guardarArea(){
    var nomArea = $("#nomArea").val();
    var nomUsu  = $("#nomUser").val();
    //alert(nomUsu);
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=guardarArea',
        data: 'nomArea='+nomArea+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
           //$("#"+mostrar).html(resultado);
        }, complete: function () {
            listarAreas();
        }
    });
}

function confirBorrarArea(codArea){
    Swal.fire({
        title: 'Mensaje',
        text: "Esta seguro de borrar el Area?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#48C28D',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Continuar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          borrarArea(codArea);
        }
      })
    
}

function borrarArea(codArea){
    var nomUsu  = $("#nomUser").val();
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=borrarArea',
        data: 'codArea='+codArea+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
           //$("#"+mostrar).html(resultado);
        }, complete: function () {
            listarAreas();
        }
    });
}

function editArea(codArea, nomArea){
    
    $("#codArea").val(codArea);
    $("#nomArea").val(nomArea);
    $("#btnArea").attr("onclick","actualizarArea()");
    $("#btnArea").html('Actualizar');
}

function actualizarArea(){
    var codArea = $("#codArea").val();
    var nomArea = $("#nomArea").val();
    var nomUsu  = $("#nomUser").val();
    //alert(nomUsu);
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=actualizarArea',
        data: 'codArea='+codArea+'&nomArea='+nomArea+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
        }, complete: function () {
            listarAreas();
        }
    });
}

function listarAreas(){
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=listarAreas',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#lisAreas").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}

function agregarUsuario(){
    $('#modalAgregarUsuario').modal('show')

}
/****************************************
 *       Basic Table                   *
 ****************************************/

</script>

</html>