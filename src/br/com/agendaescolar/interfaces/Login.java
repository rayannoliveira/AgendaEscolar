/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.interfaces;

import br.com.agendaescolar.classes.Aluno;
import br.com.agendaescolar.classes.Professor;
import br.com.agendaescolar.classes.Responsavel;
import dao.DAOAluno;
import dao.DAOResponsavel;
import dao.DAOProfessor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dell1
 */
public class Login extends javax.swing.JFrame {
public static String v;
    /**
     * Creates new form LoginAdmim
     */
    public Login() {
        initComponents();
        setSize(535, 400);
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelUsuário = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jTextUsuario = new javax.swing.JTextField();
        jButtonSavar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TELA DE LOGIN");
        getContentPane().setLayout(null);

        jLabelUsuário.setText("Usuário");
        getContentPane().add(jLabelUsuário);
        jLabelUsuário.setBounds(160, 60, 110, 20);

        jLabelSenha.setText("Senha");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(160, 130, 70, 14);
        getContentPane().add(jPassword);
        jPassword.setBounds(160, 150, 150, 30);

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Administrador", "Professor", "Responsavel", "Aluno" }));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipo);
        jComboBoxTipo.setBounds(160, 210, 150, 30);
        getContentPane().add(jTextUsuario);
        jTextUsuario.setBounds(160, 90, 150, 30);

        jButtonSavar.setText("ENTRAR");
        jButtonSavar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSavar);
        jButtonSavar.setBounds(110, 290, 100, 23);

        jButtonLimpar.setText("LIMPAR");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar);
        jButtonLimpar.setBounds(240, 290, 100, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell1\\Desktop\\lib.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 520, 360);

        setBounds(9, 0, 538, 399);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSavarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavarActionPerformed
        String usuario, senha, tipo;

        if (jComboBoxTipo.getSelectedItem() == "Administrador") {
            if (jTextUsuario.getText().equals("admin") && jPassword.getText().equals("4dm1n")) {
                Principa tela = new Principa();
                tela.setVisible(true);
                
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha  incorretos");
            }

        } else {
            if (jComboBoxTipo.getSelectedItem() == "Aluno") {
                usuario = jTextUsuario.getText();
                senha = jPassword.getText();

                Aluno alunologin = new Aluno();
                alunologin.setMatricula(usuario);
                alunologin.setSenha(senha);
                DAOAluno objdaoA = new DAOAluno();
               v=objdaoA.login(alunologin);
                if(v=="aluno"){
                        retonetipo();
                        new Principa().setVisible(true);
                         dispose();
                } 

               

            } else {
                if (jComboBoxTipo.getSelectedItem() == "Responsavel") {
                    usuario = jTextUsuario.getText();
                    senha = jPassword.getText();
                    Responsavel objR = new Responsavel();
                    objR.setCpf(usuario);
                    objR.setSenha(senha);
                    DAOResponsavel objdaoR = new DAOResponsavel();
                    v=objdaoR.loginResponsavel(objR);
                    
                       if(v=="responsavel"){
                        retonetipo();
                        new Principa().setVisible(true);
                         dispose();
                        }
                  
                    
                  
                } else {
                    if (jComboBoxTipo.getSelectedItem() == "Professor") {

                        usuario = jTextUsuario.getText();
                        senha = jPassword.getText();
                        Professor objP = new Professor();
                        objP.setMatriculaProf(usuario);
                        objP.setSenhaProfessor(senha);
                        DAOProfessor objdaoP = new DAOProfessor();
                        //receber o valor de login
                        v=objdaoP.loginProfessor(objP);
                        System.out.println(v);
                        if(v=="professor"){
                        retonetipo();
                        new Principa().setVisible(true);
                        
                           dispose();
                        }

                     
                    } else 
                    {
                        JOptionPane.showMessageDialog(null,"Selecione o tipo");
                    }
                }
            }
        }
     
    }//GEN-LAST:event_jButtonSavarActionPerformed
 public String retonetipo(){
        String tipo=v;
        return tipo;
      
      }
    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextUsuario.setText(null);
        jPassword.setText(null);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed


    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSavar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuário;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}