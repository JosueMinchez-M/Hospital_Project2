/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.DAO.LaboratoristaDAO;
import com.mycompany.hospitalproject2.Laboratorista;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joshua
 */
@WebServlet(name = "ValidarLaboratorista", urlPatterns = {"/ValidarLaboratorista"})
public class ValidarLaboratorista extends HttpServlet {
    LaboratoristaDAO laboratoristaDAO = new LaboratoristaDAO();
    Laboratorista laboratorista = new Laboratorista();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidarLaboratorista</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidarLaboratorista at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String botonRegistrarLaboratorista = request.getParameter("btn_registrarLaboratorista");
        if(botonRegistrarLaboratorista.equalsIgnoreCase("Registrar")){
            String user = request.getParameter("txt_userLaboratorista");
            String pass = request.getParameter("txt_passwordLaboratorista");
            laboratorista = laboratoristaDAO.validar(user, pass);
            if(laboratorista.getCodigo() != null){
                request.setAttribute("nombreLaboratorista", laboratorista.getNombre());
                request.setAttribute("codigoLaboratorista", laboratorista.getCodigo());
                request.getRequestDispatcher("PrincipalLaboratorista.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("LoginLaboratorista.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("LoginLaboratorista.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
