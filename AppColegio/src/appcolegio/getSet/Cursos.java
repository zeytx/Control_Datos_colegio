package appcolegio.getSet;

public class Cursos {
    public String codigo;
    public String nombre;
    public String detalle;

    public Cursos() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Cursos(String codigo, String nombre, String detalle) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Cursos{" + "codigo=" + codigo + ", nombre=" + nombre + ", detalle=" + detalle + '}';
    }

}
