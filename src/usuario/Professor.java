package usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.ProfessorDAO;
import infra.ConnectionPool;

import javax.swing.ImageIcon;

public class Professor {

	private JFrame frame;
	private JTextField codigoField;
	private JTextField professorField;



	/**
	 * Create the application.
	 */
	public Professor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setBounds(100, 100, 461, 423);
		frame.setVisible(true);
		frame.setTitle("Teacher Form");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("REGISTRATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		label.setBounds(113, 45, 139, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("DATA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		label_1.setBounds(250, 45, 139, 23);
		frame.getContentPane().add(label_1);
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCdigo.setBounds(10, 122, 301, 14);
		frame.getContentPane().add(lblCdigo);
		
		codigoField = new JTextField();
		codigoField.setForeground(Color.WHITE);
		codigoField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		codigoField.setColumns(10);
		codigoField.setBackground(new Color(0, 51, 102));
		codigoField.setBounds(10, 147, 428, 20);
		frame.getContentPane().add(codigoField);
		
		JLabel lblProfessor = new JLabel("PROFESSOR");
		lblProfessor.setForeground(Color.WHITE);
		lblProfessor.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblProfessor.setBounds(10, 179, 301, 14);
		frame.getContentPane().add(lblProfessor);
		
		professorField = new JTextField();
		professorField.setForeground(Color.WHITE);
		professorField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		professorField.setColumns(10);
		professorField.setBackground(new Color(0, 51, 102));
		professorField.setBounds(10, 204, 428, 20);
		frame.getContentPane().add(professorField);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Professor.class.getResource("/icones/cancel.png")));
		btnExcluir.setForeground(new Color(0, 51, 102));
		btnExcluir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnExcluir.setBackground(new Color(0, 51, 102));
		btnExcluir.setBounds(243, 79, 42, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Professor.class.getResource("/icones/accept.png")));
		btnSalvar.setForeground(new Color(0, 51, 102));
		btnSalvar.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnSalvar.setBackground(new Color(0, 51, 102));
		btnSalvar.setBounds(203, 79, 42, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(Professor.class.getResource("/icones/folder.png")));
		btnAbrir.setForeground(new Color(0, 51, 102));
		btnAbrir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnAbrir.setBackground(new Color(0, 51, 102));
		btnAbrir.setBounds(164, 79, 42, 23);
		frame.getContentPane().add(btnAbrir);
		
		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Professor.class.getResource("/icones/add.png")));
		btnNovo.setForeground(new Color(0, 51, 102));
		btnNovo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnNovo.setBackground(new Color(0, 51, 102));
		btnNovo.setBounds(123, 79, 42, 23);
		frame.getContentPane().add(btnNovo);
		
		btnAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigo_aluno = Integer.parseInt(codigoField.getText());
				ProfessorDAO professor = new ProfessorDAO(ConnectionPool.getConexao());
				modelo.Professor vrl = professor.procuraPelo(codigo_aluno);
				
				professorField.setText(vrl.getNome_prof());
				
			}
		});
		
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				codigoField.setText("");
				professorField.setText("");
			
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Integer codigo_prof = Integer.parseInt(codigoField.getText());
				
				try {
					ProfessorDAO prof = new ProfessorDAO(ConnectionPool.getConexao());
					modelo.Professor vrl = prof.procuraPelo(codigo_prof);
					
					
					
					if(vrl != null) {
						
						vrl.setCodigo_prof(Integer.parseInt(codigoField.getText()));
						vrl.setNome_prof(professorField.getText());
				

						prof.altera(vrl);
						
					}else {
						
						vrl.setNome_prof(professorField.getText());
						vrl.setCodigo_prof(Integer.parseInt(codigoField.getText()));
						prof.salva(vrl);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		btnExcluir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigo_prof = Integer.parseInt(codigoField.getText());
				
				ProfessorDAO prof;
				prof = new ProfessorDAO(ConnectionPool.getConexao());
				prof.remove(codigo_prof);
					
			}
			
		});
	}
}
