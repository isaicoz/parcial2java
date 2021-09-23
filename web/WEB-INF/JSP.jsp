<%-- 
    Document   : JSP
    Created on : 22 sep. 2021, 13:56:09
    Author     : adalb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#2E35A4">
        <h1>Productos</h1>
        <form action="producto" method="GET">
            <table>
                <tr>
                    <td>Id Producto:</td><td><input id="codigo" name="codigo" type="number"></td><td></td>
                </tr>
                 <tr>
                    <td>Producto:</td><td><input id="producto" name="producto" type="text"></td><td></td>
                </tr> 
                <tr>
                    <td>Id Marca:</td><td><input id="marca" name="marca" type="text"></td><td><input id="boton" name="boton" type="submit" value="marca" > </td><td></td>
                </tr> 
                <tr>
                    <td>Descripcion:</td><td><input id="descripcion" name="descripcion" type="text"></td><td></td>
                </tr> 
                <tr>
                    <td>Precio Costo:</td><td><input id="costo" name="costo" type="number"></td><td></td>
                </tr>
                <tr>
                    <td>Precio Venta:</td><td><input id="venta" name="venta" type="number"></td><td></td>
                </tr>
                 <tr>
                    <td>Existencia:</td><td><input id="existencia" name="esistencia" type="text"></td><td></td>
                </tr>
                <tr>
                    <td><input id="boton"name="boton"type="submit"value="agregar producto"></td><td></td>
                </tr>
            
            </table> 
            
        </form>
    </body>
</html>
