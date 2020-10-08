<%-- 
    Document   : PrincipalAdministrador
    Created on : 29/09/2020, 00:56:49
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            iframe{
            border:none;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">HOSPITAL</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Administrador<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Agregar/Modificar Servicios
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                      <a class="dropdown-item" href="Prueba?menu=ServicioConsultaDoctor&accion=Listar" target="frameAdministrador">Consultas Doctor</a>
                    <a class="dropdown-item" href="Prueba?menu=AgregarExamenLab&accion=Listar" target="frameAdministrador">Examenes Laboratorio</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Agregar/Modificar Personal y Especialidad
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="Prueba?menu=AgregarDoctor&accion=Listar" target="frameAdministrador">Doctor</a>
                    <a class="dropdown-item" href="Prueba?menu=AgregarEspecialidad&accion=Listar" target="frameAdministrador">Especialidad Doctor</a>
                    <a class="dropdown-item" href="Prueba?menu=AgregarLaboratorista&accion=Listar" target="frameAdministrador">Laboratorista</a>
                    <a class="dropdown-item" href="Prueba?menu=AgregarPaciente&accion=Listar" target="frameAdministrador">Paciente</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Consultas
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                      <form action ="ControladorAdimDB?menu=Consulta1&accion=Listar" method="POST">
                          <input type="hidden" value="<%out.println(request.getAttribute("codigoAdmin"));%>" name="txtCodigotx" class="form-control" readonly>
                          <input type="submit" class="dropdown-item" name="accion" formtarget="frameAdministrador" value="Los 10 médicos que más informes han realizado dentro de un intervalo de tiempo">
                          <input type="submit" class="dropdown-item" name="accion" formtarget="frameAdministrador" formaction="ControladorLaboratoristaDB?menu=Consulta2&accion=Listar" value="Exámenes realizados en el día">
                          <input type="submit" class="dropdown-item" name="accion" formtarget="frameAdministrador" formaction="ControladorMedicoDB?menu=Consulta3&accion=Listar" value="Falta Reporte/Consulta">
                          <input type="submit" class="dropdown-item" name="accion" formtarget="frameAdministrador" formaction="ControladorMedicoDB?menu=Consulta4&accion=Listar" value="Falta Reporte/Consulta">
                      </form>
                  </div>
                </li>
              </ul>
            </div>
            <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%out.println(request.getAttribute("nombreAdmin"));%>
            </button>
            <div class="dropdown-menu text-center">
                <a class="dropdown-item" href="#">
                    <img src="imagenes/Administrador.png" alt="50" width ="50"/>
                </a>
              <a class="dropdown-item" href="#">Administrador</a>
              <a class="dropdown-item" href="#"><%out.println(request.getAttribute("codigoAdmin"));%></a>
              <div>
                  <form action ="ValidarAdministrador" method="POST">
                      <a name="accion" value ="Salir" class="dropdown-item" href="TipoUsuario.jsp">Salir</a>
                  </form>
              </div>
            </div>
          </div>
        </nav>
              <div class="m-4" style="height: 550px">
                  <iframe name="frameAdministrador" style="height: 100%; width: 100%"></iframe>
              </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
