package br.com.dwd.sapatariaandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by duke on 20/10/15.
 */
public class WebServiceProdutoTask extends AsyncTask<Object, Object, String> {

    private final Context context;
    private String codigoProduto;
    private ProgressDialog progressDialog;

    public WebServiceProdutoTask(Context context, String codigoProduto) {
        this.context = context;
        this.codigoProduto = codigoProduto;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Aguarde...", "Buscando Produto...", true, true);
    }

    @Override
    protected String doInBackground(Object... params) {
        WebClient client = new WebClient("/produto/codigo/" + codigoProduto);
        return client.get();
    }

    @Override
    protected void onPostExecute(String resposta) {
        super.onPostExecute(resposta);

        String retornoWS = "";

        if ("null".equalsIgnoreCase(resposta) || resposta == null) {
            retornoWS = "Produto nao encontrado";
        }else {
            Produto produto = new Gson().fromJson(resposta, new TypeToken<Produto>() {}.getType());
            retornoWS = "Produto encontrado: " + produto.getNome();
        }

        Toast.makeText(context, retornoWS, Toast.LENGTH_LONG).show();

        progressDialog.cancel();
    }

}
