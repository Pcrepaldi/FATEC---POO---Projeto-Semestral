/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ExercicioDAO;
import dao.TreinoDAO;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.Exercicio;
import model.Treino;

/**
 *
 * @author lubuntu
 */
public class Cad_Treino extends javax.swing.JFrame {

    /**
     * Creates new form Cad_Usuario
     */

    public Cad_Treino() {
        initComponents();
        carregarExercicios();
    }
    
    public void limpar(){
        jTextFieldNome_Treino.setText(null);
        jTextAreaObjetivo.setText(null);
        jComboBoxExercicios.setSelectedIndex(0);
        modelo.setRowCount(0);
    }
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public void carregarExercicios(){
        
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        
        ExercicioDAO eDAO = new ExercicioDAO();
        ArrayList<Exercicio> lista = eDAO.consultarExercicio();
        
        for(int i=0; i<lista.size(); i++){
            jComboBoxExercicios.addItem(lista.get(i).getNomeEx());      
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

        jPanelWrapper = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome_Treino = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObjetivo = new javax.swing.JTextArea();
        jComboBoxExercicios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonAdicionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonRemover = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemInicio = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuCad_Aluno = new javax.swing.JMenuItem();
        jMenuCons_Aluno = new javax.swing.JMenuItem();
        jMenuCons_Aluno1 = new javax.swing.JMenuItem();
        jMenuAlt_Aluno = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuCad_Professor = new javax.swing.JMenuItem();
        jMenuCons_Professor1 = new javax.swing.JMenuItem();
        jMenuCons_Endereco_Prof = new javax.swing.JMenuItem();
        jMenuAlt_Professor = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuCad_Exercicio = new javax.swing.JMenuItem();
        jMenuCons_Exercicio = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuMontar_Treino = new javax.swing.JMenuItem();
        jMenuItemCons_Alt_Exc_Treino = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuItemLogOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GymManager - Cadastro Treino");
        setResizable(false);

        jPanelWrapper.setBackground(new java.awt.Color(255, 255, 255));

        jPanelHeader.setBackground(new java.awt.Color(2, 1, 24));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Treino");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Informações do Treino", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 20))); // NOI18N
        jPanel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setText("Nome do Treino");

        jTextFieldNome_Treino.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jTextFieldNome_Treino.setForeground(new java.awt.Color(91, 95, 99));
        jTextFieldNome_Treino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNome_TreinoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNome_TreinoFocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel13.setText("Objetivo");

        jButtonCadastrar.setBackground(new java.awt.Color(103, 247, 92));
        jButtonCadastrar.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCadastrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCadastrarMouseEntered(evt);
            }
        });
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jTextAreaObjetivo.setColumns(20);
        jTextAreaObjetivo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextAreaObjetivo.setLineWrap(true);
        jTextAreaObjetivo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObjetivo);

        jComboBoxExercicios.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxExercicios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel3.setText("Exercicios");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel4.setText("Treino");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Exercício"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(205, 225, 243));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jButtonRemover.setText("Remover Exercício");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome_Treino)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jComboBoxExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonCadastrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(128, 128, 128)))
                    .addComponent(jButtonRemover))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxExercicios)
                    .addComponent(jTextFieldNome_Treino, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelWrapperLayout = new javax.swing.GroupLayout(jPanelWrapper);
        jPanelWrapper.setLayout(jPanelWrapperLayout);
        jPanelWrapperLayout.setHorizontalGroup(
            jPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelWrapperLayout.setVerticalGroup(
            jPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWrapperLayout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Sistema");

        jMenuItemInicio.setText("Início");
        jMenuItemInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInicioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemInicio);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Aluno");

        jMenuCad_Aluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuCad_Aluno.setText("Cadastro");
        jMenuCad_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCad_AlunoActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuCad_Aluno);

        jMenuCons_Aluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuCons_Aluno.setText("Consulta Status");
        jMenuCons_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCons_AlunoActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuCons_Aluno);

        jMenuCons_Aluno1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuCons_Aluno1.setText("Consulta Endereço");
        jMenuCons_Aluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCons_Aluno1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuCons_Aluno1);

        jMenuAlt_Aluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuAlt_Aluno.setText("Alterar/Excluir");
        jMenuAlt_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAlt_AlunoActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuAlt_Aluno);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Professor");

        jMenuCad_Professor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuCad_Professor.setText("Cadastro");
        jMenuCad_Professor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCad_ProfessorActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuCad_Professor);

        jMenuCons_Professor1.setText("Consulta Informações Adicionais");
        jMenuCons_Professor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCons_Professor1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuCons_Professor1);

        jMenuCons_Endereco_Prof.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuCons_Endereco_Prof.setText("Consulta Endereço");
        jMenuCons_Endereco_Prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCons_Endereco_ProfActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuCons_Endereco_Prof);

        jMenuAlt_Professor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuAlt_Professor.setText("Alterar/Excluir");
        jMenuAlt_Professor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAlt_ProfessorActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuAlt_Professor);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Exercício");

        jMenuCad_Exercicio.setText("Cadastro");
        jMenuCad_Exercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCad_ExercicioActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuCad_Exercicio);

        jMenuCons_Exercicio.setText("Consultar/Alterar/Excluir");
        jMenuCons_Exercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCons_ExercicioActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuCons_Exercicio);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Treino");

        jMenuMontar_Treino.setText("Montar Treino");
        jMenuMontar_Treino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMontar_TreinoActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuMontar_Treino);

        jMenuItemCons_Alt_Exc_Treino.setText("Consulta/Alterar/Excluir");
        jMenuItemCons_Alt_Exc_Treino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCons_Alt_Exc_TreinoActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemCons_Alt_Exc_Treino);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Opções");

        jMenuItemSair.setText("Sair do Sistema");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSair);

        jMenuItemLogOut.setText("Sair do Perfil");
        jMenuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogOutActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemLogOut);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
       
        TreinoDAO tDAO = new TreinoDAO();
        Treino treino = new Treino();
        
        String nomeTreino = jTextFieldNome_Treino.getText();
        String objetivo = jTextAreaObjetivo.getText();
        
        treino.setNome(nomeTreino);
        treino.setObjetivo(objetivo);

        try {
            tDAO.inserirTreino(treino);
        } catch (ParseException ex) {
            Logger.getLogger(Cad_Treino.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i=0; i<jTable1.getRowCount(); i++){
            tDAO.inserirExercicioTreino(Integer.parseInt(jTable1.getValueAt(i, 0).toString()));
        }
  
        limpar();
        
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jTextFieldNome_TreinoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNome_TreinoFocusGained
        jTextFieldNome_Treino.setBorder(new LineBorder(new Color(70,130,180), 2));
    }//GEN-LAST:event_jTextFieldNome_TreinoFocusGained

    private void jTextFieldNome_TreinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNome_TreinoFocusLost
        jTextFieldNome_Treino.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
    }//GEN-LAST:event_jTextFieldNome_TreinoFocusLost

    private void jButtonCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCadastrarMouseEntered
        jButtonCadastrar.setForeground(new Color(58,65,84));
        jButtonCadastrar.setBackground(Color.WHITE);
    }//GEN-LAST:event_jButtonCadastrarMouseEntered

    private void jButtonCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCadastrarMouseExited
        jButtonCadastrar.setForeground(new Color(51, 51, 51));
        jButtonCadastrar.setBackground(new Color(103,247,92));
    }//GEN-LAST:event_jButtonCadastrarMouseExited

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        String exercicio = String.valueOf(jComboBoxExercicios.getSelectedItem());
        
        ExercicioDAO eDAO = new ExercicioDAO();
        ArrayList<Exercicio> lista = eDAO.consultarExercicioPersonalizada("nome", exercicio);

        int verificador = 0;
        
        // VERIFICANDO SE O EXERCICIO JA EXISTE NA TABELA
        for(int i=0; i<jTable1.getRowCount(); i++){
            String exerc = String.valueOf(jTable1.getValueAt(i, 1));
            String combo = String.valueOf(jComboBoxExercicios.getSelectedItem());
            
            if(exerc.equals(combo)){
                //System.out.println("["+i+"] Valor já inserido");
                verificador = 1;
            }
        }

        if(verificador == 0){
            // Adiciona o valor do jcombo na tabela
            for(int i=0; i<lista.size(); i++){
                modelo.addRow(new Object[]{
                    lista.get(i).getCod_exerc(),    
                    lista.get(i).getNomeEx(),    
                    });
            }
        }else{
            JOptionPane.showMessageDialog(null, "Exercício já inserido.");
        }
        
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        
        int row = jTable1.getSelectedRow();
        
        modelo = (DefaultTableModel) jTable1.getModel();
        if(jTable1.getSelectedRow() >= 0){
            modelo.removeRow(row);
            jTable1.setModel(modelo);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para remover!");
        }
        
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jMenuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInicioActionPerformed
        dispose();
        Tela_Inicio x = new Tela_Inicio();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItemInicioActionPerformed

    private void jMenuCad_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCad_AlunoActionPerformed
        Cad_Aluno_1 cad = new Cad_Aluno_1();
        cad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCad_AlunoActionPerformed

    private void jMenuCons_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCons_AlunoActionPerformed
        Cons_Status_Aluno c = new Cons_Status_Aluno();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCons_AlunoActionPerformed

    private void jMenuCons_Aluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCons_Aluno1ActionPerformed
        Cons_Endereco_Aluno c = new Cons_Endereco_Aluno();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCons_Aluno1ActionPerformed

    private void jMenuAlt_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAlt_AlunoActionPerformed
        Alterar_Excluir_Aluno a = new Alterar_Excluir_Aluno();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuAlt_AlunoActionPerformed

    private void jMenuCad_ProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCad_ProfessorActionPerformed
        Cad_Professor_1 cad = new Cad_Professor_1();
        cad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCad_ProfessorActionPerformed

    private void jMenuCons_Professor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCons_Professor1ActionPerformed
        Cons_InfoAdicionais_Professor c = new Cons_InfoAdicionais_Professor();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCons_Professor1ActionPerformed

    private void jMenuCons_Endereco_ProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCons_Endereco_ProfActionPerformed
        Cons_Endereco_Professor c = new Cons_Endereco_Professor();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCons_Endereco_ProfActionPerformed

    private void jMenuAlt_ProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAlt_ProfessorActionPerformed
        Alterar_Excluir_Professor a = new Alterar_Excluir_Professor();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuAlt_ProfessorActionPerformed

    private void jMenuCad_ExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCad_ExercicioActionPerformed
        Cad_Exercicio cad = new Cad_Exercicio();
        cad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCad_ExercicioActionPerformed

    private void jMenuCons_ExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCons_ExercicioActionPerformed
        Consultar_Alterar_Excluir_Exercicios c = new Consultar_Alterar_Excluir_Exercicios();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuCons_ExercicioActionPerformed

    private void jMenuMontar_TreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMontar_TreinoActionPerformed
        Cad_Treino cad = new Cad_Treino();
        cad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuMontar_TreinoActionPerformed

    private void jMenuItemCons_Alt_Exc_TreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCons_Alt_Exc_TreinoActionPerformed
        Consultar_Alterar_Excluir_Treino c = new Consultar_Alterar_Excluir_Treino();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemCons_Alt_Exc_TreinoActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        Object[] botoes = { "Não", "Sim" };
        int resposta = JOptionPane.showOptionDialog(null,
            "Deseja sair do sistema?", // mensagem para o usuário
            "Confirmação", // o título da janela
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            botoes, botoes[1]);

        if(resposta == 1){
            System.out.println("Saindo do sistema...");
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        Object[] botoes = { "Não", "Sim" };
        int resposta = JOptionPane.showOptionDialog(null,
            "Deseja sair do perfil?", // mensagem para o usuário
            "Confirmação", // o título da janela
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            botoes, botoes[1]);

        if(resposta == 1){
            System.out.println("Saindo do perfil...");
            dispose();
            Tela_Login x = new Tela_Login();
            x.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItemLogOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cad_Treino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cad_Treino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cad_Treino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cad_Treino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Treino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox<String> jComboBoxExercicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuAlt_Aluno;
    private javax.swing.JMenuItem jMenuAlt_Professor;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCad_Aluno;
    private javax.swing.JMenuItem jMenuCad_Exercicio;
    private javax.swing.JMenuItem jMenuCad_Professor;
    private javax.swing.JMenuItem jMenuCons_Aluno;
    private javax.swing.JMenuItem jMenuCons_Aluno1;
    private javax.swing.JMenuItem jMenuCons_Endereco_Prof;
    private javax.swing.JMenuItem jMenuCons_Exercicio;
    private javax.swing.JMenuItem jMenuCons_Professor1;
    private javax.swing.JMenuItem jMenuItemCons_Alt_Exc_Treino;
    private javax.swing.JMenuItem jMenuItemInicio;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuMontar_Treino;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelWrapper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaObjetivo;
    private javax.swing.JTextField jTextFieldNome_Treino;
    // End of variables declaration//GEN-END:variables
}