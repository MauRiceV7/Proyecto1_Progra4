<!--com.progra.Seguros_1.-->
<%@page import="com.progra.seguros_1.presentation.login.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
         <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        
        
        
        
        <h1>Login</h1> 
        <%@ include file="/presentation/Header.jsp" %>
        <main>
            <div class="wrapper">
                <div>
                  <div><h3>Login</h3></div>
                  <div><img src="image/login-icon.svg " alt="login-icon" style="height: 5em"></div>
                </div>
               <form name="form" action="presentation/login/login" method = "post">
                 <div>
                 <div class="input">
                   <div>
                     <span><img src="image/username-icon.svg" alt="username-icon" style="height: 1em;"></span>
                     <input  type="text" name="id" placeholder="Username" aria-label="id de usuario" class="<%=erroneo("id",errores)%>" value="<%=form.get("id")[0]%>" title="<%=title("id",errores)%>">
                   </div>
                 </div>
                 <div class="input">
                   <div>
                     <span><img src="image/password-icon.svg" alt="username-icon" style="height: 1em"> </span>
                     <input  type="password" name="clave" placeholder="Password" aria-label="clave de usuario" class="<%=erroneo("clave",errores)%>"  value="<%=form.get("clave")[0]%>" title="<%=title("clave",errores)%>">
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
                  <a href="presentation/register/login">Register</a>
                </div>
                <div>or</div>
                <div>
                  <img src="image/google-icon.svg" alt="google-icon">
                  <div>Continue with Google</div>
                </div>
            </div>
        </main>
        <%@ include file="/presentation/Footer.jsp" %>
        
<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("id", new String[]{model.getCurrent().getId()});
       values.put("clave", new String[]{model.getCurrent().getClave()});
       return values;
    }
    
%> 

    </body>
</html>

