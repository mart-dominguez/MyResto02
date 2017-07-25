package cursofyb.test.myresto02;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by martdominguez on 21/07/2017.
 */

public class MyPedidoIntentService extends IntentService {

    public MyPedidoIntentService(){
        super("MyPedidoIntentService");
    }

    Handler miHandler = new Handler();

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        final String dato = intent.getExtras().getString("VALOR1");
        Log.d("RESTO","dato "+dato);

        try {
            Thread.currentThread().sleep(7000);
            miHandler.post(new Runnable() {
                @Override
                public void run() {
                    Log.d("RESTO","Muestra resultado");
                    Toast.makeText(MyPedidoIntentService.this,"SERVICIO RECIBI "+dato,Toast.LENGTH_LONG).show();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
