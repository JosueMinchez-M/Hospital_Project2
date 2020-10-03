/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.Cita;
import com.mycompany.hospitalproject2.DAO.CitaDAO;
import com.mycompany.hospitalproject2.DAO.EspecialidadMedicoDAO;
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
@WebServlet(name = "ControladorPacienteDB", urlPatterns = {"/ControladorPacienteDB"})
public class ControladorPacienteDB extends HttpServlet {
    EspecialidadMedicoDAO especialidadMedicoDAO = new EspecialidadMedicoDAO();
    CitaDAO citaDAO = new CitaDAO();
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
        if(menu.equals("AgendarCitaDoctor")){
            switch(accion){
                case "Listar":
                    List lista = especialidadMedicoDAO.listarInfoMedico();
                    request.setAttribute("listaEspecialidadDoctorJoin", lista);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "BuscarNombre":
                    String datoBuscarPorNombre = request.getParameter("txtBuscarNombreDoctor");
                    List listarTabNombre = especialidadMedicoDAO.listarTablaNombres(datoBuscarPorNombre);
                    request.setAttribute("listaEspecialidadDoctorJoin", listarTabNombre);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "BuscarEspecialidad":
                    String datoBuscarPorEspecialidad = request.getParameter("txtBuscarEspDoctor");
                    List listarTabEspecialidad = especialidadMedicoDAO.listarTablaEsp(datoBuscarPorEspecialidad);
                    request.setAttribute("listaEspecialidadDoctorJoin", listarTabEspecialidad);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "BuscarRangoFecha":
                    String datoBuscarPorFechaMenor = request.getParameter("txtBuscarFechaMenorDoctor");
                    String datoBuscarPorFechaMayor = request.getParameter("txtBuscarFechaMayorMedic");
                    List listarTabFecha = especialidadMedicoDAO.listarTablaFecha( datoBuscarPorFechaMenor, datoBuscarPorFechaMayor);
                    request.setAttribute("listaEspecialidadDoctorJoin", listarTabFecha);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "AgregarCita":
                    String especialidad = request.getParameter("txtEspecialidadCita");
                    String fechaCita = request.getParameter("txtFechaCita");
                    String horaCita = request.getParameter("txtHoraCita");
                    String codigoPaciente = request.getParameter("txtCodigoPacienteCita");
                    String codigoDoctor = request.getParameter("txtCodigoDoctorCita");
                    String codigo = String.valueOf(generarNumero());
                    Cita cita = new Cita(codigo, codigoPaciente, Date.valueOf(fechaCita), horaCita, codigoDoctor, especialidad);
                    citaDAO.agregar(cita);
                    request.getRequestDispatcher("ControladorPacienteDB?menu=AgendarCitaDoctor&accion=Listar").forward(request, response);
                    break;
//                case "Editar":
//                    id = request.getParameter("id");
//                    Doctor doc = doctorDAO.listarId(id);
//                    EspecialidadMedico eM = especialidadMedicoDAO.listarId(id);
//                    request.setAttribute("editarDatosEspDoctor", eM);
//                    request.setAttribute("editarDoctor", doc);
//                    request.getRequestDispatcher("ControladorPacienteDB?menu=AgendarCitaDoctor&accion=Listar").forward(request, response);
//                    break;
            }
        }
    }
    public int generarNumero(){
        return (int)(1000000 * Math.random());
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
