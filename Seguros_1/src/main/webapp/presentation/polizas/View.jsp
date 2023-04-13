<%-- 
    Document   : View
    Created on : 4 abr. 2023, 21:10:17
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import = "com.progra.seguros_1.presentation.login.Model"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@ include file="/presentation/Head.jsp" %>
         <%@ include file="/presentation/Header.jsp" %>
        <title>Polizas</title>
    </head>
    <body>
<!--        TO-DO AQUI VAMOS A LISTAR LAS POLIZAS DE LOS AUTOS 
        s filtrando por número de placa, ver datos de una póliza específica.-->


<!--        AQUI ES DONDE SE DEBEN PONER LAS TABLAS -->
<!--HAY QUE VER COMO SACAR LAS IMAGENES PARA PONERLAS A LA PAR DE CADA POLIZA-->
        
         <% Model model = (Model) request.getAttribute("model"); %> 
        <br>
        <br> 
        <br>
        <br>
        <br>

        <h1>Polizas</h1>
        <h1>Id: <%= model.getCurrent().getId()%></h1>
         <h1>Clave: <%= model.getCurrent().getClave()%></h1>
         <button><a href="presentation/login/logout">Logout</a></button>
         <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
