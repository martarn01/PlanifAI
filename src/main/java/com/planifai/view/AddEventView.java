package com.planifai.view;

import com.planifai.controller.DocumentoController;
import com.planifai.controller.EventoController;
import com.planifai.interfaces.EventoListener;
import com.planifai.model.Aula;
import com.planifai.model.Documento;
import com.planifai.model.Evento;
import com.planifai.service.DocumentoService;
import com.planifai.service.EventoService;
import java.awt.Color;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import raven.datetime.component.date.DatePicker;

/**
 * Vista para agregar un evento a un aula. Esta clase es responsable de mostrar
 * la interfaz gráfica para crear un nuevo evento, permitiendo seleccionar
 * documentos asociados y configurar la fecha del evento.
 *
 * @author Marta Rosado Nabais
 */
public class AddEventView extends javax.swing.JFrame {

    private DocumentoController documentoController;
    private EventoController eventoController;
    private Map<String, Integer> documentoIdMap;
    private EventoListener eventoListener;
    private Aula aula;
    private Documento documento;
    private Evento evento;

    /**
     * Constructor por defecto de la vista para agregar un evento. Inicializa
     * los controladores, configura la interfaz gráfica, y carga los documentos.
     */
    public AddEventView() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.aula = aula;

        documentoController = new DocumentoController(new DocumentoService());
        eventoController = new EventoController(new EventoService());
        documentoIdMap = new HashMap<>();

        DatePicker datePicker = new DatePicker();
        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
        datePicker.setEditor(datePickerField);

        cargarDocumentos();

    }

    /**
     * Constructor de la vista para agregar un evento, con un aula especificada.
     * Este constructor permite la creación de un evento asociado a un aula
     * existente.
     *
     * @param aula El aula a la que se asociará el nuevo evento.
     */
    public AddEventView(Aula aula) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.aula = aula;

        documentoController = new DocumentoController(new DocumentoService());
        eventoController = new EventoController(new EventoService());
        documentoIdMap = new HashMap<>();

        DatePicker datePicker = new DatePicker();
        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
        datePicker.setEditor(datePickerField);

        cargarDocumentos();
    }

    public AddEventView(Evento evento, Aula aula) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.evento = evento;
        this.aula = aula;

        documentoController = new DocumentoController(new DocumentoService());
        eventoController = new EventoController(new EventoService());
        documentoIdMap = new HashMap<>();

        nombreField.setText(evento.getDescripcion());
        EventoComboBox.setSelectedItem(evento.getTipoEvento());
        Timestamp timestamp = evento.getFechaEvento();
        LocalDate fechaEvento = timestamp.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        DatePicker datePicker = new DatePicker();
        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
        datePicker.setEditor(datePickerField);
        datePicker.setSelectedDate(fechaEvento);

        cargarDocumentos();

        if (evento.getIdDocumento() != null) {
            documento = documentoController.getDocumentoById(evento.getIdDocumento());
        }

        if (documento == null) {
            DocumentsComboBox.setSelectedItem("Sin documento asociado");
        } else {
            DocumentsComboBox.setSelectedItem(documento.getTitulo());
        }
    }

    /**
     * Establece el listener para los eventos relacionados con la vista de
     * agregar evento.
     *
     * @param listener El listener que se notificará cuando se cree un nuevo
     * evento.
     */
    public void setEventoListener(EventoListener listener) {
        this.eventoListener = listener;
    }

    /**
     * Carga los documentos disponibles asociados al aula en el combobox de la
     * vista. El combobox permite seleccionar un documento para asociarlo al
     * nuevo evento.
     */
    private void cargarDocumentos() {
        DocumentoController documentoController = new DocumentoController(new DocumentoService());
        List<Documento> documentos = documentoController.obtenerDocumentosPorAula(aula.getIdAula());

        DocumentsComboBox.removeAllItems();
        DocumentsComboBox.addItem("Sin documento asociado");

        for (Documento documento : documentos) {
            DocumentsComboBox.addItem(documento.getTitulo());
            documentoIdMap.put(documento.getTitulo(), documento.getIdDocumento());
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

        background4 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        descripcionText = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        nombreField = new javax.swing.JTextField();
        guardarButton = new javax.swing.JPanel();
        guardarButtonText = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        EventoComboBox = new javax.swing.JComboBox<>();
        text1 = new javax.swing.JLabel();
        datePickerField = new javax.swing.JFormattedTextField();
        text3 = new javax.swing.JLabel();
        DocumentsComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background4.setBackground(new java.awt.Color(255, 255, 255));
        background4.setName("edittext"); // NOI18N

        title.setFont(new java.awt.Font("Lato Semibold", 0, 22)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Añadir evento");

        descripcionText.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        descripcionText.setText("Descripción evento");

        jSeparator9.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setPreferredSize(new java.awt.Dimension(50, 3));

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

        text2.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        text2.setText("Tipo evento");

        EventoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Evaluación", "Reunión de padres", "Reunión de departamneto", "Excursión ", "Otro" }));
        EventoComboBox.setToolTipText("Formato del documento");

        text1.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        text1.setText("Fecha");

        datePickerField.setText("jFormattedTextField1");

        text3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        text3.setText("Documento asociado");

        DocumentsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout background4Layout = new javax.swing.GroupLayout(background4);
        background4.setLayout(background4Layout);
        background4Layout.setHorizontalGroup(
            background4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background4Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(background4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreField)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EventoComboBox, 0, 270, Short.MAX_VALUE)
                    .addComponent(datePickerField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DocumentsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        background4Layout.setVerticalGroup(
            background4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title)
                .addGap(20, 20, 20)
                .addComponent(descripcionText)
                .addGap(4, 4, 4)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datePickerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(text2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EventoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(text3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DocumentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseClicked
        try {
            String descripcion = nombreField.getText().trim();
            String tipoEvento = EventoComboBox.getSelectedItem().toString();
            String fechaStr = datePickerField.getText().trim();

            if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fechaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = dateFormat.parse(fechaStr);
            Timestamp fechaEvento = new Timestamp(fecha.getTime());

            Integer idAula = aula.getIdAula();

            Integer idDocumento = null;
            if (DocumentsComboBox.getSelectedIndex() > 0) {
                String documentoSeleccionado = DocumentsComboBox.getSelectedItem().toString();
                idDocumento = documentoIdMap.get(documentoSeleccionado);
            }

            if (evento  == null) {
                eventoController.crearEvento(descripcion, fechaEvento, tipoEvento, idAula, idDocumento);
                JOptionPane.showMessageDialog(this, "Evento creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                if (eventoListener != null) {
                    eventoListener.onEventoCreated();
                }
            } else {
                eventoController.editarEvento(evento.getIdEvento(), descripcion, fechaEvento, tipoEvento, idAula, idDocumento);
                JOptionPane.showMessageDialog(this, "Evento actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                if (eventoListener != null) {
                    eventoListener.onEventoChanged();
                }
            }

            this.dispose();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de la fecha", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el evento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarButtonMouseClicked

    private void guardarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseEntered
        Color customColor = new Color(51, 51, 51);
        guardarButton.setBackground(Color.white);
        guardarButtonText.setForeground(customColor);
    }//GEN-LAST:event_guardarButtonMouseEntered

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
            java.util.logging.Logger.getLogger(AddEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEventView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DocumentsComboBox;
    private javax.swing.JComboBox<String> EventoComboBox;
    private javax.swing.JPanel background4;
    private javax.swing.JFormattedTextField datePickerField;
    private javax.swing.JLabel descripcionText;
    private javax.swing.JPanel guardarButton;
    private javax.swing.JLabel guardarButtonText;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
