
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class conexion{
    
    Connection con;
 
   
    public Connection getConexion(){
     try{
             String bd="jdbc:mysql://localhost:3306/bd_ventas";     
             String user="root";
             String pass="";
             
             con=DriverManager.getConnection(bd,user,pass);
    return con;
    }catch (SQLException e){
    
        JOptionPane.showMessageDialog(null, e.toString());
    }
    
    return null;
    }



    
}



