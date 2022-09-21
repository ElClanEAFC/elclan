<%-- 
    Document   : index
    Created on : 05/08/2021, 09:33:20 AM
    Author     : bcondori
--%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-body">
                    <!--ENCABEZADO SEARCH-->
                    <!------formulario--->
                    <div
                         >
                        <h3>DATOS DEL USUARIO</h3>
                        <p><br></p>
                        <form id="formRegistroUsuario" class="">
                            <div class="row">
                                <div class="col-3">
                                    <label for="usuTDoc">TIPO DE DOCUMENTO *</label>
                                    <select id="usuTDoc" name="usuTDoc" class=" form-control" >
                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="usuNumDoc">Nª DOCUMENTO *</label>
                                    <input id="usuNumDoc" name="usuNumDoc" type="text" maxlength="8"
                                           class="form-control" onkeypress="soloNumeros(event);" onkeyup="buscarDOI(this.value);" onchange="" > 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <label for="usuNombre">NOMBRES *</label>
                                    <input id="usuNombre" name="usuNombre" type="text" class=" form-control datos" > 
                                </div>
                                <div class="col-4">
                                    <label for="usuApaterno">APELLIDO PATERNO *</label>
                                    <input id="usuApaterno" name="usuApaterno" type="text" class=" form-control datos" >  
                                </div>
                                <div class="col-4">
                                    <label for="usuAmaterno">APELLIDO MATERNO *</label>
                                    <input id="usuAmaterno" name="usuAmaterno" type="text" class=" form-control datos" >
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <label for="usuCelular">CELULAR *</label>
                                    <input id="usuCelular" name="usuCelular" type="text" class=" form-control datos datoEdita" maxlength="9">  
                                </div>
                                <div class="col-4">
                                    <label for="usuCorreo">CORREO *</label>
                                    <input id="usuCorreo" name="usuCorreo" type="email" class=" form-control datos datoEdita" required="" > 
                                </div>
                                <div class="col-4">
                                    <label for="usuDireccion">DIRECCION *</label>
                                    <input id="usuDireccion" name="usuDireccion" type="text" class=" form-control datos datoEdita" >  
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-3">
                                    <label for="usuPais">PAIS *</label>
                                    <select name="usuPais" id="usuPais" class="form-control datos datoEdita" >
                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="usuDpto">DEPARTAMENTO *</label>
                                    <select name="usuDpto" id="usuDpto" class=" form-control datos datoEdita" onchange="listarProv();" >
                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="usuProv">PROVINCIA *</label>
                                    <select name="usuProv" id="usuProv" class=" form-control datos datoEdita" onchange="listarDist();" >
                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="usuDist">DISTRITO *</label>
                                    <select name="usuDist" id="usuDist" class=" form-control datos datoEdita" >
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-3">
                                    <label for="usuArea">SUCURSAL *</label>
                                    <select name="usuSucursal" id="usuSucursal" class="form-control datos datoEdita"  onchange="listarAreasSede();">
                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="usuArea">ÁREA *</label>
                                    <select name="usuArea" id="usuArea" class=" form-control datos"  onchange="listarPerfil();">
                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="usuCargo">CARGO / PUESTO *</label>
                                    <select name="usuCargo" id="usuCargo" class="form-control datos"  >

                                    </select>
                                </div>
                                <div class="col-3">
                                    <label for="usuFNacimiento">FECHA NACIMIENTO *</label>
                                    <input id="usuFNacimiento" name="usuFNacimiento" type="date" class="form-control datos datoEdita" > 
                                </div>
                                <div class="col-3">
                                    <label for="usuFinicio">FECHA INGRESO *</label>
                                    <input id="usuFinicio" max="9999-12-31" name="usuFinicio" type="date" class=" form-control datos" > 
                                </div>
                            </div>
                            <hr>
                        </form> 
                            <div class="footer">
                            <button class="btn btn-danger btn-lg text-white" onclick="limpiarCampo();">CANCELAR</button>
                            <button class="btn btn-success btn-lg text-white" onclick="validarCamposUsu();" id="btnGuardarUsuario">GUARDAR</button>
                            <button class="btn btn-success btn-lg text-white hide" onclick="validarCamposUsu();" id="btnActualizarUsuario">ACTUALIZAR</button>
                            <!--<input class="submit" type="submit" value="SUBMIT">-->
                        </div>   
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal Perfil Existente en DB-->
<div class="modal fade" id="modalPerfilExiste" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-dark" id="exampleModalLabel">MENSAJE</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p id="exitoso">

                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary " id="btnActulizarInfo" data-bs-dismiss="modal">ACTUALIZAR</button>
                <button type="button" class="btn btn-success text-white" id="btnAsignarPeriodo">ASIGNAR NUEVO PERIODO LABORAL</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal Asignar Periodo Laboral  en DB-->
