<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/presentation/Head.jsp" %>
        <title>Register</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <main>
<!--           TO-DO HAY QUE PONER MAS BONITO EL REGISTER Y QUE ESTOS DATOS SE VAYAN ALA COLECCION DE 
           DATOS QUEMADOS -->


<div class="wrapper">
    <form name="form" action="presentation/register/register" method="post"> 
        <div>
            <div><h1 class="register-nombre">Register</h1></div>     
            <div class="contendor">
                <div class="etiqueta">Cedula:</div>  
                <div class="campo"><input type="text" name="cedulaFld" id="cedulaFld" placeholder="Cedula" ></div>
            </div>
            <div class="contendor">
                <div class="etiqueta">Clave:</div>  
                <div class="campo"><input type="text" name="claveFld" id="claveFld" placeholder="Clave" ></div>
            </div>
            <div class="contendor">
                <div class="etiqueta">Nombre:</div>  
                <div class="campo"><input type="text" name="nombreFld" id="nombreFld" placeholder="Nombre" ></div>
            </div>
            <div class="contendor">
                <div class="etiqueta">Telefono:</div>  
                <div class="campo"><input type="text" name="telefonoFld" id="telefonoFld" placeholder="Telefono" ></div>
            </div>
            <div class="contendor">
                <div class="etiqueta">Correo:</div>  
                <div class="campo"><input type="text" name="correoFld" id="correoFld" placeholder="Correo" ></div>
            </div>
            <div class="contendor">
                <div class="etiqueta"> Medio de pago:</div>  
                <div class="campo"><input type="text" name="tarjetaFld" id="tarjetaFld" placeholder="Tarjeta" ></div>
            </div> 
            <div><button type="submit" class="btn-login" name="register"> login </button> </div>
        </div>
    </form>    
        </main>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
