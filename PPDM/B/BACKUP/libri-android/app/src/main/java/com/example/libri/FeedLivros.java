package com.example.libri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import database.SQLHelper;
import model.Item;
import model.Livro;

public class FeedLivros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_livros);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<Item> item = SQLHelper.getInstance(this).listBook();

        recyclerView.setAdapter(new LivroAdapter(item));

    }

    /**
     * INFLATE DO MENU
     **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    /**
     * AÇÕES DO MENU
     **/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Log.d("MENUITEM-", String.valueOf(item.getItemId()));

        switch (item.getItemId()) {

            case R.id.menu_cadastrar_livro:
                startActivity(new Intent(this,
                        CadastroLivro.class));
                break;

            case R.id.menu_feed_livro:
                startActivity(new Intent(this,
                        FeedLivros.class));
                break;

            case R.id.menu_sair:
                startActivity(new Intent(this,
                        MainActivity.class));
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    /***** ADAPATER DO RECYCLERVIEW *****/
    class LivroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        //ATRIBUTO QUE RECEBER OS OBEJTOS DE "ITEMS"
        public List<Item> item;

        //CONSTRUTOR DA CLASSE LivroAdapter
        public LivroAdapter(List<Item> item){

            this.item = item;

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            if(viewType == 0){

                return new LivroAdapter.LivroViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(
                                R.layout.item_container_livro,
                                parent,
                                false
                        ));

            }

            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if(getItemViewType(position) == 0){
                //TIPO LIVRO

                Livro livro = (Livro) item.get(position).getObject();
                ((LivroAdapter.LivroViewHolder) holder).setLivroData(livro);

            }

            //else if(getItemViewType(position) == 0){

                //TIPO HQ
            //}


        }

        /** MÉTODO AUXULIAR DE MANIPULAÇÃO DE POSITION
         * PARA O MÉTODO onBindViewHolder**/
        public int getItemViewType(int position){
            return item.get(position).getType();
        }

        @Override
        public int getItemCount() {
            return item.size();
        }

        /**
         * INICIO VIEWHOLDER
         **/
        class LivroViewHolder extends RecyclerView.ViewHolder {

            private TextView textLivroTitulo, textLivroDescricao;
            private int cod_livro;

            /**
             * MÉTODO CONSTRUTOR DA VIEWHOLDER
             **/
            public LivroViewHolder(@NonNull View itemView) {
                super(itemView);

                textLivroTitulo = itemView.findViewById(R.id.textLivroTitulo);
                textLivroDescricao = itemView.findViewById(R.id.textLivroDescricao);

            }

            /**
             * MÉTODO DE SET DE DADOS NAS TEXTVIEWS
             **/
            public void setLivroData(Livro livro) {

                textLivroTitulo.setText(livro.getTitulo());
                textLivroDescricao.setText(livro.getDescricao());

            }

            /** FIM VIEWHOLDER **/

        }//FIM DA ADAPTER

    }
}
















