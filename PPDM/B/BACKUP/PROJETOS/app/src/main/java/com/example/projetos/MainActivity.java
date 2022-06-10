package com.example.projetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editNomeUsuario;
    private EditText editSenha;
    private Button btnEntrar;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNomeUsuario = findViewById(R.id.edit_entrar_nome_usuario);
        editSenha = findViewById(R.id.edit_entrar_senha);
        btnEntrar = findViewById(R.id.btn_entrar_entrar);
        btnCadastrar = findViewById(R.id.btn_entrar_cadastrar);

        btnCadastrar.setOnClickListener(view->{
            startActivity(new Intent(
                    MainActivity.this,
                    CadastroActivity.class
            ));

        });

    }


}