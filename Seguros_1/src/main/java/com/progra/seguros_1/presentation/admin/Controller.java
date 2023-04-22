package com.progra.seguros_1.presentation.admin;

import com.progra.seguros_1.presentation.register.*;
import com.progra.seguros_1.presentation.login.*;
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
@WebServlet(name="AdminController", urlPatterns={
        "/presentation/admin/show","/presentation/admin/marcaModelo",
    "/presentation/admin/categoriaCobertura"
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
            case "/presentation/admin/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/admin/marcaModelo":
                viewUrl = this.marcaModelo(request);
                break;
              case "/presentation/admin/categoriaCobertura":
                viewUrl = this.categoriasCoberturas(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
        public String show(HttpServletRequest request){
       Model model = (Model) request.getAttribute("model");
        model.getCurrent().setClave("");
        model.getCurrent().setId("");
        return "/presentation/admin/View.jsp";
    }
    
    public void updateModel(HttpServletRequest request) { // Le pasa los datos que se escribio
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setId(request.getParameter("id"));
        model.getCurrent().setClave(request.getParameter("clave"));
        //request.setAttribute("model",model);
    }
    
    public String marcaModelo(HttpServletRequest request){
        
        return "/presentation/admin/gestionMarcaModelo/View.jsp";
    }
     public String categoriasCoberturas(HttpServletRequest request){
        
        return  "/presentation/admin/gestionCategoriaCobertura/View.jsp";
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
