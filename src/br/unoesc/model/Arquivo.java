package br.unoesc.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "arquivo")
public class Arquivo {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_linha", unique = true, nullable = false)
	private long id;// chave primaria tabela
	// informacoes do arquivo
	 @Column(name = "line_arq", unique = true, nullable = false)
	private int line;
	 @Column(name = "est_civil", unique = false, nullable = false, length = 20)
	private String est_civil;
	 @Column(name = "escolaridade", unique = false, nullable = false, length = 100)
	private String escolaridade;
	 @Column(name = "qtdFilhos", unique = false, nullable = false)
	private int nFilhos;
	 @Column(name = "Salario", unique = false, nullable = false)
	private float Salario;
	 @Column(name = "idade_anos", unique = false, nullable = false)
	private int idade_anos;
	 @Column(name = "idade_meses", unique = false, nullable = false)
	private int idade_meses;
	 @Column(name = "dtCompra", unique = false, nullable = false)
	private Date dtCompra;
	 @Column(name = "Valor", unique = false, nullable = false)
	private float Valor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getEst_civil() {
		return est_civil;
	}

	public void setEst_civil(String est_civil) {
		this.est_civil = est_civil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getnFilhos() {
		return nFilhos;
	}

	public void setnFilhos(int nFilhos) {
		this.nFilhos = nFilhos;
	}

	public float getSalario() {
		return Salario;
	}

	public void setSalario(float salario) {
		Salario = salario;
	}

	public int getIdade_anos() {
		return idade_anos;
	}

	public void setIdade_anos(int idade_anos) {
		this.idade_anos = idade_anos;
	}

	public int getIdade_meses() {
		return idade_meses;
	}

	public void setIdade_meses(int idade_meses) {
		this.idade_meses = idade_meses;
	}

	public Date getDtCompra() {
		return dtCompra;
	}

	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}

	public float getValor() {
		return Valor;
	}

	public void setValor(float valor) {
		Valor = valor;
	}

}
