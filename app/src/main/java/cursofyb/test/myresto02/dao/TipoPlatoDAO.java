package cursofyb.test.myresto02.dao;

import cursofyb.test.myresto02.modelo.TipoPlato;

/**
 * Created by mdominguez on 03/08/17.
 */

public  interface TipoPlatoDAO {
    public void inicializar();

    public TipoPlato[] listaTipoPlato();
}
