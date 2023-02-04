/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package appcolegio.visual.Mantenimiento;

import appcolegio.Conexion.Conexion;
import appcolegio.getSet.Alumnos;
import appcolegio.getSet.Asistencia;
import appcolegio.getSet.ClaseHolder;
import appcolegio.getSet.Cursos;
import appcolegio.getSet.Matricula;
import appcolegio.getSet.funciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class jFrameMatricula extends javax.swing.JInternalFrame {

    /**
     * Creates new form jFrameMatricula
     */
    public jFrameMatricula() {
        initComponents();
        ClaseHolder Buscar = new ClaseHolder("BUSCAR POR DNI", this.txtBuscar);
        cargaComboCurso();
        cargaComboAlumnos();
        limpiar();
        this.jTable1.setModel(func.listarMatricula());
    }

    funciones func=new funciones();
    
    public void limpiar(){
            Calendar diaActual = new GregorianCalendar();
            this.comboCurso.setSelectedIndex(0);
            this.comboDNI.setSelectedIndex(0);
            this.txtBuscar.setText("");
            this.txtNombreCurso.setText("");
            this.txtNombreEstudiante.setText("");
            this.txtObservacion.setText("");
            
            jDateMatricula.setLocale(new Locale("es"));
            jDateMatricula.setDateFormatString("dd-MM-yyyy");
            this.jDateMatricula.setCalendar(diaActual);
    }
    
    public void listaBusca(String nombre){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"COD.MATRICULA","COD.CURSO","NOMBRE CURSO","DNI ALUMNO","NOMBRE ALUMNO","FECHA MATRICULA","OBSERVACION"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[7];
            String sql="SELECT * FROM TB_MATRICULA WHERE DNI_ALUMNO LIKE '%"+nombre+"%'";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                llenado[0]=rs.getString("COD_MATRICULAR");
                llenado[1]=rs.getString("COD_CURSO");
                llenado[2]=rs.getString("NOMBRE_CURSO");
                llenado[3]=rs.getString("DNI_ALUMNO");
                llenado[4]=rs.getString("NOMBRE_ALUMNO");
                llenado[5]=rs.getString("FECHA_MATRICULA");
                llenado[6]=rs.getString("OBSERVACION");
              modeloTabla.addRow(llenado);
            }
            this.jTable1.setModel(modeloTabla);
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameApoderado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    List<String> listaCurso = new ArrayList<String>();
    
    public void cargaComboCurso(){
        try{
            Connection con;
            con=Conexion.getConnection();
            listaCurso = new ArrayList<String>();
            DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
            String sql="SELECT * FROM TB_CURSOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            modeloCombo.addElement("-- SELECCIONE --");
            while(rs.next()){
              modeloCombo.addElement(rs.getString("COD_CURSO"));
              listaCurso.add(rs.getString("NOMBRE"));
            }
            this.comboCurso.setModel(modeloCombo);
            con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    List<String> listaAlumnos = new ArrayList<String>();
    
    public void cargaComboAlumnos(){
        try{
            Connection con;
            con=Conexion.getConnection();
            listaAlumnos = new ArrayList<String>();
            DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
            String sql="SELECT * FROM TB_ALUMNOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            modeloCombo.addElement("-- SELECCIONE --");
            while(rs.next()){
              modeloCombo.addElement(rs.getString("DNI"));
              listaAlumnos.add(rs.getString("NOMBRES"));
            }
            this.comboDNI.setModel(modeloCombo);
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
        jLabel1 = new javax.swing.JLabel();
        comboCurso = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreCurso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreEstudiante = new javax.swing.JTextField();
        comboDNI = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateMatricula = new com.toedter.calendar.JDateChooser();

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MATRICULA");

        comboCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCursoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("COD. CURSO:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("DETALLE CURSO:");

        txtNombreCurso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreCurso.setEnabled(false);
        txtNombreCurso.setFocusTraversalPolicyProvider(true);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("DNI:");

        txtNombreEstudiante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreEstudiante.setEnabled(false);
        txtNombreEstudiante.setFocusTraversalPolicyProvider(true);

        comboDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDNIActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("NOMBRE:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("FECHA MATRICULA:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("OBSERVACION:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD.CURSO", "DETALLE CURSO", "DNI ALUMNO", "NOMBRE ALUMNO", "FECHA MATRICULA", "OBSERVACION"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcolegio/img/agregarpng.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboDNI, 0, 254, Short.MAX_VALUE)
                                    .addComponent(jDateMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreCurso))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                    .addComponent(txtObservacion))))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Matricula matri=new Matricula();
        Cursos cur=new Cursos();
        Alumnos alu=new Alumnos();
        
        cur.setCodigo((String) this.comboCurso.getSelectedItem());
        cur.setNombre(this.txtNombreCurso.getText());
        matri.setCurso(cur);
        
        alu.setDni((String) this.comboDNI.getSelectedItem());
        alu.setNombres(this.txtNombreEstudiante.getText());
        matri.setEstudiantes(alu);
        
        Date date = this.jDateMatricula.getDate();
        SimpleDateFormat formato=new SimpleDateFormat("dd-MM-YYYY");
        
        String dia = formato.format(date);
        matri.setFecha(dia);
        
        matri.setObservacion(this.txtObservacion.getText());
        
        String cod=cur.getCodigo().trim()+alu.getNombres().substring(1,3)+alu.getDni();
        matri.setCodMatricula(cod.trim());
        
        func=new funciones();
        func.agregarMatricula(matri);

        limpiar();
        this.jTable1.setModel(func.listarMatricula());
        
        Asistencia asistencia=new Asistencia();
        Alumnos alum=new Alumnos();
        SimpleDateFormat fs=new SimpleDateFormat("dd-MM-YYYY");
        Date fecha = new Date();
            
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void comboCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCursoActionPerformed
        int indice = this.comboCurso.getSelectedIndex();
        if(indice<=0){
           this.txtNombreCurso.setText(""); 
        }else{
           this.txtNombreCurso.setText(this.listaCurso.get(indice-1)); 
        }
    }//GEN-LAST:event_comboCursoActionPerformed

    private void comboDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDNIActionPerformed
        int indice = this.comboDNI.getSelectedIndex();
        if(indice<=0){
           this.txtNombreEstudiante.setText(""); 
        }else{
           this.txtNombreEstudiante.setText(this.listaAlumnos.get(indice-1)); 
        }
    }//GEN-LAST:event_comboDNIActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int row = this.jTable1.getSelectedRow();
        String codigo = this.jTable1.getValueAt(row, 0).toString();
        func=new funciones();
        func.eliminarMatricula(codigo);
        this.jTable1.setModel(func.listarMatricula());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        listaBusca(this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboCurso;
    private javax.swing.JComboBox<String> comboDNI;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateMatricula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombreCurso;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
