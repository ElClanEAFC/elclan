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
                <div class="row">
                    
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="col-md-12 badge bg-danger cabecera">
                                    <div class="row">
                                        <div class="col-10"></div>
                                        <div class="col-2">
                                            <ul>
                                                <!--<li><a href="usuarios.jsp" onclick="crearUsuario();" title="Listar Usuarios"><i class="fas fa-arrow-alt-circle-left"></i></a></li>-->
                                                <li><a href="#" onclick="crearUsuario();" title="Agregar Usuarios"><i class="fas fa-plus-circle"></i></a></li>
                                                
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <!-- contenido -->
                                    <div class="card">
                                        <div class="card-body">
                                            <!------formulario--->
                                            
                                                <!-- ============================================================== -->
                                                <!-- Start Page Content -->
                                                <!-- ============================================================== -->
                                                <div id="mensaje"></div>
                                                <div class="card">
                                                    <div class="card-body wizard-content">
                                                        <div id="result"></div>
                                                        <!--- campo del formulario de registro de personas-->
                                                        <h3 class="card-title">Registro de personas</h3>
                                                        <hr>
                                                        <h6 class="card-subtitle"></h6>
                                                        <form id="example-form" action="#" class="mt-5">
                                                          <div>
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
                                                                            <input id="usuNumDoc" name="usuNumDoc" type="text" class="required form-control" onkeypress="return soloNumeros(event);" onchange="buscarDOI(this.value);"requerid> 
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
                                                          </div>
                                                           <hr>
                                                            <div class="footer">
                                                                <button class="btn btn-danger btn-lg text-white" onclick="limpiarCampo();">Cancelar</button>
                                                                <button class="btn btn-success btn-lg text-white" onclick="validarCamposUsu();" disabled="disabled" id="btnUsuarios">Guardar</button>
                                                                <!--<input class="submit" type="submit" value="SUBMIT">-->
                                                            </div>
                                                        </form>
                                                        <!--- fin del registro de personas-->
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
    segundaCarga();
    function segundaCarga(){
        var param = $("#param").val();
        var param1 = $("#param1").val();
        //alert(param1);
        if(param != "null" && param1 != "null"){
            editarUsuario(param1,param);
        }else{
            
           
        } 
        cargarTipoDoc();
        cargarAreas();
        listarPais();
        listarDpto(); 
    }
    /*
    function buscarDOI(){
        var usuNumDoc = $('#usuNumDoc').val();
        $.ajax({
            type: 'POST',
            url: '../../../usuariosServlet?Accion=listarJson',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#crearUsu").html(resultado);
            }, complete: function () {
            }
        });
    }*/
 
    function buscarDOI(){
        var usuNumDoc = $('#usuNumDoc').val();
        var usuTDoc   = $('#usuTDoc option:selected').val();
        $.ajax({
            type: 'POST',
            url: '../../../asociadosServlet?Accion=buscarDOI',
            data: 'usuTDoc='+usuTDoc+'&usuNumDoc='+usuNumDoc,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#result").html(resultado);
            }, complete: function () {
                var val = $("#valDNI").val();
                //alert(ini);
                if(val =="1"){
                    var datos = $("#valDatos").val();
                    var codPer = $("#valCodUsu").val();
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
                    denyButtonText: 'registrar contrato',
                    denyButtonColor: '#48C28D',
                  }).then((result) => {

                    if (result.isConfirmed) {
                        
                      editarUsuario(codUser,usuNumDoc);
                    } else if (result.isDenied) {
                      registarContrato(codUser);
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
    
    function registarContrato(codUser){
        alert("Nuevo: "+codUser);
    }

    function editarUsuario(codUser,dni){

        //alert("dni: "+dni)
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=editarUsu',
            data: 'codUsuario='+codUser,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#result").html(resultado);
                $("input").removeAttr('disabled');
                $("select").removeAttr('disabled');
                $("button").removeAttr('disabled');
                $("#usuArea").attr('disabled',true);
                $("#usuCargo").attr('disabled',true);
                $("#usuFinicio").attr('disabled',true);
                $("#usuArea").attr('disabled',true);
                //alert(resultado);
            }, complete: function () {
                var nombre 	= $("#edNombre").val();
                var apaterno 	= $("#edApaterno").val();
                var aMaterno 	= $("#edAmaterno").val();
                var celular 	= $("#edCelular").val();
                var correo 	= $("#edCorreo").val();
                var direccion 	= $("#edDireccion").val();
                var codPais 	= $("#edCodPais").val();
                var desPais 	= $("#edDesPais").val();
                var codDpto 	= $("#edCodDpto").val();
                var desDpto 	= $("#edDesDpto").val();
                var codProv 	= $("#edCodProv").val();
                var desProv 	= $("#edDesProv").val();
                var codDist 	= $("#edCodDist").val();
                var desDist 	= $("#edDesDist").val();
                var fnacimiento = $("#edFNacimiento").val();
                
                $("#usuNumDoc").val(dni);
                $("#usuNombre").val(nombre);
                $("#usuApaterno").val(apaterno);
                $("#usuAmaterno").val(aMaterno);
                $("#usuCelular").val(celular);
                $("#usuCorreo").val(correo);
                $("#usuDireccion").val(direccion);
                $("#usuPais").prepend("<option value='"+codPais+"' selected='selected'>"+desPais+"</option>");
                $("#usuDpto").prepend("<option value='"+codDpto+"' selected='selected'>"+desDpto+"</option>");
                $("#usuProv").prepend("<option value='"+codProv+"' selected='selected'>"+desProv+"</option>");
                $("#usuDist").prepend("<option value='"+codDist+"' selected='selected'>"+desDist+"</option>");
                $("#usuFinicio").val();
                $("#usuFNacimiento").val(fnacimiento);
                
                $("#btnUsuarios").attr("onclick","modificarUser()");
                $("#btnUsuarios").html('Modificar');
                $("#usuNumDoc").attr("readonly", true);
            }
        });
    }
    
    function modificarUser(){
        //var codigoUsuario = "
        //alert('mod:');
        var usuNumDoc       = $("#usuNumDoc").val();
        var usuNombre       = $("#usuNombre").val();
        var usuApaterno     = $("#usuApaterno").val();
        var usuAmaterno     = $("#usuAmaterno").val();
        var usuCelular      = $("#usuCelular").val();
        var usuCorreo       = $("#usuCorreo").val();
        var usuDireccion    = $("#usuDireccion").val();
        var usuPais         = $("#usuPais").val();
        var usuDpto         = $("#usuDpto").val();
        var usuProv         = $("#usuProv").val();
        var usuDist         = $("#usuDist").val();
        //var usuArea         = $("#usuArea").val();
        //var usuCargo        = $("#usuCargo").val();
        //var usuFinicio      = $("#usuFinicio").val();
        var usuFNacimiento  = $("#usuFNacimiento").val();
        var usuCodUser       = $("#edCodUser").val();
        
        
        var param = 'usuCodUser='+usuCodUser+'&usuNumDoc='+usuNumDoc+'&usuNombre='+usuNombre+'&usuApaterno='+usuApaterno+'&usuAmaterno='+usuAmaterno+'&usuCelular='+usuCelular+'&usuCorreo='+usuCorreo+
                    '&usuDireccion='+usuDireccion+'&usuPais='+usuPais+'&usuDpto='+usuDpto+'&usuProv='+usuProv+'&usuDist='+usuDist+'&usuFNacimiento='+usuFNacimiento;
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=modificarUser',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#result").html(resultado);
                //alert(resultado);
            }, complete: function () {
            }
        });
    }
    
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
    function listarPerfil(){
        var codArea = $("#usuArea").val();
        //alert(codArea);
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarPerfil',
            data: 'codArea='+codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuCargo").html(resultado);
            }, complete: function () {
            }
        });
    }
    
    function cargarAreas(){
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listaAreas',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuArea").html(resultado);
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
    }
 
    function limpiarCampo(){
        $("#formRegistroPreVenta")[0].reset();
        $("input").addAttr('disabled');
        $("select").addAttr('disabled');
        $("button").addAttr('disabled');
    }

 
    function crearUsuario(){
        var usuTDoc         = $("#usuTDoc").val();
        var usuNumDoc       = $("#usuNumDoc").val();
        var usuNombre       = $("#usuNombre").val();
        var usuApaterno     = $("#usuApaterno").val();
        var usuAmaterno     = $("#usuAmaterno").val();
        var usuCelular      = $("#usuCelular").val();
        var usuCorreo       = $("#usuCorreo").val();
        var usuDireccion    = $("#usuDireccion").val();
        var usuPais         = $("#usuPais").val();
        var usuDpto         = $("#usuDpto").val();
        var usuProv         = $("#usuProv").val();
        var usuDist         = $("#usuDist").val();
        var usuArea         = $("#usuArea").val();
        var usuCargo        = $("#usuCargo").val();
        var usuFinicio      = $("#usuFinicio").val();
        var usuFNacimiento  = $("#usuFNacimiento").val();
        var param = 'usuTDoc='+usuTDoc+'&usuNumDoc='+usuNumDoc+'&usuNombre='+usuNombre+'&usuApaterno='+usuApaterno+'&usuAmaterno='+usuAmaterno+'&usuCelular='+usuCelular+
                    '&usuCorreo='+usuCorreo+'&usuDireccion='+usuDireccion+'&usuPais='+usuPais+'&usuDpto='+usuDpto+'&usuProv='+usuProv+'&usuDist='+usuDist+'&usuArea='+usuArea+
                    '&usuCargo='+usuCargo+'&usuFinicio='+usuFinicio+'&usuFNacimiento='+usuFNacimiento;
        
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=crearUsuario',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#mensaje").html(resultado);
            }, complete: function () {
            }
        });
        
        
        /*
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=crearUsuario',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                alert(resultado);
            }, complete: function () {
               var msj = "Se guardo correctamente el usuario";
               var color = "#4FAF4F";
               var icono = "success";
               msjAlerta(msj,icono,color);
            }
        });*/

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
  
</script>

</html>