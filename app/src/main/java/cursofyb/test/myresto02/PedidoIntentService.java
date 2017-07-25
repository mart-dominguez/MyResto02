package cursofyb.test.myresto02;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * helper methods.
 */
public class PedidoIntentService extends IntentService {
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_HACER_PEDIDO = "cursofyb.test.myresto02.action.HACER_PEDIDO";
    private static final String ACTION_BAZ = "cursofyb.test.myresto02.action.BAZ";

    private static final String EXTRA_PARAM1 = "cursofyb.test.myresto02.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "cursofyb.test.myresto02.extra.PARAM2";

    public PedidoIntentService() {
        super("PedidoIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionHacerPedido(Context context, String param1, String param2) {
        Intent intent = new Intent(context, PedidoIntentService.class);
        intent.setAction(ACTION_HACER_PEDIDO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, PedidoIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_HACER_PEDIDO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionHacerPedido(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionHacerPedido(String param1, String param2) {
        // TODO: LANZAR EL BROADCAST PARA EL PEDIDO
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intentBR = new Intent(this,ReceptorPedidoListo.class);
        intentBR.putExtra("PLATO",param1);
        sendBroadcast(intentBR);
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
