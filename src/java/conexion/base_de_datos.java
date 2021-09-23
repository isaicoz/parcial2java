/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import objetos.productos;

public class base_de_datos {
    public Connection coneccionBD;
    private final String Puerto="3306";
    private final String bd ="parcial";
    private final String urlConeccion = String.format("jdbc:mysql://localhost:%s/%s",Puerto, bd);
    private final String usuario ="root";
    private final String contra = "53370234";
    private final String jdbc ="com.mysql.cj.jdbc.Driver";
    public void abrir_coneccion(){
        try{
        Class.forName(jdbc);
        coneccionBD =DriverManager.getConnection(urlConeccion,usuario,contra);
        JOptionPane.showMessageDialog(null,"conexion Exitosa","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        
        }catch(HeadlessException | ClassNotFoundException | SQLException ex){
            System.out.println("Error:"+ ex.getMessage());
    }
    }
    public void insertar(productos productos){
        try{
            Statement sentenciamysql=this.coneccionBD.createStatement();
            String insertproducto="INSERT INTO `productos`, `id_productos`,`Producto`,`id_marcas`, `Descripcion`,`Precio_costo`,`Precio_venta`,`Existencia`\n" 
            + " VALUES (id_productos.nextval, '"+productos.getIdproductos()+"' ,'"+productos.getProducto()+"' , '"+productos.getIdmarca()+"' , '"+productos.getDescripcion()+"' ,'"+productos.getPreciocosto()+"' ,'"+productos.getPrecioventa()+"' , '"+productos.getExistencia()+"')";
            sentenciamysql.executeUpdate(insertproducto);
        } catch(HeadlessException | SQLException ex){
            System.out.print(ex);
        }
    }
    public void cerrar_coneccion(){
        try{
        coneccionBD.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ ex.getMessage());
    }
    }
    
    public static void main(String[] argumentos){
          base_de_datos connecion = new base_de_datos();
            connecion.abrir_coneccion();
            
        productos productos = new productos();
            productos.setIdproductos("1");
            productos.setProducto("memorias ram");
            productos.setIdmarca("1");
            productos.setDescripcion("kit 2*8");
            productos.setPreciocosto("650");
            productos.setPrecioventa("900");
            productos.setExistencia("5");
            connecion.insertar(productos);
            
        connecion.cerrar_coneccion();        
    }
}
