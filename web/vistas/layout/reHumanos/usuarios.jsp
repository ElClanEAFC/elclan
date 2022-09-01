<%-- 
    Document   : index
    Created on : 05/08/2021, 09:33:20 AM
    Author     : bcondori
--%>

<!--============================================================================
MODALES
=============================================================================-->
<div id="crearUsu"></div>
<div id="modal"></div>
<div id="resultado"></div>
<!-- Button trigger modal -->

<!-- Modal DETALLES DEL USUARIO-->
<div class="modal fade" id="modalDetalleUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleUsuario">Bentu Condori - BCONDORI</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row gap-sm-2 gap-md-0">
                    <div class="col-sm-12 col-md-12 col-lg-4">
                        <div class="content-img-user my-2">
                            <img src="src" alt="alt"/>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6 col-lg-4">
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">NOMBRE/RAZÓN SOCIAL:</p>
                            </div>
                            <div class="col-6">
                                <p id="detNombre">BENTU</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">APELLIDO PATERNO:</p>
                            </div>
                            <div class="col-6">
                                <p id="detAPaterno">CONDORI</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">APELLIDO MATERNO:</p>
                            </div>
                            <div class="col-6">
                                <p id="detAMaterno">MAMANI</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">TELEFONO:</p>
                            </div>
                            <div class="col-6">
                                <p id="detCelular">987879781</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">CORREO:</p>
                            </div>
                            <div class="col-6">
                                <p id="detCorreo">BENTUCM@GMAIL.COM</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6 col-lg-4">
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">NACIONALIDAD:</p>
                            </div>
                            <div class="col-6">
                                <p id="detPais">PERU</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">DIRECCIÓN</p>
                            </div>
                            <div class="col-6">
                                <p id="detDireccion">AV. RICARDO FLORES</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">DEPARTAMENTO:</p>
                            </div>
                            <div class="col-6">
                                <p id="detDepartamento">CUSCO</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">PROVINCIA:</p>
                            </div>
                            <div class="col-6">
                                <p id="detProvincia">Quispicanchi</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="fw-bold">DISTRITO:</p>
                            </div>
                            <div class="col-6">
                                <p id="detDistrito">Quiquijana</p>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-12 container-fluid">
                    <hr>
                    <h4 class="card-title">LISTA DE CARGOS</h4>
                    <div class="table-responsive">
                        <table id="tablaCargosUsuarioDetalle" class="table  table-bordered">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>AREA</th>
                                    <th>PERMISOS</th>
                                    <th>F. INICIO</th>
                                    <th>F. CESE</th>
                                    <th>MOTIVO CESE</th>
                                    <th>ESTADO</th>
                                </tr>
                            </thead>
                            <tbody id="listaCargosUsuarioDetalle">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CERRAR</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal Asignar CARGO Laboral  en DB-->
<div class="modal fade" id="modalAsignarPeriodo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="exampleModalLabel">ASIGNAR NUEVO CARGO AL USUARIO</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body modal-lg">
                <div class="row">
                    <form id="idAsignarCargo" class="row col-lg-8">
                        <div class="form-group col-lg-6">
                            <div class="d-flex gap-2">
                                <label for="selectArea">AREA:</label>
                                <div class="flex-grow-1">
                                    <select class="form-control" id="selectArea" name="selectArea">

                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-lg-6">
                            <div class="d-flex gap-2">
                                <label for="selectCargo">CARGO:</label>
                                <div class="flex-grow-1">
                                    <select class="form-control" id="selectCargo" name="selectCargo">

                                    </select>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="form-group col-lg-4">
                        <div class="d-flex gap-2 justify-content-center">
                            <button type="button" class="btn btn-success text-white" onclick="validarCamposCargo();">AGREGAR</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 container-fluid">
                <h4 class="card-title">LISTA DE CARGOS</h4>
                <div class="table-responsive">
                    <table id="tablaCargosUsuario" class="table table-bordered" width="100%" autocomplete="off">
                        <thead>
                            <tr>
<!--                                <th>N°</th>-->
                                <th>AREA</th>
                                <th>PERMISOS</th>
                                <th>F. INICIO</th>
                                <th>F. CESE</th>
                                <th>MOTIVO CESE</th>
                                <th>ESTADO</th>
                                <th>OPCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">                
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CERRAR</button>
            </div>
        </div>
    </div>
</div>
<!--======================== MODAL DE EDITAR USUARIO =========================-->
<!-- Modal -->
<div class="modal fade" id="modalEditarUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h4 class="modal-title text-white" id="exampleModalLabel">EDITAR USUARIO</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!--ENCABEZADO SEARCH-->
                <!------formulario--->
                <div>
                    <h4>DATOS DEL USUARIO</h4>
                    <p><br></p>
                    <form id="formRegistroUsuario" class="">
                        <div class="row">
                            <div class="col-3">
                                <label for="usuTDoc">Tipo de Documento *</label>
                                <select id="usuTDoc" name="usuTDoc" class=" form-control" >
                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuNumDoc">N° Documento *</label>
                                <input id="usuNumDoc" name="usuNumDoc" type="text" maxlength="8"
                                       class="form-control" onkeypress="soloNumeros(event);" onkeyup="buscarDOI(this.value);" onchange="" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <label for="usuNombre">NOMBRES *</label>
                                <input id="usuNombre" name="usuNombre" type="text" class=" form-control datos"   > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuApaterno">APELLIDO PATERNO *</label>
                                <input id="usuApaterno" name="usuApaterno" type="text" class=" form-control datos"   >  
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuAmaterno">APELLIDO MATERNO *</label>
                                <input id="usuAmaterno" name="usuAmaterno" type="text" class=" form-control datos"   >   
                                <!--                                    <div class="valid-feedback">
                                                                        Looks good!
                                                                    </div>-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <label for="usuCelular">CELULAR *</label>
                                <input id="usuCelular" name="usuCelular" type="text" class=" form-control datos datoEdita" maxlength="9" >  
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuCorreo">CORREO *</label>
                                <input id="usuCorreo" name="usuCorreo" type="email" class=" form-control datos datoEdita" required="" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-4">
                                <label for="usuDireccion">DIRECCIÓN *</label>
                                <input id="usuDireccion" name="usuDireccion" type="text" class=" form-control datos datoEdita" >  
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-3">
                                <label for="usuPais">PAIS *</label>
                                <select name="usuPais" id="usuPais" class="form-control datos datoEdita"  >
                                    <!--<option value="51">Perï¿½</option>-->
                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuDpto">DEPARTAMENTO *</label>
                                <select name="usuDpto" id="usuDpto" class=" form-control datos datoEdita" onchange="listarProv();"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuProv">PROVINCIA *</label>
                                <select name="usuProv" id="usuProv" class=" form-control datos datoEdita" onchange="listarDist();"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuDist">DISTRITO *</label>
                                <select name="usuDist" id="usuDist" class=" form-control datos datoEdita"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-3">
                                <label for="usuArea">AREA *</label>
                                <select name="usuArea" id="usuArea" class=" form-control datos"  onchange="listarPerfil();"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuCargo">CARGO / PUESTO *</label>
                                <select name="usuCargo" id="usuCargo" class="form-control datos"  >

                                </select>
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuFNacimiento">FECHA NACIMIENTO *</label>
                                <input id="usuFNacimiento" name="usuFNacimiento" type="date" class="form-control datos datoEdita" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                            <div class="col-3">
                                <label for="usuFinicio">FECHA INGRESO *</label>
                                <input id="usuFinicio" max="9999-12-31" name="usuFinicio" type="date" class=" form-control datos" > 
                                <div class="valid-feedback">
                                    Looks good!
                                </div>
                            </div>
                        </div>
                    </form>  
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CERRAR</button>
                <button class="btn btn-success text-white" onclick="validarCamposUsu();" id="btnActualizarUsuario">ACTUALIZAR</button>
                <button class="btn btn-success text-white hide" onclick="validarCamposUsu();" id="btnGuardarUsuario">GUARDAR</button>
            </div>
            <!-- ===== LOADER ======= -->
            <div class="content-loader visually-hidden" id="ico-loader">
                <div class="loader">
                </div>
            </div>
        </div>
    </div>
