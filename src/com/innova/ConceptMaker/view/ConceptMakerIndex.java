/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Inicio.java
 *
 * Created on Nov 8, 2009, 3:32:20 PM
 */
package com.innova.ConceptMaker.view;

import com.innova.ConceptMaker.bo.ConceptoBO;
import com.innova.ConceptMaker.bo.TemaBO;
import com.innova.ConceptMaker.dao.ConceptDAO;
import com.innova.ConceptMaker.dao.TemaDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * @author juan
 */
public class ConceptMakerIndex extends javax.swing.JFrame {

    private static ConceptMakerIndex inicio = new ConceptMakerIndex();
    private ConceptDAO conceptDao = new ConceptDAO();
    private TemaDAO temaDao = new TemaDAO();
    private String temaSeleccionado;

    /**
     * Constructores
     */
    public ConceptMakerIndex(ConceptDAO persist) {

        temaAplicacion();
        conceptDao = persist;
        initComponents();
        llenarTemas();
        jTable1.setAutoCreateRowSorter(true);

    }

    public ConceptMakerIndex() {
        temaAplicacion();
        initComponents();
        llenarTemas();
        jTable1.setAutoCreateRowSorter(true);
    }

    /**
     * Codigo generado por netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConceptMaker");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(642, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Concepto", "Definicion", "Tema"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickConcepto(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Terminos de busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Droid Sans", 1, 13))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Droid Sans", 1, 18));
        jLabel6.setText("Tema");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione uno" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Droid Sans", 1, 18));
        jCheckBox2.setText("Todos");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Resultados:");

        jLabel10.setFont(new java.awt.Font("Droid Sans", 1, 36));
        jLabel10.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton10.setText("Limpiar");
        jButton10.setMaximumSize(new java.awt.Dimension(63, 31));
        jButton10.setMinimumSize(new java.awt.Dimension(63, 31));
        jButton10.setPreferredSize(new java.awt.Dimension(63, 31));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Nuevo");
        jButton11.setMaximumSize(new java.awt.Dimension(63, 31));
        jButton11.setMinimumSize(new java.awt.Dimension(63, 31));
        jButton11.setPreferredSize(new java.awt.Dimension(63, 31));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Ver/Editar");
        jButton12.setMaximumSize(new java.awt.Dimension(63, 31));
        jButton12.setMinimumSize(new java.awt.Dimension(63, 31));
        jButton12.setPreferredSize(new java.awt.Dimension(63, 31));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Eliminar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Conceptos", jPanel5);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Droid Sans", 1, 13))); // NOI18N

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jList1);

        jLabel7.setFont(new java.awt.Font("Droid Sans", 1, 18));
        jLabel7.setText("Lista de temas");

        jButton7.setText("Nuevo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Eliminar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Droid Sans", 1, 13))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Droid Sans", 1, 36));
        jLabel8.setText("Tema");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(591, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Temas", jPanel7);

        jMenu1.setText("Archivo");
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja la opcion Salir del menu.
     * @param evt
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Se traen los conceptos dentro del tema seleccionado (Guardados).
     * @param evt
     */
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        String temaSelec = jList1.getSelectedValue().toString();

