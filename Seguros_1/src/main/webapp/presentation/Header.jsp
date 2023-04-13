<%@page contentType="text/html" pageEncoding="UTF-8"%> 
  <%@ include file="/presentation/Head.jsp" %>
<!--Este Header se usara para saber cual pantalla debo de mostrar dependiendo de que 
usuario sea y debo verificar si el usuario es nulo o no en el controller de login-->
    <header>
            <div>
              <div class="logo-company"><img src="image/logo-company.svg" alt="logo-company" style="width: 3em;"></div>
              <div class="nombre-company"><h2>Car insurence</h2></div>
            </div>
            <div>
              <div class="logo-number"><img src="image/number-icon.svg" alt="number-company" style="width: 3em;"></div>
              <div class="number"><h3>+506 61187234</h3></div>
            </div>
            <div>
              <nav class="navigation">
                  <a href="#">about us</a>
                  <a href="#">Login</a>
                <button class="button-login">login</button>
              </nav>
            </div>
      </header>