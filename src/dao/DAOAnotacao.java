/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import br.com.agendaescolar.classes.Anotacao;
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
public class DAOAnotacao {
    private final Connection con;
    private PreparedStatement stmt;
    private String comandoSql;
    private ResultSet res;
    private ArrayList<Anotacao> lista = new ArrayList<Anotacao>();
    
    public DAOAnotacao(){
        con= ConnectionFactory.getConnection();
    }
    
    public void salvar(Anotacao a) throws SQLException{
        try {
            comandoSql = "insert into anotacao(descricao,Responsavel_has_aluno_FKidResponsavel,Responsavel_has_aluno_FKidAluno) values(?,?,?)";
            stmt=con.prepareStatement(comandoSql);
        
            stmt.setString(1, a.getDescricao());
            stmt.setInt(2, a.getIdresponsavel());
            stmt.setInt(3, a.getIdaluno());
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
    
  public  ArrayList<Anotacao> listarAnotacao(int identificador, String tipo){
            try {
                if (tipo == "ALUNO"){
                    comandoSql = "select * from anotacao where 	Responsavel_has_aluno_FKidAluno =?";    
                }
                else {
                    comandoSql = "select * from anotacao where Responsavel_has_aluno_FKidResponsavel =?";
                }
                
                stmt=con.prepareStatement(comandoSql);            
                stmt.setInt(1,identificador);
                res = stmt.executeQuery();
                while(res.next()){
                   Anotacao anotacaolista = new Anotacao();
                     anotacaolista.setIdAnotacao(res.getInt("idanotacao"));
                    anotacaolista.setDescricao(res.getString("descricao"));
                    anotacaolista.setIdresponsavel(res.getInt("Responsavel_has_aluno_FKidResponsavel"));
                    anotacaolista.setIdaluno(res.getInt("Responsavel_has_aluno_FKidAluno"));
                    lista.add(anotacaolista);
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
    
   
       public void alterarNome(Anotacao a){
       /*    comandoSql="update aluno set nomeAluno=? where matricula=?";
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
          
           
       */}

      
    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
