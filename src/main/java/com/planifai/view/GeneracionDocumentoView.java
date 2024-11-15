package com.planifai.view;

import com.planifai.controller.OpenAIController;
import com.planifai.model.Documento;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Window;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 * La clase GeneracionDocumentoView es una vista de la aplicación que permite la
 * generación de documentos educativos. Proporciona una interfaz gráfica para
 * que el usuario seleccione parámetros como nivel educativo, asignatura, tema y
 * genere prompts personalizados para la creación de documentos como
 * evaluaciones y planes de clase mediante un servicio de OpenAI.
 *
 * @author Marta Rosado Nabais
 */
public class GeneracionDocumentoView extends javax.swing.JFrame {

    private HashMap<String, String[]> cursosPorNivel;
    private OpenAIController openAIController;

    private static final Color COLOR_CUSTOM = new Color(51, 51, 51);

    /**
     * Constructor que inicializa la interfaz de usuario con un documento
     * existente. Configura el tamaño de la ventana, el ícono, el título y llena
     * los campos con la información del documento.
     *
     * @param documento El documento preexistente que se va a visualizar o
     * editar en la interfaz.
     */
    public GeneracionDocumentoView(Documento documento) {
        initComponents();

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Ajustar el tamaño de la ventana al tamaño de la pantalla
        this.setSize(screenSize.width, screenSize.height);
        this.setExtendedState(GeneracionDocumentoView.MAXIMIZED_BOTH);//maximizada por defecto
        this.setResizable(false);

        // Cambiar el ícono de la ventana
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\images\\icono.png");
        setIconImage(icon);
        setTitle("PlanifAI");

        openAIController=new OpenAIController();

        // Inicializamos el mapa con niveles educativos y sus cursos correspondientes
        cursosPorNivel = new HashMap<>();
        cursosPorNivel.put("Educación Infantil", new String[]{"Primer ciclo (0-3 años)", "Segundo ciclo (3-6 años)"});
        cursosPorNivel.put("Educación Primaria", new String[]{"1º Primaria", "2º Primaria", "3º Primaria", "4º Primaria", "5º Primaria", "6º Primaria"});
        cursosPorNivel.put("Educación Secundaria Obligatoria", new String[]{"1º ESO", "2º ESO", "3º ESO", "4º ESO"});
        cursosPorNivel.put("Bachillerato", new String[]{"1º Bachillerato", "2º Bachillerato"});
        cursosPorNivel.put("Formación Profesional", new String[]{"Grado Medio", "Grado Superior"});
        cursosPorNivel.put("Educación Universitaria", new String[]{"Grado", "Máster", "Doctorado"});

        nivelEducativoBox.addActionListener(evt -> actualizarCursos());

        documentoTitle.setText(documento.getTitulo());
        DocumentoTextArea.setText(documento.getContenido());
    }
    
     /**
     * Constructor alternativo que inicializa la vista sin un documento
     * preexistente. Configura la ventana de forma similar al otro constructor,
     * pero sin cargar contenido de documento.
     */
    public GeneracionDocumentoView() {
        initComponents();

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Ajustar el tamaño de la ventana al tamaño de la pantalla
        this.setSize(screenSize.width, screenSize.height);
        this.setExtendedState(GeneracionDocumentoView.MAXIMIZED_BOTH);//maximizada por defecto
        this.setResizable(false);
    
         openAIController=new OpenAIController();
         
        // Cambiar el ícono de la ventana
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\images\\icono.png");
        setIconImage(icon);
        setTitle("PlanifAI");

        // Inicializamos el mapa con niveles educativos y sus cursos correspondientes
        cursosPorNivel = new HashMap<>();
        cursosPorNivel.put("Educación Infantil", new String[]{"Primer ciclo (0-3 años)", "Segundo ciclo (3-6 años)"});
        cursosPorNivel.put("Educación Primaria", new String[]{"1º Primaria", "2º Primaria", "3º Primaria", "4º Primaria", "5º Primaria", "6º Primaria"});
        cursosPorNivel.put("Educación Secundaria Obligatoria", new String[]{"1º ESO", "2º ESO", "3º ESO", "4º ESO"});
        cursosPorNivel.put("Bachillerato", new String[]{"1º Bachillerato", "2º Bachillerato"});
        cursosPorNivel.put("Formación Profesional", new String[]{"Grado Medio", "Grado Superior"});
        cursosPorNivel.put("Educación Universitaria", new String[]{"Grado", "Máster", "Doctorado"});

        nivelEducativoBox.addActionListener(evt -> actualizarCursos());
    }

