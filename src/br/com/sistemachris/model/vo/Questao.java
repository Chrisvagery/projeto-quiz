
package br.com.sistemachris.model.vo;


public class Questao {
    private int idquestao;  
    private String nomeQuestao;
    private String A;
    private String B;
    private String C;
    private String D;
    private String resposta;
    private String nivel;
    private String tema;
    
    public Questao(){
        
    }

    public Questao(int idquestao, String nomeQuestao, String A, String B, String C, String D, String resposta, String nivel, String tema) {
        this.idquestao = idquestao;
        this.nomeQuestao = nomeQuestao;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.resposta = resposta;
        this.nivel = nivel;
        this.tema = tema;
    }

    public int getIdquestao() {
        return idquestao;
    }

    public void setIdquestao(int idquestao) {
        this.idquestao = idquestao;
    }

    public String getNomeQuestao() {
        return nomeQuestao;
    }

    public void setNomeQuestao(String nomeQuestao) {
        this.nomeQuestao = nomeQuestao;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    
    
    
}
