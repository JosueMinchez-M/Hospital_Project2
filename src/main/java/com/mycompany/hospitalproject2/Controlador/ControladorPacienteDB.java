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
import com.mycompany.hospitalproject2.DAO.DoctorDAO;
import com.mycompany.hospitalproject2.DAO.EspecialidadMedicoDAO;
import com.mycompany.hospitalproject2.DAO.ExamenDAO;
import com.mycompany.hospitalproject2.DAO.LaboratoristaDAO;
import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.Laboratorista;
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
    DoctorDAO doctorDAO = new DoctorDAO();
    String id;
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
                    String codigoPacienteRecibirPrincipal = request.getParameter("txtCodigotx");
                    request.setAttribute("codPacient", codigoPacienteRecibirPrincipal);
                    List lista = especialidadMedicoDAO.listarInfoMedico();
                    request.setAttribute("listaEspecialidadDoctorJoin", lista);
                    List listaConsulta = consultaDAO.listar();
                    request.setAttribute("listaConsulta", listaConsulta);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "MostrarTodo":
                    String codigoPacienteRecibirPrincipal1 = request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codigoPacienteRecibirPrincipal1);
                    List lista1 = especialidadMedicoDAO.listarInfoMedico();
                    request.setAttribute("listaEspecialidadDoctorJoin", lista1);
                    List listaConsulta1 = consultaDAO.listar();
                    request.setAttribute("listaConsulta", listaConsulta1);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
                case "BuscarNombre":
                    String codigPacientBNom = request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codigPacientBNom);
                    String datoBuscarPorNombre = request.getParameter("txtBuscarNombreDoctor");
                    if(datoBuscarPorNombre.replaceAll("\\r|\\n", "").equals("")){
                        int numBuscarNombreVacio = 3;
                        request.setAttribute("numVacioConsulta", numBuscarNombreVacio);
                        List listaBusqNom = especialidadMedicoDAO.listarInfoMedico();
                        request.setAttribute("listaEspecialidadDoctorJoin", listaBusqNom);
                        List listaConsultaN = consultaDAO.listar();
                        request.setAttribute("listaConsulta", listaConsultaN);
                        request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    }else{
                        List listarTabNombre = especialidadMedicoDAO.listarTablaNombres(datoBuscarPorNombre);
                        request.setAttribute("listaEspecialidadDoctorJoin", listarTabNombre);
                        List listaConsultaN = consultaDAO.listar();
                        request.setAttribute("listaConsulta", listaConsultaN);
                        request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    }
                    break;
                case "BuscarEspecialidad":
                    String codigPacientBEsp= request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codigPacientBEsp);
                    String datoBuscarPorEspecialidad = request.getParameter("txtBuscarEspDoctor");
                    if(datoBuscarPorEspecialidad.replaceAll("\\r|\\n", "").equals("")){
                        int numBusqEsp = 4;
                        request.setAttribute("numBusqEspecialidad", numBusqEsp);
                        List listaBusqEsp = especialidadMedicoDAO.listarInfoMedico();
                        request.setAttribute("listaEspecialidadDoctorJoin", listaBusqEsp);
                        List listaConsultaE = consultaDAO.listar();
                        request.setAttribute("listaConsulta", listaConsultaE);
                        request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    }else{
                        List listarTabEspecialidad = especialidadMedicoDAO.listarTablaEsp(datoBuscarPorEspecialidad);
                        request.setAttribute("listaEspecialidadDoctorJoin", listarTabEspecialidad);
                        List listaConsultaE = consultaDAO.listar();
                        request.setAttribute("listaConsulta", listaConsultaE);
                        request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    }
                    break;
                case "BuscarRangoFecha":
                    String codigPacientRangFecha = request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codigPacientRangFecha);
                    String datoBuscarPorFechaMenor = request.getParameter("txtBuscarFechaMenorDoctor");
                    String datoBuscarPorFechaMayor = request.getParameter("txtBuscarFechaMayorMedic");
                    if(datoBuscarPorFechaMenor.replaceAll("\\r|\\n", "").equals("")||datoBuscarPorFechaMayor.replaceAll("\\r|\\n", "").equals("")){
                        int numBusRangFech = 5;
                        request.setAttribute("numBusRango", numBusRangFech);
                        List listaBusqRang = especialidadMedicoDAO.listarInfoMedico();
                        request.setAttribute("listaEspecialidadDoctorJoin", listaBusqRang);
                        List listaConsultaR = consultaDAO.listar();
                        request.setAttribute("listaConsulta", listaConsultaR);
                        request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    }else{
                        List listarTabFecha = especialidadMedicoDAO.listarTablaFecha( datoBuscarPorFechaMenor, datoBuscarPorFechaMayor);
                        request.setAttribute("listaEspecialidadDoctorJoin", listarTabFecha);
                        List listaConsultaR = consultaDAO.listar();
                        request.setAttribute("listaConsulta", listaConsultaR);
                        request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    }
                    break;
                case "AgregarCita":
                    String codPaciente = request.getParameter("txtCodigoPacienteCita");
                    request.setAttribute("codPacient", codPaciente);
                    String especialidad = request.getParameter("txtEspecialidadCita");
                    String fechaCita = request.getParameter("txtFechaCita");
                    String horaCita = request.getParameter("txtHoraCita");
                    String codigoPaciente = request.getParameter("txtCodigoPacienteCita");
                    String codigoDoctor = request.getParameter("txtCodigoDoctorCita");
                    String codigo = String.valueOf(generarNumero());
                    if(especialidad.replaceAll("\\r|\\n", "").equals("")|| fechaCita.replaceAll("\\r|\\n", "").equals("")||
                            horaCita.replaceAll("\\r|\\n", "").equals("")|| codigoPaciente.replaceAll("\\r|\\n", "").equals("")||
                            codigoDoctor.replaceAll("\\r|\\n", "").equals("")|| codigo.replaceAll("\\r|\\n", "").equals("")){
                        int numAgendarCitaVacio = 6;
                        request.setAttribute("numVacioConsulta", numAgendarCitaVacio);
                        request.getRequestDispatcher("ControladorPacienteDB?menu=AgendarCitaDoctor&accion=Listar").forward(request, response);
                    }else{
                        List listaVerificar = especialidadMedicoDAO.verificarEspecialidadDoc(especialidad, codigoDoctor);
                        if(listaVerificar.size() == 0){
                            int numAgendarCitaVacio = 7;
                            request.setAttribute("numVerificar", numAgendarCitaVacio);
                            List listaAgregarList = especialidadMedicoDAO.listarInfoMedico();
                            request.setAttribute("listaEspecialidadDoctorJoin", listaAgregarList);
                            List listaConsultaAList = consultaDAO.listar();
                            request.setAttribute("listaConsulta", listaConsultaAList);
                            request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                        }else{
                            Cita cita = new Cita(codigo, codigoPaciente, Date.valueOf(fechaCita), horaCita, codigoDoctor, especialidad);
                            int numAgregarCita = citaDAO.agregar(cita);
                            request.setAttribute("numAgregado", numAgregarCita);
                            List listaAgregarList = especialidadMedicoDAO.listarInfoMedico();
                            request.setAttribute("listaEspecialidadDoctorJoin", listaAgregarList);
                            List listaConsultaAList = consultaDAO.listar();
                            request.setAttribute("listaConsulta", listaConsultaAList);
                            request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                        }
                    }
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    String codPacienteEd = request.getParameter("txtCodPacientTabla");
                    request.setAttribute("codPacient", codPacienteEd);
                    Doctor doc = doctorDAO.listarId(id);
                    request.setAttribute("editarCitaDoc", doc);
                    List listaEdit = especialidadMedicoDAO.listarInfoMedico();
                    request.setAttribute("listaEspecialidadDoctorJoin", listaEdit);
                    List listaConsultaEdit = consultaDAO.listar();
                    request.setAttribute("listaConsulta", listaConsultaEdit);
                    request.getRequestDispatcher("PacienteCitaConsultaMedico.jsp").forward(request, response);
                    break;
            }
        }else if(menu.equals("AgendarCitaExamenLab")){
            switch(accion){
                case "Listar":
                    String codPaciente = request.getParameter("txtCodigotx");
                    request.setAttribute("codPacient", codPaciente);
                    List lista = laboratoristaDAO.listar();
                    request.setAttribute("listaLaboratorista", lista);
                    List listaEx = examenDAO.listar();
                    request.setAttribute("listaExamen", listaEx);
                    request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    break;
                case "BuscarNombre":
                    String codPacienteBusNom = request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codPacienteBusNom);
                    String datoBuscarPorNombre = request.getParameter("txtBuscarNombreLab");
                    if(datoBuscarPorNombre.replaceAll("\\r|\\n", "").equals("")){
                        int numBusNom = 3;
                        request.setAttribute("numVacioConsulta", numBusNom);
                        List listaBusNom = laboratoristaDAO.listar();
                        request.setAttribute("listaLaboratorista", listaBusNom);
                        List listaExBusNom = examenDAO.listar();
                        request.setAttribute("listaExamen", listaExBusNom);
                        request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    }else{
                        List listarTabNombre = laboratoristaDAO.listarTablaNombres(datoBuscarPorNombre);
                        request.setAttribute("listaLaboratorista", listarTabNombre);
                        List listaExN = examenDAO.listar();
                        request.setAttribute("listaExamen", listaExN);
                        request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    }
                    break;
                case "BuscarExamen":
                    String codPacienteBusEx = request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codPacienteBusEx);
                    String datoBuscarPorExamen = request.getParameter("txtBuscarTipoExLab");
                    if(datoBuscarPorExamen.replaceAll("\\r|\\n", "").equals("")){
                        int numBuscEx = 4;
                        request.setAttribute("numBusqEspecialidad", numBuscEx);
                        List listaBusEx = laboratoristaDAO.listar();
                        request.setAttribute("listaLaboratorista", listaBusEx);
                        List listaExBusEx = examenDAO.listar();
                        request.setAttribute("listaExamen", listaExBusEx);
                        request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    }else{
                        List listarTabEspecialidad = laboratoristaDAO.listarTablaExam(datoBuscarPorExamen);
                        request.setAttribute("listaLaboratorista", listarTabEspecialidad);
                        List listaExE = examenDAO.listar();
                        request.setAttribute("listaExamen", listaExE);
                        request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    }
                    break;
                case "BuscarRangoFecha":
                    String codPacienteBusRan = request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codPacienteBusRan);
                    String datoBuscarPorFechaMenor = request.getParameter("txtBuscarFechaMenorLab");
                    String datoBuscarPorFechaMayor = request.getParameter("txtBuscarFechaMayorLab");
                    if(datoBuscarPorFechaMenor.replaceAll("\\r|\\n", "").equals("")||datoBuscarPorFechaMayor.replaceAll("\\r|\\n", "").equals("")){
                        int numRangFech = 5;
                        request.setAttribute("numBusRango", numRangFech);
                        List listaBusRan = laboratoristaDAO.listar();
                        request.setAttribute("listaLaboratorista", listaBusRan);
                        List listaExBusRan = examenDAO.listar();
                        request.setAttribute("listaExamen", listaExBusRan);
                        request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    }else{
                        List listarTabFecha = laboratoristaDAO.listarTablaRangoFech(datoBuscarPorFechaMenor, datoBuscarPorFechaMayor);
                        request.setAttribute("listaLaboratorista", listarTabFecha);
                        List listaExR = examenDAO.listar();
                        request.setAttribute("listaExamen", listaExR);
                        request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    }
                    break;
                case "MostrarTodo":
                    String codPacienteMosTodo = request.getParameter("txtCodPacienteBusq");
                    request.setAttribute("codPacient", codPacienteMosTodo);
                    List listaMosTodo = laboratoristaDAO.listar();
                    request.setAttribute("listaLaboratorista", listaMosTodo);
                    List listaExMosTodo = examenDAO.listar();
                    request.setAttribute("listaExamen", listaExMosTodo);
                    request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    String codPacienteEd = request.getParameter("txtCodPacientTabla");
                    request.setAttribute("codPacient", codPacienteEd);
                    Laboratorista lab = laboratoristaDAO.listarId(id);
                    request.setAttribute("editarCitaLab", lab);
                    List listaEdi = laboratoristaDAO.listar();
                    request.setAttribute("listaLaboratorista", listaEdi);
                    List listaExEdi = examenDAO.listar();
                    request.setAttribute("listaExamen", listaExEdi);
                    request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    break;
                case "AgregarCita":
                    String codPacienteAgreCita = request.getParameter("txtCodigoPacienteCita");
                    request.setAttribute("codPacient", codPacienteAgreCita);
                    String codExamen = request.getParameter("txtExamenCita");
                    String fechaCita = request.getParameter("txtFechaCita");
                    String horaCita = request.getParameter("txtHoraCita");
                    String codigoPaciente = request.getParameter("txtCodigoPacienteCita");
                    String codigoLab = request.getParameter("txtCodigoLaboratoristaCita");
                    String codDoct = request.getParameter("txtCodigoDoctorCita");
                    String codigo = String.valueOf(generarNumero());
                    if(codExamen.replaceAll("\\r|\\n", "").equals("")||fechaCita.replaceAll("\\r|\\n", "").equals("")||
                            horaCita.replaceAll("\\r|\\n", "").equals("")||codigoPaciente.replaceAll("\\r|\\n", "").equals("")||
                            codigoLab.replaceAll("\\r|\\n", "").equals("")||codigo.replaceAll("\\r|\\n", "").equals("")){
                        int numAgregarCitaVacia = 6;
                        request.setAttribute("numVacioConsulta", numAgregarCitaVacia);
                        List listaAgreCita = laboratoristaDAO.listar();
                        request.setAttribute("listaLaboratorista", listaAgreCita);
                        List listaExAgreCita = examenDAO.listar();
                        request.setAttribute("listaExamen", listaExAgreCita);
                        request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                    }else{
                        List verificarLabExamen = laboratoristaDAO.verificarLab(codExamen, codigoLab);
                        if(verificarLabExamen.size() == 0){
                            int numVerificarListaVacia = 7;
                            request.setAttribute("numVerificar", numVerificarListaVacia);
                            List listaAgreCita = laboratoristaDAO.listar();
                            request.setAttribute("listaLaboratorista", listaAgreCita);
                            List listaExAgreCita = examenDAO.listar();
                            request.setAttribute("listaExamen", listaExAgreCita);
                            request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                        }else{
                            CitaLaboratorista citaLab = new CitaLaboratorista(codigo, codExamen, Date.valueOf(fechaCita), horaCita, codigoPaciente, codigoLab, codDoct);
                            int numAgregarCita = citaLaboratoristaDAO.agregar(citaLab);
                            request.setAttribute("numAgregado", numAgregarCita);
                            List listaAgreCita = laboratoristaDAO.listar();
                            request.setAttribute("listaLaboratorista", listaAgreCita);
                            List listaExAgreCita = examenDAO.listar();
                            request.setAttribute("listaExamen", listaExAgreCita);
                            request.getRequestDispatcher("PacienteCitaExamenLaboratorio.jsp").forward(request, response);
                        }
                    }
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
