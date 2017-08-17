package cursofyb.test.myresto02.modelo;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by mdominguez on 03/08/17.
 */

public class Pedido {

    private Integer id;
    private Plato pedido;
    private Integer cantidad;
    private boolean aceptado;
    private boolean listo;
    private Usuario usuario;
    private LatLng ubicacionEntrega;

    public Pedido() {
    }



    public Pedido(Integer id, Plato pedido, Integer cantidad, boolean aceptado, boolean listo) {
        this.id = id;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.aceptado = aceptado;
        this.listo = listo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plato getPedido() {
        return pedido;
    }

    public void setPedido(Plato pedido) {
        this.pedido = pedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LatLng getUbicacionEntrega() {
        return ubicacionEntrega;
    }

    public void setUbicacionEntrega(LatLng ubicacionEntrega) {
        this.ubicacionEntrega = ubicacionEntrega;
    }


    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", pedido:" + pedido +
                ", cantidad:" + cantidad +
                ", aceptado:" + aceptado +
                ", listo:" + listo +
                '}';
    }
}
