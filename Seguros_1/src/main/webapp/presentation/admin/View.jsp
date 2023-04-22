
<%@page import="com.progra.seguros_1.logic.Poliza"%>
<%@page import="com.progra.seguros_1.presentation.login.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@ include file="/presentation/Head.jsp" %>
        <title>Administrador</title>
    </head>
    <body>
         <%@ include file="/presentation/Header.jsp" %>
         <main>
             <div>
                 <h1>Cliente-polizas</h1>     
                 <table>
                     <thead>
                         <tr> <td>Cliente</td> <td>Poliza</td>  </tr>
                     </thead>
                     <tbody>
                        <tr> 
                            <td>Cliente</td> 
                            <td>Poliza</td>
                        </tr>
                     </tbody>
                 </table>          
             </div> 
          </main>
          <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
