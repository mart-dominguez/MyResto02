package cursofyb.test.myresto02.modelo;

/**
 * Created by martdominguez on 04/07/2017.
 */

public class TipoPlato {

    private static Integer IDS=1;
    private Integer id;
    private String nombre;

    public TipoPlato() {
        this.id=IDS++;
    }

    public TipoPlato(String nombre) {
        this();
        this.nombre = nombre;
    }

    public TipoPlato(String nombre,Integer id){
        this.id = id;
        this.nombre=nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPlato)) return false;

        TipoPlato tipoPlato = (TipoPlato) o;

        return getId().equals(tipoPlato.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
