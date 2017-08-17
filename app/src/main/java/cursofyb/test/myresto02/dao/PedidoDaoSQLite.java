package cursofyb.test.myresto02.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import cursofyb.test.myresto02.modelo.Pedido;

/**
 * Created by martdominguez on 17/08/17.
 */

public class PedidoDaoSQLite implements PedidoDao {

    private MyRestoOpenHelper myHelper;

    public PedidoDaoSQLite(Context ctx){

        myHelper=MyRestoOpenHelper.getInstance(ctx);
    }


    @Override
    public void hacerPedido(Pedido p) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID_PLATO",p.getPedido().getId());
        cv.put("CANTIDAD",3);
        cv.put("ACEPTADO",1);
        cv.put("LISTO",0);
        cv.put("ID_USUARIO",p.getUsuario().getId());
        String ubicacion = (p.getUbicacionEntrega()!=null && p.getUbicacionEntrega().toString().trim().length()>0) ? p.getUbicacionEntrega().toString():p.getUsuario().getUbicacionDefecto().toString();
        Log.d("RESTO::MAP",ubicacion);
        cv.put("UBICACION",ubicacion);
    }

    @Override
    public Boolean pedidoListo(Integer id) {
        return null;
    }

    @Override
    public Pedido cargarPedido() {
        return null;
    }
}
