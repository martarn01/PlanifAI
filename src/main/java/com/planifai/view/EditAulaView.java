package com.planifai.view;

import com.planifai.controller.AulaController;
import com.planifai.service.AulaService;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import com.planifai.interfaces.AulaListener;
import com.planifai.model.Aula;

/**
 *
 * @author Marta Rosado Nabais
 */
public class EditAulaView extends javax.swing.JFrame {

    private AulaService aulaService;
    private AulaController aulaController;
    private Aula aulaToEdit;

    private AulaListener aulaListener;

    public EditAulaView(AulaController aulaController, Aula aulaToEdit,  AulaListener aulaListener) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.aulaService = new AulaService();
        this.aulaController = aulaController;
        this.aulaToEdit = aulaToEdit;
        this.aulaListener = aulaListener; // Inicializa el aulaListener

        setAulaData();
    }

    public EditAulaView() {
    }

    private void setAulaData() {
        if (aulaToEdit != null) {
            nombreField.setText(aulaToEdit.getNombre());
            asignaturaField.setText(aulaToEdit.getAsignatura());
            title.setText("Editar Aula"); // Cambia el título del frame
        }
    }

    /**
     * Establece el listener que será notificado cuando se añada un aula.
     *
     * @param listener El listener a establecer.
     */
    public void setAulaAddedListener(AulaListener listener) {
        this.aulaListener = listener;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nombreText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        asignaturaText = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        asignaturaField = new javax.swing.JTextField();
        nombreField = new javax.swing.JTextField();
        addClassButton = new javax.swing.JPanel();
        addAulaText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setName("edittext"); // NOI18N

        title.setFont(new java.awt.Font("Lato Semibold", 0, 22)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Nueva aula");

        nombreText.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        nombreText.setText("Nombre aula");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 3));

        asignaturaText.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        asignaturaText.setText("Asignatura");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 3));

        asignaturaField.setBackground(new java.awt.Color(255, 255, 255));
        asignaturaField.setBorder(null);

        nombreField.setBackground(new java.awt.Color(255, 255, 255));
        nombreField.setBorder(null);

        addClassButton.setBackground(new java.awt.Color(51, 51, 51));
        addClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addClassButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addClassButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addClassButtonMouseExited(evt);
            }
        });

        addAulaText.setFont(new java.awt.Font("Lato Semibold", 1, 14)); // NOI18N
        addAulaText.setForeground(new java.awt.Color(255, 255, 255));
        addAulaText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addAulaText.setText("Guardar");

        javax.swing.GroupLayout addClassButtonLayout = new javax.swing.GroupLayout(addClassButton);
        addClassButton.setLayout(addClassButtonLayout);
        addClassButtonLayout.setHorizontalGroup(
            addClassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addClassButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAulaText, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );
        addClassButtonLayout.setVerticalGroup(
            addClassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClassButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAulaText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(asignaturaText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addComponent(asignaturaField)
                        .addComponent(nombreField))
                    .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(title)
                .addGap(20, 20, 20)
                .addComponent(nombreText)
                .addGap(4, 4, 4)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(asignaturaText)
                .addGap(18, 18, 18)
                .addComponent(asignaturaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón para añadir un aula. Valida que los
     * campos no estén vacíos y, si es así, llama al servicio para guardar el
     * aula y notifica al listener.
     *
     * @param evt El evento de mouse que desencadenó el clic.
     */
    private void addClassButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClassButtonMouseClicked

        String nombre = nombreField.getText();
        String asignatura = asignaturaField.getText();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || asignatura.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Llamar al método de servicio para actualizar el aula
        aulaService.actualizarAula(aulaToEdit.getIdAula(), nombre, asignatura);
        JOptionPane.showMessageDialog(this, "Aula actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        aulaListener.onAulaChanged();

        dispose();
    }//GEN-LAST:event_addClassButtonMouseClicked

    private void addClassButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClassButtonMouseEntered
        Color customColor = new Color(51, 51, 51);
        addClassButton.setBackground(Color.white);
        addAulaText.setForeground(customColor);
        addClassButton.setBorder(LineBorder.createBlackLineBorder());
    }//GEN-LAST:event_addClassButtonMouseEntered

    private void addClassButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClassButtonMouseExited
        Color customColor = new Color(51, 51, 51);
        addClassButton.setBackground(customColor);
        addAulaText.setForeground(Color.white);
    }//GEN-LAST:event_addClassButtonMouseExited

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
            java.util.logging.Logger.getLogger(EditAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditAulaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addAulaText;
    private javax.swing.JPanel addClassButton;
    private javax.swing.JTextField asignaturaField;
    private javax.swing.JLabel asignaturaText;
    private javax.swing.JPanel background;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreText;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}