    /**
     * Método para actualizar los cursos en el JComboBox "cursoBox" en función
     * del nivel educativo seleccionado. Cuando se selecciona un nivel
     * educativo, este método obtiene los cursos correspondientes del mapa y los
     * muestra en el JComboBox de cursos.
     */
    private void actualizarCursos() {
        // Obtener el nivel educativo seleccionado
        String nivelSeleccionado = nivelEducativoBox.getSelectedItem().toString();

        System.out.println("Nivel seleccionado: " + nivelSeleccionado); // Depuración

        // Obtener los cursos correspondientes a ese nivel
        String[] cursos = cursosPorNivel.get(nivelSeleccionado);
        System.out.println("Cursos encontrados: " + (cursos != null ? cursos.length : "No se encontraron cursos")); // Depuración

        // Actualizar el modelo del segundo JComboBox con los cursos correspondientes
        if (cursos != null) {
            cursoBox.setModel(new DefaultComboBoxModel<>(cursos));
        } else {
            cursoBox.setModel(new DefaultComboBoxModel<>(new String[0]));
        }
    }

    /**
     * Método para generar un prompt basado en los datos introducidos por el
     * usuario en la interfaz. Comprueba que todos los campos necesarios estén
     * rellenados y genera un prompt adecuado para la creación de un documento
     * educativo (evaluación o plan de clase).
     *
     * @return El prompt generado, o una cadena vacía si falta algún campo
     * requerido.
     */
    private String generarPrompt() {
        // Verificar que todos los campos estén rellenos
        if (asignaturaField.getText().trim().isEmpty()
                || temaField.getText().trim().isEmpty()
                || nivelEducativoBox.getSelectedItem() == null
                || cursoBox.getSelectedItem() == null
                || objetivosTextArea.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos requeridos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return "";  // Devolver una cadena vacía si algún campo está vacío
        }

        // Seleccionar el primer elemento del ComboBox si no se ha seleccionado ninguno
        if (tipoDocumentoComboBox.getSelectedItem() == null) {
            tipoDocumentoComboBox.setSelectedIndex(0);  // Seleccionar el primer elemento
        }

        // Obtener los valores de los campos
        String asignatura = asignaturaField.getText();
        String tema = temaField.getText();
        String nivelEducativo = nivelEducativoBox.getSelectedItem().toString();
        String curso = cursoBox.getSelectedItem().toString();
        int duracion = (int) DuracionSpinner.getValue();  // Se obtiene la duración desde el spinner
        String objetivosAprendizaje = objetivosTextArea.getText();

        // Obtener el tipo de documento seleccionado
        String tipoDocumento = tipoDocumentoComboBox.getSelectedItem().toString();

        // Generar el prompt según el tipo de documento
        String prompt = "";
        if (tipoDocumento.equals("Evaluación")) {
            prompt = "Genera una evaluación para la asignatura de " + asignatura + ", con el tema " + tema + ", dirigida a estudiantes de " + nivelEducativo + " en el curso " + curso + ". La duración de la evaluación será de " + duracion + " minutos. Los objetivos de aprendizaje de esta evaluación son los siguientes: " + objetivosAprendizaje + ". Asegúrate de incluir preguntas variadas que evalúen el conocimiento en los siguientes aspectos: comprensión, aplicación y análisis de conceptos.";
        } else if (tipoDocumento.equals("Plan de Clase")) {
            prompt = "Genera un plan de clase para la asignatura de " + asignatura + ", con el tema " + tema + ", dirigido a estudiantes de " + nivelEducativo + " en el curso " + curso + ". La duración de la clase será de " + duracion + " minutos. Los objetivos de aprendizaje son los siguientes: " + objetivosAprendizaje + ". Incluye una descripción detallada de las actividades, el enfoque pedagógico y los materiales que se utilizarán durante la clase. El plan debe ser interactivo y fomentar la participación de los estudiantes.";
        }
        return prompt;
    }

