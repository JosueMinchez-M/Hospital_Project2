<%-- 
    Document   : AdminCrearNuevaConsulta
    Created on : 29/09/2020, 17:00:50
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
                width:1000px; 
            } 
        </style>
    </head>
    <body>
        <c:if test="${numAgregado eq 1}">
            <div class="alert alert-success text-center" role="alert">
                Consulta Registrada Correctamente
            </div>
        </c:if>
        <c:if test="${numAgregado eq 2}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss, a ocurrido un Error! No se Registro la Consulta
            </div>
        </c:if>
        <c:if test="${numActuConsulta eq 3}">
            <div class="alert alert-success text-center" role="alert">
                Consulta Actualizada Correctamente
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
            <div>
                <h2 class="text-center">Agregar/Modificar Consulta Doctor</h2>
                </br>
                <div>
                    <form action="Prueba?menu=ServicioConsultaDoctor&accion=Agregar" method="POST">
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${editarConsulta.getTipo()}" name="txtTipoConsulta" class="form-control" placeholder="Tipo de Consulta">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarConsulta.getCosto()}" name="txtCostoConsulta" class="form-control" placeholder="Costo">
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar" formaction="Prueba?menu=ServicioConsultaDoctor&accion=Actualizar">
                          </div>
                        </div>
                        </br>
                        </br>
                    </form>
                </div>
                <h3 class="text-center">Consultas de Doctor Existentes</h3>
            </div>
            <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Tipo de Consulta</th>
                        <th>Costo en Quetzales</th>
                        <th>Accion</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="consulta" items="${listaConsulta}">
                            <tr>
                                <th>${consulta.getTipo()}</th>
                                <td>${consulta.getCosto()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Prueba?menu=ServicioConsultaDoctor&accion=Editar&id=${consulta.getTipo()}">Editar</a>
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
