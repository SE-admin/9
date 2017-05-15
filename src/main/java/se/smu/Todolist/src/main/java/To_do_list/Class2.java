package To_do_list;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Class2 extends JFrame{
	JTextArea jta;
	JButton jb1, jb2, jb3, jb4, jb5;
	JTextField jt1, jt2, jt3, jt4;
	JLabel jl1,jl2,jl3,jl4;
	HashMap<String, List> m = new HashMap<String, List>();
	
	class List{
	   String s1;
	   String s2;
	   public List(String s1, String s2){
	      this.s1 = s1;
	      this.s2 = s2;
	   }
	}
	
	Class2(){
	   setTitle("To Do List");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setLayout(null);
	      
	   MyActionListener listener = new MyActionListener ();
	   JPanel jp1 = new JPanel();
	   jp1.setLayout(new GridLayout(1,3));
	   jb1 = new JButton("검색");
	   jb2 = new JButton("삽입");
	   jb3 = new JButton("삭제");
	   jb1.addActionListener(listener);
	   jb2.addActionListener(listener);
	   jb3.addActionListener(listener);
	   jp1.add(jb1);
	   jp1.add(jb2);
	   jp1.add(jb3);
	   jp1.setLocation(530,20);
	   jp1.setSize(330,30);
	   jb4 = new JButton("중 요");
	   jb4.addActionListener(listener);
	   jb4.setSize(70, 20);
	   jb4.setLocation(460, 230);
	   add(jb4);
	   jb5 = new JButton("돌아가기");
	   jb5.addActionListener(listener);
	   jb5.setSize(90, 30);
	   jb5.setLocation(770, 230);
	   add(jb5);
	      
	   JPanel jp2 = new JPanel();
	   jp2.setLayout(new GridLayout(4,1));
	   jl1 = new JLabel("할 일 명");
	   jl2 = new JLabel("과목 명");
	   jl3 = new JLabel("담당 교수");
	   jl4 = new JLabel("상세 내용");
	   jp2.add(jl1);
	   jp2.add(jl2);
	   jp2.add(jl3);
	   jp2.add(jl4);
	   jp2.setLocation(460,90);
	   jp2.setSize(80,120);
	      
	   JPanel jp3 = new JPanel();
	   jp3.setLayout(new GridLayout(4,1));
	   jt1 = new JTextField();
	   jt2 = new JTextField();
	   jt3 = new JTextField();
	   jt4 = new JTextField();
	   jp3.setLocation(540,90);
	   jp3.setSize(320,120);
	   jp3.add(jt1);
	   jp3.add(jt2);
	   jp3.add(jt3);
	   jp3.add(jt4);
	      
	   jta = new JTextArea();
	   JScrollPane js = new JScrollPane(jta);
	   js.setLocation(10,10);
	   js.setSize(430,250);
	      
	   add(js);
	   add(jp1);
	   add(jp2);
	   add(jp3);
	   setSize(900,350);
	   setVisible(true);
	}
	   
	class MyActionListener implements ActionListener{ 
	   public void actionPerformed(ActionEvent e){ 
	      JButton b = (JButton)e.getSource();
	      if(b.getText().equals("조회")){
	         Set<String> names = m.keySet();
	         Vector<String>v = new Vector<String>();
	         v.addAll(names); 
	         Collections.sort(v);
	         Iterator<String> it = v.iterator();
	         while(it.hasNext()) {
	            String name = it.next();
	            List person = m.get(name);
	            jta.append(name + " : " + person.s1 + " " + person.s2+"\n");
	         }
	      }
	      else if(b.getText().equals("검색")){
	         if(m.containsKey(jt1.getText())){
	        	List personx = m.get(jt1.getText());
	            jta.append(jt1.getText()+" : "+personx.s1 + " " + personx.s2+"\n"); 
	         }
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	      }
	      else if(b.getText().equals("삽입")){
	         m.put(jt1.getText(), new List(jt2.getText(),jt3.getText()));
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	      }
	      else if(b.getText().equals("삭제")){
	         if(m.containsKey(jt1.getText()))
	            m.remove(jt1.getText());
	         jt1.setText("");
	         jt2.setText("");
	         jt3.setText("");
	      }
	      else if(b.getText().equals("돌아가기")){
	    	  setVisible(false);
	    	  new Class1();
	      }
	   }
	}
}
