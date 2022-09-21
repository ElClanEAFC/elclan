<%-- 
    Document   : config. categoria
    Created on : 2 set. 2022, 11:11:48
    Author     : sistemas02
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--id="contact-tab-pane"  -->
<div class="tab-pane fade show active" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab" tabindex="0" >
    <div class=" bg-white border-top border-danger border-3">
        <div class="card">
            <div class="card-body p-t-40 " >
                <div class="row">
                    <div class="col-12 col-lg-8" >
                        <div class="row">
                            <div class="col-12 col-lg-4"><!--  border border-1 -->
                                <select class="form-control" id="BuscadorConfCategoria">
                                    <option  value="0" >--INGRESE NOMBRE DE CONF. CATEGORIA--</option>
                                </select>  
                            </div>
                            <div class="col-2">
                                <button class="btn btn-success my-sm-0 text-white" id="buscar" onclick="ObtenerConfCategoria();" >BUSCAR</button>
                            </div>

                        </div>
                    </div>
                    <div class="col-12 col-lg-2">                        
                    </div>
                    <div class="col-12 col-lg-2">
                        <button class=" hola btn btn-success my-sm-0 text-white" id="bntAñadirVariables" data-bs-toggle="modal" onclick="abrirModalAgregarVariables();" >AÑADIR VARIABLES</button>
                    </div>
                </div>
                <hr>
                <h4 class="card-title">LISTA DE ORGANIGRAMA Y ESTRUCTURA DE UNIDADES Y EQUIPOS</h4>

                <style>
                    .titulo {
                        height: 50px;
                        background-color: #1F262D;
                    }
                    .variable{
                        margin-bottom: 10px;
                    }
                    label{
                        font-weight: 400 !important;
                    }
                    .categorias{
                        padding-top: 5% !important;
                    }

                </style>
                <div style="position: relative;" ><!-- Inicio -->
                    <div class="row   text-light titulo text-center " style='width: 100%;' >
                        <div class="col-lg-2 " >
                            <label for="variable" id="variable" class="p-t-15">NOMBRES CATEGORIAS</label>
                        </div>
                        <div class="col-lg-2 " >
                            <label for="variable" id="variable" class="p-t-15">VARIABLES</label>
                        </div>
                        <div class="col-lg-2 " >
                            <label for="variable" id="variable" class="p-t-15">TIPO CONDICION</label>
                        </div>
                        <div class="col-lg-2 " >
                            <label for="variable" id="variable" class="p-t-15">VALOR PARAMETRO</label>
                        </div>
                        <div class="col-lg-2 " >
                            <label for="variable" id="variable" class="p-t-15">PRIORIDAD</label>
                        </div>
                        <div class="col-lg-2  " >
                            <label for="variable" id="variable" class="p-t-15">OPCIONES</label>
                        </div>
                    </div>
                    <div >
                        <table id="tablaConfigCategoria" class="table table-striped " width="100%" autocomplete="off">
                            <thead>
                            </thead>                    
                            <tbody id="cuerpodelatabla">

                            </tbody>
                        </table>
                    </div>
                </div><!-- Fin -->
            </div>
        </div>
    </div>
</div>
<!-- AÑADIR VARIABLES  -->
<div class="modal fade"  aria-hidden="true" id="AñadirVariables" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleCategoria">AÑADIR VARIABLES</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <form class="form row" >
                    <div class="form-group col-md-8"">
                        <input class="input-group input-group-lg m-t-20 p-l-50" type="text" id="desVariablesCat"  oninput="conviertMayucula(this);" >
                    </div>

                    <div class="form-group col-4">
                        <button type="button" class="btn btn-success text-white m-t-15 " onclick="registroVariCategoria();">GUARDAR</button><!--  -->
                    </div>
                </form>
            </div>
            <hr>
            <table id="tablaVariables" class="table table-bordered text-center  p-2" width="100%" autocomplete="off">
                <thead>
                    <tr>
                        <!-- <th>CODIGO VARIABLES</th> -->
                        <th>DESCRIPCION VARIABLES</th>
                        <th>ESTADO</th>
                        <th>USUARIO</th>
                        <th>FECHA CREACION</th>
                        <th>OPCIONES</th>
                    </tr>
                </thead>                    
                <tbody id="resultListaVari">

                </tbody>
            </table>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CERRAR</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal ACTUALIZA VARIABLES -->
