/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.interfaces;

import br.com.agendaescolar.classes.Atividade;
import br.com.agendaescolar.classes.Turma;
import dao.DAOAtividade;
import dao.DAOProfessor;
import dao.DAOTurma;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell1
 */
public class ProfessorTela extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProfessorTela
     */
    public ProfessorTela() {
        initComponents();
        setSize(800, 500);
    }
    private void montarAtividade(){
        DAOProfessor obj= new DAOProfessor();
          int idP= obj.idProfessor;
         
     // TODO add your handling code here:
        //Dados para a montagem das Colunas
        String colunas[] = new String[]{"Atividade","Disciplina","id professor","Turma"};
        //Criacao do objeto que define o modelo da Tabela
        //Passamos null no primeiro argumento, pois as linhas serão definidas
        //Dentro do foreach. Ele recebe como argumento um vetor de Objetos
        DefaultTableModel modelotabela = new DefaultTableModel(null,colunas);
        
        //Criação do objeto DAOAluno para recuperar os dados dos alunos
        //que estão na Tabela Aluno
        DAOAtividade daoatividade = new DAOAtividade();
        //Chamada do método que retorna todos os alunos cadastrados
        //na tabela Aluno
       ArrayList<Atividade> ListaA = daoatividade.listarAtividade(idP, "PROFESSOR");
        //ForEach que pega cada objeto aluno da ListaA e atribui
        //ao objeto Aluno a
        for(Atividade a : ListaA){
            //Nesta linha nos adicionamos as linhas na tabela
            //Montamos aqui um Vetor de Objetos
            // nome = daoaluno.retornaNome(a.getIdaluno());
            // jLabelNomeAluno.setText("Olá  "+nome);
            modelotabela.addRow(new Object[]{a.getDescricaoAtividade(), a.getDisciplina(),a.getIdTurma(),a.getIdProf()});
             
        }
     
       jTable1.setModel(modelotabela);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxSelecionarTurma = new javax.swing.JComboBox<>();
        jLabelTurma = new javax.swing.JLabel();
        jTextDescricaoAtiv = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabelAtividade = new javax.swing.JLabel();
        jTextDisciplina = new javax.swing.JTextField();
        jLabelDisicplina = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Professor");
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

        jComboBoxSelecionarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecionarTurmaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxSelecionarTurma);
        jComboBoxSelecionarTurma.setBounds(150, 70, 145, 31);

        jLabelTurma.setText("Turma");
        getContentPane().add(jLabelTurma);
        jLabelTurma.setBounds(150, 38, 70, 14);

        jTextDescricaoAtiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDescricaoAtivActionPerformed(evt);
            }
        });
        getContentPane().add(jTextDescricaoAtiv);
        jTextDescricaoAtiv.setBounds(150, 159, 154, 74);

        jButtonSalvar.setText("Enviar Atividade");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar);
        jButtonSalvar.setBounds(150, 343, 143, 23);

        jLabelAtividade.setText("Atividade");
        getContentPane().add(jLabelAtividade);
        jLabelAtividade.setBounds(150, 130, 100, 14);
        getContentPane().add(jTextDisciplina);
        jTextDisciplina.setBounds(150, 276, 154, 30);

        jLabelDisicplina.setText("Disciplina");
        getContentPane().add(jLabelDisicplina);
        jLabelDisicplina.setBounds(150, 251, 120, 14);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(417, 57, 282, 109);

        jLabel1.setText("Visualizar Atividade ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(417, 38, 95, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell1\\Desktop\\fundo2.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, -60, 780, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextDescricaoAtivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDescricaoAtivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDescricaoAtivActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       
          DAOProfessor prof= new DAOProfessor();
          int idp= prof.idProfessor;
          
          DAOTurma objt1= new DAOTurma();
           ArrayList<Turma> lista=objt1.turmare(idp);
          jComboBoxSelecionarTurma.removeAllItems();
       for (Turma minhaTurma: lista){
         
         jComboBoxSelecionarTurma.addItem(minhaTurma.retornaId());
        }
        montarAtividade();  
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        String descricao; 
         String opcao;
        String disciplina;
        descricao=jTextDescricaoAtiv.getText();
        disciplina=jTextDisciplina.getText();
        opcao=jComboBoxSelecionarTurma.getSelectedItem().toString();
        int op=Integer.parseInt(opcao);
        
        DAOProfessor prof= new DAOProfessor();
          int idp= prof.idProfessor;
          
        Atividade atv= new Atividade();
        atv.setDescricaoAtividade(descricao);
        atv.setDisciplina(disciplina);
        atv.setIdTurma(op);
        atv.setIdProf(idp);
        System.out.println(idp);
        System.out.println(op);
        DAOAtividade obj= new DAOAtividade();
        obj.salvarAtividade(atv);
        montarAtividade();
        
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jComboBoxSelecionarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecionarTurmaActionPerformed
       
    }//GEN-LAST:event_jComboBoxSelecionarTurmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxSelecionarTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAtividade;
    private javax.swing.JLabel jLabelDisicplina;
    private javax.swing.JLabel jLabelTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextDescricaoAtiv;
    private javax.swing.JTextField jTextDisciplina;
    // End of variables declaration//GEN-END:variables
}
