/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Dato.ClienteDAO;
import Dato.TiendaDAO;
import Dominio.Cliente;
import Dominio.Tienda;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Vásquez
 */
public class JFrmMantTienda extends javax.swing.JInternalFrame {

    /**
     * Creates new form JFrmMantTienda
     */
    
    public void llenar_tabla() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ubicación");
        modelo.addColumn("Estado");
        
        TiendaDAO objTiendaDAO = new TiendaDAO();
        List<Tienda> tienda = objTiendaDAO.select();
        jTable1.setModel(modelo);
        String[] dato = new String[4];
        for (int i = 0; i < tienda.size(); i++) {
            dato[0] = tienda.get(i).getCodigoTienda();
            dato[1] = tienda.get(i).getNombreTienda();
            dato[2] = tienda.get(i).getUbicacionTienda();
            dato[3] = tienda.get(i).getEstadoTienda();
            modelo.addRow(dato);
        }
    }
    
    public JFrmMantTienda() throws SQLException {
        initComponents();
        llenar_tabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTxtCodigoTienda = new javax.swing.JTextField();
        JTxtNombreTienda = new javax.swing.JTextField();
        JTxtUbicacion = new javax.swing.JTextField();
        JCmbEstado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("Mantenimiento de Tienda");

        jLabel1.setText("Código de Tienda:");

        jLabel2.setText("Nombre de Tienda:");

        jLabel3.setText("Ubicación Tienda:");

        jLabel4.setText("Estado Tienda:");

        JCmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "I" }));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cargar Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("?");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTxtCodigoTienda)
                                    .addComponent(JTxtNombreTienda)
                                    .addComponent(JTxtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6))
                            .addComponent(JCmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTxtCodigoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTxtNombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTxtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JCmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TiendaDAO objTiendaDAO = new TiendaDAO();
        Tienda objTienda = new Tienda();

        objTienda.setCodigoTienda(JTxtCodigoTienda.getText());
        objTienda.setNombreTienda(JTxtNombreTienda.getText());
        objTienda.setUbicacionTienda(JTxtUbicacion.getText());
        objTienda.setEstadoTienda(JCmbEstado.getSelectedItem().toString());
        

        if (objTienda != null) {
            if (objTiendaDAO.insert(objTienda) > 0) {
                JOptionPane.showMessageDialog(null, "¡Registro Exitoso!", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Exitoso", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Tienda objTienda = new Tienda();
        TiendaDAO objTiendaDAO = new TiendaDAO();
        objTienda.setCodigoTienda(JTxtCodigoTienda.getText());

        objTienda = objTiendaDAO.query(objTienda);

        if (!objTienda.getCodigoTienda().equals("")) {

            JOptionPane.showMessageDialog(null, "¡Registro Buscado Exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
            JTxtCodigoTienda.setText(objTienda.getCodigoTienda());
            JTxtNombreTienda.setText(objTienda.getNombreTienda());
            JTxtUbicacion.setText(objTienda.getUbicacionTienda());
            JCmbEstado.setSelectedItem(objTienda.getEstadoTienda());
            
        } else {
            JOptionPane.showMessageDialog(null, "Registro Inexistente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TiendaDAO objTiendaDAO = new TiendaDAO();
        Tienda objTienda = new Tienda();

        objTienda.setCodigoTienda(JTxtCodigoTienda.getText());
        objTienda.setNombreTienda(JTxtNombreTienda.getText());
        objTienda.setUbicacionTienda(JTxtUbicacion.getText());
        objTienda.setEstadoTienda(JCmbEstado.getSelectedItem().toString());
        

        if (objTienda != null) {
            if (objTiendaDAO.update(objTienda) > 0) {
                JOptionPane.showMessageDialog(null, "¡Registro Modificado Exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Modificado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TiendaDAO objTiendaDAO = new TiendaDAO();
        Tienda objTienda = new Tienda();

        objTienda.setCodigoTienda(JTxtCodigoTienda.getText());
        
        

        if (objTienda != null) {
            if (objTiendaDAO.delete(objTienda) > 0) {
                JOptionPane.showMessageDialog(null, "¡Registro Eliminado Exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registro No Eliminado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            llenar_tabla();
        } catch (SQLException ex) {
            Logger.getLogger(JFrmMantTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCmbEstado;
    private javax.swing.JTextField JTxtCodigoTienda;
    private javax.swing.JTextField JTxtNombreTienda;
    private javax.swing.JTextField JTxtUbicacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}