package br.com.dwd.sapatariaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joe on 07/12/2015.
 */
public class PedidoActivity extends Activity {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        EditText etxCodProduto = (EditText)findViewById(R.id.etxCodProduto);

        View btnBuscarProduto = findViewById(R.id.btnBuscarProduto);
        btnBuscarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insereProduto();
            }
        });
    }

    private void insereProduto() {
        ListView listPedido = (ListView)findViewById(R.id.lista_produtos);
        TextView listaQtd = (TextView)findViewById(R.id.listaQtd);
        TextView listaMarca = (TextView)findViewById(R.id.listaMarca);
        TextView listaDescricao = (TextView)findViewById(R.id.listaDescricao);
        TextView listaVlr = (TextView)findViewById(R.id.listaValor);

        listaQtd.setText("1");
        listaMarca.setText("Havaianas");
        listaDescricao.setText("Chinelo");
        listaVlr.setText("30.00");
        ((BaseAdapter)listPedido.getAdapter()).notifyDataSetChanged();

    }
}