        jLabel8.setText(temaSelec);
    }//GEN-LAST:event_jList1MouseClicked

    /**
     * Maneja el evento del boton nuevo (temas). Crea un nuevo tema.
     * @param evt
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String temaNuevo = JOptionPane.showInputDialog(jTabbedPane1, "Ingrese el " +
                "nombre del nuevo tema", "Nuevo tema", JOptionPane.QUESTION_MESSAGE);

        if (temaNuevo != null && !temaNuevo.equals("")) {
            temaDao.insertarTema(temaNuevo);

            jComboBox2.addItem(temaNuevo);

            DefaultListModel modelo = (DefaultListModel) jList1.getModel();
            modelo.addElement(temaNuevo);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * Maneja el evento del boton eliminar (temas). Elimina el tema seleccionado.
     * @param evt
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed


        if (jList1.isSelectionEmpty()) {
            JOptionPane.showConfirmDialog(jTabbedPane1, "Debe seleccionar un" +
                    "tema. \nIntente nuevamente.", "Alerta", -1, JOptionPane.ERROR_MESSAGE);
        } else {

            int opcion = JOptionPane.showConfirmDialog(jTabbedPane1, "Realmente desea " +
                    "eliminar el tema?\nSe eliminaran todos los conceptos asociados.", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opcion == 0) {
                DefaultListModel modelo = (DefaultListModel) jList1.getModel();
                String temaSelec = jList1.getSelectedValue().toString();
                temaDao.eliminarTema(temaSelec);

                //Se actualizan las listas de temas.
                jComboBox2.removeItem(temaSelec);
                modelo.removeElement(temaSelec);

                jLabel8.setText("Tema");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * Maneja el evento del boton limpiar (guardados). Limpia la tabla de conceptos
     * guardados.
     * @param evt
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        limpiarConsulta();
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * Seleccionar / deseleccionar checkBox "Todos"
     * @param evt
     */
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            temaSeleccionado = jComboBox2.getSelectedItem().toString();

            jComboBox2.setSelectedIndex(0);
            jComboBox2.setEnabled(false);
            llenarConceptos(null);
        } else {
            jComboBox2.setEnabled(true);
            jComboBox2.setSelectedItem(temaSeleccionado);
            llenarConceptos(temaSeleccionado);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * Boton editar concepto
     * @param evt
     */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        ListSelectionModel seleccionProyectos = jTable1.getSelectionModel();
        if (!seleccionProyectos.isSelectionEmpty()) {
            int conceptoFilaSeleccionada = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
            DefaultTableModel tablaConceptos = (DefaultTableModel) jTable1.getModel();


            ConceptoBO concepto = new ConceptoBO();
            concepto.setConcepto(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 0).toString());
            concepto.setSignificado(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 1).toString());
            concepto.setTema(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 2).toString());

            EditarConcepto ventanaEditar = new EditarConcepto(concepto, inicio);
            ventanaEditar.setLocationRelativeTo(null);
            ventanaEditar.setVisible(true);
        } else {
            JOptionPane.showConfirmDialog(jPanel5, "Seleccione primero un concepto a " +
                    "modificar.", "Error", -1, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * Ventana nuevo concepto.
     * @param evt
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        if (jComboBox2.getSelectedIndex() != 0) {
            NuevoConcepto ventanaNuevo = new NuevoConcepto(jComboBox2.getSelectedItem().toString(),inicio);
            ventanaNuevo.setLocationRelativeTo(null);
            ventanaNuevo.setVisible(true);
        } else {
            NuevoConcepto ventanaNuevo = new NuevoConcepto();
            ventanaNuevo.setLocationRelativeTo(null);
            ventanaNuevo.setVisible(true);
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * Boton eliminar concepto.
     * @param evt
     */
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        ListSelectionModel seleccionProyectos = jTable1.getSelectionModel();


        if (!seleccionProyectos.isSelectionEmpty()) {

            int conceptoFilaSeleccionada = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
            DefaultTableModel tablaConceptos = (DefaultTableModel) jTable1.getModel();


            ConceptoBO concepto = new ConceptoBO();
            concepto.setConcepto(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 0).toString());
            concepto.setSignificado(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 1).toString());
            concepto.setTema(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 2).toString());

            if (!conceptDao.eliminarConcepto(concepto)) {
                JOptionPane.showConfirmDialog(jPanel5, "Ocurrio un error al eliminar" +
                        "el concepto.", "Error", -1, JOptionPane.ERROR_MESSAGE);
            } else {
                llenarConceptos(concepto.getTema());
            }

        } else {
            JOptionPane.showConfirmDialog(jPanel5, "Seleccione primero un concepto a " +
                    "eliminar.", "Error", -1, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * ComboBox temas. Muestra los conceptos al seleccionar un tema.
     * @param evt
     */
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        llenarConceptos(jComboBox2.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * Doble click en un concepto
     * @param evt
     */
    private void clickConcepto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickConcepto
        int clicks = evt.getClickCount();

        if (clicks == 2) {
            ListSelectionModel seleccionProyectos = jTable1.getSelectionModel();
            if (!seleccionProyectos.isSelectionEmpty()) {
                int conceptoFilaSeleccionada = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
                DefaultTableModel tablaConceptos = (DefaultTableModel) jTable1.getModel();


                ConceptoBO concepto = new ConceptoBO();
                concepto.setConcepto(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 0).toString());
                concepto.setSignificado(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 1).toString());
                concepto.setTema(tablaConceptos.getValueAt(conceptoFilaSeleccionada, 2).toString());

                EditarConcepto ventanaEditar = new EditarConcepto(concepto, inicio);
                ventanaEditar.setLocationRelativeTo(null);
                ventanaEditar.setVisible(true);
            } else {
                JOptionPane.showConfirmDialog(jPanel5, "Seleccione primero un concepto a " +
                        "modificar.", "Error", -1, JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_clickConcepto

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                inicio.setLocationRelativeTo(null);
                inicio.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void limpiarConsulta() {
        DefaultTableModel tabla = (DefaultTableModel) jTable1.getModel();

        int numFilas = tabla.getRowCount();
        for (int j = 0; j < numFilas; j++) {
            tabla.removeRow(0);
        }

        jComboBox2.setSelectedIndex(0);
        jComboBox2.setEnabled(true);
        jCheckBox2.setSelected(false);
        jLabel10.setText("0");
    }

    /**
     * Llena la lista de temas de conceptos.
     */
    private void llenarTemas() {
        Vector<TemaBO> temas = new Vector();
        DefaultListModel modelo = new DefaultListModel();

        temas = temaDao.getTemas();

        for (int i = 0; i < temas.size(); i++) {
            jComboBox2.addItem(temas.elementAt(i).getDescripcion());
            modelo.addElement(temas.elementAt(i).getDescripcion());
        }
        jList1.setModel(modelo);
    }

    private void temaAplicacion() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(ConceptMakerIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarConceptos(String tema) {
        Vector<ConceptoBO> conceptos = new Vector();
        DefaultTableModel tabla = (DefaultTableModel) jTable1.getModel();

        //Limpia primero la tabla. Luego inserta datos.
        int numFilas = tabla.getRowCount();
        for (int j = 0; j < numFilas; j++) {
            tabla.removeRow(0);
        }

        if (jCheckBox2.isSelected()) {
            conceptos = conceptDao.getConceptos("");
        } else {

            conceptos = conceptDao.getConceptos(tema);
        }

        for (int i = 0; i < conceptos.size(); i++) {
            Object nuevo[] = {conceptos.get(i).getConcepto(), conceptos.get(i).getSignificado(),
                conceptos.get(i).getTema()};
            tabla.addRow(nuevo);
        }

        int numCon = conceptos.size();

        jLabel10.setText(String.valueOf(numCon));
    }

    public void setTemaSeleccionado(String tema) {
        jComboBox2.setSelectedItem(tema);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/book.png"));
        return retValue;
    }
}
