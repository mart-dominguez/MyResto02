package cursofyb.test.myresto02;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import cursofyb.test.myresto02.modelo.Plato;

/**
 * Created by martdominguez on 28/07/2017.
 */

public class ListaPlatosCursorAdapter extends CursorAdapter {

    public ListaPlatosCursorAdapter(Context ctx,Cursor c){
        super(ctx,c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.fila_plato,viewGroup,false);
    }

    @Override
    public void bindView(View filaNueva, final Context context, Cursor cursor) {
        TextView tvNombre = (TextView ) filaNueva.findViewById(R.id.filaNombrePlato);
        TextView tvPrecio = (TextView ) filaNueva.findViewById(R.id.filaPrecioPlato);
        //Plato platoActual = new Plato(cursor.get)
        tvNombre.setText("NOMBRE: "+cursor.getString(cursor.getColumnIndex("NOMBRE")));
        tvPrecio.setText("$"+cursor.getDouble(cursor.getColumnIndex("PRECIO")));
        //ID,DESCRIPCION,ID_TIPO_PLATO
        Button btnPedir = (Button) filaNueva.findViewById(R.id.btnPedir);
        btnPedir.setTag(cursor.getInt(cursor.getColumnIndex("_id")));
        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag =view.getTag().toString();
                int idProducto = Integer.parseInt(tag);
                PedidoIntentService.startActionHacerPedido(context,""+idProducto," ");
            }
        });
    }
}
