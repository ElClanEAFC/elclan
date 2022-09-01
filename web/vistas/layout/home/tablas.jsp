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

<%
 String codArea = request.getParameter("codArea");    
 String nomArea = request.getParameter("nomArea"); 
%>
<!--============================================================================
MODALES
=============================================================================-->
<div id="crearUsu"></div>
<input type="hidden" name="codArea" id="codArea" value="<%=codArea %>">
<input type="hidden" name="noArea" id="noArea" value="<%=nomArea %>">
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
                        <h4 class="page-title"><%=nomArea %></h4>
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
                                <!--
                                <div class="col-md-12 badge bg-danger cabecera">
                                    <div class="row">
                                        <div class="col-10"></div>
                                        <div class="col-2">
                                            <ul>
                                                <li><a href="#" onclick="crearUsuario();" title="Agregar Usuarios"><i class="fas fa-plus-circle"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                -->
                                <div class="row">
                                    <!-- contenido -->
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-3">
                                                    <h4 class="card-title">Agregar nuevo Rol o cargo</h4>
                                                    <hr>
                                                    <form>
                                                        <input type="hidden" name="codPerfil" id="codPerfil">
                                                        <label for="perfilRol">Nombre rol o cargo</label>
                                                        <input type="text" name="nomPerfil" id="nomPerfil" class="form-control">
                                                        <br>
                                                        <!--<input type="submit" value="Guardar" id="btnArea" class="btn btn-success btn-lg text-white" onclick="guardarArea();">-->
                                                        <button class="btn btn-success btn-lg text-white" onclick="guardarPerfil();"  id="btnPerfil">Guardar</button>
                                                    </form>
                                                </div>
                                                <div class="col-1"><br></div>
                                                <div class="col-11">
                                                    <h4 class="card-title">Lista de roles o cargos</h4>
                                                    <hr>
                                                    <div class="table-responsive">
                                                        <table id="tablaUsuarios" class="table  table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th style="width:5%">N°</th>
                                                                    <th style="width:15%">Medio de pago</th>
                                                                    <th style="width:15%">Banco</th>
                                                                    <th style="width:20%">N° Cuenta</th>
                                                                    <th style="width:20%">N° Operacion</th>
                                                                    <th style="width:10%">Importe</th>
                                                                    <th style="width:10%">Tipo Moneda</th>
                                                                    <th style="width:5%"></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="lisPerfil">
                                                                <tr>
                                                                    <td>01</td>
                                                                    <!--<td>01</td>-->
                                                                    <td>Trans. Bancaria</td>
                                                                    <td>Banbif</td>
                                                                    <td>0011 124 4585754</td>
                                                                    <td>00125454685</td>
                                                                    <td>15.00</td>
                                                                    <td>Dolares</td>
                                                                    <td><i class="far fa-trash-alt borrar"></i></td>
                                                                </tr>
                                                                
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
    var codArea = $("#codArea").val();
    listarPerfiles(codArea);
}    
function crearUsuario(){
    window.location("crearUsuario.jsp");
}
function guardarPerfil(){
    //var codArea   = $("#codPerfil").val();
    var nomPerfil = $("#nomPerfil").val();
    var codArea   = $("#codArea").val();
    var noArea    = $("#noArea").val();
    var param = 'nomPerfil='+nomPerfil+'&codArea='+codArea+'&noArea='+noArea;
    //alert(param);
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=guardarCargo',
        data: 'codArea='+codArea+'&nomPerfil='+nomPerfil,
        beforeSend: function () {
        }, success: function (resultado) {
           //$("#"+mostrar).html(resultado);
        }, complete: function () {
            window.location.href = "roles.jsp?codArea="+codArea+"&nomArea="+noArea;
            //listarPerfiles(codArea);
        }
    });
}
function confirBorrarPerfil(codPerfil){
    Swal.fire({
        title: 'Mensaje',
        text: "Esta seguro de desactivar el Perfil",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#48C28D',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Continuar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          borrarPerfil(codPerfil);
        }
      })
    
}

function borrarPerfil(codPerfil){
    var nomUsu  = $("#nomUser").val();
    
    var codArea   = $("#codArea").val();
    var noArea    = $("#noArea").val();
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=borrarPerfil',
        data: 'codPerfil='+codPerfil+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
           //$("#"+mostrar).html(resultado);
        }, complete: function () {
            window.location.href = "roles.jsp?codArea="+codArea+"&nomArea="+noArea;
        }
    });
}


function editPerfil(codPerfil, nomPerfil){
    
    $("#codPerfil").val(codPerfil);
    $("#nomPerfil").val(nomPerfil);
    $("#btnPerfil").attr("onclick","actualizarPerfil()");
    $("#btnPerfil").html('Actualizar');
}

function actualizarPerfil(){
    var codArea = $("#codArea").val();
    var codPerf = $("#codPerfil").val();
    var nomPerf = $("#nomPerfil").val();
    var nomUsu  = $("#nomUser").val();
    var noArea  = $("#noArea").val();
    //alert(nomUsu);
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=actualizarPerfil',
        data: 'codArea='+codArea+'&codPerf='+codPerf+'&nomPerf='+nomPerf+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
        }, complete: function () {
            window.location.href = "roles.jsp?codArea="+codArea+"&nomArea="+noArea;
        }
    });
}

function listarPerfiles(codArea){
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=listarPerfiles',
        data: 'codArea='+codArea,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#lisPerfil").html(resultado);
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