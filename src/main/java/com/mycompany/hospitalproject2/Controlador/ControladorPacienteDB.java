/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.DAO.CitaLaboratoristaDAO;
import com.mycompany.hospitalproject2.Cita;
import com.mycompany.hospitalproject2.CitaLaboratorista;
import com.mycompany.hospitalproject2.DAO.CitaDAO;
import com.mycompany.hospitalproject2.DAO.ConsultaDAO;
import com.mycompany.hospitalproject2.DAO.EspecialidadMedicoDAO;
import com.mycompany.hospitalproject2.DAO.ExamenDAO;
import com.mycompany.hospitalproject2.DAO.LaboratoristaDAO;
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
    LaboratoristaDAO laboratoristaDAO = new LaboratoristaDAO();
    ExamenDAO examenDAO = new ExamenDAO();
    CitaLaboratoristaDAO citaLaboratoristaDAO = new CitaLaboratoristaDAO();
    ConsultaDAO consultaDAO = new ConsultaDAO();
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
                    List listaConsulta = consultaDAO.listar();
                    request.setAttribute("listaConsulta", listaConsulta);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "BuscarNombre":
                    String datoBuscarPorNombre = request.getParameter("txtBuscarNombreDoctor");
                    List listarTabNombre = especialidadMedicoDAO.listarTablaNombres(datoBuscarPorNombre);
                    request.setAttribute("listaEspecialidadDoctorJoin", listarTabNombre);
                    List listaConsultaN = consultaDAO.listar();
                    request.setAttribute("listaConsulta", listaConsultaN);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "BuscarEspecialidad":
                    String datoBuscarPorEspecialidad = request.getParameter("txtBuscarEspDoctor");
                    List listarTabEspecialidad = especialidadMedicoDAO.listarTablaEsp(datoBuscarPorEspecialidad);
                    request.setAttribute("listaEspecialidadDoctorJoin", listarTabEspecialidad);
                    List listaConsultaE = consultaDAO.listar();
                    request.setAttribute("listaConsulta", listaConsultaE);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "BuscarRangoFecha":
                    String datoBuscarPorFechaMenor = request.getParameter("txtBuscarFechaMenorDoctor");
                    String datoBuscarPorFechaMayor = request.getParameter("txtBuscarFechaMayorMedic");
                    List listarTabFecha = especialidadMedicoDAO.listarTablaFecha( datoBuscarPorFechaMenor, datoBuscarPorFechaMayor);
                    request.setAttribute("listaEspecialidadDoctorJoin", listarTabFecha);
                    List listaConsultaR = consultaDAO.listar();
                    request.setAttribute("listaConsulta", listaConsultaR);
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
            }
        }else if(menu.equals("AgendarCitaExamenLab")){
            switch(accion){
                case "Listar":
                    List lista = laboratoristaDAO.listar();
                    request.setAttribute("listaLaboratorista", lista);
                    List listaEx = examenDAO.listar();
                    request.setAttribute("listaExamen", listaEx);
                    request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    break;
                case "BuscarNombre":
                    String datoBuscarPorNombre = request.getParameter("txtBuscarNombreLab");
                    List listarTabNombre = laboratoristaDAO.listarTablaNombres(datoBuscarPorNombre);
                    request.setAttribute("listaLaboratorista", listarTabNombre);
                    List listaExN = examenDAO.listar();
                    request.setAttribute("listaExamen", listaExN);
                    request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    break;
                case "BuscarExamen":
                    String datoBuscarPorExamen = request.getParameter("txtBuscarTipoExLab");
                    List listarTabEspecialidad = laboratoristaDAO.listarTablaExam(datoBuscarPorExamen);
                    request.setAttribute("listaLaboratorista", listarTabEspecialidad);
                    List listaExE = examenDAO.listar();
                    request.setAttribute("listaExamen", listaExE);
                    request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    break;
                case "BuscarRangoFecha":
                    String datoBuscarPorFechaMenor = request.getParameter("txtBuscarFechaMenorLab");
                    String datoBuscarPorFechaMayor = request.getParameter("txtBuscarFechaMayorLab");
                    List listarTabFecha = laboratoristaDAO.listarTablaRangoFech(datoBuscarPorFechaMenor, datoBuscarPorFechaMayor);
                    request.setAttribute("listaLaboratorista", listarTabFecha);
                    List listaExR = examenDAO.listar();
                    request.setAttribute("listaExamen", listaExR);
                    request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    break;
                case "AgregarCita":
                    String codExamen = request.getParameter("txtExamenCita");
                    String fechaCita = request.getParameter("txtFechaCita");
                    String horaCita = request.getParameter("txtHoraCita");
                    String codigoPaciente = request.getParameter("txtCodigoPacienteCita");
                    String codigoLab = request.getParameter("txtCodigoLaboratoristaCita");
                    String codDoct = request.getParameter("txtCodigoDoctorCita");
                    String codigo = String.valueOf(generarNumero());
                    CitaLaboratorista citaLab = new CitaLaboratorista(codigo, codExamen, Date.valueOf(fechaCita), horaCita, codigoPaciente, codigoLab, codDoct);
                    citaLaboratoristaDAO.agregar(citaLab);
                    request.getRequestDispatcher("ControladorPacienteDB?menu=AgendarCitaExamenLab&accion=Listar").forward(request, response);
                    break;
            }
        }else if(menu.equals("CitaPendiente")){
            switch(accion){
                case "ListarCita":
                    String prueba = request.getParameter("txtCodigotx");
                    request.setAttribute("prueb", prueba.replaceAll("\\r|\\n", ""));
                    List lista = citaLaboratoristaDAO.listar(prueba);
                    request.setAttribute("listaCitaPendiente", lista);
                    request.getRequestDispatcher("PacienteCitaPendienteLaboratorio.jsp").forward(request, response);
                    break;
            }
        }else if(menu.equals("CitaPendienteDoctor")){
            switch(accion){
                case "ListarCita":
                    String prueba = request.getParameter("txtCodigotx");
                    request.setAttribute("prueb", prueba.replaceAll("\n", ""));
                    List lista = citaDAO.listar(prueba);
                    request.setAttribute("listaCitaPendiente", lista);
                    request.getRequestDispatcher("PacienteCitaPendienteMedico.jsp").forward(request, response);
                    break;
            }
        }else if(menu.equals("CitaRealizadaDoctor")){
            switch(accion){
                case "ListarHistorial":
                    String prueba = request.getParameter("txtCodigotx");
                    //request.setAttribute("prueb", prueba.replaceAll("\\r|\\n", ""));
                    List listaDoc = citaDAO.listarCitaRealizadaMedico(prueba);
                    request.setAttribute("listaCitaPendiente", listaDoc);
                    List listaLab = citaLaboratoristaDAO.listarCitasRealizadasLab(prueba);
                    request.setAttribute("listaCitaPendienteLab", listaLab);
                    request.getRequestDispatcher("PacienteHistorialMedico.jsp").forward(request, response);
                    break;
            }
        }else if(menu.equals("Consulta1")){
            switch(accion){
                case "Listar":
                    String codPaciente = request.getParameter("txtCodigotx");
                    request.setAttribute("codPaci", codPaciente);
                    List listaC1 = citaLaboratoristaDAO.listarConsulta1(codPaciente);
                    request.setAttribute("listac1", listaC1);
                    List listaConsultaCompleta = citaLaboratoristaDAO.listarCitasRealizadasLab(codPaciente);
                    request.setAttribute("listac2", listaConsultaCompleta);
                    List listaConsultaMedico1 = citaDAO.listarCitaRealizadaMedico(codPaciente);
                    request.setAttribute("listac3", listaConsultaMedico1);
                    List listaConsultaMedico4 = citaDAO.listarCitaRealizadaMedico(codPaciente);
                    request.setAttribute("listac4", listaConsultaMedico4);
                    request.getRequestDispatcher("PacienteConsulta.jsp").forward(request, response);
                    break;
                case "Listar2":
                    String codPac = request.getParameter("txtCodigoPaci");
                    request.setAttribute("codPaci", codPac);
                    String codTipo = request.getParameter("txtBuscarCodigoTipo");
                    String fechaMen = request.getParameter("txtBuscarFechaMenor");
                    String fechaMay = request.getParameter("txtBuscarFechaMayor");
                    List listaC12 = citaLaboratoristaDAO.listarConsulta1(codPac);
                    request.setAttribute("listac1", listaC12);
                    List listaC2 = citaLaboratoristaDAO.listarConsulta2(codPac, codTipo, fechaMen, fechaMay);
                    request.setAttribute("listac2", listaC2);
                    List listaConsultaMedic1 = citaDAO.listarCitaRealizadaMedico(codPac);
                    request.setAttribute("listac3", listaConsultaMedic1);
                    List listaConsultaMedi4 = citaDAO.listarCitaRealizadaMedico(codPac);
                    request.setAttribute("listac4", listaConsultaMedi4);
                    request.getRequestDispatcher("PacienteConsulta.jsp").forward(request, response);
                    break;
                case "Listar3":
                    String codPacient = request.getParameter("txtCodigoPaci");
                    request.setAttribute("codPaci", codPacient);
                    String codTipo3 = request.getParameter("txtBuscarDoc");
                    String fechaMen3 = request.getParameter("txtBuscarFechaMenor");
                    String fechaMay3 = request.getParameter("txtBuscarFechaMayor");
                    List listaConsulta4 = citaDAO.listarConsulta4(codPacient, codTipo3, fechaMen3, fechaMay3);
                    request.setAttribute("listac4", listaConsulta4);
                    List listaC11 = citaLaboratoristaDAO.listarConsulta1(codPacient);
                    request.setAttribute("listac1", listaC11);
                    List listaConsultaComplet = citaLaboratoristaDAO.listarCitasRealizadasLab(codPacient);
                    request.setAttribute("listac2", listaConsultaComplet);
                    List listaConsultaMedi1 = citaDAO.listarCitaRealizadaMedico(codPacient);
                    request.setAttribute("listac3", listaConsultaMedi1);
                    request.getRequestDispatcher("PacienteConsulta.jsp").forward(request, response);
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
