package quizApplication;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {//extends jframe for page //implements actionlistnere coz we have use onclick event on button 
	
	JButton rules,back;
	JTextField tfname;
	Login(){//constructor for login frame
		
		getContentPane().setBackground(Color.white);// color prop in awt 
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));//for adding image we create obj and apply in add() funct //but we cant add it directly so we created JLabels obj & added that JLabels obj in add funct.
		JLabel image=new JLabel(i1);
		image.setBounds(0,0,600,500);//manually positioning
		add(image);
		
		JLabel heading=new JLabel("Simple Minds!");
		heading.setBounds(750,60,300,45);//default gives small fonts so change by using font family
		heading.setFont(new Font("viner Hand ITC",Font.BOLD,40));
		heading.setForeground(new Color(30,144,254));//set color in rgb
		add(heading);
		
		JLabel name=new JLabel("Enter your name");
		name.setBounds(800,120,180,65);//default gives small fonts so change by using font family
		name.setFont(new Font("mongolian Baiti",Font.BOLD,20));
		name.setForeground(new Color(204,0,102));//set color in rgb
		add(name);
		
		tfname=new JTextField();
		tfname.setBounds(725,200, 300,25);//without setbounds we cant place textbox on frame //725,200,300,25
		tfname.setFont(new Font("Times NEw Roman",Font.BOLD,20));//arial,high tower ,amaze,Comic sans,Magneto
		add(tfname);
		
		rules=new JButton("Rules");//button 1
		rules.setBounds(750, 300, 100, 25);
		rules.setBackground(new Color(0,102,0));
		rules.setForeground(Color.WHITE);
		rules.addActionListener(this);
		add(rules);
		
		 back=new JButton("Back");//button 2
		back.setBounds(900, 300, 100, 25);
		back.setBackground(new Color(0,102,0));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setLocation(200,150);//by default top left loc (left,top)
		setSize(1100,500);//by default small size (length,width)
		setVisible(true);//by default visibility hidden so we set it to true for visibility
		//created image 1
	}
	public void actionPerformed(ActionEvent ae) {
		//we added this coz if removed then at Start Login class gets erros bcoz in this implemented actionListnere this Actionperformed has one unplemented methos so we override this method here.
		if(ae.getSource()==rules) {
			String name=tfname.getText();
			setVisible(false);
			new Rules(name);
		}else if(ae.getSource()==back) {
			setVisible(false);
		}
	}
	
	public static void main(String args[]) {//create main method coz jvm finds this and execute the code 
		new Login();//created object
	}

}
