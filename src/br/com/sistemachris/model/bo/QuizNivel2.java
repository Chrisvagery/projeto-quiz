
package br.com.sistemachris.model.bo;
import br.com.sistemachris.model.vo.Jogador;
import br.com.sistemachris.model.vo.Questao;
import br.com.sistemachris.model.dao.QuestaoDAO;
import br.com.sistemachris.model.dao.Conexao;
import java.util.ArrayList;
import java.sql.Statement;
import static br.com.sistemachris.model.dao.Conexao.conectar;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static br.com.sistemachris.model.dao.Conexao.con;
import static br.com.sistemachris.model.dao.Conexao.fecharConexao;
import static br.com.sistemachris.model.dao.Conexao.status;

public class QuizNivel2 {
    
    private int pontos;
    private Jogador chris;
    String nome;
    private int totalAcerto;
    
    public QuizNivel2(){
        
    }
    public QuizNivel2(Jogador chris){
        this.chris = chris;
    }
    public void responder (){
        Statement resultado = null;
        ResultSet rs = null;
        ArrayList<Questao> questoes = new ArrayList<>(); 
        QuestaoDAO questaoDAO = new QuestaoDAO();
        
        
        try{
            
            Scanner dado = new Scanner(System.in);
            
            conectar();
            this.pontos = 0;
            this.totalAcerto = 0;
            
            
            System.out.println("Qual o nível que vc quer jogar?");
            System.out.println("1 - Fácil");
            System.out.println("2 - Intermediário");
            System.out.println("3 - Difícil");
            System.out.print("Opção: ");
            int opcao = dado.nextInt();
            String nivel = "";
            if (opcao == 1)
                nivel = "facil";
            else
            if (opcao == 2)
                nivel = "intermediario";
            else
            if (opcao == 3)
                nivel = "dificil";
            
            System.out.println("Escolha o tema!");
            System.out.println("1 - Programação");
            System.out.println("2 - Conhecimentos gerais");
            System.out.println("3 - Saúde");
            System.out.print("Opção: ");
            //Montar o menu
            String tema="";
            
            opcao = dado.nextInt();
            
            //ifs
            if(opcao == 1)
                tema = "programacao";
            else
                if(opcao == 2)
                    tema = "conhecimentosg";
            else
                    if(opcao == 3)
                        tema = "saude";
                
            
                 
        
        
            resultado = con.createStatement();
            rs = resultado.executeQuery("Select * from questao where nivel = 'dificil' and tema = 'saude' order by rand() limit 0," );
                                                     
            while(rs.next()){
               // ArrayList<Questao> questoes = questaoDAO.consultarQuestoesAleatorios();
                Questao questao = new Questao();
                questao.setIdquestao(rs.getInt("idquestao"));
                questao.setNomeQuestao(rs.getString("nomeQuestao"));
                questao.setA(rs.getString("A"));
                questao.setB(rs.getString("B"));
                questao.setC(rs.getString("C"));
                questao.setD(rs.getString("D"));
               // questao.setNivel(rs.getString("nivel"));
               // questao.setTema(rs.getString("tema"));
               // questao.setResposta(rs.getString("resposta"));
         
                questoes.add(questao);
               
               String resposta;
               resposta = dado.next();
               
               if(resposta.equalsIgnoreCase(rs.getString("resposta"))){
                   this.pontos += 1;
                   this.totalAcerto += 1;
                   System.out.println("Acertou");
               }else{
                   this.pontos += 0;
                   this.totalAcerto += 0;
                   System.out.println("Voce errou");
               }
               System.out.println("");
           }
            resultado.close();
            rs.close();
            
       
        }catch(SQLException erro){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            status = ("STATUS:" + erro.getMessage());
            
        }
        
        
        
    }
    public void exibirPontuacao (){
      System.out.println("Parabens " + this.chris.getNome()  +" seu total de pontos é: " + this.pontos + "," + " seu total de acertos sao: " + this.totalAcerto );
  
  }
  
  public void salvarPontuacao (){
    try{
      conectar();
      String query = "insert into quiz (nomeJogador, pontuacao) values ( '" + this.chris.getNome() +  "'," +  this.pontos + " )";
      
      PreparedStatement insert = con.prepareStatement(query);
      
      insert.execute();
    
    
      fecharConexao();
    }catch(SQLException erro){
        
    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
    
    }
  }
  
  public static void gerarRanking () {
      int i = 1;
  try{  
  conectar();
  String query = "select * from quiz order by pontuacao desc";
  
  Statement rst = con.createStatement();
  
  ResultSet resultado = rst.executeQuery(query);
  
      System.out.println("---------- RANKING GERAL ------------");
  while(resultado.next()){
      
      System.out.println( i + ":" + resultado.getString("nomeJogador") + " Pontos: " + resultado.getString("pontuacao"));
      //if(i == 5){break;}
      i++;
  }
  
      }catch(SQLException erro){
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
    }
  }
    
    
}
