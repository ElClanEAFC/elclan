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
<%
    String param = request.getParameter("param"); 
    String param1 = request.getParameter("param1"); 
%>
<input type="hidden" name="param" id="param" value="<%= param%>">
<input type="hidden" name="param1" id="param1" value="<%= param1%>">
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
       
        
        <%@include file="../includes/menu-superior.jsp"%>
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
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="card">
                  <div class="card-body wizard-content">
                    <h4 class="card-title">Registro de personas & asociados</h4>
                    <h6 class="card-subtitle"></h6>
                    <form id="frmAsociados" action="#" class="mt-5">
                      <div>
                        <h3>Datos Personales</h3>
                        <section>
                            <div class="row">
                                <div class="col-3">
                                    <p>
                                        <label for="usuTDoc">Tipo de Documento *</label>
                                        <select id="usuTDoc" name="usuTDoc" class="required form-control" requerid>
                                            <option>1</option>
                                            <option>2</option>
                                        </select>
                                    </p>
                                </div>
                                <div class="col-3">
                                    <p>
                                        <label for="usuNumDoc">Nª Documento *</label>
                                        <input id="usuNumDoc" name="usuNumDoc" type="text" class="required form-control" onkeypress="return soloNumeros(event);" onchange="buscarDOI(this.value);" value="45645645" required="required"> 
                                    </p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <p>
                                        <label for="usuNombre">Nombre / Razon social *</label>
                                        <input id="usuNombre" name="usuNombre" type="text" class="required form-control" onchange='conMayusculas(this);' requerid disabled> 
                                    </p>
                                </div>
                                <div class="col-4">
                                    <p>
                                        <label for="usuApaterno">Apellido Paterno *</label>
                                        <input id="usuApaterno" name="usuApaterno" type="text" class="required form-control" onchange='conMayusculas(this);' requerid disabled>  
                                    </p>        
                                </div>
                                <div class="col-4">
                                    <p>
                                        <label for="usuAmaterno">Apellido Materno *</label>
                                        <input id="usuAmaterno" name="usuAmaterno" type="text" class="required form-control" onchange='conMayusculas(this);' requerid disabled>   
                                    </p>    
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <p>
                                       <label for="usuCelular">Celular *</label>
                                       <input id="usuCelular" name="usuCelular" type="text" class="required form-control" onchange='conMayusculas(this);' requerid disabled>  
                                    </p>
                                </div>
                                <div class="col-4">
                                    <p>
                                       <label for="usuCorreo">Correo *</label>
                                       <input id="usuCorreo" name="usuCorreo" type="email" class="required form-control" onchange='conMayusculas(this);' requerid disabled> 
                                    </p>        
                                </div>
                                <div class="col-4">
                                    <p>
                                       <label for="usuDireccion">Direccion *</label>
                                       <input id="usuDireccion" name="usuDireccion" type="text" class="required form-control" onchange='conMayusculas(this);' requerid disabled>  
                                    </p>       
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-3">
                                    <p>
                                        <label for="usuPais">Pais *</label>
                                        <select name="usuPais" id="usuPais" class="required form-control" requerid disabled>

                                        </select> 
                                    </p>
                                </div>
                                <div class="col-3">
                                    <p>
                                       <label for="usuDpto">Departamento</label>
                                       <select name="usuDpto" id="usuDpto" class="required form-control" onchange="listarProv();" requerid disabled>

                                       </select>  
                                    </p>
                                </div>
                                <div class="col-3">
                                    <p>
                                        <label for="usuProv">Provincia</label>
                                        <select name="usuProv" id="usuProv" class="required form-control" onchange="listarDist();" requerid disabled>

                                        </select>
                                    </p>
                                </div>
                                <div class="col-3">
                                    <p>
                                        <label for="usuDist">Distrito</label>
                                        <select name="usuDist" id="usuDist" class="required form-control" requerid disabled>

                                        </select>
                                    </p>
                                </div>
                            </div>
                        </section>
                        <h3>Reservar Contrato</h3>
                        <section>
                            <div class="row">
                                <div class="col-3">
                                    <p>
                                        <label for="usuTDoc">Programa *</label>
                                        <select id="conPrograma" name="conPrograma" class="required form-control" requerid>
                                            <option>MGA</option>
                                        </select>
                                    </p>
                                </div>
                                <div class="col-3">
                                    <p>
                                        <label for="usuNumDoc">Grupo *</label>
                                        <select id="conGrupo" name="conGrupo" class="required form-control" requerid>
                                            <option>2005</option>
                                        </select>
                                    </p>
                                </div>
                                <div class="col-3">
                                    <p>
                                        <label for="usuNumDoc">Cupo *</label>
                                        <input id="conCupo" name="conCupo" type="text" class="required form-control" readonly="readonly"  requerid> 
                                    </p>
                                </div>
                                <div class="col-3">
                                    <p>
                                        <label for="usuNumDoc">Nª Folio *</label>
                                        <input id="conNumFolio" name="conNumFolio" type="text" class="required form-control" requerid> 
                                    </p>
                                </div>
                            </div>
                        </section>
                        <h3>Datos Adicionales</h3>
                        <section>
                          
                        </section>
                        <h3>Confirmar</h3>
                        <section>
                          
                        </section>
                      </div>
                    </form>
                  </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Right sidebar -->
                <!-- ============================================================== -->
                <!-- .right-sidebar -->
                <!-- ============================================================== -->
                <!-- End Right sidebar -->
                <!-- ============================================================== -->
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
    segundaCarga();
    function segundaCarga(){ 
        cargarTipoDoc();
        listarPais();
        listarDpto(); 
        manejoTabs("frmAsociados");
    }
    
    function buscarDOI(){
        var numDoc = $('#usuNumDoc').val();
        var tipDoc = $('#usuTDoc').val();
        $.ajax({
            type: 'POST',
            url: '../../../apiServlet?Accion=validarDNI',
            data: 'tipDoc='+tipDoc+'&numDoc='+numDoc,
            beforeSend: function () {
            }, success: function (resultado) {
                if(tipDoc=="1"){
                    $("#usuNombre").val(resultado.split(',')[0]);
                    $("#usuApaterno").val(resultado.split(',')[1]);
                    $("#usuAmaterno").val(resultado.split(',')[2]);    
                }else if(tipDoc=="2")
                {
                    $("#usuNombre").val(resultado);
                    $("#usuApaterno").val('');
                    $("#usuAmaterno").val(''); 
                }
                
            }, complete: function () {
            }
        });
    }
 /*
    function buscarDOI(){
        var usuNumDoc = $('#usuNumDoc').val();
        var usuTDoc   = $('#usuTDoc option:selected').val();
        alert("valida DNI");
        $.ajax({
            type: 'POST',
            url: '../../../apiServlet?Accion=validarDNI',
            data: 'usuTDoc='+usuTDoc+'&usuNumDoc='+usuNumDoc,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#result").html(resultado);
            }, complete: function () {
                var val = $("#valDNI").val();
                //alert(ini);
                if(val =="1"){
                    var datos = $("#valDatos").val();
                    var codUser = $("#valCodUsu").val();
                    Swal.fire({
                    title: 'Mensaje',
                    html:
                          'El numero de documento ya se encuetra registrado: <br>' +
                          '<b>'+datos+'</b>',
                    showDenyButton: true,
                    showCancelButton: true,
                    confirmButtonText: 'Editar Datos',
                    confirmButtonColor: '#2255A4',
                    cancelButtonColor: '#E06E4D',
                    denyButtonText: 'registrar nuevo periodo',
                    denyButtonColor: '#48C28D',
                  }).then((result) => {

                    if (result.isConfirmed) {
                        
                      editarUsuario(codUser,usuNumDoc);
                    } else if (result.isDenied) {
                      asignarNuevoPeriodo(codUser);
                    }else if (result.dismiss == 'cancel'){
                        limpiarCampo();
                    }
                  })
                  limpiarCampo();
                  $("input").addAttr('disabled');
                  $("select").addAttr('disabled');
                  $("button").addAttr('disabled');
                }else{
                    $("input").removeAttr('disabled');
                    $("select").removeAttr('disabled');
                    $("button").removeAttr('disabled');
                }
            }
        });
    }

    */
    function listarDist(){
        var codDpto = $("#usuDpto").val();
        var codProv = $("#usuProv").val();
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listarDist',
            data: 'codDpto='+codDpto+'&codProv='+codProv,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuDist").html(resultado);
            }, complete: function () {
            }
        });
    }
    
    function listarProv(){
        var codDpto = $("#usuDpto").val();
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listarProv',
            data: 'codDpto='+codDpto,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuProv").html(resultado);
            }, complete: function () {
            }
        });
    }
    
    function listarDpto(){
        
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listarDpto',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuDpto").html(resultado);
            }, complete: function () {
            }
        });
    }
    function listarPais(){
        
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listarPais',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuPais").html(resultado);
            }, complete: function () {
            }
        });
    }

    function cargarTipoDoc(){
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listaTipoDocumento',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuTDoc").html(resultado);
            }, complete: function () {
            }
        });    
    }
    /*
    function validarCamposUsu(){
        var validator = $("#formRegistroPreVenta").validate({
            rules: {
                usuNumDoc: { required: true},
                usuNombre: { required:true},
                usuApaterno: { required: true},
                usuAmaterno: { required:true},
                usuCelular: { required:true},
                usuCorreo: { required: true},
                usuDireccion: { required:true},
                usuPais: { required: true},
                usuDpto: { required:true},
                usuProv: { required:true},
                usuDist: { required: true},
                usuArea: { required:true},
                usuCargo: { required: true},
                usuFinicio: { required:true}
	    },
	    messages: {
                usuNumDoc: "El numero documento obligatorio.",
                usuNombre : "Ingrese el nombre.",
                usuApaterno : "Ingrese apellido paterno.",
                usuAmaterno : "Ingrese apellido materno",
                usuCelular : "Ingrese N° celular.",
                usuCorreo: "Ingrese Correo",
                usuDireccion: "Ingrese Direccion",
                usuPais: "Seleccione Pais",
                usuDpto: "Seleccione Departamento",
                usuProv: "Seleccione Provencia",
                usuDist: "Seleccione Distrito",
                usuArea: "Seleccione Area",
                usuCargo: "Seleccione Cargo",
                usuFinicio: "Ingrese Fecha inicio"
	    } 
        });  
        var estado = validator.form();
        if (estado) {
            crearUsuario();
        }
    }*/
 
    function limpiarCampo(){
        $("#formRegistroPreVenta")[0].reset();
        $("input").addAttr('disabled');
        $("select").addAttr('disabled');
        $("button").addAttr('disabled');
    }

    function agregarUsuario(){
        $('#modalAgregarUsuario').modal('show')

    }
    /****************************************
     *       Basic Table                   *
     ****************************************/
    $('#tablaUsuarios').DataTable();
    
    function conMayusculas(field) {
        field.value = field.value.toUpperCase()
    }
    
    function soloNumeros(e) {
        var charCode = (e.which) ? e.which : e.keyCode
        if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;
        return true;
    }

    function soloLetras(e) {
        var charCode = (e.which) ? e.which : e.keyCode
        if (charCode == 32) {
            return true;
        } else {
            if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122))
                return false;
            return true;
        }
    }
 
 
     // Basic Example with form
    var form = $("#frmAsociados");
    form.validate({
      errorPlacement: function errorPlacement(error, element) {
        element.before(error);
      },
      rules: {
        confirm: {
          equalTo: "#password",
        },
      },
    });
    form.children("div").steps({
      headerTag: "h3",
      bodyTag: "section",
      idTag:"tabcon",
      transitionEffect: "Siguiente",
      onStepChanging: function (event, currentIndex, newIndex) {
        form.validate().settings.ignore = ":disabled,:hidden";
        return form.valid();
      },
      onFinishing: function (event, currentIndex) {
        form.validate().settings.ignore = ":disabled";
        return form.valid();
      },
      onFinished: function (event, currentIndex) {
      },
    });
 
 
    










 
 function funcionClic(){
     
 }
</script>

</html>