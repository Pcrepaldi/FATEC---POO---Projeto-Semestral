/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lubuntu
 */
public class Exercicio extends Treino{
    
    private int cod_exerc;
    //private int cod_treino;
    private String nomeEx;
    private String parte_corpo;
    private int qtd_series;
    private String tempo_intervalo;
    
    //public static ArrayList arrayExerc = new ArrayList<>();
    
    public Exercicio(){
        
    }

    public int getCod_exerc() {
        return cod_exerc;
    }

    public void setCod_exerc(int cod_exerc) {
        this.cod_exerc = cod_exerc;
    }
/*
    public int getCod_treino() {
        return cod_treino;
    }

    public void setCod_treino(int cod_treino) {
        this.cod_treino = cod_treino;
    }
*/
    public String getNomeEx() {
        return nomeEx;
    }

    public void setNomeEx(String nomeEx) {
        this.nomeEx = nomeEx;
    }

    public String getParte_corpo() {
        return parte_corpo;
    }

    public void setParte_corpo(String parte_corpo) {
        this.parte_corpo = parte_corpo;
    }

    public int getQtd_series() {
        return qtd_series;
    }

    public void setQtd_series(int qtd_series) {
        this.qtd_series = qtd_series;
    }

    public String getTempo_intervalo() {
        return tempo_intervalo;
    }

    public void setTempo_intervalo(String tempo_intervalo) {
        this.tempo_intervalo = tempo_intervalo;
    }
    
    
    
}
