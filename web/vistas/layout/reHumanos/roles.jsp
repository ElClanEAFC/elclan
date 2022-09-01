<%
    HttpSession session_actual = request.getSession(true);
    String codPagina = (String) session_actual.getAttribute("codMo");
%>
<input type="hidden" name="codArea" id="codArea" value="<%=codPagina%>">
<!--============================================================================
FIN MODALES
=============================================================================-->

<!--===========fin del menu del historial de navegacion=============-->
<div class="container-fluid">
    <div class="row">

        <div class="col-md-12">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <!-- contenido -->
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-12">
                                        <h4 class="card-title titPagRol"> </h4>
                                    </div>
                                    <hr>
                                    <br>
                                </div>
                                <div class="row gap-2">
                                    <div class="col-md-3">
                                        <form class="col-12" id="frmCargo">
                                            <h4 class="card-title titOpPerfil">AGREGAR NUEVO ROL O CARGO</h4>
                                            <hr>
                                            <input type="hidden" name="codPerfil" id="codPerfil">
                                            <label for="perfilRol">NOMBRE ROL O CARGO *</label>
                                            <input type="text" name="nomPerfil" id="nomPerfil" name="nomPerfil" class="form-control">
                                            <p class="input-error" id="label-nomPerfil">No se aceptan caracteres espciales ni números.</p>
                                            <br>                                            
                                        </form>
                                        <button class="btn btn-danger text-white hide" onclick="cancelActPerfil();"  id="btnCanPerfil">CANCELAR</button>
                                        <button class="btn btn-success  text-white" onclick="validarCrearCargo();"  id="btnPerfil">GUARDAR</button>
                                    </div>
                                    <div class=" col-0 col-md-1"><br></div>
                                    <div class="col-12 col-md-7">
                                        <h4 class="card-title">LISTA DE ROLES O CARGO</h4>
                                        <hr>
                                        <div class="table-responsive">
                                            <table id="tablaUsuarios" class="table  table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>N°</th>
                                                        <th>ÁREA</th>
                                                        <th>PERFIL O CARGO</th>
                                                        <th>ESTADO</th>
                                                        <th>U. CREACION</th>
                                                        <th>F. CREACION</th>
                                                        <th>OPCIONES</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="lisPerfil">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $.validator.addMethod("inputTrim", function (value, element, param) {
            if (value.replace(/[^0-9]/g, '') || value.replace(/^[^-_#'"\\\/<>=*@&]*$/, '')) {
                return false;
            }
            return this.optional(element) || value.trim().length > 0;
        });
    });
    segundaCarga();
    function segundaCarga() {
//    var codArea = $("#codArea").val();
        returnNomArea(codAreaSend);
        listarPerfilesArea(codAreaSend);
        $("#nomPerfil").val("");
    }
    function actualizarPerfil() {
        var codArea = $("#codArea").val();
        var codPerf = $("#codPerfil").val();
        var nomPerf = $("#nomPerfil").val().trim();
        var nomUsu = $("#nomUser").val();
        var noArea = $("#noArea").val();
        //alert(nomUsu);
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=actualizarPerfil',
            data: 'codArea=' + codArea + '&codPerf=' + codPerf + '&nomPerf=' + nomPerf,
            beforeSend: function () {
            }, success: function (resultado) {
                var valor = resultado.toString().split("_");
                console.log(valor);
                if (valor[1] === '1') {
                    Swal.fire({
                        icon: 'success',
                        text: valor[0],
                        showConfirmButton: false,
                        timer: 2500
                    });
                    updateCargos = false;
                    listarPerfilesArea(codArea);
                } else {
                    Swal.fire({
                        icon: 'error',
                        text: valor[0],
                        showConfirmButton: false,
                        timer: 2500
                    });
                }
            }, complete: function () {
                //window.location.href = "roles.jsp?codArea="+codArea+"&nomPerf="+nomPerf;
            }
        });
    }

    function confirBorrarPerfil(codPerfil) {
        var codArea = $("#codArea").val();
        Swal.fire({
            title: 'Mensaje',
            text: "Esta seguro de borrar el Cargo o Perfil?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#48C28D',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Continuar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../../reHumanosServlet?Accion=confirBorrarPerfil',
                    data: 'codPerfil=' + codPerfil,
                    beforeSend: function () {
                    }, success: function (resultado) {
                        //$("#"+mostrar).html(resultado);
                        var valor = resultado.toString().split("_");
                        if (valor[1] === '1') {
                            Swal.fire({
                                icon: 'success',
                                text: valor[0],
                                showConfirmButton: false,
                                timer: 2500
                            });
                        } else {
                            Swal.fire({
                                icon: 'error',
                                text: valor[0],
                                showConfirmButton: false,
                                timer: 2500
                            });
                        }
                        $("#nomPerfil").val('');
                        listarPerfilesArea(codArea);
                    }, complete: function () {
                        //listarPerfiles(codArea);
                    }
                });
            }
        });
    }

    function cancelActPerfil() {
        let validarArea = $("#frmCargo").validate();
        validarArea.destroy();
        $("#codPerfil").val("");
        $("#nomPerfil").val("");
        $("#btnPerfil").attr("onclick", "validarCrearCargo()");
        $("#btnPerfil").html('GUARDAR');
        $(".titOpPerfil").html("Registrar Perfil");
        $("#btnCanPerfil").addClass("hide");
        listarPerfilesArea();
    }

    function editPerfil(codPerfil, nomPerfil) {
        let validarArea = $("#frmCargo").validate();
        validarArea.destroy();
        updateCargos = true;
        $("#codPerfil").val(codPerfil);
        $("#nomPerfil").val(nomPerfil);
        $("#btnPerfil").attr("onclick", "validarCrearCargo()");
        $("#btnPerfil").html('ACTUALIZAR');
        $("#btnCanPerfil").removeClass("hide");
        $(".titOpPerfil").html("Actualizar Perfil");
    }

    function guardarCargo() {
        //var codArea   = $("#codPerfil").val();
        var nomPerfil = $("#nomPerfil").val().trim();
        var codArea = $("#codArea").val();
        var param = 'nomPerfil=' + nomPerfil + '&codArea=' + codArea;
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=guardarCargo',
            data: 'codArea=' + codArea + '&nomPerfil=' + nomPerfil,
            beforeSend: function () {
            }, success: function (resultado) {
                let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $("#nomPerfil").val('');
                    listarPerfilesArea(codArea);
                } else {
                    msjFinal(res[0], res[1]);
                }
                //$("#"+mostrar).html(resultado);
            }, complete: function () {
//            direcPagina(codArea, "REC_HUMANO", "../layout/reHumanos/roles.jsp");
                //listarPerfiles(codArea);
            }
        });
    }

    function listarPerfilesArea(codArea) {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listarPerfilesArea',
            data: 'codArea=' + codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#lisPerfil").html(resultado);
            }, complete: function () {
                //msjExitoso('El usuario fue dado de baja!');
            }
        });
    }
