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
                <form id="formFiltrarAsistencia" class="col-md-7">
                    <div class="d-flex my-2 my-lg-0 gap-3">
                        <label>Fecha</label>
                        <input name="fechaAsistencia" id="fechaAsistencia" class="form-control mr-sm-2 rounded" type="date">
                        <input id="nombreAsistencia" class="form-control mr-sm-2 rounded" type="text" placeholder="INGRESE NOMBRE">
                        <select id="tipAsistencia" class="form-control mr-sm-2 rounded">
                            <option  value="0">-- SELECCIONE --</option>
                            <option >PUNTUAL</option>
                            <option >TARDANZA</option>
                            <option >AUSENTE</option>
                        </select>
                        <button class="btn btn-success my-sm-0 text-white" onclick="listarAsistenciaDiario('1', '1');" type="button">FILTRAR</button>
                    </div>
                </form>
                <div class="d-flex align-items-center gap-1">
                    <button class="btn btn-info text-white " onclick="generarReportAsistencia();"><i class="fa fas fa-download"></i> GENERAR REPORTE</button>
                    <!--<button class="btn btn-info text-white " onclick="crearReportAsistenciaTXT();"><i class="fa fas fa-download"></i> GENERAR REPORTE</button>-->
                    <button class="btn btn-success text-white " onclick="modalCargaAsistencia();"><i class="fa fa-upload"></i> CARGAR ASISTENCIA</button> 
                </div>        
            </div>
            <hr>
            <h4 class="card-title">LISTA DE ASISTENCIAS</h4>
            <!--<div class="table-responsive">-->
            <table id="tablaUsuarios" class="table table-striped table-bordered" width="100%" autocomplete="off">
                <thead>
                    <tr>
                        <th>DATOS PERSONALES</th>
                        <th>N° DNI</th>
                        <th>FECHA</th>
                        <th>HORA INGRESO</th>
                        <th>CARGO</th>
                        <th>ASISTENCIA</th>
                        <th>OPCIONES</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        <!--</div>-->
        <!-- Modal -->
        </div>
    </div>    
</div>
<!-- MODAL DE CARGAR ASISTENCIA -->
<div class="modal fade " id="modalCargaAsistencia" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModal">
                    CARGAR ASISTENCIA DEL DIA
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" onclick="closeNuevo();">
                </button>
            </div>
            <div class="modal-body">
                <form method="post" id="formAsistencia">
                    <div class="form row">
                        <div  class="form-group col-md-3"></div>
                        <div class="form-group col-md-6">
                            <label>FECHA DE ASISTENCIA</label>
                            <input type="date" id="fecIni" name="fecIni" class="form-control rounded-lg" />
                        </div>
                        <div  class="form-group col-md-3"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal" onclick="closeNuevo();">CANCELAR</button>
                <button type="button" class="btn btn-success text-white" onclick="cargaAsistencia();">CARGAR</button>

            </div>
            <div class="content-loader visually-hidden" id="ico-loader">
                <div class="loader">
                </div>
            </div>
        </div>
    </div>
</div>

