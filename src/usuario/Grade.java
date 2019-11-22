package usuario;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import dao.GradeDAO;
import infra.ConnectionPool;
import modelo.Disciplina;
import modelo.Aluno;
import modelo.Curso;

import javax.swing.JScrollPane;

public class Grade {

	private JFrame frmGrade;
	private JTextField anoField;
	private JComboBox<Disciplina> discCB;
	private JComboBox<Curso> cursoCB;
	private DefaultTableModel modelo;


	public Grade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param cursoCB 
	 */
	private void initialize() {
		frmGrade = new JFrame();
		frmGrade.setTitle("Grade");
		frmGrade.setResizable(false);
		frmGrade.setVisible(true);
		frmGrade.getContentPane().setBackground(new Color(0, 51, 102));
		frmGrade.setBounds(100, 100, 452, 459);
		frmGrade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGrade.setLocationRelativeTo(null);
		frmGrade.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("REGISTRATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		label.setBounds(113, 30, 139, 23);
		frmGrade.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("DATA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		label_1.setBounds(250, 30, 139, 23);
		frmGrade.getContentPane().add(label_1);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Grade.class.getResource("/icones/cancel.png")));
		btnExcluir.setForeground(new Color(0, 51, 102));
		btnExcluir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnExcluir.setBackground(new Color(0, 51, 102));
		btnExcluir.setBounds(243, 64, 42, 23);
		frmGrade.getContentPane().add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Grade.class.getResource("/icones/accept.png")));
		btnSalvar.setForeground(new Color(0, 51, 102));
		btnSalvar.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnSalvar.setBackground(new Color(0, 51, 102));
		btnSalvar.setBounds(203, 64, 42, 23);
		frmGrade.getContentPane().add(btnSalvar);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(Grade.class.getResource("/icones/folder.png")));
		btnAbrir.setForeground(new Color(0, 51, 102));
		btnAbrir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnAbrir.setBackground(new Color(0, 51, 102));
		btnAbrir.setBounds(164, 64, 42, 23);
		frmGrade.getContentPane().add(btnAbrir);
		
		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Grade.class.getResource("/icones/add.png")));
		btnNovo.setForeground(new Color(0, 51, 102));
		btnNovo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnNovo.setBackground(new Color(0, 51, 102));
		btnNovo.setBounds(123, 64, 42, 23);
		frmGrade.getContentPane().add(btnNovo);
		
		JLabel lblAno = new JLabel("ANO");
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblAno.setBounds(10, 107, 301, 14);
		frmGrade.getContentPane().add(lblAno);
		
		JLabel label_3 = new JLabel("CURSO");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		label_3.setBounds(10, 164, 301, 14);
		frmGrade.getContentPane().add(label_3);
		
		cursoCB = new JComboBox <Curso>();
		cursoCB.setEditable(true);
		cursoCB.setBounds(10, 189, 419, 20);
		frmGrade.getContentPane().add(cursoCB);
		populaComboBoxCurso();
		
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA");
		lblDisciplina.setForeground(Color.WHITE);
		lblDisciplina.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblDisciplina.setBounds(10, 220, 301, 14);
		frmGrade.getContentPane().add(lblDisciplina);
		
		discCB = new JComboBox <Disciplina>();
		discCB.setEditable(true);
		discCB.setBounds(10, 245, 419, 20);
		frmGrade.getContentPane().add(discCB);
		populaComboBoxDisciplina();
		
		
		String linha[][] = {{"","",""}};
		String coluna[] = {"Disciplina", "CH"};
		
		JTable tabela = new JTable(linha,coluna);
		tabela.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{"", ""},
			},
			new String[] {
				"DISCIPLINA", "CARGA HORÁRIA"
			}
		));
		
		tabela.setFont(new Font("Nirmala UI Semiligh", Font.BOLD, 11));
		
		anoField = new JTextField();
		anoField.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		anoField.setForeground(new Color(0, 51, 102));
		anoField.setBackground(Color.WHITE);
		anoField.setBounds(10, 133, 419, 20);
		frmGrade.getContentPane().add(anoField);
		anoField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 288, 419, 58);
		frmGrade.getContentPane().add(scrollPane);
		
		
		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cursoCB.setSelectedIndex(0);
				discCB.setSelectedIndex(0);

			}
		});
		
		btnAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				preencheTabela();
				
			}
		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Curso curso = (Curso) cursoCB.getSelectedItem();
				Disciplina disciplina = (Disciplina) discCB.getSelectedItem();
				
				modelo.Grade gr = new modelo.Grade();
				
				GradeDAO dao = new GradeDAO(ConnectionPool.getConexao());
				
				
				
				 if(dao.buscaGradeDados(curso, disciplina) == null && JOptionPane.showConfirmDialog(null, "Não foi encontrado relacionamento entre curso "+ cursoCB.getSelectedItem()+" e disciplina " +discCB.getSelectedItem() + " no banco.\nDeseja cadastrar nova grade?", "Salvar",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					 
					 dao.salvar(gr);
				     JOptionPane.showMessageDialog(null, "Grade Salva com Sucesso");
				     preencheTabela();
				     
				 }
	
			}
		});

		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Curso curso = (Curso) cursoCB.getSelectedItem();
				Disciplina disciplina = (Disciplina) discCB.getSelectedItem();
				
				GradeDAO dao = new GradeDAO(ConnectionPool.getConexao());
				 if(dao.buscaGradeDados(curso, disciplina) != null && JOptionPane.showConfirmDialog(null, "Deseja excluir grade do curso "+ cursoCB.getSelectedItem()+" e disciplina " +discCB.getSelectedItem() + "?", "Excluir",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					 
					 modelo.Grade gr = new modelo.Grade();
					 dao.remove(gr);
					 
				 }else {
					 JOptionPane.showMessageDialog(null, "Não pode excluir! Grade de "+discCB.getSelectedItem()+" e curso "+cursoCB.getSelectedItem()+" não existe no banco de dados.");
				 }
					

			}
		});
	}
	
	private void populaComboBoxDisciplina() {

		List<Disciplina> diciplinas = new ArrayList<Disciplina>();

		DisciplinaDAO disDAO = new DisciplinaDAO(ConnectionPool.getConexao());
		diciplinas = disDAO.buscaDisciplinas();

		for (Disciplina disciplina : diciplinas) {
			discCB.addItem(disciplina);
		}
	}
	

	
	private void populaComboBoxCurso()  {

		List<Curso> cursos = new ArrayList<Curso>();

		CursoDAO cursoDao = new CursoDAO(ConnectionPool.getConexao());
		cursos = cursoDao.buscaCursos();

		for (Curso curso : cursos) {
			cursoCB.addItem(curso);
		}
	}
	
	private void preencheTabela() {
		
		modelo.setNumRows(0);
		Aluno disc = (Aluno) discCB.getSelectedItem();
		
		
		CursoDAO dao = new CursoDAO(ConnectionPool.getConexao());
		List<Curso> cursos = dao.buscarNomeCursoPor(disc);
		
		
		if(cursos.size() == 0) {
			JOptionPane.showMessageDialog(null, "A disciplina  "+ discCB.getSelectedItem() +" não está inserida em nenhum curso");
		}
		
		for (Curso curso : cursos) {
			
			modelo.addRow(new Object[] {
					curso,
			});
		}

	}


}
