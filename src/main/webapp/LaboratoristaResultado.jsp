<%-- 
    Document   : LaboratoristaResultado
    Created on : 4/10/2020, 13:01:11
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
                Resultado Registrado Correctamente
            </div>
        </c:if>
        <c:if test="${numAgregado eq 2}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss, a ocurrido un Error! No se Registro el Resultado
            </div>
        </c:if>
        <c:if test="${numBuscVacio eq 3}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss! El campo ingrese codigo esta vacío
            </div>
        </c:if>
        <c:if test="${numVacioConsulta eq 5}">
            <div class="alert alert-danger text-center" role="alert">
                ¡Upss! Algun campo se Encuentra Vacío
            </div>
        </c:if>
        <h1 class="text-center">Buscador de Citas Examenes</h1>
        <div class="form-group">
            <form action="ControladorLaboratoristaDB?menu=ResultadoLab&accion=ListarBusqueda" method="POST">
                <div class="row">
                    <div class="col">
                        <input class="form-control mr-sm-2" style="width: 700px; height: 40px" name="txtBuscarCodigo" type="search" placeholder="Ingrese el Código de la Cita" aria-label="Search">
                    </div>
                    <div class="col">
                        <input class="btn btn-outline-dark my-2 my-sm-0" name="accion" type="submit" value="Buscar">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control mr-sm-2" name="txtCodigoLab" type="search" value="${codLab}">
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
                        <th>Tipo Examen</th>
                        <th>Fecha Cita</th>
                        <th>Hora Cita</th>
                        <th>Codigo Paciente</th>
                        <th>Codigo Laboratorista</th>
                        <th>Codigo Doctor</th>
                        <th>Accion</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="listCitaLab" items="${listaCitaLab}">
                            <tr>
                                <th>${listCitaLab.getCodigo()}</th>
                                <td>${listCitaLab.getCodigoExamen()}</td>
                                <td>${listCitaLab.getFechaCitaLab()}</td>
                                <td>${listCitaLab.getHoraEstablecida()}</td>
                                <td>${listCitaLab.getCodigoPaciente()}</td>
                                <td>${listCitaLab.getCodigoLaboratorista()}</td>
                                <td>${listCitaLab.getCodigoMedico()}</td>
                                <td>
                                    <form class="input-group" action="ControladorLaboratoristaDB?menu=ResultadoLab&accion=Editar&id=${listCitaLab.getCodigo()}" method="POST">
                                        <input type="hidden" name="txtCodTabla" value="${codLab}" class="form-control">
                                        <input type="submit" class="btn btn-warning" name="accion" value="Editar">
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
                <h2 class="text-center">Llenar Informacion Resultado del Examen</h2>
                <div>
                    <form action="ControladorLaboratoristaDB?menu=ResultadoLab&accion=AgregarResultado" method="POST">
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" name="txtOrdenRes" class="form-control" placeholder="Orden">
                          </div>
                          <div class="col">
                              <input type="text" name="txtInfoRes" class="form-control" placeholder="Informe">
                          </div>
                          <div class="col">
                            <input type="text" name="txtFechaRes" value="${editarCitaLab.getFechaCitaLab()}" class="form-control" placeholder="Fecha Cita">
                          </div>
                          <div class="col">
                              <input type="text" name="txtCodPacienteRes" value="${editarCitaLab.getCodigoPaciente()}" class="form-control" placeholder="Código Paciente">
                          </div>
                          <div class="col">
                              <input type="text" name="txtCodDoctorRes" value="${editarCitaLab.getCodigoMedico()}" class="form-control" placeholder="Código Doctor(Opcional)">
                          </div>
                        </div>
                          </br>
                          <div class="row">
                          <div class="col">
                            <input type="text" name="txtCodExamenRes" value="${editarCitaLab.getCodigoExamen()}" class="form-control" placeholder="Código Examen">
                          </div>
                          <div class="col">
                              <input type="text" name="txtCodLabRes" value="${codLab}" class="form-control" placeholder="Código Laboratorista" readonly>
                          </div>
                          <div class="col">
                              <input type="text" name="txtHoraRes" value="${editarCitaLab.getHoraEstablecida()}" class="form-control" placeholder="Hora (00:00)" >
                          </div>
                          <div class="col">
                              <input type="submit" class="btn btn-primary" name="accion" value="Registrar Resultado">
                          </div>
                          <div class="col">
                            <input type="hidden" class="btn btn-primary" name="accion" >
                          </div>
                        </div>
                        </br>
                        </br>
                    </form>
                </div>
            </div>
            </br>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
