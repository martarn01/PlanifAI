package com.planifai.view;

import com.planifai.controller.DocumentoController;
import com.planifai.controller.EventoController;
import com.planifai.controller.NotaController;
import com.planifai.interfaces.DocumentoListener;
import com.planifai.interfaces.EventoListener;
import com.planifai.model.Aula;
import com.planifai.model.Documento;
import com.planifai.model.Evento;
import com.planifai.service.DocumentoService;
import com.planifai.service.EventoService;
import com.planifai.service.NoteService;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 * Clase que representa la vista detallada de un aula en la aplicación. Esta
 * vista permite visualizar los eventos, documentos y notas asociados a un aula,
 * así como interactuar con ellos a través de las tarjetas correspondientes.
 * Implementa los listeners para manejar eventos de los objetos Evento y
 * Documento.
 *
 * @author Marta Rosado Nabais
 */
public class AulaView extends javax.swing.JFrame implements EventoListener, DocumentoListener {

    private Aula aula;
    private DocumentoController documentoController;
    private EventoController eventoController;
    private NotaController notaController;

    /**
     * Constructor que inicializa la vista del aula con su información y carga
     * los eventos, documentos y notas asociados.
     *
     * @param aula El aula cuyo datos serán mostrados en la vista.
     */
    public AulaView(Aula aula) {
        this.aula = aula;

        initComponents();

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Ajustar el tamaño de la ventana al tamaño de la pantalla
        this.setSize(screenSize.width, screenSize.height);
        this.setExtendedState(MainFrame.MAXIMIZED_BOTH);//maximizada por defecto
        this.setResizable(true);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        // Cambiar el ícono de la ventana
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\images\\icono.png");
        setIconImage(icon);
        setTitle("PlanifAI");

        titleAula.setText(aula.getNombre());

        eventoController = new EventoController(new EventoService());
        documentoController = new DocumentoController(new DocumentoService());
        this.notaController = new NotaController(new NoteService());

        cargarDocumentos();
        cargarEventos();
        cargarNota();
    }

    /**
     * Constructor vacío. Se utiliza en el caso de que no se pase un aula al
     * inicializar.
     */
    public AulaView() {

    }

    /**
     * Carga y muestra los eventos asociados al aula. Los eventos se muestran en
     * tarjetas dentro de un panel. Si no hay eventos, se actualiza la vista sin
     * agregar tarjetas.
     */
    public void cargarEventos() {
        List<Evento> eventos = eventoController.obtenerEventosPorAula(aula.getIdAula());
        System.out.println("Cantidad de eventos obtenidos: " + eventos.size());

        eventosPanel.removeAll();

        if (eventos.isEmpty()) {
            eventosPanel.revalidate();
            eventosPanel.repaint();
            return;
        }

        eventosPanel.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH;

        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            EventoCardTemplate card = new EventoCardTemplate(evento);
            card.setEventoListener(this);
            gbc.gridy = i;
            eventosPanel.add(card, gbc);
        }

