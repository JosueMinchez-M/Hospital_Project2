<%-- 
    Document   : AdminAgregarPaciente
    Created on : 4/10/2020, 19:32:16
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            .scrollableFormulario{
                height: 200px;
                width: 1300px;
                overflow-y: scroll;
            }
            .scrollableTabla{
                height: 250px;
                overflow-y: scroll;
            }
            form { 
                margin: 0 auto; 
                width:1200px; 
            } 
        </style>
    </head>
    <body>
            <div>
                <h2 class="text-center">Agregar/Modificar Paciente </h2>
                <div>
                    <form action="Prueba?menu=AgregarPaciente&accion=Agregar" method="POST">
                        <div class="row">
                          <div class="col">
                              <input type="text" value="${editarPaciente.getCodigo()}" name="txtCodigoPac" class="form-control" placeholder="Código generado Automáticamente" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="${editarPaciente.getNombre()}" name="txtNombrePac" class="form-control" placeholder="Nombre">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarPaciente.getSexo()}" name="txtGeneroPac" class="form-control" placeholder="Genero">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarPaciente.getFecha_nacimiento()}" name="txtFechaNacPac" class="form-control" placeholder="Fecha de Nacimiento (0000-00-00)">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${editarPaciente.getDpi()}" name="txtDpiPac" class="form-control" placeholder="Dpi">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarPaciente.getTelefono()}" name="txtTelPac" class="form-control" placeholder="Telefono">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarPaciente.getPeso_kg()}" name="txtPesoPac" class="form-control" placeholder="Peso(Kg)">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarPaciente.getTipo_Sangre()}" name="txtTipoSanPac" class="form-control" placeholder="Tipo de Sangre">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${editarPaciente.getCorreo()}" name="txtCorreoPac" class="form-control" placeholder="Correo Electronico">
                          </div>
                          <div class="col">
                            <input type="password" value="${editarPaciente.getPassword()}" name="txtPassPac" class="form-control" placeholder="Contraseña">
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                          </div>
                          <div class="col">
                              <input type="submit" class="btn btn-success" name="accion" value="Actualizar" formaction="Prueba?menu=AgregarPaciente&accion=Actualizar">
                          </div>
                        </div>
                        </br>
                    </form>
                </div>
                <h3 class="text-center">Pacientes Existentes</h3>
            </div>
            <div class="scrollableTabla">
                
                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Genero</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Dpi</th>
                        <th>Telefono</th>
                        <th>Peso(Kg)</th>
                        <th>Tipo de Sangre</th>
                        <th>Correo Electronico</th>
                        <th>Contraseña</th>
                        <th>Accion</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="pac" items="${listaPaciente}">
                            <tr>
                                <th>${pac.getCodigo()}</th>
                                <td>${pac.getNombre()}</td>
                                <td>${pac.getSexo()}</td>
                                <td>${pac.getFecha_nacimiento()}</td>
                                <td>${pac.getDpi()}</td>
                                <td>${pac.getTelefono()}</td>
                                <td>${pac.getPeso_kg()}</td>
                                <td>${pac.getTipo_Sangre()}</td>
                                <td>${pac.getCorreo()}</td>
                                <td>${pac.getPassword()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Prueba?menu=AgregarPaciente&accion=Editar&id=${pac.getCodigo()}">Editar</a>
                                </td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