<div class="modal fade" id="modalAsignarPeriodo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header bg-danger ">
                <h5 class="modal-title text-white" id="exampleModalLabel">ASIGNAR CARGO AL NUEVO PERIODO LABORAL</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body modal-lg">
                <div class="row">
                    <form id="idAsignarCargo" class="row col-lg-8">
                        <div class="form-group col-lg-6">
                            <div class="d-flex gap-2">
                                <label for="selectArea">AREA</label>
                                <div class="flex-grow-1">
                                    <select class="form-control" id="selectArea" name="selectArea">

                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-lg-6">
                            <div class="d-flex gap-2">
                                <label for="selectCargo">CARGOS:</label>
                                <div class="flex-grow-1">
                                    <select class="form-control" id="selectCargo" name="selectCargo">

                                    </select>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="form-group col-lg-4">
                        <div class="d-flex gap-2 justify-content-center">
                            <button type="button" class="btn btn-success text-white" onclick="validarCamposCargo();">Agregar</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 container-fluid">
                <h4 class="card-title">LISTA DE CARGOS </h4>
                <div class="table-responsive">
                    <table id="tablaCargosUsuario" class="table  table-bordered " width="100%" autocomplete="off">
                        <thead>
                            <tr>
                                <th>AREA</th>
                                <th>PERMISOS</th>
                                <th>F. INICIO </th>
                                <th>F. CESE</th>
                                <th>MOTIVO CESE</th>
                                <th>ESTADO</th>
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
<!-- ===========footer ============================================= -->

