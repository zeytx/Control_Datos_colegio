package appcolegio.visual.Mantenimiento;

import appcolegio.Conexion.Conexion;
import appcolegio.getSet.Docentes;
import appcolegio.getSet.funciones;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class jFrameDocentes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ADD_ALUMNOS
     */
    public jFrameDocentes() {
        initComponents();
        this.jTable1.setModel(func.listarDocentes());
        cargaCombo();
    }

    funciones func=new funciones();
    
    public void limpiar(){
        this.txtDni.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtEdad.setText("");
        this.comboCurso.setSelectedIndex(0);
    }
    
    
    
    public void cargaCombo(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
            String sql="SELECT * FROM TB_CURSOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            modeloCombo.addElement("-- SELECCIONE --");
            while(rs.next()){
              modeloCombo.addElement(rs.getString("COD_CURSO"));
            }
            this.comboCurso.setModel(modeloCombo);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboCurso = new javax.swing.JComboBox<>();
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
        jLabel1.setText("DOCENTES");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("DNI :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("NOMBRES:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("APELLIDOS:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("EDAD:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRES", "APELLIDOS", "EDAD"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        txtDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("CURSO ACARGO:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addGap(226, 226, 226)
                                .addComponent(jLabel5))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        func=new funciones();
        if(!func.estanVaciosTXT(txtDni, txtApellido, txtNombre, txtEdad, txtEdad)){
            Docentes doc=new Docentes();
            doc.setDni(this.txtDni.getText());
            doc.setNombre(this.txtNombre.getText());
            doc.setApellido(this.txtApellido.getText());
            doc.setEdad(Integer.parseInt(this.txtEdad.getText()));
            doc.setIdCurso(String.valueOf(this.comboCurso.getSelectedItem()));
            
            func.agregarDocentes(doc);
        
            this.jTable1.setModel(func.listarDocentes());
            limpiar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int row = this.jTable1.getSelectedRow();
        String dni = this.jTable1.getValueAt(row, 0).toString();
        func=new funciones();
        func.eliminarDocentes(dni);
        this.jTable1.setModel(func.listarDocentes());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.txtDni.setEnabled(false);
        
        int row = this.jTable1.getSelectedRow();
        this.txtDni.setText(this.jTable1.getValueAt(row, 0).toString());
        this.txtNombre.setText(this.jTable1.getValueAt(row, 1).toString());
        this.txtApellido.setText(this.jTable1.getValueAt(row, 2).toString());
        this.txtEdad.setText(this.jTable1.getValueAt(row, 3).toString());
        this.comboCurso.setSelectedItem(this.jTable1.getValueAt(row, 4).toString());
        
        this.btnAgregar.setVisible(false);
        this.btnActualizar.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Docentes doc=new Docentes();
        doc.setDni(this.txtDni.getText());
        doc.setNombre(this.txtNombre.getText());
        doc.setApellido(this.txtApellido.getText());
        doc.setEdad(Integer.parseInt(this.txtEdad.getText()));
        doc.setIdCurso(String.valueOf(this.comboCurso.getSelectedItem()));
        
        func=new funciones();
        func.actualizarDocentes(doc);
        
        limpiar();
        this.jTable1.setModel(func.listarDocentes());
        this.btnAgregar.setVisible(true);
        this.btnActualizar.setVisible(false);
        this.txtDni.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        try{
            if(this.txtDni.getText().length()>8){
                throw new Exception();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "DNI NO PUEDE TENER MAS DE 8 CARACTERES","Error",JOptionPane.ERROR_MESSAGE);
            String actualiza = this.txtDni.getText();
            this.txtDni.setText(actualiza.substring(0,8));
        }
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        try{
            char valida=evt.getKeyChar();
            if(Character.isLetter(valida)){
                evt.consume();
                throw new Exception();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "EL DNI NO PUEDE CONTENER LETRAS","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        try{
            char valida=evt.getKeyChar();
            if(Character.isLetter(valida)){
                evt.consume();
                throw new Exception();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "LA EDAD NO PUEDE CONTENER LETRAS","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtEdadKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboCurso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
