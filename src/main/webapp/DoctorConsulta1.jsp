<%-- 
    Document   : DoctorConsulta1
    Created on : 8/10/2020, 00:26:01
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
        <h2 class="text-center"> Historial médico de los pacientes que estén dentro del portal</h2>
            <div class="form-group">
            <form action="ControladorMedicoDB?menu=Consulta1&accion=BuscarListar" method="POST">
                <div class="row">
                    <div class="col">
                        <input class="form-control mr-sm-2" name="txtBuscarCodigoPaciente" type="search" placeholder="Codigo Paciente" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="btn btn-outline-dark my-2 my-sm-0" name="accion" type="submit" value="Buscar">
                    </div>
                    <div class="col">
                        <input class="form-control mr-sm-2" value="${codDoc}" name="txtCodPacieConsulta1" type="hidden"aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="btn btn-outline-dark my-2 my-sm-0" name="accion" type="hidden" value="Buscar">
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
                        <c:forEach var="listaDocConsut1" items="${listaBuscConsulta1}">
                            <tr>
                                <th>${listaDocConsut1.getCodigo()}</th>
                                <td>${listaDocConsut1.getEspecialidad()}</td>
                                <td>${listaDocConsut1.getFecha()}</td>
                                <td>${listaDocConsut1.getHora()}</td>
                                <td>${listaDocConsut1.getPaciente()}</td>
                                <td>${listaDocConsut1.getMedico()}</td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
            </br>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
