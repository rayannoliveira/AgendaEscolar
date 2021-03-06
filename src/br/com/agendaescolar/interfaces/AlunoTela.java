/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.interfaces;

import br.com.agendaescolar.classes.Anotacao;
import br.com.agendaescolar.classes.Atividade;
import br.com.agendaescolar.classes.Observacao;
import dao.DAOAluno;
import dao.DAOAnotacao;
import dao.DAOResponsavel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.agendaescolar.utilitarios.ModeloTabela;
import dao.DAOAtividade;
import dao.DAOObservacao;
import dao.DAOProfessor;

/**
 *
 * @author dell1
 */
public class AlunoTela extends javax.swing.JInternalFrame {

    /**
     * Creates new form AlunoTela
     */
    public AlunoTela() {
        initComponents();
        setSize(700, 490);
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAnotacao = new javax.swing.JTable();
        jLabelNomeAluno = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAtividade = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableObservacao = new javax.swing.JTable();
        jLabelAtividade = new javax.swing.JLabel();
        jLabelAnotacao = new javax.swing.JLabel();
        jLabelObservacao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell1\\Desktop\\fundo2.png")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell1\\Desktop\\fundo2.png")); // NOI18N

        setClosable(true);
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

        jTableAnotacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableAnotacao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 230, 340, 80);

        jLabelNomeAluno.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        getContentPane().add(jLabelNomeAluno);
        jLabelNomeAluno.setBounds(220, 20, 250, 30);

        jTableAtividade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableAtividade);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 100, 340, 90);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agendaescolar/imagens/logo.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, -10, 360, 90);

        jTableObservacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTableObservacao);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(190, 340, 350, 90);

        jLabelAtividade.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelAtividade.setText("Atividade Criada por professores ");
        getContentPane().add(jLabelAtividade);
        jLabelAtividade.setBounds(190, 80, 280, 17);

        jLabelAnotacao.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelAnotacao.setText("Anotação Criada por Responsaveis ");
        getContentPane().add(jLabelAnotacao);
        jLabelAnotacao.setBounds(200, 200, 280, 17);

        jLabelObservacao.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelObservacao.setText("Observação Criada por Professores");
        getContentPane().add(jLabelObservacao);
        jLabelObservacao.setBounds(200, 320, 310, 17);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agendaescolar/imagens/fundo2.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-80, -240, 890, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
     montarTabela();
     montarAtividade();
     montarObservacao();
    
    }
        private void montarTabela(){
        DAOAluno objaluno= new DAOAluno();
          //int idA=objaluno.idAluno;
          int idA=DAOAluno.idAluno;
     // TODO add your handling code here:
        //Dados para a montagem das Colunas
        String colunas[] = new String[]{"Id","Nome","Descrição","data"};
        //Criacao do objeto que define o modelo da Tabela
        //Passamos null no primeiro argumento, pois as linhas serão definidas
        //Dentro do foreach. Ele recebe como argumento um vetor de Objetos
        DefaultTableModel modelotabela = new DefaultTableModel(null,colunas);
        
        //Criação do objeto DAOAnotação para recuperar os dados dos alunos
        //que estão na Tabela Aluno
        DAOAnotacao daoanotacao = new DAOAnotacao();
        //Chamada do método que retorna todos os alunos cadastrados
        //na tabela Anotação
        ArrayList<Anotacao> ListaA = daoanotacao.listarAnotacao(idA, "ALUNO");
        //ForEach que pega cada objeto Anotação da ListaA e atribui
        //ao objeto Anotação
        DAOAluno daoaluno = new DAOAluno();
        String nome="";
         nome=daoaluno.retornaNome(idA);
         jLabelNomeAluno.setText("Olá  "+nome);
        for(Anotacao a : ListaA){
            //Nesta linha nos adicionamos as linhas na tabela
            //Montamos aqui um Vetor de Objetos
             nome = daoaluno.retornaNome(a.getIdaluno());
             jLabelNomeAluno.setText("Olá  "+nome);
            modelotabela.addRow(new Object[]{a.getIdAnotacao(), nome, a.getDescricao(),a.getData()});
             
        }
     
        
     jTableAnotacao.setModel(modelotabela);
              
        
    }//GEN-LAST:event_formInternalFrameOpened

       private void montarAtividade(){
        DAOAluno objaluno= new DAOAluno();
          int idA=objaluno.idturma;
     // TODO add your handling code here:
        //Dados para a montagem das Colunas
        String colunas[] = new String[]{"Atividade","Disciplina","Nome Professor","Turma"};
        //Criacao do objeto que define o modelo da Tabela
        //Passamos null no primeiro argumento, pois as linhas serão definidas
        //Dentro do foreach. Ele recebe como argumento um vetor de Objetos
        DefaultTableModel modelotabela = new DefaultTableModel(null,colunas);
        
        //Criação do objeto DAOAluno para recuperar os dados dos alunos
        //que estão na Tabela Aluno
        DAOAtividade daoatividade = new DAOAtividade();
        //Chamada do método que retorna todos os alunos cadastrados
        //na tabela Aluno
       ArrayList<Atividade> ListaA = daoatividade.listarAtividade(idA, "ALUNO");
        //ForEach que pega cada objeto aluno da ListaA e atribui
        //ao objeto Aluno a
        for(Atividade a : ListaA){
            //Nesta linha nos adicionamos as linhas na tabela
            //Montamos aqui um Vetor de Objetos
              DAOProfessor objr= new DAOProfessor();
            String nomeProf=objr.retornaNome(a.getIdProf());
            // jLabelNomeAluno.setText("Olá  "+nome);
            modelotabela.addRow(new Object[]{a.getDescricaoAtividade(), a.getDisciplina(),nomeProf,a.getIdTurma()});
             
        }
     
       jTableAtividade.setModel(modelotabela);
    }
       private void montarObservacao(){
        String colunas[] = new String[]{"Descrição","Professor","Aluno"};
        DefaultTableModel modelotabela = new DefaultTableModel(null,colunas);
        DAOObservacao obj= new DAOObservacao();
         DAOAluno objaluno= new DAOAluno();
           int idA=DAOAluno.idAluno;
        DAOProfessor objr= new DAOProfessor();
       ArrayList<Observacao> ListaA = obj.retornarObAluno(idA);
        for( Observacao a : ListaA){
            String nomeAluno,nomeProf;
            
             nomeAluno =obj.retornaNome(a.getIdAluno());
             nomeProf=objr.retornaNome(a.getIdProfessor());
          modelotabela.addRow(new Object[]{a.getDescricao(),nomeProf,nomeAluno});    
        }
     
       jTableObservacao.setModel(modelotabela);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAnotacao;
    private javax.swing.JLabel jLabelAtividade;
    private javax.swing.JLabel jLabelNomeAluno;
    private javax.swing.JLabel jLabelObservacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAnotacao;
    private javax.swing.JTable jTableAtividade;
    private javax.swing.JTable jTableObservacao;
    // End of variables declaration//GEN-END:variables

}