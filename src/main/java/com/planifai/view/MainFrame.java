package com.planifai.view;

import com.planifai.model.Aula;
import com.planifai.service.AulaService;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import javax.swing.border.LineBorder;
import com.planifai.interfaces.AulaListener;

/**
 * MainFrame es la clase principal que representa la ventana principal de la
 * aplicación PlanifAI. Esta clase extiende javax.swing.JFrame e implementa el
 * interfaz AulaAddedListener.
 *
 * @author marta
 */
public class MainFrame extends javax.swing.JFrame implements AulaListener {

    private AulaService aulaService;
    private AulaView aulaView;
    private boolean[] panelesCargados;
    private MenuGestion menuDesplegable;
    private static final int MAX_AULAS = 4;

    /**
     * Constructor de la clase MainFrame. Inicializa los componentes de la
     * ventana, establece el tamaño y el ícono, y carga las aulas desde la base
     * de datos.
     */
    public MainFrame() {
        initComponents();

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Ajustar el tamaño de la ventana al tamaño de la pantalla
        this.setSize(screenSize.width, screenSize.height);
        this.setExtendedState(MainFrame.MAXIMIZED_BOTH);//maximizada por defecto
        this.setResizable(true);

        // Cambiar el ícono de la ventana
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\images\\icono.png");
        setIconImage(icon);
        setTitle("PlanifAI");

        aulaService = new AulaService();
        aulaView = new AulaView();
        panelesCargados = new boolean[4];
        for (int i = 0; i < panelesCargados.length; i++) {
            panelesCargados[i] = false;
        }

        cargarAulas();
    }

