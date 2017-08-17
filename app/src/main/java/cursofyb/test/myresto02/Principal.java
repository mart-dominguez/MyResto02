package cursofyb.test.myresto02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private ImageButton btnCuenta;
    private ImageButton btnAltaPlato;
    private ImageButton btnVerRuta;
    private ImageButton btnPedido;
    private ImageButton btnPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnCuenta=  (ImageButton)findViewById(R.id.btnCuenta);
        btnAltaPlato=  (ImageButton)findViewById(R.id.btnAltaPlato);
        btnPedido=  (ImageButton)findViewById(R.id.btnPedido);
        btnVerRuta=  (ImageButton)findViewById(R.id.btnVerRuta);
        btnPagar=  (ImageButton) this.findViewById(R.id.btnPagar);
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this,AltaUsuario.class);
                startActivity(i);
            }
        });

        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this,ListPlatos.class);
                startActivity(i);
            }
        });

        btnVerRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this,MapsActivity.class);
                startActivity(i);
            }
        });

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this,PagarActivity.class);
                startActivity(i);
            }
        });
        btnAltaPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
