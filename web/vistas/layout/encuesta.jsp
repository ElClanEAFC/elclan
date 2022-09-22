
<!DOCTYPE html>
<html dir="ltr" lang="en">

    <% String numDoc = request.getParameter("numDoc"); %> 
    <% String nomUsu = request.getParameter("nomUsu"); %> 
    <% String apePat = request.getParameter("apePat"); %> 
    <% String apeMat = request.getParameter("apeMat");%> 
    <% String codUsuario = request.getParameter("codUsuario");%> 



    <!--=========== inclui el archivo de la cabecera css o jquery ====================-->
    <jsp:include page="includes/header.jsp" />  

    <!-- ==================== Libreria Chart js ======================= -->
    <style>
        canvas {
            padding: 10px;
            min-height: 100px;
        }
        .title {
            color: #575757;
        }
    </style>
    <body >
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>

        <main id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
              data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
            <jsp:include page="includes/menu-superior.jsp" /> 
            <jsp:include page="includes/menu.jsp" />

            <div class="container-fluid border border-dark p-40 ">

                <div class="container ">
                    <label for="nuDoc">Inicio</label>

                </div>  


                <div class="container-md border border-danger ">

                    <label align="center" class="h2 pt-5"for="nuDoc">ENCUESTA DEL MOTIVO DE SU SALIDA</label>
                    <hr>
                    <br>



                    <div class="row justify-content-center">
                        <div class="col-12 ">
                            <label for="nuDoc">N° DOCUMENTO *</label> <br> 
                            <input type="text" id="numDoc" value="<%= numDoc%>">
                        </div>
                        <br> 
                    </div>

                    <div class="row">
                        <div class="col-12 col-lg-4">
                            <label for="nuDoc">NOMBRES *</label> <br> 
                            <input type="text" style="width : 100%; heigth : 1px;" id="numNombre" value="<%= nomUsu%>">
                        </div>
                        <br> 
                        <div class="col-12 col-lg-4">
                            <label for="nuDoc">APELLIDO PATERNO *</label><br> 
                            <input type="text" style="width : 100%; heigth : 1px;" id="apePaterno" value="<%= apePat%>">
                        </div>
                        <br> 
                        <div class="col-12 col-lg-4">
                            <label for="nuDoc">APELLIDO MATERNO *</label><br> 
                            <input type="text" style="width : 100%; heigth : 1px;" id="apeMaterno" value="<%= apeMat%>" >
                        </div>
                        <br> 
                        <br> 

                    </div>

                    <div class="row ">

                        <div class="col-12 ">
                            <div class="form-group mt-3">
                                <label class="">SELECIONE LOS MOTIVOS DE SU SALIDA</label><br> 
                                <div class="">
                                    <select class="select2 form-select shadow-none" id="selectRespuesta" multiple="multiple"style="height: 36px; width: 100%">

                                    </select>
                                </div>
                            </div>
                        </div>
                        <form id="formEncuesta">       

                            <div class="form row mb-3">
                                <div class="form-group col-12">
                                    <label for="name">OBSERVACIONES</label> <br> 
                                    <input type="text" class="form-control rounded-lg inputForm" id="name" name="nombre" placeholder="OBSERVACIONES"/>

                                </div>
                                <br> 
                            </div>
                        </form>

                        <hr>
                        <div class="row">
                            <div class="col-8 col-lg-8">

                            </div>
                            <div class="col-4  col-lg-4 mb-1">
                                <button class="btn btn-danger my-sm-0 text-white" onclick="cerrarPestaña();"  >CERRAR</button>
                                <button class="btn btn-success my-sm-0 text-white " onclick="guardarEncuesta();"  >GUARDAR</button><!-- guardarEncuesta validarCamposEncuesta--> 

                            </div>

                        </div>

                        <br>
                        <br>
                        <br>
                    </div>
                </div>



        </main>
        <!-- =========================footer - los script===========================-->
        <jsp:include page="includes/footer.jsp" />  


    </body>

</html>
<style TYPE="text/css" MEDIA=screen>
    .btn-danger{
        padding: 10px;
        margin-bottom: 10px;
    }
    .btn-success{
        padding: 10px;

    }
</style>

<script >
    function cerrarPestaña() {
        window.close();
    }

    $(".select2").select2();

    $("#numDoc").attr('readonly', 'readonly');
    $("#numNombre").attr('readonly', 'readonly');
    $("#apePaterno").attr('readonly', 'readonly');
    $("#apeMaterno").attr('readonly', 'readonly');




    function guardarEncuesta() {

        let codUsuario = <%= codUsuario%>;
        let codrespt = $("#selectRespuesta").val();
        let encObservaci = $("#name").val();

        let data = 'codUsuario=' + codUsuario + '&codrespt=' + codrespt + '&encObservaci=' + encObservaci;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=guardarEncuesta',
            data: data,
            //dataType: 'json',
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {

                    msjFinal(res[0], res[1]);

                } else {
                    msjFinal(res[0], res[1]);
                }
            }, complete: function () {

            }
        });
        setTimeout(function () {
            window.close().fadeOut(1000);
        }, 2000);

    }


    listarMotivos();
    async function listarMotivos() {
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaMotivosSalida',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selectRespuesta").html(resultado);
            }, complete: function () {
            }
        });
    }


    function validarCamposEncuesta() {
        let validator = $('#formEncuesta').validate({//formEncuesta  formSucursal
            rules: {
                nombre: {
                    required: true,
                    inputTrim: true
                },

                address: {

                }
            },
            messages: {
                nombre: {
                    required: "Ingrese Observaciónes",
                    inputTrim: "Ingrese Observaciónes validas"
                },

                address: {

                }
            }
        });
        let estado = validator.form();
        if (estado) {
            if (!updateSede) {
                guardarEncuesta();
            }
        }

        alert("Hola  " + resulta);


    }

</script>