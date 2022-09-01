<%-- 
    Document   : index
    Created on : 05/08/2021, 09:33:20 AM
    Author     : bcondori
--%>


<%
    String nomArea   ;
    String codPerfil ;  
    String desPerfil ;
    String cod1      ;
    String cod2      ;
    
    HttpSession session_actual = request.getSession(true);
    cod1 = (String) session_actual.getAttribute("cod1"); 
    cod2 = (String) session_actual.getAttribute("cod2");

%>


<!--============================================================================
MODALES
=============================================================================-->
<div id="crearUsu"></div>
<input type="hidden" name="codArea" id="codArea" value="<%=cod1%>">
<input type="hidden" name="codPerfil" id="codPerfil" value="<%=cod2%>">
<!-----------------AGREGAR USUARIO---------------------------------------->

<!--============================================================================
FIN MODALES
=============================================================================-->

<div class="container-fluid">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="exampleFormControlSelect1">SELEECIONE EL ÁREA:</label>
                    <select class="form-control" id="selectArea" >

                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="exampleFormControlSelect1">SELECCIONE EL PERFIL / CARGO:</label>
                    <select class="form-control" id="selectPerfil">
                        <option></option>
                    </select>
                </div>

                <div class="col-md-12 rounded-3 bg-white px-5 pt-4 hide modulos" id="contentModuls">
                    <div class="card gap-1 bg-light" id="cardModulos">

                    </div>
                </div>
                <div class="text-center hide py-3 pb-0 gap-3" id="btnGuardar">
                    <button class="col-md-1 btn bg-danger  text-white" onclick="cancelarSeleccion();">CANCELAR</button>            
                    <button class="col-md-1 btn btn-success text-white" onclick="guardarPersmisosPerfil();">GUARDAR</button>            
                </div>
            <!-- ===== LOADER ======= -->
            </div>
        </div>
     </div>
</div>
    <div class="content-loader visually-hidden" id="ico-loader">
        <div class="loader">
        </div>
    </div>
<script>
//listarModulosSubmodulos();
var arr = [];

function segundaCarga(){
//    var codArea = $("#codArea").val();
//    var codPerfil = $("#codPerfil").val();
//    if (codPerfil === "0"){
//        cargarAreas('selectArea');
//        listarModulos();
//    }else{
//        listarModulos();
//    }
}

$(document).ready(async function() {
    let codArea = $("#codArea").val();
    let codPerfil = $("#codPerfil").val();
    console.log(codArea+ " " +codPerfil);
    if(codArea > 0){
        await listarAllAreas();
        $("#selectArea").val(codArea); 
        await listarPerfiles(codArea);
        $("#selectPerfil").val(codPerfil);
        listarModulosSubmodulos(codPerfil);
    }else{
        listarAllAreas();                
    }
    $('#selectArea').change(async function() {
        var codArea = this.value;
        await listarPerfiles(codArea);
    });
    $('#selectPerfil').change(function() {
        var codPerfil = this.value;
        listarModulosSubmodulos(codPerfil);
//        setTimeout( ()=> {
//            $("#contentModuls").removeClass("hide");
//            $("#btnGuardar").removeClass("hide");            
//        },2000);
    });
});

async function listarAllAreas(){
    await $.ajax({
        type: 'POST',
        url: '../../reHumanosServlet?Accion=listarAllAreas',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
            $("#selectArea").html(resultado);
        }, complete: function () {
        }
    });