</div>
<!--========================MODAL DE CESE DEL USUARIO=========================-->
<div class='modal fade' id='ceseUsuario' tabindex='-1' role='dialog'>
    <div class='modal-dialog'  role='document'>
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title text-white'><i class="fas fa-tags"></i>REGISTRAR DATOS DEL CESE</h4>
                <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <div class="row">
                        <form id="formCesarUsuario">
                            <input type="hidden" name="usuAMod" id="usuAMod">
                            <div class="col-md-10 centrar">
                                <p>
                                    <label>SELECCIONE MOTIVO CESE *</label>
                                    <select class="form-control" id="motCese" name="motCese" aria-invalid="true">
                                    </select>
                                </p>
                            </div>
                            <div class="col-md-10 centrar">
                                <p>
                                    <label>FECHA CESE *</label>
                                    <input type="date" max="9999-12-31" name="fecCese" id="fecCese" class="form-control">
                                </p>
                            </div>   
                        </form>

                    </div>
                </div> 
            </div>
            <div class='modal-footer'>
                <button type='button' onclick='validarDatosDeCese();' class='btn btn-primary btn-success'>CONFIRMAR</button>
                <button type='button' onclick='cerrarModal("ceseUsuario");' class='btn btn-secondary btn-danger text-white' data-bs-dismiss='modal'>CERRAR</button>
            </div>
        </div>
    </div>
</div>

<!-------------------MODAL CONFIRMAR CESE DEL USUARIO  ------------------------->
<div class='modal fade' id='confirCese' tabindex='-1' role='dialog'>
    <div class='modal-dialog'  role='document'>
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title text-white'><i class="fas fa-tags"></i>CONFIRMAR CESE</h4>
                <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <div class="row">
                        <form>
                            <input type="hidden" name="usuAMod" id="usuAMod">
                            <div class="col-md-10 centrar">
                                <p>
                                    <label>USUARIO:</label>
                                    <input type="text" name="usuConfir" id="usuConfir" class="form-control"> 
                                </p>
                            </div>
                            <div class="col-md-10 centrar">
                                <p>
                                    <label>CONTRASEÑA:</label>
                                    <input type="password" name="claConfir" id="claConfir" class="form-control" placeholder='Ingrese Contraseï¿½a'>
                                </p>
                            </div>   
                        </form>

                    </div>
                </div> 
            </div>
            <div class='modal-footer'>
                <button type='button' onclick="validarConfirmacion();" class='btn btn-primary btn-success'>CONFIRMAR</button>
                <button type='button' onclick='cerrarModal("confirCese");' class='btn btn-secondary btn-danger text-white' data-bs-dismiss='modal'>CERRAR</button>
            </div>
        </div>
    </div>
</div>

<!--========================AGREGAR INFORMACION  ADICIONAL DEL USUARIO=========================-->
<div class='modal fade' id='addExperiencia' tabindex='-1' aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class='modal-dialog modal-xl'  role='document'>
        <div class='modal-content' >
            <div class='modal-header bg-danger'>
                <h4 class='modal-title text-white'><i class="fas fa-tags"></i>AGREGAR EXPERIENCIAS</h4>
                <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'>
                </button>
            </div>
            <div class='modal-body'>
                <div class="container">
                    <!--CEBECERA-->
                    <input type="hidden" name="codUsuExp" id="codUsuExp">
                    <form class="row" id="formExperiencia">
                        <div class="col-md-4">
                            <label>PUESTO: *</label>
                            <input type="text" id="puesto" name="puesto" class="form-control">
                            <ol id="suggestions" class="autocomplete">
                            </ol>
                        </div>  
                        <div class="col-md-2">
                            <p>
                                <label>F. INICIO *</label>
                                <input type="date" name="fecIni" id="fecIni" class="form-control">
                            </p>
                        </div>
                        <div class="col-md-2">
                            <p>
                                <label>F. Fin *</label>
                                <input type="date" name="fecFin" id="fecFin" class="form-control">
                            </p>
                        </div>
                        <div class="col-md-4">
                            <label>EMPRESA: *</label>
                            <input type="text" name="empresa" id="empresa" class="form-control">
                            <ol id="resEmpresa" class="autocomplete"></ol>
                        </div>
                        <div class="col-12">
                            <label for="exampleFormControlTextarea1" class="form-label">OBSERVACIONES(opcional):</label>
                            <textarea class="form-control" id="observaciones" name="observaciones" rows="2"></textarea>
                        </div>
                    </form>
                        <div class="col-12 text-center d-flex justify-content-end">
                            <p class="my-1">
                                <button type="button" class="btn btn-primary btn-success" onclick="validarCamposExp();"><i class="fas fa-check">AÑADIR</i></button>
                            </p>
                        </div>
                    <div class="row">
                        <div class="col-md-12"><hr></div>
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table id="tablaExpreriencias"  class="table datatable-basic ui celled table responsive nowrap unstackable " width="100%" autocomplete="off">
                                    <thead>
                                        <tr>
                                            <th>N°</th>
                                            <th>PUESTO LABORAL</th>
                                            <th>TIEMPO LABORAL </th>
                                            <th>EMPRESA</th>
                                            <th>OPCIONES</th>                  
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
            <div class='modal-footer'>
                <!--<button type='button' onclick='darBajaUsuario();' class='btn btn-primary btn-success'>Confirmar</button>-->
                <button type='button' onclick='cerrarModal("addExperiencia");' class='btn btn-secondary btn-danger text-white' data-dismiss='modal'>CERRAR</button>
            </div>
        </div>
    </div>
</div>

<!--============================================================================
FIN MODALES
=============================================================================-->

