/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.agendaescolar.classes.Atividade;
import br.com.agendaescolar.utilitarios.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOAtividade {
     private  Connection con;
    private PreparedStatement stmt;
    private String comandoSql;
    private  ResultSet res;
    ArrayList <Atividade> lista= new ArrayList<>();
    
public DAOAtividade(){
    con= ConnectionFactory.getConnection();
}
   
public void salvarAtividade(Atividade a){
    comandoSql="insert into atvidade(descricaoAtividade,disciplina,Turma_has_Professor_Turma_idTurma,Turma_has_Professor_Professor_idProfessor)values(?,?,?,?)";
         try {
             stmt=con.prepareStatement(comandoSql);
             stmt.setString(1,a.getDescricaoAtividade());
             stmt.setString(2, a.getDisciplina());
             stmt.setInt(3, a.getIdTurma());
             stmt.setInt(4,a.getIdProf());
             
             stmt.execute();
             
             JOptionPane.showMessageDialog(null, "Atividade enviada com sucesso");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
             Logger.getLogger(DAOAtividade.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    
}
public  ArrayList<Atividade> listarAtividade(int identificador, String tipo){
            try {
                if (tipo == "ALUNO"){
                    comandoSql = "select * from atvidade where Turma_has_Professor_Turma_idTurma =?";   
                   
                }
                else {
                    comandoSql = "select * from  atvidade  where Turma_has_Professor_Professor_idProfessor =?";
                }
                
                stmt=con.prepareStatement(comandoSql);            
                stmt.setInt(1,identificador);
                res = stmt.executeQuery();
                while(res.next()){
                   Atividade atividadelista = new Atividade();
                    atividadelista.setDescricaoAtividade(res.getString("descricaoAtividade"));
                    atividadelista.setDisciplina(res.getString("disciplina"));
                    atividadelista.setIdProf(res.getInt("Turma_has_Professor_Turma_idTurma"));
                    atividadelista.setIdTurma(res.getInt("Turma_has_Professor_Professor_idProfessor"));
                    lista.add(atividadelista);
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

 
 
    
}