<div class="modal fade"  tabindex="-1" aria-hidden="true" id="ActualizaVariable"  aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleCategoria">ACTUALIZAR VARIABLE</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <form class="form row" id="formCategoria">
                    <div class="form-group col-md-8"">
                        <input class="input-group input-group-lg m-t-20 p-l-50" type="text" id="desVariablesCatA" name="desCategoriaAct" >
                    </div>

                    <div class="form-group col-4">
                        <button type="button" class="btn btn-success text-white m-t-15 " onclick="actualizarVariable();">ACTUALIZAR</button><!-- col-md-8 text-white m-t-20  -->
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Configuracion de Variables para categoria de Vendedores-->
<div class="modal fade"  tabindex="-1" aria-hidden="true" id="confVariables"  aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleConf">CONFIGURACION DE VARIABLES PARA CATEGORIA DE VENDEDORES</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <form class="form" id="confVariablesCateg" >
                    <div class="row">
                        <div class="form-group col-12 col-lg-4">
                            <label for="nomCat">NOMBRE CATEGORIA:</label>
                            <input class="input-group input-group-lg " value="0" type="text" id="nomCategoria" name="nomCategoria" >
                        </div>   
                        <div class="form-group col-12 col-lg-4">
                            <label for="nomVariable">VARIABLE:</label>
                            <input class="input-group input-group-lg" value="0" type="text" id="nomVariable" name="nomVariable" >
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-12 col-lg-4 ">
                            <label for="nomCat">SELECCIONE LA CONDICION:</label>
                            <select class="form-control" name="selecCondicion"id="selecCondicion">
                                <!-- <option  value="0" >SELECCIONAR</option> --> 
                            </select>              
                        </div>
                        <div class="col-12 col-lg-4 ">
                            <label for="nomParametr">VALOR PARAMETRO:</label>
                            <input class="input-group input-group-lg m-t-9  h-50" type="number" id="nomParametro" name="nomParametro"  oninput="validity.valid||(value='');" >

                        </div>

                        <div class="col-12 col-lg-4 "><!-- col-3 col-sm-12  -->
                            <label for="nomCat">REFERENCIA VALOR:</label>
                            <select class="form-control" id="selectValor">
                                <!-- <option  value="0" >SELECCIONAR</option> --> 
                            </select>              
                        </div>
                    </div>

                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
                <button type="button" class="btn btn-success text-white" onclick="valCampoConfVariables();">GUARDAR</button><!-- valCampoConfVariables  registrarConfig -->
            </div>
        </div>
    </div>
</div>


<script>
    //Configurar Tabla Tabla Variables
    $(document).ready(async function () {
        tablaVariables = $('#tablaVariables').DataTable({
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
        
        tablaConfigCategoria = $('#tablaConfigCategoria').DataTable({
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
    //Configurar Tabla Configuracion d Variables

    $(document).ready(async function () {
//        tablaConfigCategoria = $('#tablaConfigCategoria').DataTable({
//            responsive: true,
//            searching: false,
//            ordering: false,
//            "language": {
//                "sZeroRecords": "No se encontrao resultados",
//                "sEmptyTable": "Ningun dato disponible en esta tabla",
//                "sInfo": "_START_ al _END_ de _TOTAL_ registros",
//                "infoEmpty": "Mostrando del 0 al 0 de 0 registros",
//                "sLengthMenu": "",
//                "oPaginate": {
//                    "sFirst": "Erste",
//                    "sPrevious": "Atras",
//                    "sNext": "Siguiente",
//                    "sLast": "Letzte"
//                },
//                select: {rows: ""}
//            }
//        });

    });

    $("#nomCategoria").attr('readonly', 'readonly');
    $("#nomVariable").attr('readonly', 'readonly');


    //Funcion para Listar el ORGANIGRAMA Y ESTRUCTURA DE UNIDADES Y EQUIPOS
    TablaConfiCategCategorias();
    function TablaConfiCategCategorias() {
        let codigo = $('#BuscadorConfCategoria').val();
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=estructuraCatgoriaVariables',
            data: 'BuscadorConfCategoria=' + codigo,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#cuerpodelatabla").html(resultado);
            }, complete: function () {

            }

        });
    }

    function abrirModalAgregarVariables() {
        listaVariCategoria();
        $('#desVariablesCat').val('');
        $("#AñadirVariables").modal('show');
    }

//Funcion para registrar variables de la categoria
    function registroVariCategoria() {
        let desVariablesCat = $('#desVariablesCat').val();
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=registroVariCategoria',
            data: 'desVariablesCat=' + desVariablesCat,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    //$('#AñadirCategoria').modal('hide');
                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                listaVariCategoria();
            }
        });
    }

//Funcion carga la tabla variables de la categoria 
    function listaVariCategoria() {
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listaVariCategorias',
            data: '',
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                llenarTablaVariCategoria(resultado);
            }, complete: function () {
            }
        });
    }

    //Funcion Llena la tabla variables de la categoria
    function llenarTablaVariCategoria(data) {
        tablaVariables.clear().draw();
        $.each(data, function () {
            let codVariableCat = this['v_codVariableCat'];
            let desVariableCat = this['v_desVariableCat'];
            let estado = this['v_estado'].toString();
            let colorEstado;
            if (estado == 'ACTIVO') {
                colorEstado = "bg-success text-white p-1 rounded-3";
            } else {
                colorEstado = "bg-danger text-white p-1 rounded-3";
            }
            // let colorEstado = estado !== "activo" ? "bg-danger text-white p-1 rounded-3" : "bg-success text-white p-1 rounded-3";


            tablaVariables.row.add([
                // codVariableCat,
                desVariableCat,
                "<span class=\" " + colorEstado + "\">" + this['v_estado'] + "</span>",
                this['v_usuario'],
                this['v_fechaCreacion'],
                '<a class=\'pe-1\' href=\'#\' \" title=\'ActualizarVariable\'  onclick="abrirModalActualizarVariable(' + codVariableCat + ',\'' + desVariableCat + '\');" > <i class=\'fas fa-edit editar\' ></i></a>' + //onclick="ActualizarCategoria();"
                        '<a class=\'pe-1\' href=\'#\' \" title=\'EliminarCategoria\' onclick="confirBajaVariableCat(' + codVariableCat + ',\'' + desVariableCat + '\');"> <i class=\'fas fa-trash-alt borrar \' ></i></a>'

            ]).draw(false);
        });
    }

    function abrirModalActualizarVariable(codVariableCat, desVariableCat) {
        $('#ActualizaVariable').modal('show');
        $("#desVariablesCatA").attr("value", codVariableCat);
        $('#desVariablesCatA').val(desVariableCat);
    }

