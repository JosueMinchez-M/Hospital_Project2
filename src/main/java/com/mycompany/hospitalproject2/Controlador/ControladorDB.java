/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.Consulta;
import com.mycompany.hospitalproject2.DAO.ConsultaDAO;
import com.mycompany.hospitalproject2.DAO.DoctorDAO;
import com.mycompany.hospitalproject2.DAO.EspecialidadMedicoDAO;
import com.mycompany.hospitalproject2.DAO.ExamenDAO;
import com.mycompany.hospitalproject2.DAO.LaboratoristaDAO;
import com.mycompany.hospitalproject2.DAO.PacienteDAO;
import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.EspecialidadMedico;
import com.mycompany.hospitalproject2.Examen;
import com.mycompany.hospitalproject2.Laboratorista;
import com.mycompany.hospitalproject2.Paciente;
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
    Laboratorista lab;
    LaboratoristaDAO laboratoristaDAO = new LaboratoristaDAO();
    EspecialidadMedicoDAO especialidadMedicoDAO = new EspecialidadMedicoDAO();
    ConsultaDAO consultaDAO = new ConsultaDAO();
    ExamenDAO examenDAO = new ExamenDAO();
    PacienteDAO pacienteDAO = new PacienteDAO();
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
                    String pass = request.getParameter("txtPassDoc");
                    String especialidad = request.getParameter("");
                    docConst = new Doctor(colegiado, tel, especialidad, correo, horEntrada, horSalida, Date.valueOf(fechaInicio), codigo, nombre, dpi, pass);
                    doctorDAO.agregar(docConst);
                    request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    break;
                    case "Editar":
                    id = request.getParameter("id");
                    Doctor doc = doctorDAO.listarId(id);
                    request.setAttribute("editarDoctor", doc);
                    request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    break;
                    case "Actualizar":
                    String codigoA = request.getParameter("txtCodigoDoc");
                    String nombreA = request.getParameter("txtNombreDoc");
                    String colegiadoA = request.getParameter("txtColegiadoDoc");
                    String dpiA = request.getParameter("txtDpiDoc");
                    String telA = request.getParameter("txtTelDoc");
                    String correoA = request.getParameter("txtCorreoDoc");
                    String horEntradaA = request.getParameter("txtHIDoc");
                    String horSalidaA = request.getParameter("txtHSDoc");
                    String fechaInicioA = request.getParameter("txtITDoc");
                    String passA = request.getParameter("txtPassDoc");
                    String especialidadA = request.getParameter("");
                    docConst = new Doctor(colegiadoA, telA, especialidadA, correoA, horEntradaA, horSalidaA, Date.valueOf(fechaInicioA), codigoA, nombreA, dpiA, passA);
                    doctorDAO.actualizar(docConst);
                    request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    break;
            }
            //request.getRequestDispatcher("Prueba1.jsp").forward(request, response);
        }else if(menu.equals("AgregarLaboratorista")){
            switch(accion){
                case "Listar":
                    List lista = laboratoristaDAO.listar();
                    request.setAttribute("listaLaboratorista", lista);
                    //request.setAttribute("listaDoctores", lista);
                    request.getRequestDispatcher("AdminAgregarLaboratorista.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String codigo = request.getParameter("txtCodigoLab");
                    String nombre = request.getParameter("txtNombreLab");
                    String numRegistro = request.getParameter("txtNoRegistroLab");
                    String dpi = request.getParameter("txtDpiLab");
                    String tel = request.getParameter("txtTelLab");
                    String tipoExamen = request.getParameter("txtTipoExamenLab");
                    String correo = request.getParameter("txtCorreoLab");
                    String fechaInicio = request.getParameter("txtITLab");
                    String pass = request.getParameter("txtPassLab");
                    lab = new Laboratorista(codigo, nombre, dpi, pass, numRegistro, tel, tipoExamen, correo, Date.valueOf(fechaInicio));
                    laboratoristaDAO.agregar(lab);
                    request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    Laboratorista lab = laboratoristaDAO.listarId(id);
                    request.setAttribute("editarLaboratorista", lab);
                    request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    //String codigoA = request.getParameter("txtCodigoLab");
                    String nombreA = request.getParameter("txtNombreLab");
                    String numRegistroA = request.getParameter("txtNoRegistroLab");
                    String dpiA = request.getParameter("txtDpiLab");
                    String telA = request.getParameter("txtTelLab");
                    String tipoExamenA = request.getParameter("txtTipoExamenLab");
                    String correoA = request.getParameter("txtCorreoLab");
                    String fechaInicioA = request.getParameter("txtITLab");
                    String passA = request.getParameter("txtPassLab");
                    lab = new Laboratorista(id, nombreA, dpiA, passA, numRegistroA, telA, tipoExamenA, correoA, Date.valueOf(fechaInicioA));
                    laboratoristaDAO.actualizar(lab);
                    request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    break;
            }
        }else if(menu.equals("AgregarPaciente")){
            switch(accion){
                case "Listar":
                    List lista = pacienteDAO.listar();
                    request.setAttribute("listaPaciente", lista);
                    request.getRequestDispatcher("AdminAgregarPaciente.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String codigo = String.valueOf(generarNumero());
                    String nombre = request.getParameter("txtNombrePac");
                    String genero = request.getParameter("txtGeneroPac");
                    String fechaNac = request.getParameter("txtFechaNacPac");
                    String dpi = request.getParameter("txtDpiPac");
                    String tel = request.getParameter("txtTelPac");
                    String peso = request.getParameter("txtPesoPac");
                    String tipoSangre = request.getParameter("txtTipoSanPac");
                    String correo = request.getParameter("txtCorreoPac");
                    String pass = request.getParameter("txtPassPac");
                    Paciente pacient = new Paciente(codigo, nombre, dpi, pass, genero, Date.valueOf(fechaNac),tel, Double.parseDouble(peso), tipoSangre, correo);
                    pacienteDAO.agregar(pacient);
                    request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    Paciente pac = pacienteDAO.listarId(id);
                    request.setAttribute("editarPaciente", pac);
                    request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String codigoA = request.getParameter("txtCodigoPac");
                    String nombreA = request.getParameter("txtNombrePac");
                    String generoA = request.getParameter("txtGeneroPac");
                    String fechaNacA = request.getParameter("txtFechaNacPac");
                    String dpiA = request.getParameter("txtDpiPac");
                    String telA = request.getParameter("txtTelPac");
                    String pesoA = request.getParameter("txtPesoPac");
                    String tipoSangreA = request.getParameter("txtTipoSanPac");
                    String correoA = request.getParameter("txtCorreoPac");
                    String passA = request.getParameter("txtPassPac");
                    Paciente pacientA = new Paciente(codigoA, nombreA, dpiA, passA, generoA, Date.valueOf(fechaNacA),telA, Double.parseDouble(pesoA), tipoSangreA, correoA);
                    pacienteDAO.actualizar(pacientA);
                    request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    break;
            }
        }else if(menu.equals("AgregarEspecialidad")){
            switch(accion){
                case "Listar":
                    List lista = especialidadMedicoDAO.listar();
                    request.setAttribute("listaEspecialidadDoctor", lista);
                    request.getRequestDispatcher("AdminAgregarEspecialidad.jsp").forward(request, response);
                    break;
                case "Buscar":
                    id = request.getParameter("txtBuscarDocEsp");
                    Doctor doc = doctorDAO.listarId(id);
                    request.setAttribute("buscarDoctorEs", doc);
                    request.getRequestDispatcher("Prueba?menu=AgregarEspecialidad&accion=Listar").forward(request, response);
                    break;
                case "Agregar":
                    String codigo = request.getParameter("txtCodigoDoc");
                    String especialidad = request.getParameter("txtEspecialidadDoc");
                    EspecialidadMedico especialidadMedico = new EspecialidadMedico(codigo, especialidad);
                    especialidadMedicoDAO.agregar(especialidadMedico);
                    request.getRequestDispatcher("Prueba?menu=AgregarEspecialidad&accion=Listar").forward(request, response);
                    break;
            }
        }else if(menu.equals("ServicioConsultaDoctor")){
            switch(accion){
                case "Listar":
                    List lista = consultaDAO.listar();
                    request.setAttribute("listaConsulta", lista);
                    request.getRequestDispatcher("AdminConsultaDoctor.jsp").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    Consulta consulta = consultaDAO.listarId(id);
                    request.setAttribute("editarConsulta", consulta);
                    request.getRequestDispatcher("Prueba?menu=ServicioConsultaDoctor&accion=Listar").forward(request, response);
                    break;
                case "Agregar":
                    String tipo = request.getParameter("txtTipoConsulta");
                    int costo = Integer.parseInt(request.getParameter("txtCostoConsulta"));
                    Consulta consult = new Consulta(tipo, costo);
                    consultaDAO.agregar(consult);
                    request.getRequestDispatcher("Prueba?menu=ServicioConsultaDoctor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    //String tipo = request.getParameter("txtTipoConsulta");
                    int costoA = Integer.parseInt(request.getParameter("txtCostoConsulta"));
                    Consulta consul = new Consulta(id, costoA);
                    consultaDAO.actualizar(consul);
                    request.getRequestDispatcher("Prueba?menu=ServicioConsultaDoctor&accion=Listar").forward(request, response);
                    break;
            }
        }else if(menu.equals("AgregarExamenLab")){
            switch(accion){
                case "Listar":
                    List lista = examenDAO.listar();
                    request.setAttribute("listaExamenLab", lista);
                    request.getRequestDispatcher("AdminExamenesLaboratorio.jsp").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    Examen ex = examenDAO.listarId(id);
                    request.setAttribute("editarExamen", ex);
                    request.getRequestDispatcher("Prueba?menu=AgregarExamenLab&accion=Listar").forward(request, response);
                    break;
                case "Agregar":
                    String codigo = request.getParameter("txtCodigoEx");
                    String tipoEx = request.getParameter("txtNombreEx");
                    String orden = request.getParameter("txtOrdenEx");
                    String descripcion = request.getParameter("txtDescripcionEx");
                    double costo = Double.parseDouble(request.getParameter("txtCostoEx"));
                    String informe = request.getParameter("txtInformeEx");
                    Examen examen = new Examen(codigo, tipoEx, orden, descripcion, costo, informe);
                    examenDAO.agregar(examen);
                    request.getRequestDispatcher("Prueba?menu=AgregarExamenLab&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String codigoA = request.getParameter("txtCodigoEx");
                    String tipoExA = request.getParameter("txtNombreEx");
                    String ordenA = request.getParameter("txtOrdenEx");
                    String descripcionA = request.getParameter("txtDescripcionEx");
                    double costoA = Double.parseDouble(request.getParameter("txtCostoEx"));
                    String informeA = request.getParameter("txtInformeEx");
                    Examen examenA = new Examen(codigoA, tipoExA, ordenA, descripcionA, costoA, informeA);
                    examenDAO.actualizar(examenA);
                    request.getRequestDispatcher("Prueba?menu=AgregarExamenLab&accion=Listar").forward(request, response);
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
