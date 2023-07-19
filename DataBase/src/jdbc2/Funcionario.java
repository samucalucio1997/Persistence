package jdbc2;

public class Funcionario {
	private float salario;
	private String nome;
	
	public Funcionario(String nome, float salario) {
		this.nome=nome;
		this.salario=salario;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
