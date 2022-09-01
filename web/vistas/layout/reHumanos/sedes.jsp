<%-- 
    Document   : sedes.jsp
    Created on : 4 jul. 2022, 15:41:30
    Author     : yasubhr
--%>

<!DOCTYPE html>
<div class="container-fluid bg-white">
    <div class="card">
        <div class="card-body">
        <div class="d-flex gap-1 justify-content-between flex-wrap">
            <div class="col-md-5">
                <form class="d-flex my-2 my-lg-0 gap-3" id="formSucursalBuscar">
                    <input id="sedeBuscar" name="sedeBuscar" class="sedeBuscar form-control mr-sm-2 rounded" type="search" placeholder="ingrese nombre de sede">
                    <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoSedeBuscar(e);">BUSCAR</button>
                </form>
            </div>
            <div class="d-flex align-items-center">
                <button class="btn btn-success text-white " onclick="modalNew();">AÑADIR NUEVO</button>            
            </div>        
        </div>
        <hr>
        <h4 class="card-title">LISTA SEDES</h4>
        <!--table-bordered-->
        <table id="tablaSucursales" class="table table-striped " width="100%" autocomplete="off">
            <thead>
                <tr>
                    <th>NOMBRE DE SEDE</th>
                    <th>TELEFONO</th>
                    <th>EMAIL</th>
                    <th>DIRECCION</th>
                    <th>CIUDAD</th>
                    <th>ESTADO</th>
                    <th>OPCIONES</th>
                </tr>
            </thead>
            <!--<tbody id="listSucursales">-->
            <tbody>

            </tbody>
        </table>
        </div>
    </div>
</div>
<!-- Modal AGREGAR SUCURSAL -->
<div class="modal fade " id="modalNuevo" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModal"></h5>
                <button type="button" class="btn-close bg-white" data-dismiss="modal" aria-label="Close" onclick="closeNuevo();">
                </button>
            </div>
            <div class="modal-body">
                <form id="formSucursal">
                    <div class="form row">
                        <div class="form-group col-md-4">
                            <label for="name" class="form-label">NOMBRE:</label>
                            <input type="text" class="form-control rounded-lg inputForm" id="name" name="nombre" placeholder="NOMBRE SEDE"/>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="phone" class="form-label">TELEFONO:</label>
                            <input type="text" class="form-control rounded-lg inputForm" id="phone" name="phone" 
                                   placeholder="TELEFONO SEDE" maxlength="9"/>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="email" class="form-label">EMAIL:</label>
                            <input type="email" class="form-control rounded-lg inputForm" id="email" name="email" placeholder="EMAIL SEDE"/>
                        </div>
                    </div>
                    <div class="form row">
                        <div class="form-group col-md-4"">
                            <label for="selectDpto" class="form-label">SELECCIONE DEPARTAMENTO:</label>
                            <select class="form-control rounded-lg selectForm" id="selectDpto" name="selectDpto">
                            </select>
                        </div>
                        <div class="form-group col-md-4"">
                            <label for="selectProv" class="form-label">SELECCIONE PROVINCIA:</label>
                            <select class="form-control rounded-lg selectForm" id="selectProv" name="selectProv">
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="selectDisto" class="form-label">SELECCIONE DISTRITO:</label>
                            <select class="form-control rounded-lg selectForm" id="selectDisto" name="selectDisto">
                            </select>
                        </div>
                    </div>
                    <div class="form row">
                        <div class="form-group col-md-8">
                            <label for="address" class="form-label">DIRECCION:</label>
                            <input class="form-control rounded-lg inputForm" id="address" name="address" placeholder="INGRESE DIRECCION DE SEDE"/>                            
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-dismiss="modal" onclick="closeNuevo();">CANCELAR</button>
                <button type="button" class="btn-guardar btn btn-success text-white" onclick="validarCamposSucursal();">GUARDAR</button>
                <button type="button" class="btn-actualizar btn btn-success text-white hide" onclick="validarCamposSucursal();">ACTUALIZAR</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal AGREGAR AREAS -->
