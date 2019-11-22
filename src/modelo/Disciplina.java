package modelo;

public class Disciplina {
	
	private Integer codigo_disc;
	private String disciplina;
	private Integer ch;
	private String ementa;
	private String professor;
	
	public Disciplina(Integer codigo_disc, String disciplina, Integer ch, String ementa, String professor) {
		super();
		this.codigo_disc = codigo_disc;
		this.disciplina = disciplina;
		this.ch = ch;
		this.ementa = ementa;
		this.professor = professor;
	}

	public Disciplina() {
		
	}
	
	public Integer getCodigo_disc() {
		return codigo_disc;
	}

	public void setCodigo_disc(Integer codigo_disc) {
		this.codigo_disc = codigo_disc;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getCh() {
		return ch;
	}

	public void setCh(Integer ch) {
		this.ch = ch;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	
	
	
}
