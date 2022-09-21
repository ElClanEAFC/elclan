<%-- 
    Document   : unidades
    Created on : 5 set. 2022, 15:58:55
    Author     : sistemas03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0" >
    <div class=" bg-white border-top border-danger border-3">
        <div class="card">
            <div class="card-body p-t-40" id="principalUnidad" >
                <div class="row">       
                    <div class="col-md-12" >
                        <div class="d-flex gap-1 justify-content-between flex-wrap align-items-end">
                            <div class="col-md-5 col-sm-12 col-12 d-flex gap-3 align-items-end justify-content-sm-between justify-content-md-start">
                                <form class="my-lg-0 gap-3 col-md-8 col-sm-9 col-8" id="formUnidadBuscar">
                                    <label for="selectUnidad" class="form-label">SELECCIONE UNA UNIDAD:</label>
                                    <select  id="selectUnidad" name="selectUnidad" 
                                             class="fform-control rounded-lg text-dark" style="width: 100%;">   
                                    </select>
                                </form>
                                <div class="">
                                    <button class="btn btn-success my-sm-0 text-white" onclick="validarCampoUnidadBuscar();" type="button">BUSCAR</button>           
                                </div>
                            </div>
                            <div class="d-flex align-items-center">
                                <button class="btn btn-success my-sm-0 text-white"
                                        onclick="vistaOrganigramaUnidad();"
                                        >ORGANIGRAMA
                                </button>
                            </div>
                            <div class="d-flex align-items-center">
                                <button class="btn btn-success my-sm-0 text-white" onclick="abrirNuevaUnidad();">AÑADIR UNIDAD</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                <h4 class="card-title">LISTA DE UNIDADES</h4>
                <!--table-bordered-->
                <table id="tablaUnidades" class="table table-striped " width="100%" autocomplete="off">
                    <thead>
                        <tr>
                            <th>UNIDAD</th>
                            <th>FECHA CREACION</th>
                            <th>USUARIO</th>
                            <th>ESTADO</th>
                            <th>OPCIONES</th>
                        </tr>
                    </thead>                    
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="card-body p-t-40 hide" id="organigramaUnidades">
                <%--<jsp:include page="../modals/organigrama.jsp" />--%>
            </div>
        </div>
    </div>
</div>
<!-- MODAL DE NUEVA UNIDAD -->
<div class="modal fade " id="modalNuevaUnidad" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModal">
                    CREAR NUEVA UNIDAD
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" >
                </button>
            </div>
            <div class="modal-body">
                <form method="post" id="formNuevaUnidad">
                    <div class="form row">
                        <div  class="form-group col-md-3"></div>
                        <div class="form-group col-md-6">
                            <label>NOMBRE DE LA UNIDAD</label>
                            <input type="text" id="desUnidad" name="desUnidad" class="form-control rounded-lg" />
                        </div>
                        <div  class="form-group col-md-3"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
                <button type="button" class="btn btn-success text-white" id="btnGuardarUnidad" onclick="validarNuevaUnidad();">GUARDAR</button>
                <button type="button" class="btn btn-success text-white hide" id="btnActualizarUnidad" onclick="validarNuevaUnidad();">ACTUALIZAR</button>
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
        vistaOrgEquipo = false;
        $('#organigrama').empty();

        $("input").on("keypress", function () {
            $input = $(this);
            UpperCaseInput($input);
        });
        tablaUnidades = $('#tablaUnidades').DataTable({
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
        })
        $('#selectUnidad').select2({
            width: 'resolve'
        });
        // LISTAR UNIDADES EN LA TABLA Y SELECT DE UNIDADES
        listarUnidades("llenarTablaUnidades", "llenarSelectUnidades");
