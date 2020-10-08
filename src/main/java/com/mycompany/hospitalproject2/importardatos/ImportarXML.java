package com.mycompany.hospitalproject2.importardatos;


import com.mycompany.hospitalproject2.Administrador;
import com.mycompany.hospitalproject2.Cita;
import com.mycompany.hospitalproject2.Consulta;
import com.mycompany.hospitalproject2.DiaDeTrabajoLaboratorista;
import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.EspecialidadMedico;
import com.mycompany.hospitalproject2.Examen;
import com.mycompany.hospitalproject2.Laboratorista;
import com.mycompany.hospitalproject2.Paciente;
import com.mycompany.hospitalproject2.Reporte;
import com.mycompany.hospitalproject2.Resultado;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author joshua
 */
public class ImportarXML {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection acceso;
    String[] nombreTag = {"admin", "doctor", "laboratorista", "paciente", "examen", "reporte", "resultado", 
        "cita", "consulta"};
    ArrayList<String> capturarDatos = new ArrayList<String>();
     ArrayList<String> especialidadDoctor = new ArrayList<String>();
     ArrayList<String> diasDeTrabajoLaboratorista = new ArrayList<String>();
    Administrador administrador;
    Doctor doctor;
    EspecialidadMedico especialidadMedico;
    Laboratorista laboratorista;
    DiaDeTrabajoLaboratorista diaDeTrabajoLaboratorista;
    Paciente paciente;
    Examen examen;
    Reporte reporte;
    Resultado resultado;
    Cita cita;
    Consulta consulta;
    String inicio_trabajo = "";
    
