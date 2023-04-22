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
        <%@ include file="/presentation/Body.jsp" %>
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

