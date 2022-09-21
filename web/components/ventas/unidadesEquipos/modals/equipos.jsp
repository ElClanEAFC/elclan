<%-- 
    Document   : equipos
    Created on : 5 set. 2022, 16:05:46
    Author     : sistemas03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="tab-pane fade show active" id="nav-contact" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0" >
    <div class=" bg-white border-top border-danger border-3">
        <div class="card">
            <div class="card-body p-t-40 " id="principal" >            
                <div class="row">       
                    <div class="col-md-12" >
                        <div class="d-flex gap-1 justify-content-between flex-wrap align-items-end">
                            <div class="col-md-5 d-flex gap-3 align-items-end">
                                <form class="my-lg-0 gap-3 col-md-9" id="formEquipoBuscar">
                                    <div class="d-flex gap-3">
                                        <div>
                                            <label for="selectEquipo" class="form-label">SELECCIONE EQUIPO:</label>
                                            <select  id="selectEquipo" name="selectEquipo" 
                                                     class="fform-control rounded-lg text-dark" style="width: 100%;">   
                                            </select>
                                        </div>
                                        <div>
                                            <label for="selectUnidadEquipoBuscar" class="form-label">SELECCIONE UNIDAD:</label>
                                            <select class="form-control rounded-lg text-dark" 
                                                    name="selectUnidadEquipoBuscar" id="selectUnidadEquipoBuscar" style="width: 100%;">
                                            </select>
                                        </div>
                                    </div>
                                </form>
                                <div class="">
                                    <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoEquipoBuscar();" type="button">BUSCAR</button>
                                </div>
                            </div>
                            <div class="d-flex align-items-center">
                                <button class="btn btn-success my-sm-0 text-white"
                                        onclick="vistaOrganigrama();"
                                        >ORGANIGRAMA
                                </button>
                            </div>
                            <div class="d-flex align-items-center">
                                <button class="btn btn-success my-sm-0 text-white" onclick="abrirNuevoEquipo();">AÑADIR EQUIPO</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                <h4 class="card-title">LISTA DE EQUIPOS</h4>
                <table id="tablaEquipos" class="table table-striped " width="100%" autocomplete="off">
                    <thead>
                        <tr>
                            <th>EQUIPO</th>
                            <th>UNIDAD</th>
                            <th>FECHA CREACION</th>
                            <th>ESTADO</th>
                            <th>OPCIONES</th>
                        </tr>
                    </thead>                    
                    <tbody>

                    </tbody>
                </table>
            </div>
            <div class="card-body p-t-40 hide" id="organigrama">
                <%--<jsp:include page="../modals/organigrama.jsp" />--%>
            </div>
        </div>
    </div>
