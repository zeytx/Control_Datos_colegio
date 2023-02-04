package appcolegio.getSet;

public class Alumnos {
    public String dni;
    public String nombres;
    public String apellidos;
    public int edad;

    public Alumnos() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Alumnos(String dni, String nombres, String apellidos, int edad) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "dni=" + dni + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
    
}
