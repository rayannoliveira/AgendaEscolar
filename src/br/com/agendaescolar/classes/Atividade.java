/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.classes;

import java.util.Calendar;


public class Atividade {
    private String descricaoAtividade;
    private  Calendar data;
    private  Calendar dataEntrega;
    private String disciplina;
    private int idTurma;
    private int idProf;

    /**
     * @return the descricaoAtividade
     */
    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    /**
     * @param descricaoAtividade the descricaoAtividade to set
     */
    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
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
     * @return the dataEntrega
     */
    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the idTurma
     */
    public int getIdTurma() {
        return idTurma;
    }

    /**
     * @param idTurma the idTurma to set
     */
    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    /**
     * @return the idProf
     */
    public int getIdProf() {
        return idProf;
    }

    /**
     * @param idProf the idProf to set
     */
    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }
    
    
    
}