<!------ MODAL JUSTIFICA ASISTENCIA ---->
<div class="modal fade " id="modalRegJustificacion" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" > 
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <h5 class="modal-title text-white" id="titleModalJusti"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" onclick="closeNuevo();">
                </button>
            </div>
            <div class="modal-body">
                <form id="formJustificar">
                    <div class="form row">
                        <div  class="form-group col-md-1"></div>
                        <div class="form-group col-md-10">
                            <input type="hidden" id="codVendedor">
                            <input type="hidden" id="codAsistDet">
                            <p>
                                <b>DATOS: </b><span id="datosVendedor"></span>
                            </p>
                            <label>INGRESE MOTIVO *</label>
                            <textarea name="obsJustificacion" class="form-control rounded-lg" id="obsJustificacion"></textarea>
                            <p id="usuarioJust"></p>
                        </div>
                        <div  class="form-group col-md-1"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger text-white" data-bs-dismiss="modal">CANCELAR</button>
                <button id="btnJustificar" type="button" class="btn btn-success text-white" onclick="validarJustificar();">REGISTRAR</button>

            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#formFiltrarAsistencia input').keydown(function (e) {
            if (e.keyCode === 13) {
                e.preventDefault();
                console.log("funciona");
            }
        });
        $('#fechaAsistencia').attr({
            "max": limitarFechahoy(new Date())
        });
        $('#fecIni').attr({
            "min": limitarFechahoy(new Date()),
            "max": limitarFechahoy(new Date())
        });
        tablaUsuariosAsistencia = $('#tablaUsuarios').DataTable({
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
    function limitarFechahoy(fecha) {
        let hoy = fecha.toISOString().slice(0, 10);
        console.log(fecha);
        return hoy;
    }
    function downloadFile(filePath) {
        var link = document.createElement('a');
        link.href = filePath;
        link.download = filePath.substr(filePath.lastIndexOf('/') + 1);
        link.click();
    }
    function abrirModalJustificacion(cod_usu, cod_asistdet, datos) {
        $("#modalRegJustificacion").modal('show');
        $("#titleModalJusti").html("JUSTIFICAR TARDANZA O INASISTENCIA");
        $("#codVendedor").val(cod_usu);
        $("#codAsistDet").val(cod_asistdet);
        $("#datosVendedor").html(datos);
    }
    function validarJustificar(){
        let validator = $('#formJustificar').validate({
            rules: {
                obsJustificacion: {required: true}
            },
            messages: {
                obsJustificacion: "Ingrese la justifiación"
            }
        });
        let estado = validator.form();
        if (estado) {
            justificarAsistencia();
        }
    }
    function justificarAsistencia() {
        var fechas = $("#fechaAsistencia").val();
        var cod_usu = $("#codVendedor").val();
        var cod_asistdet = $("#codAsistDet").val();
        var obs = $("#obsJustificacion").val();
        var param = 'Accion=justificarAsistencia&cod_usu=' + cod_usu + '&cod_asistdet=' + cod_asistdet + '&fechas=' + fechas + '&obs=' + obs;
        var res = "";
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=justificarAsistencia',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                var valor = resultado.toString().split("_");
                //Mostrar Icono de Detalle de justificacion
                $('#asist'+cod_asistdet+'').toggleClass('hide');
                $('#detAsist'+cod_asistdet+'').toggleClass('hide');
                msjFinal(valor[0], valor[1]);
            }, complete: function () {
                $("#modalRegJustificacion").modal('hide');
            }
        });
    }
    function generarReportAsistencia() {
        var fecIni = $("#fechaAsistencia").val();
        var param = 'Accion=generarReportAsistencia&fecIni=' + fecIni;
        var urll;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=generarReportAsistencia',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                var valor = resultado.toString().split("_");
                console.log(valor);
                //msjFinal(valor[0], valor[1]);
                urll = valor[2];
            }, complete: function () {
                $("#fechaAsistencia").val(fecIni);
                listarAsistenciaDiario(fecIni, '2');
                downloadFile(urll);

            }
        });
    }

    function crearReportAsistenciaTXT() {
        var fecIni = $("#fecIni").val();
        var param = 'accion=crearReportAsistenciaTXT&fecIni=' + fecIni;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=crearReportAsistenciaTXT',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
            }, complete: function () {

                //listarAsistenciaDiario(fecIni, '2'); 
            }
        });

    }

    function cargaAsistencia() {
        let validator = $("#formAsistencia").validate({
            rules: {
                fecIni: {required: true}
            },
            messages: {
                fecIni: "Seleccione la fecha"
            }
        });
        let estado = validator.form();
        if (estado) {
            var fecIni = $("#fecIni").val();
            var param = 'Accion=cargaAsistencia&fecIni=' + fecIni;
            loaderON();
            $.ajax({
                type: 'POST',
                url: '../../reHumanosServlet',
                data: param,
                beforeSend: function () {
                }, success: function (resultado) {
                    loaderOFF();
                    var valor = resultado.toString().split("_");
                    console.log(valor);
                    msjFinal(valor[0], valor[1]);
                    $("#modalCargaAsistencia").modal("hide");
                    $("#fechaAsistencia").val(fecIni);
                    listarAsistenciaDiario(fecIni, '2');

                }, complete: function () {
                }, error: function (e) {
                    loaderOFF(); 
                    console.log("ERROR EN CARGA ASISTENCIA");
                }
            });
        }

    }

    function listarAsistenciaDiario(fecha, opcion) {
        let validator = $("#formFiltrarAsistencia").validate({
            rules: {
                fechaAsistencia: {required: true}
            },
            messages: {
                fechaAsistencia: "Seleccione la fecha"
            }
        });
        let estado = validator.form();
        if (estado) {
            var fechaAsis = '';
            if (opcion == '1') {
                fechaAsis = $("#fechaAsistencia").val();
            } else {
                fechaAsis = fecha;
            }

            var nombreAsis = $("#nombreAsistencia").val();
            let estado = $('#tipAsistencia').val();
            var param = 'accion=listarAsistenciaDiario&fechaAsis=' + fechaAsis + '&nombreAsis=' + nombreAsis + '&estado=' + estado;
            //alert(param);
            $.ajax({
                type: 'POST',
                url: '../../reHumanosServlet?Accion=listarAsistenciaDiario',
                data: param,
                dataType: 'json',
                beforeSend: function () {
                }, success: function (resultado) {
//                    $('#listAsistenciaDiario').html(resultado);
                    llenarTablaAsistencia(resultado);
                }, complete: function () {
                }
            });
        }
    }
    ;
    function llenarTablaAsistencia(data){
        tablaUsuariosAsistencia.clear().draw();
        $.each(data,function (){
            let asistencia = this['sitAsistencia'];
            let codJustifi = this['codJustificacion'];
            let datoPer = this['nombreUsuario']+ ' '+ this['apePaternoUsuario']+' '+this['apeMaternoUsuario'];
//          let colorEstado = estado !== 'ACTIVO' ? "bg-danger text-white p-1 rounded-3" : "bg-success text-white p-1 rounded-3";
            let inpuntual = '';
            if(asistencia == "TARDANZA" && codJustifi == '0'){
                inpuntual = '<a class=\'pe-1\' id=\"asist'+this['codigoAsisDet']+'\" href=\'#\' onclick=\"abrirModalJustificacion(' + this['codigoUsuario'] 
                        +','+ this['codigoAsisDet'] 
                        + ',\''+datoPer +'\');\" title=\'JUSTIFICAR ASISTENCIA\'>\n\
                    <i class=\'far fa-clock otras-opciones\' ></i>\n\
                </a>'+'<a class=\'pe-1 hide\' id=\"detAsist'+this['codigoAsisDet']+'\" href=\'#\' onclick=\"detalleModalJustificacion('+this['codigoAsisDet']+",'"+datoPer +'\');\" \n\
                    title=\'DETALLE DE JUSTIFICACION\'>\n\
                            <i class=\'fas fa-clock otras-opciones\' ></i>\n\
                </a>';
            
            }else if(asistencia == "TARDANZA" && codJustifi == '1'){
                inpuntual = '<a class=\'pe-1 \' href=\'#\' onclick=\"detalleModalJustificacion('+this['codigoAsisDet']+",'"+datoPer +'\');\" \n\
                    title=\'DETALLE DE JUSTIFICACION\'>\n\
                            <i class=\'fas fa-clock otras-opciones\' ></i>\n\
                </a>';
            }
            
//            let estado = asistencia == "TARDANZA" ? inpuntual : '';
            
            tablaUsuariosAsistencia.row.add([
                this['nombreUsuario'],
                this['numeroDOI'],
                this['fechaMarcacion'],
                this['horaMarcacion'],
                this['descPerfil'],
                this['sitAsistencia'],
                inpuntual
            ]).draw(false);
        });
    }
    function detalleModalJustificacion(codAsist, datoPer){
        $('#btnJustificar').addClass('hide');
        $('#titleModalJusti').html("DETALLE DE JUSTIFICACION");
        $("#modalRegJustificacion").modal('show');        
        $("#datosVendedor").html(datoPer);
        listaJustificacion(codAsist);
    }
    function listaJustificacion(codAsist){
        $.ajax({
                type: 'POST',
                url: '../../reHumanosServlet?Accion=listaJustificacion',
                data: 'codAsistDet='+codAsist,
                dataType: 'json',
                beforeSend: function () {
                }, success: function (resultado) {
                    llenarDetalleJustificacion(resultado);
                }, complete: function () {
                }
            });
    }
    function llenarDetalleJustificacion(data){
        $('#obsJustificacion').attr('readonly', true);
        $('#obsJustificacion').val(data.observacion);
    }
    function modalCargaAsistencia() {
        $("#modalCargaAsistencia").modal("show");
    }
    function closeNuevo() {
        $("#modalNuevo").modal("hide");
    }

</script>