<%-- 
    Document   : AdminAgregarEspecialidad
    Created on : 1/10/2020, 19:09:17
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
                width:1000px; 
            } 
        </style>
    </head>
    <body>
        <c:if test="${numAgregado eq 1}">
            <div class="alert alert-success text-center" role="alert">
                Especialidad de Doctor Registrada Correctamente
            </div>
        </c:if>
        <c:if test="${numAgregado eq 2}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss, a ocurrido un Error! No se Registro la especialidad de el Doctor
            </div>
        </c:if>
        <c:if test="${numActuConsulta eq 3}">
            <div class="alert alert-success text-center" role="alert">
                El campo buscar Doctor está Vacío, debes de agregar el código del Doctor
            </div>
        </c:if>
        <c:if test="${numVacioConsulta eq 5}">
            <div class="alert alert-warning text-center" role="alert">
                ¡Upss! Algun campo se Encuentra Vacío
            </div>
        </c:if>
        <h2 class="text-center">Agregar Especialidad Doctor</h2>
            <div>
                <div>
                    <form action="Prueba?menu=AgregarEspecialidad&accion=Agregar" method="POST">
                        <div class="row">
                          <div class="col">
                            <input type="hidden" value="" name="" class="form-control" placeholder="">
                          </div>
                          <div class="col">
                            <input type="hidden" value="" name="" class="form-control" placeholder="">
                          </div>
                          <div class="col">
                              <input class="form-control mr-sm-2" name="txtBuscarDocEsp" type="search" placeholder="Buscar Código Doctor" aria-label="Search">
                          </div>
                          <div class="col">
                              <input class="btn btn-outline-dark my-2 my-sm-0" type="submit" value="Buscar" formaction="Prueba?menu=AgregarEspecialidad&accion=Buscar">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                              <input type="text" value="${buscarDoctorEs.getCodigo()}" name="txtCodigoDoc" class="form-control" placeholder="Código" readonly>
                          </div>
                          <div class="col">
                              <input type="text" value="${buscarDoctorEs.getNombre()}" name="txtNombreDoc" class="form-control" placeholder="Nombre" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="${buscarDoctorEs.getColegiado()}" name="txtColegiadoDoc" class="form-control" placeholder="No. Colegiado" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="${buscarDoctorEs.getDpi()}" name="txtDpiDoc" class="form-control" placeholder="Dpi" readonly>
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${buscarDoctorEs.getTelefono()}" name="txtTelDoc" class="form-control" placeholder="Telefono" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="${buscarDoctorEs.getCorreo()}" name="txtCorreoDoc" class="form-control" placeholder="Correo Electronico" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="${buscarDoctorEs.getHorario_Inicio()}" name="txtHIDoc" class="form-control" placeholder="Hora Ingreso(HH:MM)" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="${buscarDoctorEs.getHorario_Fin()}" name="txtHSDoc" class="form-control" placeholder="Hora Salida(HH:MM)" readonly>
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${buscarDoctorEs.getInicio_trabajar()}" name="txtITDoc" class="form-control" placeholder="Fecha que Inicio Trabajar" readonly>
                          </div>
                          <div class="col">
                            <input type="text" value="" name="txtEspecialidadDoc" class="form-control" placeholder="Especialidad">
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                          </div>
                          <div class="col">
                              <input type="hidden" class="btn btn-success" name="accion" value="Actualizar">
                          </div>
                        </div>
                        </br>
                    </form>
                </div>
                <h3 class="text-center">Doctores y Especialidades Existentes</h3>
            </div>
            <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Especialidad</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="docEsp" items="${listaEspecialidadDoctor}">
                            <tr>
                                <th>${docEsp.getCodigo()}</th>
                                <td>${docEsp.getEspecialidad()}</td>
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
