package com.planifai.view;

import com.planifai.interfaces.AulaAddedListener;
import com.planifai.model.Aula;
import com.planifai.service.AulaService;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 *
 * @author marta
 */
public class AulasView extends javax.swing.JFrame implements AulaAddedListener {

    private AulaService aulaService;
    private AulaView aulaView;
    private MainFrame mainFrame;
    private boolean[] panelesCargados;
    private MenuGestionAulaView menuDesplegable;
    private static final int MAX_AULAS = 8;

    public AulasView() {
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

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        aulaService = new AulaService();
        menuDesplegable = new MenuGestionAulaView();
        aulaView = new AulaView();
        panelesCargados = new boolean[4];
        for (int i = 0; i < panelesCargados.length; i++) {
            panelesCargados[i] = false;
        }
        cargarAulas();

        // Añadir MouseListener a la ventana principal
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Verificar si el menú está visible y si el clic fue fuera de él
                if (menuDesplegable.isVisible() && !menuDesplegable.getBounds().contains(e.getPoint())) {
                    menuDesplegable.dispose();
                }
            }
        });
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
        aulasPanel.setLayout(new GridLayout(5, 2, 5, 5)); // 5 filas y 2 columnas

        int numAulas = Math.min(aulas.size(), MAX_AULAS);

        for (int i = 0; i < numAulas; i++) {
            Aula aula = aulas.get(i);
            AulaCardTemplate card = new AulaCardTemplate(aula);
            card.setPreferredSize(new Dimension(520,100));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1536, 864));

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
        aulasPanel.setLayout(new java.awt.GridBagLayout());

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
                .addGap(109, 109, 109)
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
                .addGap(74, 74, 74)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verAulasButton))
                .addGap(18, 18, 18)
                .addComponent(aulasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1069, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
            .addComponent(centerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1736, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addClassButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClassButtonMouseClicked

        abrirAddAulaView(); // Esto configura el listener y abre la vista de agregar aula
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

    private void verAulasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verAulasButtonMouseClicked
        AulasView aulasView = new AulasView(); // Crea la instancia de AulasView
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
            java.util.logging.Logger.getLogger(AulasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AulasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AulasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AulasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AulasView().setVisible(true);
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
    private javax.swing.JLabel icon;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel noAulasText;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleAulas;
    private javax.swing.JLabel verAulasButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onAulaAdded() {
        cargarAulas();
    }

    private void abrirAddAulaView() {
        AddAulaView addAulaView = new AddAulaView();
        addAulaView.setAulaAddedListener(this); // Asigna el listener
        addAulaView.setVisible(true);
    }
}