package com.example.d_calc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class Dao {
    private SQLiteDatabase db;
    private CriaBanco banco;


    public Dao(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDadoMateria(String nome, String equacao, String notaS){
        ContentValues valores;
        long resultado;
        double nota = Double.parseDouble(notaS);


        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("NOME", nome);
        valores.put("EQUACAO", equacao);
        valores.put("NOTA", nota);
        Log.d("testeBD", "teste " + valores.toString());
        resultado = db.insert(CriaBanco.getTabelaMaterias(), null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao salvar :(";
        else
            return "Salvo!";
    }
    public ArrayList<Disciplina> carregaDadosDisciplinas(){
        Cursor cursor;
        ArrayList<Disciplina> disciplinas = new ArrayList();

        String[] campos = {"ID", "NOME"};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.getTabelaMaterias(), campos, null, null, null, null, null, null);

        if(cursor!=null)
            cursor.moveToFirst();

        while(cursor.moveToNext()){
            Disciplina d = new Disciplina(cursor.getString(1));
            d.setID(cursor.getInt(0));

            disciplinas.add(d);
        }

        return disciplinas;
    }

    public void limpaBanco(){
        banco.onUpgrade(db, 0, 0);
    }

}
