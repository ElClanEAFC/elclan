<%-- 
    Document   : vendedores.jsp
    Created on : 31 ago. 2022, 17:44:09
    Author     : sistemas02
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .col-12 {
        margin-bottom: 10px;
    }

</style>
<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0" >
    <div class=" bg-white border-top border-danger border-3">
        <div class="card">
            <div class="card-body p-t-40 " >
                <!-- Primera Fila -->
                <div class="row gap-2">
                    <div class="col-12 col-lg-8 " ><!-- col-8 col-sm-12 -->
                        <!-- Segunda Fila -->

                        <div class="row">
                            <div class="col-12  col-lg-4  border border-1  "><!-- col-4 col-sm-12 -->

                                <select class="form-control" id="BuscadorDNI-NOMBRE">
                                    <option  value="0"  class="text-center">  INGRESE DNI O NOMBRES  </option>
                                </select>  


                            </div>
                            <div class="col-12 col-lg-3 "><!-- col-3 col-sm-12  -->
                                <select class="form-control" id="selectUnidad">
                                    <option  value="0" >  SELECCIONE UNIDAD   </option>
                                </select>              
                            </div>
                            <div class="col-12 col-lg-3"><!-- col-3 col-sm-12 -->
                                <select class="form-control" id="selectEquipo" >
                                    <option  value="0">  SELECCIONE EQUIPO   </option>
                                </select>             
                            </div>
                            <div class="col-12 col-lg-2"><!-- col-2 col-sm-12 -->
                                <button class="btn btn-success my-sm-0 text-white" onclick="BuscarVendedor()">BUSCAR</button>            
                            </div>
                        </div>
                        <!-- Segunda Fila -->

                    </div>
                    <div class="col-12 text-end col-lg-3"><!-- col-2 col-sm-12 -->
                        <button class="btn btn-success my-sm-0 text-white" onclick="ROUTER.load('registrar')">AÑADIR VENDEDOR</button>
                    </div>
                </div>
                <!-- Primera Fila -->

                <hr>
                <h4 class="card-title">LISTA DE VENDEDORES</h4>
                <!--table-bordered-->
                <table id="tablaVendedores" class="table table-striped text-center  " width="100%" autocomplete="off">
                    <thead>
                        <tr>
                            <th>DATOS COMPLETOS</th>
                            <th>USUARIO</th>
                            <th>TIPO DOC.</th>
                            <th>N° DOCUMENTO</th>
                            <th>UNIDAD/EQUIPO</th>
                            <th>CARGO</th>
                            <th>ESTADO SMV</th>
                            <th>ESTADO</th>
                            <th>OPCIONES</th>
                        </tr>
                    </thead>                    
                    <tbody id="tablaVende">
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<!-- RESUMEN DEL VENDEDOR  -->
<div class="modal fade"  aria-hidden="true" id="ResumenVendedor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleExperiencia">RESUMEN DE VENTAS</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="text-center pt-3" >
                <label class="h3" align="center"id="NomVendedor">  </label>
            </div>
            <hr>
            <table id="TablaExperiencia" class="table table-bordered p-1" width="100%" autocomplete="off"><!-- table  table-bordered   table-striped -->
                <thead>
                    <tr>
                        <th>PROGRAMA</th>
                        <th>GRUPO</th>
                        <th>CONTRATO</th>
                        <th>DATOS ASOCIADO</th>
                        <th>FECHA CREACION</th>
                        <th>ESTADO</th>
                    </tr>
                </thead>                    
                <tbody id="resultListaVari">

                </tbody>
            </table>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
            </div>
        </div>
    </div>
</div>



