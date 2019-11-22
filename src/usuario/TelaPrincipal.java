package usuario;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class TelaPrincipal  extends JFrame{

	private static final long serialVersionUID = 1L;
	private JMenu arquivo, ajuda,tabelas,spf;
	private JMenuItem sair, sobre,aluno,curso,professor,disciplina,grade,matricula,prof_disc;
	private JMenuBar menuBar;

public static void main(String[] args) {

		new Login();
}
	public TelaPrincipal() {
		super("Home");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(0, 51, 102));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		 menuBar = new JMenuBar();
	     setJMenuBar(menuBar);
	       
	        
	       arquivo = new JMenu("ARQUIVO");
	       arquivo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/page.png")));
	       arquivo.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       arquivo.setForeground(new Color(0, 51, 102));
	       ajuda = new JMenu("AJUDA");
	       ajuda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/help.png")));
	       ajuda.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       ajuda.setBackground(new Color(255, 255, 255));
	       ajuda.setForeground(new Color(0, 51, 102));
	       tabelas = new JMenu("TABELAS");
	       tabelas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/application_view_detail.png")));
	       tabelas.setBackground(new Color(255, 255, 255));
	       tabelas.setForeground(new Color(0, 51, 102));
	       tabelas.setFont(new Font("Nirmala UI", Font.BOLD, 10));	       
	      spf = new JMenu("SPF");
	      spf.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/layout.png")));
	      spf.setForeground(new Color(0, 51, 102));
	      spf.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	      spf.setBackground(Color.WHITE);
	       
	       menuBar.add(arquivo);
	       menuBar.add(tabelas);	  
	       menuBar.add(spf);
	       
	       grade = new JMenuItem("GRADE");
	       grade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/application_view_list.png")));
	       grade.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       grade.setForeground(new Color(0, 51, 102));
	       spf.add(grade);
	       
	          
	      matricula = new JMenuItem("MATRICULA ALUNO");
	      matricula.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/application_view_list.png")));
	      matricula.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	      matricula.setForeground(new Color(0, 51, 102));
	      spf.add(matricula);
	          
	      prof_disc = new JMenuItem("PROFESSOR DISCIPLINA");
	      prof_disc.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/application_view_list.png")));
	      prof_disc.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	      prof_disc.setForeground(new Color(0, 51, 102));
	      spf.add(prof_disc);
	      
	       menuBar.add(ajuda);
	       
	       sair   = new JMenuItem("SAIR");
	       sair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/cancel.png")));
	       sair.setBackground(Color.WHITE);
	       sair.setForeground(new Color(0, 51, 102));
	       sair.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       
	       sobre   = new JMenuItem("SOBRE");
	       sobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/information.png")));
	       sobre.setBackground(Color.WHITE);
	       sobre.setForeground(new Color(0, 51, 102));
	       sobre.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       
	       aluno   = new JMenuItem("ALUNO");
	       aluno.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/user.png")));
	       aluno.setBackground(Color.WHITE);
	       aluno.setForeground(new Color(0, 51, 102));
	       aluno.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       
	       professor  = new JMenuItem("PROFESSOR");
	       professor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/user_suit.png")));
	       professor.setBackground(Color.WHITE);
	       professor.setForeground(new Color(0, 51, 102));
	       professor.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       
	       disciplina = new JMenuItem("DISCIPLINA");
	       disciplina.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/layout_content.png")));
	       disciplina.setBackground(Color.WHITE);
	       disciplina.setForeground(new Color(0, 51, 102));
	       disciplina.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       
	       curso      = new JMenuItem("CURSO");
	       curso.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/layout_content.png")));
	       curso.setBackground(Color.WHITE);
	       curso.setForeground(new Color(0, 51, 102));
	       curso.setFont(new Font("Nirmala UI", Font.BOLD, 10));
	       
	       arquivo.add(sair);
	       ajuda.add(sobre);
	       tabelas.add(aluno);
	       tabelas.add(professor);
	       tabelas.add(disciplina);
	       tabelas.add(curso);
	       getContentPane().setLayout(null);
	       
	       matricula.addActionListener(new ActionListener() {
				
	 					@Override
	 					public void actionPerformed(ActionEvent e) {
	 						new Grade();
	 						
	 					}
	 				});
	       prof_disc.addActionListener(new ActionListener() {
				
	 					@Override
	 					public void actionPerformed(ActionEvent e) {
	 						new Grade();
	 						
	 					}
	 				});
		       grade.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Grade();
						
					}
				});
		       
	       aluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Aluno();
				
			}
		});
	       
	       professor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Professor();
				
			}
		});
	       
	       curso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Curso();
				
			}
		});
		     
	     
	       sobre.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	        	   JOptionPane.showMessageDialog(null, "Nome: Aplicativo para Prova de LP3\nVersão: 1.1\nAno: 2019\nAutor(a):Luana Alves");
	           }
	       });
	       
	       sair.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	              int resposta =  JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
	               
	               if(resposta == JOptionPane.YES_OPTION){
	                   dispose();
	               }
	           }
	       });
	  
	       
	   }
}