<!--=====
TABLA LISTA DE USUARIOS
=====-->
<div class="container-fluid">
            <!-- contenido -->
    <div class="card">
        <div class="card-body">
            <div class="row">        
                <div class="col-md-12">
                    <div class="d-flex gap-1 justify-content-between flex-wrap">
                        <div class="col-md-5 d-flex gap-3">
                            <form id="formBuscarUser" class="my-lg-0 gap-3 col-md-7">
                                <input class="form-control mr-sm-2 rounded" id="userbuscar" name="userbuscar" type="search" placeholder="ingrese dni o nombre">
                            </form>
                            <div class="form-group">
                                <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoUser();">BUSCAR</button>
                            </div>
                        </div>
                        <div class="d-flex align-items-center">
                            <button class="btn btn-success text-white " onclick="ROUTER.load('registrar');">AÑADIR USUARIO</button>            
                        </div>        
                    </div>
                    <hr/>
                    <h5 class="card-title">LISTA DE USUARIOS</h5>
                    <table id="listaUsuarios"  class="table table-striped" width="100%" autocomplete="off">
                        <thead>
                            <tr>
                                <th>Nombres</th>
                                <th>APELLIDO PATERNO</th>
                                <th>APELLIDO MATERNO</th>
                                <th>USUARIO</th>
                                <th>TIPO DOC.</th>
                                <th>N° DOCUMENTO</th>
                                <th>CARGO</th>
                                <th>ESTADO</th>
                                <!-- <th>Fecha Inicio</th>-->
                                <!--<th>Nï¿½ Celular</th>-->
                                <th>OPCIONES</th>                  
                            </tr>
                        </thead>
                        <!--<tbody id="listaUser">-->
                        <!--<tbody id="listaUsuarios">
                        </tbody>-->
                        <tbody >
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<script type="module" src="../../js/usuarios.js"></script>-->
<script>
    var validarDB = false;
    var validarReniec = false;
    var codUser;
    var codUser1;
    var codUser2;
    var codUserReniec;
    var userDetalle = false;
