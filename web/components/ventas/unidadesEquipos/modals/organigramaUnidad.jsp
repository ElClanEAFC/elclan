<%-- 
    Document   : organigramaUnidad
    Created on : 20 set. 2022, 15:37:02
    Author     : sistemas03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- ESTILO Y JS PARA LA ESTRUCTURA DE ORGANIZACION-->
<link href="../assets/libs/chartOrg/Themes/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" />
<script  src="../assets/libs/chartOrg/js/jquery-1.10.2.js"/></script>    
<script type="text/javascript">
</script>
<!--css-->
<link rel="stylesheet" type="text/css" href="../assets/libs/chartOrg/css/jHTree.css "/>
<!--js-->
<script src="../assets/libs/chartOrg/js/jquery-ui-1.10.4.custom.min.js"/></script>   
<script src="../assets/libs/chartOrg/js/jQuery.jHTree.js"/></script>  

<div class="tab-pane fade show active" id="nav-organigramaUnidad" role="tabpanel" aria-labelledby="nav-organigramaUnidad-tab" tabindex="0">
    <div class="row">       
        <div class="col-md-12" >
            <div class="d-flex gap-1 justify-content-between flex-wrap align-items-end">
                <div class="col-md-5 d-flex gap-3 align-items-end">
                    <form class="my-lg-0 gap-3 col-md-6" id="formUnidadBuscarOrga">
                        <div class="">
                            <div class=" gap-3">
                                <label for="c" class="form-label">SELECCIONE UNIDAD:</label>
                                <select  id="selectUnidadOrg" name="selectUnidadOrg" 
                                         class="fform-control rounded-lg text-dark" style="width: 100%;">   
                                </select>
                            </div>
                        </div>
                    </form>
                    <div class="">
                        <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoUnidadBuscarOrga();" type="button">BUSCAR</button>
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <button class="btn btn-success my-sm-0 text-white"  onclick="vistaUnidades();"
                            id="btntitleVista" >IR A UNIDADES
                    </button>
                </div>
                <div class="d-flex align-items-center">
                    <button class="btn btn-success my-sm-0 text-white" onclick="abrirNuevoCargo();">AÑADIR NUEVO</button>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <h4 class="card-title">LISTA DE UNIDADES</h4>
    <div class="col-12 row gap-1 gap-sm-3">        
        <div class="col-md-7">
            <table id="tablaUnidadesOrg" class="table table-striped" width="100%" autocomplete="off">
                <thead>
                    <tr>
                        <th>UNIDAD</th>
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

