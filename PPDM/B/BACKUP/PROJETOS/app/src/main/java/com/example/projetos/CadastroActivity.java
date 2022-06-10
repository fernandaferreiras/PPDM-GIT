package com.example.projetos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import database.SQLHelper;

public class CadastroActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editSobrenome;
    private EditText editNomeUsuario;
    private EditText editSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.edit_cadastro_nome);
        editSobrenome = findViewById(R.id.edit_cadastro_sobrenome);
        editNomeUsuario = findViewById(R.id.edit_entrar_nome_usuario);
        editSenha = findViewById(R.id.edit_casdastro_senha);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener( view -> {

            if (!validate()) {

                Toast.makeText(this, "PREENCHA TODOS OS CAMPOS", Toast.LENGTH_SHORT).show();
                return;
            }

            AlertDialog dialog =  new AlertDialog.Builder(this)

                    .setTitle("CADASTRO DE USUÁRIO")
                    .setMessage("VOCÊ ESTÁ CADASTRANDO UM USUÁRIO")
                    .setPositiveButton(R.string.salvar, (dialog1, which) -> {

                        String nome = editNome.getText().toString();
                        String sobrenome = editSobrenome.getText().toString();
                        String nomeUsuario = editNomeUsuario.getText().toString();
                        String senha = editSenha.getText().toString();

                        boolean cadastro = SQLHelper.getInstance(CadastroActivity.this).addUser(nome, sobrenome, nomeUsuario, senha);

                        if (cadastro) {

                            Toast.makeText(this, "CADASTRO REALIZADO", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "HOUVE UM ERRO", Toast.LENGTH_LONG).show();
                        }


                    })

                    .setNegativeButton(R.string.cancelar, (dialog1, which)->{}).create();

            dialog.show();

        });

    }

    private boolean validate () {

            return (

                !editNome.getText().toString().isEmpty() &&
                !editSobrenome.getText().toString().isEmpty() &&
                !editNomeUsuario.getText().toString().isEmpty() &&
                !editSenha.getText().toString().isEmpty()

                );
    }

}