<%-- 
    Document   : AdminAgregarLaboratorista
    Created on : 29/09/2020, 16:45:20
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
            <div>
                <h2 class="text-center">Agregar Laboratorista</h2>
                <div>
                    <form action="Prueba?menu=AgregarLaboratorista&accion=Agregar" method="POST">
                        <div class="row">
                          <div class="col">
                              <input type="text" value="${editarLaboratorista.getCodigo()}" name="txtCodigoLab" class="form-control" placeholder="Código">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarLaboratorista.getNombre()}" name="txtNombreLab" class="form-control" placeholder="Nombre">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarLaboratorista.getNumero_registro()}" name="txtNoRegistroLab" class="form-control" placeholder="No. Registro MS">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarLaboratorista.getDpi()}" name="txtDpiLab" class="form-control" placeholder="Dpi">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="text" value="${editarLaboratorista.getTelefono()}" name="txtTelLab" class="form-control" placeholder="Telefono">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarLaboratorista.getExamen_realizar()}" name="txtTipoExamenLab" class="form-control" placeholder="Tipo Examen">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarLaboratorista.getCorreo()}" name="txtCorreoLab" class="form-control" placeholder="Correo Electronico">
                          </div>
                          <div class="col">
                            <input type="text" value="${editarLaboratorista.getFecha_trabajar()}" name="txtITLab" class="form-control" placeholder="Fecha Inicio Trabajo">
                          </div>
                        </div>
                        </br>
                        <div class="row">
                          <div class="col">
                            <input type="password" value="${editarLaboratorista.getPassword()}" name="txtPassLab" class="form-control" placeholder="Contraseña">
                          </div>
                          <div class="col">
                            <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                          </div>
                          <div class="col">
                              <input type="submit" class="btn btn-success" name="accion" value="Actualizar" formaction="Prueba?menu=AgregarLaboratorista&accion=Actualizar">
                          </div>
                          <div class="col">
                              <input type="hidden" name="espacio" class="form-control" placeholder="Espacio">
                          </div>
                        </div>
                        </br>
                    </form>
                </div>
                <h3 class="text-center">Laboratoristas Existentes</h3>
            </div>
            <div class="scrollableTabla">

                <table class="table table-bordered table-striped mb-0">
                  <thead class="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>No. Registro MS</th>
                        <th>Dpi</th>
                        <th>Teléfono</th>
                        <th>Tipo Examen</th>
                        <th>Correo Electronico</th>
                        <th>Fecha Inicio Trabajo</th>
                        <th>Contraseña</th>
                        <th>Accion</th>
                    </tr>
                  </thead>
                    <tbody>
                        <c:forEach var="lab" items="${listaLaboratorista}">
                            <tr>
                                <th>${lab.getCodigo()}</th>
                                <td>${lab.getNombre()}</td>
                                <td>${lab.getNumero_registro()}</td>
                                <td>${lab.getDpi()}</td>
                                <td>${lab.getTelefono()}</td>
                                <td>${lab.getExamen_realizar()}</td>
                                <td>${lab.getCorreo()}</td>
                                <td>${lab.getFecha_trabajar()}</td>
                                <td>${lab.getPassword()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Prueba?menu=AgregarLaboratorista&accion=Editar&id=${lab.getCodigo()}">Editar</a>
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
