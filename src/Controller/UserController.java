package Controller;

import Dao.DaoLogin;
import Model.Usuarios;
import Services.Conexao;
import View.TelaCad;
import View.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Erica
 */
public class UserController implements ActionListener{
    
    private TelaLogin telaLogin;
    private TelaCad edicao;
    private DaoLogin dl;

    public UserController(Connection conn) {
        dl = new DaoLogin(conn);
        this.telaLogin = new TelaLogin(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "usuario.logar":
                autenticar();
                break;       
            case "usuario.voltar":
                System.exit(0);
                break;
            
        }
    }
    
    
     

    private void logar() {
        
     this.telaLogin.setVisible(true);
    }

    private void autenticar() {
       // puxar do dao q vai ter o construtor com a comparacao no banco e login e aqui mostrar a resposta.
    }
    
    
}