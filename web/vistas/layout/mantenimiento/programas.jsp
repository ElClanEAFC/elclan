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
<div class='modal fade' id='modalConfigPago' tabindex='-1' role='dialog'>
    <div class='modal-dialog modal-xl'  role='document'>
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title'><i class="fas fa-tags"></i>Configuracion de Pago del Programa</h4>
                <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                    <span aria-hidden='true'>&times;</span>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <form id="frmConfigPago" method="post">
                        <div class="row">
                            <input type="hidden" name="paCodPrograma" id="paCodPrograma">
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
                                                    <button class="btn btn-success btn-lg text-white" onclick="habilitaAgregar();" id="btnAddPro"><i class="fas fa-plus"></i> Crear Nuevo Programa</button>
                                                    <hr>
                                                    <form class="frmPrograma hide" id="frmPrograma" >
                                                        <input type="hidden" name="codPrograma" id="codArea">
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">Nombre de Programa *</label>
                                                                <input type="text" name="nomPrograma" id="nomPrograma" class="form-control" title="Ingrese Programa" required>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">Nombre de Comercial *</label>
                                                                <input type="text" name="nomComercial" id="nomComercial" class="form-control" title='Ingrese Nombre Comercial' required>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-12">
                                                                <label for="usuCelular">N° Resolución *</label>
                                                                <input type="text" name="numResol" id="numResol" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="usuCelular">N° Plazas *</label>
                                                                <input type="number" name="numPlazas" id="numPlazas" class="form-control" title='Ingrese N° de Plazas' min="1" required>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="usuCelular">N° Asociados *</label>
                                                                <input type="number" name="numAsociados" id="numAsociados" class="form-control" min="1" title='Ingrese N° de Asociados' required>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <label for="usuCelular">Tipo moneda *</label>
                                                                <select class="form-control" name="tipMoneda" id="tipMoneda" title="Seleccione tipo de moneda" required>
                                                                    <option></option>
                                                                </select>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="usuCelular">Objeto del Programa *</label>
                                                                <select class="form-control" name="objetoProg" id="objetoProg" title="Seleccione objeto del programa" required>
                                                                    <option></option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        
                                                        <span class="btn btn-danger btn-lg text-white" onclick="Cancelar('frmPrograma');"  id="btnArea">Cancelar</span>
                                                        <button class="btn btn-success btn-lg text-white"   id="btnCancelar">Guardar</button>
                                                    </form>
                                                    <div id="frmEditPro"></div>
                                                </div>
                                                
                                                <div class="col-9">
                                                    <h4 class="card-title">Lista Programas</h4>
                                                    <hr>
                                                    <div class="table-responsive">
                                                        <table id="tablaUsuarios" class="table  table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>N°</th>
                                                                    <th>PROGRAMA</th>
                                                                    <th>F. INICIO</th>
                                                                    <th>MONEDA</th>
                                                                    <th>N° PLAZO</th>
                                                                    <th>N° ASOCIADOS</th>
                                                                    <th>N° RESOLUCIÓN</th>
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
    listarPrograma();
}  
function habilCrearSubPro(codPro){
    Swal.fire({
        title: 'Mensaje',
        text: "El Programa no tiene SubProgramal. Desea crear un subprograma?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cerrar',
        confirmButtonText: 'Crear Subprograma'
      }).then((result) => {
        if (result.isConfirmed) {
          window.location.href = "subprograma.jsp?codPro="+codPro;
        }
      }) 
}
function guardarConfigPago(){
    var codPro = $("#paCodPrograma").val();
    var tipRec = $("#tipRecaudo").val();
    var impMon = $("#monto").val();
    var aplInd = $("#indicador").val();
    var parCob = $("#parametroCobro").val();
    var metApl = $("#aplica").val();
    var param = 'codPro='+codPro+'&tipRec='+tipRec+'&impMon='+impMon+'&aplInd='+aplInd+'&parCob='+parCob+'&metApl='+metApl+'&otro=0';
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
            listarConfigPago(codPro,0);//0: listado para segun programa
        }
    });
    
}
function valPagoConfig(){
    $("#frmConfigPago").validate({
        submitHandler: function(form) {
            guardarConfigPago();
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
            listarConfigPago(codPro,0);
        }
    });
}