    /**
     * Método para generar y mostrar un documento educativo basado en los datos
     * ingresados.
     */
    private void generarDocumento() {
        String prompt = generarPrompt();
        if (!prompt.isEmpty()) {
            String respuesta = openAIController.obtenerRespuestaDeOpenAI(prompt);
            DocumentoTextArea.setText(respuesta);
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

        background = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        titleGenerarDocumetnos = new javax.swing.JLabel();
        generarDocumentoButton = new javax.swing.JPanel();
        generaDocumentoText = new javax.swing.JLabel();
        planClasePanel = new javax.swing.JPanel();
        asignaturaLabel = new javax.swing.JLabel();
        asignaturaField = new javax.swing.JTextField();
        duracionLabel = new javax.swing.JLabel();
        temaField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        temaLabel = new javax.swing.JLabel();
        nivelEducativoBox = new javax.swing.JComboBox<>();
        cursoBox = new javax.swing.JComboBox<>();
        nivelEducativoLabel = new javax.swing.JLabel();
        DuracionSpinner = new javax.swing.JSpinner();
        objetivosAprendizajeLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        objetivosTextArea = new javax.swing.JTextArea();
        minLabel = new javax.swing.JLabel();
        tipoDocumentoComboBox = new javax.swing.JComboBox<>();
        rightPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        documentoTitle = new javax.swing.JLabel();
        eventosPanel = new javax.swing.JPanel();
        documentosPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DocumentoTextArea = new javax.swing.JTextArea();
        descargarButton = new javax.swing.JPanel();
        descargarText = new javax.swing.JLabel();
        guardarButton = new javax.swing.JPanel();
        guardarText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1536, 896));
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundMouseClicked(evt);
            }
        });

        leftPanel.setBackground(new java.awt.Color(235, 241, 247));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono.png"))); // NOI18N
        icon.setToolTipText("Icono de la aplicación");

        title.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText("PlanifAI");
        title.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                titleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                titleMouseExited(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setMaximumSize(new java.awt.Dimension(837, 896));
        centerPanel.setMinimumSize(new java.awt.Dimension(837, 896));

        titleGenerarDocumetnos.setFont(new java.awt.Font("Lato", 1, 32)); // NOI18N
        titleGenerarDocumetnos.setForeground(new java.awt.Color(51, 51, 51));
        titleGenerarDocumetnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleGenerarDocumetnos.setText("Generador de documentos");
        titleGenerarDocumetnos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        generarDocumentoButton.setBackground(new java.awt.Color(51, 51, 51));
        generarDocumentoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generarDocumentoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                generarDocumentoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                generarDocumentoButtonMouseExited(evt);
            }
        });

        generaDocumentoText.setFont(new java.awt.Font("Lato Semibold", 1, 16)); // NOI18N
        generaDocumentoText.setForeground(new java.awt.Color(255, 255, 255));
        generaDocumentoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generaDocumentoText.setText("Generar documento");

        javax.swing.GroupLayout generarDocumentoButtonLayout = new javax.swing.GroupLayout(generarDocumentoButton);
        generarDocumentoButton.setLayout(generarDocumentoButtonLayout);
        generarDocumentoButtonLayout.setHorizontalGroup(
            generarDocumentoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generarDocumentoButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generaDocumentoText, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        generarDocumentoButtonLayout.setVerticalGroup(
            generarDocumentoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generarDocumentoButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(generaDocumentoText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        planClasePanel.setBackground(new java.awt.Color(255, 255, 255));

        asignaturaLabel.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        asignaturaLabel.setText("Asignatura");

        asignaturaField.setToolTipText("Introduce la asignatura");
        asignaturaField.setBorder(null);
        asignaturaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignaturaFieldActionPerformed(evt);
            }
        });

        duracionLabel.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        duracionLabel.setText("Duración");

        temaField.setToolTipText("Introduce el tema");
        temaField.setBorder(null);
        temaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temaFieldActionPerformed(evt);
            }
        });

        temaLabel.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        temaLabel.setText("Tema");

        nivelEducativoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Educación Infantil", "Educación Primaria", "Educación Secundaria Obligatoria", "Bachillerato", "Formación Profesional", "Educación Universitaria" }));
        nivelEducativoBox.setToolTipText("Introduce el nivel educativo");

        cursoBox.setToolTipText("Introduce el curso");

        nivelEducativoLabel.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        nivelEducativoLabel.setText("Nivel educativo");

        DuracionSpinner.setModel(new javax.swing.SpinnerNumberModel(10, null, null, 10));
        DuracionSpinner.setToolTipText("Intoduce la duración de la clase");

        objetivosAprendizajeLabel.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        objetivosAprendizajeLabel.setText("Datos extras");

        objetivosTextArea.setColumns(20);
        objetivosTextArea.setRows(5);
        objetivosTextArea.setToolTipText("Introduce los objetivos de aprendizaje");
        jScrollPane2.setViewportView(objetivosTextArea);

        minLabel.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        minLabel.setForeground(new java.awt.Color(204, 204, 204));
        minLabel.setText("min");

        javax.swing.GroupLayout planClasePanelLayout = new javax.swing.GroupLayout(planClasePanel);
        planClasePanel.setLayout(planClasePanelLayout);
        planClasePanelLayout.setHorizontalGroup(
            planClasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planClasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(planClasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(planClasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(planClasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(asignaturaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temaField, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(asignaturaField, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(jSeparator3)
                            .addComponent(duracionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(planClasePanelLayout.createSequentialGroup()
                            .addComponent(nivelEducativoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cursoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nivelEducativoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(planClasePanelLayout.createSequentialGroup()
                            .addComponent(DuracionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(minLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(objetivosAprendizajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        planClasePanelLayout.setVerticalGroup(
            planClasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planClasePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(asignaturaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(asignaturaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(temaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nivelEducativoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(planClasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nivelEducativoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cursoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(duracionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(planClasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DuracionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minLabel))
                .addGap(18, 18, 18)
                .addComponent(objetivosAprendizajeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tipoDocumentoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plan de Clase", "Evaluación" }));

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                        .addComponent(tipoDocumentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))
                    .addComponent(titleGenerarDocumetnos, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generarDocumentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(planClasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(titleGenerarDocumetnos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tipoDocumentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(planClasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(generarDocumentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new java.awt.Color(245, 245, 245));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        documentoTitle.setFont(new java.awt.Font("Lato Semibold", 1, 22)); // NOI18N
        documentoTitle.setForeground(new java.awt.Color(51, 51, 51));
        documentoTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        documentoTitle.setText("Título el documento");
        documentoTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        eventosPanel.setBackground(new java.awt.Color(251, 251, 251));
        eventosPanel.setLayout(new java.awt.GridBagLayout());

        documentosPanel.setBackground(new java.awt.Color(251, 251, 251));
        documentosPanel.setLayout(new java.awt.GridBagLayout());

        DocumentoTextArea.setColumns(20);
        DocumentoTextArea.setRows(5);
        DocumentoTextArea.setToolTipText("Editor del documento");
        DocumentoTextArea.setBorder(null);
        jScrollPane1.setViewportView(DocumentoTextArea);

        descargarButton.setBackground(new java.awt.Color(51, 51, 51));
        descargarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descargarButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                descargarButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                descargarButtonMouseExited(evt);
            }
        });

        descargarText.setFont(new java.awt.Font("Lato Semibold", 1, 16)); // NOI18N
        descargarText.setForeground(new java.awt.Color(255, 255, 255));
        descargarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descargarText.setText("Descargar");

        javax.swing.GroupLayout descargarButtonLayout = new javax.swing.GroupLayout(descargarButton);
        descargarButton.setLayout(descargarButtonLayout);
        descargarButtonLayout.setHorizontalGroup(
            descargarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, descargarButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descargarText, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        descargarButtonLayout.setVerticalGroup(
            descargarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descargarButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(descargarText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

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

        guardarText.setFont(new java.awt.Font("Lato Semibold", 1, 16)); // NOI18N
        guardarText.setForeground(new java.awt.Color(255, 255, 255));
        guardarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarText.setText("Guardar");

        javax.swing.GroupLayout guardarButtonLayout = new javax.swing.GroupLayout(guardarButton);
        guardarButton.setLayout(guardarButtonLayout);
        guardarButtonLayout.setHorizontalGroup(
            guardarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guardarButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guardarText, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        guardarButtonLayout.setVerticalGroup(
            guardarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guardarButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(guardarText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eventosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(documentosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descargarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addComponent(documentoTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(centerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(documentoTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eventosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descargarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documentosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 2468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarDocumentoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarDocumentoButtonMouseClicked
        // Llamar al método para generar el prompt
        String prompt = generarPrompt();

        // Aquí puedes usar el prompt para la generación del documento
        System.out.println("Prompt generado: " + prompt);

        // Llamar al servicio para generar el documento
        String respuesta = openAIController.obtenerRespuestaDeOpenAI(prompt);
        DocumentoTextArea.setText(respuesta);

    }//GEN-LAST:event_generarDocumentoButtonMouseClicked

    private void generarDocumentoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarDocumentoButtonMouseEntered
        generarDocumentoButton.setBackground(Color.white);
        generaDocumentoText.setForeground(COLOR_CUSTOM);
        generarDocumentoButton.setBorder(LineBorder.createBlackLineBorder());
    }//GEN-LAST:event_generarDocumentoButtonMouseEntered

    private void generarDocumentoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarDocumentoButtonMouseExited
        generarDocumentoButton.setBackground(COLOR_CUSTOM);
        generaDocumentoText.setForeground(Color.white);
    }//GEN-LAST:event_generarDocumentoButtonMouseExited

    private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseClicked
        System.out.println("Mouse clicked in MainFrame");
        for (Window window : Window.getWindows()) {
            if (window != this && window.isVisible()) {
                window.dispose(); // Cierra la ventana
            }
        }
    }//GEN-LAST:event_backgroundMouseClicked

    private void descargarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargarButtonMouseClicked

    }//GEN-LAST:event_descargarButtonMouseClicked

    private void descargarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargarButtonMouseEntered
        descargarButton.setBackground(Color.white);
        descargarText.setForeground(COLOR_CUSTOM);
        descargarButton.setBorder(LineBorder.createBlackLineBorder());    }//GEN-LAST:event_descargarButtonMouseEntered

    private void descargarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargarButtonMouseExited
        descargarButton.setBackground(COLOR_CUSTOM);
        descargarText.setForeground(Color.white);
    }//GEN-LAST:event_descargarButtonMouseExited

    private void guardarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarButtonMouseClicked

    private void guardarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseEntered
        guardarButton.setBackground(Color.white);
        guardarText.setForeground(COLOR_CUSTOM);
        guardarButton.setBorder(LineBorder.createBlackLineBorder());     }//GEN-LAST:event_guardarButtonMouseEntered

    private void guardarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseExited
        guardarButton.setBackground(COLOR_CUSTOM);
        guardarText.setForeground(Color.white);     }//GEN-LAST:event_guardarButtonMouseExited

    private void titleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseEntered
        title.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_titleMouseEntered

    private void titleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseExited
        title.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_titleMouseExited

    private void titleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseClicked
        MainFrame mainframe = new MainFrame();
        mainframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_titleMouseClicked

    private void temaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temaFieldActionPerformed

    private void asignaturaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignaturaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignaturaFieldActionPerformed

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
            java.util.logging.Logger.getLogger(GeneracionDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneracionDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneracionDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneracionDocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneracionDocumentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DocumentoTextArea;
    private javax.swing.JSpinner DuracionSpinner;
    private javax.swing.JTextField asignaturaField;
    private javax.swing.JLabel asignaturaLabel;
    private javax.swing.JPanel background;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JComboBox<String> cursoBox;
    private javax.swing.JPanel descargarButton;
    private javax.swing.JLabel descargarText;
    private javax.swing.JLabel documentoTitle;
    private javax.swing.JPanel documentosPanel;
    private javax.swing.JLabel duracionLabel;
    private javax.swing.JPanel eventosPanel;
    private javax.swing.JLabel generaDocumentoText;
    private javax.swing.JPanel generarDocumentoButton;
    private javax.swing.JPanel guardarButton;
    private javax.swing.JLabel guardarText;
    private javax.swing.JLabel icon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel minLabel;
    private javax.swing.JComboBox<String> nivelEducativoBox;
    private javax.swing.JLabel nivelEducativoLabel;
    private javax.swing.JLabel objetivosAprendizajeLabel;
    private javax.swing.JTextArea objetivosTextArea;
    private javax.swing.JPanel planClasePanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField temaField;
    private javax.swing.JLabel temaLabel;
    private javax.swing.JComboBox<String> tipoDocumentoComboBox;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleGenerarDocumetnos;
    // End of variables declaration//GEN-END:variables

}
