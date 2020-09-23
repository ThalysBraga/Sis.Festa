
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author yasmini
 */
public class Conexao {
 private static final String url = "jdbc:mysql://localhost/banco_projeto_ds";
    private static final String user = "root";
    private static final String senha = "root";
    
    public static Connection conectar (){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        }catch (Exception ex){
        JOptionPane.showMessageDialog(null, "Erro ao conectar");
    }
        return con;
    }
}