// VALIDAR INPUTS PARA CREAR CARGO
    function validarCrearCargo() {
        if (updateCargos && $('#btnPerfil').text() == "ACTUALIZAR") {
            updateCargos = true;
        } else {
            updateCargos = false;
        }
        let validator = $("#frmCargo").validate({
            rules: {
                nomPerfil: {
                    required: true,
                    inputTrim: true
                }
            },
            messages: {
                nomPerfil: {
                    required: "Ingrese una área",
                    inputTrim: "Ingrese un nombre valido"
                }
            }
        });
        let estado = validator.form();
        if (estado) {
            if (!updateCargos) {
                guardarCargo();
            } else {
                actualizarPerfil();
            }
        }
    }

    function returnNomArea(codArea) {
        $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=returnNomArea',
            data: 'codArea=' + codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                $(".titPagRol").html(resultado);
            }, complete: function () {
                //msjExitoso('El usuario fue dado de baja!');
            }
        });
    }

    function configurarRoles(sendCodArea, descArea, sendCodPerfil, descPerfil) {
        codArea = sendCodArea;
        codPerfil = sendCodPerfil;
        console.log(codArea + ' ' + codPerfil);
        direcPagina('2', 'REC_HUMANO', '../layout/reHumanos/config-roles.jsp', codArea, codPerfil);
    }

    /*********************VALIDACION DE LOS CAMPOS************************/
//const expresiones = {
//    nomPerfil: /^[a-zA-ZÀ-ÿ\s]{1,40}$/
//}
//
//const campos = {
//    nomPerfil: false
//}
//
//const validarFormulario = (e) => {
//    switch (e.target.name) {
//        case "nomPerfil":
//                validarCampos(expresiones.nomPerfil, e.target, 'nomPerfil');
//        break;
//    }
//}

