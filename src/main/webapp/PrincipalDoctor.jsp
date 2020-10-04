<%-- 
    Document   : PrincipalDoctor
    Created on : 28/09/2020, 23:59:54
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
                  <a class="nav-link" href="#">Doctor<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Informe
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                      <form action ="ControladorMedicoDB?menu=InformeMedico&accion=MandarCodigo" method="POST">
                      <input type="hidden" value="<%out.println(request.getAttribute("codigoDoctor"));%>" name="txtCodigotx" class="form-control">
                      <input type="submit" class="dropdown-item" name="accion" formtarget="frameDoctor" value="Redactar">
                      </form>
                  </div>
                </li>
              </ul>
            </div>
            <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%out.println(request.getAttribute("nombreDoctor"));%>
            </button>
            <div class="dropdown-menu text-center">
                <a class="dropdown-item" href="#">
                    <img src="imagenes/Doctor.jpg" alt="50" width="50"/>
                </a>
              <a class="dropdown-item" href="#">Doctor</a>
              <a class="dropdown-item" href="#"><%out.println(request.getAttribute("codigoDoctor"));%></a>
              <div>
                  <form action ="ValidarMedico" method="POST">
                      <a name="accion" value ="Salir" class="dropdown-item" href="LoginMedico.jsp">Salir</a>
                  </form>
              </div>
            </div>
          </div>
        </nav>
              <div class="m-4" style="height: 550px">
                  <iframe name="frameDoctor" style="height: 100%; width: 100%"></iframe>
              </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