//Funcion Actualiza los Datos de la Variable
    function actualizarVariable() {
        let codVariableCat = $("#desVariablesCatA").attr("value");
        let desVariableCat = $('#desVariablesCatA').val();

        let data = 'codVariableCat=' + codVariableCat + '&desVariableCat=' + desVariableCat;
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=actualizarVariable',
            data: data,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    $('#ActualizaVariable').modal('hide');
                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                listaVariCategoria();
            }
        });
    }

    // Confirmacion para dar de baja a una variable de la categoria
    function confirBajaVariableCat(codVariableCat, desVariableCat) {
        Swal.fire({
            title: 'Mensaje',
            text: "Esta seguro de borrar el Categoria?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#48C28D',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Continuar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                darBajaCategoria(codVariableCat, desVariableCat);
            }
        });
    }
    //Funcion para dar de baja a la variable de la Categoria

    function darBajaCategoria(codVariableCat, desVariableCat) {

        let data = 'codVariableCat=' + codVariableCat + '&desVariableCat=' + desVariableCat;
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=darBajaVariCategoria',
            data: data,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                listaVariCategoria();
            }
        });
    }

//Modal Configuracion de Variables para categoria de Vendedores
    function abrirModalConfVariables(codCatgoria, nomCategoria, nomVariable, codVariable) {
        $('#confVariables').modal('show');

        $('#nomParametro').val('');

        $('#nomCategoria').val(nomCategoria);
        $("#nomCategoria").attr("value", codCatgoria);

        $('#nomVariable').val(nomVariable);
        $("#nomVariable").attr("value", codVariable);

        listaCondicionVar();
        listaValoresVar();
    }
    function prioridad(codCategoria, codVariable) {

        let data = 'codCategoria=' + codCategoria + '&codVariable=' + codVariable;
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=prioridadVariable',
            data: data,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                TablaConfiCategCategorias();
            }
        });
    }

    //Funcion carga Selec de las condiciones de variables
    async function listaCondicionVar() {
        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listaCondicionVar',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selecCondicion").html(resultado);
            }, complete: function () {
            }
        });
    }

//Funcion carga Selec de las condiciones de variables
    async function listaValoresVar() {
        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listaValoresVar',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selectValor").html(resultado);
            }, complete: function () {
            }
        });
    }
    //Funcion Llena el select 2 de la tabla Configuracion de Categoria
    BuscadorCategoria();
    async function BuscadorCategoria() {
        let codigo = $('#BuscadorConfCategoria').val();

        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=buscarCategoria',
            data: codigo,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#BuscadorConfCategoria").html(resultado);
            }, complete: function () {
            }
        });
    }

    //Funcion registra Configuracion
    async function registrarConfig() {
        let cod_categoria = $("#nomCategoria").attr("value");
        let cod_Variable = $("#nomVariable").attr("value");
        let cod_Condicion = $('#selecCondicion').val();
        let camValor = $('#nomParametro').val();
        let paramValor = $('#selectValor').val();

        let date = 'cod_categoria=' + cod_categoria + '&cod_Variable=' + cod_Variable + '&cod_Condicion=' + cod_Condicion + '&camValor=' + camValor + '&paramValor=' + paramValor;

        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=registrarConfig',
            data: date,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    $('#confVariables').modal('hide');
                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {

                BuscadorCategoria();

            }
        });
        TablaConfiCategCategorias();
    }

    //Filtra la tabla Configuracion de categoria
    async function ObtenerConfCategoria() {
        TablaConfiCategCategorias();
    }


//Funcion para dar de baja la Configuracion

    function darBajaConfVariables(codCategoria, codVariable) {

        let data = 'codCategoria=' + codCategoria + '&codVariable=' + codVariable;
        alert(data);
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=darBajaConfVariables',
            data: data,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                TablaConfiCategCategorias();
            }
        });
    }

    function valCampoConfVariables() {
        let validator = $("#confVariablesCateg").validate({

            rules: {
                nomParametro: {required: true},
                selecCondicion: {required: true}
            },
            messages: {
                nomParametro: "Digite el número de Parametro",
                selecCondicion: "Seleccione Condicion"
            }
        });
        let estado = validator.form();
        if (estado) {
            registrarConfig();
        }

    }





</script>

