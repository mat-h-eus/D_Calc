package com.example.d_calc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Dao {
    private SQLiteDatabase db;
    private CriaBanco banco;


    public Dao(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDadoMateria(String nome, String equacao){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("NOME", nome);
        valores.put("EQUACAO", equacao);
        resultado = db.insert(CriaBanco.getTabelaMaterias(), null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao salvar :(";
        else
            return "Salvo!";
    }

}
