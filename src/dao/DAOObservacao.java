/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import br.com.agendaescolar.classes.Aluno;
import br.com.agendaescolar.classes.Observacao;
import br.com.agendaescolar.utilitarios.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author dell1
 */
public class DAOObservacao {
    private  Connection con;
    private PreparedStatement stmt;
    private String comandoSql;
    private ResultSet res;
    public static int idAluno;
   private ArrayList<Aluno> lista = new ArrayList<Aluno>(); 
   private ArrayList<Observacao> lista1 = new ArrayList<Observacao>(); 

    public DAOObservacao() {
         con= ConnectionFactory.getConnection();
    }
    
    
     public  ArrayList<Aluno> retornarAlunos(int op){
           comandoSql = "select aluno_idAluno from turma_has_aluno where Turma_idTurma = ?";
            try {
                stmt=con.prepareStatement(comandoSql);
                stmt.setInt(1, op);
                res = stmt.executeQuery();
                while(res.next()){
                    Aluno alunolista = new Aluno();
                    alunolista.setCod(res.getInt("aluno_idAluno"));
                    lista.add(alunolista);
                }
                con.close();
             } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno"+ ex);
            }
            finally
            { 
            //con.close();
            
            }
            return lista;
                                          
    }
     
     public void salvarObservacao(Observacao o){
          comandoSql="insert into observacao(descricaoObsevacao, Professor_idProfessor, aluno_idAluno) values (?,?,?)";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setString(1,o.getDescricao());
            stmt.setInt(2, o.getIdProfessor());
            stmt.setInt(3,o.getIdAluno());
            stmt.execute();
         JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
                    } 
                catch (SQLException ex) {
            Logger.getLogger(DAOObservacao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
     }
     
     
     public  ArrayList<Observacao> retornarOb(){
           comandoSql="select * from observacao";
        try {
            stmt=con.prepareStatement(comandoSql);
            res=stmt.executeQuery();
             while(res.next()){
                Observacao obj= new Observacao();
                obj.setDescricao(res.getString("descricaoObsevacao"));
                obj.setIdProfessor(res.getInt("Professor_idProfessor"));
                obj.setIdAluno(res.getInt("aluno_idAluno"));
                lista1.add(obj);
                
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOObservacao.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista1;
     }
     public String retornaNome( int idaluno){
         String nomeAluno="";
           try {
               //pegar o id do aluno
             comandoSql="select nomeAluno from aluno where idAluno= ?";
             stmt=con.prepareStatement(comandoSql);
             stmt.setInt(1,idaluno);
             res=stmt.executeQuery();
             while(res.next()){
                nomeAluno= res.getString("nomeAluno");
             }
            } catch (Exception e) {
           }
           return nomeAluno;
        }
     
     
     
     public  ArrayList<Observacao> retornarObAluno(int idaluno){
           comandoSql="select * from observacao where aluno_idAluno=?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, idaluno);
            res=stmt.executeQuery();
             while(res.next()){
                Observacao obj= new Observacao();
                obj.setDescricao(res.getString("descricaoObsevacao"));
                obj.setIdProfessor(res.getInt("Professor_idProfessor"));
                obj.setIdAluno(res.getInt("aluno_idAluno"));
                lista1.add(obj);
                
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOObservacao.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista1;
     }
      public  ArrayList<Observacao> retornarAluno(int idAluno){
           comandoSql="select * from observacao where aluno_idAluno=?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, idAluno);
            res=stmt.executeQuery();
             while(res.next()){
                Observacao obj= new Observacao();
                obj.setDescricao(res.getString("descricaoObsevacao"));
                obj.setIdProfessor(res.getInt("Professor_idProfessor"));
                obj.setIdAluno(res.getInt("aluno_idAluno"));
                lista1.add(obj);
                
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOObservacao.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista1;
     }
    
    
}
