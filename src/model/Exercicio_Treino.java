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
public class Exercicio_Treino extends Treino{
    
    private int cod_exerc_treino;
    private int cod_exerc;
    private String nomeEx;
    private String parte_corpo;
    private int qtd_series;
    private String tempo_intervalo;
    
    private int cod_treino;
    private int cod_professor;
    private int cod_aluno;
    private String nome;
    private String objetivo;
    
    //public static ArrayList arrayExerc = new ArrayList<>();
    
    public Exercicio_Treino(){
        
    }

    public int getCod_Exerc_Treino() {
        return cod_exerc_treino;
    }

    public void setCod_Exerc_Treino(int cod_exerc_treino) {
        this.cod_exerc_treino = cod_exerc_treino;
    }
    
    public int getCod_exerc() {
        return cod_exerc;
    }

    public void setCod_exerc(int cod_exerc) {
        this.cod_exerc = cod_exerc;
    }

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

    public int getCod_treino() {
        return cod_treino;
    }

    public void setCod_treino(int cod_treino) {
        this.cod_treino = cod_treino;
    }

    public int getCod_professor() {
        return cod_professor;
    }

    public void setCod_professor(int cod_professor) {
        this.cod_professor = cod_professor;
    }

    public int getCod_aluno() {
        return cod_aluno;
    }

    public void setCod_aluno(int cod_aluno) {
        this.cod_aluno = cod_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    
    
    
}
