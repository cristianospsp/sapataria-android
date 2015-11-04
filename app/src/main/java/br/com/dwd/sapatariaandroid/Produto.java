package br.com.dwd.sapatariaandroid;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Cristiano on 02/10/15.//
 */

public class Produto implements Serializable {

	private Long id;
	private String nome;
	private String fabricante;
	private long codigoBarras;
	private int tamanho;
	private String cor;
	private int qtdMinima;
	private int qtdTotal;
	private double vlrVenda;
	private double vlrCompra;
	private boolean status;

	public Produto() {
	}

	public Produto(String nome, String fabricante, String cor, double vlrVenda) {
		this.nome = nome;
		this.fabricante = fabricante;
		this.cor = cor;
		this.vlrVenda = vlrVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(int qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public int getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(int qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public double getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(double vlrVenda) {
		this.vlrVenda = vlrVenda;
	}

	public double getVlrCompra() {
		return vlrCompra;
	}

	public void setVlrCompra(double vlrCompra) {
		this.vlrCompra = vlrCompra;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Produto)) return false;
		Produto produto = (Produto) o;
		return Objects.equals(getId(), produto.getId()) &&
			 Objects.equals(getNome(), produto.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getNome());
	}
}
