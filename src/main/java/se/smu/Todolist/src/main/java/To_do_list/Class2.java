package To_do_list;

import javax.swing.*;

import To_do_list.Class4.List;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.util.*;

public class Class2 extends JFrame{ //등록
	int important=0,tag_hard=0,tag_long=0,tag_team=0;
	JTextArea jta;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
	JTextField jt1, jt2, jt3, jt4, jt5;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	HashMap<String, List> o = new HashMap<String, List>();
	
	class List{
	   String n1;
	   String n2;
	   String n3;
	   String n4;
	   String n5;
	   String n6;
	   String n7;
	   String n8;
	   public List(String n1, String n2, String n3, String n4, String n5, String n6, String n7, String n8){
	      this.n1 = n1;
	      this.n2 = n2;
	      this.n3 = n3;
	      this.n4 = n4;
	      this.n5 = n5;
	      this.n6 = n6;
	      this.n7 = n7;
	      this.n8 = n8;
	   }
	}
	
	Class2(){
	   setTitle("To Do List");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setLayout(null);
	      
	   MyActionListener listener = new MyActionListener ();
	   JPanel jp1 = new JPanel();
	   jp1.setLayout(new GridLayout(1,4));
	   jb1 = new JButton("과목입력");
	   jb2 = new JButton("검색");
	   jb3 = new JButton("삽입");
	   jb4 = new JButton("삭제");
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
	   jb5 = new JButton("중 요");
	   jb5.addActionListener(listener);
	   jb5.setSize(70, 20);
	   jb5.setLocation(460, 230);
	   add(jb5);
	   jb6 = new JButton("돌아가기");
	   jb6.addActionListener(listener);
	   jb6.setSize(90, 30);
	   jb6.setLocation(780, 260);
	   add(jb6);
	      
	   JPanel jp2 = new JPanel();
	   jp2.setLayout(new GridLayout(5,1));
	   jl1 = new JLabel("Todo항목 명");
	   jl2 = new JLabel("과목 명");
	   jl3 = new JLabel("마감 기한");
	   jl4 = new JLabel("실제 마감일");
	   jl5 = new JLabel("완료or미완");
	   jp2.add(jl1);
	   jp2.add(jl2);
	   jp2.add(jl3);
	   jp2.add(jl4);
	   jp2.add(jl5);
	   jp2.setLocation(460,60);
	   jp2.setSize(80,150);
	      
	   JPanel jp3 = new JPanel();
	   jp3.setLayout(new GridLayout(5,1));
	   jt1 = new JTextField();
	   jt2 = new JTextField();
	   jt3 = new JTextField();
	   jt4 = new JTextField();
	   jt5 = new JTextField();
	   jp3.setLocation(550,60);
	   jp3.setSize(320,150);
	   jp3.add(jt1);
	   jp3.add(jt2);
	   jp3.add(jt3);
	   jp3.add(jt4);
	   jp3.add(jt5);
	   
	   JPanel jp4 = new JPanel();
	   jp4.setLayout(new GridLayout(1,3));
	   jb7 = new JButton("힘듬");
	   jb8 = new JButton("오래걸림");
	   jb9 = new JButton("팀플");
	   jb7.addActionListener(listener);
	   jb8.addActionListener(listener);
	   jb9.addActionListener(listener);
	   jp4.add(jb7);
	   jp4.add(jb8);
	   jp4.add(jb9);
	   jp4.setLocation(460,270);
	   jp4.setSize(270,20);
	   
	   JPanel jp5 = new JPanel();
	   jp5.setLayout(new GridLayout(2,1));
	   jl6 = new JLabel("마감기한, 실제마감일 입력 형식 : yyyymmdd");
	   jp5.add(jl6);
	   jp5.setLocation(10,270);
	   jp5.setSize(300,30);
	   
	   jta = new JTextArea();
	   JScrollPane js = new JScrollPane(jta);
	   js.setLocation(10,10);
	   js.setSize(430,250);
	      
	   add(js);
	   add(jp1);
	   add(jp2);
	   add(jp3);
	   add(jp4);
	   add(jp5);
	   setSize(900,330);
	   setVisible(true);
	}
	   