<div class="modal fade" id="modalAreas" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleAreas"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="form row" id="formAreaSucursal">
                    <div class="form-group col-md-6"">
                        <select class="form-control rounded-lg" id="selectArea" name="selectArea">
                        </select>
                    </div>
                    <div class="form-group col-5">
                        <button type="button" class="btn btn-success col-md-8 text-white" onclick="validarCampoAreaSede();">AGREGAR</button>
                    </div>
                </form>
            </div>
            <div class="table-responsive px-3">
                <table id="tablaAreasSucursal" class="table table-striped table-bordered" width="100%" autocomplete="off">
                    <thead>
                        <tr>
                            <th>NOMBRE DE AREA</th>
                            <th>ESTADO</th>
                            <th>OPCIONES</th>
                        </tr>
                    </thead>
                    <tbody >

                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal AGREGAR USUARIO A SEDE -->
<div class="modal fade" id="modalUsuarioSede" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleUsuario"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form row">
                    <form class="form-group col-md-8" id="formUsuariosSede" >
                        <label for="selectUsuarios" class="form-label">SELECCIONE USUARIO:</label>
                        <select class="form-control rounded-lg text-dark" 
                                name="selectUsuarios" id="selectUsuarios" style="width: 100%;">
                        </select>
                    </form>
                    <div class="form-group col-md-4 col-sm-12 text-center pt-md-4 pt-sm-0">
                        <button type="button" class="btn btn-success col-md-8 text-white" onclick="validarSedeUsuario();">AGREGAR</button>
                    </div>
                </div>
            </div>
            <div class="table-responsive px-3">
                <table id="tablaUsuariosSucursal" class="table table-striped table-bordered" width="100%" autocomplete="off">
                    <thead>
                        <tr>
                            <th>NOMBRE</th>
                            <th>APE. PATERNO</th>
                            <th>APE. MATERNO</th>
                            <th>CARGO</th>
                            <th>OPCION</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
            </div>
        </div>
    </div>
</div>

