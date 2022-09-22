<%-- 
    Document   : organigrama
    Created on : 9 set. 2022, 19:43:22
    Author     : sistemas03
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- ESTILO PARA LA ESTRUCTURA DE ORGANIZACION-->
<!--<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">-->
<link href="../assets/libs/chartOrg/Themes/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" />
<script  src="../assets/libs/chartOrg/js/jquery-1.10.2.js"/></script>    
<script type="text/javascript">
</script>
<!--css-->
<link rel="stylesheet" type="text/css" href="../assets/libs/chartOrg/css/jHTree.css "/>
<!--js-->

<!--<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>-->

<script src="../assets/libs/chartOrg/js/jquery-ui-1.10.4.custom.min.js"/></script>   
<script src="../assets/libs/chartOrg/js/jQuery.jHTree.js"/></script>  

<div class="tab-pane fade show active" id="nav-organigrama" role="tabpanel" aria-labelledby="nav-organigrama-tab" tabindex="0">
    <div class="row">       
        <div class="col-md-12" >
            <div class="d-flex gap-1 justify-content-between flex-wrap align-items-end">
                <div class="col-md-5 d-flex gap-3 align-items-end">
                    <form class="my-lg-0 gap-3 col-md-9" id="formEquipoBuscarOrga">
                        <div class="">
                            <div class="d-flex gap-3">
                                <div>
                                    <label for="selectUnidadEquipo" class="form-label">SELECCIONE UNIDAD:</label>
                                    <select class="form-control rounded-lg text-dark" 
                                            name="selectUnidadEquipo" id="selectUnidadEquipo" style="width: 100%;">
                                    </select>
                                </div>
                                <div>
                                    <label for="selectEquipoOrg" class="form-label">SELECCIONE EQUIPO:</label>
                                    <select  id="selectEquipoOrg" name="selectEquipoOrg" 
                                             class="fform-control rounded-lg text-dark" style="width: 100%;">       
                                    </select>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="">
                        <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoEquipoBuscarOrga();" type="button">BUSCAR</button>
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <button class="btn btn-success my-sm-0 text-white"  onclick="vistaEquipos();"
                            id="btntitleVista" >IR A EQUIPOS
                    </button>
                </div>
                <div class="d-flex align-items-center">
                    <button class="btn btn-success my-sm-0 text-white" onclick="abrirNuevoCargo();">AÑADIR NUEVO</button>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <h4 class="card-title">LISTA DE EQUIPOS</h4>
    <div class="col-12 row gap-1 gap-sm-3">        
        <div class="col-md-7">
            <table id="tablaEquiposOrg" class="table table-striped" width="100%" autocomplete="off">
                <thead>
                    <tr>
                        <th>EQUIPO</th>
                        <th>CARGO</th>
                        <th>NIVEL JERARQUICO</th>
                        <th>ESTADO</th>
                        <th>OPCIONES</th>
                    </tr>
                </thead>                    
                <tbody>
                </tbody>
            </table>
        </div>
        <div class="col-md-4 d-flex justify-content-center">
            <!--<h5>CUADRO DE ORGANIGRAMA DEL </h5>-->
            <div id="tree"> 

            </div>
        </div>
    </div>
    <!----------------------- CHART ORGANIZATION ------------------->

