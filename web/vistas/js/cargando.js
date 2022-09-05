
// ================ VARIABLES GLOBALES DE SUBMODULOS =================
// SUBMÓDULO USUARIOS
var listaPuestos;
var tableUsuarios;
let tablaExperiencias;
let allUsuarios;
let tablaCargosUsuario;
let validarErrorUser;
    //CREAR USUARIO
    var codUser='';
    var validarDB = false;
    var validarReniec = false;
//    let tablaCargosUsuario;
    let validarErrorForm;
// SUBMÓDULO SEDES
var codSede = '';
let updateSede = false;
var allSucursales;
let tablaSucursales;
let tablaUsuariosSucursal;
let tablaAreasSucursal;
//    var allUsuarios;

// SUBMÓDULO ÁREAS
let updateAreas = false;

// SUBMÓDULO ROLES
let codAreaSend = "";
let updateCargos = false;

// SUBMÓDULO CARGAR ASISTENCIA
let tablaUsuariosAsistencia; 

// SUBMÓDULO PERSONAL DE VENTA
var tablaVendedores; 
var tablaCategoria; 
var tablaConfigCategoria; 

// =================================================================
function msjFinal(codMsj, desMsj){
    if(codMsj=="1"){
        Swal.fire({
            icon: 'success',
            text: desMsj,
            showConfirmButton: false,
            timer: 1500
        }) 
    }else{
        Swal.fire({
            icon: 'error',
            text: desMsj,
            showConfirmButton: false,
            timer: 1500
        })
    }
}
// MOSTRAR LOADER DE CARGA 
function loaderON() {
    $('#ico-loader').removeClass('visually-hidden');
}
// OCULTAR LOADER DE CARGA
function loaderOFF() {
    $('#ico-loader').addClass('visually-hidden');
}
function limiteFechas(id, limite, fecha) {
    $("#"+id).attr(limite, fecha);
}
function limpiarFormulario(id){
    $("#"+id)[0].reset();
}
function Cancelar(id){
    $("#"+id).addClass('hide');  
}
function ocultar(id){
    $("#"+id).addClass('hide');
}
function primeraCarga(){
//    var url = $(location).attr('href');
//    var ul = url.split("layout/");
    cargaMenu();
    obtenerFecha();
    //segundaCarga();
    //obtenerUrl();
}
function direcPagina(codPagina, nemo, linPagina, cod1=0, cod2=0){
    let url = window.location;
    var param = 'codModu='+codPagina+'&nemo='+nemo+'&link='+linPagina;
    let codigos = '&cod1='+cod1+'&cod2='+cod2;
    //alert(linPagina);
    $.ajax({
        type: 'POST',
        url: '../../mantenimientoServlet?Accion=direcPagina',
        data: param + codigos,
        beforeSend: function () {
        }, success: function (resultado) {
                //$('#content-pages').load(resultado);
                console.log(url);
                //window.location = url+"?pagina="+nemo;
         // window.location.href = "elclan.jsp?pagina="+nemo;
        }, complete: function () {
        }
    });  
}
function abrirModal(modal){
    $("#"+modal).modal('show'); 
}
function cerrarModal(modal){
    $("#"+modal).modal('hide'); 
}
function mensajeAlerta(mensaje){
    Swal.fire({
        title: 'Mensaje',
        text: mensaje,
        icon: 'icono',
        confirmButtonColor: '#da542e',
        confirmButtonText: 'Cerrar'
    });
}
function msjAlerta(mensaje){
    var conMensaje = "";
    if(mensaje =="1"){
        conMensaje = "El usuario se encuentra inhabilitado";
    } else if(mensaje =="2"){
        conMensaje = "El usuario ya está inhabilitado";
    } else if(mensaje =="3"){
        conMensaje = "El Programa no tiene SubPrograma";
    }else if(mensaje =="4"){
        conMensaje = "Para su configuración ingrese a SubProgramas";
    }
    
    if(mensaje == "3"){
        Swal.fire({
        title: 'Mensaje',
        text: conMensaje+" Desea crear un subprograma?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cerrar',
        confirmButtonText: 'Crear Subprograma'
      }).then((result) => {
        if (result.isConfirmed) {
          //window.location.href = "subprograma.jsp?codPro="+;
        }
      });
    }else{
        Swal.fire({
            title: 'Mensaje',
            text: conMensaje,
            icon: 'icono',
            confirmButtonColor: '#da542e',
            confirmButtonText: 'Cerrar'
          })
    }
           
}
function obtenerUrl(){
    var url = $(location).attr('href');
    //alert(url);
}
function msjExitoso(mensaje){
    Swal.fire({
        position: 'center',
        icon: 'success',
        title: mensaje,
        showConfirmButton: false,
        timer: 1500
    })
}
function msjOtros(mensaje){
    Swal.fire({
        position: 'center',
        icon: 'success',
        title: mensaje,
        showConfirmButton: false,
        timer: 1500
    });
}
function cargaMenu(){
    var codUser = $("#codUser").val();
    var nomUser = $("#nomUser").val();
    var dato = 'codUser='+codUser+'&nomUser='+nomUser;
    $.ajax({
            type: 'POST',
            url: '../../mantenimientoServlet?Accion=listarMenu',
            data: dato,
            beforeSend: function () {
            }, success: function (data) {
//                $("#sidebar-menu").html(resultado);
                llenarMenu(data);
            }, complete: function () {
            }
        });
}
function llenarMenu(data){
    let contenido = "";
    let funcion = "ROUTER.load('sedes')";;
    let linkModulo;
    var nuevadata = JSON.parse(data);
    $.each(nuevadata, function(i,d) {
        if(d.canSubModulo == "0"){
            linkModulo = d.linkModulo;
            funcion = "ROUTER.load('inicio')";
        }else{
            funcion = "subMenu()";
        }
        contenido += "<li class='sidebar-item'> "
                        +  "<a class='sidebar-link waves-effect waves-dark sidebar-link' href='#' onclick=\""+funcion+"\" aria-expanded='false'>"
                        +     "<i class='"+d.icoModulo+"'></i>"
                        +    "<span class=\'hide-menu\'>"+d.desModulo+"</span>"
                        +  "</a>";                
        if(d.canSubModulo == "0") {
            console.log("NO HAY SUB MODULO");
        }else{                      
            contenido += "<ul aria-expanded=\"false\" class=\"collapse first-level\">";
            $.each(d.listaSubModulos, function(i,su){
                let namepath = su.desSubModulo;
                PATHS[namepath.toLowerCase()] = {
                    path: "/elclan/vistas/layout/"+namepath.toLowerCase() , 
                    template: su.linkSubModulo.substring(7)
                };
                if(namepath.toLowerCase() == "usuarios"){
                    PATHS["registrar"] = {
                    path: "/elclan/vistas/layout/registrar",
                    template: "reHumanos/crearUsuario.jsp"
                    };
                }
                if(namepath.toLowerCase() == "areas"){
                    PATHS["roles"] = {
                    path: "/elclan/vistas/layout/roles",
                    template: "reHumanos/roles.jsp"
                    };
                }
                funcion = "ROUTER.load('"+namepath.toLowerCase()+"')";
                contenido += "<li class='sidebar-item'>"
                            + " <a role=\"button\" onclick=\""+funcion+"\" class='sidebar-link'>"
                            +"	  <i class=\'"+su.icoSubModulo+"\'></i>"
                            +"     <span class=\'hide-menu\'> "
                            +"		"+ su.desSubModulo+""
                            +"	   </span>"
                            +"	</a>"
                            +"</li>";
            });
            contenido += "</ul> "
            + "     </li>";
            
        }
    });
    $('#sidebarnav').html(contenido);
}
function cargaMenuInterno(codPagina, difModulo){
    var codUser = $("#codUser").val();
    var param = 'codUser='+codUser+'&codPagina='+codPagina+'&difModulo='+difModulo;
    $.ajax({
            type: 'POST',
            url: '../../../reHumanosServlet?Accion=listarMenuInterno',
            data: param,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#menu-interno").html(resultado);
            }, complete: function () {
            }
        });
}
function obtenerFecha(){
  var fecha = new Date(); //Fecha actual
  var mes = fecha.getMonth()+1; //obteniendo mes
  var dia = fecha.getDate(); //obteniendo dia
  var ano = fecha.getFullYear(); //obteniendo año
  if(dia<10)
    dia='0'+dia; //agrega cero si el menor de 10
  if(mes<10)
    mes='0'+mes //agrega cero si el menor de 10
  $("#fecActual").html(""+dia+"-"+mes+"-"+ano+"");
}



