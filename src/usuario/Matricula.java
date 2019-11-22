package usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.MatriculaDAO;
import infra.ConnectionPool;
import modelo.Aluno;
import modelo.Curso;

public class Matricula {

	private JFrame frmMatricula;
	private JComboBox<Curso> cursoCB;
	private JComboBox<Aluno> alunoCB;
	private JTable tabela;
	private JScrollPane scrollPane;
	private JLabel lblCurso;
	private JLabel lblAluno;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnAbrir;
	private JButton btnNovo;
	private JLabel label_1;
	private JLabel label;
	private DefaultTableModel modelo;

	public Matricula() {
		initialize();
	}

	
	public static void main(String[] args) {
		new Matricula();
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
		frmMatricula.setVisible(true);
		frmMatricula.getContentPane().setLayout(null);
		
		label = new JLabel("REGISTRATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		label.setBounds(113, 28, 139, 23);
		frmMatricula.getContentPane().add(label);
		
		label_1 = new JLabel("DATA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		label_1.setBounds(250, 28, 139, 23);
		frmMatricula.getContentPane().add(label_1);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(Matricula.class.getResource("/icones/add.png")));
		btnNovo.setForeground(new Color(0, 51, 102));
		btnNovo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnNovo.setBackground(new Color(0, 51, 102));
		btnNovo.setBounds(123, 62, 42, 23);
		frmMatricula.getContentPane().add(btnNovo);
		
		btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(Matricula.class.getResource("/icones/folder.png")));
		btnAbrir.setForeground(new Color(0, 51, 102));
		btnAbrir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnAbrir.setBackground(new Color(0, 51, 102));
		btnAbrir.setBounds(164, 62, 42, 23);
		frmMatricula.getContentPane().add(btnAbrir);
		
		btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Matricula.class.getResource("/icones/accept.png")));
		btnSalvar.setForeground(new Color(0, 51, 102));
		btnSalvar.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnSalvar.setBackground(new Color(0, 51, 102));
		btnSalvar.setBounds(203, 62, 42, 23);
		frmMatricula.getContentPane().add(btnSalvar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Matricula.class.getResource("/icones/cancel.png")));
		btnExcluir.setForeground(new Color(0, 51, 102));
		btnExcluir.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		btnExcluir.setBackground(new Color(0, 51, 102));
		btnExcluir.setBounds(243, 62, 42, 23);
		frmMatricula.getContentPane().add(btnExcluir);
		
		lblAluno = new JLabel("ALUNO");
		lblAluno.setForeground(Color.WHITE);
		lblAluno.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblAluno.setBounds(10, 105, 301, 14);
		frmMatricula.getContentPane().add(lblAluno);
		
		lblCurso = new JLabel("CURSO");
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		lblCurso.setBounds(10, 162, 301, 14);
		frmMatricula.getContentPane().add(lblCurso);
		
	
		cursoCB = new JComboBox <Curso>();
		cursoCB.setEditable(true);
		cursoCB.setBounds(10, 187, 419, 20);
		frmMatricula.getContentPane().add(cursoCB);
		populaComboBoxCurso();
		
		
		alunoCB = new JComboBox<Aluno>();
		alunoCB.setEditable(true);
		alunoCB.setBackground(Color.WHITE);
		alunoCB.setBounds(10, 130, 419, 20);
		frmMatricula.getContentPane().add(alunoCB);
		populaComboBoxAluno();
		
		 modelo = new DefaultTableModel();
		 modelo.addColumn("Curso");
		 modelo.setNumRows(0);
		 
		tabela = new JTable(modelo);
		tabela.setForeground(new Color(0, 51, 102));
		tabela.setColumnSelectionAllowed(true);
		tabela.setCellSelectionEnabled(true);
		tabela.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
		
		tabela.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 11));
		scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 232, 425, 100);
		frmMatricula.getContentPane().add(scrollPane);
		
		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cursoCB.setSelectedIndex(0);
				alunoCB.setSelectedIndex(0);

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
				Aluno aluno = (Aluno) alunoCB.getSelectedItem();
				
			
				modelo.Matricula mtr = new modelo.Matricula(aluno, curso);
				
				MatriculaDAO dao = new MatriculaDAO(ConnectionPool.getConexao());
				
				
				
				 if(dao.buscaMatriculaDado(curso, aluno) == null && JOptionPane.showConfirmDialog(null, "Não foi encontrado relacionamento entre curso "+ cursoCB.getSelectedItem()+" e aluno " +alunoCB.getSelectedItem() + " no banco.\nDeseja cadastrar nova matrícula?", "Salvar",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					 
					 dao.salvar(mtr);
				     JOptionPane.showMessageDialog(null, "Grade Salva com Sucesso");
				     preencheTabela();
				     
				 }
	
			}
		});

		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Curso curso = (Curso) cursoCB.getSelectedItem();
				Aluno aluno = (Aluno) alunoCB.getSelectedItem();
				
				MatriculaDAO dao = new MatriculaDAO(ConnectionPool.getConexao());
				 if(dao.buscaMatriculaDado(curso, aluno) != null && JOptionPane.showConfirmDialog(null, "Deseja excluir matrícula de curso "+ cursoCB.getSelectedItem()+" e aluno " +alunoCB.getSelectedItem() + "?", "Excluir",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					 
					 modelo.Matricula mat = new modelo.Matricula(aluno, curso);
					 dao.remove(mat);
					 
				 }else {
					 JOptionPane.showMessageDialog(null, "Não pode excluir! Matrícula de aluno "+alunoCB.getSelectedItem()+" e curso "+cursoCB.getSelectedItem()+" não existe no banco de dados.");
				 }
				
					

			}
		});
	}

	
	private void populaComboBoxAluno() {

		List<Aluno> alunos = new ArrayList<Aluno>();

		AlunoDAO alunoDao = new AlunoDAO(ConnectionPool.getConexao());
		alunos = alunoDao.buscaAlunos();

		for (Aluno aluno : alunos) {
			alunoCB.addItem(aluno);
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
		Aluno aluno = (Aluno) alunoCB.getSelectedItem();
		
		
		CursoDAO dao = new CursoDAO(ConnectionPool.getConexao());
		List<Curso> cursos = dao.buscarNomeCursoPor(aluno);
		
		
		if(cursos.size() == 0) {
			JOptionPane.showMessageDialog(null, "O aluno  "+ alunoCB.getSelectedItem() +" não está matriculado em nenhum curso");
		}
		
		for (Curso curso : cursos) {
			
			modelo.addRow(new Object[] {
					curso,
			});
		}

	}

	
}
