/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.classes;


public class Turma {
    private  String nomeTurma;
    private  String turno;
    private  int idTurma;
    private int idAluno;
    

    /**
     * @return the nomeTurma
     */
    public String getNomeTurma() {
        return nomeTurma;
    }

    /**
     * @param nomeTurma the nomeTurma to set
     */
    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String retornaNome(){
        return nomeTurma;
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
    public String retornaId(){
        
        return Integer.toString(idTurma);
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

    /**
     * @return the idProfessor
     */
  
    
}
