package cursofyb.test.myresto02;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;

import java.net.URLEncoder;

import cursofyb.test.myresto02.dao.PedidoDao;
import cursofyb.test.myresto02.dao.PedidoDaoHTTP;
import cursofyb.test.myresto02.dao.PedidoDaoSQLite;
import cursofyb.test.myresto02.modelo.Pedido;

public class PedidoService extends Service {
    // Binder given to clients
    private final IBinder mBinder = new PedidoBinder ();
    // Conexion
    //private PedidoDao pedidoDao = new PedidoDaoHTTP();
    private PedidoDao pedidoDao = new PedidoDaoSQLite(PedidoService.this);

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class PedidoBinder extends Binder {
        PedidoService getService() {
            // Return this instance of LocalService so clients can call public methods
            return PedidoService.this;
        }
    }


    public PedidoService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    public void hacerPedido(Pedido ped){
        final Pedido aux =ped;
        final Runnable mandarBroadcast = new Runnable() {
            @Override
            public void run() {
                avisarPedidoRealizado(aux.getPedido().getNombre​()+" "+aux.getCantidad());
            }
        };

        final Runnable r = new Runnable() {
            @Override
            public void run() {
                pedidoDao.hacerPedido(aux);
                postRunnable(mandarBroadcast);
            }
        };
        Thread t = new Thread(r);
        t.start();


    }

    public boolean consultarEstado(Pedido p){
        return false;
    }

    private HandlerThread mHandlerThread;
    private Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        mHandlerThread = new HandlerThread("PedidoServiceThread");
        mHandlerThread.start();

        mHandler = new Handler(mHandlerThread.getLooper());
    }

    public void postRunnable(Runnable runnable) {
        mHandler.post(runnable);
    }


    private void avisarPedidoRealizado(String cantidad){
        Intent intentBR = new Intent(this,ReceptorPedidoListo.class);
        intentBR.putExtra("PLATO","....");
        Log.d("TEST-ARR", " REGISTRO EL PEDIDO REMOTO ! ! !! ");

        sendBroadcast(intentBR);
    }

}
