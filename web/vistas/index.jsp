<%-- 
    Document   : index
    Created on : 05/08/2021, 09:33:20 AM
    Author     : bcondori
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="noindex,nofollow">
    <title>Sistema EAFC - El Clan</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/logo.png">
    <!-- Custom CSS -->
    <!--<link href="assets/libs/flot/css/float-chart.css" rel="stylesheet">-->
    
    <!-- ====== MATERIAL DESING ICONS ======== -->
    <link href="dist/css/style.min.css" rel="stylesheet">
    <!-- ====== ESTILOS GENERALES ADICIONALES==== -->
    <link href="css/estilos.css" rel="stylesheet">
    
    <!--=========PLUGINS DE Swal PARA ALERTAS==================================-->    
    <script src="js/sweetalert2.all.min.js"></script>
    <script src="js/sweetalert2.min.js"></script>
</head>
<style>
    body{background: #343a40!important;}
    #loginform{background: #c0c0c0 !important;padding: 15px !important;border-radius: 15px;margin: auto;margin-top: 200px;}
</style>
<!--===============================MODALES======================================-->



<body>
    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div id="loginform" class="col align-self-center">
                
                <div class="text-center pt-3 pb-3">
                    <span class="db"><img src="assets/images/logo.png" alt="logo" /></span>
                </div>
                <!-- Form -->
                <!--<form class="form-horizontal mt-3" id="loginform"> -->
                    <div class="row pb-4">
                        <div class="col-12">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-success text-white h-100" id="basic-addon1"><i class="ti-user"></i></span>
                                </div>
                                <input type="text" id="user" class="form-control form-control-lg" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" required="">
                            </div>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-warning text-white h-100" id="basic-addon2"><i class="ti-pencil"></i></span>
                                </div>
                                <input type="password" id="clave" class="form-control form-control-lg" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1" required="">
                            </div>
                        </div>
                    </div>
                    <div class="row border-top border-secondary">
                        <div class="col-12">
                            <div class="form-group">
                                <div class="pt-3">
                                    <button class="btn btn-info" id="to-recover" type="button" onclick="recuperarClave();"><i class="fa fa-lock me-1"></i> Olvidaste tu contraseña?</button>
                                    <button class="btn btn-success float-end text-white" onclick="Login();">Ingresar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="txtMensaje"></div>
                    <div id="resultado"></div>
                <!-- </form> -->
            </div>
            <div class="col"></div>
            <a href="layout/home/home.jsp"></a>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- All Required js -- All Jquery -->
    <script src="assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- ============================================================== -->
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <!--<script src="assets/extra-libs/sparkline/sparkline.js"></script>-->
    <!--Wave Effects -->
    <script src="dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="dist/js/custom.min.js"></script>
    <!--This page JavaScript -->
    <!-- <script src="dist/js/pages/dashboards/dashboard1.js"></script> -->
    <!-- Charts js Files -->
<!--    <script src="assets/libs/flot/excanvas.js"></script>
    <script src="assets/libs/flot/jquery.flot.js"></script>
    <script src="assets/libs/flot/jquery.flot.pie.js"></script>
    <script src="assets/libs/flot/jquery.flot.time.js"></script>
    <script src="assets/libs/flot/jquery.flot.stack.js"></script>
    <script src="assets/libs/flot/jquery.flot.crosshair.js"></script>
    <script src="assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
    <script src="dist/js/pages/chart/chart-page-init.js"></script>-->
    <script src="js/cargando.js"></script>
    
</body>
<script>
    function recuperarClave(){
        Swal.fire({
        title: 'Mensaje',
        text: "Contacte con el administrador de Sistemas para solicitar el cambio de su clave",
        icon: 'warning',
        showCancelButton: true,
        cancelButtonText: 'Cancelar',
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Aceptar'
      }).then((result) => {
        if (result.isConfirmed) {
        }
      });
    }

    function Login() {
        var user = $("#user").val();
        var clave = $("#clave").val();
        $.ajax({
            type: 'POST',
            url: '../reHumanosServlet?Accion=Login',
            data: 'user=' + user + '&clave=' + clave,
            beforeSend: function () {
            }, success: function (resultado) {
                $("#resultado").html(resultado);
                //alert(resultado);
            }, complete: function () {
               //alert(resultado);
                var ini = $("#inicio").val();
                if(ini == 1){
                    window.location.href = "layout/elclan.jsp";
                }else{
                    Swal.fire({
                    title: 'Mensaje',
                    text: "Ingrese nuevamente su usuario y clave",
                    icon: 'warning',
                    confirmButtonColor: '#d33',
                    confirmButtonText: 'Cerrar'
                  });
                }
            }
        });
    }
            
    function cargando() {
        $.blockUI({
            message: '<div class="thecube"> <div class="cube c1"></div> <div class="cube c2"></div> <div class="cube c4"></div> <div class="cube c3"></div> </div>',
            //timeout: 2000, //unblock after 2 seconds
            baseZ: 2000,
            overlayCSS: {
                backgroundColor: '#1b2024',
                opacity: 0.8,
                cursor: 'wait'
            },
            css: {
                zindex: '9999',
                border: 0,
                color: '#fff',
                padding: 0,
                backgroundColor: 'transparent'
            }
        });
    }
    function cerrarCargando() {
        $.unblockUI();
    }
    
    
    
</script>
</html>