function manejoTabs(idFrm){
    var count = $("#"+idFrm+" .steps ul li").children();
    var cant  = count.length;
    
    alert(cant);
    /*for (var i=1; i=count; i++) {
        $(".steps  ul li").attr('id','lis'+i);
    } */
}
/*
$(".actions  ul li").click(function() {

    alert("alerta");
});*/
function subMenu(){
    "use strict";
     var url = window.location + "";
        var path = url.replace(window.location.protocol + "//" + window.location.host + "/", "");
        var element = $('ul#sidebarnav a').filter(function() {
            return this.href === url || this.href === path;// || url.href.indexOf(this.href) === 0;
        });

    element.addClass("active"); 
    $('#sidebarnav a').on('click', function (e) {
        //alert("alerta menu1");
            if (!$(this).hasClass("active")) {
                // hide any open menus and remove all other classes
                $("ul", $(this).parents("ul:first")).removeClass("in");
                $("a", $(this).parents("ul:first")).removeClass("active");
                
                // open our new menu and add the open class
                $(this).next("ul").addClass("in");
                $(this).addClass("active");
                
            }
            else if ($(this).hasClass("active")) {
                $(this).removeClass("active");
                $(this).parents("ul:first").removeClass("active");
                $(this).next("ul").removeClass("in");
            }
    })
    $('#sidebarnav >li >a.has-arrow').on('click', function (e) {
        e.preventDefault();
    });
}
function validarCampo(id){
    var valor = $("#"+id).val();
    if(valor ==""){
        $("#"+id).css('border-color', '#FF4A4A');
    }else{
        return '1';
    }

}
//**********CAMBIAR LOS CAMPOS DIGITADOS A MAYUSCULA
$(document).ready( function () {
    $("input").on("keypress", function () {
     $input=$(this);
     setTimeout(function () {
      $input.val($input.val().toUpperCase());
     },50);
    });
    
    $("textarea").on("keypress", function () {
     $input=$(this);
     setTimeout(function () {
      $input.val($input.val().toUpperCase());
     },50);
    });    
});

function cerrarsession(){
    $.ajax({
        type: 'POST',
        url: '../../mantenimientoServlet?Accion=cerrarsession',
        data: "",
        beforeSend: function () {
        }, success: function (resultado) {
        }, complete: function () {
          window.location.href = "../index.jsp";
        }
    });
}



