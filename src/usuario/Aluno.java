package usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.AlunoDAO;
import infra.ConnectionPool;

public class Aluno {

	private JFrame frame;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField enderecoField;
	private JTextField cpfField;
	private JTextField rgField;
	private JTextField telefoneField;

	
	/**
	 * Create the application.
	 */
	public Aluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.getContentPane().setForeground(new Color(0, 51, 102));
		frame.setBounds(100, 100, 474, 463);
		frame.setVisible(true);
		frame.setTitle("Student Form");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCdigo = new JLabel("CODE");
		lblCdigo.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCdigo.setForeground(new Color(255, 255, 255));
		lblCdigo.setBounds(10, 110, 301, 14);
		frame.getContentPane().add(lblCdigo);
		
		codigoField = new JTextField();
		codigoField.setForeground(Color.WHITE);
		codigoField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		codigoField.setBackground(new Color(0, 51, 102));
		codigoField.setBounds(10, 135, 438, 20);
		frame.getContentPane().add(codigoField);
		codigoField.setColumns(10);
		
		JLabel lblNome = new JLabel("NAME");
		lblNome.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(10, 166, 301, 14);
		frame.getContentPane().add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setForeground(Color.WHITE);
		nomeField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		nomeField.setBackground(new Color(0, 51, 102));
		nomeField.setBounds(10, 191, 438, 20);
		frame.getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("ADDRESS");
		lblEndereo.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblEndereo.setForeground(new Color(255, 255, 255));
		lblEndereo.setBounds(10, 222, 301, 14);
		frame.getContentPane().add(lblEndereo);
		
		enderecoField = new JTextField();
		enderecoField.setForeground(Color.WHITE);
		enderecoField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		enderecoField.setBackground(new Color(0, 51, 102));
		enderecoField.setBounds(10, 247, 438, 20);
		frame.getContentPane().add(enderecoField);
		enderecoField.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblRg.setForeground(new Color(255, 255, 255));
		lblRg.setBounds(10, 278, 301, 14);
		frame.getContentPane().add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setBounds(238, 278, 73, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblTelefone = new JLabel("PHONE");
		lblTelefone.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(10, 334, 301, 14);
		frame.getContentPane().add(lblTelefone);
		
		cpfField = new JTextField();
		cpfField.setForeground(Color.WHITE);
		cpfField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		cpfField.setBackground(new Color(0, 51, 102));
		cpfField.setBounds(238, 303, 210, 20);
		frame.getContentPane().add(cpfField);
		cpfField.setColumns(10);
		
		rgField = new JTextField();
		rgField.setForeground(Color.WHITE);
		rgField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		rgField.setBackground(new Color(0, 51, 102));
		rgField.setColumns(10);
		rgField.setBounds(10, 303, 220, 20);
		frame.getContentPane().add(rgField);
		
		telefoneField = new JTextField();
		telefoneField.setForeground(Color.WHITE);
		telefoneField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		telefoneField.setBackground(new Color(0, 51, 102));
		telefoneField.setBounds(10, 359, 438, 20);
		frame.getContentPane().add(telefoneField);
		telefoneField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(123, 23, 139, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		lblData.setBounds(259, 23, 139, 23);
		frame.getContentPane().add(lblData);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Aluno.class.getResource("/icones/cancel.png")));
		btnExcluir.setForeground(new Color(0, 51, 102));
		btnExcluir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnExcluir.setBackground(new Color(0, 51, 102));
		btnExcluir.setBounds(253, 65, 42, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Aluno.class.getResource("/icones/accept.png")));
		btnSalvar.setForeground(new Color(0, 51, 102));
		btnSalvar.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnSalvar.setBackground(new Color(0, 51, 102));
		btnSalvar.setBounds(213, 65, 42, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(Aluno.class.getResource("/icones/folder.png")));
		btnAbrir.setForeground(new Color(0, 51, 102));
		btnAbrir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnAbrir.setBackground(new Color(0, 51, 102));
		btnAbrir.setBounds(174, 65, 42, 23);
		frame.getContentPane().add(btnAbrir);
		
		btnAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigo_aluno = Integer.parseInt(codigoField.getText());
				AlunoDAO aluno = new AlunoDAO(ConnectionPool.getConexao());
				modelo.Aluno vrl = aluno.procuraPelo(codigo_aluno);
				
				nomeField.setText(vrl.getNome());
				rgField.setText(vrl.getRg());
				cpfField.setText(vrl.getCpf());
				telefoneField.setText(vrl.getTelefone());
				enderecoField.setText(vrl.getEndereco());
				
			}
		});
		
		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Aluno.class.getResource("/icones/add.png")));
		btnNovo.setForeground(new Color(0, 51, 102));
		btnNovo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnNovo.setBackground(new Color(0, 51, 102));
		btnNovo.setBounds(133, 65, 42, 23);
		frame.getContentPane().add(btnNovo);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				codigoField.setText("");
				nomeField.setText("");
				rgField.setText("");
				cpfField.setText("");
				telefoneField.setText("");
				enderecoField.setText("");
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Integer codigo_aluno = Integer.parseInt(codigoField.getText());
				
				try {
					AlunoDAO aln = new AlunoDAO(ConnectionPool.getConexao());
					modelo.Aluno vrl = aln.procuraPelo(codigo_aluno);
					
					
					
					if(vrl != null) {
						
						vrl.setCpf(cpfField.getText());
						vrl.setEndereco(enderecoField.getText());
						vrl.setNome(nomeField.getText());
						vrl.setRg(rgField.getText());
						vrl.setTelefone(telefoneField.getText());

						aln.altera(vrl);
						
					}else {
						
						vrl.setCpf(cpfField.getText());
						vrl.setEndereco(enderecoField.getText());
						vrl.setNome(nomeField.getText());
						vrl.setRg(rgField.getText());
						vrl.setTelefone(telefoneField.getText());
						vrl.setCodigo_aluno(Integer.parseInt(codigoField.getText()));
						aln.salva(vrl);
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
				Integer codigo_aluno = Integer.parseInt(codigoField.getText());
				
				AlunoDAO aln;
				aln = new AlunoDAO(ConnectionPool.getConexao());
				aln.remove(codigo_aluno);
					
			}
			
		});
	}
	
}

