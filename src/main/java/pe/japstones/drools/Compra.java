package pe.japstones.drools;

import java.text.MessageFormat;

/**
 * Created by Joel on 06/04/2017.
 */
public class Compra {
    private String nombre;
    private String sexo;
    private int edad;
    private int importeCompra;
    private String regalo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getImporteCompra() {
        return importeCompra;
    }

    public void setImporteCompra(int importeCompra) {
        this.importeCompra = importeCompra;
    }

    public String getRegalo() {
        return regalo;
    }

    public void setRegalo(String regalo) {
        this.regalo = regalo;
    }

    @Override
    public String toString() {
        return MessageFormat.format("[nombre: {0}, sexo : {1}, edad: {2}, importe: {3}, regalo : {4}]", nombre,
                sexo, edad, importeCompra, regalo);
    }
}
