package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;

public class AlunoDAO {
	
	private Connection conexao;

	public AlunoDAO(Connection connection) {
		this.conexao = connection;
	}

	public boolean salva(Aluno aluno)  {

		String sql = "insert into aluno (codigo_aluno, rg, cpf, nome, endereco, telefone) values (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = conexao.prepareStatement(sql)) {

			statement.setInt(1, aluno.getCodigo_aluno());
			statement.setString(2, aluno.getRg());
			statement.setString(3, aluno.getCpf());
			statement.setString(4, aluno.getNome());
			statement.setString(5, aluno.getEndereco());
			statement.setString(6, aluno.getTelefone());
			
			boolean salva = 
			statement.execute();
			return salva;
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e );
		}
		
	}
	
	public List<Aluno> buscaAlunos() {
        String sql = "select * from aluno";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {

                final List<Aluno> alunos = new ArrayList<>();

                while (resultSet.next()) {
                    Aluno aluno = monta(resultSet);
                    alunos.add(aluno);
                }
                return alunos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
	}
        
	private Aluno monta(ResultSet resultSet) {
		 try {
	        	Integer codigo_aluno = resultSet.getInt("codigo_aluno");
	            String nome = resultSet.getString("nome");
	            String endereco = resultSet.getString("endereco");
	            String rg = resultSet.getString("rg");
	            String cpf = resultSet.getString("cpf");
	            String telefone = resultSet.getString("telefone");
	            
	    
	            Aluno aluno = new Aluno(codigo_aluno, rg, cpf, nome, endereco, telefone);
	           
	            return aluno;
	        } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	        }
	}

	public boolean altera(Aluno aluno) throws SQLException{

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("update Aluno set rg=?, cpf=?, nome=?, endereco=?, telefone=? "
							           + "where codigo_aluno=?");
			
			ps.setString(1, aluno.getRg());
			ps.setString(2, aluno.getCpf());
			ps.setString(3, aluno.getNome());
			ps.setString(4, aluno.getEndereco());
			ps.setString(5, aluno.getTelefone());
			ps.setInt(6, aluno.getCodigo_aluno());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	public boolean remove(Integer aluno) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("delete from Aluno where codigo_aluno=?");
			ps.setInt(1, aluno);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	public Aluno procuraPelo(Integer codigo_aluno) {

		try (PreparedStatement ps = this.conexao
				.prepareStatement("select codigo_aluno, rg, cpf, nome, endereco, telefone "
						+ "from Aluno "
						+ "where codigo_aluno = ?") ) {

			ps.setInt(1, codigo_aluno);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Aluno aluno = montarAluno(rs);
			return aluno;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Aluno montarAluno(ResultSet rs) throws SQLException {
		
		Aluno aluno = new Aluno();
		aluno.setCodigo_aluno(rs.getInt("codigo_aluno"));
		aluno.setRg(rs.getString("rg"));
		aluno.setCpf(rs.getString("cpf"));
		aluno.setNome(rs.getString("nome"));
		aluno.setEndereco(rs.getString("endereco"));
		aluno.setTelefone(rs.getString("telefone"));
		return aluno;
	}

}