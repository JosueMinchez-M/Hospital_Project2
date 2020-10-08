<%-- 
    Document   : PacienteHistorialMedico
    Created on : 29/09/2020, 15:45:52
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
                height: 350px;
                overflow-y: scroll;
            }
        </style>
    </head>
    <body>
        <h1 class="text-center">Historial Médico</h1>
        </br>
        <h2 class="text-center">Consultas Realizadas con el Doctor</h2>
        </br>
        <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Tipo Consulta</th>
                        <th>Fecha Consulta</th>
                        <th>Hora Consulta</th>
                        <th>Codigo Paciente</th>
                        <th>Codigo Doctor</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listPendCita" items="${listaCitaPendiente}">
                            <tr>
                                <th>${listPendCita.getCodigo()}</th>
                                <td>${listPendCita.getEspecialidad()}</td>
                                <td>${listPendCita.getFecha()}</td>
                                <td>${listPendCita.getHora()}</td>
                                <td>${listPendCita.getPaciente()}</td>
                                <td>${listPendCita.getMedico()}</td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
            </br>
            <h2 class="text-center">Citas Realizadas en el Laboratorio</h2>
            </br>
            <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Código Tipo Examen</th>
                        <th>Fecha Cita</th>
                        <th>Hora Cita</th>
                        <th>Código Paciente</th>
                        <th>Código Laboratorista</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listRealidadaCita" items="${listaCitaPendienteLab}">
                            <tr>
                                <th>${listRealidadaCita.getCodigo()}</th>
                                <td>${listRealidadaCita.getCodigoExamen()}</td>
                                <td>${listRealidadaCita.getFechaCitaLab()}</td>
                                <td>${listRealidadaCita.getHoraEstablecida()}</td>
                                <td>${listRealidadaCita.getCodigoPaciente()}</td>
                                <td>${listRealidadaCita.getCodigoLaboratorista()}</td>
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
