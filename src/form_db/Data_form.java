import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;

public class Data_form 
{
	public String d,t;
	JFrame sf,f,f1,f2;
Data_form()throws Exception
{
	Scanner in = new Scanner(System.in);
	String d = "student";
	String t="records";
	String url = "jdbc:mysql://localhost:3306/";
	url = url.concat(d);
 	String uname = "root";
 	String passi = "admin";
 	Connection con = DriverManager.getConnection(url,uname,passi); 
 	Statement st = con.createStatement();
	
	sf=new JFrame();
	f=new JFrame();
	f1=new JFrame();
	f2=new JFrame();
	
	JButton a1 = new JButton("Sign up");
	a1.setBounds(70,50,100,40);
	JButton a2 = new JButton("Sign in");
	a2.setBounds(190,50,100,40);
	sf.add(a1); sf.add(a2);
	sf.setLayout(null);
	sf.setSize(400,200);
	sf.setVisible(true);
	sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	registration(a1,f,sf,st,t,d);
	credential_check(a2,f1,sf,d,t);
		    	
	in.close();
}

public void credential_check(JButton a2, JFrame f1,JFrame sf, String d, String t) {
	a2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    	sf.dispose();
		JLabel q21 = new JLabel("Student ID ");
		q21.setBounds(20,50,80,40);
		JTextField q221 = new JTextField("");
		q221.setBounds(150,55,180,20);
		JLabel q31 = new JLabel("Password: ");
		q31.setBounds(20,80,120,40);
		JTextField q331 = new JTextField("");
		q331.setBounds(150,85,180,20);
		JButton b11 = new JButton("Sign In");
		b11.setBounds(120,150,80,40);
        b11.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String id=q221.getText();
        String pass=q331.getText();
        try {
		if(id.equals(data_check("Student_ID",t,id,d)) && pass.equals(data_check("Password",t,pass,d))) {
			Score(f2,d,t);
			JOptionPane.showMessageDialog(null,"Welcome");
		f1.dispose();
		}
		else
			JOptionPane.showMessageDialog(null,"Invalid Username Or Password");
		f1.dispose();
		 } 
		catch (HeadlessException e1) {e1.printStackTrace();}
	    catch (Exception e1) {e1.printStackTrace();
	    }}});
		f1.add(q21);   f1.add(q221);
		f1.add(q31);   f1.add(q331);
		f1.add(b11);   
		f1.setLayout(null);
		f1.setSize(400,300);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }});
}

