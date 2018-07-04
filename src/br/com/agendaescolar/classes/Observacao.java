/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.classes;

import java.sql.Date;

/**
 *
 * @author dell1
 */
public class Observacao {
    private int idoberva;
    private  String descricao;
    private Date data;
    private  int idProfessor;
    private int idAluno;

    /**
     * @return the idoberva
     */
    public int getIdoberva() {
        return idoberva;
    }

    /**
     * @param idoberva the idoberva to set
     */
    public void setIdoberva(int idoberva) {
        this.idoberva = idoberva;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the idProfessor
     */
    public int getIdProfessor() {
        return idProfessor;
    }

    /**
     * @param idProfessor the idProfessor to set
     */
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    public String retornaid(){
    return  Integer.toString(idAluno);
}
    
}
