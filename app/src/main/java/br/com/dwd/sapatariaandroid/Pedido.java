package br.com.dwd.sapatariaandroid;

/**
 * Created by Joe on 07/12/2015.
 */
public class Pedido {

    private int qtd;
    private String marca;
    private String descricao;
    private double vlr;

    public Pedido() {
    }

    public Pedido (int qtd, String marca, String descricao, double vlr) {
        this.qtd = qtd;
        this.marca = marca;
        this.descricao = descricao;
        this.vlr = vlr;
    }

    public int getQtd() {
        return qtd;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getVlr() {
        return vlr;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setVlr(double vlr){
        this.vlr = vlr;
    }
}
