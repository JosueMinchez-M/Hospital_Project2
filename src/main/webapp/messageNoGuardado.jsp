<%-- 
    Document   : messageNoGuardado
    Created on : 5/10/2020, 23:42:03
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="alert alert-danger text-center" role="alert">
            ¡Upss a ocurrido un error! No se importo el archivo
        </div>
        </br>
        </br>
        </br>
        </br>
        </br>
        </br>
        <center>
            <h1>Importar Archivo</h1>
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit"/>
            </form>
        </center>
        <div class="container mt-4 col-lg-4">
            <a type="submit" name="btn_ImportarDatos" class="btn btn-success btn_blog" href="TipoUsuario.jsp">Regresar al Inicio</a>
        </div>
    </body>
</html>
