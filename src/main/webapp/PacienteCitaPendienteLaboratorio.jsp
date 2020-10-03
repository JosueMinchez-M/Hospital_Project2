<%-- 
    Document   : CItaPendienteLaboratorio
    Created on : 29/09/2020, 15:45:30
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
                height: 400px;
                overflow-y: scroll;
            }
        </style>
    </head>
    <body>
        <h1 class="text-center">Cistas Pendientes Laboratorio</h1>
        <!--<div class="form-group">
            <form>
                <div class="row">
                    <div class="col">
                        <input class="form-control mr-sm-2" style="width: 700px; height: 40px" name="txtBuscarFechaCitPendLab" type="search" placeholder="Ingresa Hasta que fecha quieres ver tus citas: (0000-00-00)" aria-label="Search">
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Buscar</button>
                    </div>
                </div>
            </form>
        </div>/-->
        </br>
        <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Codigo Tipo Examen</th>
                        <th>Fecha Cita</th>
                        <th>Hora Cita</th>
                        <th>Codigo Paciente</th>
                        <th>Codigo Laboratorista</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listPendCita" items="${listaCitaPendiente}">
                            <tr>
                                <th>${listPendCita.getCodigo()}</th>
                                <td>${listPendCita.getCodigoExamen()}</td>
                                <td>${listPendCita.getFechaCitaLab()}</td>
                                <td>${listPendCita.getHoraEstablecida()}</td>
                                <td>${listPendCita.getCodigoPaciente()}</td>
                                <td>${listPendCita.getCodigoLaboratorista()}</td>
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
