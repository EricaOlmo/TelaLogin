package View;

import Model.Usuarios;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Erica
 */
public class TelaLogin extends JDialog{
    
    private ActionListener al;
    private JButton btnLogar, btnVoltar;
    private JTextField txtNome, txtEmail;
    private JComboBox cbStatus;
    private JPasswordField txtSenha; 

    public TelaLogin(ActionListener al) {
        super();
        this.setTitle("Login de  usuários");
        this.al = al;
        this.init();
    
        
    }

    private void init() {
        this.setLayout(new BorderLayout());
        JPanel pnControles = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.add(pnControles, BorderLayout.SOUTH);
        
        JPanel pnCampos = new JPanel(new GridLayout(0, 2));
        this.add(pnCampos, BorderLayout.CENTER);
        pnCampos.setBorder(new TitledBorder("Dados do Usuario"));
        
        btnLogar = new JButton("Logar");
        btnLogar.setActionCommand("usuario.logar");
        btnLogar.addActionListener(this.al);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setActionCommand("usuario.voltar");
        btnVoltar.addActionListener(this.al);
          
        pnControles.add(btnLogar);
        pnControles.add(btnVoltar);
        
        txtSenha = new JPasswordField();
        pnCampos.add(new JLabel("Senha"));
        pnCampos.add(txtSenha);
        
        txtNome = new JTextField();
        pnCampos.add(new JLabel("Nome"));
        pnCampos.add(txtNome);
          
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }
    
    
}
