<%-- 
    Document   : prueba-api
    Created on : 06-nov-2021, 11:47:55
    Author     : bcondori
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <a href="#" onclick="apiRest();">enlace</a>
    </body>
</html>
<script>
    function apiRest(){
        //var array[] = null;
        alert("alerta");
        $.ajax({
            type: 'POST',
            url: '../../../api?Accion=apiCarga',
            data: '',
            beforeSend: function () {
            }, success: function (resultado) {
               alert(resultado);
            }, complete: function () {
               
            }
        });
        
    }

</script>