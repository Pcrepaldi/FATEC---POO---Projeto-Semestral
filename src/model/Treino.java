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
public class Treino {
    
    private int cod_treino;
    private int cod_professor;
    private int cod_aluno;
    private String nome;
    private String objetivo;

    public static ArrayList<Treino> arrayTreino = new ArrayList<>();
    
    public Treino(){
        
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