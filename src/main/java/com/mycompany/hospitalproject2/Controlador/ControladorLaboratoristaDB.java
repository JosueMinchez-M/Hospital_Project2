/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.DAO.CitaLaboratoristaDAO;
import com.mycompany.hospitalproject2.CitaLaboratorista;
import com.mycompany.hospitalproject2.DAO.ResultadoDAO;
import com.mycompany.hospitalproject2.Resultado;
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
@WebServlet(name = "ControladorLaboratoristaDB", urlPatterns = {"/ControladorLaboratoristaDB"})
public class ControladorLaboratoristaDB extends HttpServlet {
    ResultadoDAO resultadoDAO = new ResultadoDAO();
    CitaLaboratoristaDAO citaLaboratoristaDAO = new CitaLaboratoristaDAO();
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
        if(menu.equals("ResultadoLab")){
            switch(accion){
                case "ListarCitasLaboratorio":
                    String codigoLaboratorista = request.getParameter("txtCodigotx");
                    request.setAttribute("codLab", codigoLaboratorista);
                    List lista = citaLaboratoristaDAO.listarCitaLab(codigoLaboratorista);
                    request.setAttribute("listaCitaLab", lista);
                    request.getRequestDispatcher("LaboratoristaResultado.jsp").forward(request, response);
                    break;
                case "ListarBusqueda":
                    String codigoLab = request.getParameter("txtCodigoLab");
                    request.setAttribute("codLab", codigoLab);
                    String codIngresado = request.getParameter("txtBuscarCodigo");
                    List listaResulBus = citaLaboratoristaDAO.listarCitaLabPorCod(codIngresado);
                    request.setAttribute("listaCitaLab", listaResulBus);
                    request.getRequestDispatcher("LaboratoristaResultado.jsp").forward(request, response);
                    break;
                case "Editar":
                    String id = request.getParameter("id");
                    CitaLaboratorista citLab = citaLaboratoristaDAO.listarId(id);
                    request.setAttribute("editarCitaLab", citLab);
                    String codLab = request.getParameter("txtCodTabla");
                    request.setAttribute("codLab", codLab);
                    List lista1 = citaLaboratoristaDAO.listarCitaLab(codLab);
                    request.setAttribute("listaCitaLab", lista1);
                    request.getRequestDispatcher("LaboratoristaResultado.jsp").forward(request, response);
                    break;
                case "AgregarResultado":
                    String codigo = String.valueOf(generarNumero());
                    String orden = request.getParameter("txtOrdenRes");//txtOrdenRes
                    String informe = request.getParameter("txtInfoRes");//txtInfoRes
                    String fechaExamen = request.getParameter("txtFechaRes");//txtFechaRes
                    String horaExamen = request.getParameter("txtHoraRes");//txtCodPacienteRes
                    String pacienteCodigo = request.getParameter("txtCodPacienteRes");//txtCodDoctorRes
                    String medicoCodigo = request.getParameter("txtCodDoctorRes");//txtCodExamenRes
                    String examenCodigo = request.getParameter("txtCodExamenRes");//txtCodLabRes
                    String labCodigo = request.getParameter("txtCodLabRes");//txtHoraRes
                    Resultado result = new Resultado(codigo, pacienteCodigo, Date.valueOf(fechaExamen), horaExamen, examenCodigo, labCodigo, orden, informe, medicoCodigo);
                    resultadoDAO.agregar(result);
                    String codLab1 = request.getParameter("txtCodLabRes");
                    request.setAttribute("codLab", codLab1);
                    List lista2 = citaLaboratoristaDAO.listarCitaLab(codLab1);
                    request.setAttribute("listaCitaLab", lista2);
                    request.getRequestDispatcher("LaboratoristaResultado.jsp").forward(request, response);
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
