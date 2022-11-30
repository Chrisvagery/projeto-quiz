
package br.com.sistemachris.model.view;

import br.com.sistemachris.model.vo.Jogador;
import java.util.Scanner;
import br.com.sistemachris.model.bo.QuizNivel;
import static br.com.sistemachris.model.bo.QuizNivel.gerarRanking;


public class JogoQuiz {
    
    public static void main(String[] args) {
        
        Scanner dado = new Scanner(System.in);
        Jogador j1 = new Jogador();
        System.out.println("Digite seu nome para começar o jogo: "); 
        j1.registrarNome(dado.next());
        System.out.println("Seja bem vindo(a)!" );    
        //Quiz chris = new Quiz(j1);                  
        QuizNivel chris = new QuizNivel(j1);
        //QuizNivel2 chris = new QuizNivel2(j1); 
        
        
        chris.responder();
        chris.salvarPontuacao();
        chris.exibirPontuacao();
        gerarRanking();
        
        
    }
    
}
