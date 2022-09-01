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
<div id="modal"></div>
<div id="resultado"></div>
<!--========================MODAL DE CESE DEL USUARIO=========================-->
<div class='modal fade' id='ceseUsuario' tabindex='-1' role='dialog'>
    <div class='modal-dialog'  role='document'>
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title'><i class="fas fa-tags"></i>Registrar datos del Cese</h4>
                <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                    <span aria-hidden='true'>&times;</span>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <div class="row">
                        <form>
                            <input type="hidden" name="usuAMod" id="usuAMod">
                            <div class="col-md-10 centrar">
                                <p>
                                    <label>Seleccione Motivo Cese</label>
                                    <select class="form-control" id="motCese">

                                    </select>
                                </p>
                            </div>
                            <div class="col-md-10 centrar">
                                <p>
                                   <label>Fecha Cese</label>
                                   <input type="date" name="fecCese" id="fecCese" class="form-control">
                                </p>
                            </div>   
                        </form>

                    </div>
                </div> 
            </div>
            <div class='modal-footer'>
                <button type='button' onclick='darBajaUsuario();' class='btn btn-primary btn-success'>Confirmar</button>
                <button type='button' onclick='cerrarModal("ceseUsuario");' class='btn btn-secondary btn-danger text-white' data-dismiss='modal'>Cerrar</button>
            </div>
        </div>
    </div>
</div>


<!-------------------MODAL CONFIRMAR CESE DEL USUARIO  ------------------------->
<div class='modal fade' id='confirCese' tabindex='-1' role='dialog'>
        <div class='modal-dialog'  role='document'>
            <div class='modal-content' >
                <div class='modal-header bg-danger'>
                    <h4 class='modal-title'><i class="fas fa-tags"></i>Confirmar Cese</h4>
                    <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                        <span aria-hidden='true'>&times;</span>
                    </button>
                </div>
                <div class='modal-body'>
                    <div class="container">
                        <div class="row">
                            <form>
                                <input type="hidden" name="usuAMod" id="usuAMod">
                                <div class="col-md-10 centrar">
                                    <p>
                                       <input type="text" name="usuConfir" id="usuConfir" class="form-control"> 
                                    </p>
                                </div>
                                <div class="col-md-10 centrar">
                                    <p>
                                       <input type="password" name="claConfir" id="claConfir" class="form-control" placeholder='Ingrese Contraseña'>
                                    </p>
                                </div>   
                            </form>
                            
                        </div>
                    </div> 
                </div>
                <div class='modal-footer'>
                    <button type='button' onclick="validarConfirmacion();" class='btn btn-primary btn-success'>Confirmar</button>
                    <button type='button' onclick='cerrarModal("confirCese");' class='btn btn-secondary btn-danger text-white' data-dismiss='modal'>Cerrar</button>
                </div>
            </div>
        </div>
    </div>

<!-----------------ASIGNAR ROL---------------------------------------->
    <div class='modal fade' id='asignarRol' tabindex='-1' role='dialog'>
        <div class='modal-dialog' style="max-width: 50%;" role='document'>
            <div class='modal-content' >
                <div class='modal-header bg-danger'>
                    <h4 class='modal-title'><i class="fas fa-tags"></i>Asignar usuario al cargo</h4>
                    <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                        <span aria-hidden='true'>&times;</span>
                    </button>
                </div>
                <div class='modal-body'>
                    <div class="container">
                        <div class="row"><p><br></p></div>
                        <div class="row">
                            <input type="hidden" id="codUsu" name='codUsu'>
                            <div class="col-5">
                                <label>Area</label>
                                <select name="seArea" id="seArea" onchange="listarPerfil('seRol','seArea');">
                                    <option></option>
                                </select>
                            </div>
                            <div class="col-5">
                                <label>Roles</label>
                                <select name="seRol" id="seRol">
                                </select>
                            </div>
                            <div class="col-2">
                                
                                <button type='button' onclick='guardarAsigCargo();' class='btn btn-primary btn-success'><i class="fas fa-check"></i>Agregar</button>
                            </div>
                        </div>
                        <p><br><hr><br></p>
                        <div class="row">
                            <div class="col-12">
                                <table id="rolesUsu"  class="table datatable-basic ui celled table responsive nowrap unstackable" width="100%" autocomplete="off">
                                    <thead>
                                        <tr>
                                            <th>N°</th>
                                            <th>Area</th>
                                            <th>Permisos</th>
                                            <th>F. Inicio</th>
                                            <th>F. Cese</th>
                                            <th>Motivo Cese</th>
                                            <th>Estado</th>
                                            <th>Opciones</th>               
                                        </tr>
                                    </thead>
                                    <tbody id="rolesUsutbody">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div> 
                </div>
                <div class='modal-footer'>
                    <!--<button type='button' onclick='' class='btn btn-primary btn-success'>Aceptar</button>-->
                    <button type='button' onclick='cerrarModal("asignarRol");' class='btn btn-secondary btn-danger text-white' data-dismiss='modal'>Cerrar</button>
                </div>
            </div>
        </div>
    </div>
