<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        
        <h1>Login</h1> 
        <%@ include file="/presentation/Header.jsp" %>
        <main>
            <div class="wrapper">
                <div>
                  <div><h3 class="texto-login">Login</h3></div>
                  <div class="logo-login"><img src="image/login-icon.svg " alt="login-icon" style="height: 5em"></div>
                </div>
                <form name="form" action="presentation/login/login" method = "post">
                 <div>
                 <div class="input">
                   <div class="input-group flex-nowrap">
                     <span class="input-group-text" id="addon-wrapping"><img src="image/username-icon.svg" alt="username-icon" style="height: 1em;"></span>
                     <input  type="text" name="id" class="form-control" placeholder="Username" aria-label="Nombre de usuario" aria-describedby="addon-wrapping">
                   </div>
                 </div>
                 <div class="input">
                   <div class="input-group flex-nowrap">
                     <span class="input-group-text" id="addon-wrapping2"> <img src="image/password-icon.svg" alt="username-icon" style="height: 1em"> </span>
                     <input  type="password" name="clave" class="form-control" placeholder="Password" aria-label="Nombre de usuario" aria-describedby="addon-wrapping">
                   </div>
                 </div>
                 <div>
                   <label><input type="checkbox" > Remember me</label>
                 </div>
                 <div>
                   <a href="#">forgot your password?</a>
                 </div>
                  <button type="submit" class="btn-login" name="login"> login </button>
                  </div>
                </form>
                <div>
                  <div><h3>Don't have an account?</h3></div>
                  <a href="presentation/login/register">Register</a>
                </div>
                <div>or</div>
                <div>
                  <img src="image/google-icon.svg" alt="google-icon">
                  <div>Continue with Google</div>
                </div>
            </div>
        </main>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
