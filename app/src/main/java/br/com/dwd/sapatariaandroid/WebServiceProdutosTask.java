package br.com.dwd.sapatariaandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duke on 20/10/15.
 */
public class WebServiceProdutosTask extends AsyncTask<Object, Object, String> {

    private final Context context;
    private View view;
    private ProgressDialog progressDialog;

    public WebServiceProdutosTask(Context context) {
        this.context = context;
    }

    public WebServiceProdutosTask(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Aguarde...", "Comunicação com Servidor em andamento...", true, true);
    }

    @Override
    protected String doInBackground(Object... params) {
        WebClient client = new WebClient("produto/all");
        return client.get();
    }

    @Override
    protected void onPostExecute(String resposta) {
        super.onPostExecute(resposta);
        if (resposta != null) {

            List<Produto> produtos = new Gson().fromJson(resposta, new TypeToken<List<Produto>>() {}.getType());


            List<String> nomes = new ArrayList<>();
            for (Produto p : produtos) {
                nomes.add(p.getNome());
            }


            ListView minhaLista = (ListView) view.findViewById(R.id.lista_produtos);

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, nomes);

            minhaLista.setAdapter(stringArrayAdapter);
        }
        progressDialog.cancel();
    }

}
