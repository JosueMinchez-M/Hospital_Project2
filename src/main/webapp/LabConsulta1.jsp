<%-- 
    Document   : LabConsulta1
    Created on : 8/10/2020, 04:02:24
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
        <h2 class="text-center">Exámenes a realizarse en su turno del día</h2>
        <br>
        <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código Cita</th>
                        <th>Tipo Examen</th>
                        <th>Fecha Cita</th>
                        <th>Hora Cita</th>
                        <th>Código Paciente</th>
                        <th>Código Laboratorista</th>
                        <th>Código Doctor</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listaDocConsut" items="${listLab}">
                            <tr>
                                <th>${listaDocConsut.getCodigo()}</th>
                                <td>${listaDocConsut.getCodigoExamen()}</td>
                                <td>${listaDocConsut.getFechaCitaLab()}</td>
                                <td>${listaDocConsut.getHoraEstablecida()}</td>
                                <td>${listaDocConsut.getCodigoPaciente()}</td>
                                <td>${listaDocConsut.getCodigoLaboratorista()}</td>
                                <td>${listaDocConsut.getCodigoMedico()}</td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>
