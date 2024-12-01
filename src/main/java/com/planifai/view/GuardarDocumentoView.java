package com.planifai.view;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa la vista para guardar un documento. Permite al usuario
 * ingresar el nombre del documento, seleccionar su formato (PDF o TXT) y
 * guardar el archivo en la ubicación elegida.
 *
 * @author Marta Rosado Nabais
 */
public class GuardarDocumentoView extends javax.swing.JFrame {

    private String text;

    /**
     * Constructor de la vista para guardar un documento. Inicializa los
     * componentes de la interfaz y establece el contenido del documento.
     *
     * @param text El contenido del documento a guardar.
     */
    public GuardarDocumentoView(String text) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.text = text;
    }

    /**
     * Constructor por defecto. Inicializa los componentes de la interfaz sin un
     * contenido de documento específico.
     */
    public GuardarDocumentoView() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * Guarda el contenido del documento en un archivo PDF.
     *
     * @param archivo El archivo donde se guardará el documento.
     * @param contenido El contenido del documento.
     * @throws IOException Si ocurre un error al guardar el archivo.
     */
    private void guardarComoPDF(File archivo, String contenido) throws IOException {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        try (FileOutputStream fileOutputStream = new FileOutputStream(archivo)) {
            com.itextpdf.text.pdf.PdfWriter.getInstance(document, fileOutputStream);
            document.open();
            document.add(new com.itextpdf.text.Paragraph(contenido));
            document.close();
        } catch (Exception e) {
            throw new IOException("Error al generar el PDF: " + e.getMessage());
        }
    }

    /**
     * Guarda el contenido del documento en un archivo TXT.
     *
     * @param archivo El archivo donde se guardará el documento.
     * @param contenido El contenido del documento.
     * @throws IOException Si ocurre un error al guardar el archivo.
     */
    private void guardarComoTxt(File archivo, String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenido);
        } catch (IOException e) {
            throw new IOException("Error al generar el archivo TXT: " + e.getMessage());
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

        jFileChooser1 = new javax.swing.JFileChooser();
        background = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        nombreText = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        nombreField = new javax.swing.JTextField();
        guardarButton = new javax.swing.JPanel();
        guardarButtonText = new javax.swing.JLabel();
        guardarText = new javax.swing.JLabel();
        ExtensionComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setName("edittext"); // NOI18N

        title1.setFont(new java.awt.Font("Lato Semibold", 0, 22)); // NOI18N
        title1.setForeground(new java.awt.Color(51, 51, 51));
        title1.setText("Descargar documento");

        nombreText.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        nombreText.setText("Nombre documento");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 3));

        nombreField.setBackground(new java.awt.Color(255, 255, 255));
        nombreField.setToolTipText("Nombre del documento");
        nombreField.setBorder(null);

        guardarButton.setBackground(new java.awt.Color(51, 51, 51));
        guardarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guardarButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guardarButtonMouseExited(evt);
            }
        });

        guardarButtonText.setFont(new java.awt.Font("Lato Semibold", 1, 14)); // NOI18N
        guardarButtonText.setForeground(new java.awt.Color(255, 255, 255));
        guardarButtonText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarButtonText.setText("Guardar");

        javax.swing.GroupLayout guardarButtonLayout = new javax.swing.GroupLayout(guardarButton);
        guardarButton.setLayout(guardarButtonLayout);
        guardarButtonLayout.setHorizontalGroup(
            guardarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guardarButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guardarButtonText, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );
        guardarButtonLayout.setVerticalGroup(
            guardarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guardarButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guardarButtonText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        guardarText.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        guardarText.setText("Guardar como:");

        ExtensionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pdf", "txt", " " }));
        ExtensionComboBox.setToolTipText("Formato del documento");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(guardarText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(nombreField)
                    .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExtensionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(title1)
                .addGap(20, 20, 20)
                .addComponent(nombreText)
                .addGap(4, 4, 4)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardarText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExtensionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseClicked
        String nombreDocumento = nombreField.getText().trim();
        String formatoSeleccionado = (String) ExtensionComboBox.getSelectedItem();

        if (nombreDocumento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre para el documento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (formatoSeleccionado == null || formatoSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un formato para el documento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String contenidoDocumento = text;

        if (contenidoDocumento == null || contenidoDocumento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El documento no tiene contenido para guardar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreArchivo = nombreDocumento + "." + formatoSeleccionado;

        // Seleccionar el directorio y archivo para guardar
        File directorio = new File(System.getProperty("user.home"), "Documentos");
        JFileChooser fileChooser = new JFileChooser(directorio);
        fileChooser.setSelectedFile(new File(nombreArchivo));
        int opcion = fileChooser.showSaveDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            try {
                if (formatoSeleccionado.equalsIgnoreCase("pdf")) {
                    guardarComoPDF(archivoSeleccionado, contenidoDocumento);
                } else if (formatoSeleccionado.equalsIgnoreCase("txt")) {
                    guardarComoTxt(archivoSeleccionado, contenidoDocumento);
                } else {
                    JOptionPane.showMessageDialog(this, "Formato no soportado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(this, "Documento guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el documento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        dispose();
    }//GEN-LAST:event_guardarButtonMouseClicked

    private void guardarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseEntered
        Color customColor = new Color(51, 51, 51);
        guardarButton.setBackground(Color.white);
        guardarButtonText.setForeground(customColor);
        guardarButton.setBorder(LineBorder.createBlackLineBorder());    }//GEN-LAST:event_guardarButtonMouseEntered

    private void guardarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseExited
        Color customColor = new Color(51, 51, 51);
        guardarButton.setBackground(customColor);
        guardarButtonText.setForeground(Color.white);
    }//GEN-LAST:event_guardarButtonMouseExited

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
            java.util.logging.Logger.getLogger(GuardarDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuardarDocumentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ExtensionComboBox;
    private javax.swing.JPanel background;
    private javax.swing.JPanel guardarButton;
    private javax.swing.JLabel guardarButtonText;
    private javax.swing.JLabel guardarText;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreText;
    private javax.swing.JLabel title1;
    // End of variables declaration//GEN-END:variables
}
