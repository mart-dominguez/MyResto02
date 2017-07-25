package cursofyb.test.myresto02;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

public class ReceptorPedidoListo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String mensaje = intent.getExtras().getString("PLATO");
        generarNotificacion(context,mensaje);
    }

    private void generarNotificacion(Context ctx,String mensajeDetalle){
        Intent ipagar = new Intent(ctx,PagarActivity.class);
        PendingIntent piPagar = PendingIntent.getActivity(ctx,999,ipagar,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx);
        builder.setContentTitle("PEDIDO LISTO ")
        .setContentText(" Puede retirar y pagar su "+mensajeDetalle)
        .setContentIntent(piPagar)
                .setAutoCancel(true)
        .setSmallIcon(R.drawable.pedido_notif);

        NotificationManager nm = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,builder.build());
    }
}
