package com.example.cadastro_symbian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cadastro_symbian.model.Usuario;
import com.example.cadastro_symbian.remote.APIUtil;
import com.example.cadastro_symbian.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtCelular;
    Button btnCadastrar;

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtNome = findViewById(R.id.txt_nome);
        txtSobrenome = findViewById(R.id.txt_sobrenome);
        txtEmail = findViewById(R.id.txt_email);
        txtCelular = findViewById(R.id.txt_celular);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener(view -> {

            Usuario usuario = new Usuario();

            usuario.setNome(txtNome.getText().toString());
            usuario.setSobrenome(txtSobrenome.getText().toString());
            usuario.setEmail(txtEmail.getText().toString());
            usuario.setCelular(txtCelular.getText().toString());

            routerInterface = APIUtil.getUsuarioInterface();
            addUsuario(usuario);

        });

    }

    public void addUsuario(Usuario usuario){

        Call<Usuario> call = routerInterface.addUsuario(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Toast.makeText(RegisterActivity.this,
                        "USUÁRIO INSERIDO COM SUCESSO",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.d("ERRO-API", t.getMessage());
            }
        });

    }

}