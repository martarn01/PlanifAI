package com.planifai.view;

import com.planifai.service.AulaService;
import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author marta
 */
public class MenuGestionAulaView extends javax.swing.JFrame {

    Color colorHover;
    Color color;
    AulaService databaseService;

    public MenuGestionAulaView() {
        initComponents();

        colorHover = new Color(102, 102, 102);
        color = new Color(51, 51, 51);

        databaseService = new AulaService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuDesplegable = new javax.swing.JPanel();
        editarPanel = new javax.swing.JPanel();
        editarText = new javax.swing.JLabel();
        eliminarPanel = new javax.swing.JPanel();
        eliminarText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        menuDesplegable.setBackground(new java.awt.Color(51, 51, 51));

        editarPanel.setBackground(new java.awt.Color(51, 51, 51));
        editarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editarPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editarPanelMouseExited(evt);
            }
        });

        editarText.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        editarText.setForeground(new java.awt.Color(255, 255, 255));
        editarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarText.setText("Editar");

        javax.swing.GroupLayout editarPanelLayout = new javax.swing.GroupLayout(editarPanel);
        editarPanel.setLayout(editarPanelLayout);
        editarPanelLayout.setHorizontalGroup(
            editarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPanelLayout.createSequentialGroup()
                .addComponent(editarText, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        editarPanelLayout.setVerticalGroup(
            editarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPanelLayout.createSequentialGroup()
                .addComponent(editarText, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        eliminarPanel.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarPanelMouseExited(evt);
            }
        });

        eliminarText.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        eliminarText.setForeground(new java.awt.Color(255, 255, 255));
        eliminarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarText.setText("Eliminar");

        javax.swing.GroupLayout eliminarPanelLayout = new javax.swing.GroupLayout(eliminarPanel);
        eliminarPanel.setLayout(eliminarPanelLayout);
        eliminarPanelLayout.setHorizontalGroup(
            eliminarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(eliminarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(eliminarText, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
        );
        eliminarPanelLayout.setVerticalGroup(
            eliminarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
            .addGroup(eliminarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(eliminarPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(eliminarText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout menuDesplegableLayout = new javax.swing.GroupLayout(menuDesplegable);
        menuDesplegable.setLayout(menuDesplegableLayout);
        menuDesplegableLayout.setHorizontalGroup(
            menuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eliminarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuDesplegableLayout.setVerticalGroup(
            menuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDesplegableLayout.createSequentialGroup()
                .addComponent(editarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuDesplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuDesplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarPanelMouseEntered
        editarPanel.setBackground(colorHover);
        editarPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));    }//GEN-LAST:event_editarPanelMouseEntered

    private void editarPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarPanelMouseExited
        editarPanel.setBackground(color);
        editarPanel.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_editarPanelMouseExited

    private void editarPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarPanelMouseClicked

    }//GEN-LAST:event_editarPanelMouseClicked

    private void eliminarPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarPanelMouseEntered
        eliminarPanel.setBackground(colorHover);
        eliminarPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_eliminarPanelMouseEntered

    private void eliminarPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarPanelMouseExited
        eliminarPanel.setBackground(color);
        eliminarPanel.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_eliminarPanelMouseExited

    private void eliminarPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarPanelMouseClicked

    }//GEN-LAST:event_eliminarPanelMouseClicked

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
            java.util.logging.Logger.getLogger(MenuGestionAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGestionAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGestionAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGestionAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGestionAulaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editarPanel;
    private javax.swing.JLabel editarText;
    private javax.swing.JPanel eliminarPanel;
    private javax.swing.JLabel eliminarText;
    private javax.swing.JPanel menuDesplegable;
    // End of variables declaration//GEN-END:variables
}
