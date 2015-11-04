package br.com.dwd.sapatariaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ProdutosActivity extends Activity {

    //private ListView viewListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        View btAddNoPedido = findViewById(R.id.add_produto_ao_pedido);

        btAddNoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View viewById = findViewById(R.id.lista_produtos);

                new WebServiceProdutosTask(ProdutosActivity.this, viewById).execute();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_produtos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
