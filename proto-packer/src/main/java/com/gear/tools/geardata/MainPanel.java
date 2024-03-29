/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author lizhixiong
 */
public class MainPanel extends javax.swing.JFrame {

    /**
     * Creates new form MainPanelNew
     */
    public MainPanel() {
        initComponents();
        initComponentsValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfInPath = new javax.swing.JTextField();
        tfEnvironment = new javax.swing.JTextField();
        tfOutPath = new javax.swing.JTextField();
        rdoJava = new javax.swing.JRadioButton();
        rdoCsharp = new javax.swing.JRadioButton();
        rdoLua = new javax.swing.JRadioButton();
        rdoRemember = new javax.swing.JRadioButton();
        btnOutCodePath = new javax.swing.JButton();
        btnEnvironment = new javax.swing.JButton();
        btnInPath = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfClassPath = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 300));
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("目标语言");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("输入路径");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("输出路径");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("环境变量");

        tfInPath.setName("inputPath"); // NOI18N

        tfEnvironment.setName("envPath"); // NOI18N

        tfOutPath.setName("outPath"); // NOI18N

        buttonGroup1.add(rdoJava);
        rdoJava.setText("java");
        rdoJava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoJavaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoCsharp);
        rdoCsharp.setText("C#");
        rdoCsharp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCsharpActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoLua);
        rdoLua.setText("lua");
        rdoLua.setToolTipText("暂时不支持lua代码生成");
        rdoLua.setEnabled(false);
        rdoLua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLuaActionPerformed(evt);
            }
        });

        rdoRemember.setSelected(true);
        rdoRemember.setText("记住");
        rdoRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoRememberActionPerformed(evt);
            }
        });

        btnOutCodePath.setText("...");
        btnOutCodePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutCodePathActionPerformed(evt);
            }
        });

        btnEnvironment.setText("...");
        btnEnvironment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvironmentActionPerformed(evt);
            }
        });

        btnInPath.setText("...");
        btnInPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPathActionPerformed(evt);
            }
        });

        btnGenerate.setText("开始生成");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("类路径");

        tfClassPath.setName("inputPath"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gear Proto");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfClassPath, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfInPath, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInPath, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfOutPath, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOutCodePath, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(rdoJava)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdoCsharp)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdoLua)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdoRemember))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(tfEnvironment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEnvironment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoJava)
                    .addComponent(rdoCsharp)
                    .addComponent(rdoLua)
                    .addComponent(jLabel1)
                    .addComponent(rdoRemember))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEnvironment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnvironment, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfClassPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfOutPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOutCodePath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoRememberActionPerformed
        javax.swing.JRadioButton btn = (javax.swing.JRadioButton) evt.getSource();
        setting.setAutoRemember(btn.isSelected());
    }//GEN-LAST:event_rdoRememberActionPerformed

    private void btnInPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPathActionPerformed
        selectPathForTextField(tfInPath);
    }//GEN-LAST:event_btnInPathActionPerformed

    private void btnOutCodePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutCodePathActionPerformed
        selectPathForTextField(tfOutPath);
    }//GEN-LAST:event_btnOutCodePathActionPerformed

    private void rdoJavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoJavaActionPerformed
        javax.swing.JRadioButton btn = (javax.swing.JRadioButton) evt.getSource();
        if (btn.isSelected()) {
            setting.setPlatform(0);
        }
    }//GEN-LAST:event_rdoJavaActionPerformed

    private void rdoCsharpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCsharpActionPerformed
        javax.swing.JRadioButton btn = (javax.swing.JRadioButton) evt.getSource();
        if (btn.isSelected()) {
            setting.setPlatform(1);
        }
    }//GEN-LAST:event_rdoCsharpActionPerformed

    private void rdoLuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLuaActionPerformed
        javax.swing.JRadioButton btn = (javax.swing.JRadioButton) evt.getSource();
        if (btn.isSelected()) {
            setting.setPlatform(2);
        }
    }//GEN-LAST:event_rdoLuaActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed

        setting.Save(this);
        if (!setting.CheckAllPath()) {
            return;
        }

        new Pipeline(setting).start();
        this.btnGenerate.setEnabled(false);
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnEnvironmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvironmentActionPerformed
        selectPathForTextField(tfEnvironment);
    }//GEN-LAST:event_btnEnvironmentActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnvironment;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnInPath;
    private javax.swing.JButton btnOutCodePath;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoCsharp;
    private javax.swing.JRadioButton rdoJava;
    private javax.swing.JRadioButton rdoLua;
    private javax.swing.JRadioButton rdoRemember;
    private javax.swing.JTextField tfClassPath;
    private javax.swing.JTextField tfEnvironment;
    private javax.swing.JTextField tfInPath;
    private javax.swing.JTextField tfOutPath;
    // End of variables declaration//GEN-END:variables

    private Settings setting;
    private static MainPanel sInstance;

    public static MainPanel GetInstance() {
        if (sInstance == null) {
            sInstance = new MainPanel();
        }
        return sInstance;
    }

    private void initComponentsValue() {
        if (setting == null) {
            setting = new Settings();
        }

        switch (setting.getPlatform()) {
            case 0:
                this.rdoJava.setSelected(true);
                break;
            case 1:
                this.rdoCsharp.setSelected(true);
                break;
            case 2:
                this.rdoLua.setSelected(true);
                break;
        }
        this.tfEnvironment.setText(setting.getEnvironmentPath());
        this.tfClassPath.setText(setting.getClassPath());
        this.tfInPath.setText(setting.getInputPath());
        this.tfOutPath.setText(setting.getOutPath());
        this.rdoRemember.setSelected(setting.getAutoRemember());
    }

    private void selectPathForTextField(JTextField field) {
        JFileChooser fd = new JFileChooser();
        fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fd.showOpenDialog(null);
        File f = fd.getSelectedFile();
        if (f != null) {
            String fieldText = f.getAbsolutePath();
            field.setText(fieldText);
        }
    }

    public String getEnvironmentPath() {
        return this.tfEnvironment.getText();
    }

    public String getClassPath() {
        return this.tfClassPath.getText();
    }

    public String getInputPath() {
        return this.tfInPath.getText();
    }

    public String getOutPath() {
        return this.tfOutPath.getText();
    }

    public void onComplete() {
        JOptionPane.showMessageDialog(null, "完成!");
        Runtime.getRuntime().exit(0);
    }
}
