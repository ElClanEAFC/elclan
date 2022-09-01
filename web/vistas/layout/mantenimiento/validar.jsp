<%-- 
    Document   : validar
    Created on : 8 jun. 2022, 15:09:23
    Author     : bcondori
--%>

<%@page import="pe.sis.sistemaWeb.Beans.Seguridad"%>
<%@page import="pe.sis.sistemaWeb.Beans.Menu"%>
<%
HttpSession session_actual = request.getSession(true);
String usuario=(String)session_actual.getAttribute("usuario");



if(usuario == null){
    response.sendRedirect("index.jsp");
    
}else{
    

%>