        eventosPanel.revalidate();
        eventosPanel.repaint();
    }

    /**
     * Carga y muestra los documentos asociados al aula. Los documentos se
     * muestran en tarjetas dentro de un panel. Si no hay documentos, se
     * actualiza la vista sin agregar tarjetas.
     */
    public void cargarDocumentos() {

        List<Documento> documentos = documentoController.obtenerDocumentosPorAula(aula.getIdAula());
        System.out.println("Cantidad de documentos obtenidos: " + documentos.size());

        documentosPanel.removeAll();

        if (documentos.isEmpty()) {
            documentosPanel.revalidate();
            documentosPanel.repaint();
            return;
        }

        documentosPanel.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH;

        for (int i = 0; i < documentos.size(); i++) {
            Documento documento = documentos.get(i);
            DocumentoCardTemplate card = new DocumentoCardTemplate(documento);
            card.setDocumentoListener(this);
            System.out.println("Documento cargado: " + documento.getTitulo());

            gbc.gridy = i;
            documentosPanel.add(card, gbc);
        }

        documentosPanel.revalidate();
        documentosPanel.repaint();
    }

    /**
     * Carga la nota asociada al aula. Si existe una nota, se muestra en el área
     * de texto correspondiente.
     */
    private void cargarNota() {
        String contenido = notaController.obtenerNotaPorAula(aula.getIdAula());
        if (contenido != null && !contenido.isEmpty()) {
            noteTextArea.setText(contenido);
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
        titleAula = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        documentosTitle = new javax.swing.JLabel();
        documentosTitle1 = new javax.swing.JLabel();
        documentosPanel = new javax.swing.JPanel();
        notePanel = new javax.swing.JPanel();
        noteSaveButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        noteTextArea = new javax.swing.JTextArea();
        addDocumentButton = new javax.swing.JPanel();
        addAulaText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        eventosTitle = new javax.swing.JLabel();
        eventosPanel = new javax.swing.JPanel();
        addEventButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1536, 864));
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

        titleAula.setFont(new java.awt.Font("Lato", 1, 32)); // NOI18N
        titleAula.setForeground(new java.awt.Color(51, 51, 51));
        titleAula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleAula.setText("Nombre aula");
        titleAula.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        documentosTitle.setFont(new java.awt.Font("Lato Semibold", 1, 22)); // NOI18N
        documentosTitle.setForeground(new java.awt.Color(51, 51, 51));
        documentosTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        documentosTitle.setText("Documentos");
        documentosTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        documentosTitle1.setFont(new java.awt.Font("Lato Semibold", 1, 22)); // NOI18N
        documentosTitle1.setForeground(new java.awt.Color(51, 51, 51));
        documentosTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        documentosTitle1.setText("Nota");
        documentosTitle1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        documentosPanel.setBackground(new java.awt.Color(251, 251, 251));
        documentosPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        documentosPanel.setLayout(new java.awt.GridBagLayout());

        notePanel.setBackground(new java.awt.Color(187, 187, 187));

        noteSaveButton.setBackground(new java.awt.Color(204, 204, 204));
        noteSaveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noteSaveButton.setForeground(new java.awt.Color(153, 153, 153));
        noteSaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteSaveButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                noteSaveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                noteSaveButtonMouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jLabel4.setText("Guardar");

        javax.swing.GroupLayout noteSaveButtonLayout = new javax.swing.GroupLayout(noteSaveButton);
        noteSaveButton.setLayout(noteSaveButtonLayout);
        noteSaveButtonLayout.setHorizontalGroup(
            noteSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noteSaveButtonLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        noteSaveButtonLayout.setVerticalGroup(
            noteSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noteSaveButtonLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        noteTextArea.setBackground(new java.awt.Color(204, 204, 204));
        noteTextArea.setColumns(20);
        noteTextArea.setRows(5);
        noteTextArea.setWrapStyleWord(true);
        noteTextArea.setBorder(null);
        jScrollPane3.setViewportView(noteTextArea);

        javax.swing.GroupLayout notePanelLayout = new javax.swing.GroupLayout(notePanel);
        notePanel.setLayout(notePanelLayout);
        notePanelLayout.setHorizontalGroup(
            notePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(notePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        notePanelLayout.setVerticalGroup(
            notePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        addDocumentButton.setBackground(new java.awt.Color(51, 51, 51));
        addDocumentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addDocumentButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addDocumentButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addDocumentButtonMouseExited(evt);
            }
        });

        addAulaText.setFont(new java.awt.Font("Lato Semibold", 1, 16)); // NOI18N
        addAulaText.setForeground(new java.awt.Color(255, 255, 255));
        addAulaText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addAulaText.setText("Nuevo documento");

        javax.swing.GroupLayout addDocumentButtonLayout = new javax.swing.GroupLayout(addDocumentButton);
        addDocumentButton.setLayout(addDocumentButtonLayout);
        addDocumentButtonLayout.setHorizontalGroup(
            addDocumentButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocumentButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAulaText, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        addDocumentButtonLayout.setVerticalGroup(
            addDocumentButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDocumentButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(addAulaText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(documentosTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(documentosTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addDocumentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(documentosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(483, Short.MAX_VALUE)
                    .addComponent(notePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(91, 91, 91)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(documentosTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(documentosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(documentosTitle1)))
                .addGap(18, 18, 18)
                .addComponent(addDocumentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(notePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(253, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(titleAula, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(titleAula, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(245, 245, 245));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        eventosTitle.setFont(new java.awt.Font("Lato Semibold", 1, 22)); // NOI18N
        eventosTitle.setForeground(new java.awt.Color(51, 51, 51));
        eventosTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eventosTitle.setText("Próximos eventos");
        eventosTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        eventosPanel.setBackground(new java.awt.Color(251, 251, 251));
        eventosPanel.setLayout(new java.awt.GridBagLayout());

        addEventButton.setBackground(new java.awt.Color(0, 0, 51));
        addEventButton.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        addEventButton.setForeground(new java.awt.Color(0, 0, 51));
        addEventButton.setText("+");
        addEventButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEventButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addEventButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addEventButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(eventosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(eventosTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(addEventButton)))
                .addGap(587, 587, 587))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(centerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventosTitle)
                    .addComponent(addEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eventosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 2090, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseClicked
        System.out.println("Mouse clicked in MainFrame");
        for (Window window : Window.getWindows()) {
            if (window != this && window.isVisible()) {
                window.dispose(); // Cierra la ventana
            }
        }
    }//GEN-LAST:event_backgroundMouseClicked

    private void addDocumentButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDocumentButtonMouseExited
        Color customColor = new Color(51, 51, 51);
        addDocumentButton.setBackground(customColor);
        addAulaText.setForeground(Color.white);
    }//GEN-LAST:event_addDocumentButtonMouseExited

    private void addDocumentButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDocumentButtonMouseEntered
        Color customColor = new Color(51, 51, 51);
        addDocumentButton.setBackground(Color.white);
        addAulaText.setForeground(customColor);
        addDocumentButton.setBorder(LineBorder.createBlackLineBorder());
    }//GEN-LAST:event_addDocumentButtonMouseEntered

    private void addDocumentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDocumentButtonMouseClicked
        GeneracionDocumentoView generacionDocumentoView = new GeneracionDocumentoView();
        generacionDocumentoView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addDocumentButtonMouseClicked

    private void titleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseExited
        title.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_titleMouseExited

    private void titleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseEntered
        title.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_titleMouseEntered

    private void titleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseClicked
        MainFrame mainframe = new MainFrame();
        mainframe.setVisible(true);
    }//GEN-LAST:event_titleMouseClicked

    private void addEventButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEventButtonMouseEntered
        addEventButton.setForeground(Color.gray);
    }//GEN-LAST:event_addEventButtonMouseEntered

    private void addEventButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEventButtonMouseExited
        Color color = new Color(0, 0, 51);
        addEventButton.setForeground(color);
    }//GEN-LAST:event_addEventButtonMouseExited

    private void addEventButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEventButtonMouseClicked
        AddEventView addEventView = new AddEventView(aula);
        addEventView.setEventoListener(this);
        addEventView.setVisible(true);
    }//GEN-LAST:event_addEventButtonMouseClicked

    private void noteSaveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteSaveButtonMouseEntered
        Color color = new Color(153, 153, 153);
        noteSaveButton.setBackground(color);
    }//GEN-LAST:event_noteSaveButtonMouseEntered

    private void noteSaveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteSaveButtonMouseExited
        Color color = new Color(204, 204, 204);
        noteSaveButton.setBackground(color);
    }//GEN-LAST:event_noteSaveButtonMouseExited

    private void noteSaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteSaveButtonMouseClicked
        try {
            String contenido = noteTextArea.getText().trim();

            if (contenido.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "El contenido de la nota está vacío",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            notaController.crearNota(contenido, aula.getIdAula());

            JOptionPane.showMessageDialog(this,
                    "Nota guardada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar la nota: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_noteSaveButtonMouseClicked

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
            java.util.logging.Logger.getLogger(AulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AulaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AulaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addAulaText;
    private javax.swing.JPanel addDocumentButton;
    private javax.swing.JLabel addEventButton;
    private javax.swing.JPanel background;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel documentosPanel;
    private javax.swing.JLabel documentosTitle;
    private javax.swing.JLabel documentosTitle1;
    private javax.swing.JPanel eventosPanel;
    private javax.swing.JLabel eventosTitle;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel notePanel;
    private javax.swing.JPanel noteSaveButton;
    private javax.swing.JTextArea noteTextArea;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleAula;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onEventoDeleted() {
        cargarEventos();
    }

    @Override
    public void onEventoCreated() {
        cargarEventos();
    }

    @Override
    public void onDocumentoDeleted() {
        cargarDocumentos();
    }

    @Override
    public void onEventoChanged() {
        cargarEventos();
    }
}
