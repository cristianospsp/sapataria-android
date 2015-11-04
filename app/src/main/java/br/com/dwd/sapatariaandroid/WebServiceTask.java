package br.com.dwd.sapatariaandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by duke on 20/10/15.
 */
public class WebServiceTask extends AsyncTask<Object, Object, String> {

    private final Context context;
    private String login;
    private String senha;
    private ProgressDialog progressDialog;

    public WebServiceTask(Context context, String login, String senha) {
        this.context = context;
        this.login = login;
        this.senha = senha;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Aguarde...", "Comunicação com Servidor em andamento...", true, true);
    }

    @Override
    protected String doInBackground(Object... params) {
        WebClient client = new WebClient(login, senha);
        return client.get();
    }

    @Override
    protected void onPostExecute(String resposta) {
        super.onPostExecute(resposta);

        String retornoWS = "";

        if ("null".equalsIgnoreCase(resposta)) {
            retornoWS = "Usuario nao encontrado";
        }else {
            Usuario usuario = new Gson().fromJson(resposta, new TypeToken<Usuario>() {}.getType());
            retornoWS = "Usuario encontrado: " + usuario.getNome();
        }

        Toast.makeText(context, retornoWS, Toast.LENGTH_LONG).show();

        progressDialog.cancel();
    }

}
