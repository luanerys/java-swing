package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Disciplina;
import modelo.Grade;
import modelo.Curso;

public class GradeDAO {
	

	private Connection conexao;

    public GradeDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public Grade salvar(Grade grade) {
    	
        String sql = "insert into grade(ano,codigo_curs, codigo_disc) values(?,?,?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {

        
            statement.setInt(1, grade.getDisciplina().getCodigo_disc());
            statement.setInt(2, grade.getCurso().getCodigo_curs());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return grade;
    }

    public Grade procuraPelo(Disciplina disciplina, Curso curso) {

    	try (PreparedStatement ps = this.conexao
			.prepareStatement("select codigo_aluno, codigo_curs" + "from grade" + "where codigo_aluno = ? and codigo_curs = ?") ) {

    		ps.setInt(1, disciplina.getCodigo_disc());
    		ps.setInt(2, curso.getCodigo_curs());
    		ResultSet rs = ps.executeQuery();
    		if (!rs.next()) {
    			return null;
    		}
    		Grade grade = montarGrade(rs);
    			return grade;

    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
	}
    
    public boolean remove(Grade grade) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("delete from grade where codigo_curs = ? and codigo_disc = ?");
			
			ps.setInt(1, grade.getDisciplina().getCodigo_disc());
    		ps.setInt(2, grade.getCurso().getCodigo_curs());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	private Grade montarGrade(ResultSet rs) throws SQLException {
		
		Grade grade = new Grade();
		
		try {
			((PreparedStatement) grade).setInt(1, grade.getCurso().getCodigo_curs());
			((PreparedStatement) grade).setInt(1, grade.getDisciplina().getCodigo_disc());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grade;
		
	}
	
	
	 public Grade buscaGradeDados(Curso curso, Disciplina disciplina) {
	    	String sql = "select * from grade where codigo_curs = ? and codigo_disc = ?";
	    	 try (PreparedStatement statement = conexao.prepareStatement(sql)) {
	    		 
		            statement.setInt(1, curso.getCodigo_curs());
		            statement.setInt(2, disciplina.getCodigo_disc());
		            
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next())
		                    return montarGrade(resultSet);
		                return null;
		            }
		        } catch (SQLException e) {
		            throw new RuntimeException(e.getMessage());
		        }
	    }

}
