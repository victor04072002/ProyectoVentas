/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controlador.ControladorLogin;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author moise
 */
public class VistaLogin extends javax.swing.JFrame {

    /**
     * Creates new form VistaLogin
     */
    public VistaLogin() {
        initComponents();
        setCustomIcon();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
     private void setCustomIcon() {
        // Cargar el icono desde el archivo .png en la carpeta 'img'
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/iconcerdo.png"));
        setIconImage(icon); // Establecer el icono de la ventana
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textLoginUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textLoginPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnLoginEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(120, 0, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lOGIN.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 210, 400));

        jPanel2.setBackground(new java.awt.Color(193, 18, 31));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIENVENIDO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 60));

        textLoginUsername.setBackground(new java.awt.Color(193, 18, 31));
        textLoginUsername.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        textLoginUsername.setForeground(new java.awt.Color(255, 255, 255));
        textLoginUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLoginUsernameActionPerformed(evt);
            }
        });
        bg.add(textLoginUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 180, 50));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("PASSWORD");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        textLoginPassword.setBackground(new java.awt.Color(193, 18, 31));
        textLoginPassword.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        textLoginPassword.setForeground(new java.awt.Color(255, 255, 255));
        textLoginPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLoginPasswordActionPerformed(evt);
            }
        });
        textLoginPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textLoginPasswordKeyPressed(evt);
            }
        });
        bg.add(textLoginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 180, 50));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("USER");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        btnLoginEntrar.setBackground(new java.awt.Color(193, 18, 31));
        btnLoginEntrar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnLoginEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginEntrar.setText("INICIA SESION");
        btnLoginEntrar.setBorder(null);
        btnLoginEntrar.setBorderPainted(false);
        btnLoginEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoginEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEntrarActionPerformed(evt);
            }
        });
        bg.add(btnLoginEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textLoginPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLoginPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLoginPasswordActionPerformed

    private void btnLoginEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEntrarActionPerformed
        // TODO add your handling code here:
        ControladorLogin.login();
    }//GEN-LAST:event_btnLoginEntrarActionPerformed

    private void textLoginUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLoginUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLoginUsernameActionPerformed

    private void textLoginPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textLoginPasswordKeyPressed
        if(KeyEvent.VK_ENTER==evt.getKeyCode()){
            ControladorLogin.login();
        }
    }//GEN-LAST:event_textLoginPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    public JPasswordField getTextLoginPassword() {
        return textLoginPassword;
    }

    public JTextField getTextLoginUsername() {
        return textLoginUsername;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnLoginEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField textLoginPassword;
    private javax.swing.JTextField textLoginUsername;
    // End of variables declaration//GEN-END:variables
}
