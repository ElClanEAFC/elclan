<%-- 
    Document   : menu-superior
    Created on : 04/08/2021, 09:37:11 AM
    Author     : bcondori
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession session_actual = request.getSession(true);%>
<input type="hidden" name="coUser" id="codUser" value="<%=session_actual.getAttribute("codigoUser")%>">
<input type="hidden" name="nomUser" id="nomUser" value="<%=session_actual.getAttribute("usuario")%>">
<header class="topbar" data-navbarbg="skin5">
    <nav class="navbar top-navbar navbar-expand-md navbar-dark">
        <div class="navbar-header" data-logobg="skin5">

            <!-- ============================================================== -->
            <!-- Logo -->
            <!-- ============================================================== -->
            <a class="navbar-brand" href="index.html">
                <b class="logo-icon ">
                <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                <!-- Dark Logo icon -->
                <img
                  src="../assets/images/logo-text.png"
                  alt="homepage"
                  class="light-logo"
                  width="45"
                />
              </b>
                <span class="logo-text">
                    <!-- dark Logo text -->
                    <img src="../assets/images/text-logo.jpg" alt="homepage" class="light-logo" />

                </span>
            </a>
            <!-- ============================================================== -->
            <!-- Toggle which is visible on mobile only -->
            <!-- ============================================================== -->
            <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i
                    class="ti-menu ti-close"></i></a>
        </div>
        <!-- ============================================================== -->
        <!-- End Logo -->
        <!-- ============================================================== -->
        <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
            <!-- ============================================================== -->
            <!-- toggle and nav items -->
            <!-- ============================================================== -->
            <ul class="navbar-nav float-start me-auto">
                <li class="nav-item d-none d-lg-block"><a
                        class="nav-link sidebartoggler waves-effect waves-light" href="javascript:void(0)"
                        data-sidebartype="mini-sidebar"><i class="mdi mdi-menu font-24"></i></a></li>
                <!-- ============================================================== -->
                <!-- create new -->
                <!-- ============================================================== -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <span class="d-none d-md-block">Fecha: <span id="fecActual"></span></span>
                        <span class="d-block d-md-none"><i class="fa fa-plus"></i></span>
                    </a>
                </li>
                <!-- ============================================================== -->
                <!-- Search -->
                <!-- ============================================================== -->
                <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark"
                                                    href="javascript:void(0)"><i class="ti-search"></i></a>
                    <form class="app-search position-absolute">
                        <input type="text" class="form-control" placeholder="Search &amp; enter"> <a
                            class="srh-btn"><i class="ti-close"></i></a>
                    </form>
                </li>
            </ul>
            <!-- ============================================================== -->
            <!-- Right side toggle and nav items -->
            <!-- ============================================================== -->
            <ul class="navbar-nav float-end">
                <!-- ===========================================================
                notificaciones
                ============================================================ -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="mdi mdi-bell font-24"></i>
                    </a>
                </li>
                <!-- =====================fin de notificaciones================= -->
                <!-- ===========================================================
                /// inicio de mensajes
                ============================================================ -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle waves-effect waves-dark" href="#" id="2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="font-24 mdi mdi-comment-processing"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end mailbox animated bounceInDown" aria-labelledby="2">
                        <ul class="list-style-none">
                            <li>
                                <div class="">
                                    <!-- Mensaje -->
                                    <a href="javascript:void(0)" class="link border-top">
                                        <div class="d-flex no-block align-items-center p-10">
                                            <span class="btn btn-success btn-circle"><i
                                                    class="ti-calendar"></i></span>
                                            <div class="ms-2">
                                                <h5 class="mb-0">Nombre Usuario</h5>
                                                <span class="mail-desc">Mensaje</span>
                                            </div>
                                        </div>
                                    </a>

                                </div>
                            </li>
                        </ul>
                    </ul>
                </li>
                <!-- ===============fin de mensajesges========================== -->

                <!-- ===========================================================
                /// opciones del usuario
                ================================================================-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="../assets/images/user.jpg" alt="user" class="rounded-circle" width="31">
                        <span><%= session_actual.getAttribute("usuario")%></span>
                    </a>

                    <ul class="dropdown-menu miperfil dropdown-menu-end user-dd animated" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="javascript:void(0)"><i class="ti-user me-1 ms-1"></i>
                            Mi Perfil
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" onclick ="cerrarsession();"><i
                                class="fa fa-power-off me-1 ms-1"></i> Cerrar Sesion</a>
                        <div class="dropdown-divider"></div>
                    </ul>
                </li>
                <!-- ============fin de opciones del usuario====================-->
            </ul>
        </div>
    </nav>
</header>