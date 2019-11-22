package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Aluno;
import modelo.Curso;
import modelo.Matricula;

public class MatriculaDAO {

	
	private Connection conexao;

    public MatriculaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public Matricula salvar(Matricula matricula) {
    	
        String sql = "insert into matricula_aluno(codigo_aluno, codigo_curs) values(?,?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {

        
            statement.setInt(1, matricula.getAluno().getCodigo_aluno());
            statement.setInt(2, matricula.getCurso().getCodigo_curs());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return matricula;
    }

    public Matricula procuraPelo(Aluno aluno, Curso curso) {

    	try (PreparedStatement ps = this.conexao
			.prepareStatement("select codigo_aluno, codigo_curs" + "from matricula_aluno" + "where codigo_aluno = ? and codigo_curs = ?") ) {

    		ps.setInt(1, aluno.getCodigo_aluno());
    		ps.setInt(2, curso.getCodigo_curs());
    		ResultSet rs = ps.executeQuery();
    		if (!rs.next()) {
    			return null;
    		}
    		Matricula matricula = montarMatricula(rs);
    			return matricula;

    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
	}
    
    public boolean remove(Matricula matricula) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("delete from matricula_aluno where codigo_curs = ? and codigo_aluno = ?");
			
			ps.setInt(1, matricula.getAluno().getCodigo_aluno());
    		ps.setInt(2, matricula.getCurso().getCodigo_curs());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	private Matricula montarMatricula(ResultSet rs) throws SQLException {
		
		Matricula matricula  = new Matricula();
		
		try {
			((PreparedStatement) matricula).setInt(1, matricula.getCurso().getCodigo_curs());
			((PreparedStatement) matricula).setInt(1, matricula.getAluno().getCodigo_aluno());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return matricula;
		
	}
	
	
	
	
	 public Matricula buscaMatriculaDado(Curso curso, Aluno aluno) {
	    	String sql = "select * from matricula_aluno where codigo_curs = ? and codigo_aluno = ?";
	    	 try (PreparedStatement statement = conexao.prepareStatement(sql)) {
	    		 
		            statement.setInt(1, curso.getCodigo_curs());
		            statement.setInt(2, aluno.getCodigo_aluno());
		            
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next())
		                    return montarMatricula(resultSet);
		                return null;
		            }
		        } catch (SQLException e) {
		            throw new RuntimeException(e.getMessage());
		        }
	    }
	
}
