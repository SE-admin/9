package To_do_list;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Class3 extends JFrame { //����
	TextArea jta;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8 ;
	JTextField  jt1;
	JLabel jl1, jl2, jl3 ;
	String fs;
	
	Class3() {
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		MyActionListener listener = new MyActionListener();
		JPanel jp1 = new JPanel();
	    jp1.setLayout(new GridLayout(1,4));
		jb1 = new JButton("��  ��");
		jb2 = new JButton("��  ��");
		jb3 = new JButton("��  ��");
		jb4 = new JButton("��  ��");
		jb1.addActionListener(listener);
		jb2.addActionListener(listener);
		jb3.addActionListener(listener);
		jb4.addActionListener(listener);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.setLocation(20,460);
		jp1.setSize(360,30);
		
		JPanel jp2 = new JPanel();
	    jp2.setLayout(new GridLayout(1,4));
		jb5 = new JButton("���� �̿�");
		jb6 = new JButton("���� �ϼ�");
		jb7 = new JButton("���� �̿�");
		jb8 = new JButton("���� �ϼ�");
		jb5.addActionListener(listener);
		jb6.addActionListener(listener);
		jb7.addActionListener(listener);
		jb8.addActionListener(listener);
		jp2.add(jb5);
		jp2.add(jb6);
		jp2.add(jb7);
		jp2.add(jb8);
		jp2.setLocation(20,10);
		jp2.setSize(360,30);
		
		jta = new TextArea("",20, 40, TextArea.SCROLLBARS_NONE);
		JScrollPane js = new JScrollPane(jta);
		js.setSize(370, 400);
		js.setLocation(15, 50);
		
		add(js);
		add(jp1);
		add(jp2);
	    setSize(415,550);
	    setVisible(true);
	}
	
	private class MyActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("��  ��")){
				setVisible(false);
				new Class1();
		    }
		    else if(b.getText().equals("��  ��")){
		    	jta.setText("  *** ��  �� *** \n \n"); //�޷��� ǥ���ϴ� �Լ� �߰�
		    }
		    else if(b.getText().equals("��  ��")){
		    }
		    else if(b.getText().equals("��  ��")){
		    	setVisible(false);
		    	new Class2();
		    }
		}
	}
}