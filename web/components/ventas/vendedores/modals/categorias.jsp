<%-- 
    Document   : categorias
    Created on : 2 set. 2022, 11:06:46
    Author     : sistemas02
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>

    .col-12{
        margin-bottom: 10px;
    }


</style>


<div class="tab-pane fade show active" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0" >
    <div class=" bg-white border-top border-danger border-3">
        <div class="card">
            <div class="card-body p-t-40 " >
                <div class="row">


                    <div class="col-12 col-lg-3">
                        <select class="form-control" id="BuscadorCategoria">
                            <option  value="0" >--INGRESE NOMBRE DE CATEGORIA--</option>
                        </select>
                    </div>

                    <div class="col-12 col-lg-3"  >
                        <button class="btn btn-success my-sm-0 text-white" onclick="ObtenerCategoria();">BUSCAR</button> 

                    </div>

                    <div class="col-12 col-lg-6 posicion text-end">
                        <button class="btn btn-success my-sm-0 text-white" onclick="abrirModalGuardar();">AÑADIR CATEGORIA</button>
                    </div>


                </div>
                <hr>
                <h4 class="card-title">LISTA DE CATEGORIAS</h4>


                <table id="tablaCategoria" class="table table-striped text-center " width="100%" autocomplete="off">
                    <thead>
                        <tr>
                            <!-- <th >CODIGO CATEGORIA</th> -->
                            <th >DESCRIPCION CATEGORIA</th>
                            <th>ESTADO</th>
                            <th>USUARIO CREADOR</th>
                            <th>FECHA CREACION</th>
                            <th>OPCIONES</th>
                        </tr>
                    </thead>                    
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Modal AGREGAR CATEGORIA -->
<div class="modal fade"  tabindex="-1" aria-hidden="true" id="AñadirCategoria" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleCategoria">REGISTRAR CATEGORIA</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <form class="form row" id="formCategoria">
                    <div class="form-group col-md-8"">
                        <input class="input-group input-group-lg m-t-20 p-l-50" type="text" id="desCategoria" name="AgreCategoria" oninput="mayus(this);" placeholder="INGRESE NOMBRE DE  CATEGORIA">
                    </div>

                    <div class="form-group col-4">
                        <button type="button" class="btn btn-success col-md-8 text-white m-t-15" onclick="validarCamposCat();">AGREGAR</button>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal ACTUALIZA CATEGORIA -->
<div class="modal fade"  tabindex="-1" aria-hidden="true" id="ActualizaCategoria"  aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleCategoria">ACTUALIZAR CATEGORIA</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <form class="form row" id="formCategoria">
                    <div class="form-group col-md-8"">
                        <input class="input-group input-group-lg m-t-20 p-l-50" type="text" id="desCategoriaAc" name="desCategoriaAct" oninput="conviertMayucula(this);" >
                    </div>

                    <div class="form-group col-4">
                        <button type="button" class="btn btn-success text-white m-t-15 " onclick="ActualizarCategoria();">ACTUALIZAR</button><!-- col-md-8 text-white m-t-20  -->
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
            </div>
        </div>
    </div>
</div>


