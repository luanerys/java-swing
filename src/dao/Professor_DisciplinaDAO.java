package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Disciplina;
import modelo.Professor;
import modelo.Professor_Disciplina;

public class Professor_DisciplinaDAO {
	
	private Connection conexao;

    public Professor_DisciplinaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public Professor_Disciplina salvar(Professor_Disciplina pd) {
    	
        String sql = "insert into professor_disciplina(codigo_prof, codigo_disc) values(?,?)";

        try (PreparedStatement statement = conexao.prepareStatement(sql)) {

        
            statement.setInt(1, pd.getDisciplina().getCodigo_disc());
            statement.setInt(2, pd.getProfessor().getCodigo_prof());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return pd;
    }

    public Professor_Disciplina procuraPelo(Disciplina disciplina, Professor professor) {

    	try (PreparedStatement ps = this.conexao
			.prepareStatement("select codigo_disc, codigo_prof" + "from professor_disciplina" + "where codigo_disc = ? and codigo_prof = ?") ) {

    		ps.setInt(1, disciplina.getCodigo_disc());
    		ps.setInt(2, professor.getCodigo_prof());
    		ResultSet rs = ps.executeQuery();
    		if (!rs.next()) {
    			return null;
    		}
    		Professor_Disciplina pf = montarPF(rs);
    			return pf;

    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
	}
    
    public boolean remove(Professor_Disciplina pf) {

		try {
			PreparedStatement ps = this.conexao
					.prepareStatement("delete from professor_disciplina where codigo_disc = ? and codigo_prof = ?");
			
			ps.setInt(1, pf.getDisciplina().getCodigo_disc());
    		ps.setInt(2, pf.getProfessor().getCodigo_prof());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}

	private Professor_Disciplina montarPF(ResultSet rs) throws SQLException {
		
		Professor_Disciplina pf = new Professor_Disciplina();
		
		try {
			((PreparedStatement) pf).setInt(1, pf.getProfessor().getCodigo_prof());
			((PreparedStatement) pf).setInt(1, pf.getDisciplina().getCodigo_disc());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pf;
		
	}
	
	 public Professor_Disciplina buscaPF(Professor professor,Disciplina disciplina) {
	    	String sql = "select * from professor_disciplina where codigo_prof = ? and codigo_disc = ?";
	    	 try (PreparedStatement statement = conexao.prepareStatement(sql)) {
	    		 
		            statement.setInt(1, professor.getCodigo_prof());
		            statement.setInt(2, disciplina.getCodigo_disc());
		            
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next())
		                    return montarPF(resultSet);
		                return null;
		            }
		        } catch (SQLException e) {
		            throw new RuntimeException(e.getMessage());
		        }
	    }


}
