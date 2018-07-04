
package dao;
import br.com.agendaescolar.classes.Aluno;
import br.com.agendaescolar.classes.Professor;
import br.com.agendaescolar.classes.Turma;
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
public class DAOTurma {
    private  Connection con;
    private PreparedStatement stmt;
    private String comandoSql;
    private  ResultSet res;
    private ArrayList<Turma> lista1 = new ArrayList<Turma>();
    private ArrayList<Aluno> lista = new ArrayList<Aluno>();
    
    public DAOTurma(){
         con= ConnectionFactory.getConnection();
    }
    
    public void salvarTurma(Turma t){
        comandoSql="insert into turma(nomeTurma, turno) values(?,?)";
        try {
            stmt=con.prepareStatement(comandoSql);
            
            stmt.setString(1,t.getNomeTurma());
            stmt.setString(2,t.getTurno());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Cadastrada com");
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "o erro: "+ ex);
        }
        
    }
    public ArrayList<Turma> retornarTurma(){
           comandoSql="select * from  turma";
        try {
            stmt= con.prepareStatement(comandoSql);
            res=stmt.executeQuery();
             while(res.next()){
                 Turma t= new Turma();
                 t.setIdTurma(res.getInt("idTurma"));
                 t.setNomeTurma(res.getString("nomeTurma"));
                 t.setTurno(res.getString("turno"));
                 lista1.add(t); 
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista1;
    }
    
     public void salvarTurmaeProfessor(String idTurma, int idProf){
         int turma=Integer.parseInt(idTurma);
         
        comandoSql=" insert into turma_has_professor(Turma_idTurma,Professor_idProfessor) values (?,?)";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1,turma);
            stmt.setInt(2, idProf);
            stmt.execute();
            con.close();
             JOptionPane.showMessageDialog(null, "Relacionado com sucessor");
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     public void salvarTurmaAluno( String turma,String aluno){
             int ida= Integer.parseInt(aluno);
             int idt= Integer.parseInt(turma);
             
             comandoSql="insert into turma_has_aluno(Turma_idTurma , aluno_idAluno)values(?,?) ";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, idt);
            stmt.setInt(2, ida);
            stmt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
             
           
         
     }
     public ArrayList<Turma> turmare( int id){
         int idprofe=0;
         idprofe=id;
         comandoSql="select Turma_idTurma from turma_has_professor where Professor_idProfessor = ?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, idprofe);
            res=stmt.executeQuery();
           
            while(res.next()){
           Turma objturma= new Turma();
           objturma.setIdTurma(res.getInt("Turma_idTurma"));
            lista1.add(objturma);
            
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
       return lista1;
     }
 
      public ArrayList<Aluno> retornaridaluno( int id){
        
         comandoSql="select aluno_idAluno from turma_has_aluno where Turma_idTurma = ?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, id);
            res=stmt.executeQuery();
           
            while(res.next()){
           Aluno objaluno= new Aluno();
           objaluno.setCod(res.getInt("aluno_idAluno"));
            lista.add(objaluno);
            
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
       return lista;
     }
      
      public ArrayList<Turma> retornaTurmaeAluno(){
        
         comandoSql="select * from turma_has_aluno";
        try {
            stmt=con.prepareStatement(comandoSql);
            res=stmt.executeQuery();
           
            while(res.next()){
           Turma objturma= new Turma();
           objturma.setIdTurma(res.getInt("Turma_idTurma"));
           objturma.setIdAluno(res.getInt("aluno_idAluno"));
            lista1.add(objturma);
            
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
       return lista1;
     }
       public  int retornaridTurma (int id){
        int idTurma=0;
         comandoSql="select Turma_idTurma from turma_has_aluno where aluno_idAluno= ?";
        try {
            stmt=con.prepareStatement(comandoSql);
            stmt.setInt(1, id);
            res=stmt.executeQuery();
           
            while(res.next()){
          Turma objt= new Turma();
              objt.setIdTurma(res.getInt("Turma_idTurma"));
              idTurma=objt.getIdTurma();
            
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
       return idTurma;
     }
     
     
}

