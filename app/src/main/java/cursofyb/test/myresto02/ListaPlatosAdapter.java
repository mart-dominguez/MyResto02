package cursofyb.test.myresto02;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import cursofyb.test.myresto02.modelo.Plato;

/**
 * Created by martdominguez on 14/07/2017.
 */

public class ListaPlatosAdapter extends ArrayAdapter<Plato> {

    private LayoutInflater layoutInflater;

    public ListaPlatosAdapter(Context ctx,List<Plato> lista){
        super(ctx,android.R.layout.simple_list_item_1,lista);
        layoutInflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View filaNueva = convertView;
        if(filaNueva==null) filaNueva = layoutInflater.inflate(R.layout.fila_plato,parent,false);
        TextView tvNombre = (TextView ) filaNueva.findViewById(R.id.filaNombrePlato);
        TextView tvPrecio = (TextView ) filaNueva.findViewById(R.id.filaPrecioPlato);
        Plato platoActual = getItem(position);
        tvNombre.setText("NOMBRE: "+platoActual.getNombre​());
        tvPrecio.setText("$"+platoActual.getPrecio​());

        Button btnPedir = (Button) filaNueva.findViewById(R.id.btnPedir);
        btnPedir.setTag(position);
        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag =view.getTag().toString();
                int indice = Integer.parseInt(tag);
                Plato p = ListaPlatosAdapter.this.getItem(indice);
                PedidoIntentService.startActionHacerPedido(ListaPlatosAdapter.super.getContext(),p.getNombre​()," ");
            }
        });

        return filaNueva;
    }
}
