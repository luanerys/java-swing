package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Professor;

public class ProfessorDAO {

	private Connection conexao;

	public ProfessorDAO(Connection connection) {
		this.conexao = connection;
	}

	public boolean salva(Professor professor) throws SQLException {

		String sql = "insert into curso (codigo_prof, nome_prof) values (?,?)";
		try (PreparedStatement statement = conexao.prepareStatement(sql)) {

			statement.setInt(1, professor.getCodigo_prof());
			statement.setString(2, professor.getNome_prof());

			statement.execute();

	}
		return false;

	}
	
	public boolean altera(Professor professor) throws SQLException{

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("update professor set nome_prof=? "
							           + "where codigo_prof=?");
			
			ps.setInt(1, professor.getCodigo_prof());
			ps.setString(2, professor.getNome_prof());
		
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	public boolean remove(Integer professor) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("delete from Aluno where codigo_aluno=?");
			
			ps.setInt(1, professor);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	public Professor procuraPelo(Integer codigo_prof) {

		try (PreparedStatement ps = this.conexao
				.prepareStatement("select codigo_prof, nome_prof "
						+ "from professor "
						+ "where codigo_prof = ?") ) {

			ps.setInt(1, codigo_prof);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Professor professor = montarProfessor(rs);
			return professor;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Professor montarProfessor(ResultSet rs) throws SQLException {
		
		Professor aluno = new Professor();
		aluno.setNome_prof(rs.getString("nome_prof"));
		return aluno;
	}
}
