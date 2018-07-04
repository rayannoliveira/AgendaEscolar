/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.classes;

import java.util.Calendar;

/**
 *
 * @author dell1
 */
public class Anotacao {
    private int idAnotacao;
    private int idaluno;
    private int idresponsavel;
    private String descricao;
    private Calendar data;
   

    /**
     * @return the idaluno
     */
    public int getIdaluno() {
        return idaluno;
    }

    /**
     * @param idaluno the idaluno to set
     */
    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    /**
     * @return the idresponsavel
     */
    public int getIdresponsavel() {
        return idresponsavel;
    }

    /**
     * @param idresponsavel the idresponsavel to set
     */
    public void setIdresponsavel(int idresponsavel) {
        this.idresponsavel = idresponsavel;
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
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the idAnotacao
     */
    public int getIdAnotacao() {
        return idAnotacao;
    }

    /**
     * @param idAnotacao the idAnotacao to set
     */
    public void setIdAnotacao(int idAnotacao) {
        this.idAnotacao = idAnotacao;
    }
    
    
}
