<%-- 
    Document   : PacienteConsulta1
    Created on : 5/10/2020, 01:14:10
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
                height: 200px;
                overflow-y: scroll;
            }
            form { 
                margin: 0 auto; 
                width:1150px; 
            }
        </style>
    </head>
    <body>
        <h2 class="text-center">Ultimos 5 examenes de laboratorio realizados</h2>
        </br>
        <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código Cita</th>
                        <th>Tipo Examen</th>
                        <th>Fecha Cita</th>
                        <th>Hora Cita</th>
                        <th>Codigo Paciente</th>
                        <th>Codigo Laboratorista</th>
                        <th>Código Doctor</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listc1" items="${listac1}">
                            <tr>
                                <th>${listc1.getCodigo()}</th>
                                <td>${listc1.getCodigoExamen()}</td>
                                <td>${listc1.getFechaCitaLab()}</td>
                                <td>${listc1.getHoraEstablecida()}</td>
                                <td>${listc1.getCodigoPaciente()}</td>
                                <td>${listc1.getCodigoLaboratorista()}</td>
                                <td>${listc1.getCodigoMedico()}</td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
            </br>
            <h2 class="text-center">Exámenes realizados de un tipo en específico dentro de un intervalo de tiempo</h2>
            <div class="form-group">
            <form action="ControladorPacienteDB?menu=Consulta1&accion=Listar2" method="POST">
                <div class="row">
                    <div class="col">
                        <input class="form-control mr-sm-2" name="txtBuscarCodigoTipo" type="search" placeholder="Codigo Tipo" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="form-control mr-sm-2" name="txtBuscarFechaMenor" type="search" placeholder="Fecha Menor" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="form-control mr-sm-2" name="txtBuscarFechaMayor" type="search" placeholder="Fecha Mayor" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="btn btn-outline-dark my-2 my-sm-0" name="accion" type="submit" value="Buscar">
                    </div>
                    <div class="col">
                        <input type="hidden" class="form-control mr-sm-2" name="txtCodigoPaci" type="search" value="${codPaci}">
                    </div>
                </div>
            </form>
        </div>
            </br>
            <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código Cita</th>
                        <th>Tipo Examen</th>
                        <th>Fecha Cita</th>
                        <th>Hora Cita</th>
                        <th>Codigo Paciente</th>
                        <th>Codigo Laboratorista</th>
                        <th>Código Doctor</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listc2" items="${listac2}">
                            <tr>
                                <th>${listc2.getCodigo()}</th>
                                <td>${listc2.getCodigoExamen()}</td>
                                <td>${listc2.getFechaCitaLab()}</td>
                                <td>${listc2.getHoraEstablecida()}</td>
                                <td>${listc2.getCodigoPaciente()}</td>
                                <td>${listc2.getCodigoLaboratorista()}</td>
                                <td>${listc2.getCodigoMedico()}</td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
            </br>
            <h2 class="text-center">Últimas 5 consultas realizadas</h2>
            <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código Consulta</th>
                        <th>Tipo Especialidad</th>
                        <th>Fecha Consulta</th>
                        <th>Hora Consulta</th>
                        <th>Codigo Paciente</th>
                        <th>Código Doctor</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listc3" items="${listac3}">
                            <tr>
                                <th>${listc3.getCodigo()}</th>
                                <td>${listc3.getEspecialidad()}</td>
                                <td>${listc3.getFecha()}</td>
                                <td>${listc3.getHora()}</td>
                                <td>${listc3.getPaciente()}</td>
                                <td>${listc3.getMedico()}</td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
            </br>
            <h2 class="text-center">Consultas realizadas con un Doctor en específico dentro de un intervalo de tiempo</h2>
            <div class="form-group">
            <form action="ControladorPacienteDB?menu=Consulta1&accion=Listar3" method="POST">
                <div class="row">
                    <div class="col">
                        <input class="form-control mr-sm-2" name="txtBuscarDoc" type="search" placeholder="Código Doctor" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="form-control mr-sm-2" name="txtBuscarFechaMenor" type="search" placeholder="Fecha Menor" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="form-control mr-sm-2" name="txtBuscarFechaMayor" type="search" placeholder="Fecha Mayor" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="btn btn-outline-dark my-2 my-sm-0" name="accion" type="submit" value="Buscar">
                    </div>
                    <div class="col">
                        <input type="hidden" class="form-control mr-sm-2" name="txtCodigoPaci" type="search" value="${codPaci}">
                    </div>
                </div>
            </form>
        </div>
            </br>
            <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código Consulta</th>
                        <th>Tipo Especialidad</th>
                        <th>Fecha Consulta</th>
                        <th>Hora Consulta</th>
                        <th>Codigo Paciente</th>
                        <th>Código Doctor</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listc4" items="${listac4}">
                            <tr>
                                <th>${listc4.getCodigo()}</th>
                                <td>${listc4.getEspecialidad()}</td>
                                <td>${listc4.getFecha()}</td>
                                <td>${listc4.getHora()}</td>
                                <td>${listc4.getPaciente()}</td>
                                <td>${listc4.getMedico()}</td>
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
