package br.com.dwd.sapatariaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdutosActivity extends Activity {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    //private ListView viewListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        ListView listaPedido = (ListView) findViewById(R.id.lista_produtos);

        final ArrayAdapter<Pedido> pedido = new ArrayAdapter<>(this, R.layout.layout_pedido, pedidos);
        listaPedido.setAdapter(pedido);

        View btAddNoPedido = findViewById(R.id.add_produto_ao_pedido);

        btAddNoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View viewById = findViewById(R.id.lista_produtos);
                Intent intent = new Intent();
                intent.setClass(ProdutosActivity.this, PedidoActivity.class);

                startActivity(intent);

                //new WebServiceProdutoTask(ProdutosActivity.this, viewById).execute();

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
        switch (item.getItemId()){
            case R.id.finalizaPedido:
                finalizaPedido();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void finalizaPedido() {
        String mensagem = "Código do Pedido: 54789\n\nPedido realizado com sucesso.";
        Toast toast = Toast.makeText(getApplicationContext(),mensagem,Toast.LENGTH_LONG);
        toast.show();
    }
}