//    var listaPuestos;
//    let tablaExperiencias;
//    let allUsuarios;
//    let tablaCargosUsuario;
//    let validarErrorUser;
    $(document).ready(function () {
        
        $('#userbuscar').keydown(function (e){ 
            if(e.keyCode === 13){
                e.preventDefault();
                buscarEmpleado();
            }
        });
        // 27-07-2022
        tableUsuarios = $('#listaUsuarios').DataTable({
            responsive: true,
            searching: false,
            ordering: false,
            "language": {
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla",
                "sInfo": "_START_ al _END_ de _TOTAL_ registros",
                "infoEmpty": "Mostrando del 0 al 0 de 0 registros",
                "sLengthMenu": "",
                "oPaginate": {
                    "sFirst": "Erste",
                    "sPrevious": "Atrás",
                    "sNext": "Siguiente",
                    "sLast": "Letzte"
                 },
                select: { rows: "" }
            }
        });
        // 26-07-2022
        tablaExperiencias = $('#tablaExpreriencias').DataTable({
            responsive: true,
            searching: false,
            ordering: false,
            "language": {
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla",
                "sInfo": "_START_ al _END_ de _TOTAL_ registros",
                "infoEmpty": "Mostrando del 0 al 0 de 0 registros",
                "sLengthMenu": "",
                "oPaginate": {
                    "sFirst": "Erste",
                    "sPrevious": "Atrás",
                    "sNext": "Siguiente",
                    "sLast": "Letzte"
                 },
                select: { rows: "" }
            }
        });
        tablaCargosUsuario = $('#tablaCargosUsuario').DataTable({
            responsive: true,
            searching: false,
            ordering: false,
            "language": {
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla",
                "sInfo": "_START_ al _END_ de _TOTAL_ registros",
                "infoEmpty": "Mostrando del 0 al 0 de 0 registros",
                "sLengthMenu": "",
                "oPaginate": {
                    "sFirst": "Erste",
                    "sPrevious": "Atrás",
                    "sNext": "Siguiente",
                    "sLast": "Letzte"
                 },
                select: { rows: "" }
            }
        });
        // 19-07-2022
        listarUsuarios();
        $('#selectArea').change(function () {
            var codArea = this.value;
            llenarSelectCargos(codArea, '#selectCargo');
        });
        $("#abrir").click(function () {
            $("#addExperiencia").modal("show");
            listaExperienciasLab();
        });
        $('#fecCese').attr(limitarFechaAyerManana(3,3));
        $('#usuFinicio').attr(limitarFechaAyerManana(3,3));
        
        $.validator.addMethod("puestoTrim", function(value, element, param){
            if (value.replace(/[^0-9]/g,'') || value.replace(/^[^-_#'"\\\/<>=*@&]*$/,'')) {
                return false;
            }
            return this.optional(element) || value.trim().length > 0;
        },"Ingrese un puesto valido");
        
        $.validator.addMethod("inputTrim", function(value, element, param){
            return this.optional(element) || value.trim().length > 0;
        });
//        INGRESA SOLO NUMEROS EN CAMPO DNI
        $('#usuNumDoc').on('input', function (){
            this.value = this.value.replace(/[^0-9]/g,'');
        });
        // INGRESA SOLO NUMEROS EN CAMPO CELULAR
        $('#usuCelular').on('input', function (){
            this.value = this.value.replace(/[^0-9]/g,'');
        });
        // LISTAR REGISTROS DE USUARIOS
        $('#userbuscar').on('input', function (){
            if (this.value == ""){
                listarUsuarios();
            }
        });
    });
    function llenarDatosDetalles(data) {
        let nombre = data.nombreUsuario;
        let user = data.usuario;
        $('#titleUsuario').text(nombre+"-"+user);
        $('#detNombre').text(data.nombreUsuario);
        $('#detAPaterno').text(data.apePaternoUsuario);
        $('#detAMaterno').text(data.apeMaternoUsuario);
        $('#detCelular').text(data.telefono);
        $('#detCorreo').text(data.email);
        $('#detPais').text(data.descPais);
        $('#detDireccion').text(data.direccion);
        $('#detDepartamento').text(data.descDepartamento);
        $('#detProvincia').text(data.descProvincia);
        $('#detDistrito').text(data.descDistrito);
    }
    async function detalleUsuario(codUsuario, codTDoc, numDoc) {
        $('#modalDetalleUsuario').modal('show');
        await listaCargosUsuarioDetalle(codUsuario, '#listaCargosUsuarioDetalle');
        userDetalle = true;
        editarUsuario(codTDoc, numDoc);
    }
    // MOSTRAR LOADER DE CARGA 
    function loaderON() {
        $('#ico-loader').removeClass('visually-hidden');
    }
    // OCULTAR LOADER DE CARGA
    function loaderOFF() {
        $('#ico-loader').addClass('visually-hidden');
    }
    function listarDist() {
        var codDpto = $("#usuDpto").val();
        var codProv = $("#usuProv").val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaDistritos',
            data: 'codDpto=' + codDpto + '&codProv=' + codProv,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuDist").html(resultado);
            }, complete: function () {
            }
        });
    }
    function listarProv() {
        var codDpto = $("#usuDpto").val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaProvincias',
            data: 'codDpto=' + codDpto,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuProv").html(resultado);
            }, complete: function () {
            }
        });
    }
    function listarDpto() {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaDepartamentos',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuDpto").html(resultado);
            }, complete: function () {
            }
        });
    }
    // DESACTIVAR USUARIO 
    async function desactivarUsuario(codUser) {
        //let codUser = $("#usuAMod").val();
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=desactivarUsuario',
            data: 'codUser=' + codUser,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
            }, complete: function () {
            }
        });
    }
    // ===== CREAR USUARIOS ====
    function crearUsuario() {
        var usuTDoc = $("#usuTDoc").val();
        var usuNumDoc = $("#usuNumDoc").val();
        var usuNombre = $("#usuNombre").val();
        var usuApaterno = $("#usuApaterno").val();
        var usuAmaterno = $("#usuAmaterno").val();
        var usuCelular = $("#usuCelular").val();
        var usuCorreo = $("#usuCorreo").val();
        var usuDireccion = $("#usuDireccion").val();
        var usuPais = $("#usuPais").val();
        var usuDpto = $("#usuDpto").val();
        var usuProv = $("#usuProv").val();
        var usuDist = $("#usuDist").val();
        var usuArea = $("#usuArea").val();
        var usuCargo = $("#usuCargo").val();
        var usuFinicio = $("#usuFinicio").val();
        var usuFNacimiento = $("#usuFNacimiento").val();
        var param = 'codTDoc=' + usuTDoc + '&usuNumDoc=' + usuNumDoc + '&usuNombre=' +
                usuNombre + '&usuApaterno=' + usuApaterno + '&usuAmaterno=' + usuAmaterno + '&usuCelular=' +
                usuCelular + '&usuCorreo=' + usuCorreo + '&usuDireccion=' + usuDireccion + '&codPais=' + usuPais + '&codDpto=' + usuDpto + '&codProv=' + usuProv + '&codDist=' + usuDist + '&codArea=' + usuArea +
                '&codCargo=' + usuCargo + '&usuFinicio=' + usuFinicio + '&usuFNacimiento=' + usuFNacimiento;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=guardarUsuarios',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    console.log("El resultado es: " + resultado);
                    $('#btnActualizarUsuario').removeClass('hide');
                    $('#btnGuardarUsuario').addClass('hide');
                    $('#modalEditarUsuario').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                    console.log("FALLO EL REGISTRO DEL USUARIO");
                }
            }, complete: function () {
            }
        });
        console.log(usuFNacimiento);
        console.log(usuFinicio);
    }
    // ==== ACTUALIZAR INFOMACION DE USUARIO
    async function actualizarUsuario() {
        loaderON();
        let codUsuario;
        if (codUser2.toString().length > 0) {
            codUsuario = codUser2;
            await desactivarUsuario(codUser1);
        } else {
            codUsuario = codUser1;
        }
        var usuNombre = $("#usuNombre").val();
        var usuApaterno = $("#usuApaterno").val();
        var usuAmaterno = $("#usuAmaterno").val();
        var codTDoc = $("#usuTDoc").val();
        var numDoc = $("#usuNumDoc").val();
        var codPais = $("#usuPais").val();
        var codDpto = $("#usuDpto").val();
        var codProv = $("#usuProv").val();
        var codDist = $("#usuDist").val();
        var usuCelular = $("#usuCelular").val();
        var usuCorreo = $("#usuCorreo").val();
        var usuDirec = $("#usuDireccion").val();
        var usuFNac = $("#usuFNacimiento").val();
        //var usuFIni      = $("#usuFinicio").val();
        //var usuCodUser = $("#edCodUser").val();
        var param = 'codUsuario=' + codUsuario + '&usuNombre=' + usuNombre + '&usuApaterno=' + usuApaterno + '&usuAmaterno=' + usuAmaterno + '&codTDoc=' + codTDoc + '&numDoc=' + numDoc + '&codPais=' + codPais +
                '&codDpto=' + codDpto + '&codProv=' + codProv + '&codDist=' + codDist + '&usuCelular=' + usuCelular + '&usuCorreo=' + usuCorreo + '&usuDirec=' + usuDirec + '&usuFNac=' + usuFNac;
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=actualizarUsuarios',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
                let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0],res[1]);
                    console.log("ACTUALIZADO");
                    $('#modalEditarUsuario').modal('hide');
                    loaderOFF();
                } else {
                    msjFinal(res[0],res[1]);
                    console.log("FALLO LA ACTUALIZACION DEL USUARIO");
                    loaderOFF();
                }
            }, complete: function () {
            }
        });

    }
    // ===== VALIDAR CAMPOS VACIOS FORM USUARIO=====
    function validarCamposUsu() {
        let validator = $("#formRegistroUsuario").validate({
            rules: {
                usuNumDoc: {required: true},
                usuNombre: {required: true},
                usuApaterno: {required: true},
                usuAmaterno: {required: true},
                usuCelular: {
                    required: true,
                    inputTrim : true
                },
                usuCorreo: {required: true},
                usuDireccion: {
                    required: true,
                    inputTrim : true
                },
                usuPais: {required: true},
                usuDpto: {required: true},
                usuProv: {required: true},
                usuDist: {required: true},
                usuArea: {required: true},
                usuCargo: {required: true},
                usuFNacimiento: {required: true},
                usuFinicio: {required: true}
            },
            messages: {
                usuNumDoc: "El numero documento obligatorio.",
                usuNombre: "Ingrese el nombre.",
                usuApaterno: "Ingrese apellido paterno.",
                usuAmaterno: "Ingrese apellido materno",
                usuCelular: {
                    required: "Ingrese numero celular",
                    inputTrim: "Ingrese un número valido"
                },
                usuCorreo: "Ingrese Correo",
                usuDireccion: {
                    required: "Ingrese Direccion",
                    inputTrim: "Ingrese una dirección valida"
                },
                usuPais: "Seleccione Pais",
                usuDpto: "Seleccione Departamento",
                usuProv: "Seleccione Provnncia",
                usuDist: "Seleccione Distrito",
                usuArea: "Seleccione Area",
                usuCargo: "Seleccione Cargo",
                usuFNacimiento: "Ingrese Fecha de nacimiento",
                usuFinicio: "Ingrese Fecha inicio"}
        });
        let estado = validator.form();
        if (estado) {
            if (validarDB) {
                actualizarUsuario();
            } else if (validarReniec) {
                desactivarUsuario(codUser1);
                crearUsuario();
            }
        }
    }
    // ====== OBTENER TIPOS DE DOCUMENTOS =======
    function cargarTipoDoc() {
        let codTipoDoc = 1;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaTipoDocumento',
            data: 'codTipoDoc=' + codTipoDoc,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuTDoc").html(resultado);
            }, complete: function () {
            }
        });
    }
    // ===== LISTAR PAISES =====
    async function listaPaises() {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaPaises',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuPais").html(resultado);
            }, complete: function () {
            }
        });
    }
    // ==== funcion OBTENER LISTA DE PERFILES O CARGOS
    function listarPerfil() {
        var codArea = $("#usuArea").val();
        //alert(codArea);
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listarPerfiles',
            data: 'codArea=' + codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#usuCargo").html(resultado);
            }, complete: function () {
            }
        });
    }
    // ===== LISTAR CARGO SEGUN EL  "ID_AREA" =====
    async function llenarSelectCargos(codArea, idCargoSelect) {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listarPerfiles',
            data: 'codArea=' + codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                $(idCargoSelect).html(resultado);
            }, complete: function () {
            }
        });
    }
    // ===== LISTAR AREAS =====
    async function listarAllAreas(idAreaSelect) {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listarAllAreas',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $(idAreaSelect).html(resultado);
            }, complete: function () {
            }
        });
    }
    // ===== LISTAR DEPARTAMENTOS =====
    async function listaDepartamentos() {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaDepartamentos',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $('#usuDpto').html(resultado);
                console.log("LISTA DE DEPARTAMENTOS---");
            }, complete: function () {
            }
        });
    };
    // ===== LISTAR PROVINCIAS =====
    var listaProvincias = async (codDpto) => {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaProvincias',
            data: 'codDpto=' + codDpto,
            beforeSend: function () {
            }, success: function (resultado) {
                $('#usuProv').html(resultado);
                console.log("LISTA DE Provincias---");
            }, complete: function () {

            }
        });
    };
    // ===== LISTAR DISTRITOS =====
    var listaDistritos = async (codDpto, codProv) => {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaDistritos',
            data: 'codDpto=' + codDpto + '&codProv=' + codProv,
            beforeSend: function () {
            }, success: function (resultado) {
                $('#usuDist').html(resultado);
            }, complete: function () {
            }
        });
    };
    // ==== funcion llenar INPUTS SELECT con datos de BASE DE DATOS
    function mostrarDatosEnSelect(id, dato) {
        $(id).empty();
        $(id).prepend($('<option/>', {
            text: dato
        }));
    }
    // ==== funcion llenar inputs con datos de RENIEC
    var llenarDatosUsuarioReniec = (data) => {
        $('#usuNombre').val(data.nombres);
        $('#usuApaterno').val(data.paterno);
        $('#usuAmaterno').val(data.materno);
    };
    // LLENAR DATOS DEL USUARIO TRAIDO DE BASE DE DATOS
    function llenarCamposUsuario(data) {
        $('input.datos').attr('readonly', true);
        $('select.datos').attr("disabled", true);
        $('input.datoEdita').attr('readonly', false);
        $('select.datoEdita').attr("disabled", false);
        $('#usuTDoc').attr("disabled", true);
        //codUser1 = data.codigoUsuario;
        $('#usuNumDoc').val(data.numeroDOI);
        $('#usuTDoc').val(data.numeroDOI);
        $('#usuNombre').val(data.nombreUsuario);
        $('#usuApaterno').val(data.apePaternoUsuario);
        $('#usuAmaterno').val(data.apeMaternoUsuario);
        $('#usuCelular').val(data.telefono);
        $('#usuCorreo').val(data.email);
        $("#usuPais").val(data.codigoPais);
        $('#usuDireccion').val(data.direccion);
        $('#usuDpto').val(data.codigoDepartamento);
        $('#usuProv').val(data.codigoProvincia);
        $('#usuDist').val(data.codigoDistrito);
        $('#usuFNacimiento').val(data.fechaNacimiento);
        $('#usuFinicio').val(data.finicio);
        mostrarDatosEnSelect('#usuArea', data.descArea);
        mostrarDatosEnSelect('#usuCargo', data.descPerfil);
    };
    // === LIMPIAR CAMPOS CUANDO EL CAMPO DNI ES MENOR A 8 (DIGITOS)
    function limpiarCampo() {
        $('input.datos').val('');
        $("select.datos").val('');
        //$("#usuTDoc option[value='1']").attr("selected", true);
    }
    // ===== LIMPIAR CAMPOS ====
    function limpiarCampoReniec(){
        $('input.datos').val('');
        $("select.datos").val('');
    }
    // OBTENER DATOS DEL USUARIO DESDE LA "BASE DE  DATOS"
    async function editarUsuario(codTDoc, numDoc) {

        if (!userDetalle) {
            $('#modalEditarUsuario').modal('show');
        }
        loaderON();
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=validarNumDoc',
            data: 'codTDoc=' + codTDoc + '&numDoc=' + numDoc,
            dataType: 'json',
            beforeSend: function () {
            }, success: async function (res) {
                console.log(res);
                //let res = res.toString().split("_");
                if (res.codMensaje == '1') {
                    if (userDetalle) {
                        llenarDatosDetalles(res);
                        loaderOFF();
                        userDetalle = false;
                        let validarErrorForm = $("#formRegistroUsuario").validate();
                        validarErrorForm.destroy();
                    } else {
                        if (codUser1 != null) {
                            codUser2 = res.codigoUsuario;
                            validarDB = true;
                            valiDarReniec = false;
                        } else {
                            codUser1 = res.codigoUsuario;
                        }
                        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
                        let validarErrorForm = $("#formRegistroUsuario").validate();
                        validarErrorForm.destroy();
                        
                        await listaDepartamentos();
                        await listaProvincias(res.codigoDepartamento);
                        await listaDistritos(res.codigoDepartamento, res.codigoProvincia);
                        await listaPaises();
                        // FUNCION CARGAR TIPOS DE DOCUMENTOS
                        cargarTipoDoc();
                        // FUNCION LLENAR CAMPOS EN FORMULARIO!
                        llenarCamposUsuario(res);
                        $('.datos').attr("disabled", true);
                        $('input.datoEdita').attr('disabled', false);
                        $('select.datoEdita').attr('disabled', false);
                        $('#modalEditarUsuario').modal('show');
                        $('#btnActualizarUsuario').removeClass('hide');
                        $('#btnGuardarUsuario').addClass('hide');
                        loaderOFF();
                    }

                } else {
                    let userreniec = {"dni": numDoc};
                    //FUNCION BUSCAR EN API-RENIEC
                    buscarReniec(userreniec);
                }
            }, complete: function () {

            }
        });
    }
    // VALIDADOR PARA INGRESAR SOLO NUMEROS EN EL CAMPO DNI
    function soloNumeros(e) {
        var charCode = (e.which) ? e.which : e.keyCode;
        console.log(charCode);
        if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;
        return true;
    }
    // ====== Buscar DNI EN BASE DE DATOS  Y  RENIEC
    async function buscarDOI() {
        var codTDoc = $('#usuTDoc option:selected').val();
        var numDoc = $('#usuNumDoc').val();
        if (numDoc.toString().length === 8 && codTDoc === '1') {
            // BUSCAR EL DNI EN "BASE DE DATOS O RENIEC"
            editarUsuario(codTDoc, numDoc);
        }else{
            $('#usuNombre').val('');
            $('#usuApaterno').val('');
            $('#usuAmaterno').val('');
            $('.datos').val('');
        }
    }
    // ==== BUSQUEDA DE DATOS EN RENIEC MEDIANTE DNI =====
    async function buscarReniec(userreniec) {
        loaderON();
        await $.ajax({
            async: true,
            type: 'POST',
            url: 'https://www.softwarelion.xyz/api/reniec/reniec-dni',
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo4NTQsImNvcnJlbyI6InNpc3RlbWFzLmVsY2xhbmVhZmNAZ21haWwuY29tIiwiaWF0IjoxNjU3NjQ3OTM4fQ.PbaWSjGmng6R4HGby_6B4STJO4VIhGj5dyVO5ebeUGE"
            },
            dataType: 'json',
            data: userreniec,
            beforeSend: function () {
            }, success: function (res) {
                if (res.success === true) {
                    if (codUser1 !== null) {
                        codUser2 = "";
                        validarDB = false;
                        validarReniec = true;
                        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
                        let validarErrorForm = $("#formRegistroUsuario").validate();
                        validarErrorForm.destroy();
                        
                        limpiarCampo();
                        console.log(res.result);
                        llenarDatosUsuarioReniec(res.result);
                        listaPaises();
                        listarAllAreas('#usuArea');
                        listaDepartamentos();
                        $('select.datos').attr("disabled", false);
                        $('#usuFinicio').attr("disabled", false);
                        $('#usuFinicio').attr('readonly', false);
                        $('#btnActualizarUsuario').addClass('hide');
                        $('#btnGuardarUsuario').removeClass('hide');
                        
                    }
                    loaderOFF();
                } else if (res.success === false) {
                    console.log("NADA");
                    loaderOFF();
                }
            }, complete: function () {
            }
        });
    }
    // VALIDAR INPUTS PARA CESAR AL USUARIO
    function validarDatosDeCese() {
        let validator = $("#formCesarUsuario").validate({
            rules: {
                motCese: {required: true},
                fecCese: {required: true}
            },
            messages: {
                motCese: "Seleccione un motivo",
                fecCese: "Seleccione una fecha"
            }
        });
        let estado = validator.form();
        if (estado) {
            darBajaUsuario();
        }
    }
    // MOSTRAR MODAL DE VALIDAR USUARIO y GUARDAR COD_USUARIO A CESAR 19/07/2022
    function confirmarBaja(codUsu) {
        $("#confirCese").modal('show'); // Modal para VALIDAR Usuario 
        $("#usuAMod").val(codUsu);//cod usuario a dar de baja        
    }
    // VENTANA PARA CESE DE USUARIO 19/07/2022
    function confirmarBajaUser(codUser) {
        Swal.fire({
            title: 'Mensaje',
            text: "Esta seguro de dar de baja al usuario?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#28B779',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar!',
            confirmButtonText: 'Confirmar!'
        }).then((result) => {
            if (result.isConfirmed) {
                confirmarBaja(codUser);
            }
        });
    }
    // OBTENER LISTA DE USUARIOS 19/07/2022
    function listarUsuarios() {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaUsuarios',
            data: '',
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                allUsuarios = resultado;
                llenarTablaUusarios(resultado);
                //$("#listaUsuarios").html(resultado);
            }, complete: function () {

            }
        });
    }
    // LLENAR TABLA DE LISTA DE USUARIOS;
    function llenarTablaUusarios(data) {             
        tableUsuarios.clear().draw();
                    $.each(data, function () {
            let cargo = this['descPerfil'].toString().split("-");
            let estado = this['estado'].toString();
            let colorEstado = estado == "activo" ? "bg-danger text-white p-1 rounded-3" : "bg-success text-white p-1 rounded-3";
            tableUsuarios.row.add([
                this['nombreUsuario'],
                this['apePaternoUsuario'],
                this['apeMaternoUsuario'],
                this['usuario'],
                this['descTipoDOI'],
                this['numeroDOI'],
                cargo[0],
                "<span class=\" "+colorEstado+ "\">" + this['estado'] + "</span>",
                '<a href=\'#\' onclick=\"editarUsuario(' + this['codigoTipoDOI'] + ',\'' + this['numeroDOI'] + '\');\" title=\'Editar Usuario\'><i class=\'fas fa-edit editar\' ></i></a>'
                        + '<a class=\'pe-1\' href=\'#\' onclick=\"detalleUsuario(' + this['codigoUsuario'] + ',\'' + this['codigoTipoDOI'] + '\',' + this['numeroDOI'] + ');\" title=\'Detalle Usuario\'><i class=\'fas fa-eye\'></i></a>'
                        + '<a class=\'pe-1\' href=\'#\' onclick=\"asignarAreas(' + this['codigoUsuario'] + ');\" title=\'Asginar Cargo\'><i class=\'far fa-address-card otras-opciones\' ></i></a>'
                        + '<a class=\'pe-1\' href=\'#\' onclick=\"agregarExperiencia(' + this['codigoUsuario'] + ');\"><i class=\"fas fa-briefcase\" title=\'agregar Experiencia\'></i></a>'
                        + '<a class=\'pe-1\' href=\'#\' onclick=\"confirmarBajaUser(' + this['codigoUsuario'] + ');\"><i class=\'fas fa-trash-alt borrar\'  title=\'Cesar Usuario\'></i></a>'
//                '<button type="button" class="btn btn-warning btn-delete" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i></button>'
            ]).draw(false);
        });
    }
    //VALIDAR CAMPO DE BUSQUEDA DE EMPLEADO / USUARIO;
    function validarCampoUser(){
        let validator = $("#formBuscarUser").validate({
            rules: {
                userbuscar: {required: true}
            },
            messages: {
                userbuscar: "Ingrese el dni"
            }
        });
        let estado = validator.form();
        if (estado) {
            buscarEmpleado();
        }
    }
    // BUSCA USUARIO;
    function buscarEmpleado(){
        let buscar = $('#userbuscar').val(); 
        console.log(allUsuarios);
        let empleado = allUsuarios.filter( e => 
                    e?.numeroDOI.toLowerCase().includes(buscar) || e?.nombreUsuario.includes(buscar)
                );
        console.log(empleado);
        llenarTablaUusarios(empleado);
    }
