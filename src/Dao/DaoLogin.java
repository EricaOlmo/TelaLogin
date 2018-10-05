//nome do pacote
package Dao;

//importações
import Model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author drink
 */

public class DaoLogin {

    
    private Connection conn;
  
    private static final String SELECT_ALL = "select * from tbl_cliente ";

    
    public DaoLogin(Connection cnx) {
        
        this.conn = cnx;
        
        criarTabela();
    }

    
    private void criarTabela() {
        
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ";
        sql += "( id integer primary key not null auto_increment, ";
        sql += " nome varchar(60), email varchar(20) unique, senha varchar(8),`status` ";
        sql += " char(1) not null '" + Usuarios.statusValidos[0] + "')";
        
        try {
           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    public void salvarCliente(Usuarios c) {
        String sql = "update usuarios set nome = ? , ";
        sql += " email = ?, `status` = ? where senha = ? ";
        int Senha = c.getSenha();
        String nome = c.getNome();
        String Email = c.getEmail();
        String status = c.getStatus();
        if (Senha < 1) {
            Senha = 0;
            sql = "insert into usuarios (nome, email, `status`, senha) ";
            sql += "values (?, ?, ?, ?) ";
        }
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(4, Senha);
            ps.setString(1, nome);
            ps.setString(2, Email);
            ps.setString(3, status);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void removerCliente(Usuarios c) {
        String sql = "delete from tbl_cliente where codigo = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, c.getSenha());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Usuarios> listarCliente(Usuarios c) {
        ArrayList<Usuarios> retorno = new ArrayList<>();
        String where = " where 1=1 ";
        if (c != null) {
            if (c.getSenha() > 0) {
                where += " AND senha = " + c.getSenha();
            }
            if ( c.getNome()!=null && !c.getNome().isEmpty()) {
                where += " OR nome like '" + c.getNome() + "%' ";
            }
            if ( c.getEmail()!=null && !c.getEmail().isEmpty()) {
                where += " OR email like '%" + c.getEmail() + "%' ";
            }
        }
        
        try {
            PreparedStatement ps
                    = this.conn.prepareStatement(DaoLogin.SELECT_ALL + where);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios user = new Usuarios();
                user.setSenha(rs.getInt("senha"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getString("status"));
                retorno.add(user);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }

}
