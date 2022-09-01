<%-- 
    Document   : index
    Created on : 05/08/2021, 09:33:20 AM
    Author     : bcondori
--%>

<div class="container-fluid">
    <div class="row">
        <div id="mensaje"></div>
        <div class="col-md-12">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <!-- contenido -->
                        <div class="card">
                            <div class="card-body">
                                <div class="row gap-2">
                                    <div class="col-md-3">
                                        <form class="col-12" id="frmArea">
                                            <h4 class="card-title titOpArea">AGREGAR ÁREA</h4>
                                            <hr>
                                                <input type="hidden" name="codArea" id="codArea">
                                                <label for="usuCelular">NOMBRE DE AREA *</label>
                                                <input type="text" name="nomArea" id="nomArea" class="form-control" required="required">
                                                <p class="input-error" id="label-nomArea">No se aceptan caracteres espciales ni números.</p>
                                                <br>
                                                <!--<input type="submit" value="Guardar" id="btnArea" class="btn btn-success btn-lg text-white" onclick="guardarArea();">-->
                                        </form>
                                        <button class="btn btn-danger text-white hide" onclick="cancelActArea();"  id="btnCanArea">CANCELAR</button>
                                        <button class="btn btn-success text-white" type="button" onclick="validarCrearArea();"  id="btnArea">GUARDAR</button>                                        
                                    </div>
                                    <div class="col-0 col-md-1"><br></div>
                                    <div class="col-12 col-md-7">
                                        <h4 class="card-title">LISTA ÁREAS</h4>
                                        <hr>
                                        <div class="table-responsive">
                                            <table id="tablaUsuarios" class="table  table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>N°</th>
                                                        <th>NOMBRE AREA</th>
                                                        <th>U. CREACION</th>
                                                        <th>F. CREACION</th>
                                                        <th>OPCIONES</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="lisAreas">

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

$(document).ready(function (){
    $.validator.addMethod("inputTrim", function(value, element, param){
        if (value.replace(/[^0-9]/g,'') || value.replace(/^[^-_#'"\\\/<>=*@&]*$/,'')) {
            return false;
        }
        return this.optional(element) || value.trim().length > 0;
    }); 
//    $('#nomArea').on('input', function (){
//        var regex = new RegExp('^[a-zA-Z ]+$');
//        this.value = this.value.replace(regex,'');
//    });
});

function cargaMantenimientoAreas(){
    listarAreas();
    $("#nomArea").val("");
}
cargaMantenimientoAreas();

function cancelActArea(){
    let validarArea = $("#frmArea").validate();
    validarArea.destroy();
    $("#codArea").val("");
    $("#nomArea").val("");
    $("#btnArea").attr("onclick","validarCrearArea()");
    $("#btnArea").html('GUARDAR');
    $(".titOpArea").html("Registrar Área");
    $("#btnCanArea").addClass("hide");
    listarAreas();
}

function listarAreas(){
    $.ajax({
        type: 'POST',
        url: '../../reHumanosServlet?Accion=listarAreas',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#lisAreas").html(resultado);
        }, complete: function () {
            //msjExitoso('El usuario fue dado de baja!');
        }
    });
}
// VALIDAR INPUTS PARA CREAR AREA
function validarCrearArea() {
    if (updateAreas && $('#btnArea').text() == "ACTUALIZAR") {
        updateAreas = true;
    }else{
        updateAreas = false;
    }
    let validator = $("#frmArea").validate({
        rules: {
            nomArea: {
                required: true,
                inputTrim: true
            }
        },
        messages: {
            nomArea: { 
                required: "Ingrese una área",
                inputTrim: "Ingrese un nombre valido"
            }
        }
    });
    let estado = validator.form();
    if (estado) {
        if (!updateAreas) {
            guardarArea();        
        }else{
            actualizarArea();
        }
    }
}

function guardarArea(){
    var nomArea = $("#nomArea").val().trim();
        $.ajax({
           type: 'POST',
           url: '../../reHumanosServlet?Accion=guardarArea',
           data: 'nomArea='+nomArea,
           beforeSend: function () {
               //alert("alerta");
           }, success: function (resultado) {
               let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $("#nomArea").val("");
                    listarAreas();
                } else {
                    msjFinal(res[0], res[1]);
                }
              //$("#mensaje").html(resultado);
           }, complete: function () {
           }
        });  
        
}
     
