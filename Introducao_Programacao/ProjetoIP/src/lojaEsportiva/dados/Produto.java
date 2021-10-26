package lojaEsportiva.dados;

public class Produto {
	private String tamanho;
	private String modelo;
	private String marca;
	private String	identificador;
	private String tipo;
	private double preco;
	
	
	public Produto(String tamanho, String modelo, String marca, String identificador, String tipo, double preco) {
	this.tamanho=tamanho;
	this.modelo=modelo;
	this.marca=marca;
	this.identificador=identificador;
	this.tipo=tipo;
	this.preco=preco;
	}	
	
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
