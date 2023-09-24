package quizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener {
	//now for Qustion and answer we create one array with row column
	String questions[][]=new String[10][5];//we have define how many rows and column requied otherwise it gives error
	//10for 10q are present and 5 for 5 column as 1 line for q and 4 options
	String answers[][]=new String[10][2];
	String useranswers[][]=new String[10][1];
	
	JLabel qno,question;
	JButton lifeline,next,submit;
	ButtonGroup groupOption;
	JRadioButton opt1,opt2,opt3,opt4;
	public static int timer=15;
	public static int ans_given=0;
	public static int count=0;
	public static int score=0;
	String name;

	Quiz(String name){
		this.name=name;
		setLayout(null);
		//setSize(800,600);//or we cn use setBounds
		//setLocation(350,100);
		setBounds(50,0,1440,830);
		getContentPane().setBackground(Color.white);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));//for adding image we create obj and apply in add() funct //but we cant add it directly so we created JLabels obj & added that JLabels obj in add funct.
		JLabel image=new JLabel(i1);
		image.setBounds(0,0,1400,392);//manually positioning
		add(image);
		
		qno=new JLabel("");
		qno.setBounds(100,450,50,30);
		qno.setFont(new Font("tahoma",Font.PLAIN,24));
		add(qno);
		
		question=new JLabel("");
		question.setBounds(150,450,950,30);
		question.setFont(new Font("tahoma",Font.PLAIN,24));
		add(question);
		
		questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
	//////ANSWERSSS===========        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        opt1=new JRadioButton("");
        opt1.setBounds(170,520,700,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("dialog",Font.PLAIN,20));
        add(opt1);
        
        opt2=new JRadioButton("");
        opt2.setBounds(170,570,700,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3=new JRadioButton("");
        opt3.setBounds(170,620,700,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("dialog",Font.PLAIN,20));
        add(opt3);
        
        opt4=new JRadioButton("");
        opt4.setBounds(170,670,700,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("dialog",Font.PLAIN,20));
        add(opt4);
        
        groupOption=new ButtonGroup();//we formed group coz defaultly we can select 4 option but we can at a 1 on time ..so if select one option and then other option then firstly selected option will removed.
        groupOption.add(opt1);
        groupOption.add(opt2);
        groupOption.add(opt3);
        groupOption.add(opt4);
		
        next =new JButton("Next");
        next.setBounds(950,550,150,40);
        next.setBackground(new Color(80,183,235));//(51,230,255);
        next.setForeground(Color.black);
        next.setFont(new Font("tahoma",Font.PLAIN,22));
        next.addActionListener(this);
        add(next);
        
        lifeline =new JButton("LifeLine");
        lifeline.setBounds(950,600,150,40);
        lifeline.setBackground(new Color(80,183,235));//(51,230,255);
        lifeline.setForeground(Color.black);
        lifeline.setFont(new Font("tahoma",Font.PLAIN,22));
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit =new JButton("Submit");
        submit.setBounds(950,650,150,40);
        submit.setBackground(new Color(80,183,235));//(51,230,255);
        submit.setForeground(Color.black);
        submit.setFont(new Font("tahoma",Font.PLAIN,22));
        submit.setEnabled(false);//we do this coz at the we use submit button not in bitween 
        submit.addActionListener(this);
        add(submit);
        
        start(count);// for printing options and Que sequencily
        
		setVisible(true);
		
	}
	
	 public void actionPerformed(ActionEvent ae) //this code perform when manually button is clicked
	 { 
			  if(ae.getSource()==next) {
				  repaint();
				  
				  //we get error ki opt set disabled after clicking next button for enabling this we use for 4lines code
				  opt1.setEnabled(true);//we apply this coz after lifeline we got fresh option which is no any option is disabled
					opt2.setEnabled(true);
					opt3.setEnabled(true);
					opt4.setEnabled(true);
				  
				  ans_given=1;// if not applicable then 15 sec will not give for every Question.
				  if(groupOption.getSelection()==null) {
			  useranswers[count][0]="";
			  }else {
			  useranswers[count][0]=groupOption.getSelection().getActionCommand();
			  }
				  
				  if(count==8) {//so at 10 th Question submit button will appear and next will disappear
					  next.setEnabled(false);
					  submit.setEnabled(true);
				  }
			 
			  count++;
			  start(count); 
			  }else if(ae.getSource()==lifeline) {
				  if(count==2||count==4||count==6||count==8||count==9) {//but after applying this it continuely disabled the opt1,opt4 ..so in PAINT method and apply setEnabled (true) 
					  opt2.setEnabled(false);
					  opt3.setEnabled(false);
				  }else {
					  opt1.setEnabled(false);
					  opt4.setEnabled(false);
				  }
				  lifeline.setEnabled(false);
			  }else if(ae.getSource()==submit) {//when submit buttin clicked then this code execute
				 ans_given=1;
				  if(groupOption.getSelection()==null) {
						useranswers[count][0]="";
					}else {
						useranswers[count][0]=groupOption.getSelection().getActionCommand();
					}
				 
				 for(int i=0;i<useranswers.length;i++) {//for calculating score
					 if(useranswers[i][0].equals(answers[i][1])) {//checking stroed ans and given ans is equal or not
						 score+=10;//each correct ans is +10
					 }else {
						 score+=0;//for wrong answer
					 }
				 }
				 setVisible(false);//then open next frame
				 new Score(name,score);
			  }
			 
		 
		 //setVisible(false);
	 }
		
		public void paint(Graphics g) {//here we used Graphics method paint so we can display TIMER 
			super.paint(g);//no need to call paint method calls automatically
			String time="Time Left-"+timer+" seconds";//this is graphics
			g.setColor(Color.red);
			g.setFont(new Font("tahoma",Font.BOLD,22));
			if(timer>0) {
				g.drawString(time,1100,500);//time, width, width
			} else {
				g.drawString("Times Out!!",1100,500);
			}
			timer--;//decreases time for that we has to call **repaint() by using multithreading
			
			try {
				Thread.sleep(1000);//time in miliseconds so 1 sec =1000 milisec
				repaint();//it continuly dceses times otherwiae stops at 14sec ButtonGroup groupOption
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			if(ans_given==1) {
				ans_given=0;
				timer=15;
			}else if(timer<0) {
				timer=15;
				
				opt1.setEnabled(true);//we apply this coz after lifeline we got fresh option which is no any option is disabled
				opt2.setEnabled(true);
				opt3.setEnabled(true);
				opt4.setEnabled(true);
				
				 if(count==8) {//so at 10 th Question submit button will appear and next will disappear
					  next.setEnabled(false);
					  submit.setEnabled(true);
				  }
				 
				 if(count==9) {//this code execute when time out and user didnt submitted then automatically it submit and for use of submit onClick method go to actionPerformed method
					 if(groupOption.getSelection()==null) {
							useranswers[count][0]="";
						}else {
							useranswers[count][0]=groupOption.getSelection().getActionCommand();
						}
					 
					 for(int i=0;i<useranswers.length;i++) {//for calculating score
						 if(useranswers[i][0].equals(answers[i][1])) {//checking stroed ans and given ans is equal or not
							 score+=10;//each correct ans is +10
						 }else {
							 score+=0;//for wrong answer
						 }
					 }
					 setVisible(false);
					 new Score(name,score);
				 }else {
					 if(groupOption.getSelection()==null) {
							useranswers[count][0]="";
						}else {
							useranswers[count][0]=groupOption.getSelection().getActionCommand();
						}
						count++;
						start(count);//but at next q shows same selection of option was previouly done we have make it blank option selected
				 }
			}
		}
		
		public void start(int count) {
			qno.setText(""+(count+1)+". ");//adding 1 so each time increament the count
			question.setText(questions[count][0]);//it starts from [0][0] columns
			opt1.setText(questions[count][1]);
			opt1.setActionCommand(questions[count][1]);
			opt2.setText(questions[count][2]);
			opt2.setActionCommand(questions[count][2]);
			opt3.setText(questions[count][3]);
			opt3.setActionCommand(questions[count][3]);
			opt4.setText(questions[count][4]);
			opt4.setActionCommand(questions[count][4]);
			groupOption.clearSelection();
			
		}
	
	public static void main(String []args) {
		new Quiz("user");
	}

}
