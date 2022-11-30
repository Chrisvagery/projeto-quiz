
package br.com.sistemachris.model.vo;


public class Jogador {
    
    private String nome;
    
    public void registrarNome(String nome){
        this.nome = nome;
        
    }
    
    public String getNome(){
        return this.nome;
    }
    
}