<!-- MODAL AGREGAR NUEVO CARGO  A LA ESTRUCTURA DE LA UNIDAD -->
<div class="modal fade " id="modalNuevoCargo" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModalNuevoCargoEstructura">
                    REGISTRAR CARGO A LA UNIDAD
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
    var addCodUnidad;
    var updateCodEstruc;
    var updateCargo = false;
    var codEstructura;

    $(document).ready(function () {
        // CODNICIUONAL PARA VISUALIZAR ORGANIGRAMAS
//        if (vistaOrgEquipo) {
//            $('#btntitleVista').attr('onClick', "vistaEquipos();");
//            $('#btntitleVista').text("IR A EQUIPOS");
//        } else if (vistaOrgUnidad) {
//            $('#btntitleVista').attr('onClick', "vistaUnidades();");
//            $('#btntitleVista').text("IR A UNIDADES");
//        }
        /**************************************************/
        $('#selectUnidadOrg').select2({
            width: 'resolve'
        });
        $('#selectPersonal').select2({
            width: 'resolve'
        });
        tablaUnidadesOrg = $('#tablaUnidadesOrg').DataTable({
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
        listarUnidadesOrg();
        //listarEstructuraEquipos();
        $('#selectUnidadOrg').change(function () {
            addCodUnidad = this.value;
        });
    });

    // ABRIR MODAL DE AGREGAR CARGO A LA UNIDAD
    function abrirNuevoCargo() {
        let codEquipo = $('#selectUnidadOrg').val();
        if (codEquipo >= 1) {
            updateCargo = false;
            $('#titleModalNuevoCargoEstructura').text("CREAR NUEVA ESTRUCTURA DE UNIDAD");
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
                title: 'Seleccione una Unidad',
                showConfirmButton: false,
                timer: 2000
            })
        }
    }

    //LISTA DE CARGOS DEL AREA COMERCIAL
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

    // LISTAR UNIDADES PARA EL SELECT
    function listarUnidadesOrg(codUnidad = "0") {
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
        $('#selectUnidadOrg').empty();
        $('#selectUnidadOrg').append($('<option/>', {
            text: ''
        }));
        data?.forEach(uni => {
            $('#selectUnidadOrg').append($('<option/>', {
                text: uni?.v_desUnidad,
                value: uni?.v_codUnidad
            }));
        });
    }

    // VALIDAR CAMPO DE BUSQUEDA DE EQUIPO ORGANIGRAMA
    function validarCampoUnidadBuscarOrga() {
        let validator = $("#formUnidadBuscarOrga").validate({
            rules: {
                selectUnidadOrg: {required: true}
            },
            messages: {
                selectUnidadOrg: "Seleccione una unidad"
            }
        });
        let estado = validator.form();
        if (estado) {
            let codUnidad = $("#selectUnidadOrg").val();
            listarEstructuraUnidades(codUnidad);
        }
    }

    // (AUTO Y BUSQUEDA) OBTENER UNA UNICA ESTRUCTURA DE UNIDAD 
    function listarEstructuraUnidades(codUnidad = 0) {
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarEstructuraUnidades",
            data: "codUnidad=" + codUnidad,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data; // LISTA 
                llenarTablaEstructuraUnidades(data);
                llenarOrganizadorUnidad(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    // (AUTO y BUSQUEDA) LLENAR TABLA DE ESTRUCTURAS PARA UNIDADES
    function llenarTablaEstructuraUnidades(data) {
        tablaUnidadesOrg.clear().draw();
        $.each(data, function () {
            tablaUnidadesOrg.row.add([
                this['v_desUnidad'],
                this['v_desPerfil'],
                this['v_numOrden'],
                this['v_estado'],
                '<a class=\'pe-1\' href=\'#\' onclick=\"listarEstructuraUnidadDatos(' + this['v_codEstructura'] + ',\'' + this['v_desUnidad'] + '\');\" title=\'Editar Unidad\' ><i class=\'fas fa-edit editar\'  ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' onclick=\"asginarCargoUnidad(' + this['v_codPerfil'] + ',' + 0 + ',' + 0 + ',' + this['v_codEstructura'] + ');\" title=\'Asginar Cargo\'><i class=\'far fa-address-card otras-opciones\' ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' onclick=\"darbajaEstructuraUnidad(' + this['v_codEstructura'] + ',\'' + this['v_codUnidad'] + '\');\" title=\'Dar de Baja Cargo de Unidad\' ><i class=\'fas fa-trash-alt borrar\'  ></i></a>'
            ]).draw(false);
        });
    }

    //  CREAR Y LLENAR  DIAGRAMA DE UNIDAD
    function llenarOrganizadorUnidad(data) {
        console.log(data);
        $("div").remove('.zmrcntr');
        $("#tree").empty();
        let estructuraObj = [
            {
                "head": data[0]?.v_desPerfil,
                "id": data[0]?.v_numOrden,
                "contents": 'Firts name',
                "children": [
//                    {
//                        "head": data[1]?.v_desPerfil,
//                        "id": data[1]?.v_numOrden,
//                        "contents": "el ejecutivo"
//                    }
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
                registrarEstructuraUnidad();
            } else {
                actualizarEstructuraUnidad();
            }
        }
    }

    // REGISTRAR CARGO A ESTRUCTURA DE UNIDAD
    function registrarEstructuraUnidad() {
        let codPerfil = $('#selectCargo').val();
        let numOrden = $('#numOrden').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=registrarEstructuraUnidad",
            data: "codUnidad=" + addCodUnidad + "&codPerfil=" + codPerfil + "&numOrden=" + numOrden,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $('#formNuevoCargo').trigger("reset");

                    // LISTAR ESTRUCTURA DE UNIDAD EN LA TABLA
                    listarEstructuraUnidades(addCodEquipo);
                    $('#modalNuevoCargo').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }

    // OBTNER  DATOS  DE UNA DE ESTRUCTURA DE UNIDAD
    async function listarEstructuraUnidadDatos(codEstructura, desUnidad) {
        await $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarEstructuraUnidadDatos",
            data: "codEstructura=" + codEstructura,
            dataType: 'json',
            success: async function (data, textStatus, jqXHR) {
                data = data[0]; // LISTA DE DATOS DE UN CARGO DE ESTRUCTURA
                await llenarFormCargoEstructura(data, desUnidad);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    // LLENAR FORM CON DATOS DE CARGO DE UNA ESTRUCTURA DE UNIDAD
    async function llenarFormCargoEstructura(data, desUnidad) {
        updateCargo = true;
        updateCodEstruc = data?.v_codEstructura;
        addCodUnidad = data?.v_codUnidad;
        console.log(data);
        $('#titleModalNuevoCargoEstructura').text("EDITAR CARGO DE " + desUnidad);
        await listarPerfilesComer();
        $('#selectCargo').val(data.v_codPerfil);
        $('#numOrden').val(data.v_numOrden);
        $('#btnGuardarCargo').addClass('hide');
        $('#btnActualizarCargo').removeClass('hide');

        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
        let validarErrorForm = $("#formNuevoCargo").validate();
        validarErrorForm.destroy();
        $('#modalNuevoCargo').modal("show");
    }

    // ACTUALIZAR CARGO DE ESTRUCTURA DE UN EQUIPO
    function actualizarEstructuraUnidad() {
        let codPerfil = $('#selectCargo').val();
        let numOrden = $('#numOrden').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=actualizarEstructuraUnidad",
            data: "codEstructura=" + updateCodEstruc + "&codPerfil=" + codPerfil + "&numOrden=" + numOrden,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $('#formNuevoCargo').trigger("reset");
                    // LISTAR ESTRUCTURA DE UNIDAD EN LA TABLA 
                    listarEstructuraUnidades(addCodUnidad);
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

    function asginarCargoUnidad(codPerfil, codUnidad, codEquipo, sendCodEstructura) {
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
                data = data?.listVendedoresSinCargo; // LISTA DE VENDEDORES SIN CARGO
                llenarSelectAsignarCargo(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    // LLENAR SELECT DE PERSONAL
    function llenarSelectAsignarCargo(data) {
        $('#selectPersonal').empty();
        $('#selectPersonal').append($('<option/>', {
            text: ''
        }));
        data?.forEach(vende => {
            $('#selectPersonal').append($('<option/>', {
                text: vende?.v_usuario + " " + vende?.v_apellidoPaterno + " " + vende?.v_apellidoMaterno,
                value: vende?.v_cod_Vendedor
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
    function darbajaEstructuraUnidad(codEstructura, codUnidad) {
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
                    url: '../../reHumanosServlet?Accion=darbajaEstructuraUnidad',
                    data: 'codEstructura=' + codEstructura,
                    beforeSend: function () {
                    }, success: function (resultado) {
                        console.log(resultado);
                        let res = resultado.toString().split("_");
                        if (res[0] == 1) {
                            msjFinal(res[0], res[1]);
                            listarEstructuraUnidades(codUnidad);
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