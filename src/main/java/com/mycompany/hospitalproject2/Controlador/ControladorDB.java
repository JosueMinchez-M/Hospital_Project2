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
import java.util.Random;
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
                    Random rng = new Random();
                    int dig3 = rng.nextInt(900)+100;
                    String codigo = String.valueOf("MED-"+dig3);
                    String nombre = request.getParameter("txtNombreDoc");
                    String colegiado = request.getParameter("txtColegiadoDoc");
                    String dpi = request.getParameter("txtDpiDoc");
                    String tel = request.getParameter("txtTelDoc");
                    String correo = request.getParameter("txtCorreoDoc");
                    String horEntrada = request.getParameter("txtHIDoc");
                    String horSalida = request.getParameter("txtHSDoc");
                    String fechaInicio = request.getParameter("txtITDoc");
                    String pass = DigestUtils.md5Hex(request.getParameter("txtPassDoc"));
                    String especialidad = request.getParameter("");
                    if(codigo.replaceAll("\\r|\\n", "").equals("")||nombre.replaceAll("\\r|\\n", "").equals("")
                            || colegiado.replaceAll("\\r|\\n", "").equals("")|| dpi.replaceAll("\\r|\\n", "").equals("")
                            || tel.replaceAll("\\r|\\n", "").equals("") || correo.replaceAll("\\r|\\n", "").equals("")
                            || horEntrada.replaceAll("\\r|\\n", "").equals("")|| horSalida.replaceAll("\\r|\\n", "").equals("")
                            || fechaInicio.replaceAll("\\r|\\n", "").equals("")|| pass.replaceAll("\\r|\\n", "").equals("")){
                        int numAgregarVacio = 5;
                        request.setAttribute("numVacioConsulta", numAgregarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    }else{
                        docConst = new Doctor(colegiado, tel, especialidad, correo, horEntrada, horSalida, Date.valueOf(fechaInicio), codigo, nombre, dpi, pass);
                        int numAgregar = doctorDAO.agregar(docConst);
                        request.setAttribute("numAgregado", numAgregar);
                        request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    }
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
                    if(codigoA.replaceAll("\\r|\\n", "").equals("")||nombreA.replaceAll("\\r|\\n", "").equals("")||
                            colegiadoA.replaceAll("\\r|\\n", "").equals("")||dpiA.replaceAll("\\r|\\n", "").equals("")||
                            telA.replaceAll("\\r|\\n", "").equals("")||correoA.replaceAll("\\r|\\n", "").equals("")||
                            horEntradaA.replaceAll("\\r|\\n", "").equals("")|| horSalidaA.replaceAll("\\r|\\n", "").equals("")||
                            fechaInicioA.replaceAll("\\r|\\n", "").equals("")){
                        int numActualizarVacio = 6;
                        request.setAttribute("numActualizarConsultVacia", numActualizarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    }else{
                        if(passA.replaceAll("\\r|\\n", "").equals("")){
                        docConst = new Doctor(colegiadoA, telA, especialidadA, correoA, horEntradaA, horSalidaA, Date.valueOf(fechaInicioA), codigoA, nombreA, dpiA, passA);
                        int numActualizar = doctorDAO.actualizarSinPass(docConst);
                        request.setAttribute("numActuConsulta", numActualizar);
                        request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    }else{
                        String passEnc = DigestUtils.md5Hex(passA);
                        docConst = new Doctor(colegiadoA, telA, especialidadA, correoA, horEntradaA, horSalidaA, Date.valueOf(fechaInicioA), codigoA, nombreA, dpiA, passEnc);
                        int numActualizar = doctorDAO.actualizar(docConst);
                        request.setAttribute("numActuConsulta", numActualizar);
                        request.getRequestDispatcher("Prueba?menu=AgregarDoctor&accion=Listar").forward(request, response);
                    }
                    }
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
                    Random rng = new Random();
                    int dig3 = rng.nextInt(900)+100;
                    String codigo = String.valueOf("LAB-" + dig3);
                    String nombre = request.getParameter("txtNombreLab");
                    String numRegistro = request.getParameter("txtNoRegistroLab");
                    String dpi = request.getParameter("txtDpiLab");
                    String tel = request.getParameter("txtTelLab");
                    String tipoExamen = request.getParameter("txtTipoExamenLab");
                    String correo = request.getParameter("txtCorreoLab");
                    String fechaInicio = request.getParameter("txtITLab");
                    String pass = DigestUtils.md5Hex(request.getParameter("txtPassLab"));
                    if(codigo.replaceAll("\\r|\\n", "").equals("")||nombre.replaceAll("\\r|\\n", "").equals("")||
                            numRegistro.replaceAll("\\r|\\n", "").equals("")||dpi.replaceAll("\\r|\\n", "").equals("")||
                            tel.replaceAll("\\r|\\n", "").equals("")||tipoExamen.replaceAll("\\r|\\n", "").equals("")||
                            correo.replaceAll("\\r|\\n", "").equals("")||fechaInicio.replaceAll("\\r|\\n", "").equals("")||
                            pass.replaceAll("\\r|\\n", "").equals("")){
                        int numAgregarVacio = 5;
                        request.setAttribute("numVacioConsulta", numAgregarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    }else{
                        lab = new Laboratorista(codigo, nombre, dpi, pass, numRegistro, tel, tipoExamen, correo, Date.valueOf(fechaInicio));
                        int numAgregar = laboratoristaDAO.agregar(lab);
                        request.setAttribute("numAgregado", numAgregar);
                        request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    }
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    Laboratorista lab = laboratoristaDAO.listarId(id);
                    request.setAttribute("editarLaboratorista", lab);
                    request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreA = request.getParameter("txtNombreLab");
                    String numRegistroA = request.getParameter("txtNoRegistroLab");
                    String dpiA = request.getParameter("txtDpiLab");
                    String telA = request.getParameter("txtTelLab");
                    String tipoExamenA = request.getParameter("txtTipoExamenLab");
                    String correoA = request.getParameter("txtCorreoLab");
                    String fechaInicioA = request.getParameter("txtITLab");
                    String passA = request.getParameter("txtPassLab");
                    if(nombreA.replaceAll("\\r|\\n", "").equals("")|| numRegistroA.replaceAll("\\r|\\n", "").equals("")||
                            dpiA.replaceAll("\\r|\\n", "").equals("")||telA.replaceAll("\\r|\\n", "").equals("")||
                            tipoExamenA.replaceAll("\\r|\\n", "").equals("")||correoA.replaceAll("\\r|\\n", "").equals("")||
                            fechaInicioA.replaceAll("\\r|\\n", "").equals("")){
                        int numActualizarVacio = 6;
                        request.setAttribute("numActualizarConsultVacia", numActualizarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    }else{
                        if(passA.replaceAll("\\r|\\n", "").equals("")){
                        lab = new Laboratorista(id, nombreA, dpiA, passA, numRegistroA, telA, tipoExamenA, correoA, Date.valueOf(fechaInicioA));
                        int numActualizarSinPass = laboratoristaDAO.actualizarSinPass(lab);
                        request.setAttribute("numActuConsulta", numActualizarSinPass);
                        request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    }else{
                        String passAEncr = DigestUtils.md5Hex(passA);
                        lab = new Laboratorista(id, nombreA, dpiA, passAEncr, numRegistroA, telA, tipoExamenA, correoA, Date.valueOf(fechaInicioA));
                        int numActualizarConPass = laboratoristaDAO.actualizar(lab);
                        request.setAttribute("numActuConsulta", numActualizarConPass);
                        request.getRequestDispatcher("Prueba?menu=AgregarLaboratorista&accion=Listar").forward(request, response);
                    }
                    }
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
                    String pass = DigestUtils.md5Hex(request.getParameter("txtPassPac"));
                    if(codigo.replaceAll("\\r|\\n", "").equals("")|| nombre.replaceAll("\\r|\\n", "").equals("")||
                            genero.replaceAll("\\r|\\n", "").equals("")||fechaNac.replaceAll("\\r|\\n", "").equals("")||
                            dpi.replaceAll("\\r|\\n", "").equals("")||tel.replaceAll("\\r|\\n", "").equals("")||
                            peso.replaceAll("\\r|\\n", "").equals("")||tipoSangre.replaceAll("\\r|\\n", "").equals("")||
                            correo.replaceAll("\\r|\\n", "").equals("")||pass.replaceAll("\\r|\\n", "").equals("")){
                        int numAgregarVacio = 5;
                        request.setAttribute("numVacioConsulta", numAgregarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    }else{
                        Paciente pacient = new Paciente(codigo, nombre, dpi, pass, genero, Date.valueOf(fechaNac),tel, Double.parseDouble(peso), tipoSangre, correo);
                        int numAgregar = pacienteDAO.agregar(pacient);
                        request.setAttribute("numAgregado", numAgregar);
                        request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    }
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
                    if(codigoA.replaceAll("\\r|\\n", "").equals("")||nombreA.replaceAll("\\r|\\n", "").equals("")||
                            generoA.replaceAll("\\r|\\n", "").equals("")||fechaNacA.replaceAll("\\r|\\n", "").equals("")||
                            dpiA.replaceAll("\\r|\\n", "").equals("")||telA.replaceAll("\\r|\\n", "").equals("")||
                            pesoA.replaceAll("\\r|\\n", "").equals("")||tipoSangreA.replaceAll("\\r|\\n", "").equals("")||
                            correoA.replaceAll("\\r|\\n", "").equals("")){
                        int numActualizarVacio = 6;
                        request.setAttribute("numActualizarConsultVacia", numActualizarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    }else{
                        if(passA.replaceAll("\\r|\\n", "").equals("")){
                        Paciente pacientA = new Paciente(codigoA, nombreA, dpiA, passA, generoA, Date.valueOf(fechaNacA),telA, Double.parseDouble(pesoA), tipoSangreA, correoA);
                        int numActualizarSinPass = pacienteDAO.actualizarSinPass(pacientA);
                        request.setAttribute("numActuConsulta", numActualizarSinPass);
                        request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    }else{
                        String passAEnce = DigestUtils.md5Hex(passA);
                        Paciente pacientA = new Paciente(codigoA, nombreA, dpiA, passAEnce, generoA, Date.valueOf(fechaNacA),telA, Double.parseDouble(pesoA), tipoSangreA, correoA);
                        int numActualizarConPass = pacienteDAO.actualizar(pacientA);
                        request.setAttribute("numActuConsulta", numActualizarConPass);
                        request.getRequestDispatcher("Prueba?menu=AgregarPaciente&accion=Listar").forward(request, response);
                    }
                    }
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
                    if(id.replaceAll("\\r|\\n", "").equals("")){
                        int buscVacio = 3;
                        request.setAttribute("numActuConsulta", buscVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarEspecialidad&accion=Listar").forward(request, response);
                    }else{
                        Doctor doc = doctorDAO.listarId(id);
                        request.setAttribute("buscarDoctorEs", doc);
                        request.getRequestDispatcher("Prueba?menu=AgregarEspecialidad&accion=Listar").forward(request, response);
                    }
                    break;
                case "Agregar":
                    String codigo = request.getParameter("txtCodigoDoc");
                    String especialidad = request.getParameter("txtEspecialidadDoc");
                    if(codigo.replaceAll("\\r|\\n", "").equals("")||especialidad.replaceAll("\\r|\\n", "").equals("")){
                        int numAgregarVacio = 5;
                        request.setAttribute("numVacioConsulta", numAgregarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarEspecialidad&accion=Listar").forward(request, response);
                    }else{
                        EspecialidadMedico especialidadMedico = new EspecialidadMedico(codigo, especialidad);
                        int numAgregar = especialidadMedicoDAO.agregar(especialidadMedico);
                        request.setAttribute("numAgregado", numAgregar);
                        request.getRequestDispatcher("Prueba?menu=AgregarEspecialidad&accion=Listar").forward(request, response);
                    }
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
                    String costoString = request.getParameter("txtCostoConsulta");
                    //int costo = Integer.parseInt(request.getParameter("txtCostoConsulta"));
                    if(tipo.replaceAll("\\r|\\n", "").equals("") || costoString.replaceAll("\\r|\\n", "").equals("")){
                        int numVacioConsulta = 5;
                        request.setAttribute("numVacioConsulta", numVacioConsulta);
                        request.getRequestDispatcher("Prueba?menu=ServicioConsultaDoctor&accion=Listar").forward(request, response);
                    }else{
                        int costo = Integer.parseInt(request.getParameter("txtCostoConsulta"));
                        Consulta consult = new Consulta(tipo, costo);
                        int numAregarConsulta = consultaDAO.agregar(consult);
                        //JOptionPane.showMessageDialog(null, agregarConsulta);
                        request.setAttribute("numAgregado", numAregarConsulta);
                        request.getRequestDispatcher("Prueba?menu=ServicioConsultaDoctor&accion=Listar").forward(request, response);
                    }
                    break;
                case "Actualizar":
                    //String tipo = request.getParameter("txtTipoConsulta");
                    String costoAString = request.getParameter("txtCostoConsulta");
                    if(costoAString.replaceAll("\\r|\\n", "").equals("")){
                        int numActualizarConsultaVacia = 6;
                        request.setAttribute("numActualizarConsultVacia", numActualizarConsultaVacia);
                        request.getRequestDispatcher("Prueba?menu=ServicioConsultaDoctor&accion=Listar").forward(request, response);
                    }
                    int costoA = Integer.parseInt(request.getParameter("txtCostoConsulta"));
                    Consulta consul = new Consulta(id, costoA);
                    int numActualizarConsulta = consultaDAO.actualizar(consul);
                    request.setAttribute("numActuConsulta", numActualizarConsulta);
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
                    Random rng = new Random();
                    int dig3 = rng.nextInt(900)+100;
                    String codigo = String.valueOf(dig3);
                    String tipoEx = request.getParameter("txtNombreEx");
                    String orden = request.getParameter("txtOrdenEx");
                    String descripcion = request.getParameter("txtDescripcionEx");
                    String costoString = request.getParameter("txtCostoEx");
                    String informe = request.getParameter("txtInformeEx");
                    if(codigo.replaceAll("\\r|\\n", "").equals("") || tipoEx.replaceAll("\\r|\\n", "").equals("") || orden.replaceAll("\\r|\\n", "").equals("")
                            || descripcion.replaceAll("\\r|\\n", "").equals("") || costoString.replaceAll("\\r|\\n", "").equals("")
                            ||informe.replaceAll("\\r|\\n", "").equals("")){
                        int numCasillasVacias = 5;
                        request.setAttribute("numVacioConsulta", numCasillasVacias);
                        request.getRequestDispatcher("Prueba?menu=AgregarExamenLab&accion=Listar").forward(request, response);
                    }else{
                        double costo = Double.parseDouble(request.getParameter("txtCostoEx"));
                        Examen examen = new Examen(codigo, tipoEx, orden, descripcion, costo, informe);
                        int agregarExamenLab = examenDAO.agregar(examen);
                        request.setAttribute("numAgregado", agregarExamenLab);
                        request.getRequestDispatcher("Prueba?menu=AgregarExamenLab&accion=Listar").forward(request, response);
                    }
                    break;
                case "Actualizar":
                    String codigoA = request.getParameter("txtCodigoEx");
                    String tipoExA = request.getParameter("txtNombreEx");
                    String ordenA = request.getParameter("txtOrdenEx");
                    String descripcionA = request.getParameter("txtDescripcionEx");
                    String costoAString = request.getParameter("txtCostoEx");
                    String informeA = request.getParameter("txtInformeEx");
                    if(codigoA.replaceAll("\\r|\\n", "").equals("") || tipoExA.replaceAll("\\r|\\n", "").equals("")
                            || ordenA.replaceAll("\\r|\\n", "").equals("") || descripcionA.replaceAll("\\r|\\n", "").equals("")
                            || costoAString.replaceAll("\\r|\\n", "").equals("") || informeA.replaceAll("\\r|\\n", "").equals("")){
                        int numActualizarVacio = 6;
                        request.setAttribute("numActualizarConsultVacia", numActualizarVacio);
                        request.getRequestDispatcher("Prueba?menu=AgregarExamenLab&accion=Listar").forward(request, response);
                    }else{
                        double costoA = Double.parseDouble(request.getParameter("txtCostoEx"));
                        Examen examenA = new Examen(codigoA, tipoExA, ordenA, descripcionA, costoA, informeA);
                        int numActualizar = examenDAO.actualizar(examenA);
                        request.setAttribute("numActuConsulta", numActualizar);
                        request.getRequestDispatcher("Prueba?menu=AgregarExamenLab&accion=Listar").forward(request, response);
                    }
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
