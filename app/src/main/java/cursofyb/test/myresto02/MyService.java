package cursofyb.test.myresto02;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Handler miHandler = new Handler();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //super.onStartCommand(intent, flags, startId);
        final String dato = intent.getExtras().getString("VALOR1");
        Runnable r= new Runnable() {
            @Override
            public void run() {
                Log.d("RESTO","pasa el hilo");
                try {
                    Thread.currentThread().sleep(7000);
                    miHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("RESTO","Muestra resultado");
                            Toast.makeText(MyService.this,"SERVICIO RECIBI "+dato,Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r).start();
        return START_STICKY;
    }


}
