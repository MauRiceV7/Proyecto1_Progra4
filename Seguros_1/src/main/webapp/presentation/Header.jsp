<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="com.progra.seguros_1.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("Usuario");  %>
  <%@ include file="/presentation/Head.jsp" %>
<!--Este Header se usara para saber cual pantalla debo de mostrar dependiendo de que 
usuario sea y debo verificar si el usuario es nulo o no en el controller de login-->
    <header>
            <div>
              <div class="logo-company"><img src="image/logo-company.svg" alt="logo-company" style="width: 3em;"></div>
              <div class="nombre-company"><h2>Car insurence</h2></div>
            </div>
            <div>
              <div class="logo-number"><img src="image/number-icon.svg" alt="number-company" style="width: 2em;"></div>
              <div class="number"><h3>+506 61187234</h3></div>
            </div>
        <% if (usuario!=null && usuario.getTipo() == 2){ %>
            <div>
              <nav class="navigation">
                  <div class="logo-company"><img src="image/contact-icon.svg" alt="logo-company" style="width: 2em;"></div>
                  <a href="#">User: <%=usuario.getId()%></a>
                  <a href="#">Agregar Polizas</a>
                  <a href="#">Clientes-polizas</a>
                  <a href="#">Gestion-marcas</a>
                  <a href="#">categorias-coberturas</a>
                <button class="button-login"><a href="presentation/login/logout">Logout</a></button>
              </nav>
            </div>
            <% } else if(usuario!=null && usuario.getTipo() == 1){%> 
                <div>
                    <nav class="navigation">
                         <div class="logo-company"><img src="image/contact-icon.svg" alt="logo-company" style="width: 2em;"></div>
                        <a href="#">User: <%=usuario.getNombre()%></a>
                         <a href="#">Polizas</a>
                        <button class="button-login"><a href="presentation/login/logout">Logout</a></button>
                    </nav>
                </div>
               <% }%> 
           <% if (usuario==null){ %>
             <div>
              <nav class="navigation">
                  <a href="#">about us</a>
              </nav>
            </div>
           <% }%>  
      </header>
      
<!--      <a href="presentation/login/login">login</a>-->