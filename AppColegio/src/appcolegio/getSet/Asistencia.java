package appcolegio.getSet;

public class Asistencia {
    public String fecha;
    public Alumnos al;
    public String estado;
    public String codCurso;

    public Asistencia() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public Alumnos getAl() {
        return al;
    }

    public void setAl(Alumnos al) {
        this.al = al;
    }
    
    

    public Asistencia(String fecha, String estado, String codCurso) {
        this.fecha = fecha;
        this.estado = estado;
        this.codCurso = codCurso;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "fecha=" + fecha + ", nombre=" + ", estado=" + estado + ", codCurso=" + codCurso + '}';
    }
    
}
