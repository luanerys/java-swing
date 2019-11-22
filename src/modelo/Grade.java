package modelo;

public class Grade {
	
	private Integer ano;
	private Curso curso;
	private Disciplina disciplina;
	
	public Grade(Integer ano, Curso curso, Disciplina disciplina) {
		super();
		this.ano = ano;
		this.curso = curso;
		this.disciplina = disciplina;
	}

	public Grade() {
		
	}
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
