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

import dao.CursoDAO;
import infra.ConnectionPool;

import javax.swing.ImageIcon;

public class Curso {

	private JFrame frame;
	private JTextField codigoField;
	private JTextField cursoField;

	
	/**
	 * Create the application.
	 */
	public Curso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setBounds(100, 100, 462, 409);
		frame.setVisible(true);
		frame.setTitle("Course Form");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("REGISTRATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		label.setBounds(113, 37, 139, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("DATA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		label_1.setBounds(250, 37, 139, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("C\u00D3DIGO");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		label_2.setBounds(10, 114, 301, 14);
		frame.getContentPane().add(label_2);
		
		codigoField = new JTextField();
		codigoField.setForeground(Color.WHITE);
		codigoField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		codigoField.setColumns(10);
		codigoField.setBackground(new Color(0, 51, 102));
		codigoField.setBounds(10, 139, 428, 20);
		frame.getContentPane().add(codigoField);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCurso.setBounds(10, 171, 301, 14);
		frame.getContentPane().add(lblCurso);
		
		cursoField = new JTextField();
		cursoField.setForeground(Color.WHITE);
		cursoField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		cursoField.setColumns(10);
		cursoField.setBackground(new Color(0, 51, 102));
		cursoField.setBounds(10, 196, 428, 20);
		frame.getContentPane().add(cursoField);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Curso.class.getResource("/icones/cancel.png")));
		btnExcluir.setForeground(new Color(0, 51, 102));
		btnExcluir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnExcluir.setBackground(new Color(0, 51, 102));
		btnExcluir.setBounds(243, 71, 42, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Curso.class.getResource("/icones/accept.png")));
		btnSalvar.setForeground(new Color(0, 51, 102));
		btnSalvar.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnSalvar.setBackground(new Color(0, 51, 102));
		btnSalvar.setBounds(203, 71, 42, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(Curso.class.getResource("/icones/folder.png")));
		btnAbrir.setForeground(new Color(0, 51, 102));
		btnAbrir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnAbrir.setBackground(new Color(0, 51, 102));
		btnAbrir.setBounds(164, 71, 42, 23);
		frame.getContentPane().add(btnAbrir);
		
		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Curso.class.getResource("/icones/add.png")));
		btnNovo.setForeground(new Color(0, 51, 102));
		btnNovo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnNovo.setBackground(new Color(0, 51, 102));
		btnNovo.setBounds(123, 71, 42, 23);
		frame.getContentPane().add(btnNovo);
		
btnAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigo_curs = Integer.parseInt(codigoField.getText());
				CursoDAO curso = new CursoDAO(ConnectionPool.getConexao());
				modelo.Curso vrl = curso.procuraPelo(codigo_curs);
				
				cursoField.setText(vrl.getCurso());
				
			}
		});
		
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				codigoField.setText("");
				cursoField.setText("");
			
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Integer codigo_curs = Integer.parseInt(codigoField.getText());
				
				try {
					CursoDAO crs = new CursoDAO(ConnectionPool.getConexao());
					modelo.Curso vrl = crs.procuraPelo(codigo_curs);
					
					
					
					if(vrl != null) {
						
						vrl.setCodigo_curs(Integer.parseInt(codigoField.getText()));
						vrl.setCurso(cursoField.getText());
				

						crs.altera(vrl);
						
					}else {
						
						vrl.setCurso(cursoField.getText());
						vrl.setCodigo_curs(Integer.parseInt(codigoField.getText()));
						crs.salva(vrl);
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
				Integer codigo_curs = Integer.parseInt(codigoField.getText());
				
				CursoDAO crs;
				crs = new CursoDAO(ConnectionPool.getConexao());
				crs.remove(codigo_curs);
					
			}
			
		});
	}

}
