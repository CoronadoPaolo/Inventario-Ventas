
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class ClienteDAO{
    
    
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public List listarCliente(){
        List<Cliente>ListaCl = new ArrayList();
        String sql="select* from clientes";
        try{
         con=cn.getConexion();
         ps=con.prepareStatement(sql);
         rs= ps.executeQuery();
         
         while(rs.next()) {
         
             Cliente cl=new Cliente();
             cl.setId(rs.getInt("Id"));
             cl.setDni(rs.getString("Dni"));
             cl.setNom(rs.getString("Nombre"));
             cl.setDir(rs.getString("Direccion"));
             cl.setEstado(rs.getString("Estado"));
             ListaCl.add(cl);
          
         }
        
        }catch (SQLException e){
            System.out.println(e.toString());
            
        }
        return ListaCl;
    }


    public int add(Object[] o) {
       
        int r=0;
        String sql="insert into cliente(dni,nombres,direccion,estado)values(?,?,?,?)";
       try{
         con=cn.getConexion();
         ps=con.prepareStatement(sql);
         ps.setObject(1,o[0]);
         ps.setObject(2,o[1]);
         ps.setObject(3,o[2]);
         ps.setObject(4,o[3]);
         ps.executeUpdate();
      
        }catch (Exception e){
            
        }
        return r;
    }
  
    public int actualizar(Object[] o) {
        int r=0;
       String sql="update cliente set Dni=?,nombres=?,Direccion=?,Estado=? where idCliente=?";
     try{
         con=cn.getConexion();
         ps=con.prepareStatement(sql);
         ps.setObject(1,o[0]);
         ps.setObject(2,o[1]);
         ps.setObject(3,o[2]);
         ps.setObject(4,o[3]);
         ps.setObject(5,o[4]);
         ps.executeUpdate();
      
        }catch (Exception e){
            
        }
        return r;
    }
 
    public void eliminar(int id) {
        String sql="delete from cliente where idCliente=?";
    try{
         con=cn.getConexion();
         ps=con.prepareStatement(sql);
         ps.setInt(1, id);
         ps.executeUpdate();
      
        }catch (Exception e){
            
        }
    }
}
