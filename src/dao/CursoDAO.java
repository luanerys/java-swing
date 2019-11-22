package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;
import modelo.Curso;

public class CursoDAO {

	private Connection conexao;

	public CursoDAO(Connection connection) {
		this.conexao = connection;
	}

	public boolean salva(Curso curso) throws SQLException {

		String sql = "insert into curso (codigo_curs, curso) values (?,?)";
		try (PreparedStatement statement = conexao.prepareStatement(sql)) {

			statement.setInt(1, curso.getCodigo_curs());
			statement.setString(2, curso.getCurso());

			statement.execute();
	}
		return false;

	}
	
	public boolean altera(Curso curso) throws SQLException{

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("update curso set curso=? "
							           + "where codigo_curs=?");
			ps.setInt(1, curso.getCodigo_curs());
			ps.setString(2, curso.getCurso());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}
	
	public List<Curso> buscaCursos() {
        String sql = "select * from curso";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {

                final List<Curso> cursos = new ArrayList<>();

                while (resultSet.next()) {
                    Curso curso = monta(resultSet);
                    cursos.add(curso);
                }
                return cursos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
	}
        
	private Curso monta(ResultSet resultSet) {
		 
		try {
	        	Integer codigo_curs = resultSet.getInt("codigo_curs");
	            String curso = resultSet.getString("curso");          
	    
	            Curso cursos = new Curso(codigo_curs,curso);
	           
	            return cursos;
	        } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	        }
	}

	public boolean remove(Integer curso) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("delete from curso where codigo_curs=?");
			ps.setInt(1, curso);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	public Curso procuraPelo(Integer codigo_curs) {

		try (PreparedStatement ps = this.conexao
				.prepareStatement("select codigo_curs, curso "
						+ "from curso "
						+ "where codigo_curs = ?") ) {

			ps.setInt(1, codigo_curs);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Curso curso = montarCurso(rs);
			return curso;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Curso montarCurso(ResultSet rs) throws SQLException {
		
		Curso curso = new Curso();
		curso.setCurso(rs.getString("curso"));
		return curso;
	}
	
	
	public List<Curso> buscarNomeCursoPor(Aluno nomeAluno) {

		String sql = "select * from curso inner join matricula_aluno on curso.codigo_curs = matricula_aluno.codigo_curs"
				+ " inner join aluno on aluno.codigo_aluno = matricula_aluno.codigo_aluno where aluno.nome = ?";

		try (PreparedStatement statement = conexao.prepareStatement(sql)) {

			statement.setString(1, nomeAluno.getNome());

			try (ResultSet resultSet = statement.executeQuery()) {
				final List<Curso> cursos = new ArrayList<>();

				while (resultSet.next()) {
					Curso curso = monta(resultSet);
					cursos.add(curso);
				}

				return cursos;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
