
<!DOCTYPE html>
<html dir="ltr" lang="en">
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.util.ArrayList" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="pe.sis.elclan.Clases.mantenimiento" %>
<%@page import="pe.sis.elclan.Services.mantenimientoServices" %>  
<%
    HttpSession session_actual = request.getSession(true);
    String Usuario = (String) session_actual.getAttribute("usuario"); 
    String link = (String) session_actual.getAttribute("linMo");
    String codUsuario = (String) session_actual.getAttribute("codigoUser");    
    if(Usuario == null){
        response.sendRedirect("../index.jsp");
        link = "../index.jsp";
    }
    System.out.println("Session Usuario: "+ Usuario);
    
    System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy llega al include de contenido: "+link+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
%>
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
<body onload="primeraCarga();">
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <main id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
        data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
        <!-- ========incluir menu superior======= -->
        <jsp:include page="includes/menu-superior.jsp" /> 
        <!--  ========incluir menu lateral========== -->
        <jsp:include page="includes/menu.jsp" />
        <!--==========contenido del sistema=====================================-->
        <div class="page-wrapper">
            <div class="content-main">
                <jsp:include page="includes/menu-pagina.jsp" />
                <!--===========fin del menu del historial de navegacion=============-->
                <!--<p class="hide" id="link-page"><%=link%></p>-->

                <div id="content-pages">               
                </div>
                <%--<jsp:include page="<%=link%>" />--%>

                <!-- ===========footer ============================================= -->
                <jsp:include page="includes/footer-pag.jsp" />
            </div>
        </div>
        <!--================fin del contenido===================================-->
    </main>
    <!-- =========================footer - los script===========================-->
     <jsp:include page="includes/footer.jsp" />  

</body>
<script>
//    $(document).ready(async function (){
//       await renderizarPagina();        
//    });
//renderizarPagina();
async function renderizarPagina(){
    let pagina = $("#link-page").text();
    await $("#content-pages").load(pagina);
}


</script>

</html>