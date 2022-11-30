
 
package br.com.sistemachris.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Conexao {
    
    public static Connection con = null;
    public static String status;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/sistemachris";
    private static final String usuario = "root";
    private static final String senha = "Cv3839";
    
    public static Connection conectar(){
    
    con = null;
        
    
    
    try {
        Class.forName(driver);
    }catch(ClassNotFoundException erro){
        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,erro);
    }
    
    
    try {
        con = DriverManager.getConnection(url,usuario,senha);
        status = "Conectao com sucesso";
        return con;
    }catch(SQLException erro){
        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            status = ("STATUS:" + erro.getMessage());
            return con;
    }
    }
    
     public static boolean fecharConexao(){
        
         try {
            //fecha a conexao
            Conexao.conectar().close();
            return true;
        } catch (SQLException erro) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            return false;
        }
    
    }
            
    
}
