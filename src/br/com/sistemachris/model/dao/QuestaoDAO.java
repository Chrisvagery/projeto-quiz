
package br.com.sistemachris.model.dao;
import br.com.sistemachris.model.dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import br.com.sistemachris.model.vo.Questao;

public class QuestaoDAO {
    
    private Connection con;
    
    public QuestaoDAO(){
        this.con = Conexao.conectar();
        
        
    }
     public ArrayList<Questao> consultarQuestoes(String facil, String saude){        
        Statement resultado = null;
        ResultSet rs = null;
        ArrayList<Questao> questoes = new ArrayList<>();            
        
        try{
            resultado = con.createStatement();
            rs = resultado.executeQuery("Select * from questao where nivel='facil' and tema=' saude'");
                                                     
            while(rs.next()){
                Questao questao = new Questao();
                questao.setIdquestao(rs.getInt("idquestao"));
                questao.setNomeQuestao(rs.getString("nomeQuestao"));
                questao.setA(rs.getString("A"));
                questao.setB(rs.getString("B"));
                questao.setC(rs.getString("C"));
                questao.setD(rs.getString("D"));
                questao.setNivel(rs.getString("nivel"));
                questao.setTema(rs.getString("tema"));
                questao.setResposta(rs.getString("resposta"));
                               
                questoes.add(questao);
            }                  
            resultado.close();
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return questoes;
    }
     
     public ArrayList<Questao> consultarQuestoesAleatorios(int quant){        
        Statement resultado = null;
        ResultSet rs = null;
        ArrayList<Questao> questoes = new ArrayList<>();            
        
        try{
            resultado = con.createStatement();
            rs = resultado.executeQuery("Select * from questao where nivel ='intermediario' and tema = 'programacao' order by rand() limit 0," + quant);
                                                     
            while(rs.next()){
                Questao questao = new Questao();
                questao.setIdquestao(rs.getInt("idquestao"));
                questao.setNomeQuestao(rs.getString("nomeQuestao"));
                questao.setA(rs.getString("A"));
                questao.setB(rs.getString("B"));
                questao.setC(rs.getString("C"));
                questao.setD(rs.getString("D"));
                questao.setNivel(rs.getString("nivel"));
                questao.setTema(rs.getString("tema"));
                questao.setResposta(rs.getString("resposta"));
                               
                questoes.add(questao);
            }                  
            resultado.close();
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return questoes;
    }
    
     
}

