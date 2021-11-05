
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class VendedorDAO {
    
    PreparedStatement ps;
    ResultSet rs;
   
    conexion con=new conexion();
    Connection acceso;
    
   public EntidadVendedor Login(String user,String dni){
      EntidadVendedor ev =new EntidadVendedor();
       String sql="select * from vendedor where user=? and dni=?";
   try{
   
     acceso=con.getConexion();
     ps=acceso.prepareStatement(sql);
     ps.setString(1, user);
     ps.setString(2, dni);
     rs=ps.executeQuery();
     if(rs.next()){
         
         
         
         ev.setId(rs.getInt(1));
         ev.setDni(rs.getString(2));
         ev.setNom(rs.getString(3));
         ev.setTel(rs.getString(4));
         ev.setEstado(rs.getString(5));
         ev.setUser(rs.getString(6));
         
     }
   }catch (SQLException e){
       JOptionPane.showMessageDialog(null,e.toString());
   }
  
   return ev;
   }
}
