/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendaescolar.interfaces;

/**
 *
 * @author dell1
 */
public class Principa extends javax.swing.JFrame {

    /**
     * Creates new form Principa
     */
    public Principa() {
        initComponents();
       // setSize(1000, 1000);
        Login objlogin= new Login();
        String t=objlogin.retonetipo();
        if(t=="professor"){
           jMenu1.enable(false);
           jMenu12.enable(false);
           jMenuAlterar.enable(false);
           jVisualizarAgenda.enable(false);
        }
        else
            if(t=="responsavel"){
                jMenu1.enable(false);
                jMenuAlterar.enable(false);
                jVisualizarAgenda.enable(false);
                jMenu16.enable(false);
            }
            else 
                if(t=="aluno"){
                jMenu1.enable(false);
                jMenuAlterar.enable(false);
                jMenu16.enable(false);
                jMenu12.enable(false);
                }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jdpPrincipal = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jAluno = new javax.swing.JMenuItem();
        jResponsavel = new javax.swing.JMenuItem();
        jProfessor = new javax.swing.JMenuItem();
        jTurma = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jRelacionarProfessor = new javax.swing.JMenuItem();
        jRelacionar = new javax.swing.JMenuItem();
        jMenuAlterar = new javax.swing.JMenu();
        jAlterarAluno = new javax.swing.JMenuItem();
        jAlterarResponsavel = new javax.swing.JMenuItem();
        jAlteraProfessor = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jTela1 = new javax.swing.JMenuItem();
        jMenuItemVisualizar = new javax.swing.JMenuItem();
        jVisualizarAgenda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jCadastrarObser = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu8.setText("jMenu8");

        jMenu9.setText("jMenu9");

        jMenu10.setText("jMenu10");

        jMenu11.setText("jMenu11");

        jMenu13.setText("jMenu13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpPrincipal.add(jLabel2);
        jLabel2.setBounds(1483, 146, 0, 0);

        jLabel1.setText("jLabel1");
        jdpPrincipal.add(jLabel1);
        jLabel1.setBounds(430, 734, 34, 14);
        jdpPrincipal.add(jLabel4);
        jLabel4.setBounds(670, 140, 34, 14);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agendaescolar/imagens/ghf.png"))); // NOI18N
        jdpPrincipal.add(jLabel3);
        jLabel3.setBounds(180, -30, 1030, 770);

        jMenu1.setText("Cadastro");
        jMenu1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jMenu1StateChanged(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jAluno.setText("Aluno");
        jAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(jAluno);

        jResponsavel.setText("Responsavel");
        jResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResponsavelActionPerformed(evt);
            }
        });
        jMenu1.add(jResponsavel);

