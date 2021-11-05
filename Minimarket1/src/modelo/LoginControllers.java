
package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.VendedorDAO;
import modelo.EntidadVendedor;
import vista.Principal;
import vista.loginfrom;

public class LoginControllers implements ActionListener {
    
    private EntidadVendedor ev;
    private VendedorDAO evDAO;
    private loginfrom vista;
    
    public LoginControllers(EntidadVendedor ev,VendedorDAO evDAO,loginfrom vista){
    
    this.ev=ev;
    this.evDAO=evDAO;
    this.vista=vista;
    this.vista.btnLogin.addActionListener(this);
   
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnLogin){
        
        if(vista.txtUser.getText().equals(" ") || String.valueOf(vista.txtPass.getPassword()).equals("")){
        
            JOptionPane.showMessageDialog(null,"Campos vacios");
        }else{
        
            String usuario=vista.txtUser.getText();
            String clave=String.valueOf(vista.txtPass.getPassword());
            ev=evDAO.Login(usuario, clave);
            if(ev.getUser()!=null){
                Principal p = new Principal();
                p.setVisible(true);
                 this.vista.dispose();
                
            }
        }
        
        }else{
        
        }
      
    }
    
    }