</div>
<!-- MODAL DE NUEVA EQUIPO -->
<div class="modal fade " id="modalNuevoEquipo" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModalNuevoEquipo">
                    CREAR NUEVO EQUIPO
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" >
                </button>
            </div>
            <div class="modal-body">
                <form method="post" id="formNuevoEquipo">
                    <div class="form row">
                        <div  class="form-group col-md-3"></div>
                        <div class="form-group col-md-6">
                            <div class="col-12">
                                <label>NOMBRE DEL EQUIPO</label>
                                <input type="text" id="desEquipo" name="desEquipo" class="form-control rounded-lg" />                            
                            </div>
                            <div class="col-12">
                                <label for="selectUnidadEquipo" class="form-label">SELECCIONE UNIDAD:</label>
                                <select class="form-control rounded-lg text-dark" 
                                        name="selectUnidadEquipo" id="selectUnidadEquipo" style="width: 100%;">
                                </select>                                
                            </div>
                        </div>
                        <div  class="form-group col-md-3"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
                <button type="button" class="btn btn-success text-white" id="btnGuardarEquipo" onclick="validarNuevoEquipo();">GUARDAR</button>
                <button type="button" class="btn btn-success text-white hide" id="btnActualizarEquipo" onclick="validarNuevoEquipo();">ACTUALIZAR</button>
            </div>
            <div class="content-loader visually-hidden" id="ico-loader">
                <div class="loader">
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {  
        vistaOrgUnidad = false;
//        $('#organigramaUnidades').empty();
        
        $("input").on("keypress", function () {
            $input = $(this);
            UpperCaseInput($input);
        });        
        tablaEquipos = $('#tablaEquipos').DataTable({
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
        $('#selectEquipo').select2({
            width: 'resolve'
        });
        $('#selectUnidadEquipoBuscar').select2({
            width: 'resolve'
        });
        listarEquipos("llenarTablaEquipos", "llenarSelectEquipos");
        listarUnidadesSelectBusqueda();
    });
    function vistaOrganigrama(){
        vistaOrgEquipo = true;
        $('#organigrama').load("../../components/ventas/unidadesEquipos/modals/organigrama.jsp")
        $('#principal').addClass('hide');
        $('#organigrama').removeClass('hide');
    }
    function vistaEquipos(){
        vistaOrgEquipo = false;
        $('#organigrama').empty();
        $('#organigrama').addClass('hide');
        $('#principal').removeClass('hide');
    }
    function listarEquipos(llenarTabla = null, llenarSelect = null, codEquipo = "0", codUnidad = "0") {
        console.log(codEquipo);
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarEquipos",
            data: "codEquipo=" + codEquipo + "&codUnidad=" + codUnidad,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listEquipos; // LISTA DE EQUIPOS
                if ((llenarTabla && llenarSelect) !== null) {
                    llenarTablaEquipos(data);
                    llenarSelectEquipos(data);
                } else if (llenarTabla !== null) {   // VALIDAR SI SE LLENARA LA TABLA O SELECT DE EQUIPOS
                    llenarTablaEquipos(data);
                } else if (llenarSelect !== null) {
                    llenarSelectEquipos(data);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }
    function llenarTablaEquipos(data) {
        tablaEquipos.clear().draw();
        $.each(data, function () {
            tablaEquipos.row.add([
                this['v_desEquipo'],
                this['v_desUnidad'],
                this['v_fechaCreacion'],
                this['v_estado'],
                '<a class=\'pe-1\' href=\'#\' onclick=\"editarEquipo(' + this['v_codUnidad'] + ',' + this['v_codEquipo'] + ',\'' + this['v_desEquipo'] + '\');\" title=\'Editar Equipo\' ><i class=\'fas fa-edit editar\'  ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' onclick=\"darBajaEquipo(' + this['v_codUnidad'] + ',' + this['v_codEquipo'] + ',\'' + this['v_desEquipo'] + '\');\" title=\'Dar de Baja Equipo\' ><i class=\'fas fa-trash-alt borrar\'  ></i></a>'
            ]).draw(false);
        });
    }
    async function abrirNuevoEquipo() {
        updateEquipo = false;
        $('#titleModalNuevoEquipo').text("CREAR NUEVO EQUIPO");
        $('#btnActualizarEquipo').addClass('hide');
        $('#btnGuardarEquipo').removeClass('hide');
        await listarUnidadesParaEquipo();
        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
        let validarErrorForm = $("#formNuevoEquipo").validate();
        validarErrorForm.destroy();
        $('#modalNuevoEquipo').modal("show");
    }
    function validarNuevoEquipo() {
        let validator = $('#formNuevoEquipo').validate({
            rules: {
                desEquipo: {required: true}
            },
            messages: {
                desEquipo: "Ingrese un equipo"
            }
        });
        let estado = validator.form();
        if (estado) {
            if (!updateEquipo) {
                guardarEquipo();
            } else {
                actualizarEquipo();
            }
        }
    }
    function guardarEquipo() {
        let desEquipo = $('#desEquipo').val();
        let codUnidad = $('#selectUnidadEquipo').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=guardarEquipo",
            data: "desEquipo=" + desEquipo + "&codUnidad=" + codUnidad,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $('#fomNuevaUnidad').trigger("reset");
                    // LISTAR UNIDADES EN LA TABLA Y SELECT DE EQUIPOS
                    listarUnidades("llenarTablaEquipos", "llenarSelectEquipos");
                    $('#formNuevoEquipo').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }
    async  function editarEquipo(codUnidadSend, codEquipoSend, desEquipo) {
        codUnidad = codUnidadSend;
        codEquipo = codEquipoSend;
        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
        let validarErrorForm = $("#formNuevoEquipo").validate();
        validarErrorForm.destroy();
        updateEquipo = true;
        $('#btnActualizarEquipo').removeClass('hide');
        $('#btnGuardarEquipo').addClass('hide');
        $('#desEquipo').val(desEquipo);
        $('#titleModalNuevoEquipo').text("EDITAR " + desEquipo);
        await listarUnidadesParaEquipo();
        $('#selectUnidadEquipo').val(codUnidad);
        $('#modalNuevoEquipo').modal("show");
    }
    function actualizarEquipo() {
        let codUnidad = $('#selectUnidadEquipo').val();
        let desEquipo = $('#desEquipo').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=actualizarEquipo",
            data: "codUnidad=" + codUnidad + "&codEquipo=" + codEquipo + "&desEquipo=" + desEquipo,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    updateEquipo = false;
                    msjFinal(res[0], res[1]);
                    // LISTAR UNIDADES EN LA TABLA Y SELECT DE UNIDADES
                    listarEquipos("llenarTablaEquipos", "llenarSelectEquipos");
                    $('#formNuevoEquipo').trigger("reset");
                    $('#modalNuevoEquipo').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }
    function darBajaEquipo(codUnidad, codEquipo, desEquipo) {
        Swal.fire({
            title: "Mensaje",
            text: "Esta Seguro dar de baja  " + desEquipo,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: "#28B779",
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar!',
            confirmButtonText: 'Confirmar!'
        }).then(async (result) => {
            if (result.isConfirmed) {
                await $.ajax({
                    type: 'POST',
                    url: "../../ventasServlet?Accion=darBajaEquipo",
                    data: "codUnidad=" + codUnidad + "&codEquipo="+codEquipo,
                    success: function (data, textStatus, jqXHR) {
                        let res = data.toString().split("_");
                        if (res[0] == 1) {
                            updateUnidad = false;
                            msjFinal(res[0], res[1]);
                            // LISTAR UNIDADES EN LA TABLA Y SELECT DE UNIDADES
                            listarEquipos("llenarTablaEquipos", "llenarSelectEquipos");
                        } else {
                            msjFinal(res[0], res[1]);
                        }
                    },
                    complete: function (jqXHR, textStatus) {

                    }
                });
            }
        });
    }
    function listarUnidadesSelectBusqueda(){
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarUnidades",
            data: "codUnidad=" + "0",
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listUnidades; // LISTA DE UNIDADES
                llenarSelectUnidadesParaBusqueda(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
    async  function listarUnidadesParaEquipo() {
        await  $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarUnidades",
            data: "codUnidad=" + "0",
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listUnidades; // LISTA DE UNIDADES
                llenarSelectUnidadesParaEquipo(data);
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
    // LLENAR SELECT UNIDADES PARA EQUIPO
    function llenarSelectUnidadesParaEquipo(data) {
        $('#selectUnidadEquipo').empty();
        $('#selectUnidadEquipo').append($('<option/>', {
            text: ''
        }));
        data.forEach(uni => {
            $('#selectUnidadEquipo').append($('<option/>', {
                text: uni.v_desUnidad,
                value: uni.v_codUnidad
            }));
        });
    }
    // LLENAR SELECT EQUIPOS
    function llenarSelectEquipos(data) {
        $('#selectEquipo').empty();
        $('#selectEquipo').append($('<option/>', {
            text: 'TODOS',
            value: '0'
        }));
        data.forEach(equipo => {
            $('#selectEquipo').append($('<option/>', {
                text: equipo.v_desEquipo,
                value: equipo.v_codEquipo
            }));
        });
    }
    // LLENAR SELECT UNIDADES PARA BUSQUEDA
    function llenarSelectUnidadesParaBusqueda(data) {
        $('#selectUnidadEquipoBuscar').empty();
        $('#selectUnidadEquipoBuscar').append($('<option/>', {
            text: "TODOS",
            value: '0'
        }));
        data.forEach(uni => {
            $('#selectUnidadEquipoBuscar').append($('<option/>', {
                text: uni.v_desUnidad,
                value: uni.v_codUnidad
            }));
        });
    }
    //VALIDAR CAMPO DE BUSQUEDA DE EQUIPO
    function validarCampoEquipoBuscar() {
        let validator = $("#formEquipoBuscar").validate({
            rules: {
                selectEquipo: {required: true},
                selectUnidadEquipoBuscar: {required: true}
            },
            messages: {
                selectEquipo: "Ingresa el equipo",
                selectUnidadEquipoBuscar: "Ingresa el equipo"
            }
        });
        let estado = validator.form();
        if (estado) {
            let codEquipo = $("#selectEquipo").val();
            let codUnidad = $("#selectUnidadEquipoBuscar").val();
            listarEquipos("llenarTablaEquipos", null, codEquipo, codUnidad);
        }
    }
    
</script>