        jProfessor.setText("Professor");
        jProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProfessorActionPerformed(evt);
            }
        });
        jMenu1.add(jProfessor);

        jTurma.setText("Turma");
        jTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTurmaActionPerformed(evt);
            }
        });
        jMenu1.add(jTurma);

        jMenuItem2.setText("Relacionar Professor e Turma");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jRelacionarProfessor.setText("Relacionar Aluno e Turma");
        jRelacionarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelacionarProfessorActionPerformed(evt);
            }
        });
        jMenu1.add(jRelacionarProfessor);

        jRelacionar.setText("Relacionar Aluno e Responsavel");
        jRelacionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelacionarActionPerformed(evt);
            }
        });
        jMenu1.add(jRelacionar);

        jMenuBar1.add(jMenu1);

        jMenuAlterar.setText("Alterar");

        jAlterarAluno.setText("Aluno");
        jAlterarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarAlunoActionPerformed(evt);
            }
        });
        jMenuAlterar.add(jAlterarAluno);

        jAlterarResponsavel.setText("Responsavel");
        jAlterarResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarResponsavelActionPerformed(evt);
            }
        });
        jMenuAlterar.add(jAlterarResponsavel);

        jAlteraProfessor.setText("Professor");
        jAlteraProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlteraProfessorActionPerformed(evt);
            }
        });
        jMenuAlterar.add(jAlteraProfessor);

        jMenuBar1.add(jMenuAlterar);

        jMenu12.setText("Responsavel");

        jTela1.setText("Criar Anotação");
        jTela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTela1ActionPerformed(evt);
            }
        });
        jMenu12.add(jTela1);

        jMenuItemVisualizar.setText("Visualizar Agenda");
        jMenuItemVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVisualizarActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItemVisualizar);

        jMenuBar1.add(jMenu12);

        jVisualizarAgenda.setText("Aluno");
        jVisualizarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVisualizarAgendaActionPerformed(evt);
            }
        });

        jMenuItem3.setText("VisualizarAgenda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jVisualizarAgenda.add(jMenuItem3);

        jMenuBar1.add(jVisualizarAgenda);

        jMenu16.setText("Professor");

        jMenuItem4.setText("Criar Atividade");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem4);

        jCadastrarObser.setText("Criar Observação");
        jCadastrarObser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarObserActionPerformed(evt);
            }
        });
        jMenu16.add(jCadastrarObser);

        jMenuBar1.add(jMenu16);

        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdpPrincipal)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1131, 713));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jRelacionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelacionarActionPerformed
        Relacionar obj3= new  Relacionar();
        jdpPrincipal.add(obj3);
        obj3.setVisible(true);
    }//GEN-LAST:event_jRelacionarActionPerformed

    private void jProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProfessorActionPerformed
        CadastrarProfessor obj2=  new CadastrarProfessor ();
        jdpPrincipal.add(obj2);
        obj2.setVisible(true);
    }//GEN-LAST:event_jProfessorActionPerformed

    private void jResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResponsavelActionPerformed
        CadastrarResponsavel obj1=  new CadastrarResponsavel ();
        jdpPrincipal.add(obj1);
        obj1.setVisible(true);
    }//GEN-LAST:event_jResponsavelActionPerformed

    private void jAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlunoActionPerformed
        CadastrarA obj=  new CadastrarA ();
        jdpPrincipal.add(obj);
        obj.setVisible(true);

    }//GEN-LAST:event_jAlunoActionPerformed

    private void jRelacionarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelacionarProfessorActionPerformed
         RelacionarTurmaAluno obj4= new RelacionarTurmaAluno();
         jdpPrincipal.add(obj4);
         obj4.setVisible(true);
    }//GEN-LAST:event_jRelacionarProfessorActionPerformed

    private void jAlterarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarAlunoActionPerformed
       AlterarAluno obj6= new AlterarAluno();
       jdpPrincipal.add(obj6);
       obj6.setVisible(true);
       
    }//GEN-LAST:event_jAlterarAlunoActionPerformed

    private void jAlterarResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarResponsavelActionPerformed
        AlterarResponsavel obj7= new AlterarResponsavel();
        jdpPrincipal.add(obj7);
        obj7.setVisible(true);
    }//GEN-LAST:event_jAlterarResponsavelActionPerformed

    private void jAlteraProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlteraProfessorActionPerformed
        AlterarProfessor obj8= new AlterarProfessor();
        jdpPrincipal.add(obj8);
        obj8.setVisible(true);
    }//GEN-LAST:event_jAlteraProfessorActionPerformed

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        Login ob =  new Login();
       ob.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jTela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTela1ActionPerformed
      ResponsavelTela objg= new ResponsavelTela();
      jdpPrincipal.add(objg);
      objg.setVisible(true);
     
    }//GEN-LAST:event_jTela1ActionPerformed

    private void jTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTurmaActionPerformed
       CadastrarTurma objt= new CadastrarTurma();
       jdpPrincipal.add(objt);
       objt.setVisible(true);
    
    }//GEN-LAST:event_jTurmaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       RelacionarTurmareProfessor objturma= new RelacionarTurmareProfessor();
       jdpPrincipal.add(objturma);
       objturma.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jVisualizarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVisualizarAgendaActionPerformed
            
                     
    }//GEN-LAST:event_jVisualizarAgendaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        AlunoTela objAluno= new AlunoTela();
             jdpPrincipal.add(objAluno);
             objAluno.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      ProfessorTela objpt= new ProfessorTela();
      jdpPrincipal.add(objpt);
      objpt.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMenu1StateChanged
  
    }//GEN-LAST:event_jMenu1StateChanged

    private void jCadastrarObserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarObserActionPerformed
      ProfessorObservação objto= new ProfessorObservação();
      jdpPrincipal.add(objto);
      objto.setVisible(true);
    }//GEN-LAST:event_jCadastrarObserActionPerformed

    private void jMenuItemVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVisualizarActionPerformed
       ResponsavelAgenda objag= new ResponsavelAgenda();
       jdpPrincipal.add(objag);
       objag.setVisible(true);
    }//GEN-LAST:event_jMenuItemVisualizarActionPerformed

  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principa().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAlteraProfessor;
    private javax.swing.JMenuItem jAlterarAluno;
    private javax.swing.JMenuItem jAlterarResponsavel;
    private javax.swing.JMenuItem jAluno;
    private javax.swing.JMenuItem jCadastrarObser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenu jMenuAlterar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemVisualizar;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenuItem jProfessor;
    private javax.swing.JMenuItem jRelacionar;
    private javax.swing.JMenuItem jRelacionarProfessor;
    private javax.swing.JMenuItem jResponsavel;
    private javax.swing.JMenuItem jTela1;
    private javax.swing.JMenuItem jTurma;
    private javax.swing.JMenu jVisualizarAgenda;
    private javax.swing.JDesktopPane jdpPrincipal;
    // End of variables declaration//GEN-END:variables
}