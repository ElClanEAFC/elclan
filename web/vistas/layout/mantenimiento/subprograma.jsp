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
<div class='modal fade' id='modalConfigPago' tabindex='-1' role='dialog'>
    <div class='modal-dialog modal-xl'  role='document'>
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title'><i class="fas fa-tags"></i>Configuracion de Pago del Sub Programa</h4>
                <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                    <span aria-hidden='true'>&times;</span>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <form id="frmConfigPago" method="post">
                        <div class="row">
                            <input type="hidden" name="paCodSubProgra" id="paCodSubProgra">
                            <div class="col-md-4 centrar">
                                <label>Seleccione concepto de pago</label>
                                <select class="form-control" id="tipRecaudo" name="tipRecaudo" title="Seleccione concepto de pago" required>

                                </select>
                            </div>
                            <div class="col-md-4 centrar">
                                <label>Porc.(%) y/o Monto</label>
                                <input type="number" name="monto" id="monto" class="form-control" title="Ingrese el valor" min="1" required>
                            </div>
                            <div class="col-md-4 centrar">
                                <label>Seleccione Indicador</label>
                                <select class="form-control" id="indicador" name="indicador" title="Seleccione indicador del pago" required>

                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 centrar">
                                <label>Seleccione Parametro</label>
                                <select class="form-control" id="parametroCobro" name="parametroCobro" title="Seleccione parametro" required>

                                </select>
                            </div>
                            <div class="col-md-4 centrar">
                                <label>Indicador de Aplicación</label>
                                <select class="form-control" id="aplica" name="aplica"  title="Seleccione indicador de aplicacion" required>

                                </select>
                            </div>
                            <div class="col-md-4 centrar">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-md-4 centrar"></div>
                            <div class="col-md-4 centrar"></div>
                            <div class="col-md-4 centrar">
                                <button  onclick='valPagoConfig();' class='btn btn-primary btn-success'>GUARDAR</button>
                            </div>
                        </div>
                        <br>
                    </form>
                    <hr>
                    <div class="row">
                        <div class="col-md-12 centrar">
                            <div class="table-responsive">
                                <table id="tablaUsuarios" class="table datatable-basic ui celled table responsive nowrap unstackable">
                                    <thead>
                                        <tr>
                                            <th>PROGRAMA</th>
                                            <th>CONCEPTO</th>
                                            <th>VALOR</th>
                                            <th>INDICADOR</th>
                                            <th>REFERENCIA</th>
                                            <th>IND. APLICACION</th>
                                            <th>ESTADO</th>
                                            <th>OPCIONES</th>
                                        </tr>
                                    </thead>
                                    <tbody id="listaConfigPago">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
            <div class='modal-footer'>
                <!--<button type='button' onclick='darBajaUsuario();' class='btn btn-primary btn-success'>Confirmar</button>-->
                <button type='button' onclick='cerrarModal("modalConfigPago");' class='btn btn-secondary btn-danger text-white' data-dismiss='modal'>Cerrar</button>
            </div>
        </div>
    </div>
