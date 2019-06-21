package com.example.d_calc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "Dcalc";
    private static final String TABELA_MATERIAS = "materia";
    private static final String TABELA_PROVAS = "prova";
    private static final int VERSAO = 1;

    public static String getTabelaMaterias() {
        return TABELA_MATERIAS;
    }

    public static String getTabelaProvas() {
        return TABELA_PROVAS;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sqlCriaTabelaMaterias = " CREATE TABLE " + TABELA_MATERIAS + "("
                                            +" ID integer primary key autoincrement,"
                                            +" NOME text,"
                                            +" EQUACAO text"
                                        +");";
        String sqlCriaTabelaProvas = " CREATE TABLE " + TABELA_PROVAS + "("
                                            +" ID integer primary key autoincrement,"
                                            +" NOME text,"
                                            +" MATERIA text,"
                                            +" NOTA real,"
                                            +" DATA text"
                                        +");";

        db.execSQL(sqlCriaTabelaMaterias);
        db.execSQL(sqlCriaTabelaProvas);
    }

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int uld, int nw){


        db.execSQL("drop table if  exists " + TABELA_MATERIAS);
        db.execSQL("drop table if exists " + TABELA_PROVAS);
        onCreate(db);
    }
}
