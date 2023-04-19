/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.progra.seguros_1.presentation.login;

import com.progra.seguros_1.logic.Service;
import com.progra.seguros_1.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESCINF
 */
@WebServlet(name="Controller", urlPatterns={
            "/presentation/login/show"
        ,"/presentation/login/login",
        "/presentation/login/logout",
        "/presentation/register/login",
        "/presentation/register/register"
})
public class Controller extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("model",new Model());
        String viewUrl = "";
        switch(request.getServletPath()){
              case "/presentation/login/show":
                viewUrl=this.show(request);
                break;              
            case "/presentation/login/login":
                viewUrl=this.login(request);
                break;            
            case "/presentation/login/logout":
                viewUrl=this.logout(request);
                break;
            case "/presentation/register/login":
                viewUrl = "/presentation/register/View.jsp"; break;
                
            case "/presentation/register/register":
                viewUrl = this.register(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    
    public String show(HttpServletRequest request){
       Model model = (Model) request.getAttribute("model");
        model.getCurrent().setClave("");
        model.getCurrent().setId("");
        return "/presentation/login/View.jsp";
    }
    
//    public String login(HttpServletRequest request){
//        this.updateModel(request);
//        return "/presentation/polizas/View.jsp";
//    }
    
    public String login(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.loginAction(request);
            }else {
                request.setAttribute("errores", errores);
//                return "/presentation/cliente/datos/View.jsp";
                 return "/presentation/login/View.jsp"; 
            }
        } catch (Exception e) {
            //TODO HAY QUE HACER QUE CUANDO NO LO ENCUENTRE AL USUARIO LO MARQUE EN ROJO Y LE PIDA
            // UNA CEDULA Y UN PASSWORD CORRECTO
//            return "/presentation/Error.jsp";
//            return "/presentation/login/View.jsp";
            return "/presentation/Error.jsp";   
        }
    }
    
    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        //Por el momento no lo puedo hacer 
        if (request.getParameter("id").isEmpty()) {
            errores.put("id", "Cedula requerida");
        }
        if (request.getParameter("clave").isEmpty()) {
            errores.put("clave", "Clave requerida");
        }
        return errores;
    }

    public void updateModel(HttpServletRequest request) { // Le pasa los datos que se escribio
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setId(request.getParameter("id"));
        model.getCurrent().setClave(request.getParameter("clave"));
        //request.setAttribute("model",model);
    }
     
     public String loginAction(HttpServletRequest request) {
         Model model = (Model) request.getAttribute("model");
         Service service = Service.instance();
         HttpSession session = request.getSession(true);
         try {
             Usuario real = service.usuarioFind(model.getCurrent().getId(), model.getCurrent().getClave());
             session.setAttribute("Usuario", real);
             String viewUrl = "";
             switch (real.getTipo()) {
                 case 1: // En este caso deberia redirigirme a las paginas donde
                     // Se encuentran las polizas 
//                    viewUrl = "/presentation/cliente/cuentas/show";
                     viewUrl = "/presentation/polizas/View.jsp";
                     break;
                 case 2: // Este caso es para la parte del administrador 
                     viewUrl = "/presentation/admin/View.jsp";
                     break;
             }
             return viewUrl;
        } catch (Exception e) {
//             Map<String,String> errores = new HashMap<>();
//            request.setAttribute("errores", errores);
//            errores.put("cedulaFld","Usuario o clave incorrectos");
//            errores.put("claveFld","Usuario o clave incorrectos");
//            return "/presentation/login/View.jsp"; 
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("id","Usuario o clave incorrectos");
            errores.put("clave","Usuario o clave incorrectos");
            return "/presentation/login/View.jsp"; 
        }
    }
    
     public String logout(HttpServletRequest request){
         HttpSession session = request.getSession(true);
         session.removeAttribute("Usuario");
         session.invalidate();
         return "/presentation/login/View.jsp";
     }
    
    public String register(HttpServletRequest request) {
        // TO-DO AGREGAR LOS PARAMETROS A LOS DATOS QUEMADOS
        // Y VERIFICAR QUE LOS USUARIOS NO SE ESTEN REPITIENDO 
          Model model = (Model) request.getAttribute("model");
         Service service = Service.instance();
         HttpSession session = request.getSession(true);
         Usuario register = new Usuario(request.getParameter("idFld"),request.getParameter("claveFld"),
                         request.getParameter("nombreFld"),request.getParameter("telefonoFld"),
                         request.getParameter("correoFld"),request.getParameter("tarjetaFld"));
         if(!"".equals(register.getId())){
             this.updateModel(request);
            service.getUsuarios().put(request.getParameter("idFld"),register );
         }else{
             return "/presentation/Error.jsp";
         }
         
         System.out.println(service.getUsuarios());
//     private String id;
//     private String clave;
//     private String Nombre;
//     private String telefono;
//     private String correo;
//     private String datosTarjeta;
//     private Integer tipo;
        return "/presentation/login/View.jsp"; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
