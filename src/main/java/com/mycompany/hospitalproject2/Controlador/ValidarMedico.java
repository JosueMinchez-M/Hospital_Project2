/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.DAO.DoctorDAO;
import com.mycompany.hospitalproject2.Doctor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author joshua
 */
@WebServlet(name = "ValidarMedico", urlPatterns = {"/ValidarMedico"})
public class ValidarMedico extends HttpServlet {
    DoctorDAO doctorDAO = new DoctorDAO();
    Doctor doctor = new Doctor();
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
            out.println("<title>Servlet ValidarMedico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidarMedico at " + request.getContextPath() + "</h1>");
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
        String botonRegistarDoctor = request.getParameter("btn_registrarDoctor");
        if(botonRegistarDoctor.equalsIgnoreCase("Registrar")){
            String user = request.getParameter("txt_userDoctor");
            String pass = DigestUtils.md5Hex(request.getParameter("txt_passwordDoctor"));
            doctor = doctorDAO.validar(user, pass);
            if(doctor.getCodigo() != null){
                request.setAttribute("nombreDoctor", doctor.getNombre());
                request.setAttribute("codigoDoctor", doctor.getCodigo());
                request.getRequestDispatcher("PrincipalDoctor.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("LoginMedico.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("LoginMedico.jsp").forward(request, response);
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