<script>
//    var codSede = '';
//    let updateSede = false;
//    var allUsuarios;
//    var allSucursales;
//    let tablaSucursales;
//    let tablaUsuariosSucursal;
    $(document).ready(async function () {
        tablaSucursales = $('#tablaSucursales').DataTable({
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
        tablaUsuariosSucursal = $('#tablaUsuariosSucursal').DataTable({
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
        tablaAreasSucursal = $('#tablaAreasSucursal').DataTable({
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
        listarSucursales();
        $('#selectDpto').change(function () {
            let codDpto = this.value;
            listaProvincias(codDpto);
        });
        $('#selectProv').change(function () {
            let codProv = this.value;
            let codDpto = $('#selectDpto').val();
            listaDistritos(codDpto, codProv);
        });
        $('#selectUsuarios').select2({
            dropdownParent: $('#modalUsuarioSede'),
            width: 'resolve'
        });
        $('#sedeBuscar').keydown(function (e){ 
            if(e.keyCode === 13){
                e.preventDefault();
                buscarSucursal();
            }
        });
        // INGRESA SOLO NUMEROS EN CAMPO CELULAR
        $('#phone').on('input', function (){
            this.value = this.value.replace(/[^0-9]/g,'');
        });
        $.validator.addMethod("inputTrim", function(value, element, param){
            if (value.replace(/[^0-9]/g,'') || value.replace(/^[^-_#'"\\\/<>=*@&]*$/,'')) {
            return false;
            }
            return this.optional(element) || value.trim().length > 0;
        });
        $.validator.addMethod("inputTrimAddress", function(value, element, param){
            return this.optional(element) || value.trim().length > 0;
        });
    });
    function modalNew() {
        updateSede = false;
        $("#modalNuevo").modal("show");
        $('.btn-actualizar').addClass('hide');
        $('.btn-guardar').removeClass('hide');
        let validarError = $('#formSucursal').validate();
        validarError.destroy(); 
        $('#formSucursal').trigger("reset");
        
        listaDepartamentos();
        $('#titleModal').html("REGISTRAR SEDE");
    }
    function closeNuevo() {
        $("#modalNuevo").modal("hide");
    }
    function listarAreasSede(codSede){
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listarAreasSede',
            data: 'codSede='+codSede,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selectArea").html(resultado);
            }, complete: function () {
            }
        });
    }
    function listaAreasSucursal(codSede) {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaAreasSucursal',
            data: 'codSede='+codSede,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                llenarAreasSucursal(resultado, codSede);
            }, complete: function () {
            }
        });
    }
    function llenarAreasSucursal(data,codSede){
        console.log(data);
        tablaAreasSucursal.clear().draw();
        $.each(data,function (){        
            let estado = this['estado'].toString();
            let colorEstado = estado !== 'ACTIVO' ? "bg-danger text-white p-1 rounded-3" : "bg-success text-white p-1 rounded-3";
            tablaAreasSucursal.row.add([
                this['descArea'],
                "<span class=\" "+colorEstado+ "\">" + this['estado'] + "</span>",
                '<a class=\'pe-1\' href=\'#\' onclick=\"desactivarAreaSucursal('+codSede+','+this['codigoArea']+');\" title=\'Desactivar Área\'><i class=\'fas fa-trash-alt borrar\' ></i></a>'
            ]).draw(false);
        });
    }
    function listaUsuariosSucursal(codSede) {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaUsuariosSucursal',
            data: 'codSucursal='+codSede,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                llenarUsuariosSucursal(resultado,codSede);
                //
            }, complete: function () {
            }
        });
    }
    // LISTAR CARGOS ASIGNADOS AL USUARIO
    function llenarUsuariosSucursal(data, codSede) {
        console.log(data);
        tablaUsuariosSucursal.clear().draw();
        $.each(data,function (){    
            tablaUsuariosSucursal.row.add([
                this['nombreUsuario'],
                this['apePaternoUsuario'],
                this['apeMaternoUsuario'],
                this['descPerfil'],
                '<a class=\'pe-1\' href=\'#\' onclick=\"bajaUsuarioSucursal('+codSede+','+this['codigoUsuario']+');\" title=\'Desactivar Usuario\'><i class=\'fas fa-trash-alt borrar\' ></i></a>'
            ]).draw(false);;
        });
    }
    // DAR BAJA USUARIO DE SUCURSAL
    function bajaUsuarioSucursal(codSucursal, codUsuario){
        Swal.fire({
            title: 'Mensaje',
            text: "Desea remover al usuario de la sede?",
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
                    url: '../../reHumanosServlet?Accion=bajaUsuarioSucursal',
                    data: 'codSucursal=' + codSucursal + '&codUsuario=' + codUsuario,
                    beforeSend: function () {
                    }, success: function (resultado) {
                        console.log(resultado);
                        let res = resultado.toString().split("_");
                        if(res[0] == 1){
                            msjFinal(res[0],res[1]);	               
                            listaUsuariosSucursal(codSucursal);
                        }else{
                            msjFinal(res[0],res[1]);
                        }
                    }, complete: function () {
                    }
                });
            }
        });
    }
    function desactivarAreaSucursal(codSucursal,codArea){
        Swal.fire({
            title: 'Mensaje',
            text: "Desea dar de baja el área?",
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
                    url: '../../reHumanosServlet?Accion=desactivarAreaSucursal',
                    data: 'codSucursal=' + codSucursal + '&codArea=' + codArea,
                    beforeSend: function () {
                    }, success: function (resultado) {
                        console.log(resultado);
                        let res = resultado.toString().split("_");
                        if(res[0] === '1'){
                            msjFinal(res[0],res[1]);	               
                            listaAreasSucursal(codSede);
                        }else{
                            msjFinal(res[0],res[1]);
                        }
                    }, complete: function () {
                    }
                });
            }
        });
    };
    function agregarUsuario(codSucursal, nombreSede){        
        $('#titleUsuario').text("ASIGNAR USUARIO - "+ nombreSede);
        let validator = $('#formUsuariosSede').validate();
        validator.destroy();
        $('#modalUsuarioSede').modal('show');
        codSede = codSucursal;
        listarUsuarios();
        listaUsuariosSucursal(codSede);
    }
    // LLENAR SELECT USUARIOS
    function llenarSelectUsuarios(data){
        $('#selectUsuarios').empty();
        $('#selectUsuarios').append($('<option/>',{
               text:''
        }));
        data.forEach(user => {
            let apmaterno = user.apeMaternoUsuario;
            let appaterno = user.apePaternoUsuario;
            let nombre = user.nombreUsuario;
           $('#selectUsuarios').append($('<option/>',{
               text: nombre.concat(''+appaterno).concat(''+apmaterno),
               value: user.codigoUsuario
           }));
        });
    }
    // OBTENER LISTA DE USUARIOS 30/07/2022
    function listarUsuarios() {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaUsuarios',
            data: '',
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                allUsuarios = resultado;
                llenarSelectUsuarios(allUsuarios);
                //$("#selectUsuarios").html(resultado);
            }, complete: function () {
            }
        });
    }
    function validarSedeUsuario() {
        let validator = $("#formUsuariosSede").validate({
            rules: {
                selectUsuarios: {required: true}
            },
            messages: {
                selectUsuarios: "Seleccione un usuario validado"
            }
        });
        let estado = validator.form();
        if (estado) {
            registroSedeUsuario();
        }
    }
    // REGISTRAR USUARIO A SEDE
    function registroSedeUsuario(){
        let codUser = $('#selectUsuarios').val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=registroSedeUsuario',
            data: 'codUser=' + codUser + '&codSede=' + codSede,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    msjFinal(res[0],res[1]);
                    console.log(resultado);	
                    $("#selectArea").val('');
                    listaUsuariosSucursal(codSede);
                    
                }else{
                    msjFinal(res[0],res[1]);
                }
            }, complete: function () {
                listaAreasSucursal(codSede);
            }
        });
    }
    function validarCampoAreaSede() {
        let validator = $("#formAreaSucursal").validate({
            rules: {
                selectArea: {required: true}
            },
            messages: {
                selectArea: "Seleccione una area"
            }
        });
        let estado = validator.form();
        if (estado) {
            agregarAreasSucursal();
        }
    }
    var agregarAreasSucursal = () => {
        let codArea = $('#selectArea').val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=agregarAreasSucursal',
            data: 'codSucursal=' + codSede + '&codArea=' + codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    msjFinal(res[0],res[1]);            
                }else{
                    msjFinal(res[0],res[1]);
                }
            }, complete: function () {
                listarAreasSede(codSede);
                listaAreasSucursal(codSede);
            }
        });
    };
    var asginarAreas = (codigoSede, nombreSede) => {
        $('#titleAreas').text("ASIGNAR AREAS - " +nombreSede);
        codSede = codigoSede;
        $("#modalAreas").modal("show");
        listarAreasSede(codSede);
        listaAreasSucursal(codSede);
    };
    // LISTA DE DEPARTAMENTOS
    var listaDepartamentos = async () => {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaDepartamentos',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $('#selectDpto').html(resultado);
                console.log("LISTA DE DEPARTAMENTOS---");
            }, complete: function () {
            }
        });
    };
    // LISTA DE PROVINCIAS
    var listaProvincias = async (codDpto) => {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaProvincias',
            data: 'codDpto=' + codDpto,
            beforeSend: function () {
            }, success: function (resultado) {
                $('#selectProv').html(resultado);
                console.log("LISTA DE Provincias---");
            }, complete: function () {

            }
        });
    };
    // LISTA DE DISTRITOS
    var listaDistritos = async (codDpto, codProv) => {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaDistritos',
            data: 'codDpto=' + codDpto + '&codProv=' + codProv,
            beforeSend: function () {
            }, success: function (resultado) {
                $('#selectDisto').html(resultado);
            }, complete: function () {
            }
        });
    };
    // LISTA DE SUCURSALES
    var listarSucursales = () => {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaSucursales',
            data: '',
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                allSucursales = resultado;
                llenarTablaSucursales(resultado);
//                $('#listSucursales').html(resultado);
            }, complete: function () {
            }
        });
    };
    function llenarTablaSucursales(data){
        tablaSucursales.clear().draw();
        $.each(data, function () {
            let estado = this['estado'].toString();
            let tipoSede = this['tipoSucursal'].toString();
            let colorEstado = estado !== 'ACTIVO' ? "bg-danger text-white p-1 rounded-3" : "bg-success text-white p-1 rounded-3";
            let principal = tipoSede !== '0' ? '<i class=\'fas fa-star text-warning\'></i>' : '';
            tablaSucursales.row.add([
                principal+ this['desSucursal'],
                this['telefono'],
                this['email'],
                this['direccion'],
                this['ciudad'],
                "<span class=\" "+colorEstado+ "\">" + this['estado'] + "</span>",
                '<a class=\'pe-1\' href=\'#\' onclick=\"editSucursal('+ this['codSucursal'] + ',\''+ this['desSucursal'] + '\',\'' + this['telefono'] 
                    +'\',\'' + this['email'] + '\',\'' + this['direccion'] + '\',\'' + this['codigoDepartamento'] + '\',\'' + this['codigoProvincia'] 
                    + '\',\'' + this['codigoDistrito'] +'\');\" title=\'Editar Sucursal\'><i class=\'fas fa-edit editar\' ></i></a>'
            
                + '<a class=\'pe-1\' href=\'#\' onclick=\"asginarAreas(' + this['codSucursal'] +',\''+ this['desSucursal'] + '\');\" title=\'Asginar Áreas\'><i class=\'far fa-address-card otras-opciones\' ></i></a>'
                + '<a class=\'pe-1\' href=\'#\' onclick=\"agregarUsuario(' + this['codSucursal'] +',\''+ this['desSucursal'] + '\');\"><i class=\"fas fa-user-plus\" title=\'agregar Usuario\'></i></a>'
                + '<a class=\'pe-1\' href=\'#\' onclick=\"deleteSucursal(' + this['codSucursal'] + ');\"><i class=\'fas fa-trash-alt borrar\'  title=\'Desactivar Sucursal\'></i></a>'
//                '<button type="button" class="btn btn-warning btn-delete" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i></button>'
            ]).draw(false);
        });
    }
    // BUSCA USUARIO;
    function buscarSucursal(){  
        let buscar = $('#sedeBuscar').val(); 
        console.log(allSucursales);
        console.log(buscar);
        let sucursal = allSucursales.filter( e => 
                    e?.desSucursal?.includes(buscar)
                );
        console.log(sucursal);
        llenarTablaSucursales(sucursal);
    }
    //VALIDAR CAMPO DE BUSQUEDA DE EMPLEADO / USUARIO;
    function validarCampoSedeBuscar(e){
        e.preventDefault();
        let validator = $("#formSucursalBuscar").validate({
            rules: {
                sedeBuscar: {required: true}
            },
            messages: {
                sedeBuscar: "Ingrese la sucursal"
            }
        });
        let estado = validator.form();
        if (estado) {
            buscarSucursal();
        }
    }
    // DAR DE BAJA SUCURSAL
    var deleteSucursal = async (cod) => {
        Swal.fire({
            title: 'Mensaje',
            text: "Se asignara los usuarios a la sede principal?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#28B779',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar!',
            confirmButtonText: 'Confirmar!'
        }).then(async (result) => {
            if (result.isConfirmed) {
                await $.ajax({
                    type: 'POST',
                    url: '../../reHumanosServlet?Accion=deleteSucursal',
                    data: 'cod=' + cod,
                    beforeSend: function () {
                    }, success: function (data) {
                        let res = data.toString().split("_");
                        console.log(data);
                        if(res[0] == 1){
                            msjFinal(res[0],res[1]);              
                        }else{
                            msjFinal(res[0],res[1]);
                        }
                    }, complete: function () {
                        listarSucursales();
                    }
                });
            }
        });
    };
    var actualizarSucursal = async () => {
        let nomSede = $('#name').val();
        let telefono = $('#phone').val();
        let email = $('#email').val();
        let dpto = $('#selectDpto').val();
        let prov = $('#selectProv').val();
        let dist = $('#selectDisto').val();
        let direc = $('#address').val();

        let data = 'codSede=' + codSede + '&nomSede=' + nomSede + '&telefono=' + telefono + '&email=' + email
                + '&dpto=' + dpto + '&prov=' + prov + '&dist=' + dist + '&direc=' + direc;
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=actualizarSucursal',
            data: data,
            beforeSend: function () {
            }, success: function (resultado) {
                console.log(resultado);
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    console.log("------- Se actualizo ------");
                    $("#modalNuevo").modal("hide");
                    $('.btn-guardar').toggleClass('hide');
                    $('.btn-actualizar').toggleClass('hide');
                    msjFinal(res[0],res[1]);	             
                }else{
                    msjFinal(res[0],res[1]);
                }
                
            }, complete: function () {
                listarSucursales();
            }
        });
    };
    var editSucursal = async (cod, nombre, telef, email, direc, codDep, codPro, codDis) => {
        let validator = $('#formSucursal').validate();
        validator.destroy();
        updateSede = true;
        $('.btn-guardar').addClass('hide');
        $('.btn-actualizar').removeClass('hide');
        console.log(nombre);
        codSede = cod;
        $("#modalNuevo").modal("show");
        $('#name').val(nombre);
        $('#phone').val(telef);
        $('#email').val(email);
        await listaDepartamentos();
        $('#selectDpto').val(codDep);
        await listaProvincias(codDep);
        $('#selectProv').val(codPro);
        await listaDistritos(codDep, codPro);
        $('#selectDisto').val(codDis);
        $('#address').val(direc);
        $('#titleModal').html("EDITAR SEDE");
    };
    // VALIDAR CAMPOS DE AGREGAR SUCURSAL
    function validarCamposSucursal(){
        let validator = $('#formSucursal').validate({
            rules:{
                nombre: {
                    required: true,
                    inputTrim: true
                },
                phone: {required: true},
                email: {required: true},
                selectDpto: {required: true},
                selectProv: {required: true},
                selectDisto: {required: true},
                address: {
                    required: true,
                    inputTrimAddress: true
                }
            },
            messages:{
                nombre: {
                    required: "Ingrese el nombre",
                    inputTrim: "Ingrese un nombre valido"
                },
                phone: "Ingrese el número",
                email: "Ingrese el email",
                selectDpto: "Seleccione el departamento",
                selectProv: "Seleccione el departamento",
                selectDisto: "Seleccione el distrito",
                address: {
                    required: "Ingrese la dirección",
                    inputTrimAddress: "Ingrese una dirección valida"
                }
            }
        });
        let estado = validator.form();
        if (estado) {
            if (!updateSede) {                
                newSucursal();                
            }else{
                actualizarSucursal();
            }
        }else {
            console.log("LLENA LOS CAMPOS");
        }

    }
    var newSucursal = () => {
        let name = $('#name').val();
        let phone = $('#phone').val();
        let email = $('#email').val();
        let selectDpto = $('#selectDpto').val();
        let selectProv = $('#selectProv').val();
        let selectDisto = $('#selectDisto').val();
        let address = $('#address').val();

        let data = 'nombre=' + name + '&telefono=' + phone + '&email=' + email
                + '&dpto=' + selectDpto + '&prov=' + selectProv + '&dist=' + selectDisto + '&direccion=' + address;

        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=guardarSucursal',
            data: data,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    msjFinal(res[0],res[1]);
                    console.log("------- Todo bien ------");
                    console.log(resultado);	
                    $("#modalNuevo").modal("hide");        
                }else{
                    msjFinal(res[0],res[1]);
                }
            }, complete: function () {
                listarSucursales();
            }
        });
    };   
</script>