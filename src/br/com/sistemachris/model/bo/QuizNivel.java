
package br.com.sistemachris.model.bo;

import br.com.sistemachris.model.vo.Jogador;
import br.com.sistemachris.model.dao.Conexao;
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


public class QuizNivel {
    
    private int pontos;
    private Jogador chris;
    String nome;
    private int totalAcerto;
    private int totalQuestao;
    
    public QuizNivel(){
        
    }
    public QuizNivel(Jogador chris){
        this.chris = chris;
    }
    public void responder (){
        
        try{
            
            Scanner dado = new Scanner(System.in);
            
            conectar();
            this.pontos = 0;
            this.totalAcerto = 0;
            this.totalQuestao = 0;
            
            
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
                
            
             String query = "Select * from questao where nivel='" + nivel + "' and tema='" + tema + "'";
             Statement resultado ;
       
             resultado = con.createStatement();
       
             
            ResultSet rs = resultado.executeQuery(query);
       
           String resposta;
       
           fecharConexao();
           
           int i = 0;
           while(rs.next()){
               i++;
               System.out.println("("+i+")- " + rs.getString("nomeQuestao"));
               System.out.println("(A): " + rs.getString("A"));
               System.out.println("(B): " + rs.getString("B"));
               System.out.println("(C): " + rs.getString("C"));
               System.out.println("(D): " + rs.getString("D"));
               
               resposta = dado.next();
               
               if(resposta.equalsIgnoreCase(rs.getString("resposta"))){
                   this.pontos += 1;
                   this.totalAcerto += 1;
                   this.totalQuestao += 1;
                   System.out.println("Acertou");
               }else{
                   this.pontos += 0;
                   this.totalAcerto += 0;
                   this.totalQuestao += 1;
                   System.out.println("Voce errou");
               }
               System.out.println("");
           }
       
        }catch(SQLException erro){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            status = ("STATUS:" + erro.getMessage());
            
        }
    }
    public void exibirPontuacao (){
      System.out.println("Parabens " + this.chris.getNome()  +" seu total de pontos é: " + this.pontos + "," + 
               " seu total de acertos sao: " + this.totalAcerto + "," + "O total de questoes respondidos: " + this.totalQuestao );
  
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
