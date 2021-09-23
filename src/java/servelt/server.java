/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelt;

import conexion.base_de_datos;
import objetos.productos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adalb
 */
@WebServlet(name="Productos", urlPatterns = {"http://localhost:8083/parcialprogra/Productos"})
public class server extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
           String idproductos = request.getParameter("codigo");
            String producto = request.getParameter("producto");
            String idmarca = request.getParameter("marca");
            String descripcion =request.getParameter("descripcion");
            String preciocosto = request.getParameter("costo");
            String precioventa = request.getParameter("venta");
            String existencia = request.getParameter("existencia");
            
            productos productos = new productos();
            productos.setIdproductos(idproductos);
            productos.setProducto(producto);
            productos.setIdmarca(idmarca);
            productos.setDescripcion(descripcion);
            productos.setPreciocosto(preciocosto);
            productos.setPrecioventa(precioventa);
            productos.setExistencia(existencia);
            
            base_de_datos connecion = new base_de_datos();
            connecion.abrir_coneccion();
            connecion.insertar(productos);
            
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado de Productos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado de Productos</h1>");
            out.println("<table border=1>");
            out.println("<tr>");
            out.println("<td>idproductos</td><td>producto</td><td>idmarca</td><td>descripcion</td><td>preciocosto</td><td>precioventa</td><td>existencia</td>");
                
        
        connecion.cerrar_coneccion();
        
            out.println("</tr>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}