//        $('#unidadBuscar').keydown(function (e) {
//            if (e.keyCode === 13) {
//                e.preventDefault();
//                buscarUnidad();
//            }
//        });
//        // LISTAR REGISTROS DE USUARIOS
//        $('#unidadBuscar').on('input', function () {
//            if (this.value == "") {
//                listarUnidades();
//            }
//        });
    });
    function vistaOrganigramaUnidad() {
//        vistaOrgUnidad = true;
        $('#organigramaUnidades').load("../../components/ventas/unidadesEquipos/modals/organigramaUnidad.jsp");
        $('#principalUnidad').addClass('hide');
        $('#organigramaUnidades').removeClass('hide');
    }
    function vistaUnidades() {
//        vistaOrgUnidad = false;
        $('#organigramaUnidades').empty();
        $('#organigramaUnidades').addClass('hide');
        $('#principalUnidad').removeClass('hide');
    }
    function listarUnidades(llenarTabla = null, llenarSelect = null, codUnidad = "0") {
//        let codUnidad = $("#unidadBuscar").val() || "0";
        console.log(codUnidad);
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=listarUnidades",
            data: "codUnidad=" + codUnidad,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                data = data.listUnidades;  // LSITA DE UNIDADES
                if ((llenarTabla && llenarSelect) !== null) {
                    llenarTablaUnidades(data);
                    llenarSelectUnidades(data);
                } else if (llenarTabla !== null) {      // VALIDAR SI SE LLENARA LA TABLA O SELECT DE UNIDADES              
                    llenarTablaUnidades(data);
                } else if (llenarSelect !== null) {
                    llenarSelectUnidades(data);
                }
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
    function llenarTablaUnidades(data) {
        tablaUnidades.clear().draw();
        $.each(data, function () {
            tablaUnidades.row.add([
                this['v_desUnidad'],
                this['v_fechaCreacion'],
                this['v_usuarioCreacion'],
                this['v_estado'],
                '<a class=\'pe-1\' href=\'#\' onclick=\"editarUnidad(' + this['v_codUnidad'] + ',\'' + this['v_desUnidad'] + '\');\" title=\'Editar Unidad\' ><i class=\'fas fa-edit editar\'  ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' onclick=\"darBajaUnidad(' + this['v_codUnidad'] + ',\'' + this['v_desUnidad'] + '\');\" title=\'Dar de Baja Unidad\' ><i class=\'fas fa-trash-alt borrar\'  ></i></a>'
            ]).draw(false);
        });
    }
    function abrirNuevaUnidad() {
        updateUnidad = false;
        $('#titleModal').text("CREAR NUEVA UNIDAD");
        $('#btnActualizarUnidad').addClass('hide');
        $('#btnGuardarUnidad').removeClass('hide');
        $('#modalNuevaUnidad').modal("show");
        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
        let validarErrorForm = $("#formNuevaUnidad").validate();
        validarErrorForm.destroy();
    }
    function validarNuevaUnidad() {
        let validator = $('#formNuevaUnidad').validate({
            rules: {
                desUnidad: {required: true},
            },
            messages: {
                desUnidad: "Ingrese un nombre"
            }
        });
        let estado = validator.form();
        if (estado) {
            if (!updateUnidad) {
                guardarUnidad();
            } else {
                actualizarUnidad();
            }
        }
    }
    function guardarUnidad() {
        let desUnidad = $('#desUnidad').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=guardarUnidad",
            data: "desUnidad=" + desUnidad,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $('#fomNuevaUnidad').trigger("reset");
                    // LISTAR UNIDADES EN LA TABLA Y SELECT DE UNIDADES
                    listarUnidades("llenarTablaUnidades", "llenarSelectUnidades");
                    $('#modalNuevaUnidad').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }
    function editarUnidad(codUnidadSend, desUnidad) {
        codUnidad = codUnidadSend;
        // LIMPIAR ALERTAS DE CAMPOS ERRONEOS
        let validarErrorForm = $("#formNuevaUnidad").validate();
        validarErrorForm.destroy();
        updateUnidad = true;
        $('#btnActualizarUnidad').removeClass('hide');
        $('#btnGuardarUnidad').addClass('hide');
        $('#desUnidad').val(desUnidad);
        $('#titleModal').text("EDITAR " + desUnidad);
        $('#modalNuevaUnidad').modal("show");
    }
    function actualizarUnidad() {
        let desUnidad = $('#desUnidad').val();
        $.ajax({
            type: 'POST',
            url: "../../ventasServlet?Accion=actualizarUnidad",
            data: "codUnidad=" + codUnidad + "&desUnidad=" + desUnidad,
            success: function (data, textStatus, jqXHR) {
                let res = data.toString().split("_");
                if (res[0] == 1) {
                    updateUnidad = false;
                    msjFinal(res[0], res[1]);
                    // LISTAR UNIDADES EN LA TABLA Y SELECT DE UNIDADES
                    listarUnidades("llenarTablaUnidades", "llenarSelectUnidades");
                    $('#formNuevaUnidad').trigger("reset");
                    $('#modalNuevaUnidad').modal('hide');
                } else {
                    msjFinal(res[0], res[1]);
                }
            },
            complete: function (jqXHR, textStatus) {

            }
        });
    }
    function darBajaUnidad(codUnidad, desUnidad) {
        Swal.fire({
            title: "Mensaje",
            text: "Esta Seguro dar de baja  la " + desUnidad,
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
                    url: "../../ventasServlet?Accion=darBajaUnidad",
                    data: "codUnidad=" + codUnidad,
                    success: function (data, textStatus, jqXHR) {
                        let res = data.toString().split("_");
                        if (res[0] == 1) {
                            updateUnidad = false;
                            msjFinal(res[0], res[1]);
                            // LISTAR UNIDADES EN LA TABLA Y SELECT DE UNIDADES
                            listarUnidades("llenarTablaUnidades", "llenarSelectUnidades");
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
    // LLENAR SELECT UNIDADES
    function llenarSelectUnidades(data) {
        $('#selectUnidad').empty();
        $('#selectUnidad').append($('<option/>', {
            text: ''
        }));
        data.forEach(uni => {
            $('#selectUnidad').append($('<option/>', {
                text: uni.v_desUnidad,
                value: uni.v_codUnidad
            }));
        });
    }
    //VALIDAR CAMPO DE BUSQUEDA DE UNIDAD
    function validarCampoUnidadBuscar() {
        let validator = $("#formUnidadBuscar").validate({
            rules: {
                selectUnidad: {required: true}
            },
            messages: {
                selectUnidad: "Ingresa la unidad"
            }
        });
        let estado = validator.form();
        if (estado) {
            let codUnidad = $("#selectUnidad").val();
            listarUnidades("llenarTablaUnidades", null, codUnidad);
        }
    }
</script>