//    console.log(codPerfil + ' ' + codArea);
}
async function listarPerfiles(codArea){
    await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listarPerfiles',
            data: 'codArea='+codArea,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#selectPerfil").html(resultado);
            }, complete: function () {
            }
        });
}
function cancelarSeleccion(){
    var codPerfil = $("#selectPerfil").val();
    listarModulosSubmodulos(codPerfil);
}
function listarModulosSubmodulos(codPerfil){
    loaderON();
    $.ajax({
        type: 'POST',
        url: '../../reHumanosServlet?Accion=listarModulos',
        data: 'codPerfil='+codPerfil,
        beforeSend: function () {
        }, success: function (resultado) {
            $("#cardModulos").html(resultado);
            setTimeout( ()=> {
            $("#contentModuls").removeClass("hide");
            $("#btnGuardar").removeClass("hide");            
        },0000);
        loaderOFF();
        }, complete: function () {
        }
    });
}
function desplegarSubModulos(payloat){
    $("#"+payloat+"").toggleClass("hide");
    $("#"+payloat+"").toggleClass("d-flex flex-wrap gap-2");
}
function desactivarPermisoModulo(codModulo){
    var codPerfil = $("#selectPerfil").val();
    var param = 'codPerfil='+codPerfil+'&codModulo='+codModulo;
    $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=desactivarPermisoModulo',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
               var men = resultado.split("-"); //retorna un array
               var txt01 = men[0];
               var txt02 = men[1];
               if(txt01=='0'){
                   mensajeAlerta(txt02);
               }else{
                   listarPermisosPerfil();
               }
            }, complete: function () {
                listarPermisosPerfil();
            }
        });
    
}
function desactivarPermisoSubModulo(codSubModulo,codModulo){
    var codPerfil = $("#selectPerfil").val();
    var param = 'codPerfil='+codPerfil+'&codSubModulo='+codSubModulo+'&codModulo='+codModulo;
    $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=desactivarPermisoSubModulo',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
               //$("#tbody-permisos").html(resultado);
            }, complete: function () {
                listarPermisosPerfil();
            }
        });
    
}
function listarPermisosPerfil(){
    var codPerfil = $("#selectPerfil").val();
    $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarPermisosPerfil',
            data: 'codPerfil='+codPerfil,
            beforeSend: function () {
            }, success: function (resultado) {
               $("#tbody-permisos").html(resultado);
            }, complete: function () {

            }
        });
}
function removePermiso(codModulo){
    arr = arr.filter((r) => r !== codModulo);
    console.log(arr + " REMOVIDO RESULTADO:");
    $('#check'+codModulo).removeAttr('checked');
    $('input[name="checkSubModul['+codModulo+']"]').each(function(){
        $(this).prop('checked', false);
    }); 
    $('input[name="checkPermiso['+codModulo+']"]').each(function(){
        $(this).prop('checked', false);
    });  
}
function addPermiso(codModulo){
//        $('#check'+codModulo).prop('checked', true);     
        $('#inCheck'+codModulo).removeAttr('checked'); 
}
function guardarPersmisosPerfil(){
    var codArea   = $("#selectArea").val();
    var codPerfil = $("#selectPerfil").val();    
    //MODULOS
    $('[name="checkModulos"]:checked').each(function(){
      if(this.value){
        arr.push(this.value);          
      }
    });    
    var codMod = arr.join(',');
    //SUB-MODULOS
    var daSub = $('.checkSubModul:checked').map(function() {
        return this.value;
    }).get();
    var codSub = daSub.join(',');
    //PREMISOS
    var daPerm = $('.checkPermiso:checked').map(function() {
        return this.value; 
    }).get();
    var codPer = daPerm.join(',');
    
    var data = {codMod: codMod,
             codSub: codSub,
             codPer: codPer};
    console.log(Object.values(data));
    $.ajax({
        type: 'POST',
        url: '../../reHumanosServlet?Accion=guardarRoles',
        data: 'codPerfil='+codPerfil+'&codArea='+codArea+'&codMod='+codMod+'&codSub='+codSub+'&codPer='+codPer,
        beforeSend: function () {
        }, success: function (resultado) {
           let res = resultado.toString().split("_");
           msjFinal(res[0],res[1]); 
           console.log(resultado);           
           console.log("======== FUNCIONO =======");
        }, complete: function () {
           
        }
    });
    arr = [];
}

$("#ckSubModulo").change(function () {
      $(".ckSubModulo").prop('checked', $(this).prop("checked"));
      selectSubModulo();
});
/*
function selectSubModulo(){
    var arr = $('[name="checkSubModulos[]"]:checked').map(function(){
      return this.value;
    }).get();
    var str = arr.join(',');
    var contar = str.length;
    if(contar >=1){
        
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarSubModulos',
            data: 'codModulos='+str,
            beforeSend: function () {
            }, success: function (resultado) {
                //alert(resultado);
               $("#tbody-subModulos").html(resultado);
            }, complete: function () {
            }
        });
        $("#tbody-subModulos").css('display','block'); 
        
       alert(contar);
    }else{
        
        $(".ckPaginas").prop('checked', false);
        $("#tbody-paginas").css('display','none');
    }
}*/

function listarModulos(){
    
    $.ajax({
        type: 'POST',
        url: '../../../reHumanosServlet?Accion=listarModulos',
        data: '',
        beforeSend: function () {
        }, success: function (resultado) {
           $("#tbody-modulo").html(resultado);
        }, complete: function () {
           
        }
    });
}
$("#checkModulo").change(function () {
      $(".ckModulo").prop('checked', $(this).prop("checked"));
      valSeleccionado();
});
function valSeleccionado(){
    var arr = $('[name="checkModulos[]"]:checked').map(function(){
      return this.value;
    }).get();
    var str = arr.join(',');
    var contar = str.length;
    if(contar >=1){
        $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarSubModulos',
            data: 'codModulos='+str,
            beforeSend: function () {
            }, success: function (resultado) {
                //alert(resultado);
               $("#tbody-subModulos").html(resultado);
            }, complete: function () {
            }
        });
        $("#tbody-subModulos").css('display','table-row-group'); 
    }else{
        $(".ckSubModulo").prop('checked', false);
        $("#tbody-subModulos").css('display','none');
    }
}
function cargarAreas(mostrar){
        $.ajax({
            type: 'POST',
            url: '../../../utilitariosServlet?Accion=listaAreas',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
                $("#"+mostrar).html(resultado);
            }, complete: function () {
            }
        });
    }
/****************************************
 *       Basic Table                   *
 ****************************************/

</script>

</html>