<%-- 
    Document   : grupos
    Created on : 15/03/2022, 
    Author     : bentu condori
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<!--===========inclui el archivo de la cabecera css o jquery====================-->
<jsp:include page="../includes/header.jsp" />  
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
<!--============================================================================
MODALES
=============================================================================-->

<!--============================================================================
FIN MODALES
=============================================================================-->
        <!--==========contenido del sistema=====================================-->
        <div class="page-wrapper css-contenido">
            <!--===========inicio de menu del historial de navegacion===========-->
            <jsp:include page="../includes/menu-interno.jsp" />   
            <!--<div class="page-breadcrumb">
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
            </div>-->
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
                                                    <button class="btn btn-success btn-lg text-white" onclick="habRegisGrupo();" id="btnAddPro"><i class="fas fa-plus"></i> Crear Nuevo Grupo</button>
                                                    <hr>
                                                    <form class="frmPrograma hide" id="frmGrupo" >
                                                        <input type="hidden" name="codPrograma" id="codArea">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="gruPrograma">Programa *</label>
                                                                <select name="selectPrograma" id="selectPrograma" class="form-control" title="Seleccione Programa" required></select>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="grupSubPrograma">Sub Programa *</label>
                                                                <select name="grupSubPrograma" id="grupSubPrograma" onchange="listPlazoDuracion('2');" class="form-control" title="Seleccione SubPrograma"></select>
                                                                
                                                            </div>
                                                        </div>
                                                        <div id="mosPlazoDuracion">
                                                            
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">Numero del Grupo *</label>
                                                                <input type="text" name="numGrupo" id="numGrupo" class="form-control" title='Ingrese Nombre Comercial' required>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">Fecha Primer Asamblea *</label>
                                                                <input type="date" name="fecAsamblea" id="fecAsamblea" onclick="limiteFechas('fecAsamblea','min','10-03-2022');" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="usuCelular">Valor Certificado Inicial*</label>
                                                                <input type="number" name="minCertificado" id="minCertificado" class="form-control" title='Ingrese N° de Plazas' min="1" required>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="usuCelular">Valor Certificado Final*</label>
                                                                <input type="number" name="maxCertificado" id="maxCertificado" class="form-control" min="1" title='Ingrese N° de Asociados' required>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="usuCelular">Rango de diferencia</label>
                                                                <input type="number" name="cerDiferencia" id="cerDiferencia" class="form-control" min="1" title='Ingrese N° de Asociados' required>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        
                                                        <span class="btn btn-danger btn-lg text-white" onclick="Cancelar('frmPrograma');"  id="btnArea">Cancelar</span>
                                                        <button class="btn btn-success btn-lg text-white"   id="btnCancelar" onclick="validaGuardarGrupo();">Guardar</button>
                                                    </form>
                                                    <div id="frmEditPro"></div>
                                                </div>
                                                
                                                <div class="col-9" style="padding-left: 25px;">
                                                    <h4 class="card-title">Lista grupos</h4>
                                                    <hr>
                                                    <div class="table-responsive">
                                                        <table id="tablaUsuarios" class="table  table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>N°</th>
                                                                    <th>PROGRAMA</th>
                                                                    <th>N° GRUPO</th>
                                                                    <th>F. ASAM. INAUGURAL</th>
                                                                    <th>N° PLAZO</th>
                                                                    <th>N° ASOCIADOS</th>
                                                                    <th>RANGO DE CRETIFICADOS</th>
                                                                    <th>OPCIONES</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="listaPrograma">
                                                                
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
    cargaMenuInterno(2,2);
    listarGrupos();

}  
function habRegisGrupo(){
    $('#frmGrupo').removeClass('hide');
    $('#frmEditPro').addClass('hide');
    listSelectPrograma();
}

function validaGuardarGrupo(){
    $("#frmGrupo").validate({
        submitHandler: function(form) {
            confirGuardarGrupo();
        }
    }); 
}

function confirGuardarGrupo(){
    var codPro = $("#selectPrograma").val();
    var subPro = $("#grupSubPrograma").val();
    var numGru = $("#numGrupo").val();
    var feAsam = $("#fecAsamblea").val();
    var minCer = $("#minCertificado").val();
    var maxCer = $("#maxCertificado").val();
    var cerDif = $("#cerDiferencia").val();
    var param  = 'codPro='+codPro+'&subPro='+subPro+'&numGru='+numGru+'&feAsam='+feAsam+'&minCer='+minCer+'&maxCer='+maxCer+'&cerDif='+cerDif;
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=confirGuardarGrupo',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
           var mensaje = resultado.split("-");
           var codMsj = mensaje[0];
           var desMsj = mensaje[1];
           msjFinal(codMsj, desMsj); 
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}

function listSelectPrograma(){
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listSelectPrograma',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#selectPrograma").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}

$("#selectPrograma").change(function(){
    var codPrograma = $("#selectPrograma").val();
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listSelectSubPrograma',
        data: 'codPrograma='+codPrograma,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#grupSubPrograma").html(resultado);
        }, complete: function () {
            listPlazoDuracion('1');
            mostarNumGrupo();
            mostarCertiMin();
            mostarCertiMax();
        }
    });
})

function listPlazoDuracion(id){
    var codPrograma = "";
    if(id == "1"){
       codPrograma = $("#selectPrograma").val();
    }else{
       codPrograma = $("#grupSubPrograma").val();
    }
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listPlazoDuracion',
        data: 'codPrograma='+codPrograma+'&ide='+id,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#mosPlazoDuracion").html(resultado);
        }, complete: function () {   
        }
    });
}

function mostarNumGrupo(){
    var codPrograma = $("#selectPrograma").val();
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=mostarNumGrupo',
        data: 'codPrograma='+codPrograma,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#numGrupo").val(resultado);
        }, complete: function () {   
        }
    });
}

function mostarCertiMin(){
    var codPrograma = $("#selectPrograma").val();
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=mostarCertiMin',
        data: 'codPrograma='+codPrograma,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#minCertificado").val(resultado);
        }, complete: function () {   
        }
    });
}

function mostarCertiMax(){
    var codPrograma = $("#selectPrograma").val();
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=mostarCertiMax',
        data: 'codPrograma='+codPrograma,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#maxCertificado").val(resultado);
        }, complete: function () {   
        }
    });
}
/****************************************
 *       Basic Table                   *
 ****************************************/

</script>

</html>