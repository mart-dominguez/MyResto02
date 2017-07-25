package cursofyb.test.myresto02;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import cursofyb.test.myresto02.modelo.Plato;
import cursofyb.test.myresto02.modelo.TipoPlato;

public class MainActivity extends AppCompatActivity {

    private Spinner cmbTipoPlato;
    private ArrayAdapter<TipoPlato> adapterTipoPlato;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        adapterTipoPlato = new ArrayAdapter<TipoPlato>(this,android.R.layout.simple_spinner_item,this.obtenerListaPlato());
        cmbTipoPlato = (Spinner) findViewById(R.id.cmbTipoPlato);
        cmbTipoPlato.setAdapter(adapterTipoPlato);
        this.btnGuardar = (Button) findViewById(R.id.btnGuardar);
        this.btnGuardar.setOnClickListener(clicGuardar);
    }

    private View.OnClickListener clicGuardar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Plato platoNuevo = new Plato();
            platoNuevo.setId(100);
            platoNuevo.setNombre​("Milanesa");
            platoNuevo.setPrecio​(88.0);
            platoNuevo.setDescripcion​(" a la napollitana");

            Intent resultadoIntent = getIntent();

            resultadoIntent.putExtra("PLATO_NUEVO",platoNuevo);

            setResult(RESULT_OK,resultadoIntent);

            finish();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private TipoPlato[] obtenerListaPlato(){
        TipoPlato[] arreglo = new TipoPlato[5];
        arreglo[0]=new TipoPlato("Entrada");
        arreglo[1]=new TipoPlato("Principal");
        arreglo[2]=new TipoPlato("Postre");
        arreglo[3]=new TipoPlato("Minuta");
        arreglo[4]=new TipoPlato("Bebida");
        return arreglo;
    }
}