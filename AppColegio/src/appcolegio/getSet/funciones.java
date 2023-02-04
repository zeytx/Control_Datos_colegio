package appcolegio.getSet;

import appcolegio.Conexion.Conexion;
import appcolegio.visual.Mantenimiento.jFrameAlumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class funciones {
    
    public DefaultTableModel listarAlumnos(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"DNI","NOMBRES","APELLIDOS","EDAD"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[4];
            String sql="SELECT * FROM TB_ALUMNOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
              llenado[0]=rs.getString("DNI");
              llenado[1]=rs.getString("NOMBRES");
              llenado[2]=rs.getString("APELLIDOS");
              llenado[3]=rs.getString("EDAD");
              modeloTabla.addRow(llenado);
            }
            con.close();
            return modeloTabla;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarAlumnos(Alumnos al){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="INSERT INTO TB_ALUMNOS VALUES ('"+al.getDni()+"','"+al.getNombres()+"','"+al.getApellidos()+"',"+al.getEdad()+")";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "ALUMNO AGREGADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarAlumnos(String dniAlumno){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="DELETE FROM TB_ALUMNOS WHERE DNI='"+dniAlumno+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "ALUMNO ELIMINADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarAlumnos(Alumnos al){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="UPDATE TB_ALUMNOS SET NOMBRES='"+al.getNombres()+"',APELLIDOS = '"+al.getApellidos()+"' ,EDAD="+al.getEdad()+" where DNI='"+al.getDni()+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel listarCursos(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"CODIGO","NOMBRE","DETALLES"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[3];
            String sql="SELECT * FROM TB_CURSOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
              llenado[0]=rs.getString("COD_CURSO");
              llenado[1]=rs.getString("NOMBRE");
              llenado[2]=rs.getString("DETALLE");
              modeloTabla.addRow(llenado);
            }
            con.close();
            return modeloTabla;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarCursos(Cursos curso){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="INSERT INTO TB_CURSOS VALUES ('"+curso.getCodigo()+"','"+curso.getNombre()+"','"+curso.getDetalle()+"')";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "CURSO AGREGADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCursos(String codCurso){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="DELETE FROM TB_CURSOS WHERE COD_CURSO='"+codCurso+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "CURSO ELIMINADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarCursos(Cursos cursos){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="UPDATE TB_CURSOS SET NOMBRE='"+cursos.getNombre()+"',DETALLE='"+cursos.getDetalle()+"' WHERE COD_CURSO='"+cursos.getCodigo()+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "DOCENTE ACTUALIZADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel listarDocentes(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"DNI","NOMBRES","APELLIDOS","EDAD","CURSO"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[5];
            String sql="SELECT * FROM TB_PROFESOR";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
              llenado[0]=rs.getString("DNI");
              llenado[1]=rs.getString("NOMBRES");
              llenado[2]=rs.getString("APELLIDOS");
              llenado[3]=rs.getString("EDAD");
              llenado[4]=rs.getString("CURSO");
              modeloTabla.addRow(llenado);
            }
            con.close();
            return modeloTabla;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarDocentes(Docentes doc){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="INSERT INTO TB_PROFESOR VALUES ('"+doc.getDni()+"','"+doc.getNombre()+"','"+doc.getApellido()+"',"+doc.getEdad()+",'"+doc.getIdCurso()+"')";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "DOCENTE AGREGADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarDocentes(String dni){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="DELETE FROM TB_PROFESOR WHERE DNI='"+dni+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "DOCENTE ELIMINADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarDocentes(Docentes doc){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="UPDATE TB_PROFESOR SET NOMBRES='"+doc.getNombre()+"',APELLIDOS='"+doc.getApellido()+"',EDAD="+doc.getEdad()+",CURSO='"+doc.getIdCurso()+"' WHERE DNI='"+doc.getDni()+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "CURSO MODIFICADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel listarApoderado(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"DNI","NOMBRES","APELLIDOS","TELF","DNI HIJO"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[5];
            String sql="SELECT * FROM TB_APODERADOS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
              llenado[0]=rs.getString("DNI");
              llenado[1]=rs.getString("NOMBRE");
              llenado[2]=rs.getString("APELLIDO");
              llenado[3]=rs.getString("TELF");
              llenado[4]=rs.getString("DNI_HIJO");
              modeloTabla.addRow(llenado);
            }
            con.close();
            return modeloTabla;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarApoderado(Apoderado apode){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="INSERT INTO TB_APODERADOS VALUES ('"+apode.getDni()+"','"+apode.getNombre()+"','"+apode.getApellido()+"','"+apode.getTelf()+"','"+apode.getDni_hijo()+"')";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "APODERADO AGREGADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarApoderado(String dni){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="DELETE FROM TB_APODERADOS WHERE DNI='"+dni+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "APODERADO ELIMINADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarApoderado(Apoderado apo){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="UPDATE TB_APODERADOS SET NOMBRE='"+apo.getNombre()+"',APELLIDO='"+apo.getApellido()+"',TELF='"+apo.getTelf()+"',DNI_HIJO='"+apo.getDni_hijo()+"' WHERE DNI='"+apo.getDni()+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "APODERADO MODIFICADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel listarNotas(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"DNI","T1","T2","PARCIAL","FINAL"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[5];
            String sql="SELECT * FROM TB_NOTAS";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
              llenado[0]=rs.getString("DNI_ALUMNO");
              llenado[1]=rs.getString("EXAMENT1");
              llenado[2]=rs.getString("EXAMENT2");
              llenado[3]=rs.getString("PARCIAL");
              llenado[4]=rs.getString("FINAL");
              modeloTabla.addRow(llenado);
            }
            con.close();
            return modeloTabla;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarNotas(Notas grade){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="INSERT INTO TB_NOTAS VALUES ('"+grade.getDni()+"',"+grade.getExt1()+","+grade.getExt2()+","+grade.getExparcial()+","+grade.getExfinal()+")";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "NOTAS AGREGADAS");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarNotas(String dni){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="DELETE FROM TB_NOTAS WHERE DNI_ALUMNO='"+dni+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "NOTA ELIMINADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarNotas(Notas grade){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="UPDATE TB_NOTAS SET EXAMENT1="+grade.getExt1()+",EXAMENT2="+grade.getExt2()+",PARCIAL="+grade.getExparcial()+",FINAL="+grade.getExfinal()+" WHERE DNI_ALUMNO='"+grade.getDni()+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "NOTAS MODIFICADAS");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MODIFICAR","Error",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel listarMatricula(){
        try{
            Connection con;
            con=Conexion.getConnection();
            
            String titulos[]={"COD.MATRICULA","COD.CURSO","NOMBRE CURSO","DNI ALUMNO","NOMBRE ALUMNO","FECHA MATRICULA","OBSERVACION"};
            DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
            
            String llenado[] = new String[7];
            String sql="SELECT * FROM TB_MATRICULA";
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
            con.close();
            return modeloTabla;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NO SE PUEDE MOSTRAR DATOS ERR: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jFrameAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarMatricula(Matricula matricula){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="INSERT INTO TB_MATRICULA VALUES ('"+matricula.getCodMatricula()+"','"+matricula.getCurso().getCodigo()+"','"+matricula.getCurso().getNombre()+"','"+
                    matricula.getEstudiantes().getDni()+"','"+matricula.getEstudiantes().getNombres()+"','"+matricula.getFecha()+"','"+matricula.getObservacion()+"')";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "MATRICULA AGREGADA");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarMatricula(String codio){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="DELETE FROM TB_MATRICULA WHERE COD_MATRICULAR='"+codio+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "MATRICULA ELIMINADO");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarListadeEstudiantes(Asistencia asistencia,Alumnos al){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="INSERT INTO TB_ASISTENCIA VALUES ('"+asistencia.getFecha()+"','"+al.getDni()+"','"+al.getNombres()+"','"+
                    al.getApellidos()+"','FALTA','"+asistencia.getCodCurso()+"')";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarAsistencia(String estado,String codigo,String fecha, String dni){
        try {
            Connection con;
            con=Conexion.getConnection();
            String sql="UPDATE TB_ASISTENCIA SET ESTADO='"+estado+"' WHERE COD_CURSO='"+codigo+"' AND FECHA='"+fecha+"' and DNI='"+dni+"'";
            PreparedStatement pts=con.prepareStatement(sql);
            pts.executeUpdate();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MODIFICAR","Error",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean estanVaciosTXT(JTextField txt1,JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5){
        if(txt1.getText().equals("")||txt2.getText().equals("")||txt3.getText().equals("")||txt4.getText().equals("")||txt5.getText().equals("")){
            JOptionPane.showMessageDialog(null, "NO SE PERMITE ESPACIOS EN BLANCO","Error",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }
    
    public void prueba(int q){
        
    }
}