<script>
    $(document).ready(async function () {
        //Configurar Tabla tablaVendedores
        tablaVendedores = $('#tablaVendedores').DataTable({
            responsive: true,
            searching: false,
            ordering: false,
            "language": {
                "sZeroRecords": "No se encontrao resultados",
                "sEmptyTable": "Ningun dato disponible en esta tabla",
                "sInfo": "_START_ al _END_ de _TOTAL_ registros",
                "infoEmpty": "Mostrando del 0 al 0 de 0 registros",
                "sLengthMenu": "",
                "oPaginate": {
                    "sFirst": "Erste",
                    "sPrevious": "Atras",
                    "sNext": "Siguiente",
                    "sLast": "Letzte"

                },
                select: {rows: ""}
            }
        });
    });
    listaVendedores();


    function listaVendedores() {
        let codVendedor = $('#codigoVendedor').val();
        let codUnidad = $('#selectUnidad').val();
        let codEquipo = $('#selectEquipo').val();
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listaVendedores',
            data: 'codVendedor=' + codVendedor + '&codUnidad=' + codUnidad + '&codEquipo=' + codEquipo,
            dataType: 'json',
            beforeSend: function () {

            }, success: function (resultado) {
                llenarTablalistaVendedores(resultado);
            }, complete: function () {
            }

        });

    }
    function llenarTablalistaVendedores(data) {
        console.log(data);

        tablaVendedores.clear().draw();
        $.each(data, function () {
            let tipoDoc = this['v_tipoDocumento'];
            let DNI = this['v_numDocumento'].toString();
            let codVendedor = this['v_cod_Vendedor'];
            let datosCompletos = this['v_nombres'] + ' ' + this['v_apellidoPaterno'] + ' ' + this['v_apellidoMaterno'];

            let estado = this['v_estado'].toString();
            let colorEstado;
            if (estado === 'ACTIVO') {
                colorEstado = "bg-success text-white p-1 rounded-3";
            } else {
                colorEstado = "bg-danger text-white p-1 rounded-3";
            }

            let unidadEquipo = this['v_desUnidad'] + '/' + this['v_desEquipo'];

            tablaVendedores.row.add([
                datosCompletos,
                this['v_usuario'],
                this['v_des_documento'],
                this['v_numDocumento'],
                unidadEquipo = unidadEquipo.includes("null") ? "-" : unidadEquipo,
                this['v_cargo'],
                this['v_est_SMV'],
                "<span class=\" " + colorEstado + "\">" + this['v_estado'] + "</span>",

                '<a class=\'pe-1\' href=\'#\' \" title=\'Editar Vendedor\'\n\
                onclick="editarUsuario(' + tipoDoc + ',\'' + DNI + '\',' + 1 + ' );" > <i class=\'fas fa-edit editar\' ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' \" title=\'Resumen Ventas\' onclick="abrirModalResVentas(\'' + datosCompletos + '\');"> <i class=\'fas fa-calculator\' ></i></a>' + //'+datosCompletos+'
                        //'<a class=\'pe-1\' href=\'#\' \" title=\'Desactivar Usuario\'> <i class=\'fas fa-wrench \' ></i></a>' +
                        '<a class=\'pe-1\' href=\'#\' \" title=\'Agregar Experiencia\' onclick="agregarExperiencia(' + codVendedor + ');" > <i class=\'fas fa-briefcase \' ></i></a>' + //onclick=\"agregarExperiencia(' + codVendedor+ ');
                        '<a class=\'pe-1\' href=\'#\' \" title=\'Eliminar Vendedor\'> <i class=\'fas fa-trash-alt borrar \' ></i></a>'



            ]).draw(false);

        });
    }

    function abrirModalVendedor(tipDoc, DNI, nombre, apellidoP, apllidoM) {
        $("#modalDetalleVendedor").modal('show');
        datosVendedores(tipDoc, DNI);
    }
    function datosVendedores(codTDoc, numDoc) {

        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=validarNumDoc',
            data: 'codTDoc=' + codTDoc + '&numDoc=' + numDoc,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (res) {
                Datos(res);
            }, complete: function () {
            }

        });

    }




    listarUnidades(0);
    async function listarUnidades(codUnidad) {
        var param = "codUnidad=" + codUnidad;
        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listarUnidades',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selectUnidad").html(resultado);
            }, complete: function () {
               listaEquipos(null, codUnidad);
            }
        });
    }
     
    async function listaEquipos(codEquipo=0, codUnidad=0) {
        var param1 = "codEquipo=" + codEquipo;
        var param2 = "selectUnidad=" + codUnidad;
        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listaEquipos',
            data:  param2,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selectEquipo").html(resultado);

            }, complete: function () {
            }
        });
    }

    $(document).ready(function () {
        $('#BuscadorDNI-NOMBRE').select2({
            theme: "bootstrap5"
        });
    });

    Buscador(null);
    async function Buscador(codEquipo) {

        var param1 = "codEquipo=" + codEquipo;
        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listaBuscador', //listaBuscador
            data: param1,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#BuscadorDNI-NOMBRE").html(resultado);

            }, complete: function () {
            }
        });
    }


    //Extrae los id y busca al vendedor por su codigo, equipo, unidad al precionar el boton "BUSCAR"
    function BuscarVendedor() {
        
      // let tablaVende.clear().draw;
        
        let codVendedor = $('#BuscadorDNI-NOMBRE').val();
        let codUnidad = $('#selectUnidad').val();
        let codEquipo = $('#selectEquipo').val();
       // alert("codVendedor " + codVendedor + "  codUnidad" + codUnidad + "  codEquipo" + codEquipo);

        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=BuscarVendedor',
            data: 'BuscadorDNI-NOMBRE=' + codVendedor + '&codUnidad=' + codUnidad + '&codEquipo=' + codEquipo,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                llenarTablalistaVendedores(resultado);
            }, complete: function () {
            }

        });

    }

    //Funcion Abrir Modal de Experiencia
    function abrirModalResVentas(datosCompletos) {
        $("#ResumenVendedor").modal('show');

        $('#NomVendedor').text(datosCompletos);
    }


</script>
