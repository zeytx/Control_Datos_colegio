package appcolegio.getSet;

public class Apoderado {
    public String dni;
    public String nombre;
    public String apellido;
    public String telf;
    public String dni_hijo;

    public Apoderado() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getDni_hijo() {
        return dni_hijo;
    }

    public void setDni_hijo(String dni_hijo) {
        this.dni_hijo = dni_hijo;
    }

    public Apoderado(String dni, String nombre, String apellido, String telf, String dni_hijo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telf = telf;
        this.dni_hijo = dni_hijo;
    }

    @Override
    public String toString() {
        return "Apoderado{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telf=" + telf + ", dni_hijo=" + dni_hijo + '}';
    }
    
}