<script>
//
    $(document).ready(function () {
        cargaPrincipal();
        cargarTipoDoc();
        $("input").on("keypress", function () {
            $input = $(this);
            UpperCaseInput($input);
        });
        $('#usuFNacimiento').attr(
                limitarAnioEdad(18)
        );
        $('#usuFinicio').attr(
                limitarFechaAyerManana(7,7)
        );
      // ======= VALIDACION GENERAL CAMPO VACIO =======
        $.validator.addMethod("inputTrim", function(value, element, param){
            return this.optional(element) || value.trim().length > 0;
        });
        
        $('#usuTDoc').change(function () {
            var cod = this.value;
            if (cod === '1') {
                $('#usuNumDoc').attr({
                    "maxlength": 8    // values (or variables) here
                });
            } else if (cod === '3' || cod === '4') {
                $('#usuNumDoc').attr({
                    "maxlength": 12    // values (or variables) here
                });
            }
        });
        // INGRESA SOLO NUMEROS EN CAMPO DNI
        $('#usuNumDoc').on('input', function (){
            this.value = this.value.replace(/[^0-9]/g,'');
        });
        // INGRESA SOLO NUMEROS EN CAMPO CELULAR
        $('#usuCelular').on('input', function (){
            this.value = this.value.replace(/[^0-9]/g,'');
        });
        $('#usuArea').change(function () {
            var codArea = this.value;
            llenarSelectCargos(codArea, '#usuCargo');
        });
        $('#selectArea').change(function () {
            var codArea = this.value;
            llenarSelectCargos(codArea, '#selectCargo');
        });
        $('#usuDpto').change(function () {
            let codDpto = this.value;
            listaProvincias(codDpto);
        });
        $('#usuProv').change(function () {
            let codProv = this.value;
            let codDpto = $('#usuDpto').val();
            listaDistritos(codDpto, codProv);
        });
        // MUESTRA EL MODAL PARA ASIGNAR NUEVO PERIODO
        $('#btnAsignarPeriodo').click(function () {
            $('#modalAsignarPeriodo').modal('show');
            listarAllAreas('#selectArea');
            //LISTA DE CARGOS ASIGNADOS
            listaCargosUsuario();
        });
        // HABILITA LOS INPUTS PARA LA EDICIÓN DEL USUARIO
        $('#btnActulizarInfo').click(function () {
            $('#btnActualizarUsuario').removeClass('hide');
            $('input.datoEdita').attr('disabled', false);
            $('select.datoEdita').attr('disabled', false);
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
    });
    function cargaPrincipal(){
        $('#usuNombre').attr('readonly',true);
        $('#usuApaterno').attr('readonly',true);
        $('#usuAmaterno').attr('readonly',true);
        
    }
    function listarAreasSede(){
        var codSede = $("#usuSucursal").val();
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaAreasSucursal',
            data: 'codSede=' + codSede,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (data) {
                $('#usuArea').empty();
                $('#usuArea').append($('<option/>',{
                        value: "nada"
                    }));
                $.each(data, function(i, s){
                    $('#usuArea').append($('<option/>',{
                        value: s.codigoArea ,
                        text: s.descArea
                    }));
                });
//                $("#usuProv").html(resultado);
            }, complete: function () {
            }
        });
    }
    // LISTA DE SUCURSALES
    var listarSucursales = async () => {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaSucursales',
            data: '',
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                $('#usuSucursal').empty();
                llenarSelectSucursales(resultado);
            }, complete: function () {
            }
        });
    };
    function llenarSelectSucursales(data){
        $.each(data, function(i, s){
            $('#usuSucursal').append($('<option/>',{
                value: s.codSucursal ,
                text: s.desSucursal
            }));
        });
    }
    // LISTAR CARGOS ASIGNADOS AL USUARIO
    function listaCargosUsuario(){
        let codUsuario = codUser;
        
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaCargosUsuario',
            data: 'codUser=' + codUsuario,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (data) {
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
                        "<span class=\" "+colorEstado+ "\">" + this['estado'] + "</span>"                        
                    ]).draw(false);;
                });
            }, complete: function () {
            }
        });
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
                //msjFinal(res[0],res[1]);
                if(res[0]){
                    $('#selectCargo').val('');
                    msjFinal(res[0],res[1]);	              
                    listaCargosUsuario();
                }else{
                    msjFinal(res[0],res[1]);
                }
            }, complete: function () {
            }
        });
    }
    function llenarSelectCargos(codArea, idCargoSelect) {
        $.ajax({
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
    // ====== Buscar DNI EN BASE DE DATOS  Y  RENIEC
    async function buscarDOI() {
        var codTDoc = $('#usuTDoc option:selected').val();
        var numDoc = $('#usuNumDoc').val();
        if (numDoc.toString().length === 8 && codTDoc === '1') {
            //alert("DNI VALIDO");

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
                        //$('.datos').attr('readonly',true);
                        let validarErrorForm = $("#formRegistroUsuario").validate();
                        validarErrorForm.destroy();
                        validarReniec = false;
                        validarDB = true;
                        await listaDepartamentos();
                        await listaProvincias(res.codigoDepartamento);
                        await listaDistritos(res.codigoDepartamento, res.codigoProvincia);
                        await listarSucursales();
                        await listaPaises();
                        llenarCamposUsuario(res);
                        //validarCamposUsu();
                        $('.datos').attr("disabled", true);
                        if (!$('#btnGuardarUsuario').hasClass("hide")) {
                            $('#btnGuardarUsuario').addClass('hide');
                        }
                        if (!$('#btnActualizarUsuario').hasClass("hide")) {
                            $('#btnActualizarUsuario').addClass('hide');
                        }
                        //$('#btnActualizarUsuario').removeClass('hide');
                        $('#exitoso').html(res.mensaje);
                        $('#modalPerfilExiste').modal('show');
                        console.log("Usuario ya registrado");
                    } else {
//                        $('.datos').attr('readonly', false);
//                        $('.datos').attr("disabled", false);
                        let userreniec = {"dni": numDoc};
                        //FUNCION BUSCAR EN API-RENIEC
                        buscarReniec(userreniec);
                    }
                    //$("#result").html(resultado);
                }, complete: function () {
//                var val = $("#valDNI").val();
//                if (val === "1") {
//                    var datos = $("#valDatos").val();
//                    var codUser = $("#valCodUsu").val();
//                    Swal.fire({
//                        title: 'Mensaje',
//                        html:
//                                'El numero de documento ya se encuetra registrado: <br>' +
//                                '<b>' + datos + '</b>',
//                        showDenyButton: true,
//                        showCancelButton: true,
//                        confirmButtonText: 'Editar Datos',
//                        confirmButtonColor: '#2255A4',
//                        cancelButtonColor: '#E06E4D',
//                        denyButtonText: 'registrar nuevo periodo',
//                        denyButtonColor: '#48C28D'
//                    }).then((result) => {
//
//                        if (result.isConfirmed) {
//
//                            editarUsuario(codUser, usuNumDoc);
//                        } else if (result.isDenied) {
//                            asignarNuevoPeriodo(codUser);
//                        } else if (result.dismiss === 'cancel') {
//                            limpiarCampo();
//                        }
//                    });
//                    limpiarCampo();
//                    $("input").addAttr('disabled');
//                    $("select").addAttr('disabled');
//                    $("button").addAttr('disabled');
//                } else {
//                    $("input").removeAttr('disabled');
//                    $("select").removeAttr('disabled');
//                    $("button").removeAttr('disabled');
//                }
                }
            });
        }else{
            $('#usuNombre').val('');
            $('#usuApaterno').val('');
            $('#usuAmaterno').val('');
            $('.datos').val('');
        }
    }
    //
    function mostrarDatosEnSelect(id, dato) {
        $(id).empty();
        $(id).prepend($('<option/>', {
            text: dato
        }));
    }
    // ==== funcion llenar inputs con datos de BASE DE DATOS
    var llenarCamposUsuario = (data) => {
        codUser = data.codigoUsuario;
        $('#usuNombre').val(data.nombreUsuario);
        $('#usuApaterno').val(data.apePaternoUsuario);
        $('#usuAmaterno').val(data.apeMaternoUsuario);
        $('#usuCelular').val(data.telefono);
        $('#usuCorreo').val(data.email);
        $('#usuDireccion').val(data.direccion);
        $('#usuPais').val(data.codigoPais);
        $('#usuDpto').val(data.codigoDepartamento);
        $('#usuProv').val(data.codigoProvincia);
        $('#usuDist').val(data.codigoDistrito);
//        mostrarDatosEnSelect('#usuDpto', data.descDepartamento);
//        mostrarDatosEnSelect('#usuProv', data.descProvincia);
//        mostrarDatosEnSelect('#usuDist', data.descDistrito);
        $('#usuSucursal').val(data.codSucursal);
        mostrarDatosEnSelect('#usuArea', data.descArea);
        mostrarDatosEnSelect('#usuCargo', data.descPerfil);
        $('#usuFNacimiento').val(data.fechaNacimiento);
        $('#usuFinicio').val(data.finicio);
    };
    // ==== funcion llenar inputs con datos de RENIEC
    var llenarDatosUsuarioReniec = (data) => {
        $('#usuNombre').val(data.nombres);
        $('#usuApaterno').val(data.paterno);
        $('#usuAmaterno').val(data.materno);
        $('.datos').attr("disabled", false);
    };
    // ==== funcion BUSQUEDA DE DATOS MEDIANTE DNI 
    async function buscarReniec(userreniec) {
        
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
                    if (!$('#btnActualizarUsuario').hasClass("hide")) {
                        $('#btnActualizarUsuario').addClass('hide');
                    }
                    if ($('#btnGuardarUsuario').hasClass('hide')) {
                        $('#btnGuardarUsuario').removeClass('hide');
                    }
                    let validarErrorForm = $("#formRegistroUsuario").validate();
                    validarErrorForm.destroy();
                    validarDB = false;
                    validarReniec = true;
                    limpiarCampoReniec();
                    console.log(res.result);
                    llenarDatosUsuarioReniec(res.result);
                    listaPaises();
                    listaDepartamentos();
                    listarSucursales();
                    $("#usuDist").html("");
                    $("#usuProv").html("");
                    $('#usuArea').empty();
                    $("#usuCargo").html("");
                } else if (res.success === false) {
                    console.log("NADA"); 
                }
            }, complete: function () {

            }
        });
    } 
    // SIN USO
    function asignarNuevoPeriodo(codUser) {
        //alert("Nuevo: "+codUser);
    }
    // SIN USO
    function editarUsuario(codUser, dni) {
        //alert("dni: "+dni)
        $.ajax({
            type: 'POST',
            url: '../../../usuarioServlet?Accion=editarUsu',
            data: 'codUsuario=' + codUser,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#result").html(resultado);
                $("input").removeAttr('disabled');
                $("select").removeAttr('disabled');
                $("button").removeAttr('disabled');
                $("#usuArea").attr('disabled', true);
                $("#usuCargo").attr('disabled', true);
                $("#usuFinicio").attr('disabled', true);
                $("#usuArea").attr('disabled', true);
                //alert(resultado);
            }, complete: function () {
                var nombre = $("#edNombre").val();
                var apaterno = $("#edApaterno").val();
                var aMaterno = $("#edAmaterno").val();
                var celular = $("#edCelular").val();
                var correo = $("#edCorreo").val();
                var direccion = $("#edDireccion").val();
                var codPais = $("#edCodPais").val();
                var desPais = $("#edDesPais").val();
                var codDpto = $("#edCodDpto").val();
                var desDpto = $("#edDesDpto").val();
                var codProv = $("#edCodProv").val();
                var desProv = $("#edDesProv").val();
                var codDist = $("#edCodDist").val();
                var desDist = $("#edDesDist").val();
                var fnacimiento = $("#edFNacimiento").val();
                //alert(desDpto);
                $("#usuNumDoc").val(dni);
                $("#usuNombre").val(nombre);
                $("#usuApaterno").val(apaterno);
                $("#usuAmaterno").val(aMaterno);
                $("#usuCelular").val(celular);
                $("#usuCorreo").val(correo);
                $("#usuDireccion").val(direccion);
                $("#usuPais").prepend("<option value='" + codPais + "' selected='selected'>" + desPais + "</option>");
                $("#usuDpto").prepend("<option value='" + codDpto + "' selected='selected'>" + desDpto + "</option>");
                $("#usuProv").prepend("<option value='" + codProv + "' selected='selected'>" + desProv + "</option>");
                $("#usuDist").prepend("<option value='" + codDist + "' selected='selected'>" + desDist + "</option>");
                $("#usuFinicio").val();
                $("#usuFNacimiento").val(fnacimiento);
                $("#btnUsuarios").attr("onclick", "modificarUser()");
                $("#btnUsuarios").html('Modificar');
                $("#usuNumDoc").attr("readonly", true);
            }
        });
    }
    // ==== funcion ACTUALIZAR INFOMACION DE USUARIO EXISTENTE
    function actualizarUsuario() {
        //validarCamposUsu();
        //alert('mod:');
        var codUsuario = codUser;
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
        var usuSucursal = $("#usuSucursal").val();
        var usuFNac = $("#usuFNacimiento").val();
        var param = 'codUsuario=' + codUsuario + '&usuNombre=' + usuNombre + '&usuApaterno=' + usuApaterno + '&usuAmaterno=' + usuAmaterno + '&codTDoc=' + codTDoc + '&numDoc=' + numDoc + '&codPais=' + codPais +
                '&codDpto=' + codDpto + '&codProv=' + codProv + '&codDist=' + codDist + '&usuCelular=' + usuCelular + '&usuCorreo=' + usuCorreo + '&usuDirec=' + usuDirec+ '&usuSucursal=' + usuSucursal + '&usuFNac=' + usuFNac;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=actualizarUsuarios',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                //$("#result").html(resultado);
                //alert(resultado);
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    msjFinal(res[0],res[1]);  
                    console.log(resultado);
                    $('#btnGuardarUsuario').removeClass('hide');
                    $('#btnActualizarUsuario').addClass('hide');
                    //console.log("ACTUALIZADO");                
    //              $("#formRegistroPreVenta")[0].reset();
                    $('#formRegistroUsuario').trigger("reset");	
                    $("#formRegistroUsuario select.datos").val('');                
                }else{
                    msjFinal(res[0],res[1]);
                }
