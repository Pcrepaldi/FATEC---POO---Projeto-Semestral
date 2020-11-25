/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lubuntu
 */
public class Aluno extends Usuario{
    
    private int cod_aluno;
    private double valor_mensalidade;
    private double peso;
    private double altura;
    private Date data_inicio;
    private Date data_vencimento;
    private boolean ativo;

    public static ArrayList<Aluno> arrayAluno = new ArrayList<>();
    
    public Aluno(){
        
    }
    
    public int getCod_aluno() {
        return cod_aluno;
    }

    public void setCod_aluno(int cod_aluno) {
        this.cod_aluno = cod_aluno;
    }
    
    public double getValor_mensalidade() {
        return valor_mensalidade;
    }

    public void setValor_mensalidade(double valor_mensalidade) {
        this.valor_mensalidade = valor_mensalidade;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
