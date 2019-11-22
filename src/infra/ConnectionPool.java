package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	
	  private ConnectionPool(){}
	    
	    private static Connection conexao = null;

	    public static Connection getConexao()
	    {
	        if(conexao == null){
	            try{
	                
	                String url = "jdbc:mysql://localhost/universidade?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	                String user = "root";
	                String password = "81230268";
	                conexao = DriverManager.getConnection(url, user, password);
	                System.out.println("Conectado com sucesso");

	            } catch (SQLException e) {
	                throw new RuntimeException(e.getMessage());
	            }
	        }
	        return conexao;
	    }
}