function modalConfigPago(codPro){
    $("#modalConfigPago").modal('show');
    $("#paCodPrograma").val(codPro);
    listarTipoRecaudo();
    listarIndicador();
    listarParamCobro();
    listarAplica();
    listarConfigPago(codPro,0);//0: listado para segun programa
}
function listarConfigPago(codigo,indicador){
    var param = 'codigo='+codigo+'&indicador='+indicador;
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
function valActualizarPro(){
    Swal.fire({
        title: 'Mensaje',
        text: "Esta seguro de borrar el programa?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#48C28D',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Continuar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          confirBorrarPro(codPro);
        }
      })
}
function actualizarPrograma(){
    var aCodPro = $("#aCodPrograma").val();
    var aNomPro = $("#aNomPrograma").val();
    var aNomCom = $("#aNomComercial").val();
    var aNunRes = $("#aNumResol").val();
    var aNunPla = $("#aNumPlazas").val();
    var aNunAso = $("#aNumAsociados").val();
    var aTipMon = $("#aTipMoneda").val();
    var aObjPro = $("#aObjetoProg").val();
    //alert("Actualizar");
    var param = 'aCodPro='+aCodPro+'&aNomPro='+aNomPro+'&aNomCom='+aNomCom+'&aNunRes='+aNunRes+'&aNunPla='+aNunPla+'&aNunAso='+aNunAso+'&aTipMon='+aTipMon+'&aObjPro='+aObjPro;
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=actualizarPrograma',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
           
        }, complete: function () {
           //$("#frmPrograma").addClass("hide");
        }
    });
}

function listaEditarPrograma(codPro){
    var param = 'codPro='+codPro;
    $('#frmEditPro').removeClass('hide');
    $("#frmPrograma").addClass("hide");
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listaEditarPrograma',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
            
           $("#frmEditPro").html(resultado);
        }, complete: function () {
           //$("#frmPrograma").addClass("hide");
        }
    });
}

function guardarPrograma(){
    $("#frmPrograma").validate({
        submitHandler: function(form) {
            crearPrograma();
        }
    });
   
}
function crearPrograma(){
    alert("Guardar");
    var nomPro = $("#nomPrograma").val();
    var nomCom = $("#nomComercial").val();
    var numRes = $("#numResol").val();
    var numPla = $("#numPlazas").val();
    var numAso = $("#numAsociados").val();
    var tipMon = $("#tipMoneda").val();
    var objPro = $("#objetoProg").val();
    var param = 'nomPro='+nomPro+'&nomCom='+nomCom+'&numRes='+numRes+'&numPla='+numPla+'&numAso='+numAso+'&tipMon='+tipMon+'&objPro='+objPro;
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=guardarPrograma',
        data: param,
        beforeSend: function () {
        }, success: function (resultado) {
        }, complete: function () {
            listarPrograma();
            $("#frmPrograma")[0].reset();
        }
    });
}

function listarPrograma(){
   // alert("llega");
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=listarPrograma',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#listaPrograma").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}
function habilitaAgregar(){
    $('#frmPrograma').removeClass('hide');
    $('#frmEditPro').addClass('hide');
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
           $("#objetoProg").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}
function verSubprograma(cod){
    alert(cod);

}

function borrarPrograma(codPro){
    Swal.fire({
        title: 'Mensaje',
        text: "Esta seguro de borrar el programa?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#48C28D',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Continuar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          confirBorrarPro(codPro);
        }
      })
}
function confirBorrarPro(codPro){
    //alert(codPro);
    var codPrograma = 'codPro='+codPro;
    $.ajax({
        type: 'POST',
        url: '../../../mantenimientoServlet?Accion=confirBorrarPro',
        data: codPrograma,
        beforeSend: function () {
        }, success: function (resultado) {
           listarPrograma();
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}
/****************************************
 *       Basic Table                   *
 ****************************************/

</script>

</html>