package usuario;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class MatriculaAluno {

	private JFrame frmMatricula;

	public MatriculaAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMatricula = new JFrame();
		frmMatricula.setTitle("Matricula Aluno");
		frmMatricula.getContentPane().setBackground(new Color(0, 51, 102));
		frmMatricula.setBounds(100, 100, 461, 445);
		frmMatricula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMatricula.setResizable(false);
		frmMatricula.setLocationRelativeTo(null);
		frmMatricula.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("REGISTRATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		label.setBounds(113, 28, 139, 23);
		frmMatricula.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("DATA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		label_1.setBounds(250, 28, 139, 23);
		frmMatricula.getContentPane().add(label_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MatriculaAluno.class.getResource("/icones/add.png")));
		button.setForeground(new Color(0, 51, 102));
		button.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		button.setBackground(new Color(0, 51, 102));
		button.setBounds(123, 62, 42, 23);
		frmMatricula.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MatriculaAluno.class.getResource("/icones/folder.png")));
		button_1.setForeground(new Color(0, 51, 102));
		button_1.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		button_1.setBackground(new Color(0, 51, 102));
		button_1.setBounds(164, 62, 42, 23);
		frmMatricula.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(MatriculaAluno.class.getResource("/icones/accept.png")));
		button_2.setForeground(new Color(0, 51, 102));
		button_2.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		button_2.setBackground(new Color(0, 51, 102));
		button_2.setBounds(203, 62, 42, 23);
		frmMatricula.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(MatriculaAluno.class.getResource("/icones/cancel.png")));
		button_3.setForeground(new Color(0, 51, 102));
		button_3.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		button_3.setBackground(new Color(0, 51, 102));
		button_3.setBounds(243, 62, 42, 23);
		frmMatricula.getContentPane().add(button_3);
		
		JLabel lblAluno = new JLabel("ALUNO");
		lblAluno.setForeground(Color.WHITE);
		lblAluno.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblAluno.setBounds(10, 105, 301, 14);
		frmMatricula.getContentPane().add(lblAluno);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCurso.setBounds(10, 162, 301, 14);
		frmMatricula.getContentPane().add(lblCurso);
		
		JComboBox <String>comboBox = new JComboBox <String>();
		comboBox.setEditable(true);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 130, 419, 20);
		frmMatricula.getContentPane().add(comboBox);
		
		JComboBox <String>comboBox_1 = new JComboBox <String>();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(10, 187, 419, 20);
		frmMatricula.getContentPane().add(comboBox_1);
		
		String linha[][] = {{"","",""}};
		String coluna[] = {"ALUNO", "CURSO"};
		JTable tabela = new JTable(linha,coluna);
		tabela.setForeground(new Color(0, 51, 102));
		tabela.setColumnSelectionAllowed(true);
		tabela.setCellSelectionEnabled(true);
		tabela.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		
		tabela.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 11));
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 232, 425, 100);
		frmMatricula.getContentPane().add(scrollPane);
	}
}
