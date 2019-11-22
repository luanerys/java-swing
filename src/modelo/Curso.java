package modelo;

public class Curso {
	
	private Integer codigo_curs;
	private String curso;
	
	public Curso(Integer codigo_curs, String curso) {
		super();
		this.codigo_curs = codigo_curs;
		this.curso = curso;
	}
	
	public Curso() {
		
	}
	
	public Integer getCodigo_curs() {
		return codigo_curs;
	}

	public void setCodigo_curs(Integer codigo_curs) {
		this.codigo_curs = codigo_curs;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}	
	
	@Override
	public String toString() {
		return codigo_curs + " - " + curso ;
	}
    
}