</div>

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
                                                    <button class="btn btn-success btn-lg text-white" onclick="habilitaAgregar();" id="btnAddPro"><i class="fas fa-plus"></i> Crear SubPrograma</button>
                                                    <hr>
                                                    <form class="frmPrograma hide" id="frmSubPrograma" >
                                                        <input type="hidden" name="codPrograma" id="codPrograma">
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">Nombre Sub Programa *</label>
                                                                <input type="text" name="nomSubpro" id="nomSubpro" class="form-control" title="Ingrese nombre del Subprograma" required="required">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">Nombre de Comercial *</label>
                                                                <input type="text" name="nomSubComer" id="nomSubComer" class="form-control">
                                                            </div>
                                                        </div>
                                                        <!--<div class="row">
                                                            <div class="col-6">
                                                                <label for="usuCelular">N° Duración *</label>
                                                                <input type="number" name="numSubdura" id="numSubdura" min="1" class="form-control" title="Ingrese N° plazas"  required="required">
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="usuCelular">N° Plazas *</label>
                                                                <input type="number" name="numSubPlaza" id="numSubPlaza"  min="1" class="form-control" title="Ingrese N° de asociados" required="required">
                                                            </div>
                                                        </div>-->
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">Descripcion *</label><br>
                                                                <textarea name="desSubProgra" id="desSubProgra"  class="form-control"></textarea>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        
                                                        <span class="btn btn-danger btn-lg text-white" onclick="Cancelar('frmSubPrograma');"  id="btnArea">Cancelar</span>
                                                        <button class="btn btn-success btn-lg text-white" onclick="validarSubPrograma();"  id="btnCancelar">Guardar</button>
                                                    </form>
                                                    <div id="divEditarSub">
                                                        
                                                    </div>
                                                    
                                                </div>
                                                <div class="col-1"><br></div>
                                                <div class="col-8">
                                                    <h4 class="card-title">Lista Sub Programas</h4>
                                                    <hr>
                                                    <div class="table-responsive">
                                                        <table id="tablaUsuarios" class="table  table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>N°</th>
                                                                    <th>PROGRAMA</th>
                                                                    <th>SUBPROGRAMA</th>
                                                                    <th>FECHA INICIO</th>
                                                                    <th>MONEDA</th>
                                                                    <th>N° PLAZO</th>
                                                                    <th>N° ASOCIADOS</th>
                                                                    <th>NOMBRE COMERCIAL</th>
                                                                    <th>DESCRIPCION</th>
                                                                    <th>OPCIONES</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="listaSubPrograma">
                                                                
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
     var url = $(location).attr('href');
     var res = url.split("=");
     //alert(res[1]);
     $("#codPrograma").val(res[1]);
    listarSubPrograma(res[1]);
} 
function valPagoConfig(){
    $("#frmConfigPago").validate({
        submitHandler: function(form) {
            guardarConfigPago();
        }
    }); 
}
function guardarConfigPago(){
    var codPro = $("#paCodSubProgra").val();
    var tipRec = $("#tipRecaudo").val();
    var impMon = $("#monto").val();
    var aplInd = $("#indicador").val();
    var parCob = $("#parametroCobro").val();
    var metApl = $("#aplica").val();
    var param = 'codPro='+codPro+'&tipRec='+tipRec+'&impMon='+impMon+'&aplInd='+aplInd+'&parCob='+parCob+'&metApl='+metApl+'&otro=1';
    //alert(param);
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=guardarConfigPago',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
           var mensaje = resultado.split("-");
           var codMsj = mensaje[0];
           var desMsj = mensaje[1];
           msjFinal(codMsj, desMsj);
        }, complete: function () {
            //$("#frmConfigPago").reset();
             $("#frmConfigPago")[0].reset();
            listarConfigPago(codPro,1);//0: listado para segun programa
        }
    });
    
}
function modalConfigPago(codPro){
    $("#modalConfigPago").modal('show');
    $("#paCodSubProgra").val(codPro);
    listarTipoRecaudo();
    listarIndicador();
    listarParamCobro();
    listarAplica();
    listarConfigPago(codPro,1);//0: listado para segun programa
}
function listarConfigPago(codigo,indicador){
    var param = 'codigo='+codigo+'&indicador='+indicador;
    //alert('listar: '+param);
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarConfigPago',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#listaConfigPago").html(resultado);
        }, complete: function () {
        }
    });
}

function listarAplica(){
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarAplica',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#aplica").html(resultado);
        }, complete: function () {
        }
    });
}
function listarParamCobro(){
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarParamCobro',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#parametroCobro").html(resultado);
        }, complete: function () {
        }
    });
}

function listarTipoRecaudo(){
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarTipoRecaudo',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#tipRecaudo").html(resultado);
        }, complete: function () {
        }
    });
}

function listarIndicador(){
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarIndicador',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#indicador").html(resultado);
        }, complete: function () {
        }
    });
}

function deleteConfigPago(codPag,codPro){
    
    var param = 'codPag='+codPag;
    //alert('codPag='+codPag+'codPro: ;'+codPro);
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=deleteConfigPago',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
            mensajeAlerta(resultado);           
        }, complete: function () {
            listarConfigPago(codPro,1);
        }
    });
}