//                $(':input').not(':button, :submit, :reset, :hidden, :checkbox, :radio').val(''); 
//                $(':checkbox, :radio').prop('checked', false);
                

            }, complete: function () {
            }
        });
    }
    // ==== funcion OBTENER LISTA DE PAISES
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
    // ===== VALIDAR CAMPOS DE FORMULARIO USUARIO
    function validarCamposUsu() {
        let validator = $("#formRegistroUsuario").validate({
            rules: {
                usuNumDoc: {required: true},
                usuNombre: {required: true},
                usuApaterno: {required: true},
                usuAmaterno: {required: true},
                usuCelular: {
                    required: true,
                    inputTrim: true
                },
                usuCorreo: {required: true},
                usuDireccion: {
                    required: true,
                    inputTrim: true
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
                    required: "Ingrese N° celular.",
                    inputTrim: "Ingrese un celular valido"
                },
                usuCorreo: "Ingrese Correo",
                usuDireccion: { 
                    required: "Ingrese Direccion",
                    inputTrim: "Ingrese una dirección valida"
                },
                usuPais: "Seleccione Pais",
                usuDpto: "Seleccione Departamento",
                usuProv: "Seleccione Provincia",
                usuDist: "Seleccione Distrito",
                usuArea: "Seleccione Area",
                usuCargo: "Seleccione Cargo",
                usuFNacimiento: "Ingrese Fecha de nacimiento",
                usuFinicio: "Ingrese Fecha inicio"
            }
        });
        let estado = validator.form();
        if (estado) {
            if (validarReniec) {
                crearUsuario();
            } else if (validarDB) {
                actualizarUsuario();
            }
        }
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
    // === LIMPIAR CAMPOS CUANDO EL CAMPO DNI ES MENOR A 8 (DIGITOS)
    function limpiarCampo() {
        //$("#formRegistroPreVenta")[0].reset();
//        $(":input[]",'#formRegistroPreVenta').each(function() {
        $("#usuNumDoc").val('');
        $('input.datos').val('');
        $("select.datos").val('');
        //$("#usuTDoc option[value='1']").attr("selected", true);
//        $("input").addAttr('disabled');
//        $("select").addAttr('disabled');
//        $("button").addAttr('disabled');
    };    
    // ===== LIMPIAR CAMPOS ====
    function limpiarCampoReniec(){
        $('input.datos').val('');
        $("select.datos").val('');
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
        var usuSucursal = $("#usuSucursal").val();
        var usuArea = $("#usuArea").val();
        var usuCargo = $("#usuCargo").val();
        var usuFinicio = $("#usuFinicio").val();
        var usuFNacimiento = $("#usuFNacimiento").val();
        var param = 'codTDoc=' + usuTDoc + '&usuNumDoc=' + usuNumDoc + '&usuNombre=' +
                usuNombre + '&usuApaterno=' + usuApaterno + '&usuAmaterno=' + usuAmaterno + '&usuCelular=' +
                usuCelular + '&usuCorreo=' + usuCorreo + '&usuDireccion=' + usuDireccion + '&codPais=' + usuPais + '&codDpto=' + usuDpto +
                '&codProv=' + usuProv + '&codDist=' + usuDist + '&usuSucursal=' + usuSucursal+ '&codArea=' + usuArea +
                '&codCargo=' + usuCargo + '&usuFinicio=' + usuFinicio + '&usuFNacimiento=' + usuFNacimiento;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=guardarUsuarios',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                //$("#mensaje").html(resultado);
                console.log("El resultado es: " + resultado);
                let res = resultado.toString().split("_");
                if(res[0] == 1){
                    msjFinal(res[0],res[1]);  
                    console.log(resultado);
                    $('#formRegistroUsuario').trigger("reset");	
                    $("#formRegistroUsuario select.datos").val('');                
                }else{
                    msjFinal(res[0],res[1]);
                }
                
            }, complete: function () {
            }
        });
        console.log(usuFNacimiento);
        console.log(usuFinicio);
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
    // ===== LISTAR AREAS =====
    function listarAllAreas(idAreaSelect) {
        $.ajax({
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

    function agregarUsuario() {
        $('#modalAgregarUsuario').modal('show');
    }
    /****************************************
     *       Basic Table                   *
     ****************************************/
    //$('#tablaUsuarios').DataTable();
    function fconMayusculas(field) {
        field.value = field.value.toUpperCase();
    }

    function soloNumeros(e) {
        var charCode = (e.which) ? e.which : e.keyCode;
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