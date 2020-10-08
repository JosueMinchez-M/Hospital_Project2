<%-- 
    Document   : Prueba
    Created on : 30/09/2020, 22:24:23
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
            .scrollableTabla{
                height: 250px;
                overflow-y: scroll;
            }
            form { 
                margin: 0 auto; 
                width:1260px; 
            } 
        </style>
    </head>
    <body>
        <c:if test="${numAgregado eq 1}">
            <div class="alert alert-success text-center" role="alert">
                Doctor Registrado Correctamente
            </div>
        </c:if>
        <c:if test="${numAgregado eq 2}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss, a ocurrido un Error! No se Registro el Doctor
            </div>
        </c:if>
        <c:if test="${numActuConsulta eq 3}">
            <div class="alert alert-success text-center" role="alert">
                Doctor Actualizado Correctamente
            </div>
        </c:if>
        <c:if test="${numActuConsulta eq 4}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss, a ocurrido un Error! No se Actualizo el Doctor
            </div>
        </c:if>
        <c:if test="${numVacioConsulta eq 5}">
            <div class="alert alert-warning text-center" role="alert">
                ¡Upss! Algun campo se Encuentra Vacío
            </div>
        </c:if>
        <c:if test="${numActualizarConsultVacia eq 6}">
            <div class="alert alert-warning text-center" role="alert">
                ¡Upss! Algun campo se Encuentra Vacío
            </div>
        </c:if>
            <div>
                <h2 class="text-center">Agregar Doctor</h2>
                <div>
                    <form action="Prueba?menu=AgregarDoctor&accion=Agregar" method="POST">
                        <div class="row">
                          <div class="col">
                              <input type="text" value="${editarDoctor.getCodigo()}" name="txtCodigoDoc" class="form-control" placeholder="Código Generado Automático" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="${editarDoctor.getNombre()}" name="txtNombreDoc" class="form-control" placeholder="Nombre(obligatorio)">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarDoctor.getColegiado()}" name="txtColegiadoDoc" class="form-control" placeholder="No. Colegiado(obligatorio)">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarDoctor.getDpi()}" name="txtDpiDoc" class="form-control" placeholder="Dpi(obligatorio)">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${editarDoctor.getTelefono()}" name="txtTelDoc" class="form-control" placeholder="Telefono">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarDoctor.getCorreo()}" name="txtCorreoDoc" class="form-control" placeholder="Correo Electronico">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarDoctor.getHorario_Inicio()}" name="txtHIDoc" class="form-control" placeholder="Hora Ingreso(HH:MM)">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarDoctor.getHorario_Fin()}" name="txtHSDoc" class="form-control" placeholder="Hora Salida(HH:MM)">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${editarDoctor.getInicio_trabajar()}" name="txtITDoc" class="form-control" placeholder="Fecha que Inicio Trabajar">
                          </div>
                          <div class="col">
                            <input type="password" name="txtPassDoc" class="form-control" placeholder="Contraseña (Ingresar si es necesario)">
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                          </div>
                          <div class="col">
                              <input type="submit" class="btn btn-success" name="accion" value="Actualizar" formaction="Prueba?menu=AgregarDoctor&accion=Actualizar">
                          </div>
                        </div>
                        </br>
                    </form>
                </div>
                <h3 class="text-center">Doctores Existentes</h3>
            </div>
            <div class="scrollableTabla">
                
                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>No. Colegiado</th>
                        <th>Dpi</th>
                        <th>Teléfono</th>
                        <th>Correo Electronico</th>
                        <th>Horario Entrada</th>
                        <th>Horario Salida</th>
                        <th>Fecha de Inicio Trabajar</th>
                        <th>Contraseña</th>
                        <th>Accion</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="doc" items="${listaDoctor}">
                            <tr>
                                <th>${doc.getCodigo()}</th>
                                <td>${doc.getNombre()}</td>
                                <td>${doc.getColegiado()}</td>
                                <td>${doc.getDpi()}</td>
                                <td>${doc.getTelefono()}</td>
                                <td>${doc.getCorreo()}</td>
                                <td>${doc.getHorario_Inicio()}</td>
                                <td>${doc.getHorario_Fin()}</td>
                                <td>${doc.getInicio_trabajar()}</td>
                                <td>${doc.getPassword()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Prueba?menu=AgregarDoctor&accion=Editar&id=${doc.getCodigo()}">Editar</a>
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
