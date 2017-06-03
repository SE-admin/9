package To_do_list;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
// ��¥ �����ִ� ��Ű
import java.util.*;

public class Class3 extends JFrame {
	String str = null;
	boolean hasMore = true;
	String sDate = new String();

	TextArea jta;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8;
	JTextField jt1;
	JLabel jl1, jl2, jl3;
	String fs;

	HashMap<String, List> hs = new HashMap<String, List>();

	class List {
		String n1;
		String n2;
		String n3;
		String n4;

		public List(String n1, String n2, String n3, String n4) {
			this.n1 = n1;
			this.n2 = n2;
			this.n3 = n3;
			this.n4 = n4;
		}
	}

	GregorianCalendar today = new GregorianCalendar();

	Class3() {
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		MyActionListener listener = new MyActionListener();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1, 4));
		jb1 = new JButton("����");
		jb2 = new JButton("�޷�");
		jb3 = new JButton("����");
		jb4 = new JButton("���");
		jb1.addActionListener(listener);
		jb2.addActionListener(listener);
		jb3.addActionListener(listener);
		jb4.addActionListener(listener);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.setLocation(20, 460);
		jp1.setSize(360, 30);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1, 4));
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
		jp2.setLocation(20, 10);
		jp2.setSize(360, 30);

		jta = new TextArea("", 20, 40, TextArea.SCROLLBARS_NONE);
		JScrollPane js = new JScrollPane(jta);
		js.setSize(370, 400);
		js.setLocation(15, 50);

		add(js);
		add(jp1);
		add(jp2);
		setSize(415, 550);
		setVisible(true);
		
		//Class3�� ����Ǹ� list.txt�� todo�� hasmap�� �ø�.
		try {
			Scanner scan = new Scanner(new File("list.txt"));
			while (scan.hasNextLine()) {
				String str = scan.nextLine();
				String[] strArray = str.split(" ");
				hs.put(strArray[0], new List(strArray[2], strArray[3], strArray[4], strArray[5])); // �ؽ��ʿ�
																									// task��
																									// ����.
			}
			scan.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("����� ����");
		}

		
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			jta.setText("");
			
			if (b.getText().equals("����")) {
				hs.clear();//�ٸ� ��ư�� ������ ��� �ؽ��� �ʱ�ȭ.
				setVisible(false);
				new Class1();
			} else if (b.getText().equals("�޷�")) {
				hs.clear();
				jta.setText("*** �޷� *** \n \n"); // �޷��� ǥ���ϴ� �Լ� �߰�
			} else if (b.getText().equals("����")) {
				hs.clear();
				setVisible(false);
				new Class3();
			} else if (b.getText().equals("���")) {
				hs.clear();
				setVisible(false);
				new Class2();
			} else if (b.getText().contains("���� �ϼ�")) { // ����ϼ��� ������ ���\
				jta.setText("");
				
				int nowYear= today.get(today.YEAR);
				int nowMonth = today.get(today.MONTH) + 1; // ���� �� ����.
				int nowDate = today.get(today.DATE);// ���� �� ����.
				nowDate = nowDate + (100 * nowMonth) + (10000 * nowYear);
				
				Set<String> keys = hs.keySet();
				Iterator<String> it = keys.iterator();
				for (int i = 0; i < hs.size(); i++) {//list�ϳ��� ��.
					String key = (String)it.next();
					List personx = hs.get(key);
					for(int j=0; j<personx.n2.length(); j++){//�������� MMdd�������� ��Ÿ��.
						if(48 <= personx.n2.charAt(j) && personx.n2.charAt(j) <= 57)
							sDate += personx.n2.charAt(j);
					}
					int intDate = Integer.parseInt(sDate);//�������� ��Ÿ���� ����.
					if (intDate <= nowDate) {
						if (personx.n4.equals("�Ϸ�") || personx.n4.equals("�Ϸ�*")){
							jta.append(key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + "\n");
						}
					}
					sDate = "";//���� ��¥ �ʱ�ȭ.
				}
			} else if (b.getText().contains("���� �̿�")) { //���� ���� �ϼ��� �����ǹ��� �ٸ�.
				jta.setText("");
				int nowYear= today.get(today.YEAR);
				int nowMonth = today.get(today.MONTH) + 1; // ���� �� ����.
				int nowDate = today.get(today.DATE);// ���� �� ����.
				nowDate = nowDate + (100 * nowMonth) + (10000 * nowYear);
				
				Set<String> keys = hs.keySet();
				Iterator<String> it = keys.iterator();
				for (int i = 0; i < hs.size(); i++) {
					String key = (String)it.next();
					List personx = hs.get(key);
					for(int j=0; j<personx.n2.length(); j++){
						if(48 <= personx.n2.charAt(j) && personx.n2.charAt(j) <= 57)
							sDate += personx.n2.charAt(j);
					}
					int intDate = Integer.parseInt(sDate);
					if (intDate <= nowDate) {
						if (personx.n4.equals("�̿�") || personx.n4.equals("�̿�*")) {
							jta.append(key + " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " " + personx.n4 + "\n");
						}
					}
					sDate = "";
				}
			} else if (b.getText().contains("���� �ϼ�")) { //���� ���� �ϼ��� �����ǹ��� �ٸ�.
				jta.setText("");
				int nowYear= today.get(today.YEAR);
				int nowMonth = today.get(today.MONTH) + 1; // ���� �� ����.
				int nowDate = today.get(today.DATE);// ���� �� ����.
				nowDate = nowDate + (100 * nowMonth) + (10000 * nowYear);
				
				
				Set<String> keys = hs.keySet();
				Iterator<String> it = keys.iterator();
				for (int i = 0; i < hs.size(); i++) {
					String key = (String)it.next();
					List personx = hs.get(key);
					for(int j=0; j<personx.n2.length(); j++){
						if(48 <= personx.n2.charAt(j) && personx.n2.charAt(j) <= 57)
							sDate += personx.n2.charAt(j);
					}
					int intDate = Integer.parseInt(sDate);
					if (!(intDate <= nowDate)) {
						if (personx.n4.equals("�Ϸ�") || personx.n4.equals("�Ϸ�*")){
							jta.append(key + " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + "\n");
							System.out.println(nowDate +"-" + intDate + key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + "\n");
						}
					}
					sDate = "";
				}
			} else if (b.getText().contains("���� �̿�")) { //���� ���� �ϼ��� �����ǹ��� �ٸ�.
				jta.setText("");
				int nowYear= today.get(today.YEAR);
				int nowMonth = today.get(today.MONTH) + 1; // ���� �� ����.
				int nowDate = today.get(today.DATE);// ���� �� ����.
				nowDate = nowDate + (100 * nowMonth) + (10000 * nowYear);
				
				
				Set<String> keys = hs.keySet();
				Iterator<String> it = keys.iterator();
				for (int i = 0; i < hs.size(); i++) {
					String key = (String)it.next();
					List personx = hs.get(key);
					for(int j=0; j<personx.n2.length(); j++){
						if(48 <= personx.n2.charAt(j) && personx.n2.charAt(j) <= 57)
							sDate += personx.n2.charAt(j);
					}
					int intDate = Integer.parseInt(sDate);
					if (!(intDate <= nowDate)) {
						if (personx.n4.equals("�̿�") || personx.n4.equals("�̿�*")){
							jta.append(key + " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + "\n");
						}
					}
					sDate = "";
				}
			}
		}
	}
}