public void Score(JFrame f2,String d,String t){
	
	ArrayList<String> id=new ArrayList<>();
	ArrayList<String> name=new ArrayList<>();
	ArrayList<Integer> Math=new ArrayList<>();
	ArrayList<Integer> Sci=new ArrayList<>();
	ArrayList<Integer> Eng=new ArrayList<>();
	ArrayList<Integer> Comp=new ArrayList<>();
	ArrayList<Integer> Hindi=new ArrayList<>();	
	int x=0;
	String url = "jdbc:mysql://localhost:3306/";
	url = url.concat(d);
 	String uname = "root";
 	String pass = "admin";
 	Connection con;
	try {
	con = DriverManager.getConnection(url,uname,pass); 
 	Statement st = con.createStatement();
 	ResultSet n = st.executeQuery("select count(*) from "+t+";");
 	n.next();
 	x=Integer.parseInt(n.getString("count(*)"));
	ResultSet z = st.executeQuery("select Student_Id,Name, Mathematics,Science,English,Computer_Science,Hindi from "+t+";");
	
	while(z.next())
	{
		
	id.add(z.getString("Student_Id"));
	name.add(z.getString("Name"));
	Math.add(Integer.parseInt(z.getString("Mathematics")));
	Sci.add(Integer.parseInt(z.getString("Science")));
	Eng.add(Integer.parseInt(z.getString("English")));
	Comp.add(Integer.parseInt(z.getString("Computer_Science")));
	Hindi.add(Integer.parseInt(z.getString("Hindi")));
		
}} catch (SQLException e) {
	e.printStackTrace();
}
	
 String[][] b=new String[x][7];
	
	for(int i=0;i<x;i++)
	{
		 	b[i][0]=""+id.get(i);
			b[i][1]=""+name.get(i);
			b[i][2]=""+Math.get(i);
			b[i][3]=""+Sci.get(i);
			b[i][4]=""+Eng.get(i);
			b[i][5]=""+Comp.get(i);
			b[i][6]=""+Hindi.get(i);
		
	}
	
	String[] tt= {"Student_Id","Name","Mathematics","Science","English","Computer_Science","Hindi"};
	
	 JTable result = new JTable(b,tt);
	  JScrollPane p2 = new JScrollPane(result);
	  p2.setPreferredSize(new Dimension(900,300));
	  
	  JPanel tablePanel = new JPanel();
	  tablePanel.add(p2);
	  
	f2.add(tablePanel);
	f2.setSize(920,350);
	f2.setVisible(true);
	f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public String data_check(String x,String y,String p,String d)throws Exception
{	
	String url = "jdbc:mysql://localhost:3306/";
	url = url.concat(d);
 	String uname = "root";
 	String pass = "admin";
 	Connection con = DriverManager.getConnection(url,uname,pass); 
 	Statement st = con.createStatement();
	ResultSet z = st.executeQuery("select "+x+" from "+y+";");
	while(z.next())
	{
		
		String l = z.getString(x);
		if(l.equals(p))
			return l;
	}
	return "";
}

public void registration(JButton a1, JFrame f,JFrame sf, Statement st,String t,String d) {
	a1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		sf.dispose();
		JLabel rf = new JLabel("REGISTRATION FORM");
		rf.setForeground(Color.BLUE);
		rf.setBounds(60,5,150,40);
		JLabel q1 = new JLabel("Name: ");
		q1.setBounds(20,50,80,40);
		JTextField q11 = new JTextField("");
		q11.setBounds(180,55,180,20);
		JLabel q2 = new JLabel("Student ID: ");
		q2.setBounds(20,80,80,40);
		JTextField q22 = new JTextField("");
		q22.setBounds(180,85,180,20);
		JLabel q3 = new JLabel("Location: ");
		q3.setBounds(20,110,120,40);
		JTextField q33 = new JTextField("");
		q33.setBounds(180,115,180,20);
		JLabel q4 = new JLabel("Mathematics: ");
		q4.setBounds(20,140,120,40);
		JTextField q44 = new JTextField("");
		q44.setBounds(180,145,180,20);
		JLabel q5 = new JLabel("Science: ");
		q5.setBounds(20,170,80,40);
		JTextField q55 = new JTextField("");
		q55.setBounds(180,175,180,20);
		JLabel q6 = new JLabel("English: ");
		q6.setBounds(20,200,80,40);
		JTextField q66 = new JTextField("");
		q66.setBounds(180,205,180,20);
		JLabel q7 = new JLabel("Computer Science: ");
		q7.setBounds(20,230,120,40);
		JTextField q77 = new JTextField("");
		q77.setBounds(180,235,180,20);
		JLabel q8 = new JLabel("Hindi: ");
		q8.setBounds(20,260,80,40);
		JTextField q88 = new JTextField("");
		q88.setBounds(180,265,180,20);
		JLabel q9 = new JLabel("Password: ");
		q9.setBounds(20,290,80,40);
		JTextField q99 = new JTextField("");
		q99.setBounds(180,295,180,20);
		JButton b1 = new JButton("Submit");
		b1.setBounds(40,360,80,40);
		b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		String nm=q11.getText();
		String id=q22.getText();
		String loc=q33.getText();
		int math=Integer.parseInt(q44.getText());
		int sci=Integer.parseInt(q55.getText());
		int Eng=Integer.parseInt(q66.getText());
		int comp=Integer.parseInt(q77.getText());
		int hindi=Integer.parseInt(q88.getText());
		String pass=q99.getText();
		
try {
	if(id.equals(data_check("Student_ID",t,id,d))) {
		
		JOptionPane.showMessageDialog(null,"Already Registered");
	}
	else
	{
			st.executeUpdate("insert into records values('"+id+"','"+nm+"','"+loc+"','"+math+"','"+sci+"','"+Eng+"','"+comp+"','"+hindi+"','"+pass+"');");
			f.dispose();
		JOptionPane.showMessageDialog(null,"Data Saved Successfully");
    } 
}
  catch (Exception e1) {e1.printStackTrace();}
}});
		f.add(rf);
		f.add(q1);   f.add(q11);
		f.add(q2);   f.add(q22);
		f.add(q3);   f.add(q33);
		f.add(q4);   f.add(q44);
		f.add(q5);   f.add(q55);
		f.add(q6);   f.add(q66);
		f.add(q7);   f.add(q77);
		f.add(q8);   f.add(q88);
		f.add(q9);   f.add(q99);
		
f.add(b1);   
f.setLayout(null);
f.setSize(600,500);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}});
}

public static void main(String[] args)throws Exception
{
        new Data_form();       
}}
