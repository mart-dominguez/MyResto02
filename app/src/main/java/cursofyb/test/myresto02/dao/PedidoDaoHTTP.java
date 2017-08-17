package cursofyb.test.myresto02.dao;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import cursofyb.test.myresto02.modelo.Pedido;

/**
 * Created by mdominguez on 03/08/17.
 */

public class PedidoDaoHTTP implements PedidoDao {

    @Override
    public void hacerPedido(Pedido p) {
        HttpURLConnection urlConnection = null;
        DataOutputStream printout =null;
        try {
            JSONObject pedidoJSON = new JSONObject();
            pedidoJSON.put("cantidad",p.getCantidad());
            pedidoJSON.put("plato",p.getPedido().getId());
            pedidoJSON.put("aceptado",p.isAceptado());
            pedidoJSON.put("listo",p.isListo());
            URL url = new URL("http://10.0.2.2:5000/pedidos");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            printout = new DataOutputStream(urlConnection.getOutputStream());
            Log.d("TEST-ARR",pedidoJSON.toString());
            Log.d("TEST-ARR",URLEncoder.encode(pedidoJSON.toString(),"UTF-8"));
            String str = pedidoJSON.toString();
            byte[] jsonData=str.getBytes("UTF-8");
            printout.write(jsonData);
//            printout.writeBytes(URLEncoder.encode(pedidoJSON.toString(),"UTF-8"));
            printout.flush();

// leer las respuestas
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            InputStreamReader isw = new InputStreamReader(in);
            StringBuilder sb = new StringBuilder();
            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                sb.append(current);
                data = isw.read();
            }
            Log.d("TEST-ARR",sb.toString());

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if(printout!=null) try {
                printout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(urlConnection !=null)urlConnection.disconnect();
        }
    }

    @Override
    public Boolean pedidoListo(Integer id) {
        return null;
    }

    @Override
    public Pedido cargarPedido() {
        return null;
    }
}
