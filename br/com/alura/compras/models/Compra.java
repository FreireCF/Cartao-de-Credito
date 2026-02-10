package br.com.alura.compras.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra implements Comparable<Compra> {
    private String nome;
    private double valor;
    private LocalDateTime dataHora;

    public Compra(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public String getNome(){
        return this.nome;
    }

    public double getValor(){
        return this.valor;
    }

    public LocalDateTime getDataHora(){
        return this.dataHora;
    }

    @Override
    public int compareTo(Compra c){ //ordenar em ordem alfabética, provavelmente n vou usar
        return this.getNome().compareTo(c.getNome());
    }

    @Override
    public String toString(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String newDateTime = getDataHora().format(formatter);

        return  "\nItem: "+this.getNome()
                +"\nValor : R$ "+this.getValor()+
                "\nCompra realizada no dia: "+newDateTime;
    }
}