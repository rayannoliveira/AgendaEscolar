
package br.com.agendaescolar.classes;
import br.com.agendaescolar.utilitarios.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Professor {
    private PreparedStatement stmt= null;
    private Connection con= ConnectionFactory.getConnection();
    private  String matriculaProf;
    private String nomeProfessor;
    private String telefone;
    private  String email;
    private String senhaProfessor;

    /**
     * @return the stmt
     */
    public PreparedStatement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
     */
    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the matriculaProf
     */
    public String getMatriculaProf() {
        return matriculaProf;
    }

    /**
     * @param matriculaProf the matriculaProf to set
     */
    public void setMatriculaProf(String matriculaProf) {
        this.matriculaProf = matriculaProf;
    }

    /**
     * @return the nomeProfessor
     */
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    /**
     * @param nomeProfessor the nomeProfessor to set
     */
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senhaProfessor
     */
    public String getSenhaProfessor() {
        return senhaProfessor;
    }

    /**
     * @param senhaProfessor the senhaProfessor to set
     */
    public void setSenhaProfessor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }
    public String mostrarProfessor(){
        return matriculaProf;
    }
    @Override
    public String toString(){
        return nomeProfessor;
    }
    
}
