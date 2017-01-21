import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
	
   public static void main(String[] args) 
   {
	   
	   JFrame frame = new JFrame("Counter");
	   JLabel mainLabel = new JLabel("10");
	   JFrame inputFrame = new JFrame("Counter Settings");
	   JPanel inputPanel = new JPanel();
	   JTextField tallyNum = new JTextField(3);
	   JButton startButton = new JButton("Start");
	   
	   inputFrame.setSize(150, 90);
	   
	   Action startCounter = new AbstractAction()
	   {
	       @Override
	       public void actionPerformed(ActionEvent e)
	       {
	        	  if (isNumeric(tallyNum.getText())) {
		        	  mainLabel.setText(tallyNum.getText());
		        	  resizeFrame(mainLabel, frame);
		              frame.setVisible(true);
		              inputFrame.setVisible(false);
	        	  }
	       }
	   };

	   
	   tallyNum.addActionListener(startCounter);
	   startButton.addActionListener(startCounter);
	   inputPanel.add(tallyNum);
	   inputPanel.add(startButton);
	   inputFrame.add(inputPanel);
	   inputFrame.setVisible(true);
	   
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setSize(48, 48);
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); 	// Frame size and location
      int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
      frame.setLocation(x, 0);
      
      frame.setUndecorated(true); 	// No minimize/maximize/close
      frame.setAlwaysOnTop(true);
      frame.setType(javax.swing.JFrame.Type.UTILITY); 	// No taskbar icon
      

      resizeFrame(mainLabel, frame);
      
      mainLabel.addMouseListener(new MouseAdapter()
      {
          public void mouseReleased(MouseEvent e)
          {
        	  
      		if(e.getButton() == MouseEvent.BUTTON1)
    	    {
      			
      			int curTally = Integer.parseInt(mainLabel.getText());
      			curTally++;
      			
      			mainLabel.setText(String.valueOf(curTally));
    	    }	    
      		
      		else if(e.getButton() == MouseEvent.BUTTON2)
    	    {
      			System.exit(0);
    	    }
      		
    	    else if(e.getButton() == MouseEvent.BUTTON3)
    	    {
      			int curTally = Integer.parseInt(mainLabel.getText());
      			curTally--;
      			
      			mainLabel.setText(String.valueOf(curTally));
    	    }
      		resizeFrame(mainLabel, frame);
          }
      });
      resizeFrame(mainLabel, frame);
      frame.add(mainLabel);
   }
   
   public static void resizeFrame(JLabel label, JFrame frame) {
	   
	   String curTally = label.getText();
	   int length = (curTally.length() * 22);
	   
	   if (curTally.length() == 1)
	   {label.setFont(new Font("Arial", Font.BOLD, 28)); 
	   length = 32; }
	   
	   
	   frame.setSize(length, length);
	   
	   label.setFont(new Font("Arial", Font.BOLD, 40));
	   
   }
   
   public static boolean isNumeric(String str)  
   {  
     try  
     {  
       int digit = Integer.parseInt(str);  
     }  
     catch(NumberFormatException nfe)  
     {  
       return false;  
     }  
     return true;  
   }
  
}
