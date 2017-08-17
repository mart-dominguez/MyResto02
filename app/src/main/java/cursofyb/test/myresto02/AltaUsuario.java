package cursofyb.test.myresto02;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AltaUsuario extends AppCompatActivity {
    private final int CODIGO_UBICACION_USUARIO = 801;
    private final String tagLog = "RESTO::ALTA";

    private Button bntUbicacion;
    private EditText ubicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_usuario);
        bntUbicacion= (Button) findViewById(R.id.btnBuscarUbicMapa);
        ubicacion= (EditText) findViewById(R.id.usrUbicacionTxt);
        bntUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AltaUsuario.this,MapsActivity.class);
                startActivityForResult(i,CODIGO_UBICACION_USUARIO);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(tagLog,"1:"+requestCode+","+resultCode+", "+data+" - ");
        if(resultCode==RESULT_OK){
            Log.d(tagLog,"RESULT OK");
            if(requestCode==CODIGO_UBICACION_USUARIO){
                //Plato nuevoPlato = (Plato) data.getExtras().getSerializable("PLATO_NUEVO");
                Log.d(tagLog,"Extras: ---> "+data.getExtras().get("UBICACION_RESULTADO"));
                ubicacion.setText(data.getExtras().get("UBICACION_RESULTADO").toString());
                Log.d(tagLog,"RESULT OK");
            }
        }
    }


}