function editArea(codArea, nomArea){
    let validarArea = $("#frmArea").validate();
    validarArea.destroy();
    updateAreas = true;
    $("#codArea").val(codArea);
    $("#nomArea").val(nomArea);
    $("#btnArea").attr("onclick","validarCrearArea()");
    $("#btnArea").html('ACTUALIZAR');
    $(".titOpArea").html("Actualizar Área");
    $("#btnCanArea").removeClass("hide");
}

function actualizarArea(){
    var codArea = $("#codArea").val();
    var nomArea = $("#nomArea").val().trim();
    //alert("actualizarArea");
    $.ajax({
        type: 'POST',
        url: '../../reHumanosServlet?Accion=actualizarArea',
        data: 'codArea='+codArea+'&nomArea='+nomArea,
        beforeSend: function () {
        }, success: function (resultado) {
            let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    $("#nomArea").val("");
                    listarAreas();
                    updateAreas = false;
                } else {
                    msjFinal(res[0], res[1]);
                }
        }, complete: function () {
        }
    });
}

function confirBorrarArea(codArea){
    Swal.fire({
        title: 'Mensaje',
        text: "Esta seguro de borrar el Area?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#48C28D',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Continuar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          borrarArea(codArea);
        }
      });
    
}

function borrarArea(codArea){
    var nomUsu  = $("#nomUser").val();
    $.ajax({
        type: 'POST',
        url: '../../reHumanosServlet?Accion=borrarArea',
        data: 'codArea='+codArea+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
            let res = resultado.toString().split("_");
                if (res[0] == 1) {
                    msjFinal(res[0], res[1]);
                    listarAreas();
                } else {
                    msjFinal(res[0], res[1]);
                }
           //$("#"+mostrar).html(resultado);
        }, complete: function () {
        }
    });
}

function verRoles(codArea){
    //alert(codArea);
    codAreaSend = codArea;
    ROUTER.load('roles');
//    direcPagina(codArea, "REC_HUMANO", "../layout/reHumanos/roles.jsp");
}





/*********************VALIDACION DE LOS CAMPOS************************/
//var expresiones = {
//    nomArea: /^[a-zA-ZÀ-ÿ\s]{1,40}$/
//} ;
//
//var campos = {
//    nomArea: false
//};

//var validarFormulario = (e) => {
//    switch (e.target.name) {
//        case "nomArea":
//                validarCampos(expresiones.nomArea, e.target, 'nomArea');
//        break;
//    }
//};

//var validarCampos = (expresion, input, campo) => {
//    //alert("ex: "+expresion+" input: "+input+" campo: "+campo);
//    let button = document.getElementById("btnArea");
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
//document.getElementById("nomArea").addEventListener('keyup', validarFormulario);
//
//document.getElementById("nomArea").addEventListener('blur', validarFormulario);

 /*   
function segundaCarga(){
    listarAreas();
}    
function crearUsuario(){
    window.location("crearUsuario.jsp");
}


function confirBorrarArea(codArea){
    Swal.fire({
        title: 'Mensaje',
        text: "Esta seguro de borrar el Area?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#48C28D',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Continuar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          borrarArea(codArea);
        }
      })
    
}

function borrarArea(codArea){
    var nomUsu  = $("#nomUser").val();
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=borrarArea',
        data: 'codArea='+codArea+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
           //$("#"+mostrar).html(resultado);
        }, complete: function () {
            listarAreas();
        }
    });
}

function editArea(codArea, nomArea){
    
    $("#codArea").val(codArea);
    $("#nomArea").val(nomArea);
    $("#btnArea").attr("onclick","actualizarArea()");
    $("#btnArea").html('Actualizar');
}

function actualizarArea(){
    var codArea = $("#codArea").val();
    var nomArea = $("#nomArea").val();
    var nomUsu  = $("#nomUser").val();
    //alert(nomUsu);
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=actualizarArea',
        data: 'codArea='+codArea+'&nomArea='+nomArea+'&nomUsu='+nomUsu,
        beforeSend: function () {
        }, success: function (resultado) {
        }, complete: function () {
            listarAreas();
        }
    });
}


/*
function agregarUsuario(){
    $('#modalAgregarUsuario').modal('show')

}
/****************************************
 *       Basic Table                   *
 ****************************************/


</script>