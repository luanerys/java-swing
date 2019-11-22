package usuario;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class ProfessorDisciplina {

	private JFrame frmProfessorDisciplina;

	public ProfessorDisciplina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfessorDisciplina = new JFrame();
		frmProfessorDisciplina.setTitle("Professor Disciplina");
		frmProfessorDisciplina.getContentPane().setBackground(new Color(0, 51, 102));
		frmProfessorDisciplina.setBounds(100, 100, 454, 422);
		frmProfessorDisciplina.setResizable(false);
		frmProfessorDisciplina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmProfessorDisciplina.setLocationRelativeTo(null);
		frmProfessorDisciplina.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("REGISTRATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		label.setBounds(113, 36, 139, 23);
		frmProfessorDisciplina.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("DATA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		label_1.setBounds(250, 36, 139, 23);
		frmProfessorDisciplina.getContentPane().add(label_1);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(ProfessorDisciplina.class.getResource("/icones/cancel.png")));
		btnExcluir.setForeground(new Color(0, 51, 102));
		btnExcluir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnExcluir.setBackground(new Color(0, 51, 102));
		btnExcluir.setBounds(243, 70, 42, 23);
		frmProfessorDisciplina.getContentPane().add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(ProfessorDisciplina.class.getResource("/icones/accept.png")));
		btnSalvar.setForeground(new Color(0, 51, 102));
		btnSalvar.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnSalvar.setBackground(new Color(0, 51, 102));
		btnSalvar.setBounds(203, 70, 42, 23);
		frmProfessorDisciplina.getContentPane().add(btnSalvar);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(ProfessorDisciplina.class.getResource("/icones/folder.png")));
		btnAbrir.setForeground(new Color(0, 51, 102));
		btnAbrir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnAbrir.setBackground(new Color(0, 51, 102));
		btnAbrir.setBounds(164, 70, 42, 23);
		frmProfessorDisciplina.getContentPane().add(btnAbrir);
		
		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(ProfessorDisciplina.class.getResource("/icones/add.png")));
		btnNovo.setForeground(new Color(0, 51, 102));
		btnNovo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnNovo.setBackground(new Color(0, 51, 102));
		btnNovo.setBounds(123, 70, 42, 23);
		frmProfessorDisciplina.getContentPane().add(btnNovo);
		
		JLabel lblProfessor = new JLabel("PROFESSOR");
		lblProfessor.setForeground(Color.WHITE);
		lblProfessor.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblProfessor.setBounds(10, 113, 301, 14);
		frmProfessorDisciplina.getContentPane().add(lblProfessor);
		
		JComboBox <String>profField = new JComboBox<String>();
		profField.setEditable(true);
		profField.setBounds(10, 138, 419, 20);
		frmProfessorDisciplina.getContentPane().add(profField);
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA");
		lblDisciplina.setForeground(Color.WHITE);
		lblDisciplina.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblDisciplina.setBounds(10, 170, 301, 14);
		frmProfessorDisciplina.getContentPane().add(lblDisciplina);
		
		JComboBox <String>discField = new JComboBox<String>();
		discField.setEditable(true);
		discField.setBounds(10, 195, 419, 20);
		frmProfessorDisciplina.getContentPane().add(discField);
		
		String linha[][] = {{"","",""}};
		String coluna[] = {"PROFESSOR", "DISCIPLINA"};
		JTable tabela = new JTable(linha,coluna);
		tabela.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		tabela.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 235, 419, 100);
		frmProfessorDisciplina.getContentPane().add(scrollPane);
		scrollPane.setBackground(Color.white);
		
	}
}
