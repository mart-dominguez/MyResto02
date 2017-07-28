package cursofyb.test.myresto02;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cursofyb.test.myresto02.dao.MyRestoOpenHelper;
import cursofyb.test.myresto02.dao.PlatoDao;
import cursofyb.test.myresto02.modelo.Plato;

public class ListPlatos extends AppCompatActivity {

    private static String LISTPLATOS = "LISTPLATOS--";
    private Button btnVerAbm;
    private ListView lvPlatos;
    private ListaPlatosAdapter adaptadorLista;
    private List<Plato> listaPlatos;
    private final int CODIGO_NUEVO_PLATO = 999;
    private final int CODIGO_EDITAR_PLATO = 998;
    private PlatoDao platoDao;
    private Cursor cursorListaActual;
    private ListaPlatosCursorAdapter adaptadorListaPlatosCrs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_platos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        this.btnVerAbm = (Button) findViewById(R.id.btnPrincipal);
        this.lvPlatos = (ListView) findViewById(R.id.listaPlatos);

        this.listaPlatos = new ArrayList<>();
        /*this.listaPlatos.add(new Plato("MIlanesa"));
        this.listaPlatos.add(new Plato("Pollo"));
        this.listaPlatos.add(new Plato("Chorzo"));
        this.listaPlatos.add(new Plato("Pizza"));
        this.listaPlatos.add(new Plato("Hamburguesa"));
        this.listaPlatos.add(new Plato("Helado"));
        this.listaPlatos.add(new Plato("Tallarines"));
        this.listaPlatos.add(new Plato("Ravioles"));
        this.listaPlatos.add(new Plato("Asado"));
        this.listaPlatos.add(new Plato("Costilla"));
        this.listaPlatos.add(new Plato("Costilla 2"));
        this.listaPlatos.add(new Plato("Costilla 3"));
        this.listaPlatos.add(new Plato("Costilla 4"));
        this.listaPlatos.add(new Plato("Costilla 5"));*/

        this.adaptadorLista = new ListaPlatosAdapter(this,listaPlatos);

        this.platoDao =new PlatoDao(this);
        cursorListaActual = this.platoDao.getListaPlatos();
        adaptadorListaPlatosCrs = new ListaPlatosCursorAdapter(this,cursorListaActual);
        this.lvPlatos.setAdapter(adaptadorListaPlatosCrs);
        this.btnVerAbm.setOnClickListener(clickBoton);
        Intent intServ = new Intent(this,MyPedidoIntentService.class);
        intServ.putExtra("VALOR1","ASDASDADSADAS");
        Log.d("RESTO","INICIAR SERVICIO");
        startService(intServ);
    }

    private View.OnClickListener clickBoton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentVerABM = new Intent(ListPlatos.this,MainActivity.class);
            startActivityForResult(intentVerABM,CODIGO_NUEVO_PLATO);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LISTPLATOS,"1:"+requestCode+","+resultCode+", "+data+" - ");
        if(resultCode==RESULT_OK){
            Log.d(LISTPLATOS,"RESULT OK");
            if(requestCode==CODIGO_NUEVO_PLATO){
                //Plato nuevoPlato = (Plato) data.getExtras().getSerializable("PLATO_NUEVO");
                Log.d(LISTPLATOS,"Extras: ---> "+data.getExtras().get("PLATO_NUEVO"));
                this.cursorListaActual = this.platoDao.getListaPlatos();
                Cursor viejo = this.adaptadorListaPlatosCrs.swapCursor(this.cursorListaActual);
                viejo.close();
                //listaPlatos.add(nuevoPlato);
                Log.d(LISTPLATOS,"RESULT OK");
                //adaptadorLista.notifyDataSetChanged();
            }
        }
    }
}
