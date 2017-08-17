package cursofyb.test.myresto02.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import cursofyb.test.myresto02.modelo.Plato;

/**
 * Created by martdominguez on 28/07/2017.
 */

public class PlatoDaoSqlite implements PlatoDao {

    private MyRestoOpenHelper myHelper;

    public PlatoDaoSqlite(Context ctx){

        myHelper=MyRestoOpenHelper.getInstance(ctx);
    }

    @Override
    public Cursor getListaPlatos(){
        SQLiteDatabase db =myHelper.getReadableDatabase();
        return db.rawQuery("SELECT ID _id,NOMBRE,DESCRIPCION,ID_TIPO_PLATO,PRECIO FROM PLATO",null);
    }

    @Override
    public void nuevoPlato(Plato p){
        ContentValues cv = new ContentValues();
        cv.put("NOMBRE",p.getNombre​());
        cv.put("DESCRIPCION",p.getDescripcion​());
        cv.put("ID_TIPO_PLATO",p.getTipo().getId());
        cv.put("PRECIO",p.getPrecio​());
        SQLiteDatabase db =myHelper.getWritableDatabase();
        db.insert("PLATO",null,cv);
    }
}
