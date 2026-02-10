package br.com.alura.compras.models;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;

public class Cartao {
    private double limite;
    private List<Compra> compras = new LinkedList<>();

    public Cartao(){}

    public Cartao(double limite){
        this.limite = limite;
    }

    public double getLimite(){
        return this.limite;
    }

    public List<Compra> getCompras(){
        return this.compras;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void comprar(Compra c) {
        compras.add(c);
        this.limite -= c.getValor();
    }

    public void exibirFaturamento(){
        this.compras.sort(Comparator.comparing(Compra::getValor).reversed());
        double faturamento = 0;

        System.out.println("\nLista de compras ordenada por valor: ");
        for (Compra c : this.getCompras()){
            System.out.println(c);
            faturamento += c.getValor();
        }
        System.out.printf("\nValor total: %.2f",faturamento);
        System.out.println("\nLimite disponível: "+this.getLimite());
    }

    @Override
    public String toString(){
        String mensagem = String.format("\nLimite atual do cartão: %.2f",this.getLimite());

        if(!compras.isEmpty() && compras!=null){
            mensagem += "\nLista de compras: "+compras;
        }

        return mensagem;
    }
}