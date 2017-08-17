package cursofyb.test.myresto02.dao;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import cursofyb.test.myresto02.modelo.TipoPlato;

/**
 * Created by mdominguez on 03/08/17.
 */

public class TipoPlatoDAOJSON implements TipoPlatoDAO {

    private Context ctx;
    private String filename = "tiposPlatos3.json";
    public TipoPlatoDAOJSON(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public void inicializar() {

        FileOutputStream outputStream=null;
        TipoPlato[] arreglo = new TipoPlato[5];
        arreglo[0]=new TipoPlato("EntradaJSON");
        arreglo[1]=new TipoPlato("PrincipalJSON");
        arreglo[2]=new TipoPlato("PostreJSON");
        arreglo[3]=new TipoPlato("MinutaJSON");
        arreglo[4]=new TipoPlato("BebidaJSON");
        JSONArray arregloJson = new JSONArray();
        try {
            for(TipoPlato tp : arreglo){
                JSONObject objeto = new JSONObject();
                objeto.put("id",tp.getId());
                objeto.put("nombre",tp.getNombre());
                arregloJson.put(objeto);
            }
            outputStream = ctx.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(arregloJson.toString().getBytes());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(outputStream!=null) try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public TipoPlato[] listaTipoPlato() {
        if(!fileExists(this.filename)){
            this.inicializar();
        }
        TipoPlato[] resultado =null;
        FileInputStream in = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            in = ctx.openFileInput(filename);
            inputStreamReader = new InputStreamReader(in);
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            JSONArray arr = (JSONArray) new JSONTokener(sb.toString()).nextValue();
            resultado = new TipoPlato[arr.length()];
            for(int i=0;i<arr.length();i++){
                JSONObject obj = arr.getJSONObject(i);
                TipoPlato aux = new TipoPlato(obj.getString("nombre"),obj.getInt("id"));
                resultado[i]=aux;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(in!=null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    private boolean fileExists(String filename) {
        File file = ctx.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }
}
