<%-- 
    Document   : GraficaImportar
    Created on : 5/10/2020, 03:28:10
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Importar Archivo</title>
    </head>
    <body>
        <center>
            <h1>Importar Archivo</h1>
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit"/>
            </form>
        </center>
    </body>
</html>
