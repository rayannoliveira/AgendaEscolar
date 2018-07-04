/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.interfaces;

import br.com.agendaescolar.classes.Professor;
import dao.DAOProfessor;
import javax.swing.JOptionPane;

/**
 *
 * @author dell1
 */
public class AlterarProfessor extends javax.swing.JInternalFrame {

    /**
     * Creates new form AlterarProfessor
     */
    public AlterarProfessor() {
        initComponents();
        setSize(480, 400);
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
        jTextMatricula = new javax.swing.JTextField();
        jComboBoxAlterarProf = new javax.swing.JComboBox<>();
        jTextAlterar = new javax.swing.JTextField();
        jLabelAlterar = new javax.swing.JLabel();
        jLabelTipoAlterar = new javax.swing.JLabel();
        jButtonAlterarProf = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Alterar Professor");
        getContentPane().setLayout(null);

        jLabel1.setText("Matricula");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 30, 76, 14);
        getContentPane().add(jTextMatricula);
        jTextMatricula.setBounds(140, 50, 151, 29);

        jComboBoxAlterarProf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item", "Nome", "Senha", "Telefone", "Email" }));
        getContentPane().add(jComboBoxAlterarProf);
        jComboBoxAlterarProf.setBounds(150, 120, 100, 29);
        getContentPane().add(jTextAlterar);
        jTextAlterar.setBounds(140, 180, 151, 31);

        jLabelAlterar.setText("Campo a alterar");
        getContentPane().add(jLabelAlterar);
        jLabelAlterar.setBounds(140, 160, 180, 14);

        jLabelTipoAlterar.setText("Tipo a alterar");
        getContentPane().add(jLabelTipoAlterar);
        jLabelTipoAlterar.setBounds(140, 100, 160, 14);

        jButtonAlterarProf.setText("ALTERAR");
        jButtonAlterarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarProfActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterarProf);
        jButtonAlterarProf.setBounds(110, 250, 110, 23);

        jButtonLimpar.setText("LIMPAR");
        getContentPane().add(jButtonLimpar);
        jButtonLimpar.setBounds(240, 250, 110, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell1\\Desktop\\lib.png")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 500, 360);
        jLabel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarProfActionPerformed
        String matricula,opcao;
        matricula=jTextMatricula.getText();
        opcao=jTextAlterar.getText();
        Professor obj= new Professor();
       if(jComboBoxAlterarProf.getSelectedItem()=="Nome"){
            obj.setMatriculaProf(matricula);
            obj.setNomeProfessor(opcao);
            DAOProfessor objdao= new  DAOProfessor();
            objdao.alterarNome(obj);
       } else
           if(jComboBoxAlterarProf.getSelectedItem()=="Senha"){
               obj.setMatriculaProf(matricula);
               obj.setSenhaProfessor(opcao);
               DAOProfessor objdao= new  DAOProfessor();
            objdao.alterarSenha(obj);
           } else
               if(jComboBoxAlterarProf.getSelectedItem()=="Email"){
                   obj.setMatriculaProf(matricula);
                   obj.setEmail(opcao);
                   DAOProfessor objdao= new  DAOProfessor();
                   objdao.alterarEmail(obj);
               } else{
           JOptionPane.showMessageDialog(null, "Selecione um item");        
               }
        
    }//GEN-LAST:event_jButtonAlterarProfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarProf;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JComboBox<String> jComboBoxAlterarProf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAlterar;
    private javax.swing.JLabel jLabelTipoAlterar;
    private javax.swing.JTextField jTextAlterar;
    private javax.swing.JTextField jTextMatricula;
    // End of variables declaration//GEN-END:variables
}