    /**
     * Carga las aulas desde el servicio de base de datos y actualiza la
     * interfaz de usuario. Si no hay aulas disponibles, se muestra un mensaje
     * correspondiente. Se limita el número de aulas a mostrar según la
     * constante MAX_AULAS.
     */
    public void cargarAulas() {
        List<Aula> aulas = aulaService.getAulas();

        aulasPanel.removeAll();

        // Si no hay aulas, mostrar el mensaje correspondiente
        if (aulas.isEmpty()) {
            noAulasText.setVisible(true);
            aulasPanel.add(noAulasText);
            aulasPanel.revalidate();
            aulasPanel.repaint();
            return;
        }

        noAulasText.setVisible(false);
        aulasPanel.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH;

        int numAulas = Math.min(aulas.size(), MAX_AULAS);

        for (int i = 0; i < numAulas; i++) {
            Aula aula = aulas.get(i);
            AulaCardTemplate card = new AulaCardTemplate(aula, this);

            gbc.gridy = i;
            aulasPanel.add(card, gbc);
        }

        aulasPanel.revalidate(); // Actualizar el panel
        aulasPanel.repaint(); // Redibujar el panel
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        background = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        ElemMenu1 = new javax.swing.JPanel();
        ElemMenu2 = new javax.swing.JPanel();
        ElemMenu3 = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        titleAulas = new javax.swing.JLabel();
        aulasPanel = new javax.swing.JPanel();
        noAulasText = new javax.swing.JLabel();
        addClassButton = new javax.swing.JPanel();
        addAulaText = new javax.swing.JLabel();
        verAulasButton = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        eventosTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        documentosTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        ElemMenu1.setBackground(new java.awt.Color(235, 241, 247));

        javax.swing.GroupLayout ElemMenu1Layout = new javax.swing.GroupLayout(ElemMenu1);
        ElemMenu1.setLayout(ElemMenu1Layout);
        ElemMenu1Layout.setHorizontalGroup(
            ElemMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        ElemMenu1Layout.setVerticalGroup(
            ElemMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        ElemMenu2.setBackground(new java.awt.Color(235, 241, 247));

        javax.swing.GroupLayout ElemMenu2Layout = new javax.swing.GroupLayout(ElemMenu2);
        ElemMenu2.setLayout(ElemMenu2Layout);
        ElemMenu2Layout.setHorizontalGroup(
            ElemMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        ElemMenu2Layout.setVerticalGroup(
            ElemMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        ElemMenu3.setBackground(new java.awt.Color(235, 241, 247));

        javax.swing.GroupLayout ElemMenu3Layout = new javax.swing.GroupLayout(ElemMenu3);
        ElemMenu3.setLayout(ElemMenu3Layout);
        ElemMenu3Layout.setHorizontalGroup(
            ElemMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        ElemMenu3Layout.setVerticalGroup(
            ElemMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(ElemMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(ElemMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(ElemMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ElemMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ElemMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ElemMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setMaximumSize(new java.awt.Dimension(837, 896));
        centerPanel.setMinimumSize(new java.awt.Dimension(837, 896));

        titleAulas.setFont(new java.awt.Font("Lato", 1, 32)); // NOI18N
        titleAulas.setForeground(new java.awt.Color(51, 51, 51));
        titleAulas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleAulas.setText("Mis aulas");
        titleAulas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        aulasPanel.setBackground(new java.awt.Color(251, 251, 251));
        aulasPanel.setForeground(new java.awt.Color(236, 236, 236));
        java.awt.GridBagLayout aulasPanelLayout = new java.awt.GridBagLayout();
        aulasPanelLayout.columnWidths = new int[] {0};
        aulasPanelLayout.rowHeights = new int[] {0};
        aulasPanelLayout.columnWeights = new double[] {1.0};
        aulasPanelLayout.rowWeights = new double[] {0.0};
        aulasPanel.setLayout(aulasPanelLayout);

        noAulasText.setFont(new java.awt.Font("Lato Semibold", 0, 22)); // NOI18N
        noAulasText.setForeground(new java.awt.Color(204, 204, 204));
        noAulasText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noAulasText.setText("Aún no se han añadido aulas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        aulasPanel.add(noAulasText, gridBagConstraints);

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

        addAulaText.setFont(new java.awt.Font("Lato Semibold", 1, 16)); // NOI18N
        addAulaText.setForeground(new java.awt.Color(255, 255, 255));
        addAulaText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addAulaText.setText("Añadir aula");

        javax.swing.GroupLayout addClassButtonLayout = new javax.swing.GroupLayout(addClassButton);
        addClassButton.setLayout(addClassButtonLayout);
        addClassButtonLayout.setHorizontalGroup(
            addClassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addClassButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addAulaText, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        addClassButtonLayout.setVerticalGroup(
            addClassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClassButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(addAulaText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        verAulasButton.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        verAulasButton.setForeground(new java.awt.Color(153, 153, 153));
        verAulasButton.setText("Ver todas las aulas");
        verAulasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verAulasButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verAulasButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verAulasButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, centerPanelLayout.createSequentialGroup()
                            .addComponent(titleAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verAulasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(aulasPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verAulasButton))
                .addGap(18, 18, 18)
                .addComponent(aulasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
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

        jSeparator1.setBackground(new java.awt.Color(237, 237, 237));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        eventosTitle.setFont(new java.awt.Font("Lato Semibold", 1, 22)); // NOI18N
        eventosTitle.setForeground(new java.awt.Color(51, 51, 51));
        eventosTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eventosTitle.setText("Próximos eventos");
        eventosTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(247, Short.MAX_VALUE)))
        );

        documentosTitle.setFont(new java.awt.Font("Lato Semibold", 1, 22)); // NOI18N
        documentosTitle.setForeground(new java.awt.Color(51, 51, 51));
        documentosTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        documentosTitle.setText("Mis documentos");
        documentosTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(251, 251, 251));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventosTitle)
                    .addComponent(documentosTitle)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
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
                .addGap(112, 112, 112)
                .addComponent(eventosTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(documentosTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void addClassButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClassButtonMouseClicked

        abrirAddAulaView(); // Esto configura el listener y abre la vista de agregar aula

    }//GEN-LAST:event_addClassButtonMouseClicked

    private void verAulasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verAulasButtonMouseClicked
        AulasView aulasView = new AulasView();
        aulasView.setVisible(true);
    }//GEN-LAST:event_verAulasButtonMouseClicked

    private void verAulasButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verAulasButtonMouseEntered
        Color color = new Color(204, 204, 204);
        verAulasButton.setForeground(color);
        verAulasButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_verAulasButtonMouseEntered

    private void verAulasButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verAulasButtonMouseExited
        Color color = new Color(153, 153, 153);
        verAulasButton.setForeground(color);
        verAulasButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_verAulasButtonMouseExited

    private void backgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseClicked
        System.out.println("Mouse clicked in MainFrame");

        MenuGestion menu = MenuGestion.getInstance();
        if (menu.isVisible()) {
            menu.hideMenu(); // Oculta el menú si está visible
        }
    }//GEN-LAST:event_backgroundMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ElemMenu1;
    private javax.swing.JPanel ElemMenu2;
    private javax.swing.JPanel ElemMenu3;
    private javax.swing.JLabel addAulaText;
    private javax.swing.JPanel addClassButton;
    private javax.swing.JPanel aulasPanel;
    private javax.swing.JPanel background;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel documentosTitle;
    private javax.swing.JLabel eventosTitle;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel noAulasText;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleAulas;
    private javax.swing.JLabel verAulasButton;
    // End of variables declaration//GEN-END:variables

    private void abrirAddAulaView() {
        AddAulaView addAulaView = new AddAulaView();
        addAulaView.setAulaAddedListener(this); // Asigna el listener
        addAulaView.setVisible(true);
    }

    @Override
    public void onAulaAdded() {
        cargarAulas();
    }

    @Override
    public void onAulaDeleted() {
        cargarAulas();
    }

}