</div>
<!-- MODAL AGREGAR NUEVO CARGO  A LA ESTRUCTURA DEL EQUIPO -->
<div class="modal fade " id="modalNuevoCargo" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModalNuevoCargoEstructura">
                    REGISTRAR CARGO AL EQUIPO
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" >
                </button>
            </div>
            <div class="modal-body">
                <form method="post" id="formNuevoCargo">
                    <div class="form row">
                        <div  class="form-group col-md-3"></div>
                        <div class="form-group col-md-6">
                            <div class="col-12">
                                <label for="selectCargo" >SELECCIONAR CARGO</label>                                                          
                                <select class="form-control rounded-lg text-dark" 
                                        name="selectCargo" id="selectCargo">
                                </select>
                            </div>
                            <div class="col-12">
                                <label for="numOrden" class="form-label">SELECCIONE NIVEL JERARQUICO:</label>
                                <input type="number" min="1" max="10" id="numOrden" name="numOrden" class="form-control rounded-lg" />  
                            </div>
                        </div>
                        <div  class="form-group col-md-3"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
                <button type="button" class="btn btn-success text-white" id="btnGuardarCargo" onclick="validarCamposCargoOrga();">GUARDAR</button>
                <button type="button" class="btn btn-success text-white hide" id="btnActualizarCargo" onclick="validarCamposCargoOrga();">ACTUALIZAR</button>
            </div>
            <div class="content-loader visually-hidden" id="ico-loader">
                <div class="loader">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- MODAL ASIGNAR CARGO -->
