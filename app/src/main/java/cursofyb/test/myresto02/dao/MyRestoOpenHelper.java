package cursofyb.test.myresto02.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.maps.model.LatLng;

import cursofyb.test.myresto02.modelo.Plato;
import cursofyb.test.myresto02.modelo.TipoPlato;
import cursofyb.test.myresto02.modelo.Usuario;

/**
 * Created by martdominguez on 28/07/2017.
 */

public class MyRestoOpenHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TIPO_PLATO = "CREATE TABLE TIPO_PLATO " +
            "(ID INTEGER PRIMARY KEY, " +
            "NOMBRE TEXT)";

    private static final String SQL_CREATE_PLATO = "CREATE TABLE PLATO " +
            "(ID INTEGER PRIMARY KEY , " +
            " NOMBRE TEXT, " +
            " DESCRIPCION TEXT, " +
            " ID_TIPO_PLATO INTEGER, " +
            " PRECIO REAL)";

    private static final String SQL_CREATE_PEDIDO= "CREATE TABLE PEDIDO " +
            "(ID INTEGER PRIMARY KEY, " +
            "ID_PLATO INTEGER," +
            "CANTIDAD INTEGER, " +
            "ACEPTADO INTEGER, " +
            "LISTO INTEGER," +
            "ID_USUARIO INTEGER, " +
            "UBICACION TEXT )";

    private static final String SQL_CREATE_USUARIO = "CREATE TABLE USUARIO " +
            "(ID INTEGER PRIMARY KEY , " +
            " NOMBRE TEXT, " +
            " CORREO TEXT, " +
            " UBICACION_DEFECTO TEXT)";

    private static MyRestoOpenHelper _INSTANCE;

    private MyRestoOpenHelper(Context ctx){
        super(ctx,"MY_RESTO",null,3);
    }

    public static MyRestoOpenHelper getInstance(Context ctx){
        if(_INSTANCE==null) _INSTANCE = new MyRestoOpenHelper(ctx);
        return _INSTANCE;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TIPO_PLATO);
        sqLiteDatabase.execSQL(SQL_CREATE_PLATO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        switch (i1) {
            case 2:
                sqLiteDatabase.execSQL("DELETE FROM TIPO_PLATO");
                TipoPlato[] arreglo = new TipoPlato[5];
                arreglo[0] = new TipoPlato("EntradaDB");
                arreglo[1] = new TipoPlato("PrincipalDB");
                arreglo[2] = new TipoPlato("PostreDB");
                arreglo[3] = new TipoPlato("MinutaDB");
                arreglo[4] = new TipoPlato("BebidaDB");

                Cursor res = sqLiteDatabase.rawQuery("SELECT ID,NOMBRE FROM TIPO_PLATO ", null);
                if (res.getCount() > 0) return;
                for (TipoPlato unPlato : arreglo) {
                    ContentValues valores = new ContentValues();
                    valores.put("ID", unPlato.getId());
                    valores.put("NOMBRE", unPlato.getNombre());
                    sqLiteDatabase.insert("TIPO_PLATO", null, valores);
                }
            case 3:
                sqLiteDatabase.execSQL(SQL_CREATE_PEDIDO);
                sqLiteDatabase.execSQL(SQL_CREATE_USUARIO);
        }
    }
}
