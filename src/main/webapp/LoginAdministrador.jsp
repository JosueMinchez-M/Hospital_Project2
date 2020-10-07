<%-- 
    Document   : LoginAdministrador
    Created on : 28/09/2020, 20:01:01
    Author     : joshua
--%>

<%@page import="com.mycompany.hospitalproject2.DAO.PacienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Login Administrador</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class ="card-body text-center">
                    <form class ="form-sign" method = "POST" action="ValidarAdministrador">
                        <div class ="form-group">
                            <h3>Login Administrador</h3>
                            <img src="imagenes/Administrador.png" alt="70" width="160"/>
                            <label>Bienvenido al sistema del Hospital</label>
                        </div>
                        <div class ="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txt_userAdmin" class ="form-control">                          
                        </div>
                        <div class ="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="txt_passwordAdmin" class ="form-control">
                            
                        </div>
                        <input type="submit" name="btn_registrarAdmin" value="Registrar" class="btn btn-primary btn_blog">
                    </form>
                </div>
            </div>
        </div>
        <%
            PacienteDAO pacienteDAO = new PacienteDAO();
            if(pacienteDAO.cantidadPacientes() <= 0){
        %>
        <div class="container mt-4 col-lg-4">
            <a type="submit" name="btn_ImportarDatos" class="btn btn-danger btn_blog" href="upload.jsp">Importar Datos XML</a>
        </div>
        <%}else{}%>
        <div class="container mt-4 col-lg-4">
            <a type="submit" name="btn_RegresarLab" class="btn btn-success btn_blog" href="TipoUsuario.jsp">Regresar al Inicio</a>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