function deleteSubPrograma(codPro){
    Swal.fire({
        title: 'Mensaje',
        text: "Esta seguro de borrar el Subprograma?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#48C28D',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Continuar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          confirBorrarSubPro(codPro);
        }
      })
}
function confirBorrarSubPro(codSubPro){
    var codPro= $("#codPrograma").val();
    var param = 'codSubPro='+codSubPro+'&codPro='+codPro;
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=confirBorrarSubPro',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
           var mensaje = resultado.split("-");
           var codMsj = mensaje[0];
           var desMsj = mensaje[1];
           msjFinal(codMsj, desMsj);
           
        }, complete: function () {
            listarSubPrograma(codPro);
        }
    });
}


function validarSubPrograma(){
     $("#frmSubPrograma").validate({
        submitHandler: function(form) {
            guardarSubPrograma();
            limpiarFormulario("frmSubPrograma");
        }
    }); 
 
}
function validarModSubPrograma(){
         $("#frmEdiSubProgra").validate({
        submitHandler: function(form) {
            guardarModSubPrograma();
            ocultar("frmEdiSubProgra");
        }
    });
}
function guardarModSubPrograma(){
    var codProgra = $("#codPrograma").val();
    var codSubPro = $("#codSubProEdi").val();
    var nomSubPro = $("#nomSubproEdi").val();
    var nomSubCom = $("#nomSubComerEdi").val();
    var numSubDur = $("#numSubduraEdi").val();
    var numSubPla = $("#numSubPlazaEdi").val();
    var desSubPro = $("#desSubPrograEdi").val();
    var param = 'codProgra='+codProgra+'&codSubPro='+codSubPro+'&nomSubPro='+nomSubPro+'&nomSubCom='+nomSubCom+'&numSubDur='+numSubDur+'&numSubPla='+numSubPla+'&desSubPro='+desSubPro;
    //alert(param);
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=guardarModSubPrograma',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
           var mensaje = resultado.split("-");
           var codMsj = mensaje[0];
           var desMsj = mensaje[1];
           msjFinal(codMsj, desMsj); 
           //mensajeAlerta(resultado);  
        }, complete: function () {
            listarSubPrograma(codProgra);
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}

function listaEditarSubPrograma(codSub){
    //alert("codSub:"+codSub);
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listaEditarSubPrograma',
        data: 'codSub='+codSub,
        beforeSend: function () {
        }, success: function (resultado) {
           $("#divEditarSub").html(resultado);
        }, complete: function () {
             $("#frmEdiSubProgra").removeClass('hide');
             $("#frmSubPrograma").addClass('hide');
        }
    });
}

function guardarSubPrograma(){
    var codProgra = $("#codPrograma").val();
    var nomSubPro = $("#nomSubpro").val();
    var nomSubCom = $("#nomSubComer").val();
    var numSubDur = $("#numSubdura").val();
    var numSubPla = $("#numSubPlaza").val();
    var desSubPro = $("#desSubProgra").val();
    var param = 'codProgra='+codProgra+'&nomSubPro='+nomSubPro+'&nomSubCom='+nomSubCom+'&numSubDur='+numSubDur+'&numSubPla='+numSubPla+'&desSubPro='+desSubPro;
    //alert(param);
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=guardarSubPrograma',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
           var mensaje = resultado.split("-");
           var codMsj = mensaje[0];
           var desMsj = mensaje[1];
           msjFinal(codMsj, desMsj);  
        }, complete: function () {
            listarSubPrograma(codProgra);
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}

function listarSubPrograma(cod){
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarSubPrograma',
        data: 'codSubProgra='+cod,
        
        beforeSend: function () {
        }, success: function (resultado) {
           $("#listaSubPrograma").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}

function habilitaAgregar(){
    $('#frmSubPrograma').removeClass('hide');
    $('#frmEdiSubProgra').addClass('hide');
    listaMoneda();
    listarObjetoProg();
    //$('#btnAddPro').addClass('hide');
}

function listaMoneda(){
    $.ajax({
        type: 'POST',
        url: '../../../utilitariosServlet?Accion=listarMoneda',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#tipMoneda").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}
function listarObjetoProg(){
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarObjetoProg',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#optObjetoProg").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}
function verSubprograma(cod){
    alert(cod);

}

function deletePrograma(cod){
    alert(cod);

}
/****************************************
 *       Basic Table                   *
 ****************************************/

</script>

</html>