//const validarCampos = (expresion, input, campo) => {
//    //alert("ex: "+expresion+" input: "+input+" campo: "+campo);
//    let button = document.getElementById("btnPerfil");
//    if(expresion.test(input.value)){
//        //alert("cumple");
//        document.getElementById("label-"+campo).classList.add("input-error");
//        document.getElementById("label-"+campo).classList.remove("input-error-activo");
//        campos[campo] = true;
//        button.disabled = false;
//    }else{
//        //alert(" no cumple");
//        document.getElementById("label-"+campo).classList.add("input-error-activo");
//        document.getElementById("label-"+campo).classList.remove("input-error");
//        campos[campo] = false;
//        button.disabled = true;
//    }
//}
//
//document.getElementById("nomPerfil").addEventListener('keyup', validarFormulario);
    /*    
     function segundaCarga(){
     var codArea = $("#codArea").val();
     listarPerfiles(codArea);
     }    
     function crearUsuario(){
     window.location("crearUsuario.jsp");
     }
     function guardarPerfil(){
     //var codArea   = $("#codPerfil").val();
     var nomPerfil = $("#nomPerfil").val();
     var codArea   = $("#codArea").val();
     var noArea    = $("#noArea").val();
     var param = 'nomPerfil='+nomPerfil+'&codArea='+codArea+'&noArea='+noArea;
     //alert(param);
     $.ajax({
     type: 'POST',
     url: '../../../reHumanosServlet?Accion=guardarCargo',
     data: 'codArea='+codArea+'&nomPerfil='+nomPerfil,
     beforeSend: function () {
     }, success: function (resultado) {
     //$("#"+mostrar).html(resultado);
     }, complete: function () {
     window.location.href = "roles.jsp?codArea="+codArea+"&nomArea="+noArea;
     //listarPerfiles(codArea);
     }
     });
     }
     function confirBorrarPerfil(codPerfil){
     Swal.fire({
     title: 'Mensaje',
     text: "Esta seguro de desactivar el Perfil",
     icon: 'warning',
     showCancelButton: true,
     confirmButtonColor: '#48C28D',
     cancelButtonColor: '#d33',
     confirmButtonText: 'Continuar',
     cancelButtonText: 'Cancelar'
     }).then((result) => {
     if (result.isConfirmed) {
     borrarPerfil(codPerfil);
     }
     })
     
     }
     
     function borrarPerfil(codPerfil){
     var nomUsu  = $("#nomUser").val();
     
     var codArea   = $("#codArea").val();
     var noArea    = $("#noArea").val();
     $.ajax({
     type: 'POST',
     url: '../../../reHumanosServlet?Accion=borrarPerfil',
     data: 'codPerfil='+codPerfil+'&nomUsu='+nomUsu,
     beforeSend: function () {
     }, success: function (resultado) {
     //$("#"+mostrar).html(resultado);
     }, complete: function () {
     window.location.href = "roles.jsp?codArea="+codArea+"&nomArea="+noArea;
     }
     });
     }
     
     
     function editPerfil(codPerfil, nomPerfil){
     
     $("#codPerfil").val(codPerfil);
     $("#nomPerfil").val(nomPerfil);
     $("#btnPerfil").attr("onclick","actualizarPerfil()");
     $("#btnPerfil").html('Actualizar');
     }
     
     function actualizarPerfil(){
     var codArea = $("#codArea").val();
     var codPerf = $("#codPerfil").val();
     var nomPerf = $("#nomPerfil").val();
     var nomUsu  = $("#nomUser").val();
     var noArea  = $("#noArea").val();
     //alert(nomUsu);
     $.ajax({
     type: 'POST',
     url: '../../../reHumanosServlet?Accion=actualizarPerfil',
     data: 'codArea='+codArea+'&codPerf='+codPerf+'&nomPerf='+nomPerf+'&nomUsu='+nomUsu,
     beforeSend: function () {
     }, success: function (resultado) {
     }, complete: function () {
     window.location.href = "roles.jsp?codArea="+codArea+"&nomArea="+noArea;
     }
     });
     }
     
     function listarPerfiles(codArea){
     $.ajax({
     type: 'POST',
     url: '../../../reHumanosServlet?Accion=listarPerfiles',
     data: 'codArea='+codArea,
     beforeSend: function () {
     }, success: function (resultado) {
     $("#lisPerfil").html(resultado);
     }, complete: function () {
     //msjExitoso('El usuario fue dado de baja!');
     }
     });
     }
     
     function agregarUsuario(){
     $('#modalAgregarUsuario').modal('show')
     
     }
     /****************************************
     *       Basic Table                   *
     ****************************************/

</script>