/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.DAO.DoctorDAO;
import com.mycompany.hospitalproject2.Doctor;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joshua
 */
@WebServlet(name = "Prueba", urlPatterns = {"/Prueba"})
public class ControladorDB extends HttpServlet {
    Doctor doctor = new Doctor();
    Doctor docConst;
    DoctorDAO doctorDAO = new DoctorDAO();
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
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if(menu.equals("AgregarDoctor")){
            switch(accion){
                case "Listar":
                    List lista = doctorDAO.listar();
                    request.setAttribute("listaDoctor", lista);
                    //request.setAttribute("listaDoctores", lista);
                    request.getRequestDispatcher("AdminAgregarMedico.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String codigo = request.getParameter("txtCodigoDoc");
                    String nombre = request.getParameter("txtNombreDoc");
                    String colegiado = request.getParameter("txtColegiadoDoc");
                    String dpi = request.getParameter("txtDpiDoc");
                    String tel = request.getParameter("txtTelDoc");
                    String correo = request.getParameter("txtCorreoDoc");
                    String horEntrada = request.getParameter("txtHIDoc");
                    String horSalida = request.getParameter("txtHSDoc");
                    String fechaInicio = request.getParameter("txtITDoc");
                    String pass = request.getParameter("txtEspecialidadDoc");
                    String especialidad = request.getParameter("txtPassDoc");
                    docConst = new Doctor(colegiado, tel, especialidad, correo, horEntrada, horSalida, Date.valueOf(fechaInicio), codigo, nombre, dpi, pass);
                    doctorDAO.agregar(docConst);
                    request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    break;
            }
            //request.getRequestDispatcher("Prueba1.jsp").forward(request, response);
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
        processRequest(request, response);
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
