package usuario;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Splash {
	
	 private final int largura = 480;
	 private final int altura = 300;
	 private final int tempo = 1000;
	 private final String gif = "/usuario/loading.gif";
	    
	 public Splash(){
		 
		 JWindow janelaSplash = new JWindow();
	        
	     janelaSplash.getContentPane().add(
	        new JLabel("", new ImageIcon(getClass().getResource(gif)),SwingConstants.CENTER));
	              
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        Dimension dimension = toolkit.getScreenSize();
	        
	        janelaSplash.setBounds((dimension.width - largura) / 2,(dimension.height - altura)/ 2,largura,altura);
	        
	        janelaSplash.setVisible(true);
	        
	        try
	        {
	            Thread.sleep(tempo);
	        }catch(InterruptedException e){}
	        
	        janelaSplash.dispose();
	        new Login();
	    	}   
}
