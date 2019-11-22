package modelo;

public class Professor_Disciplina {
	
	private Professor professor;
	private Disciplina disciplina;
	
	public Professor_Disciplina(Professor professor, Disciplina disciplina) {
		super();
		this.professor = professor;
		this.disciplina = disciplina;
	}
	public Professor_Disciplina() {
		
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	

}
