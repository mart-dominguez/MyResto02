package cursofyb.test.myresto02.dao;

import android.database.Cursor;

import cursofyb.test.myresto02.modelo.Plato;

/**
 * Created by mdominguez on 03/08/17.
 */

public interface PlatoDao {
    public Cursor getListaPlatos();

    public void nuevoPlato(Plato p);
}