<!-- FIN DE ASIGNAR ROL-->
<!--========================AGREGAR INFORMACION  ADICIONAL DEL USUARIO=========================-->
<div class='modal fade' id='addExperiencia' tabindex='-1' role='dialog'>
    <div class='modal-dialog'  role='document' style="max-width: 60%;">
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title'><i class="fas fa-tags"></i>Agregar Experiencias</h4>
                <button type='button' class='close' data-dismiss='modal' aria-label='Close'>
                    <span aria-hidden='true'>&times;</span>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <!--<form>-->
                        <!--<div class="row">
                            <input type="hidden" name="codUsuExp" id="codUsuExp">
                            <div class="col-md-5">
                                <p>
                                    <label>Profesion: </label>
                                    <select class="form-control" id="selectProfesion">
                                    </select>
                                </p>
                            </div>
                            <div class="col-md-5">
                                <br> 
                            </div>
                             
                        </div>-->
                        <input type="hidden" name="codUsuExp" id="codUsuExp">
                        <div class="row">
                            <div class="col-md-4">
                                <label>Puesto:</label>
                                <input type="" id="puesto" name="puesto" class="form-control">
                                <div id="suggestions" class="autocomplete"></div>
                            </div>  
                            <div class="col-md-1">
                                <p>
                                   <label>Tiempo</label>
                                   <input type="number" name="tiempo" id="tiempo" class="form-control">
                                </p>
                            </div>
                            <div class="col-md-2 centrar">
                                <p>
                                   <label></label>
                                   <select class="form-control" id="tipTiempo" name="tipTiempo" class="form-control">
                                       <option>Mes</option>
                                       <option>Año</option>
                                   </select>
                                </p>
                            </div>
                            <div class="col-md-3">
                                <label>Empresa:</label>
                                <input type="text" name="empresa" id="empresa" class="form-control">
                                <div id="resEmpresa" class="autocomplete"></div>
                            </div>
                            <div class="col-md-1 centrar">
                                <p>
                                    <button class="btn btn-primary btn-success" onclick="guardarExperiencia();"><i class="fas fa-check">Añadir</i></button>
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12"><br><hr><br></div>
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <div class="table-responsive">
                                    <table id="tablaExpreriencias"  class="table datatable-basic ui celled table responsive nowrap unstackable" width="100%" autocomplete="off">
                                        <thead>
                                            <tr>
                                                <th>N°</th>
                                                <th>Puesto laboral</th>
                                                <th>Tiempo Laboral </th>
                                                <th>Empresa</th>
                                                <th>Opciones</th>                  
                                            </tr>
                                        </thead>
                                        <!--<tbody id="listaUser">-->
                                        <tbody>

                                        </tbody>

                                    </table>
                                </div>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                    <!--</form>-->
                </div> 
            </div>
            <div class='modal-footer'>
                <!--<button type='button' onclick='darBajaUsuario();' class='btn btn-primary btn-success'>Confirmar</button>-->
                <button type='button' onclick='cerrarModal("addExperiencia");' class='btn btn-secondary btn-danger text-white' data-dismiss='modal'>Cerrar</button>
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
                                <div class="col-md-12 badge bg-danger cabecera">
                                    <div class="row">
                                        <div class="col-10"></div>
                                        <div class="col-2">
                                            <ul>
                                                <li><a href="#" onclick="crearPersona();" title="Agregar Persona"><i class="fas fa-plus-circle"></i></a></li>
                                                <li><a href="#" onclick="listarInactivos();" title="Ver Usuarios Inactivos"><i class="fas fa-folder-open"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <!-- contenido -->
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Lista de Personas & Asociados</h5>
                                            <div class="table-responsive">
                                                <table id="tablaUsuarios"  class="table datatable-basic ui celled table responsive nowrap unstackable" width="100%" autocomplete="off">
                                                    <thead>
                                                        <tr>
                                                            <th>Nombres</th>
                                                            <th>Apellido Paterno</th>
                                                            <th>Apellido Materno</th>
                                                            <th>Tipo Doc.</th>
                                                            <th>N° Documento</th>
                                                            <!-- <th>Fecha Inicio</th>-->
                                                            <th>N° Celular</th>
                                                            <th>Opciones</th>                  
                                                        </tr>
                                                    </thead>
                                                    <!--<tbody id="listaUser">-->
                                                    <tbody>
                                                        
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
function crearPersona(){
    window.location.href = "crearPersona.jsp";
}

    function segundaCarga(){
        listarUsuario('1');// lista de usuarios activos
    }
    
    function agregarExpe(codUsuario){
        $("#addExperiencia").modal('show');
        $("#codUsuExp").val(codUsuario);
        listarExperencia(codUsuario);
        
    }
    function copiarDato(dato){
        $("#puesto").val(dato);
        $("#suggestions").css('display','none');     
    }
    function copiarDatoEm(dato){
        $("#empresa").val(dato);
        $("#resEmpresa").css('display','none');
    }
    
    
    
    
    function guardarExperiencia(){
        var codUsu = $("#codUsuExp").val();
        var puesto = $("#puesto").val();
        var tiempo = $("#tiempo").val();
        var tipTie = $("#tipTiempo").val();
        var empres = $("#empresa").val();
        
       var param = 'codUsu='+codUsu+'&puesto='+puesto+'&tiempo='+tiempo+'&tipTie='+tipTie+'&empres='+empres;
       //alert(param);
       $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=guardarExperiencia',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
            }, complete: function () {
                //msjExitoso('La operacion se realizo correctamente');
                listarExperencia(codUsu);
            }
        });
    }
    function deleteExperiencia(codExperiencia,codUsuario){
        alert(codExperiencia);
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=deleteExperiencia',
            data: 'codExperiencia='+codExperiencia+'&codUsuario='+codUsuario,
            beforeSend: function () {
            }, success: function (resultado) {
            }, complete: function () {
                listarExperencia(codUsuario);
            }
        });
    }
    function listarExperencia(codUsuario){
        //var codUsuario = $("#codUsuExp").val();
        //alert(codUsuario);
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarExperencia',
            data: 'codUsuario='+codUsuario,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#tablaExpreriencias tbody").html(resultado);
            }, complete: function () {
                
            }
        });
    }
    
    
    function listarProfesiones(){
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarProfesiones',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selectProfesion").html(resultado);
            }, complete: function () {
                
            }
        });
    }
    
    function darBajaUsu(codUsu){
        Swal.fire({
            title: 'Mensaje',
            text: "Esta seguro de dar de baja al Usuario?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#48C28D',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Continuar',
            cancelButtonText: 'Cancelar'
          }).then((result) => {
            if (result.isConfirmed) {
              confirmarBaja(codUsu);
            }
          })
    }
    
    function cesarDeCargo(codUsuPerfil,){
        var usu = $("#codUsu").val();
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=cesarDeCargo',
            data: 'codUsuPerfil='+codUsuPerfil,
            beforeSend: function () {
            }, success: function (resultado) {
            }, complete: function () {
                msjExitoso('La operacion se realizo correctamente');
                //cerrarModal("ceseUsuario");
                listarCargosUsu(usu);
            }
        });
    }
    
    function listarInactivos(){
       listarUsuario('0');// lista de usuarios inactivo
    }
    function confirmarBaja(codUsu){
        $("#confirCese").modal('show');
        var usu = $("#nomUser").val();//usuario que modifica el dato
        $("#usuAMod").val(codUsu);//usuario a dar de baja
        $("#usuConfir").val(usu);
        $("#usuConfir").attr('disabled',true);
        
    }
    function validarConfirmacion(){
        var user = $("#usuConfir").val();
        var clave = $("#claConfir").val();
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=Login',
            data: 'user=' + user + '&clave=' + clave,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#resultado").html(resultado);
                //alert(resultado);
            }, complete: function () {
                var ini = $("#inicio").val();
                if(ini ==1){
                    cerrarModal('confirCese');
                    abrirModal('ceseUsuario');
                    listarMotivoBaja('motCese');
                }else{
                    Swal.fire({
                    title: 'Mensaje',
                    text: "Ingrese nuevamente su clave",
                    icon: 'warning',
                    confirmButtonColor: '#d33',
                    confirmButtonText: 'Cerrar'
                  })
                }
            }
        });
        
    }
    
    function darBajaUsuario(){
        var codUsu = $("#usuAMod").val();
        var uModifica = $("#coUser").val();
        var uClave = $("#claConfir").val();
        var motCese = $("#motCese").val();
        var feCese  = $("#fecCese").val();
        
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=darBajaUsuario',
            data: 'codUsu='+codUsu+'&uModifica='+uModifica+'&motCese='+motCese+'&feCese='+feCese,
            beforeSend: function () {
            }, success: function (resultado) {
            }, complete: function () {
                msjExitoso('El usuario fue dado de baja!');
                cerrarModal("ceseUsuario");
                
            }
        });
    }
    function listarMotivoBaja(mostrar){
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarMotivoBaja',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
               $("#"+mostrar).html(resultado);
            }, complete: function () {
                //msjExitoso('El usuario fue dado de baja!');
            }
        });
    }
    
    function listarUsuario(estado){
    $("#tablaUsuarios").DataTable().destroy();
    $("#tablaUsuarios").DataTable({           
        select: {
            style: 'single'
        }, "language": {
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            select: {rows: ""}
        },
        "bSort": false,
        "bFilter": true,
        "serverSide": true,
        "processing": true,
        "iDisplayLength": 10,
        "aaSorting": [],
        "ordering": true,
        "bAutoWidth": false,
        "paging": true,
        "rowReorder": true,
        "sEmptyTable": "Loading data from server",
//                    "order": [[3, 'desc'], [3, 'asc']],
        "columnDefs": [
            {"orderable": true, className: 'reorder', targets: 0},
            {"orderable": true, "targets": "_all"},
            {sortable: true},
            {className: "text-center", "targets": [0]},
            {className: "text-center", "targets": [1]},
            {className: "text-center", "targets": [2]},
            {className: "text-center", "targets": [3]},
            {className: "text-center", "targets": [4]},
            {className: "text-center", "targets": [5]},
            {className: "text-center", "targets": [6]}
//                        {className: "text-center", "targets": [0]}
        ],
        "ajax": {
            "url": "../../../ventasServlet?Accion=listarVendedores",
            "data": {
                      "codEstado": estado,
                    }
            }, "columns": [
            {data: 'nombre'},
            {data: 'apaterno'},
            {data: 'amaterno'},
            {data: 'tdoc'},
            {data: 'numdoc'},
            {data: 'celular'},
            {data: 'accion'}
        ], "fnDrawCallback": function (oSettings) {
            $("a.text-success").tooltip();
        }, "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {//exito
        }
    });
    $('.dataTables_filter input[type=search]').attr('placeholder', '');
    $('.dataTables_length select').select2({
        minimumResultsForSearch: Infinity,
        width: 'auto'});
    }

    function editUsuario(codUsu,nunDoc){
         window.location.href = "crearUsuario.jsp?param="+nunDoc+"&param1="+codUsu+"";
    }
    function asignarPerfil(asignarPerfil){
        $("#codUsu").val(asignarPerfil);
        listarCargosUsu(asignarPerfil);
        $("#asignarRol").modal('show');
        cargarAreas("seArea");
    }

    function cargarAreas(mostrar){
    //alert("llega");
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listaAreas',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#"+mostrar).html(resultado);
            }, complete: function () {
            }
        });
    }

    function listarPerfil(mostrar,dato){
        var codArea = $("#"+dato).val();
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarPerfil',
            data: 'codArea='+codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#"+mostrar).html(resultado);
            }, complete: function () {
            }
        });
    }
    function guardarAsigCargo(){
        var codArea   = $("#seArea").val();
        var codPerfil = $("#seRol").val();
        var codUsu    = $("#codUsu").val();
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=guardarAsigCargo',
            data: 'codArea='+codArea+'&codPerfil='+codPerfil+'&codUsu='+codUsu,
            beforeSend: function () {
            }, success: function (resultado) {

            }, complete: function () {
                listarCargosUsu(codUsu);
            }
        });

    }
    function listarCargosUsu(codUsu){
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarCargosUsu',
            data: 'codUsu='+codUsu,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#rolesUsutbody").html(resultado);
            }, complete: function () {
                //listarCargosUsu(codUsu);
            }
        });
    }
    
    /*  AUTO COMPLETADO PARA LA LISTA DE PUESTOS LABORALES*/
    $(document).ready(function() {
        $('#puesto').on('keyup', function() {
            var buscar = $(this).val();		
            var dataString = 'buscar='+buscar;
            $.ajax({
                type: "POST",
                url: "../../../reHumanosServlet?Accion=buscarPuestos",
                data: dataString,
                success: function(data) {
                    //Escribimos las sugerencias que nos manda la consulta
                    $('#suggestions').fadeIn(1000).html(data);
                    //Al hacer click en alguna de las sugerencias
                    $('.suggest-element').on('click', function(){
                            //Obtenemos la id unica de la sugerencia pulsada
                            var id = $(this).attr('id');
                            //Editamos el valor del input con data de la sugerencia pulsada
                            $('#buscar').val($('#'+id).attr('data'));
                            //Hacemos desaparecer el resto de sugerencias
                            $('#suggestions').fadeOut(1000);
                            alert('Has seleccionado el '+id+' '+$('#'+id).attr('data'));
                            return false;
                    });
                }
            });
        });
    }); 
    /******AUTO COMPLETADO DE LAS EMPRESAS LABORALES PARA */
    $(document).ready(function() {
        $('#empresa').on('keyup', function() {
            var buscar = $(this).val();		
            var dataString = 'buscar='+buscar;
            $.ajax({
                type: "POST",
                url: "../../../reHumanosServlet?Accion=buscarEmpresas",
                data: dataString,
                success: function(data) {
                    //Escribimos las sugerencias que nos manda la consulta
                    $('#resEmpresa').fadeIn(1000).html(data);
                    //Al hacer click en alguna de las sugerencias
                    $('.suggest-element').on('click', function(){
                            //Obtenemos la id unica de la sugerencia pulsada
                            var id = $(this).attr('id');
                            //Editamos el valor del input con data de la sugerencia pulsada
                            $('#buscar').val($('#'+id).attr('data'));
                            //Hacemos desaparecer el resto de sugerencias
                            $('#suggestions').fadeOut(1000);
                            alert('Has seleccionado el '+id+' '+$('#'+id).attr('data'));
                            return false;
                    });
                }
            });
        });
    }); 
    

</script>

</html>