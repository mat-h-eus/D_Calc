package com.example.d_calc;

class Avalicao {

    private String nome;
    private int nota;
    private String data;

    public Avalicao(String nome, int nota, String data) {
        this.nome = nome;
        this.nota = nota;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
