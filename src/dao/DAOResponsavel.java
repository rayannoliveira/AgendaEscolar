/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import br.com.agendaescolar.classes.Aluno;
import br.com.agendaescolar.classes.Responsavel;
import br.com.agendaescolar.utilitarios.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DAOResponsavel {
    
     private Connection con;
     private PreparedStatement stmt;
     private String comandoSql;
     private ResultSet res;
     private ArrayList <Responsavel>lista= new ArrayList<Responsavel>();
     private ArrayList<Aluno>listaaluno= new ArrayList<Aluno>();
     public Responsavel re;
     public static String verificar;
       Responsavel responsavel= new Responsavel();
     String cpfr;
     public static int ID;
     
     public DAOResponsavel(){
         con=ConnectionFactory.getConnection();
     }
    
     public  void salvarResponsavel(Responsavel r){
            try {
            comandoSql = "insert into responsavel(cpf,nome_responsavel,senha_responsavel,email) values (?,?,?,?)";
            stmt=con.prepareStatement(comandoSql);
            
            stmt.setString(1, r.getCpf());
            stmt.setString(2, r.getNome());
            stmt.setString(3, r.getSenha());
            stmt.setString(4, r.getEmail());
            
            stmt.execute();
            con.close();
           JOptionPane.showMessageDialog(null, "Responsavel matriculado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Responsavel"+ ex);
        }
        finally
        { 
            //con.close();
            
        }
       
        
         
     }
     public ArrayList<Responsavel> listarResponsavel(){
         try {
             comandoSql="select * from Responsavel";
         
             stmt=con.prepareStatement(comandoSql);
             res = stmt.executeQuery();
              while(res.next()){
                Responsavel responsavel= new  Responsavel();
           
                responsavel.setCpf(res.getString("cpf"));
                responsavel.setNome(res.getString("nome_responsavel"));
                responsavel.setSenha(res.getString("senha_responsavel"));
                responsavel.setEmail(res.getString("email"));
                lista.add(responsavel);
              } 
         }catch (Exception e) {
         }
             
          return lista;        
              
    
     }
     public void salvarAlunos(String nomeAluno, String nomeResponsavel){
         int idAluno=0,idResponsavel=0;
         try {
             //pegar o id do aluno
             comandoSql="select idAluno from aluno where nomeAluno= ?";
             stmt=con.prepareStatement(comandoSql);
             stmt.setString(1, nomeAluno);
             res=stmt.executeQuery();
             while(res.next()){
                idAluno= res.getInt("idAluno");
             }
             
             //pegar o id do Responsabel
             comandoSql="select idResponsavel from responsavel where nome_responsavel= ?";
             stmt=con.prepareStatement(comandoSql);
             stmt.setString(1, nomeResponsavel);
             res=stmt.executeQuery();
             while(res.next()){
                idResponsavel= res.getInt("idResponsavel");
             }
             //Insert na tabela responsavel_has_aluno
             comandoSql = "insert into responsavel_has_aluno(FKidResponsavel,FKidAluno) values (?,?)";
             stmt=con.prepareStatement(comandoSql);
            
            stmt.setInt(1,idResponsavel);
            stmt.setInt(2, idAluno);
            stmt.execute();
            con.close();
             JOptionPane.showMessageDialog(null, "Relacionado com sucessor");
             
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     }
     public String loginResponsavel(Responsavel r){
         comandoSql="SELECT cpf, senha_responsavel FROM responsavel WHERE cpf= ? AND  senha_responsavel = ?";
         try {
              stmt=con.prepareStatement(comandoSql);
              stmt.setString(1, r.getCpf());
              stmt.setString(2, r.getSenha());
              
              res=stmt.executeQuery();
             if(res.next()){
                 
               responsavel.setCpf(res.getString("cpf"));
                 this.cpfr= responsavel.getCpf();
                 tornarId(cpfr);
                 verificar="responsavel";
            
               con.close();
               
             } else JOptionPane.showMessageDialog(null, "usuario ou senha incorreta");
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
          return verificar;
     }
     public  ArrayList<Responsavel> retonarLogin(){
          
       
          return lista;
          
                  
         
     }
     public void alterarNome(Responsavel r){
         comandoSql="update responsavel set nome_responsavel=? where cpf=?";
         try {
             stmt=con.prepareStatement(comandoSql);
             stmt.setString(1, r.getNome());
             stmt.setString(2, r.getCpf());
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Alterado com sucesso");
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     }
     public void alterarSenha(Responsavel r){
         comandoSql="update responsavel set senha_responsavel=? where cpf=?";
         try {
             stmt=con.prepareStatement(comandoSql);
             stmt.setString(1, r.getSenha());
             stmt.setString(2, r.getCpf());
             stmt.executeUpdate();
              JOptionPane.showMessageDialog(null,"Alterado com sucesso");
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,ex);
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     public void alterarEmail(Responsavel r){
         comandoSql="update responsavel set email=? where cpf=?";
         try {
             stmt=con.prepareStatement(comandoSql);
             stmt.setString(1, r.getEmail());
             stmt.setString(2, r.getCpf());
             stmt.executeUpdate();
              JOptionPane.showMessageDialog(null,"Alterado com sucesso");
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
     }
     public int retornarResponsavel(String nomeResponsavel){
         //pegar o id do Responsabel
         int idResponsavel=0;
         comandoSql="select idResponsavel from responsavel where nome_responsavel= ?";
         try {
             stmt=con.prepareStatement(comandoSql); 
             stmt.setString(1, nomeResponsavel);
              res=stmt.executeQuery();
              while(res.next()){
                  idResponsavel = res.getInt("idResponsavel");
                  stmt=con.prepareStatement(comandoSql);            
             }     
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return idResponsavel;
     
    }
    public ArrayList<Aluno> retornarAlunos(int idresponsavel){
         int idaluno=0;
         ResultSet rs;
         PreparedStatement st;
         comandoSql="select FKIdAluno from responsavel_has_aluno where FKIDResponsavel=?";
         try {
             stmt=con.prepareStatement(comandoSql);
             stmt.setInt(1, idresponsavel);
             res=stmt.executeQuery();
             while(res.next()){
                idaluno= res.getInt("FKIdAluno");
                comandoSql="select * from aluno where idAluno=?";
                st=con.prepareStatement(comandoSql);
                st.setInt(1, idaluno);
                rs=st.executeQuery();
                while(rs.next()){
                    Aluno a= new Aluno();
                    a.setNomeAluno(rs.getString("nomeAluno"));
                    a.setSenha(rs.getString("senhaAluno"));
                    a.setMatricula(rs.getString("matricula"));
                    listaaluno.add(a);
                }
            }
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }

         return (listaaluno);
       //  stmt=con.prepareStatement(comandoSql);
         
         
                 
    }
     public void tornarId(String cpf){
         //pegar o id do Responsabel
         int idResponsavel=0;
         comandoSql="select idResponsavel from responsavel where cpf= ?";
         try {
             stmt=con.prepareStatement(comandoSql); 
             stmt.setString(1, cpf);
             res=stmt.executeQuery();
             while(res.next()){
                  idResponsavel = res.getInt("idResponsavel");
                  //stmt=con.prepareStatement(comandoSql);
                // Aluno A= new Aluno();
                //DAOResponsavel r = new DAOResponsavel();
                 ID= idResponsavel; 
             }    
              
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        //return idResponsavel;
     
    }
    public int retone(){
        return ID;
        
    }
    
    public  ArrayList<Responsavel>  retornarRelacao(){
       
        comandoSql="select * from responsavel_has_aluno";
         try {
             stmt=con.prepareStatement(comandoSql);
              res=stmt.executeQuery();
              while(res.next()){
                  Responsavel r= new Responsavel();
               r.setIdresponsavel(res.getInt("FKidResponsavel"));
               r.setIdAluno(res.getInt("FKidAluno"));
              lista.add(r);
              }              
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
         return lista;
    }
    public String retornarNome(int id){
        String nomeresponsavel="";
        comandoSql="select nome_responsavel from responsavel where idResponsavel= ?";
         try {
             stmt=con.prepareStatement(comandoSql); 
             stmt.setInt(1, id);
              res=stmt.executeQuery();
              while(res.next()){
                  nomeresponsavel= res.getString("nome_responsavel");
                  stmt=con.prepareStatement(comandoSql);            
             }     
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return nomeresponsavel;
     
    }
    
   
    
}