    public void analizarXML(String Path){
        try {
            for (int z = 0; z < nombreTag.length; z++) {
                capturarDatos.clear();
                // Creo una instancia de DocumentBuilderFactory
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                // Creo un documentBuilder
                DocumentBuilder builder = factory.newDocumentBuilder();
                // Obtengo el documento, a partir del XML /home/joshua/Escritorio/datosHospital.xml
                Document documento = builder.parse(new File(Path));
                // Cojo todas las etiquetas coche del documento
                NodeList lista = documento.getElementsByTagName(nombreTag[z]);
                if(nombreTag[z].equals("admin")){
                    obtenerContenidoTagGenearl(lista, nombreTag[z]);
                    //System.out.println(capturarDatos.size());
                }else if(nombreTag[z].equals("doctor")){
                    obtenerContenidoTagMedico(lista, documento, nombreTag[z]);
                    //System.out.println(capturarDatos.size());
                }else if(nombreTag[z].equals("laboratorista")){
                    obtenerContenidoTagMedico(lista, documento, nombreTag[z]);
                }else if(nombreTag[z].equals("paciente")){
                    obtenerContenidoTagGenearl(lista, nombreTag[z]);
                }else if(nombreTag[z].equals("examen")){
                    obtenerContenidoTagGenearl(lista, nombreTag[z]);
                }else if(nombreTag[z].equals("reporte")){
                    obtenerContenidoTagGenearl(lista, nombreTag[z]);
                }else if(nombreTag[z].equals("resultado")){
                    obtenerContenidoTagGenearl(lista, nombreTag[z]);
                }else if(nombreTag[z].equals("cita")){
                    obtenerContenidoTagMedico(lista, documento, nombreTag[z]);
                }else if(nombreTag[z].equals("consulta")){
                    obtenerContenidoTagGenearl(lista, nombreTag[z]);
                }
                //obtenerContenidoTagGenearl(listaCoches);
                
            }
 
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void obtenerContenidoTagGenearl(NodeList lista, String nombreTag){
        for (int i = 0; i < lista.getLength(); i++) {
            // Cojo el nodo actual
            Node nodo = lista.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                //System.out.println("*******"+hijos.getLength()+"*********");
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    //System.out.println("*******"+ hijo.getTextContent() +"*********");
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido
                        //System.out.println("*******"+ hijo.getTextContent() +"*********");
                        System.out.println("Propiedad: " + hijo.getNodeName()
                                        + ", Valor: " + hijo.getTextContent());
                        capturarDatos.add(hijo.getTextContent());
                        //System.out.println("**********[" + hijo.getTextContent().length() + "]*********");
                    }
                }
                System.out.println(capturarDatos.size());
                //System.out.println(capturarDatos.get(0));
                if(nombreTag.equals("admin")){
                    administrador = new Administrador(capturarDatos.get(0), capturarDatos.get(2), capturarDatos.get(1), DigestUtils.md5Hex(capturarDatos.get(3)));
                    insertarAdministrador();
                }else if(nombreTag.equals("paciente")){
                    paciente = new Paciente(capturarDatos.get(0), capturarDatos.get(1), capturarDatos.get(4), DigestUtils.md5Hex(capturarDatos.get(9)),
                            capturarDatos.get(2), Date.valueOf(capturarDatos.get(3)), capturarDatos.get(5), Double.parseDouble(capturarDatos.get(6)), 
                            capturarDatos.get(7), capturarDatos.get(8));
                    insertarPaciente();
                }else if(nombreTag.equals("examen")){
                    examen = new Examen(capturarDatos.get(0), capturarDatos.get(1), capturarDatos.get(2), 
                            capturarDatos.get(3), Double.parseDouble(capturarDatos.get(4)), capturarDatos.get(5));
                    insertarExamen();
                }else if(nombreTag.equals("reporte")){
                    reporte = new Reporte(capturarDatos.get(0), capturarDatos.get(1), Date.valueOf(capturarDatos.get(4)), 
                            capturarDatos.get(5), capturarDatos.get(2), capturarDatos.get(3));
                    insertarReporte();
                }else if(nombreTag.equals("resultado")){
                    resultado = new Resultado(capturarDatos.get(0), capturarDatos.get(1), Date.valueOf(capturarDatos.get(7)), 
                            capturarDatos.get(8), capturarDatos.get(3), capturarDatos.get(4), capturarDatos.get(5), capturarDatos.get(6),
                            capturarDatos.get(2));
                    insertarResultado();
                }else if(nombreTag.equals("consulta")){
                    consulta = new Consulta(capturarDatos.get(0), Integer.parseInt(capturarDatos.get(1)));
                    insertarConsulta();
                }
                capturarDatos.clear();
                System.out.println("");
            }

        }
    }
    public void obtenerContenidoTagMedico(NodeList lista, Document documento, String nombreTag){
        for (int i = 0; i < lista.getLength(); i++) {
            // Cojo el nodo actual
            Node nodo = lista.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                //System.out.println("*******"+hijos.getLength()+"*********");
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    //System.out.println("*******"+ hijo.getTextContent() +"*********");
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        // Muestro el contenido
                        //System.out.println("*******"+ hijo.getTextContent() +"*********");
                        //Sirve para obtener los datos de los tags multiples
                        if(hijo.getNodeName().equals("ESPECIALIDAD")){
                            String[] prueba = hijo.getTextContent().split("\r\n|\r|\n");
                            if(prueba.length == 1){
                                for (int k = 0; k < prueba.length; k++) {
                                System.out.println("Especialidad: " + prueba[k].replace(" ", ""));
                                especialidadDoctor.add(prueba[k].replace(" ", ""));
                            }
                            }else{
                                for (int k = 1; k < prueba.length-1; k++) {
                                    System.out.println("Especialidad: " + prueba[k].replace(" ", ""));
                                    especialidadDoctor.add(prueba[k].replace(" ", ""));
                                }
                            }    
                        }else if(hijo.getNodeName().equals("HORARIO")){
                            String[] prueba = hijo.getTextContent().split("\r\n|\r|\n");
                            for (int k = 1; k < prueba.length-1; k++) {
                                System.out.println("Horario: " + prueba[k].replace(" ", ""));
                                capturarDatos.add(prueba[k].replace(" ", ""));
                            }
//                            lista = documento.getElementsByTagName("HORARIO");
//                            obtenerContenidoTagGenearl(lista);
                        }else if(hijo.getNodeName().equals("TRABAJO")){
                            String[] prueba = hijo.getTextContent().split("\r\n|\r|\n");
                            if(prueba.length == 1){
                                inicio_trabajo = prueba[0];
                                System.out.println("Inicio de labores: " + inicio_trabajo);
                            }else{
                                for (int k = 1; k < prueba.length-1; k++) {
                                    System.out.println("Dias de Trabajo: " + prueba[k].replace(" ", ""));
                                    diasDeTrabajoLaboratorista.add(prueba[k].replace(" ", ""));
                                }
                            }
                        }else{
                            System.out.println("Propiedad: " + hijo.getNodeName()
                                        + ", Valor: " + hijo.getTextContent());
                            capturarDatos.add(hijo.getTextContent());
                        }
                    }

                }
                System.out.println(capturarDatos.size());
                if(nombreTag.equals("doctor")){
                    doctor = new Doctor(capturarDatos.get(0), capturarDatos.get(1), capturarDatos.get(3), 
                    DigestUtils.md5Hex(capturarDatos.get(8)), capturarDatos.get(2), capturarDatos.get(4),capturarDatos.get(5),
                    capturarDatos.get(6), capturarDatos.get(7), Date.valueOf(inicio_trabajo));
                    insertarMedico();
                    for (int j = 0; j < especialidadDoctor.size(); j++) {
                        especialidadMedico = new EspecialidadMedico(doctor.getCodigo(),especialidadDoctor.get(j));
                        insertarEspecialidadMedico();
                    }
                    especialidadDoctor.clear();
                }else if(nombreTag.equals("laboratorista")){
                    laboratorista = new Laboratorista(capturarDatos.get(0), capturarDatos.get(1), capturarDatos.get(3), DigestUtils.md5Hex(capturarDatos.get(7))
                    ,capturarDatos.get(2), capturarDatos.get(5), capturarDatos.get(5), capturarDatos.get(6),
                    Date.valueOf(inicio_trabajo));
                    insertarLaboratorista();
                    for (int j = 0; j < diasDeTrabajoLaboratorista.size(); j++) {
                        diaDeTrabajoLaboratorista = new DiaDeTrabajoLaboratorista(laboratorista.getCodigo(),
                        diasDeTrabajoLaboratorista.get(j));
                        insertarDiaDeTrabajoLaboratorista();
                    }
                    diasDeTrabajoLaboratorista.clear();
                }else if(nombreTag.equals("cita")){
                    for (int j = 0; j < especialidadDoctor.size(); j++) {
                        cita = new Cita(capturarDatos.get(0), capturarDatos.get(1), Date.valueOf(capturarDatos.get(3)), capturarDatos.get(4),
                            capturarDatos.get(2), especialidadDoctor.get(j));
                        insertarCita();
                    }
                    especialidadDoctor.clear();
                }
                capturarDatos.clear();
                System.out.println("");
            }

        }
    }
    public void insertarAdministrador(){
        //JOptionPane.showMessageDialog(null, "ESTA ES LA ULTIMA TABLA " + lineaArray[0]);
        String sql = "INSERT INTO Administrador (codigo, nombre, dpi, password) VALUES(?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, administrador.getCodigo());
            ps.setString(2, administrador.getNombre());
            ps.setString(3, administrador.getDpi());
            ps.setString(4, administrador.getPassword());
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Administrador Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR ADMINISTRADOR");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarMedico(){
        String sql = "INSERT INTO Medico (codigo, nombre, numero_colegiado, dpi, telefono,"
                + "correo_electronico, horario_inicio_trabajo, horario_fin_trabajo, fecha_inicio_trabajo,"
                + "password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, doctor.getCodigo());
            ps.setString(2, doctor.getNombre());
            ps.setString(3, doctor.getColegiado());
            ps.setString(4, doctor.getDpi());
            ps.setString(5, doctor.getTelefono());
            ps.setString(6, doctor.getCorreo());
            ps.setString(7, doctor.getHorario_Inicio());
            ps.setString(8, doctor.getHorario_Fin());
            ps.setDate(9, doctor.getInicio_trabajar());
            ps.setString(10, doctor.getPassword());
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Médico Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR MEDICO");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarEspecialidadMedico(){
        String sql = "INSERT INTO especialidad_medico (Medico_codigo, Especialidad_titulo) "
                + "VALUES(?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, especialidadMedico.getCodigo_medico());
            ps.setString(2, especialidadMedico.getEspecialidad());
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Médico y Especialidad Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR MEDICO y ESPECIALIDAD");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarLaboratorista(){
        String sql = "INSERT INTO Laboratorista (codigo, nombre, numero_registro_MS, dpi, telefono, examen_realiza,"
                + "correo_electronico, fecha_inicio_a_trabajar, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, laboratorista.getCodigo());
            ps.setString(2, laboratorista.getNombre());
            ps.setString(3, laboratorista.getNumero_registro());
            ps.setString(4, laboratorista.getDpi());
            ps.setString(5, laboratorista.getTelefono());
            ps.setString(6, laboratorista.getExamen_realizar());
            ps.setString(7, laboratorista.getCorreo());
            ps.setDate(8, laboratorista.getFecha_trabajar());
            ps.setString(9, laboratorista.getPassword());
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Laboratorista Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR LABORATORISTA");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarDiaDeTrabajoLaboratorista(){
        String sql = "INSERT INTO DiaDeTrabajoLaboratorista (Laboratorista_codigo, DiaDeTrabajo_dia_laboral) "
                + "VALUES(?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, diaDeTrabajoLaboratorista.getLaboratoristaCodigo());
            ps.setString(2, diaDeTrabajoLaboratorista.getDiaTrabajo());
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Día de trabajo Laboratorista Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR DIA TRABAJO LABORATORISTA");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarPaciente(){
        String sql = "INSERT INTO Paciente (codigo, nombre, sexo, fecha_nacimiento, dpi, telefono, peso_kg, "
                + "tipo_sangre, correo_electronico, password) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, paciente.getCodigo());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getSexo());
            ps.setDate(4, paciente.getFecha_nacimiento());
            ps.setString(5, paciente.getDpi());
            ps.setString(6, paciente.getTelefono());
            ps.setDouble(7, paciente.getPeso_kg());
            ps.setString(8, paciente.getTipo_Sangre());
            ps.setString(9, paciente.getCorreo());
            ps.setString(10, paciente.getPassword());
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Paciente Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR PACIENTE");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarExamen(){
        String sql = "INSERT INTO ExamenLaboratorio (codigo, nombre, requerimiento_orden_medico, "
                + "descripcion, costo, informe) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, examen.getCodigo());
            ps.setString(2, examen.getNombre());
            ps.setString(3, examen.getOrden());
            ps.setString(4, examen.getDescripcion());
            ps.setDouble(5, examen.getCosto());
            ps.setString(6, examen.getInforme());
            
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Examen Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR EXAMEN");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarReporte(){
        String sql = "INSERT INTO Informe (codigo, informe_redactado, fecha_de_consulta, "
                + "hora_de_cita, Paciente_codigo, Medico_codigo) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, reporte.getCodigo());
            ps.setString(2, reporte.getInforme());
            ps.setDate(3, reporte.getFecha());
            ps.setString(4, reporte.getHora());
            ps.setString(5, reporte.getPaciente());
            ps.setString(6, reporte.getMedico());
            
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Reporte Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR REPORTE");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarResultado(){
        String sql = "INSERT INTO Resultado (codigo, orden, informe, "
                + "fecha_realizo_examen, hora_cita, Paciente_codigo, Medico_codigo, ExamenLaboratorio_codigo,"
                + "Laboratorista_codigo) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, resultado.getCodigo());
            ps.setString(2, resultado.getOrden());
            ps.setString(3, resultado.getInforme());
            ps.setDate(4, resultado.getFecha());
            ps.setString(5, resultado.getHora());
            ps.setString(6, resultado.getPaciente());
            ps.setString(7, resultado.getMedico());
            ps.setString(8, resultado.getExamen());
            ps.setString(9, resultado.getLaboratorista());
            
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Resultado Guardado");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR RESULTADO");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarCita(){
        String sql = "INSERT INTO Cita (codigo, especialidad, fecha_consulta, "
                + "hora_establecida_consulta, Paciente_codigo, Medico_codigo) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, cita.getCodigo());
            ps.setString(2, cita.getEspecialidad());
            ps.setDate(3, cita.getFecha());
            ps.setString(4, cita.getHora());
            ps.setString(5, cita.getPaciente());
            ps.setString(6, cita.getMedico());
            
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Cita Guardada");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR CITA");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    public void insertarConsulta(){
        String sql = "INSERT INTO Consulta (tipo, costo) "
                + "VALUES(?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, consulta.getTipo());
            ps.setInt(2, consulta.getCosto());
            
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("Consulta Guardada");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR CONSULTA");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
}
