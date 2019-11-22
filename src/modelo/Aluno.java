package modelo;

public class Aluno {
	
	private Integer codigo_aluno;
	private String rg;
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Aluno(Integer codigo_aluno, String rg, String cpf, String nome, String endereco, String telefone) {
		super();
		this.codigo_aluno = codigo_aluno;
		this.rg = rg;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public Aluno() {
	}

	public Integer getCodigo_aluno() {
		return codigo_aluno;
	}

	public void setCodigo_aluno(Integer codigo_aluno) {
		this.codigo_aluno = codigo_aluno;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
	@Override
	public String toString() {
		return codigo_aluno + " - " + nome ;
	}
    

}
