package quizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
	
	
	Score(String name,int score){
		 
		setBounds(400,150,750,550); 
		//setVisible(true);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));//for adding image we create obj and apply in add() funct //but we cant add it directly so we created JLabels obj & added that JLabels obj in add funct.
		Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,200,300,250);//manually positioning
		add(image);
		
		JLabel heading=new JLabel("ThankYou! "+name+" for playing Simple Minds ");
		heading.setBounds(45,30,700,30);
		heading.setFont(new Font("tahoma",Font.PLAIN,26));
		add(heading);
		
		JLabel lblscore=new JLabel("Your score is "+score);
		lblscore.setBounds(350,200,300,30);
		lblscore.setFont(new Font("tahoma",Font.PLAIN,26));
		add(lblscore);
		
		JButton back=new JButton("Play Again");//button 2
			back.setBounds(380, 270, 120, 30);
			back.setBackground(new Color(0,102,0));
			back.setForeground(Color.WHITE);
			back.addActionListener(this);
			add(back);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) {
		new Score("User",0);
	}

}
