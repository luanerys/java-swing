
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Disciplina;

public class DisciplinaDAO {
	
	private Connection conexao;

	public DisciplinaDAO(Connection connection) {
		this.conexao = connection;
	}

	public boolean salva(Disciplina disciplina) throws SQLException {

		String sql = "insert into disciplina (codigo_disc, disciplina, ch, ementa, professor) values (?,?,?,?,?)";
		try (PreparedStatement statement = conexao.prepareStatement(sql)) {

			statement.setInt(1, disciplina.getCodigo_disc());
			statement.setString(2, disciplina.getDisciplina());
			statement.setInt(3, disciplina.getCh());
			statement.setString(4, disciplina.getEmenta());
			statement.setString(5, disciplina.getProfessor());

			statement.execute();

	}
		return false;

	}
	
	public boolean altera(Disciplina disciplina) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("update disciplina set ch=?,disciplina=?,ementa=?,professor=? "
							           + "where codigo_disc=?");
			
			ps.setInt(1, disciplina.getCodigo_disc());
			ps.setInt(2, disciplina.getCh());
			ps.setString(2, disciplina.getDisciplina());
			ps.setString(2, disciplina.getEmenta());
			ps.setString(2, disciplina.getProfessor());
		
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	public boolean remove(Integer disciplina) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("delete from disciplina where codigo_disc=?");
			
			ps.setInt(1, disciplina);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	public Disciplina procuraPelo(Integer codigo_disc) {

		try (PreparedStatement ps = this.conexao
				.prepareStatement("select codigo_disc, ch, disciplina, ementa, professor "
						+ "from disciplina "
						+ "where codigo_disc = ?") ) {

			ps.setInt(1, codigo_disc);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Disciplina disciplina = montarDisciplina(rs);
			return disciplina;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Disciplina montarDisciplina(ResultSet rs) throws SQLException {
		
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo_disc(rs.getInt("codigo_disc"));
		disciplina.setCh(rs.getInt("ch"));
		disciplina.setDisciplina(rs.getString("disciplina"));
		disciplina.setEmenta(rs.getString("ementa"));
		disciplina.setProfessor(rs.getString("professor"));
		return disciplina;
	}

	public List<Disciplina> buscaDisciplinas() {
        String sql = "select * from disciplina";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {

                final List<Disciplina> disciplinas = new ArrayList<>();

                while (resultSet.next()) {
                	Disciplina disciplina = montarDisciplina(resultSet);
                	disciplinas.add(disciplina);
                }
                return disciplinas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
	}

}
    

