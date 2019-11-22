package modelo;

public class Professor {
	
	private Integer codigo_prof;
	private String nome_prof;
	private String disciplina;
	
	public Professor(Integer codigo_prof, String nome_prof,String disciplina) {
		super();
		this.codigo_prof = codigo_prof;
		this.nome_prof = nome_prof;
		this.disciplina = disciplina;
	}
	
	public Professor(){
		
	}
	public Integer getCodigo_prof() {
		return codigo_prof;
	}

	public void setCodigo_prof(Integer codigo_prof) {
		this.codigo_prof = codigo_prof;
	}

	public String getNome_prof() {
		return nome_prof;
	}

	public void setNome_prof(String nome_prof) {
		this.nome_prof = nome_prof;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	
	

}