//    async function crearUsuarioLink() {
//        await ROUTER.load('registrar');
//    }
    function segundaCarga() {
        listarUsuario('1');// lista de usuarios activos
    }
    // 
    function agregarExperiencia(codUsuario) {    
        $("#suggestions").empty();
        $('#suggestions').css('display', 'none'); 
        $("#resEmpresa").empty();
        $('#resEmpresa').css('display', 'none'); 
        $("#addExperiencia").modal('show');
        $("#codUsuExp").val(codUsuario);
        codUser = codUsuario;
        $("#formExperiencia input").val(''); 
        $("#formExperiencia textarea").val(''); 
        let valores = $('#formExperiencia').validate();
        valores.destroy();
        listaExperienciasLab(codUsuario);
    }
    // NO USADO
    function copiarDato(dato) {
        $("#puesto").val(dato);
        $("#suggestions").css('display', 'none');
    }
    // NO USADO
    function copiarDatoEm(dato) {
        $("#empresa").val(dato);
        $("#resEmpresa").css('display', 'none');
    }
    // VALIDAR CAMPOS DE AGREGAR EXPERIENCIA 
    function validarCamposExp(){
        //valores.resetForm();
        let validator = $('#formExperiencia').validate({
           rules:{
               puesto: {
                   required: true,
                   puestoTrim: true
                },
               fecIni: {required: true},
               fecFin: {required: true},
               empresa: {
                   required: true,
                   puestoTrim: true
               }                
           } ,
           messages: {
               puesto: {
                   required: "Seleccione su puesto",
                   puestoTrim: "Ingrese un puesto valido"
               },
               fecIni: "Seleccione una fecha",
               fecFin: "Seleccione una fecha",
               empresa: {
                   required: "Seleccione una empresa",
                   puestoTrim: "Ingrese una empresa valida"
               }
           }
        });
        let estado = validator.form();
        if (estado) {
           registroExperienciaLab();
        }
    }
    // REGISTRAR EXPERIENCIA DE EMPLEADO
    function registroExperienciaLab() {
        var codUser = $("#codUsuExp").val();
        var codPuesto = $("#puesto").val().trim();
        var descripcion = $("#observaciones").val();
        var fecIni = $("#fecIni").val();
        var fecFin = $("#fecFin").val();
        var empresa = $("#empresa").val().trim();

        var param = 'codUser=' + codUser + '&codPuesto=' + codPuesto + '&descripcion=' + descripcion +
                '&fecIni=' + fecIni + '&fecFin=' + fecFin + '&empresa=' + empresa;
        //alert(param);
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=registroExperienciaLab',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    msjFinal(res[0],res[1]);  
                    console.log(resultado);
                    //$("#codUsuExp").val('');
                    $("#puesto").val('');
                    $("#observaciones").val('');
                    $("#fecIni").val('');
                    $("#fecFin").val('');
                    $("#empresa").val('');           
                }else{
                    msjFinal(res[0],res[1]);
                }
            }, complete: function () {
                //msjExitoso('La operacion se realizo correctamente');
                listaExperienciasLab(codUser);
            }
        });
    }
    // POR USAR 
    function deleteExperiencia(codExperiencia, codUsuario) {
        //alert(codExperiencia);
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=deleteExperiencia',
            data: 'codExperiencia=' + codExperiencia + '&codUsuario=' + codUsuario,
            beforeSend: function () {
            }, success: function (resultado) {
            }, complete: function () {
                listarExperencia(codUsuario);
            }
        });
    }
    function listarProfesiones() {
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
    // SIN _USO
    function cesarDeCargo(codUsuPerfil, ) {
        var usu = $("#codUsu").val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=cesarDeCargo',
            data: 'codUsuPerfil=' + codUsuPerfil,
            beforeSend: function () {
            }, success: function (resultado) {
            }, complete: function () {
                msjExitoso('La operacion se realizo correctamente');
                //cerrarModal("ceseUsuario");
                listarCargosUsu(usu);
            }
        });
    }
    // SIN _USO
    function listarInactivos() {
        listarUsuario('0');// lista de usuarios inactivo
    }
    // VALIDACION DE LOGIN PARA CESAR USUARIO 19/07/2022
    function validarConfirmacion() {
        var user = $("#usuConfir").val();
        var clave = $("#claConfir").val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=Login',
            data: 'user=' + user + '&clave=' + clave,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#resultado").html(resultado);
                //alert(resultado);
            }, complete: function () {
                var ini = $("#inicio").val();
                if (ini == 1) {
                    cerrarModal('confirCese');
                    abrirModal('ceseUsuario');
                    listaMotivoBaja('motCese');
                } else {
                    Swal.fire({
                        title: 'Mensaje',
                        text: "Ingrese nuevamente su clave",
                        icon: 'warning',
                        confirmButtonColor: '#d33',
                        confirmButtonText: 'Cerrar'
                    });
                }
            }
        });
    }
    // DAR DE BAJA A USUARIO CON MOTIVO DE CESE
    function darBajaUsuario() {
        let codUser = $("#usuAMod").val();
        let motCese = $("#motCese").val();
        let fecCese = $("#fecCese").val();
        
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=darBajaUsuario',
            data: 'codUser=' + codUser + '&motCese=' + motCese + '&fecCese=' + fecCese,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    msjFinal(res[0],res[1]);             
                }else{
                    msjFinal(res[0],res[1]);
                }
