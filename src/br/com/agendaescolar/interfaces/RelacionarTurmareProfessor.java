/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.interfaces;

import br.com.agendaescolar.classes.Professor;
import br.com.agendaescolar.classes.Turma;
import dao.DAOProfessor;
import dao.DAOTurma;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell1
 */
public class RelacionarTurmareProfessor extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelacionarTurmareProfessor
     */
    public RelacionarTurmareProfessor() {
        initComponents();
        setSize(800, 500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxTurma = new javax.swing.JComboBox<>();
        jComboBoxProfessor = new javax.swing.JComboBox<>();
        jButtonVincular = new javax.swing.JButton();
        jLabelTurma = new javax.swing.JLabel();
        jLabelProfessor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTurma = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell1\\Desktop\\fundo2.png")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.getAccessibleContext().setAccessibleName("");

        setClosable(true);
        setTitle("Relacionar turma e professor");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        getContentPane().add(jComboBoxTurma);
        jComboBoxTurma.setBounds(200, 100, 157, 36);

        getContentPane().add(jComboBoxProfessor);
        jComboBoxProfessor.setBounds(200, 190, 157, 33);

        jButtonVincular.setText("VINCULAR");
        jButtonVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVincularActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVincular);
        jButtonVincular.setBounds(200, 250, 120, 23);

        jLabelTurma.setText("Turma");
        getContentPane().add(jLabelTurma);
        jLabelTurma.setBounds(200, 60, 63, 14);

        jLabelProfessor.setText("Professor");
        getContentPane().add(jLabelProfessor);
        jLabelProfessor.setBounds(200, 160, 100, 14);

        jTableTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTurma);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 70, 300, 94);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Id das turmas ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 40, 140, 14);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell1\\Desktop\\fundo2.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-10, -350, 790, 880);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
  private void montarTabela(){
      //  DAOAluno objaluno= new DAOAluno();
        //  int idA=objaluno.idAluno;
     // TODO add your handling code here:
        //Dados para a montagem das Colunas
        String colunas[] = new String[]{"Id","Ano","Turno"};
        //Criacao do objeto que define o modelo da Tabela
        //Passamos null no primeiro argumento, pois as linhas serão definidas
        //Dentro do foreach. Ele recebe como argumento um vetor de Objetos
        DefaultTableModel modelotabela = new DefaultTableModel(null,colunas);
        
        //Criação do objeto DAOAluno para recuperar os dados dos alunos
        //que estão na Tabela Aluno
        DAOTurma  turma= new DAOTurma();
        //Chamada do método que retorna todos os alunos cadastrados
        //na tabela Aluno
        ArrayList<Turma> Lista = turma.retornarTurma();
        //ForEach que pega cada objeto aluno da ListaA e atribui
        //ao objeto Aluno a
        for(Turma a : Lista){
            //Nesta linha nos adicionamos as linhas na tabela
            //Montamos aqui um Vetor de Objetos
            modelotabela.addRow(new Object[]{a.getIdTurma(), a.getNomeTurma(),a.getTurno()});
             
        }
     
        
     jTableTurma.setModel(modelotabela);
              
        
    }   
    
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
         DAOProfessor objdaoP= new DAOProfessor();
            
            ArrayList<Professor> lista = objdaoP.listarProfessor();
            
            for (Professor meuProfessor : lista) {
                jComboBoxProfessor.addItem(meuProfessor.toString());    
            }
        DAOTurma objTurma= new DAOTurma();
        ArrayList<Turma> lista1= objTurma.retornarTurma();
        for (Turma minhaTurma: lista1){
            jComboBoxTurma.addItem(minhaTurma.retornaId());
        }
       montarTabela();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButtonVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVincularActionPerformed
       DAOTurma obj= new DAOTurma();
       String turmaopcao= jComboBoxTurma.getSelectedItem().toString();
       String profopcao= jComboBoxProfessor.getSelectedItem().toString();
       DAOProfessor objp= new DAOProfessor();
        int idp=objp.retornarProfessor(profopcao);
       
       obj.salvarTurmaeProfessor(turmaopcao,idp);
    }//GEN-LAST:event_jButtonVincularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVincular;
    private javax.swing.JComboBox<String> jComboBoxProfessor;
    private javax.swing.JComboBox<String> jComboBoxTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelProfessor;
    private javax.swing.JLabel jLabelTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTurma;
    // End of variables declaration//GEN-END:variables
}
