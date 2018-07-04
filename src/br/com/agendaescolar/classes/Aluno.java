
package br.com.agendaescolar.classes;

import br.com.agendaescolar.utilitarios.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Aluno {
    PreparedStatement stmt= null;
    Connection con= ConnectionFactory.getConnection();
    private String matricula;
    private String nomeAluno;
    private String senha;
    private int cod;
   
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
       
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nomeAluno
     */
    public String getNomeAluno() {
        return nomeAluno;
    }

    /**
     * @param nomeAluno the nomeAluno to set
     */
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    

// retorno do nome do aluno nos itens
    @Override
    public String toString() {
        return nomeAluno; //To change body of generated methods, choose Tools | Templates.
    }
   
  public String mostrarAluno(){
      return matricula;
  }
   

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }
   public void status(){
       System.out.println(" usuário é "+ matricula);
       System.out.println("senha é "+ senha);
   }  
public String retornaid(){
    return  Integer.toString(cod);
}
    
    
    
}
