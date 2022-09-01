<%-- 
    Document   : contenido
    Created on : 6 jun. 2022, 12:28:58
    Author     : bcondori
--%>


<%@page import="java.io.PrintWriter"%>
<div>
    <%
    System.out.println("llega al include de contenido");
    HttpSession session_actual = request.getSession(true);
    session_actual.getAttribute("linMo");
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    pw.print(session_actual.getAttribute("linMo"));    
    System.out.println("INCLUDE CONTENIDO: "+session_actual.getAttribute("linMo"));
    %>

    <jsp:include page="<%= session_actual.getAttribute("linMo")%>" />
</div>