package cursofyb.test.myresto02.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cursofyb.test.myresto02.modelo.TipoPlato;

/**
 * Created by martdominguez on 28/07/2017.
 */

public class TipoPlatoDAO {

    private MyRestoOpenHelper myHelper;

    public TipoPlatoDAO(Context ctx){

        myHelper=MyRestoOpenHelper.getInstance(ctx);
    }

    public void inicializar(){
     /*   TipoPlato[] arreglo = new TipoPlato[5];
        arreglo[0]=new TipoPlato("EntradaDB");
        arreglo[1]=new TipoPlato("PrincipalDB");
        arreglo[2]=new TipoPlato("PostreDB");
        arreglo[3]=new TipoPlato("MinutaDB");
        arreglo[4]=new TipoPlato("BebidaDB");

        SQLiteDatabase db = myHelper.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT ID,NOMBRE FROM TIPO_PLATO ",null);
        if(res.getCount()>0) return;
        for(TipoPlato unPlato : arreglo) {
            ContentValues valores = new ContentValues();
            valores.put("ID", unPlato.getId());
            valores.put("NOMBRE", unPlato.getNombre());
            db.insert("TIPO_PLATO", null, valores);
        }*/
    }

    public TipoPlato[] listaTipoPlato(){
        SQLiteDatabase db = this.myHelper.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT ID,NOMBRE FROM TIPO_PLATO ",null);
        int cantidad = res.getCount();
        TipoPlato[] arregloResultado = new TipoPlato[cantidad];
        int indice =0;
        while(res.moveToNext()){
            String nombre = res.getString(res.getColumnIndex("NOMBRE"));
            arregloResultado[indice]=new TipoPlato(nombre,res.getInt(res.getColumnIndex("ID")));
            indice++;
        }
        return  arregloResultado;
    }

}
