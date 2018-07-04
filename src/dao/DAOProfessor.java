/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.agendaescolar.classes.Aluno;
import br.com.agendaescolar.classes.Professor;
import br.com.agendaescolar.interfaces.Principa;
import br.com.agendaescolar.utilitarios.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class DAOProfessor {
    // são globais e serão usando em todos os met
    private  Connection con;
    private PreparedStatement stmt;
    private String comandoSql;
    private  ResultSet res;
    public static  int idProfessor;
    public static  String verificar;
    private ArrayList<Professor> lista1 = new ArrayList<Professor>();
   public  DAOProfessor(){
       /*Método construtor para quando chamar a classe DAO, ja terá feito conexao  com o banco de dados */
        con= ConnectionFactory.getConnection();
   } 
    /* Metodo usado na interface, para inserir os dados da tela no banco de dados*/
   public void salvarProfessor(Professor P){
       try {
           /*comandoSql é somente uma string para armazenar o comando*/
            comandoSql = "insert into professor(matricula,nomeProfessor,telefone,email,senhaProfessor)values (?,?,?,?,?)";
            // irá fazer o transporte para o  banco de dados 
            stmt=con.prepareStatement(comandoSql);
            // irá enviar por meio de metodo do prepareStatement todos os dados dos objetos da classe Professor P
            stmt.setString(1, P.getMatriculaProf());
            stmt.setString(2, P.getNomeProfessor());
            stmt.setString(3, P.getTelefone());
            stmt.setString(4, P.getEmail());
            stmt.setString(5, P.getSenhaProfessor());
          
            stmt.execute();
            
            con.close();
           JOptionPane.showMessageDialog(null, "Professor matriculado com sucesso");
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Professor"+ ex);
        }
        finally
        { 
            //con.close();
            
        }
       
       
   }
   public String loginProfessor(Professor p){
        comandoSql="SELECT  matricula, senhaprofessor FROM professor WHERE  matricula= ? AND  senhaProfessor = ?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setString(1,p.getMatriculaProf() );
            stmt.setString(2, p.getSenhaProfessor());
            res=stmt.executeQuery();
            if(res.next()){
                p.setMatriculaProf(res.getString("matricula"));
                String mat=p.getMatriculaProf();
                retornarId(mat);
                //receber o tipo do professor e mandar para o professor
                verificar="professor";
                con.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return verificar;
   }
   public void alterarNome(Professor p){
       comandoSql="update professor set nomeProfessor=? where  matricula=?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setString(1, p.getNomeProfessor());
            stmt.setString(2, p.getMatriculaProf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
   public void alterarSenha(Professor p){
       comandoSql="update professor set senhaProfessor=? where matricula=?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setString(1,p.getSenhaProfessor());
            stmt.setString(2, p.getMatriculaProf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");        
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    public void alterarEmail(Professor p){
        comandoSql="update professor set email=? where matricula=?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setString(1, p.getEmail());
            stmt.setString(2, p.getMatriculaProf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");       
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public  ArrayList<Professor> listarProfessor(){
            comandoSql="select * from professor";
        try {
            stmt=con.prepareStatement(comandoSql);
            res=stmt.executeQuery();
            while(res.next()){
                Professor p=new Professor();
                 p.setMatriculaProf(res.getString("matricula"));
                 p.setNomeProfessor(res.getString("nomeProfessor"));
                 p.setTelefone(res.getString("telefone"));
                 p.setEmail(res.getString("email"));
                 p.setSenhaProfessor(res.getString("senhaprofessor"));
                lista1.add(p);
               
            }
            con.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno"+ ex);
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista1;    
            
            
    }
    
    public int retornarProfessor(String nomeProfessor){
         //pegar o id do Responsabel
         int idProfessor=0;
         comandoSql="select idProfessor from Professor where nomeProfessor= ?";
         try {
             stmt=con.prepareStatement(comandoSql); 
             stmt.setString(1, nomeProfessor);
              res=stmt.executeQuery();
              while(res.next()){
                  idProfessor= res.getInt("idProfessor");
                  stmt=con.prepareStatement(comandoSql);            
             }     
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return idProfessor;
     
    }
    public void retornarId(String matricula){
        comandoSql="select idprofessor from professor where matricula= ? ";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setString(1, matricula);
            res=stmt.executeQuery();
            while(res.next()){
             Professor p= new Professor();
            idProfessor= res.getInt("idProfessor");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
     public String retornaNome(int id ){
          String nomeProf="";
        comandoSql="select nomeProfessor from professor where idProfessor= ? ";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, id);
            res=stmt.executeQuery();
            while(res.next()){
             Professor p= new Professor();
             nomeProf= res.getString("nomeProfessor");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return nomeProf;
    }
}
