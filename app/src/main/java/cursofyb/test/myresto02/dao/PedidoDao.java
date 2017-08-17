package cursofyb.test.myresto02.dao;

import cursofyb.test.myresto02.modelo.Pedido;

/**
 * Created by mdominguez on 03/08/17.
 */

public interface PedidoDao {

    public void hacerPedido(Pedido p);

    public Boolean pedidoListo(Integer id);

    public Pedido cargarPedido();

}
