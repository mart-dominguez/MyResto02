package cursofyb.test.myresto02.modelo;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by martdominguez on 04/07/2017.
 */

public class Plato implements Serializable{
    private static Integer IDS=1;
    private Integer id;
    private String nombre​;
    private String descripcion​;
 //   private TipoPlato tipo;
    private Double precio​;

    public Plato() {
        this.id=IDS++;
   }

    public Plato(String nombre​, Double precio​) {
        this();
        this.nombre​ = nombre​;
        this.precio​ = precio​;
    }

    public Plato(String nombre​) {
        this();
        this.nombre​ = nombre​;
        Random r = new Random();
        this.precio​ = 100+(10*r.nextDouble());
       // this.ti
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre​() {
        return nombre​;
    }

    public void setNombre​(String nombre​) {
        this.nombre​ = nombre​;
    }

    public String getDescripcion​() {
        return descripcion​;
    }

    public void setDescripcion​(String descripcion​) {
        this.descripcion​ = descripcion​;
    }

    public Double getPrecio​() {
        return precio​;
    }

    public void setPrecio​(Double precio​) {
        this.precio​ = precio​;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre​='" + nombre​ + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plato)) return false;

        Plato plato = (Plato) o;

        return getId().equals(plato.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
