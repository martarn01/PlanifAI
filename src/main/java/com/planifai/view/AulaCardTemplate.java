package com.planifai.view;

import com.planifai.interfaces.AulaListener;
import com.planifai.model.Aula;
import com.planifai.view.MenuGestion.TipoElemento;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.LayoutManager;

/**
 * Clase que representa un template de tarjeta para mostrar información de un
 * aula.
 *
 * @author Marta rosado nabais
 */
public class AulaCardTemplate extends javax.swing.JPanel {

    private MenuGestion menuDesplegable;
    private Aula aula;
    private AulaView aulaView;
    private static final Color COLOR_HOVER = new Color(215, 197, 236);
    private static final Color COLOR_CARD = new Color(227, 206, 253);

    private TipoElemento tipoElemento;

    public AulaCardTemplate(Aula aula, AulaListener aulaListener) {
        initComponents();
        this.aula = aula;

        menuDesplegable = new MenuGestion(tipoElemento.AULA, aula.getIdAula());
        menuDesplegable.setAulaListener(aulaListener); 

        aulaView = new AulaView(aula);
        cargarDatosAula();

    }

    public AulaCardTemplate(Aula aula, LayoutManager layout) {
        super(layout);
        this.aula = aula;
    }

    public AulaCardTemplate(Aula aula, boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        this.aula = aula;
    }

    /**
     * Carga los datos del aula en los componentes visuales del template.
     * Actualiza los labels con el nombre y la asignatura del aula.
     */
    private void cargarDatosAula() {
        nombreLabel.setText(aula.getNombre());
        asignaturaLabel.setText(aula.getAsignatura());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aulaCard = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        asignaturaLabel = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(715, 100));
        setMinimumSize(new java.awt.Dimension(715, 100));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        aulaCard.setBackground(new java.awt.Color(227, 206, 253));
        aulaCard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        nombreLabel.setFont(new java.awt.Font("Lato Semibold", 1, 24)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(51, 51, 51));
        nombreLabel.setText(" ");

        asignaturaLabel.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        asignaturaLabel.setForeground(new java.awt.Color(51, 51, 51));
        asignaturaLabel.setText(" ");

        menu.setBackground(new java.awt.Color(102, 255, 102));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu1.png"))); // NOI18N
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout aulaCardLayout = new javax.swing.GroupLayout(aulaCard);
        aulaCard.setLayout(aulaCardLayout);
        aulaCardLayout.setHorizontalGroup(
            aulaCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aulaCardLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(aulaCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(asignaturaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(menu)
                .addGap(23, 23, 23))
        );
        aulaCardLayout.setVerticalGroup(
            aulaCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aulaCardLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(aulaCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aulaCardLayout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aulaCardLayout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asignaturaLabel)
                        .addGap(17, 17, 17))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aulaCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aulaCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        aulaView.setVisible(true);
        MainFrame mainframe = new MainFrame();
        mainframe.dispose();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        aulaCard.setBackground(COLOR_HOVER);
        aulaCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        aulaCard.setBackground(COLOR_CARD);
        aulaCard.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseExited

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        menuDesplegable.showMenu(x, y, aula.getIdAula());
    }//GEN-LAST:event_menuMouseClicked

    private void menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseEntered
        menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuMouseEntered

    private void menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseExited
        menu.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_menuMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asignaturaLabel;
    private javax.swing.JPanel aulaCard;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel nombreLabel;
    // End of variables declaration//GEN-END:variables

}
