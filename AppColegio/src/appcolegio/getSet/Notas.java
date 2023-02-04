package appcolegio.getSet;

public class Notas {
    public String dni;
    public int ext1;
    public int ext2;
    public int exparcial;
    public int exfinal;

    public Notas() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getExt1() {
        return ext1;
    }

    public void setExt1(int ext1) {
        this.ext1 = ext1;
    }

    public int getExt2() {
        return ext2;
    }

    public void setExt2(int ext2) {
        this.ext2 = ext2;
    }

    public int getExparcial() {
        return exparcial;
    }

    public void setExparcial(int exparcial) {
        this.exparcial = exparcial;
    }

    public int getExfinal() {
        return exfinal;
    }

    public void setExfinal(int exfinal) {
        this.exfinal = exfinal;
    }

    public Notas(String dni, int ext1, int ext2, int exparcial, int exfinal) {
        this.dni = dni;
        this.ext1 = ext1;
        this.ext2 = ext2;
        this.exparcial = exparcial;
        this.exfinal = exfinal;
    }

    @Override
    public String toString() {
        return "Notas{" + "dni=" + dni + ", ext1=" + ext1 + ", ext2=" + ext2 + ", exparcial=" + exparcial + ", exfinal=" + exfinal + '}';
    }
    
}
