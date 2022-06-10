package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "projeto";
    private static final int DB_VERSION = 2;
    private static SQLHelper INSTANCE;



    public static SQLHelper getInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = new SQLHelper(context);
        }

        return INSTANCE;

    }

    public SQLHelper(Context context) {

        super (context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE tbl_usuario" + "(cod_usuario INTEGER PRIMARY KEY,"+ "nome_usuario TEXT," + "sobrenome TEXT," + "login TEXT," + "senha TEXT");

        Log.d("SQLITE-", "BANCO DE DADOS CRIADO! - " + DB_VERSION);

    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("CREATE TABLE tbl_endereco" + "(cod_endereco INTEGER PRIMARY KEY," + "cod_endereco INT," + "nome_usuario TEXT," + "sobrenome TEXT," + "login TEXT," + "senha TEXT," + "FOREIGN KEY (cod_usuario) REFERENCES tbl_usuario(cod_usuario))");

        Log.d("SQLITE-", "BANCO DE DADOS CRIADO! - " + DB_VERSION);

    }

    public boolean addUser (String nome_usuario, String sobrenome, String login, String senha) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try {
            sqLiteDatabase.beginTransaction();

            ContentValues values = new ContentValues();

            values.put("nome", nome_usuario);
            values.put("sobrenome", sobrenome);
            values.put("login", login);
            values.put("senha", senha);

            sqLiteDatabase.insertOrThrow("tbl_usuario", null,values);
            sqLiteDatabase.setTransactionSuccessful();

            return false;

        } catch (Exception e) {

            Log.d("SQLITE-", e.getMessage());
            return true;

        } finally {

            if(sqLiteDatabase.isOpen()){
                sqLiteDatabase.endTransaction();
            }

        }

    }




}