	class MyActionListener implements ActionListener{ 
	   public void actionPerformed(ActionEvent e){ 
	      JButton b = (JButton)e.getSource();
	      if(b.getText().equals("검색")){
	    	 Color prevColor = b.getBackground();
	    	 String importants = null, tag_hards = null, tag_longs = null, tag_teams = null;
		     jb5.setBackground(prevColor);
		     jb7.setBackground(prevColor);
		     jb8.setBackground(prevColor);
		     jb9.setBackground(prevColor);
		     important = 0;
	    	 tag_hard = 0;
	    	 tag_long = 0;
	    	 tag_team = 0;
	    	 try{
		    	 Scanner scan = new Scanner(new File("list.txt"));
		    	 while(scan.hasNextLine()) { 
		    		 String str = scan.nextLine();
		    		 String[] strArray = str.split(" ");
					    o.put(strArray[0], new List(strArray[2],strArray[3],strArray[4],strArray[5],strArray[6],strArray[7],strArray[8],strArray[9]));
		    	 }
				 scan.close();
		     }catch(IOException e1){
		    	 System.out.println("입출력 오류");
		     }
	         if(o.containsKey(jt1.getText())){
	        	List personx = o.get(jt1.getText());
	        	jta.append(jt1.getText()+" - "+personx.n1+" "+personx.n2+" "+personx.n3+" "+personx.n4+" ");
	        	if(personx.n5.equals("1")){
	        		importants="*";
	        		jta.append(importants+" ");
	        	}
	        	if(personx.n6.equals("1")){
	        		tag_hards="힘듬";
	        		jta.append(tag_hards+" "); 
	        	}
	        	if(personx.n7.equals("1")){
	        		tag_longs="오래걸림";
	        		jta.append(tag_longs+" "); 
	        	}
	        	if(personx.n8.equals("1")){
	        		tag_teams="팀플";
	        		jta.append(tag_teams); 
	        	}
	        	jta.append("\n");
	         }
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	         jt4.setText("");
	         jt5.setText("");
	      }
	      else if(b.getText().equals("삽입")){ //To do 항목 변경
	    	 Color prevColor = b.getBackground();
	    	 jb5.setBackground(prevColor);
	    	 jb7.setBackground(prevColor);
		     jb8.setBackground(prevColor);
		     jb9.setBackground(prevColor);
	    	 try{
	    		 Scanner scan = new Scanner(new File("list.txt"));
	    		 while(scan.hasNextLine()) { 
	    			 String str = scan.nextLine();
	    			 String[] strArray = str.split(" ");
				     o.put(strArray[0], new List(strArray[2],strArray[3],strArray[4],strArray[5],strArray[6],strArray[7],strArray[8],strArray[9]));
	    		 }
			     scan.close();
	    	 }catch(IOException e1){
	    		 System.out.println("입출력 오류");
	    	 }
	    	 o.put(jt1.getText(), new List(jt2.getText(),jt3.getText(),jt4.getText(),jt5.getText(),String.valueOf(important),String.valueOf(tag_hard),String.valueOf(tag_long),String.valueOf(tag_team)));
	    	 important = 0;
	    	 tag_hard = 0;
	    	 tag_long = 0;
	    	 tag_team = 0;
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	         jt4.setText("");
	         jt5.setText("");
	         try{
	    		  File f = new File("list.txt");
	    		  FileWriter fw = new FileWriter(f);
	    		  PrintWriter pw = new PrintWriter(fw);
	    		  Set<String> names = o.keySet();
			      Vector<String>v = new Vector<String>();
			      v.addAll(names); 
			      Collections.sort(v);
			      Iterator<String> it = v.iterator();
			      while(it.hasNext()) {
			         String name = it.next();
			         List person = o.get(name);
			         pw.println(name+" - "+person.n1+" "+person.n2+" "+person.n3+" "+person.n4+" "+person.n5+" "+person.n6+" "+person.n7+" "+person.n8);
			      }
	    		  pw.close();
	    	  }catch(IOException e1){
	    		  System.out.println("입출력 오류");
	    	  }
	      }
	      else if(b.getText().equals("삭제")){//To do 항목 삭제
	    	 Color prevColor = b.getBackground();
		     jb5.setBackground(prevColor);
		     jb7.setBackground(prevColor);
		     jb8.setBackground(prevColor);
		     jb9.setBackground(prevColor);
		     important = 0;
	    	 tag_hard = 0;
	    	 tag_long = 0;
	    	 tag_team = 0;
	    	 try{
			    Scanner scan = new Scanner(new File("list.txt"));
			    while(scan.hasNextLine()) { 
			    	String str = scan.nextLine();
			    	String[] strArray = str.split(" ");
						  o.put(strArray[0], new List(strArray[2],strArray[3],strArray[4],strArray[5],strArray[6],strArray[7],strArray[8],strArray[9]));
			    }
				scan.close();
			 }catch(IOException e1){
			    System.out.println("입출력 오류");
			 }
	         if(o.containsKey(jt1.getText()))
	            o.remove(jt1.getText());
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	         jt4.setText("");
	         jt5.setText("");
	         try{
	    		  File f = new File("list.txt");
	    		  FileWriter fw = new FileWriter(f);
	    		  PrintWriter pw = new PrintWriter(fw);
	    		  Set<String> names = o.keySet();
			      Vector<String>v = new Vector<String>();
			      v.addAll(names); 
			      Collections.sort(v);
			      Iterator<String> it = v.iterator();
			      while(it.hasNext()) {
			         String name = it.next();
			         List person = o.get(name);
			         pw.println(name+" - "+person.n1+" "+person.n2+" "+person.n3+" "+person.n4+" "+person.n5+" "+person.n6+" "+person.n7+" "+person.n8);
			      }
	    		  pw.close();
	    	 }catch(IOException e1){
	    		  System.out.println("입출력 오류");
	    	 }
	      }
	      else if(b.getText().equals("돌아가기")){
	    	  setVisible(false);
	    	  new Class1();
	      }
	      else if(b.getText().equals("과목입력")){
	    	  setVisible(false);
	    	  new Class4();
	      }
	      else if(b.getText().equals("중 요")){// 중요 여부를 등록
	    	  Color prevColor = jb1.getBackground();
	    	  if(important == 0){
	    		  important=1;  
	    		  b.setBackground(Color.YELLOW);
	    	  }
	    	  else if(important == 1){
	    		  important=0;
	    		  b.setBackground(prevColor);
	    	  }
	      }
	      else if(b.getText().equals("힘듬")){// 힘듬 여부를 등록
	    	  Color prevColor = jb1.getBackground();
	    	  if(tag_hard == 0){
	    		  tag_hard=1;  
	    		  b.setBackground(Color.YELLOW);
	    	  }
	    	  else if(tag_hard == 1){
	    		  tag_hard=0;
	    		  b.setBackground(prevColor);
	    	  }
	      }
	      else if(b.getText().equals("오래걸림")){// 오래걸림 여부를 등록
	    	  Color prevColor = jb1.getBackground();
	    	  if(tag_long == 0){
	    		  tag_long=1;  
	    		  b.setBackground(Color.YELLOW);
	    	  }
	    	  else if(tag_long == 1){
	    		  tag_long=0;
	    		  b.setBackground(prevColor);
	    	  }
	      }
	      else if(b.getText().equals("팀플")){// 팀플 여부를 등록
	    	  Color prevColor = jb1.getBackground();
	    	  if(tag_team == 0){
	    		  tag_team=1;  
	    		  b.setBackground(Color.YELLOW);
	    	  }
	    	  else if(tag_team == 1){
	    		  tag_team=0;
	    		  b.setBackground(prevColor);
	    	  }
	      }
	   }
	}
}
