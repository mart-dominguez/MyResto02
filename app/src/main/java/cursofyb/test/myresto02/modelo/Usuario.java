package cursofyb.test.myresto02.modelo;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by martdominguez on 17/08/17.
 */

public class Usuario {
    private Integer id;
    private String nombre;
    private String correo;
    private LatLng ubicacionDefecto;

    public Usuario(Integer id, String nombre, String correo, LatLng ubicacionDefecto) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.ubicacionDefecto = ubicacionDefecto;
    }

    public Usuario(String nombre, String correo, LatLng ubicacionDefecto) {
        this.nombre = nombre;
        this.correo = correo;
        this.ubicacionDefecto = ubicacionDefecto;
    }

    public Usuario() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LatLng getUbicacionDefecto() {
        return ubicacionDefecto;
    }

    public void setUbicacionDefecto(LatLng ubicacionDefecto) {
        this.ubicacionDefecto = ubicacionDefecto;
    }
}
