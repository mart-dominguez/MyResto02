package cursofyb.test.myresto02.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import cursofyb.test.myresto02.modelo.Usuario;

/**
 * Created by martdominguez on 17/08/17.
 */

public class UsuarioDaoSqlite implements UsuarioDao {

    private MyRestoOpenHelper myHelper;


    public UsuarioDaoSqlite(Context ct){
        myHelper=MyRestoOpenHelper.getInstance(ct);
    }

    @Override
    public void guardar(Usuario usr) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("UBICACION_DEFECTO",usr.getUbicacionDefecto().latitude+";"+usr.getUbicacionDefecto().longitude);
        cv.put("NOMBRE",usr.getNombre());
        cv.put("CORREO",usr.getCorreo());
        db.insert("USUARIO",null,cv);
    }

    @Override
    public Usuario leer() {
        Usuario ret = new Usuario();
        SQLiteDatabase db = myHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT ID,UBICACION_DEFECTO,NOMBRE,CORREO FROM USUARIO",null);
        if(c.moveToNext()){
            ret.setId(c.getInt(c.getColumnIndex("NOMBRE")));
            ret.setNombre(c.getString(c.getColumnIndex("NOMBRE")));
            ret.setCorreo(c.getString(c.getColumnIndex("CORREO")));
            String auxUb = c.getString(c.getColumnIndex("UBICACION_DEFECTO"));
            String[] auxLatLng = auxUb.split(";");
            Log.d("USUARIO::",auxUb);
            ret.setUbicacionDefecto(new LatLng(Double.valueOf(auxLatLng[0]).doubleValue(),Double.valueOf(auxLatLng[1])));
        }
        return ret;
    }
}
