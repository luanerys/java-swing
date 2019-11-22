package usuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DisciplinaDAO;
import infra.ConnectionPool;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Disciplina {

	private JFrame frame;
	private JTextField codigoField;
	private JTextField discField;
	private JTextField ementaField;
	private JTextField chField;


	/**
	 * Create the application.
	 */
	public Disciplina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setBounds(100, 100, 460, 449);
		frame.setVisible(true);
		frame.setTitle("Discipline Form");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("REGISTRATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		label.setBounds(111, 33, 139, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("DATA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		label_1.setBounds(248, 33, 139, 23);
		frame.getContentPane().add(label_1);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Disciplina.class.getResource("/icones/cancel.png")));
		btnExcluir.setForeground(new Color(0, 51, 102));
		btnExcluir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnExcluir.setBackground(new Color(0, 51, 102));
		btnExcluir.setBounds(243, 74, 42, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Disciplina.class.getResource("/icones/accept.png")));
		btnSalvar.setForeground(new Color(0, 51, 102));
		btnSalvar.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnSalvar.setBackground(new Color(0, 51, 102));
		btnSalvar.setBounds(203, 74, 42, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(Disciplina.class.getResource("/icones/folder.png")));
		btnAbrir.setForeground(new Color(0, 51, 102));
		btnAbrir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnAbrir.setBackground(new Color(0, 51, 102));
		btnAbrir.setBounds(164, 74, 42, 23);
		frame.getContentPane().add(btnAbrir);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNovo.setIcon(new ImageIcon(Disciplina.class.getResource("/icones/add.png")));
		btnNovo.setForeground(new Color(0, 51, 102));
		btnNovo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnNovo.setBackground(new Color(0, 51, 102));
		btnNovo.setBounds(123, 74, 42, 23);
		frame.getContentPane().add(btnNovo);
		
		JLabel lblCdigo = new JLabel("CÓDIGO");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCdigo.setBounds(10, 117, 196, 14);
		frame.getContentPane().add(lblCdigo);
		
		codigoField = new JTextField();
		codigoField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		codigoField.setColumns(10);
		codigoField.setBackground(new Color(0, 51, 102));
		codigoField.setBounds(10, 142, 196, 20);
		frame.getContentPane().add(codigoField);
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA");
		lblDisciplina.setForeground(Color.WHITE);
		lblDisciplina.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblDisciplina.setBounds(10, 174, 301, 14);
		frame.getContentPane().add(lblDisciplina);
		
		discField = new JTextField();
		discField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		discField.setColumns(10);
		discField.setBackground(new Color(0, 51, 102));
		discField.setBounds(10, 199, 428, 20);
		frame.getContentPane().add(discField);
		
		JLabel lblEmenta = new JLabel("EMENTA");
		lblEmenta.setForeground(Color.WHITE);
		lblEmenta.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblEmenta.setBounds(10, 230, 301, 14);
		frame.getContentPane().add(lblEmenta);
		
		ementaField = new JTextField();
		ementaField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		ementaField.setColumns(10);
		ementaField.setBackground(new Color(0, 51, 102));
		ementaField.setBounds(10, 250, 428, 115);
		frame.getContentPane().add(ementaField);
		
		chField = new JTextField();
		chField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		chField.setColumns(10);
		chField.setBackground(new Color(0, 51, 102));
		chField.setBounds(213, 142, 225, 20);
		frame.getContentPane().add(chField);
		
		JLabel lblCargaHorria = new JLabel("CARGA HORÁRIA");
		lblCargaHorria.setForeground(Color.WHITE);
		lblCargaHorria.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCargaHorria.setBounds(213, 117, 301, 14);
		frame.getContentPane().add(lblCargaHorria);
		
		btnAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigo_disc = Integer.parseInt(codigoField.getText());
				DisciplinaDAO disc = new DisciplinaDAO(ConnectionPool.getConexao());
				modelo.Disciplina vrl = disc.procuraPelo(codigo_disc);
				
				chField.setText(String.valueOf(vrl.getCh()));
				ementaField.setText(vrl.getEmenta());
				discField.setText(vrl.getDisciplina());
				
			}
		});
		
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				codigoField.setText("");
				chField.setText("");
				ementaField.setText("");
				discField.setText("");
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Integer codigo_disc = Integer.parseInt(codigoField.getText());
				
				try {
					DisciplinaDAO disc = new DisciplinaDAO(ConnectionPool.getConexao());
					modelo.Disciplina vrl = disc.procuraPelo(codigo_disc);
					
					
					
					if(vrl != null) {
						
						vrl.setCh(Integer.parseInt(chField.getText()));
						vrl.setEmenta(ementaField.getText());
						vrl.setDisciplina(discField.getText());

						disc.altera(vrl);
						
					}else {
						

						vrl.setCh(Integer.parseInt(chField.getText()));
						vrl.setEmenta(ementaField.getText());
						vrl.setDisciplina(discField.getText());
						disc.salva(vrl);
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
				Integer codigo_disc = Integer.parseInt(codigoField.getText());
				
				DisciplinaDAO disc;
				disc = new DisciplinaDAO(ConnectionPool.getConexao());
				disc.remove(codigo_disc);
					
			}
			
		});
		
	}
	
	
}
