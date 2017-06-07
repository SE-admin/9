package To_do_list;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Class4 extends JFrame{// ������
	private static final long serialVersionUID = 1L;
	JTextArea jta;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JTextField jt1, jt2, jt3, jt4;
	JLabel jl1,jl2,jl3,jl4,jl5;
	HashMap<String, List> m = new HashMap<String, List>();
	
	class List{
	   String s1;
	   String s2;
	   String s3;
	   public List(String s1, String s2, String s3){
	      this.s1 = s1;
	      this.s2 = s2;
	      this.s3 = s3;
	   }
	}
	
	Class4(){
	   setTitle("To Do List");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setLayout(null);
	      
	   MyActionListener listener = new MyActionListener ();
	   JPanel jp1 = new JPanel();
	   jp1.setLayout(new GridLayout(1,4));
	   jb1 = new JButton("ToDo�Է�");
	   jb2 = new JButton("�˻�");
	   jb3 = new JButton("����");
	   jb4 = new JButton("����");
	   jb1.addActionListener(listener);
	   jb2.addActionListener(listener);
	   jb3.addActionListener(listener);
	   jb4.addActionListener(listener);
	   jp1.add(jb1);
	   jp1.add(jb2);
	   jp1.add(jb3);
	   jp1.add(jb4);
	   jp1.setLocation(510,10);
	   jp1.setSize(360,30);
	   jb5 = new JButton("���ư���");
	   jb5.addActionListener(listener);
	   jb5.setSize(90, 30);
	   jb5.setLocation(780, 260);
	   add(jb5);
	      
	   JPanel jp2 = new JPanel();
	   jp2.setLayout(new GridLayout(4,1));
	   jl1 = new JLabel("���� ��");
	   jl2 = new JLabel("��� ����");
	   jl3 = new JLabel("���� ����/�ð�");
	   jl4 = new JLabel("���� �⵵/�б�");
	   jp2.add(jl1);
	   jp2.add(jl2);
	   jp2.add(jl3);
	   jp2.add(jl4);
	   jp2.setLocation(460,90);
	   jp2.setSize(90,120);
	      
	   JPanel jp3 = new JPanel();
	   jp3.setLayout(new GridLayout(4,1));
	   jt1 = new JTextField();
	   jt2 = new JTextField();
	   jt3 = new JTextField();
	   jt4 = new JTextField();
	   jp3.setLocation(550,90);
	   jp3.setSize(320,120);
	   jp3.add(jt1);
	   jp3.add(jt2);
	   jp3.add(jt3);
	   jp3.add(jt4);
	   
	   JPanel jp4 = new JPanel(); // �Է����� ����
	   jp4.setLayout(new GridLayout(1,1));
	   jl5 = new JLabel("���� ��,��� ����,���� ����/�ð�,���� �⵵/�б� �ʼ��Է�");
	   jp4.add(jl5);
	   jp4.setLocation(10,270);
	   jp4.setSize(390,15);
	   
	   jta = new JTextArea();
	   JScrollPane js = new JScrollPane(jta);
	   js.setLocation(10,10);
	   js.setSize(430,250);
	      
	   add(js);
	   add(jp1);
	   add(jp2);
	   add(jp3);
	   add(jp4);
	   setSize(900,360);
	   setVisible(true);
	}
	
	class MyActionListener implements ActionListener{ 
	   public void actionPerformed(ActionEvent e){ 
	      JButton b = (JButton)e.getSource();
	      if(b.getText().equals("�˻�")){
	    	 try{
		    	Scanner scan = new Scanner(new File("subject.txt"));
		    	while(scan.hasNextLine()) { 
		    		String str = scan.nextLine();
		    		String[] strArray = str.split(" ");
					m.put(strArray[0], new List(strArray[2],strArray[3],strArray[4]));
		    	}
				scan.close();
		     }catch(IOException e1){
		   	    System.out.println("����� ����");
		     }
	         if(m.containsKey(jt1.getText())){
	        	List personx = m.get(jt1.getText());
	            jta.append(jt1.getText()+" - "+personx.s1 + " " + personx.s2+" "+personx.s3+"\n"); 
	         }
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	         jt4.setText("");
	      }
	      else if(b.getText().equals("����")){ // ���� ����(������� ���� ������ �ٸ��� ����)
	    	  try{
		    	  Scanner scan = new Scanner(new File("subject.txt"));
		    	  while(scan.hasNextLine()) { 
		    		  String str = scan.nextLine();
		    		  String[] strArray = str.split(" ");
					  m.put(strArray[0], new List(strArray[2],strArray[3],strArray[4]));
		    	  }
				  scan.close();
		      }catch(IOException e1){
		    	  System.out.println("����� ����");
		      }
	    	  m.put(jt1.getText(), new List(jt2.getText(),jt3.getText(), jt4.getText()));
		         jt1.setText("");
		         jt2.setText("");
		         jt3.setText("");
		         jt4.setText("");
	    	  try{
	    		  File f = new File("subject.txt");
	    		  FileWriter fw = new FileWriter(f);
	    		  PrintWriter pw = new PrintWriter(fw);
	    		  Set<String> names = m.keySet();
			      Vector<String>v = new Vector<String>();
			      v.addAll(names); 
			      Collections.sort(v);
			      Iterator<String> it = v.iterator();
			      while(it.hasNext()) {
			         String name = it.next();
			         List person = m.get(name);
			         pw.println(name + " - " + person.s1 + " " + person.s2+ " "+person.s3);
			      }
	    		  pw.close();
	    	  }catch(IOException e1){
	    		  System.out.println("����� ����");
	    	  }
	      }
	      else if(b.getText().equals("����")){
	    	 try{
		    	Scanner scan = new Scanner(new File("subject.txt"));
		    	while(scan.hasNextLine()) { 
		    		String str = scan.nextLine();
		    		String[] strArray = str.split(" ");
					m.put(strArray[0], new List(strArray[2],strArray[3],strArray[4]));
		    	}
			 	scan.close();
		     }catch(IOException e1){
		     	System.out.println("����� ����");
		     }
	         if(m.containsKey(jt1.getText()))
	            m.remove(jt1.getText());
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	         jt4.setText("");
	      }
	      else if(b.getText().equals("���ư���")){
	    	  setVisible(false);
	    	  new Class1();
	      }
	      else if(b.getText().equals("ToDo�Է�")){
	    	  setVisible(false);
	    	  new Class2();
	      }
	      
	   }

	}
}
