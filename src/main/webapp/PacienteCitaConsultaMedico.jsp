<%-- 
    Document   : ConsultaMedico
    Created on : 29/09/2020, 15:42:31
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
            .scrollable{
                height: 200px;
                overflow-y: scroll;
            }
            .scrollableTabla{
                height: 250px;
                overflow-y: scroll;
            }
            form { 
                margin: 0 auto; 
                width:1250px; 
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
              </ul>
                <form class="form-inline my-2 my-lg-0" action="ControladorPacienteDB?menu=AgendarCitaDoctor&accion=BuscarNombre" method="POST">
                  <input class="form-control mr-sm-2" name="txtBuscarNombreDoctor" type="search" placeholder="Buscar por Nombre" aria-label="Search">
                  <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Buscar</button>
                  <input class="form-control mr-sm-2" name="txtBuscarEspDoctor" type="search" placeholder="Buscar por Especialidad" aria-label="Search">
                  <button class="btn btn-outline-dark my-2 my-sm-0" type="submit" formaction="ControladorPacienteDB?menu=AgendarCitaDoctor&accion=BuscarEspecialidad">Buscar</button>
                  <input class="form-control mr-sm-2" name="txtBuscarFechaMenorDoctor" type="search" placeholder="Fecha Menor(0000-00-00)" aria-label="Search">
                  <input class="form-control mr-sm-2" name="txtBuscarFechaMayorMedic" type="search" placeholder="Fecha Mayor(0000-00-00)" aria-label="Search">
                  <button class="btn btn-outline-dark my-2 my-sm-0" type="submit" formaction="ControladorPacienteDB?menu=AgendarCitaDoctor&accion=BuscarRangoFecha">Buscar</button>
                  <div>
                      </br>
                    <button class="btn btn-outline-dark my-2 my-sm-0" type="submit" formaction="ControladorPacienteDB?menu=AgendarCitaDoctor&accion=Listar">Mostrar Todo</button>
                  </div>
              </form>
            </div>
        </nav>
        <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>No. Colegiado</th>
                        <th>Dpi</th>
                        <th>Correo Electronico</th>
                        <th>Horario Entrada</th>
                        <th>Horario Salida</th>
                        <th>Fecha de Inicio Trabajar</th>
                        <th>Especialidad</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listEspJoin" items="${listaEspecialidadDoctorJoin}">
                            <tr>
                                <th>${listEspJoin.getCodigo()}</th>
                                <td>${listEspJoin.getNombre()}</td>
                                <td>${listEspJoin.getColegiado()}</td>
                                <td>${listEspJoin.getDpi()}</td>
                                <td>${listEspJoin.getCorreo()}</td>
                                <td>${listEspJoin.getHorario_Inicio()}</td>
                                <td>${listEspJoin.getHorario_Fin()}</td>
                                <td>${listEspJoin.getInicio_trabajar()}</td>
                                <td>${listEspJoin.getEspecialidad()}</td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
            </br>
            </br>
                <div>
                    <form action="ControladorPacienteDB?menu=AgendarCitaDoctor&accion=AgregarCita" method="POST">
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
                            <input type="text" name="txtCodigoPacienteCita" class="form-control" placeholder="Codigo Paciente">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" name="txtCodigoDoctorCita" class="form-control" placeholder="Codigo Doctor">
                          </div>
                          <div class="col">
                              <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar" formaction="Prueba?menu=AgregarDoctor&accion=Actualizar">
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