<script>



    //Configurar Tabla tablaCategoria
    tablaCategoria = $('#tablaCategoria').DataTable({
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
    // Funcion para validar datos de categoria
    function validarCamposCat() {
        let validator = $("#formCategoria").validate({
            rules: {
                AgreCategoria: {required: true}
            },
            messages: {
                AgreCategoria: "Agregar nombre de categoria..!"
            }
        });
        let estado = validator.form();
        if (estado) {
            RegistroCategoria();
        }
    }

    function abrirModalGuardar() {
        $('#AñadirCategoria').modal('show');
        $('#desCategoria').val('');
    }


    //Funtion carga la tabla categoria
    listaCategoria();
    function listaCategoria() {
        let codCategoria = $('#BuscadorCategoria').val();
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=listaCategoria',
            date: 'codCategoria=' + codCategoria,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                llenarTablaCategoria(resultado);
                BuscadorCategoria(null);
            }, complete: function () {

            }

        });

    }
    //Funtion llena la tabla categoria
    function llenarTablaCategoria(data) {
        tablaCategoria.clear().draw();
        $.each(data, function () {
            let codCategoria = this['v_codCategoria'].toString();
            let desCategoria = this['v_desCategoria'].toString();

            let estado = this['v_estado'].toString();
            let colorEstado;
            if (estado === 'ACTIVO') {
                colorEstado = "bg-success text-white p-1 rounded-3";
            } else {
                colorEstado = "bg-danger text-white p-1 rounded-3";
            }


            tablaCategoria.row.add([
                //codCategoria,
                desCategoria,
                "<span class=\" " + colorEstado + "\">" + this['v_estado'] + "</span>",
                this['v_usuario'],
                this['v_fechaCreacion'],
                '<a class=\'pe-1\' href=\'#\' \" title=\'Actualizar Categoria\'  onclick="abrirModalActualizar(' + codCategoria + ',\'' + desCategoria + '\');" > <i class=\'fas fa-edit editar\' ></i></a>' + //onclick="ActualizarCategoria();"
                        '<a class=\'pe-1\' href=\'#\' \" title=\'Eliminar Categoria\' onclick="confirBorrarCateg(' + codCategoria + ',\'' + desCategoria + '\');"> <i class=\'fas fa-trash-alt borrar \' ></i></a>'



            ]).draw(false);

        });
    }


    //Funcion Llena el select 2 de la tabla categoria
    BuscadorCategoria();
    async function BuscadorCategoria() {
        let codigo = $('#BuscadorCategoria').val();

        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=buscarCategoria',
            data: codigo,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#BuscadorCategoria").html(resultado);

            }, complete: function () {

            }
        });
    }

    //Filtra el select 2 y al darle buscar se refresca la tabla categoria
    async function ObtenerCategoria() {
        alert(" hOLA  "+codigo);
        await $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=FiltrarCategoria',
            data: 'BuscadorCategoria=' + codigo,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                llenarTablaCategoria(resultado);

            }, complete: function () {

            }
        });
    }
//Funcion registra categoria
    async function RegistroCategoria() {

        let desCategoria = $('#desCategoria').val();
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=registrarCategoria',
            data: 'desCategoria=' + desCategoria,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    $('#AñadirCategoria').modal('hide');
                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                listaCategoria();
                BuscadorCategoria();
                TablaConfiCategCategorias();
            }
        });


    }


    function abrirModalActualizar(codCategoria, desCategoria) {
        $('#ActualizaCategoria').modal('show');
        $("#desCategoriaAc").attr("value", codCategoria);
        $('#desCategoriaAc').val(desCategoria);
    }


//Funcion Actualiza los Datos de la categoria
    function ActualizarCategoria() {
        let codCategoria = $("#desCategoriaAc").attr("value");
        let desCategoria = $('#desCategoriaAc').val();

        let data = 'codCategoria=' + codCategoria + '&desCategoria=' + desCategoria;
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=actualizarCategoria',
            data: data,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    $('#ActualizaCategoria').modal('hide');
                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                listaCategoria();

            }
        });
    }

    function confirBorrarCateg(codCategoria, desCategoria) {
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
         darBajaCategoria1(codCategoria, desCategoria);
         }
         });
        
        
    }

    //Funcion dar de Baja los Datos de la categoria
    function darBajaCategoria1(codCategoria, desCategoria) {
        
        let data = 'codCategoria=' + codCategoria + '&desCategoria=' + desCategoria;
        
        $.ajax({
            type: 'POST',
            url: '../../ventasServlet?Accion=darBajaCategoria5',
            data: data,
            dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    msjFinal(res[0], res[1]);
                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {
                listaCategoria();

            }
        });
    }





</script>
