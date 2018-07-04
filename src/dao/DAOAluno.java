/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import br.com.agendaescolar.classes.Aluno;
import br.com.agendaescolar.classes.Turma;
import br.com.agendaescolar.interfaces.Principa;
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
public class DAOAluno {
    private final Connection con;
    private PreparedStatement stmt;
    private String comandoSql;
    private ResultSet res;
    private ArrayList<Aluno> lista = new ArrayList<Aluno>();
    public static  int idAluno,idturma;
    public static String verificar;    
    public DAOAluno(){
        con= ConnectionFactory.getConnection();
    }
    
    public void salvar(Aluno a) throws SQLException{
        try {
            comandoSql = "insert into aluno(nomeAluno, senhaAluno,matricula) values(?,?,?)";
            stmt=con.prepareStatement(comandoSql);
        
            stmt.setString(1, a.getNomeAluno());
            stmt.setString(2, a.getSenha());
            stmt.setString(3, a.getMatricula());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso");
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno"+ ex);
        }
        finally
        { 
            con.close();
            
        }
    }
    
  public  ArrayList<Aluno> listarAluno(){
            
            try {
                String comandoSql = "select * from aluno";
                stmt=con.prepareStatement(comandoSql);            
                res = stmt.executeQuery();
                while(res.next()){
                    Aluno alunolista = new Aluno();
                    alunolista.setCod(res.getInt("idAluno"));
                    alunolista.setNomeAluno(res.getString("nomealuno"));
                    alunolista.setSenha(res.getString("senhaaluno"));
                    alunolista.setMatricula(res.getString("matricula"));
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
    
   public  String login(Aluno p ){
        try {
            comandoSql=("SELECT matricula, senhaAluno FROM aluno WHERE matricula= ? AND senhaAluno = ?");
            stmt = con.prepareStatement(comandoSql);
            stmt.setString(1, p.getMatricula());
            stmt.setString(2, p.getSenha());
            
            res=stmt.executeQuery();
              res = stmt.executeQuery();
        
        if(res.next()){
            String mat="";
           // new Principa().setVisible(true);
           p.setMatricula(res.getString("matricula"));
           mat= p.getMatricula();
            tornarId(mat);
             verificar="aluno";
            con.close();
           
            } else {

             JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta");
        }
             
     
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno"+ ex);
          
       }
        return verificar;
   }
       public void alterarNome(Aluno a){
           comandoSql="update aluno set nomeAluno=? where matricula=?";
        try {
            stmt=con.prepareStatement(comandoSql);
             stmt.setString(1,   a.getNomeAluno());
             stmt.setString(2, a.getMatricula());
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Alterado com sucesso");
             
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex);
            Logger.getLogger(DAOAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           
       }
       public void alterarSenha(Aluno a){
           comandoSql="update aluno set senhaAluno=? where matricula=?";
        try {
            stmt=con.prepareStatement(comandoSql);
             stmt.setString(1,a.getSenha());
             stmt.setString(2, a.getMatricula());
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showConfirmDialog(null, ex);
            Logger.getLogger(DAOAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       
       public int retornaidA(String nomeAluno){
         int idAluno=0;
           try {
               //pegar o id do aluno
             comandoSql="select idAluno from aluno where nomeAluno= ?";
             stmt=con.prepareStatement(comandoSql);
             stmt.setString(1, nomeAluno);
             res=stmt.executeQuery();
             while(res.next()){
                idAluno= res.getInt("idAluno");
             }
            } catch (Exception e) {
           }
           return idAluno;
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
                

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void tornarId(String matricula){
         //pegar o id do Responsabel
       //  int idResponsavel=0;
         comandoSql="select idAluno from aluno where matricula= ?";
         try {
             stmt=con.prepareStatement(comandoSql); 
             stmt.setString(1, matricula);
             res=stmt.executeQuery();
             while(res.next()){
                  idAluno= res.getInt("idAluno");
                  retornaridT();
                  System.out.println("Entrou no id aluno "+idAluno);
                  //stmt=con.prepareStatement(comandoSql);
                // Aluno A= new Aluno();
                //DAOResponsavel r = new DAOResponsavel();
               
             }    
              
         } catch (SQLException ex) {
             Logger.getLogger(DAOResponsavel.class.getName()).log(Level.SEVERE, null, ex);
         }
            //return idResponsavel;
     
    }
     public void retornaridT(){
         
         comandoSql="select Turma_idTurma from turma_has_aluno where aluno_idAluno= ?";    
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, idAluno);
            res=stmt.executeQuery();
            while(res.next()){
                idturma= res.getInt("Turma_idTurma");
                System.out.println("recebendo o valor de "+ idturma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         }
     public boolean apagar(int id){
         int retorno=0;
         comandoSql=" delete from aluno where idAluno =? ";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, id);
            retorno=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(retorno==0){
             return false;
         }
         else 
             return true;
     }
     public int retornaAlunoTurma(int id){
         
         comandoSql="select Turma_idTurma from turma_has_aluno where aluno_idAluno= ?";    
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, id);
            res=stmt.executeQuery();
            while(res.next()){
                idturma= res.getInt("Turma_idTurma");
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
         return idturma;
         }
     public int retornarIdAluno( String nome){
         int idAluno=0;
         comandoSql="select idAluno from aluno where nomeAluno=?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setString(1, nome);
            res=stmt.executeQuery();
            while(res.next()){
               Aluno a= new Aluno();
                idAluno= res.getInt("idAluno");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idAluno;
     }
     
}