<div class="modal fade " id="modalAsignarCargo" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModalAsignarCargo">
                    ASGINAR CARGO
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" >
                </button>
            </div>
            <div class="modal-body">
                <form method="post" id="formAsignarCargo">
                    <div class="form row">
                        <div  class="form-group col-md-3"></div>
                        <div class="form-group col-md-6">
                            <label for="selectPersonal" class="form-label">SELECCIONE PERSONAL :</label>
                            <select  id="selectPersonal" name="selectPersonal" 
                                     class="fform-control rounded-lg text-dark" style="width: 100%;">   
                            </select>
                            <label for="selectFecha" class="form-label">SELECCIONE FECHA:</label>
                            <input class="form-control rounded-lg text-dark" type="date"
                                   name="selectFecha" id="selectFecha">
                            </input>
                        </div>
                        <div  class="form-group col-md-3"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
                <button type="button" class="btn btn-success text-white" id="btnGuardarAsginarCargo" onclick="validarAsignarCargo();">GUARDAR</button>
                <!--                <button type="button" class="btn btn-success text-white hide" id="btnActualizarUnidad" onclick="validarNuevaUnidad();">ACTUALIZAR</button>-->
            </div>
            <div class="content-loader visually-hidden" id="ico-loader">
                <div class="loader">
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $1 = jQuery.noConflict(true);
    var addCodEquipo;
    var updateCodEstruc;
    var updateCargo = false;
    var codEstructura;

    $(document).ready(function () {
        // CODNICIUONAL PARA VISUALIZAR ORGANIGRAMAS
        // 
//        if (vistaOrgEquipo) {
//            $('#btntitleVista').attr('onClick', "vistaEquipos();");
//            $('#btntitleVista').text("IR A EQUIPOS");
//        } else if (vistaOrgUnidad) {
//            $('#btntitleVista').attr('onClick', "vistaUnidades();");
//            $('#btntitleVista').text("IR A UNIDADES");
//        }
        /**************************************************/
        $('#selectEquipoOrg').select2({
            width: 'resolve'
        });
        $('#selectUnidadEquipo').select2({
            width: 'resolve'
        });
        $('#selectPersonal').select2({
            width: 'resolve'
        });
        tablaEquiposOrg = $('#tablaEquiposOrg').DataTable({
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
                select: {rows: ""}
            }
        });
        //--------------------------------
//        listarSelectEquiposOrg();
        listarSelectUnidadesEquiposOrg();
        //listarEstructuraEquipos();
        $('#selectEquipoOrg').change(function () {
            addCodEquipo = this.value;
        });
        $('#selectUnidadEquipo').change(function () {
            listarSelectEquiposOrg(0, this.value);
        });
    });

    $1(document).ready(function () {
        $1(function () {
//            $1("#tree").jHTree({
//                callType: 'url',
//                url: '../assets/libs/chartOrg/data/myJsonFile.json',
//                nodeDropComplete: function (event, data) {
//                    //----- Do Something @ Server side or client side -----------
//                    //alert("Node ID: " + data.nodeId + " Parent Node ID: " + data.parentNodeId);
//                    //-----------------------------------------------------------
//                }
//            });
//            $1("#tree").jHTree({
//                callType: 'obj',
//                structureObj: jsonStructureObject
//             });
        });
    });

    function abrirNuevoCargo() {
        let codEquipo = $('#selectEquipoOrg').val();
        if (codEquipo >= 1) {
            updateCargo = false;
            $('#titleModalNuevoCargoEstructura').text("CREAR NUEVA ESTRUCTURA DE EQUIPO");
            $('#btnActualizarCargo').addClass('hide');
            $('#btnGuardarCargo').removeClass('hide');
            listarPerfilesComer();
            // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
            let validarErrorForm = $("#formNuevoCargo").validate();
            validarErrorForm.destroy();
            $('#modalNuevoCargo').modal("show");
        } else {
            Swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'Seleccione un Equipo',
                showConfirmButton: false,
                timer: 2000
            })
        }
    }

    //LISTA DE CARGO DE AREA COMERCIAL
    async function listarPerfilesComer() {
        await $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarPerfilesComer",
            data: "",
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listPerfilesComer; // LISTA DE CARGOS DE AREA COMERCIAL
                llenarSelectCargos(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
    // LISTA DE EQUIPOS PARA LLENAR SELECT
    function listarSelectEquiposOrg(codEquipo = "0", codUnidad = "0") {
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarEquipos",
            data: "codEquipo=" + codEquipo + "&codUnidad=" + codUnidad,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listEquipos; // LISTA DE UNIDADES
                llenarSelectEquiposOrg(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
    // LLENAR SELECT EQUIPOS ORG
    function llenarSelectEquiposOrg(data) {
        $('#selectEquipoOrg').empty();
        $('#selectEquipoOrg').append($('<option/>', {
            text: 'TODOS',
            value: '0'
        }));
        data.forEach(equipo => {
            $('#selectEquipoOrg').append($('<option/>', {
                text: equipo?.v_desUnidad + ' - ' + equipo.v_desEquipo,
                value: equipo.v_codEquipo
            }));
        });
    }

    // LISTAR UNIDADES PARA LLENAR EL SELECT
    function listarSelectUnidadesEquiposOrg(codUnidad = "0") {
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarUnidades",
            data: "codUnidad=" + codUnidad,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listUnidades;  // LSITA DE UNIDADES
                llenarSelectUnidadesOrg(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    // LLENAR SELECT DE UNIDADES
    function llenarSelectUnidadesOrg(data) {
        $('#selectUnidadEquipo').empty();
        $('#selectUnidadEquipo').append($('<option/>', {
            text: 'TODOS',
            value: '0'
        }));
        data?.forEach(uni => {
            $('#selectUnidadEquipo').append($('<option/>', {
                text: uni?.v_desUnidad,
                value: uni?.v_codUnidad
            }));
        });
    }

    // VALIDAR CAMPO DE BUSQUEDA DE EQUIPO ORGANIGRAMA
    function validarCampoEquipoBuscarOrga() {
        let validator = $("#formEquipoBuscarOrga").validate({
            rules: {
                selectEquipoOrg: {required: true}
            },
            messages: {
                selectEquipoOrg: "Seleccione un equipo"
            }
        });
        let estado = validator.form();
        if (estado) {
            let codEquipo = $("#selectEquipoOrg").val();
            listarEstructuraEquipos(codEquipo);
        }
    }

    // LLENAR SELECT CARGOS 
    function llenarSelectCargos(data) {
        $('#selectCargo').empty();
        $('#selectCargo').append($('<option/>', {
            text: ''
        }));
        data.forEach(equipo => {
            $('#selectCargo').append($('<option/>', {
                text: equipo.v_desPerfil,
                value: equipo.v_codPerfil
            }));
        });
    }
    // (AUTO Y BUSQUEDA) OBTENER UNA UNICA ESTRUCTURA DE EQUIPO 
    function listarEstructuraEquipos(codEquipo = "0") {
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarEstructuraEquipos",
            data: "codEquipo=" + codEquipo,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listEstrucutraEquipos; // LISTA 
                llenarTablaEstructuraEquipos(data);
                llenarOrganizadorEquipo(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
    // (AUTO y BUSQUEDA) LLENAR TABLA DE ESTRUCTURAS
    function llenarTablaEstructuraEquipos(data) {
        tablaEquiposOrg.clear().draw();
        $.each(data, function () {
            tablaEquiposOrg.row.add([
                this['v_desEquipo'],
                this['v_desPerfil'],
                this['v_numOrden'],
                this['v_estado'],
                '<a class=\'pe-1\' href=\'#\' onclick=\"listarEstructuraEquipoDatos(' + this['v_codEstructura'] + ',\'' + this['v_desEquipo'] + '\');\" title=\'Editar Equipo\' ><i class=\'fas fa-edit editar\'  ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' onclick=\"asginarCargo(' + this['v_codPerfil'] + ',' + this['v_codUnidad'] + ',' + this['v_codEquipo'] + ',' + this['v_codEstructura'] + ');\" title=\'Asginar Cargo\'><i class=\'far fa-address-card otras-opciones\' ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' onclick=\"darbajaEstructuraEquipo(' + this['v_codEstructura'] + ',\'' + this['v_codEquipo'] + '\');\" title=\'Dar de Baja Equipo\' ><i class=\'fas fa-trash-alt borrar\'  ></i></a>'
            ]).draw(false);
        });
    }

    function llenarOrganizadorEquipo(data) {
        $("div").remove('.zmrcntr');
        $("#tree").empty();
        let estructuraObj = [
            {
                "head": data[0]?.v_desPerfil,
                "id": data[0]?.v_numOrden,
                "contents": "el jefe",
                "children": [
                    {
                        "head": data[1]?.v_desPerfil,
                        "id": data[1]?.v_numOrden,
                        "contents": "el ejecutivo"
                    }
                ]
            }
        ];
        $1("#tree").jHTree({
            callType: 'obj',
            structureObj: estructuraObj
        });
    }
    // VALIDAR CAMPOS PARA REGISTRAR CARGO
    function validarCamposCargoOrga() {
        let validator = $("#formNuevoCargo").validate({
            rules: {
                selectCargo: {required: true},
                numOrden: {required: true}
            },
            messages: {
                selectCargo: "Seleccione un  cargo",
                numOrden: "Seleccione un número"
            }
        });
        let estado = validator.form();
        if (estado) {
            if (!updateCargo) {
                registrarEstructuraEquipo();
            } else {
                actualizarEstructuraEquipo();
            }
        }
    }
    // REGISTRAR CARGO A ESTRUCTURA DE EQUIPO
    function registrarEstructuraEquipo() {
        let codPerfil = $('#selectCargo').val();
        let numOrden = $('#numOrden').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=registrarEstructuraEquipo",
            data: "codEquipo=" + addCodEquipo + "&codPerfil=" + codPerfil + "&numOrden=" + numOrden,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $('#formNuevoCargo').trigger("reset");
                    // LISTAR EQUIPOS EN LA TABLA Y SELECT D
                    listarEstructuraEquipos(addCodEquipo);
                    $('#modalNuevoCargo').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }
    // OBTNER LISTA DE DATOIS DE UN CARGO DE ESTRUCTURA
    async function listarEstructuraEquipoDatos(codEstructura, desEquipo) {
        await $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarEstructuraEquipoDatos",
            data: "codEstructura=" + codEstructura,
            dataType: 'json',
            success: async function (data, textStatus, jqXHR) {
                console.log(data);
                data = data.listEstrucutraEquipoDatos; // LISTA DE DATOS DE UN CARGO DE ESTRUCTURA
                await llenarFormCargoEstructura(data, desEquipo);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
    // LLENAR FORM CON DATOS DE CARGO DE UNA ESTRUCTURA
    async function llenarFormCargoEstructura(data, desEquipo) {
        updateCargo = true;
        updateCodEstruc = data?.v_codEstructura;
        addCodEquipo = data?.v_codEquipo;
        console.log(data);
        $('#titleModalNuevoCargoEstructura').text("EDITAR CARGO DE " + desEquipo);
        await listarPerfilesComer();
        $('#selectCargo').val(data?.v_codPerfil);
        $('#numOrden').val(data?.v_numOrden);
        $('#btnGuardarCargo').addClass('hide');
        $('#btnActualizarCargo').removeClass('hide');
        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
        let validarErrorForm = $("#formNuevoCargo").validate();
        validarErrorForm.destroy();
        $('#modalNuevoCargo').modal("show");
    }
    // ACTUALIZAR CARGO DE ESTRUCTURA DE UN EQUIPO
    function actualizarEstructuraEquipo() {
        let codPerfil = $('#selectCargo').val();
        let numOrden = $('#numOrden').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=actualizarEstructuraEquipo",
            data: "codEstructura=" + updateCodEstruc + "&codPerfil=" + codPerfil + "&numOrden=" + numOrden,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $('#formNuevoCargo').trigger("reset");
                    // LISTAR EQUIPOS EN LA TABLA Y SELECT D
                    listarEstructuraEquipos(addCodEquipo);
                    //DESHABILITAR ACTUALIZACION DE CARGO
                    updateCargo = false;
                    $('#modalNuevoCargo').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }

    function asginarCargo(codPerfil, codUnidad, codEquipo, sendCodEstructura) {
        $('#modalAsignarCargo').modal('show');
        codEstructura = sendCodEstructura;
        listarVendSinCargo(codPerfil, codUnidad, codEquipo);
    }

    function validarAsignarCargo() {
        let validator = $('#formAsignarCargo').validate({
            rules: {
                selectPersonal: {required: true},
                selectFecha: {required: true}
            },
            messages: {
                selectPersonal: "Seleccione un  cargo",
                selectFecha: "Seleccione una fecha"
            }
        });
        let estado = validator.form();
        if (estado) {
            guardarVendEstruc();
        }
    }
    // LISTAR VENDEDORES SIN CARGO
    function listarVendSinCargo(codPerfil, codUnidad, codEquipo) {
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarVendSinCargo",
            data: "codPerfil=" + codPerfil + "&codUnidad=" + codUnidad + "&codEquipo=" + codEquipo,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listVendedoresSinCargo; // LISTA DE VENDEDORES SIN CARGO
                llenarSelectAsignarCargo(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    function llenarSelectAsignarCargo(data) {
        $('#selectPersonal').empty();
        $('#selectPersonal').append($('<option/>', {
            text: ''
        }));
        data.forEach(vende => {
            $('#selectPersonal').append($('<option/>', {
                text: vende.v_usuario + " " + vende.v_apellidoPaterno + " " + vende.v_apellidoMaterno,
                value: vende.v_cod_Vendedor
            }));
        });
    }

    //REGISTRAR CARGO ASIGNADO 
    function guardarVendEstruc() {
        let codVendedor = $('#selectPersonal').val();
        let fecInicio = $('#selectFecha').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=guardarVendEstruc",
            data: "codVendedor=" + codVendedor + "&codEstructura=" + codEstructura + "&fecInicio=" + fecInicio,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $('#formAsignarCargo').trigger("reset");
                    $('#modalNuevoCargo').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    // DAR DE BAJA EL CARGO DE LA ESTRUCTURA DEL EQUIPO
    function darbajaEstructuraEquipo(codEstructura, codEquipo) {
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
                    url: '../../reHumanosServlet?Accion=darbajaEstructuraEquipo',
                    data: 'codEstructura=' + codEstructura,
                    beforeSend: function () {
                    }, success: function (resultado) {
                        console.log(resultado);
                        let res = resultado.toString().split("_");
                        if (res[0] == 1) {
                            msjFinal(res[0], res[1]);
                            listarEstructuraEquipos(codEquipo);
                        } else {
                            msjFinal(res[0], res[1]);
                        }
                    }, complete: function () {
                    }
                });
            }
        });
    }

</script>