//                if(resultado != null){
//                    msjExitoso('El usuario fue dado de baja!');
//                    cerrarModal("ceseUsuario");                    
//                }
            }, complete: function () {
            }
        });
    }
    // OBTENER LISTA DE MOTIVOS DE BAJA DE USUARIO 19/07/2022
    function listaMotivoBaja(mostrar) {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaMotivoBaja',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#" + mostrar).html(resultado);
            }, complete: function () {
                //msjExitoso('El usuario fue dado de baja!');
            }
        });
    }
    // TABLA _SIN _USO
    function listarUsuario(estado) {
        $("#tablaUsuarios").DataTable().destroy();
        $("#tablaUsuarios").DataTable({
            select: {
                style: 'single'
            }, "language": {
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningï¿½n dato disponible en esta tabla",
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
                "url": "../../../usuarioServlet?Accion=listarUsuarios",
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
    // SIN USO
    function editUsuario(codUsu, nunDoc) {
        window.location.href = "crearUsuario.jsp?param=" + nunDoc + "&param1=" + codUsu + "";
    }
    function asignarAreas(codUsuario) {
        let validator = $('#idAsignarCargo').validate();
        validator.destroy();
        codUser = codUsuario;
        $('#modalAsignarPeriodo').modal("show");
        listaCargosUsuario(codUser);
        listarAllAreas('#selectArea');
    }
    // ===== VALIDAR CAMPOS DE FORMULARIO ASGINAR CARGO
    function validarCamposCargo() {
        let validator = $("#idAsignarCargo").validate({
            rules: {
                selectArea: {required: true},
                selectCargo: {required: true}
            },
            messages: {
                selectArea: "Seleccione una area",
                selectCargo: "Seleccione un cargo"
            }
        });
        let estado = validator.form();
        if (estado) {
            asignarCargoUsuario();
        }
    }
    // ====== ASIGNAR CARGO AL USUARIO
    function asignarCargoUsuario() {
        let codCargo = $('#selectCargo').val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=asignarCargoUsuario',
            data: 'codUser=' + codUser + '&codCargo=' + codCargo,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
                let res = resultado.toString().split("_");
                if (res[0] == "1") {
                    msjFinal(res[0],res[1]);
                    listaCargosUsuario(codUser);
                }else{
                    msjFinal(res[0],res[1]);                    
                }
            }, complete: function () {
            }
        });
    }
    // LISTAR CARGOS ASIGNADOS AL USUARIO
    function listaCargosUsuario(codUser) {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaCargosUsuario',
            data: 'codUser=' + codUser,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (data) {
                console.log(data);
                tablaCargosUsuario.clear().draw();
                $.each(data,function (){        
                    let estado = this['estado'].toString();
                    let colorEstado = estado !== 'ACTIVO' ? "bg-danger text-white p-1 rounded-3" : "bg-success text-white p-1 rounded-3";
                    tablaCargosUsuario.row.add([
                        this['descArea'],
                        this['descPerfil'],
                        this['finicio'],
                        this['fcese'],
                        this['motivoCese'],
                        "<span class=\" "+colorEstado+ "\">" + this['estado'] + "</span>",
                        '<a class=\'pe-1\' href=\'#\' onclick=\"desactivarCargoUsuario('+ this['codUsuPerfil']+','+this['codigoUsuario']+','+this['codigoPerfil']+');\" title=\'Desactivar Cargo\'><i class=\'fas fa-trash-alt borrar\' ></i></a>'
                    ]).draw(false);;
                });
            }, complete: function () {
            }
        });
    }
    // DAR DE BAJA EL CARGO DEL USUARIO - 08/08/2022
    function desactivarCargoUsuario(codUserPerfil,codUser,codPerfil){
        let observacion = "nada";
        Swal.fire({
            title: 'Mensaje',
            text: "Desea dar de baja el cargo?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#28B779',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar!',
            confirmButtonText: 'Confirmar!'
        }).then(async (result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../../reHumanosServlet?Accion=desactivarCargoUsuario',
                    data: 'codUserPerfil=' + codUserPerfil + '&codUser=' + codUser + '&codPerfil=' + codPerfil+ '&observacion=' + observacion,
                    beforeSend: function () {
                    }, success: function (resultado) {
                        console.log(resultado);
                        let res = resultado.toString().split("_");
                        if(res[0] == 1){
                            msjFinal(res[0],res[1]); 
                            listaCargosUsuario(codUser);
                        }else{
                            msjFinal(res[0],res[1]);
                        }
                    }, complete: function () {
                    }
                });
            }    
        });
    }
    // LISTAR CARGOS ASIGNADOS AL USUARIO  => MODAL DETALLES
    function listaCargosUsuarioDetalle(codUser, listaCargo) {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaCargosUsuarioDetalle',
            data: 'codUser=' + codUser,
            beforeSend: function () {
            }, success: function (resultado) {
                $(listaCargo).html(resultado);
            }, complete: function () {
            }
        });
    }
    function darBajaExperienciaLab(codExperiencia){
        Swal.fire({
            title: 'Mensaje',
            text: "Desea dar de baja la experiencia?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#28B779',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar!',
            confirmButtonText: 'Confirmar!'
        }).then(async (result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../../reHumanosServlet?Accion=darBajaExperienciaLab',
                    data: 'codExperiencia=' + codExperiencia,
                    beforeSend: function () {
                    }, success: function (resultado) {
                        console.log(resultado);
                        let res = resultado.toString().split("_");
                        if(res[0] == 1){
                            msjFinal(res[0],res[1]);   
                            listaExperienciasLab(codUser);
                        }else{
                            msjFinal(res[0],res[1]);
                        }
                    }, complete: function () {
                    }
                });
            }
        });
    }
    // LISTAR EXPERIENCIAS DE USUARIO
    function listaExperienciasLab(codUsuario) {
        $.ajax({
            type: "POST",
            url: "../../reHumanosServlet?Accion=listaExperienciasLab",
            data: 'codUser=' + codUsuario,
            dataType: 'json',
            success: function (data) {
                console.log(data);
                let count = 0;
                tablaExperiencias.clear().draw();
                $.each(data, function () {
                    let fIni = this['finicio'].toString().split(" ");                
                    let fFin = this['fcese'].toString().split(" ");
                    count++;
                    tablaExperiencias.row.add([
                        count,
                        this['desPuesto'],
                        fIni[0] + " - " + fFin[0] ,
                        this['desEmpresa'],
                        '<a href=\'#\' onclick="darBajaExperienciaLab(\'' + this['codExperiencia'] + '\');\"><i class="fas fa-trash-alt borrar"></i></a>'
                        //'<button type="button" class="btn btn-success btn-edit" data-bs-toggle="modal" data-bs-target="#edit"><i class="fas fa-edit"></i></button>',
                    ]).draw(false);
                });
            }
        });
    }
    // LISTAR EMPRESAS LABORALES
    function listaEmpresaLab(empresa) {
        let empresas = [];
        //var {codPuesto, desPuesto} = p;
        $.ajax({
            type: "POST",
            url: "../../reHumanosServlet?Accion=listaEmpresaLab",
            data: '',
            success: function (data) {
                empresas = data.filter(pue =>
                    pue?.desEmpresa?.includes(empresa)
                );
                $('#resEmpresa').empty();
                if (empresas.length > 0) {
                    empresas.forEach((p) => {
                        if (p.desEmpresa.includes(empresa)) {
                            $('#resEmpresa').fadeIn(200).append(
                                    '<li class="nomEmpresa" onclick=\"seleccionarEmpresa(\'' + p.desEmpresa + '\');\">' + p.desEmpresa + '</li>'
                                    );
                        } else {
                            $('#resEmpresa').css('display', 'none');
                            console.log("no hay resultados!");
                        }
                    });
                }else {
                    $('#resEmpresa').css('display', 'none');
                    console.log("ingresa un caracter!");
                }
            }
        });
    }
    // LISTAR PUESTOS LABORALES
    function listarPuestoLab(puesto) {
        let puestos = [];
        $.ajax({
            type: "POST",
            url: "../../reHumanosServlet?Accion=listaPuestoLab",
            data: '',
            dataType: 'json',
            success: function (data) {
                puestos = data.filter(pue =>
                    pue?.desPuesto?.includes(puesto)
                );
                $('#suggestions').empty();
                if (puestos.length > 0) {
                    puestos.forEach((p) => {
                        if (p.desPuesto.includes(puesto)) {
                            $('#suggestions').fadeIn(200).append(
                                    '<li class="nomPuesto" onclick=\"seleccionarPuesto(\'' + p.desPuesto + '\');\">' + p.desPuesto + '</li>'
                                    );
                        } else {
                            $('#suggestions').css('display', 'none');
                            console.log("no hay resultados!");
                        }
                    });
                }else {
                    $('#suggestions').css('display', 'none');
                    console.log("ingresa un caracter!");
                }
                //Escribimos las sugerencias que nos manda la consulta
//                $('#suggestions').fadeIn(1000).html(data);
//                //Al hacer click en alguna de las sugerencias
//                $('.suggest-element').on('click', function () {
//                    //Obtenemos la id unica de la sugerencia pulsada
//                    var id = $(this).attr('id');
//                    //Editamos el valor del input con data de la sugerencia pulsada
//                    $('#buscar').val($('#' + id).attr('data'));
//                    //Hacemos desaparecer el resto de sugerencias
//                    $('#suggestions').fadeOut(1000);
//                    alert('Has seleccionado el ' + id + ' ' + $('#' + id).attr('data'));
//                    return false;
//                });
            }
        });
    }
    function seleccionarEmpresa(empresa) {
        $('#empresa').val(empresa);
        $('#resEmpresa').fadeOut(500);
    }
    function seleccionarPuesto(puesto) {
        $('#puesto').val(puesto);
        $('#suggestions').fadeOut(500);
    }
    /*  AUTO COMPLETADO PARA LA LISTA DE PUESTOS LABORALES*/
    $(document).ready(function () {
        $('#puesto').on('keyup', function () {
            var buscar = $(this).val();
            listarPuestoLab(buscar);
            //var dataString = 'buscar=' + buscar;
            //$('#suggestions').fadeIn(1000).html(data);
        });
    });
    /******AUTO COMPLETADO DE LAS EMPRESAS LABORALES PARA */
    $(document).ready(function () {
        $('#empresa').on('keyup', function () {
            var buscar = $(this).val();
            listaEmpresaLab(buscar);
        });
    });
    /********* LIMITAODR DE FECHA EN REGISTRO DE EXPERIENCIAS*/
    $(document).ready(function (){
       $('#fecFin').attr({
           "max": limitarFechaAyer(1)
       });
       $('#fecIni').attr({
           "max": limitarFechaAyer(15)
       });
    });
</script>

</html>