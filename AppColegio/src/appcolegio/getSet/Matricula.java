package appcolegio.getSet;

public class Matricula {
    public String codMatricula;
    public Cursos curso;
    public Alumnos estudiantes;
    public String observacion;
    public String fecha;

    public Matricula() {
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Alumnos getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Alumnos estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        if(observacion.equals("")){
            observacion="SIN OBSERVACIONES";
        }
        this.observacion = observacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    
    public Matricula(Cursos curso, Alumnos estudiantes, String observacion, String fecha) {
        this.curso = curso;
        this.estudiantes = estudiantes;
        this.observacion = observacion;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Matricula{" + "curso=" + curso + ", estudiantes=" + estudiantes + ", observacion=" + observacion + ", fecha=" + fecha + '}';
    }
    
    
}
