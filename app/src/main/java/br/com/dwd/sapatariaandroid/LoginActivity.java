package br.com.dwd.sapatariaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View btIr = findViewById(R.id.btIr);

        btIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText login = (EditText)findViewById(R.id.login);
                final EditText senha = (EditText)findViewById(R.id.senha);
                String loginString = login.getText().toString();
                String senhaString = senha.getText().toString();
                new WebServiceTask(LoginActivity.this, loginString, senhaString).execute();
            }
        });
    }

}
