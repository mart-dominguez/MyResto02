package cursofyb.test.myresto02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mdominguez on 17/08/17.
 */


public class MenuPrincipalAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater layoutInflater;


    public MenuPrincipalAdapter(Context c) {

        mContext = c;
        layoutInflater = LayoutInflater.from(c);

    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_add_shopping_cart_black_24dp,
            R.drawable.ic_credit_card_black_24dp,
            R.drawable.ic_motorcycle_black_24dp,
            R.drawable.ic_search_black_24dp
    };

    // references to our images
    private String[] mIconName = {
            "Mi Cuenta",
            "Pedir",
            "Pagar",
            "Ver Pedido",
            "Dar de Alta"
    };

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View filaNueva = convertView;

        ImageView imageView=null;
        if (filaNueva == null) {
            filaNueva = layoutInflater.inflate(R.layout.menu_item_grid, null, false);
            filaNueva.setLayoutParams(new GridView.LayoutParams(85, 85));
            // if it's not recycled, initialize some attributes
            //imageView = new ImageView(mContext);
        }
        if(imageView==null)imageView = (ImageView) filaNueva.findViewById(R.id.imgMenu);
        imageView.setImageResource(mThumbIds[position]);
        TextView tv = (TextView) filaNueva.findViewById(R.id.textoMenu);
        tv.setText(mIconName[position]);

        return filaNueva;
    }
}
