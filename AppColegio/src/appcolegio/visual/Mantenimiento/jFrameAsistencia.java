/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package appcolegio.visual.Mantenimiento;

import appcolegio.Conexion.Conexion;
import appcolegio.getSet.Alumnos;
import appcolegio.getSet.Asistencia;
import appcolegio.getSet.funciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class jFrameAsistencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form jFrameAsistencia
     */
    public jFrameAsistencia() {
        initComponents();
        listarCombo();
        this.jLabel3.setText(fs.format(fecha));
    }

    SimpleDateFormat fs=new SimpleDateFormat("dd-MM-YYYY");
    Date fecha = new Date();
            
    public void ListarAsistenciaExiste(String codigo){
        try{
            Connection con;
            con=Conexion.getConnection();
            int counter=0;
            
            String sql="SELECT * FROM TB_ASISTENCIA WHERE FECHA='"+fs.format(fecha)+"' AND COD_CURSO='"+codigo+"'";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                counter++;
            }
            if(counter!=0){
                MostarTablaEstudiantesLista(codigo);
            }else{
                CrearLista(codigo);
            }
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameApoderado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CrearLista(String codigo){
        try{
            Connection con;
            con=Conexion.getConnection();
            Asistencia asistencia=new Asistencia();
            Alumnos alum=new Alumnos();
            funciones func=new funciones();
            
            String llenado[] = new String[4];
            String sql="SELECT DNI_ALUMNO,NOMBRES,APELLIDOS FROM TB_MATRICULA INNER JOIN TB_ALUMNOS ON TB_MATRICULA.DNI_ALUMNO = TB_ALUMNOS.DNI WHERE COD_CURSO='"+codigo+"'";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                asistencia=new Asistencia();
                alum=new Alumnos();
                func=new funciones();
                
                asistencia.setFecha(fs.format(fecha));
                alum.setDni(rs.getString("DNI_ALUMNO"));
                alum.setNombres(rs.getString("NOMBRES"));
                alum.setApellidos(rs.getString("APELLIDOS"));
                asistencia.setCodCurso(codigo);
                func.agregarListadeEstudiantes(asistencia,alum);
            }
            con.close();
            MostarTablaEstudiantesLista(codigo);           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameApoderado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void MostarTablaEstudiantesLista(String codigo){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"DNI","NOMBRES","APELLIDOS","ESTADO"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[4];
            String sql="SELECT * FROM TB_ASISTENCIA WHERE FECHA='"+fs.format(fecha)+"' AND COD_CURSO='"+codigo+"'";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                llenado[0]=rs.getString("DNI");
                llenado[1]=rs.getString("NOMBRE");
                llenado[2]=rs.getString("APELLIDO");
                llenado[3]=rs.getString("ESTADO");

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
    
    public void listarCombo(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
            String llenado[] = new String[1];
            String sql="SELECT COD_CURSO FROM TB_CURSOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            modeloCombo.addElement("-- SELECCIONE --");
            while(rs.next()){
              modeloCombo.addElement(rs.getString("COD_CURSO"));
            }
            this.jComboBox1.setModel(modeloCombo);
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
        jMenuItem3 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jMenuItem1.setText("ASISTIO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("TARDANZA");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("FALTA");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jLabel1.setText("COD CURSO:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRES", "APELLIDOS", "ESTADO"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("ASISTENCIA");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DD-MM-YYYY");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        ListarAsistenciaExiste(String.valueOf(this.jComboBox1.getSelectedItem()));
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        funciones fun=new funciones();
        int row = this.jTable1.getSelectedRow();
        
        String codCurso = String.valueOf(this.jComboBox1.getSelectedItem());
        SimpleDateFormat fs=new SimpleDateFormat("dd-MM-YYYY");
        Date fecha = new Date();
        String dia = fs.format(fecha);
        String dni = this.jTable1.getValueAt(row, 0).toString();
        fun.actualizarAsistencia("ASISTIO",codCurso,dia,dni);
        
        MostarTablaEstudiantesLista(codCurso);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        funciones fun=new funciones();
        int row = this.jTable1.getSelectedRow();
        
        String codCurso = String.valueOf(this.jComboBox1.getSelectedItem());
        String dia = fs.format(fecha);
        String dni = this.jTable1.getValueAt(row, 0).toString();
        fun.actualizarAsistencia("TARDANZA",codCurso,dia,dni);
        
        MostarTablaEstudiantesLista(codCurso);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        funciones fun=new funciones();
        int row = this.jTable1.getSelectedRow();
        
        String codCurso = String.valueOf(this.jComboBox1.getSelectedItem());
        fecha = new Date();
        String dia = fs.format(fecha);
        String dni = this.jTable1.getValueAt(row, 0).toString();
        fun.actualizarAsistencia("FALTO",codCurso,dia,dni);
        
        MostarTablaEstudiantesLista(codCurso);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
