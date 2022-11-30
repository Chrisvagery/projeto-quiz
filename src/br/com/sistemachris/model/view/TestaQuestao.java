
package br.com.sistemachris.model.view;

import br.com.sistemachris.model.vo.Questao;
import br.com.sistemachris.model.dao.QuestaoDAO;
import java.util.ArrayList;


public class TestaQuestao {
    
    public static void main(String[] args){
        
        QuestaoDAO questaoDAO = new QuestaoDAO();
        
      // ArrayList<Questao> questoes = questaoDAO.consultarQuestoes("facil" , "saude");
        
        ArrayList<Questao> questoes = questaoDAO.consultarQuestoesAleatorios(5);
        
        for(Questao questao : questoes){
            System.out.println(questao.getNomeQuestao());
            System.out.println(questao.getA());
            System.out.println(questao.getB());
            System.out.println(questao.getC());
            System.out.println(questao.getD());
            System.out.println(questao.getResposta());
            System.out.println("\n");
            System.out.println("========================");
            
        }
    }
    
}
