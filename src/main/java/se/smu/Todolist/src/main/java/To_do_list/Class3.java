package To_do_list;

import javax.swing.*;


import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.*;
// 날짜 구해주는 패키
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
	JRadioButton rOngoing, rPast, rCompleted, rInCompleted;
	ButtonGroup buttonGrp1, buttonGrp2;
	
	String importants = null, tag_hards = null, tag_longs = null, tag_teams = null;
	HashMap<String, List> hs = new HashMap<String, List>();

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

	GregorianCalendar today = new GregorianCalendar();

	Class3() {
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		MyActionListener listener = new MyActionListener();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1, 4));
		jb1 = new JButton("오  늘");
		jb2 = new JButton("달  력");
		jb3 = new JButton("과  제");
		jb4 = new JButton("등  록");
		jb1.addActionListener(listener);
		jb2.addActionListener(listener);
		jb3.addActionListener(listener);
		jb4.addActionListener(listener);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.setLocation(15, 460);
		jp1.setSize(435, 30);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1, 3));
		jb5 = new JButton("조회");
		rOngoing = new JRadioButton( "진행중", true );
		rPast = new JRadioButton("지남");
		rCompleted = new JRadioButton("완료표시", true);
		rInCompleted = new JRadioButton("완료표시X");
		
		buttonGrp1 = new ButtonGroup();
		buttonGrp1.add(rOngoing);
		buttonGrp1.add(rPast);
		
		
		buttonGrp2 = new ButtonGroup();
		buttonGrp2.add(rCompleted);
		buttonGrp2.add(rInCompleted);
		
		
		jb5.addActionListener(listener);
		
		jp2.add(rOngoing);
		jp2.add(rPast);
		jp2.add(rCompleted);
		jp2.add(rInCompleted);
		jp2.add(jb5);
		
		jp2.setLocation(20, 10);
		jp2.setSize(430, 30);

		jta = new TextArea("", 20, 40, TextArea.SCROLLBARS_NONE);
		JScrollPane js = new JScrollPane(jta);
		js.setSize(435, 400);
		js.setLocation(15, 50);

		add(js);
		add(jp1);
		add(jp2);
		setSize(480, 550);
		setVisible(true);
		
		//Class3가 실행되면 list.txt의 todo를 hashmap에 올림.
		try {
			Scanner scan = new Scanner(new File("list.txt"));
			while (scan.hasNextLine()) {
				String str = scan.nextLine();
				String[] strArray = str.split(" ");
			hs.put(strArray[0], new List(strArray[2],strArray[3],strArray[4],strArray[5],strArray[6],strArray[7],strArray[8],strArray[9])); // 해쉬맵에
																																																// 넣음.
			}
			scan.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("입출력 오류");
		}
		
		jta.setText("D-day ToDo - 과목명 마감일 실제마감일 완료여부 태그1 태그2 태그3");

		
	}
	public static long diffOfDate(String begin, String end) throws Exception //d-day를 계산하기 위한 함수.
	  {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	 
	    Date beginDate = formatter.parse(begin);
	    Date endDate = formatter.parse(end);
	 
	    long diff = endDate.getTime() - beginDate.getTime();
	    long diffDays = diff / (24 * 60 * 60 * 1000);
	 
	    return diffDays;
	  }
	

	class MyActionListener implements ActionListener { //조회에서 어떠한 조건으로 실행되는지 뽑는 절차. 
		public void actionPerformed(ActionEvent e) { //조건1인 진행중/지남 중 어떤 것이 선택 되었는지 확인하는 절차. 
			JButton b = (JButton) e.getSource();
			Enumeration<AbstractButton> enums1 = buttonGrp1.getElements();
			String state = null;
			while(enums1.hasMoreElements()) { 
				 AbstractButton ab1 = enums1.nextElement();
				 JRadioButton jb1 = (JRadioButton)ab1;
				 if(jb1.isSelected())
					 state = jb1.getText().trim();
			}
			Enumeration<AbstractButton> enums2 = buttonGrp2.getElements();// 조건2인 완료표시, 완료표시X 중 어떤 것이 선택 되었는지 확인하는 절차. 
			String show = null;
			while(enums2.hasMoreElements()) { 
				 AbstractButton ab2 = enums2.nextElement();
				 JRadioButton jb2 = (JRadioButton)ab2;
				 if(jb2.isSelected())
					 show = jb2.getText().trim();
			}
			
			if (b.getText().equals("오  늘")) {
				hs.clear();//다른 버튼을 눌렀을 경우 해쉬맵 초기화.
				setVisible(false);
				new Class1();
			} else if (b.getText().equals("달  력")) {
				hs.clear();
				jta.setText("*** 달력 *** \n \n"); // 달력을 표시하는 함수 추가
			} else if (b.getText().equals("과제")) {
				hs.clear();
				setVisible(false);
				new Class3();
			} else if (b.getText().equals("등  록")) {
				hs.clear();
				setVisible(false);
				new Class2();
			} else if(b.getText().equals("조회")){
				if(state.equals("진행중") && show.equals("완료표시")){
					jta.setText("");
					
					int nowYear= today.get(today.YEAR);
					int nowMonth = today.get(today.MONTH) + 1; // 현재 월 변수.
					int nowDate = today.get(today.DATE);// 현재 일 변수.
					nowDate = nowDate + (100 * nowMonth) + (10000 * nowYear);
					
					Set<String> keys = hs.keySet();
					Iterator<String> it = keys.iterator();
					for (int i = 0; i < hs.size(); i++) {//list하나씩 비교.
						String key = (String)it.next();
						List personx = hs.get(key);
						for(int j=0; j<personx.n2.length(); j++){//마감일을 MMdd형식으로 나타냄.
							if(48 <= personx.n2.charAt(j) && personx.n2.charAt(j) <= 57)
								sDate += personx.n2.charAt(j);
						}
						int intDate = Integer.parseInt(sDate);//마감일을 나타내는 변수.
						if (intDate >= nowDate) {
							if(personx.n5.equals("1")) {
									try {
										jta.append("☆ " + "D-" + diffOfDate( Integer.toString(nowDate),  Integer.toString(intDate)) + " " +key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " " + personx.n4 + " ");
									} catch (Exception e1) {
										e1.printStackTrace();
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
							else {
								try {
									jta.append("D-" + diffOfDate( Integer.toString(nowDate),  Integer.toString(intDate)) + " " +key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + " ");
								} catch (Exception e1) {
									e1.printStackTrace();
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
						}
						sDate = "";//현재 날짜 초기화.
					}
				} else if(state.equals("진행중") && show.equals("완료표시X")){
					jta.setText("");
					int nowYear= today.get(today.YEAR);
					int nowMonth = today.get(today.MONTH) + 1; // 현재 월 변수.
					int nowDate = today.get(today.DATE);// 현재 일 변수.
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
						if (intDate >= nowDate) {
							if(personx.n5.equals("1") && personx.n4.equals("미완")) {
								try {
									jta.append("☆ " + "D-" + diffOfDate( Integer.toString(nowDate),  Integer.toString(intDate)) + " " +key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " " + personx.n4 + " ");
								} catch (Exception e1) {
									e1.printStackTrace();
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
						else if(personx.n4.equals("미완")) {
							try {
								jta.append("D-" + diffOfDate( Integer.toString(nowDate),  Integer.toString(intDate)) + " " +key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + " ");
							} catch (Exception e1) {
								e1.printStackTrace();
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
					}
						sDate = "";
					}
				} else if(state.equals("지남") && show.equals("완료표시")){
					jta.setText("");
					int nowYear= today.get(today.YEAR);
					int nowMonth = today.get(today.MONTH) + 1; // 현재 월 변수.
					int nowDate = today.get(today.DATE);// 현재 일 변수.
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
						if (!(intDate >= nowDate)) {
							if(personx.n5.equals("1")) {
								jta.append("☆ " + key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " " + personx.n4 + " ");
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
						else {
							jta.append(key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + " ");
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
					}
						sDate = "";
					}
					
					
				} else if(state.equals("지남") && show.equals("완료표시X")){
					jta.setText("");
					int nowYear= today.get(today.YEAR);
					int nowMonth = today.get(today.MONTH) + 1; // 현재 월 변수.
					int nowDate = today.get(today.DATE);// 현재 일 변수.
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
						if (!(intDate >= nowDate)) {
							if(personx.n5.equals("1") && personx.n4.equals("미완")) {
								jta.append("☆ " + key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " " + personx.n4 + " ");
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
						else if(personx.n4.equals("미완")) {
							jta.append(key+ " - " + personx.n1 + " " + personx.n2 + " " + personx.n3 + " "+ personx.n4 + " ");
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
					}
						sDate = "";
					}
				}
			} 
		}
	}
}
