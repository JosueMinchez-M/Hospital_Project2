/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.Cita;
import com.mycompany.hospitalproject2.DAO.CitaDAO;
import com.mycompany.hospitalproject2.Reporte;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControladorMedicoDB", urlPatterns = {"/ControladorMedicoDB"})
public class ControladorMedicoDB extends HttpServlet {
    ReporteDAO reporteDAO = new ReporteDAO();
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
        if(menu.equals("InformeMedico")){
            switch(accion){
                case "Agregar":
                    String fechaConsulta = request.getParameter("txtFechaInf");
                    String horaConsulta = request.getParameter("txtHoraInf");
                    String codPaciente = request.getParameter("txtCodPacienteInf");
                    String codMedico = request.getParameter("txtCodMedicoInf");
                    String codigoInforme = String.valueOf(generarNumero());
                    String descripInfo = request.getParameter("txtAreaInforme");
                    Reporte rep = new Reporte(codigoInforme, codPaciente, Date.valueOf(fechaConsulta), horaConsulta, codMedico, descripInfo);
                    reporteDAO.agregar(rep);
                    String codigoDocInfo = request.getParameter("txtCodMedicoInf");
                    request.setAttribute("codMedico", codigoDocInfo.replaceAll("\\r|\\n", ""));
                    List listaCitaInf = citaDAO.listarCitaDoctor(codMedico);
                    request.setAttribute("listaCitaDoc", listaCitaInf);
                    request.getRequestDispatcher("DoctorInforme.jsp").forward(request, response);
                    break;
                case "AgregarCitaDoctor":
                    String especialidad = request.getParameter("txtEspecialidadCita");
                    String fechaCita = request.getParameter("txtFechaCita");
                    String horaCita = request.getParameter("txtHoraCita");
                    String codigoPaciente = request.getParameter("txtCodigoPacienteCita");
                    String codigoDoctor = request.getParameter("txtCodigoDoctorCita");
                    String codigo = String.valueOf(generarNumero());
                    Cita cita = new Cita(codigo, codigoPaciente, Date.valueOf(fechaCita), horaCita, codigoDoctor, especialidad);
                    citaDAO.agregar(cita);
                    String codigoDocCitaDoc = request.getParameter("txtCodigoDoctorCita");
                    request.setAttribute("codMedico", codigoDocCitaDoc.replaceAll("\\r|\\n", ""));
                    List listaCitaDoc = citaDAO.listarCitaDoctor(codigoDocCitaDoc);
                    request.setAttribute("listaCitaDoc", listaCitaDoc);
                    request.getRequestDispatcher("DoctorInforme.jsp").forward(request, response);
                    break;
                case "MandarCodigo":
                    String codigoDoc = request.getParameter("txtCodigotx");
                    request.setAttribute("codMedico", codigoDoc.replaceAll("\\r|\\n", ""));
                    List lista = citaDAO.listarCitaDoctor(codigoDoc);
                    request.setAttribute("listaCitaDoc", lista);
                    request.getRequestDispatcher("DoctorInforme.jsp").forward(request, response);
                   break;
                case "Editar":
                    String id = request.getParameter("id");
                    Cita cit = citaDAO.listarId(id);
                    request.setAttribute("editarCitaDoc", cit);
                    String codigoDocEdit = request.getParameter("txtCodTabla");
                    request.setAttribute("codMedico", codigoDocEdit.replaceAll("\\r|\\n", ""));
                    List listaEdit = citaDAO.listarCitaDoctor(codigoDocEdit);
                    request.setAttribute("listaCitaDoc", listaEdit);
                    request.getRequestDispatcher("DoctorInforme.jsp").forward(request, response);
                    break;
                case "BuscarCodigoCita":
                    String codigoBuscar = request.getParameter("txtBuscarCodigo");
                    String codigoDocCitaDo = request.getParameter("txtCodigoMedico");
                    request.setAttribute("codMedico", codigoDocCitaDo.replaceAll("\\r|\\n", ""));
                    List listaCitaDo = citaDAO.listarCitaBuscada(codigoBuscar);
                    request.setAttribute("listaCitaDoc", listaCitaDo);
                    request.getRequestDispatcher("DoctorInforme.jsp").forward(request, response);
                    break;
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
