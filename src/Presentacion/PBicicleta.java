/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.Estado.Disponible;
import Negocio.Estado.Reservado;
import Negocio.Estado.Alquilado;
import Negocio.Estado.Devuelto;
import Negocio.Estado.Estado;
import Negocio.NBicicleta;
import Negocio.NTipo;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class PBicicleta extends javax.swing.JFrame {

    private NBicicleta nbicicleta;
    private NTipo ntipo;
    
    private int idBicicleta;
    private String modelo;
    private String color;
    private int idTipo;
    private String estado;
    private Estado stateV;
    /**
     * Creates new form PArticulo
     */
    public PBicicleta() {
        initComponents();
        nbicicleta = new NBicicleta();
        ntipo = new NTipo();
        this.setTitle("Examen Final");
        this.setLocationRelativeTo(null);
        stateV = new Estado(new Disponible());
        listarCombos();
        listar(idTipo);
    }
    
    public void limpiar(){
     txtId.setText("");
     txtModelo.setText("");
     txtColor.setText("");
    
  }
     private void registrar(){
         String[] idTipos = boxTipo.getSelectedItem().toString().split(" ");
        try {
            this.idBicicleta = Integer.parseInt(txtId.getText());
            this.modelo = txtModelo.getText();
            this.color = txtColor.getText();
            this.stateV = new Estado(new Disponible());
            this.estado = this.boxEstado.getSelectedItem().toString();
            this.idTipo = Integer.parseInt(idTipos[0]);
            
            nbicicleta.registrar(idBicicleta, modelo, color, estado, idTipo);
            listar(idTipo);
            limpiar();
        } catch (Exception e) {
            System.out.println(" (Presentacion) Error al guardar datos");
        }    
    }
     
    private void modificar(){
        String[] idTipos = boxTipo.getSelectedItem().toString().split(" ");
        try {
            this.idBicicleta = Integer.parseInt(txtId.getText());
            this.modelo = txtModelo.getText();
            this.color = txtColor.getText();
            this.estado = this.boxEstado.getSelectedItem().toString();
            this.idTipo = Integer.parseInt(idTipos[0]);
            
            
            nbicicleta.modificar(idBicicleta, modelo, color, estado, idTipo);
            listar(idTipo);
            limpiar();
        } catch (Exception e) {
            System.err.println("Capa presentacion error al modificar" + e.getMessage());
        }
    }
    
     private void eliminar(){
        this.idBicicleta = Integer.parseInt(txtId.getText());
        try {
            nbicicleta.eliminar(idBicicleta);
            listar(idTipo);
            limpiar();
        } catch (Exception e) {
             System.err.println("Capa presentacion error al eliminar " + e.getMessage());
        }
    }
     
     public void listar(int idTipo){
          try {
            ArrayList<Object[]> bicicleta = new ArrayList<>();
            bicicleta = nbicicleta.Listar(idTipo);
            
            if(!bicicleta.isEmpty()){
                String[] colums = { "ID", "Modelo", "Color","Estado","IdTipo"};
                String data[][] = new String[bicicleta.size()][bicicleta.get(0).length];
            for (int i = 0; i < bicicleta.size(); i++) {
                data[i][0] = String.valueOf(bicicleta.get(i)[0]);
                data[i][1] = String.valueOf(bicicleta.get(i)[1]);
                data[i][2] = String.valueOf(bicicleta.get(i)[2]);
                data[i][3] = String.valueOf(bicicleta.get(i)[3]);
                data[i][4] = String.valueOf(bicicleta.get(i)[4]);
            }
            jtDatos.setModel(new DefaultTableModel(data, colums));
            }else{
                deleteAllRows();
            }
            
        } catch (SQLException e) {
            System.err.println("Capa presentacion error al listar bicicletas" + e.getMessage());
        }
    }
    public void deleteAllRows() {
     DefaultTableModel dm = (DefaultTableModel) jtDatos.getModel();

    for (int i = 0; i < dm.getRowCount(); i++) {
        for (int j = 0; j < dm.getColumnCount(); j++) {
            dm.setValueAt("", i, j);
        }
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

        jLabel1 = new javax.swing.JLabel();
        ID_Label = new javax.swing.JLabel();
        nombre_Label = new javax.swing.JLabel();
        restriccion_Label = new javax.swing.JLabel();
        tipoArticulo_Label = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        jdDatos = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        boxTipo = new javax.swing.JComboBox<>();
        registrar_btn = new javax.swing.JButton();
        actualizar_btn = new javax.swing.JButton();
        eliminar_btn = new javax.swing.JButton();
        ID_Label1 = new javax.swing.JLabel();
        boxEstado = new javax.swing.JComboBox<>();
        btnEstado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("BICICLETA");

        ID_Label.setText("ID");

        nombre_Label.setText("Modelo");

        restriccion_Label.setText("Color");

        tipoArticulo_Label.setText("TIPO");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Modelo", "Color", "Estado", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDatosMouseClicked(evt);
            }
        });
        jdDatos.setViewportView(jtDatos);

        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        registrar_btn.setText("Registrar");
        registrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_btnActionPerformed(evt);
            }
        });

        actualizar_btn.setText("Modificar");
        actualizar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar_btnActionPerformed(evt);
            }
        });

        eliminar_btn.setText("Eliminar");
        eliminar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_btnActionPerformed(evt);
            }
        });

        ID_Label1.setText("ESTADO");

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Reservado", "Alquilado", "Devuelto" }));

        btnEstado.setText("Cambiar Estado");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(ID_Label)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombre_Label)
                                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ID_Label1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(181, 181, 181)
                                        .addComponent(tipoArticulo_Label))
                                    .addComponent(restriccion_Label))
                                .addGap(103, 103, 103)
                                .addComponent(btnEstado))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(registrar_btn)
                                .addGap(18, 18, 18)
                                .addComponent(actualizar_btn)
                                .addGap(18, 18, 18)
                                .addComponent(eliminar_btn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jdDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID_Label)
                            .addComponent(nombre_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ID_Label1)
                        .addGap(16, 16, 16)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoArticulo_Label)
                    .addComponent(restriccion_Label)
                    .addComponent(btnEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar_btn)
                    .addComponent(actualizar_btn)
                    .addComponent(eliminar_btn))
                .addGap(12, 12, 12)
                .addComponent(jdDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void registrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_btnActionPerformed
        
        registrar();
    }//GEN-LAST:event_registrar_btnActionPerformed

    private void actualizar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar_btnActionPerformed
        
        modificar();
    }//GEN-LAST:event_actualizar_btnActionPerformed

    private void eliminar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_btnActionPerformed

        eliminar();
    }//GEN-LAST:event_eliminar_btnActionPerformed

    private void jtDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDatosMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel model =(DefaultTableModel)jtDatos.getModel();
        int rowSelected = jtDatos.getSelectedRow();
        txtId.setText(model.getValueAt(rowSelected,0).toString()); 
        txtModelo.setText(model.getValueAt(rowSelected,1).toString()); 
        txtColor.setText(model.getValueAt(rowSelected,2).toString());
        setEstadoBox(model.getValueAt(rowSelected,3).toString()); 
    }//GEN-LAST:event_jtDatosMouseClicked

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        // TODO add your handling code here:
        estado = boxEstado.getSelectedItem().toString();
      
        switch (estado) {
            case "Disponible":
                stateV.getEstado().Disponible(stateV);
                 JOptionPane.showMessageDialog(null, stateV.getMensaje());
                 
            break;
            case "Reservado":
                   stateV.getEstado().Reservado(stateV);
                 JOptionPane.showMessageDialog(null, stateV.getMensaje());
            break;
            case "Alquilado":
                   stateV.getEstado().Alquilado(stateV);
                 JOptionPane.showMessageDialog(null, stateV.getMensaje());
            break;
            case "Devuelto":
                   stateV.getEstado().Devuelto(stateV);
                 JOptionPane.showMessageDialog(null, stateV.getMensaje());
            break;
            
            default:
                throw new AssertionError();
        }
        //listarTabla();
        limpiar();
    }//GEN-LAST:event_btnEstadoActionPerformed

    
     /*void listarTabla(){
       jtDatos.setModel(nbicicleta.listar());
    }*/
    
    void listarCombos(){
        boxTipo.setModel(ntipo.listarCombo());   
    };
    
    private void setEstadoBox(String toString) {
        switch (toString) {
            case "Disponible":
                  boxEstado.setSelectedIndex(0);
                  stateV = new Estado(new Disponible());
            break;
            case "Reservado":
                 boxEstado.setSelectedIndex(1);
                  stateV = new Estado(new Reservado());
            break;
            case "Alquilado":
                 boxEstado.setSelectedIndex(2);
                  stateV = new Estado(new Alquilado());
            break;
            case "Devuelto":
                 boxEstado.setSelectedIndex(3);
                  stateV = new Estado(new Devuelto());
                break;
            default:
                throw new AssertionError();
        }
    }
    
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
            java.util.logging.Logger.getLogger(PBicicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PBicicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PBicicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PBicicleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PBicicleta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID_Label;
    private javax.swing.JLabel ID_Label1;
    private javax.swing.JButton actualizar_btn;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton eliminar_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jdDatos;
    private javax.swing.JTable jtDatos;
    private javax.swing.JLabel nombre_Label;
    private javax.swing.JButton registrar_btn;
    private javax.swing.JLabel restriccion_Label;
    private javax.swing.JLabel tipoArticulo_Label;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}