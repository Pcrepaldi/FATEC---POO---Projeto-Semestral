/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import java.util.Date;

import java.util.Date;


/**
 *
 * @author lubuntu
 */
public class Usuario {
    
    private int cod_usuario;
    private String nome;
    private String rg;
    private String cpf;
    private Date data_nasc;
    private String sexo;
    private String email;
    private String celular;
    private String rua;
    private int num_casa;
    private String bairro;
    private String cidade;
    private String estado;

    public Usuario(){
        
    }
    
    public Usuario(int cod_usuario, String nome, String rg, String cpf, Date data_nasc,
                    String sexo, String email, String celular, String rua, int num_casa,
                    String bairro, String cidade, String estado){
        
        this.cod_usuario = cod_usuario;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.email = email;
        this.celular = celular;
        this.rua = rua;
        this.num_casa = num_casa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(int num_casa) {
        this.num_casa = num_casa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
