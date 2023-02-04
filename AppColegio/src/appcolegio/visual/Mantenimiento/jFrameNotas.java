package appcolegio.visual.Mantenimiento;

import appcolegio.Conexion.Conexion;
import appcolegio.getSet.Notas;
import appcolegio.getSet.funciones;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class jFrameNotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ADD_ALUMNOS
     */
    public jFrameNotas() {
        initComponents();
        this.jTable1.setModel(func.listarNotas());
        cargaCombo();
    }

    funciones func=new funciones();
    
    public void limpiar(){
        this.comboAlumno.setSelectedIndex(0);
        this.txtNombreAlumno.setText("");
        this.txtT1.setText("0");
        this.txtT2.setText("0");
        this.txtParcial.setText("0"); 
        this.txtFinal.setText("0"); 
    }
    
    List<String> lista = new ArrayList<String>();
    
    public void cargaCombo(){
        try{
            Connection con;
            con=Conexion.getConnection();
            lista = new ArrayList<String>();
            DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
            String sql="SELECT * FROM TB_ALUMNOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            modeloCombo.addElement("-- SELECCIONE --");
            while(rs.next()){
              modeloCombo.addElement(rs.getString("DNI"));
              lista.add(rs.getString("NOMBRES"));
            }
            this.comboAlumno.setModel(modeloCombo);
            con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameCursos.class.getName()).log(Level.SEVERE, null, ex);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtT1 = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        comboAlumno = new javax.swing.JComboBox<>();
        txtNombreAlumno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtT2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtParcial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFinal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("ELIMINAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("MODIFICAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOTAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("DNI ALUMNO:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("T1:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "T1", "T2", "PARCIAL", "FINAL"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        txtT1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtT1KeyTyped(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcolegio/img/agregarpng.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcolegio/img/actualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        comboAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAlumnoActionPerformed(evt);
            }
        });

        txtNombreAlumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreAlumno.setEnabled(false);
        txtNombreAlumno.setFocusTraversalPolicyProvider(true);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("NOMBRE ALUMNO:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("T2:");

        txtT2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtT2KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("PACIAL:");

        txtParcial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtParcial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParcialKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("FINAL:");

        txtFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFinalKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel2)
                                .addComponent(txtNombreAlumno)
                                .addComponent(comboAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtT1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtT2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(comboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtT1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtT2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtParcial))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Notas grade=new Notas();
        grade.setDni(String.valueOf(this.comboAlumno.getSelectedItem()));
        grade.setExt1(Integer.parseInt(this.txtT1.getText()));
        grade.setExt2(Integer.parseInt(this.txtT2.getText()));
        grade.setExparcial(Integer.parseInt(this.txtParcial.getText()));
        grade.setExfinal(Integer.parseInt(this.txtFinal.getText()));
        
        func=new funciones();
        func.agregarNotas(grade);
        
        limpiar();
        this.jTable1.setModel(func.listarNotas());
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int row = this.jTable1.getSelectedRow();
        String dni = this.jTable1.getValueAt(row, 0).toString();
        func=new funciones();
        func.eliminarNotas(dni);
        this.jTable1.setModel(func.listarNotas());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.comboAlumno.setEnabled(false);
        
        int row = this.jTable1.getSelectedRow();
        this.comboAlumno.setSelectedItem(this.jTable1.getValueAt(row, 0).toString());
        this.txtNombreAlumno.setText(lista.get(this.comboAlumno.getSelectedIndex()-1));
        this.txtT1.setText(this.jTable1.getValueAt(row, 1).toString());
        this.txtT2.setText(this.jTable1.getValueAt(row, 2).toString());
        this.txtParcial.setText(this.jTable1.getValueAt(row, 3).toString());
        this.txtFinal.setText(this.jTable1.getValueAt(row, 4).toString());
        
        this.btnAgregar.setVisible(false);
        this.btnActualizar.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Notas grade=new Notas();
        grade.setDni(String.valueOf(this.comboAlumno.getSelectedItem()));
        grade.setExt1(Integer.parseInt(this.txtT1.getText()));
        grade.setExt2(Integer.parseInt(this.txtT2.getText()));
        grade.setExparcial(Integer.parseInt(this.txtParcial.getText()));
        grade.setExfinal(Integer.parseInt(this.txtFinal.getText()));
        
        func=new funciones();
        func.actualizarNotas(grade);
        
        limpiar();
        this.jTable1.setModel(func.listarNotas());
        this.btnAgregar.setVisible(true);
        this.btnActualizar.setVisible(false);
        this.comboAlumno.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void comboAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAlumnoActionPerformed
        int indice = this.comboAlumno.getSelectedIndex();
        if(indice<=0){
           this.txtNombreAlumno.setText(""); 
        }else{
           this.txtNombreAlumno.setText(lista.get(indice-1)); 
        }
    }//GEN-LAST:event_comboAlumnoActionPerformed

    private void txtT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtT1KeyTyped
        try{
            char valida=evt.getKeyChar();
            if(Character.isLetter(valida)){
                evt.consume();
                throw new Exception();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "LA NOTA NO PUEDE CONTENER LETRAS","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtT1KeyTyped

    private void txtT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtT2KeyTyped
        try{
            char valida=evt.getKeyChar();
            if(Character.isLetter(valida)){
                evt.consume();
                throw new Exception();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "LA NOTA NO PUEDE CONTENER LETRAS","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtT2KeyTyped

    private void txtParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParcialKeyTyped
        try{
            char valida=evt.getKeyChar();
            if(Character.isLetter(valida)){
                evt.consume();
                throw new Exception();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "LA NOTA NO PUEDE CONTENER LETRAS","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtParcialKeyTyped

    private void txtFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinalKeyTyped
        try{
            char valida=evt.getKeyChar();
            if(Character.isLetter(valida)){
                evt.consume();
                throw new Exception();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "LA NOTA NO PUEDE CONTENER LETRAS","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtFinalKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboAlumno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JTextField txtParcial;
    private javax.swing.JTextField txtT1;
    private javax.swing.JTextField txtT2;
    // End of variables declaration//GEN-END:variables
}