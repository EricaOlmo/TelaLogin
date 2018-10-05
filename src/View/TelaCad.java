package View;

import Controller.UserController;
import Model.Usuarios;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Erica
 */
public class TelaCad extends JFrame {
    
    private JTable tabela;
    private JButton btnListar;
    private JButton btnNovo;
    private JButton btnEditar;
    private JButton btnRemover;
    private JTextField txtPesquisa;
    private ActionListener al;

    public TelaCad(ActionListener al) throws HeadlessException{
            super("Cadastrar Usuarios");
            this.al = al;
            this.init();
    }

    public TelaCad(UserController aThis, Usuarios c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void init() {
        setLayout(new BorderLayout());
        JPanel pnControles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.add(pnControles, BorderLayout.NORTH);
        this.tabela = new JTable();
        JScrollPane scroll = new JScrollPane(this.tabela);
        this.add(scroll, BorderLayout.CENTER);
        
        btnListar = new JButton("Listar");
        btnListar.setActionCommand("usuario.listar");
        btnListar.addActionListener(al);

        btnEditar = new JButton("Editar");
        btnEditar.setActionCommand("usuario.editar");
        btnEditar.addActionListener(al);

        btnNovo = new JButton("Novo");
        btnNovo.setActionCommand("usuario.novo");
        btnNovo.addActionListener(al);

        btnRemover = new JButton("Remover");
        btnRemover.setActionCommand("usuario.remover");
        btnRemover.addActionListener(al);

        txtPesquisa = new JTextField();
        txtPesquisa.setPreferredSize(new Dimension(150, 30));

        pnControles.add(new JLabel("Filtro: "));
        pnControles.add(txtPesquisa);
        pnControles.add(btnListar);
        pnControles.add(btnNovo);
        pnControles.add(btnEditar);
        pnControles.add(btnRemover);

        //empacota tudo
        this.pack();
        //centraliza
        this.setLocationRelativeTo(null);
    }

    public void setModal(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
