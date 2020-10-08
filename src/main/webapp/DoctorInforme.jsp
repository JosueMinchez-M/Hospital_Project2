<%-- 
    Document   : DoctorInforme
    Created on : 29/09/2020, 16:19:02
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
                width:1150px; 
            }
            form.input-group{ 
                margin: 0 auto; 
                width:100px; 
            }
        </style>
    </head>
    <body>
        <c:if test="${numAgregado eq 1}">
            <div class="alert alert-success text-center" role="alert">
                Registrado Correctamente
            </div>
        </c:if>
        <c:if test="${numAgregado eq 2}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss, a ocurrido un Error! No se Registro
            </div>
        </c:if>
        <c:if test="${numActuConsulta eq 3}">
            <div class="alert alert-success text-center" role="alert">
                Examen Actualizado Correctamente
            </div>
        </c:if>
        <c:if test="${numActuConsulta eq 4}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss, a ocurrido un Error! No se Actualizo la Consulta
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
        <h1 class="text-center">Buscador de Citas</h1>
        <div class="form-group">
            <form action="ControladorMedicoDB?menu=InformeMedico&accion=BuscarCodigoCita" method="POST">
                <div class="row">
                    <div class="col">
                        <input class="form-control mr-sm-2" style="width: 700px; height: 40px" name="txtBuscarCodigo" type="search" placeholder="Ingrese el Código de la Cita" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="btn btn-outline-dark my-2 my-sm-0" name="accion" type="submit" value="Buscar">
                    </div>
                    <div class="col">
                        <input type="hidden" class="form-control mr-sm-2" name="txtCodigoMedico" type="search" value="${codMedico}">
                    </div>
                </div>
            </form>
        </div>
        </br>
        <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Tipo Especialidad</th>
                        <th>Fecha Cita</th>
                        <th>Hora Cita</th>
                        <th>Codigo Paciente</th>
                        <th>Codigo Doctor</th>
                        <th>Accion</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listCitaDoc" items="${listaCitaDoc}">
                            <tr>
                                <th>${listCitaDoc.getCodigo()}</th>
                                <td>${listCitaDoc.getEspecialidad()}</td>
                                <td>${listCitaDoc.getFecha()}</td>
                                <td>${listCitaDoc.getHora()}</td>
                                <td>${listCitaDoc.getPaciente()}</td>
                                <td>${listCitaDoc.getMedico()}</td>
                                <td>
                                    <form class="input-group" action="ControladorMedicoDB?menu=InformeMedico&accion=Editar&id=${listCitaDoc.getCodigo()}" method="POST">
                                        <input type="hidden" name="txtCodTabla" value="${codMedico}" class="form-control">
                                        <input type="submit" class="btn btn-warning" name="accion" value="Seleccionar">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
            </br>
        </br>
            <div>
                <h2 class="text-center">Redactar Informe Consulta Paciente</h2>
                <div>
                    <form action="ControladorMedicoDB?menu=InformeMedico&accion=Agregar" method="POST">
                        <div class="row">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                  <span class="input-group-text">Informe Paciente</span>
                                </div>
                                <textarea class="form-control" aria-label="With textarea" name="txtAreaInforme" placeholder="Redacte aqui informe del paciente">${editarCitaDoc.getEspecialidad()}</textarea>
                            </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" name="txtFechaInf" value="${editarCitaDoc.getFecha()}" class="form-control" placeholder="Fecha Consulta (0000-00-00)">
                          </div>
                          <div class="col">
                              <input type="text" name="txtHoraInf" value="${editarCitaDoc.getHora()}" class="form-control" placeholder="Hora Consulta (00:00)">
                          </div>
                          <div class="col">
                            <input type="text" name="txtCodPacienteInf" value="${editarCitaDoc.getPaciente()}" class="form-control" placeholder="Código Paciente">
                          </div>
                          <div class="col">
                              <input type="text" name="txtCodMedicoInf" value="${codMedico}" class="form-control" placeholder="Código Doctor" readonly>
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-primary" name="accion" value="Registrar Informe">
                          </div>
                        </div>
                        </br>
                        </br>
                    </form>
                </div>
                <h3 class="text-center">Agendar Nueva Consulta</h3>
            </div>
            </br>
                <div>
                    <form action="ControladorMedicoDB?menu=InformeMedico&accion=AgregarCitaDoctor" method="POST">
                        <div class="row">
                          <div class="col">
                            <input type="text" name="txtEspecialidadCita" class="form-control" placeholder="Especialidad">
                          </div>
                          <div class="col">
                            <input type="text" name="txtFechaCita" class="form-control" placeholder="Fecha de la Cita">
                          </div>
                          <div class="col">
                            <input type="text" name="txtHoraCita" class="form-control" placeholder="Hora de la Consulta">
                          </div>
                          <div class="col">
                            <input type="text" name="txtCodigoPacienteCita" value="${editarCitaDoc.getPaciente()}" class="form-control" placeholder="Codigo Paciente">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                              <input type="text" name="txtCodigoDoctorCita" value="${codMedico}" class="form-control" placeholder="Codigo Doctor" readonly>
                          </div>
                          <div class="col">
                              <input type="submit" class="btn btn-primary" name="accion" value="Registrar Cita">
                          </div>
                          <div class="col">
                            <input type="hidden" class="btn btn-success" name="accion" value="Actualizar" formaction="Prueba?menu=AgregarDoctor&accion=Actualizar">
                          </div>
                          <div class="col">
                              <input type="hidden" name="txtCodigoDoctorCita" class="form-control" placeholder="Codigo Doctor">
                          </div>
                        </div>
                        </br>
                    </form>
                </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
