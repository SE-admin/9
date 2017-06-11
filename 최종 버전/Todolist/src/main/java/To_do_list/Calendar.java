package To_do_list;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.util.*;


public class Calendar extends JFrame{
	private static final long serialVersionUID = 1L;
	TextArea jta;
	JButton jb1, jb2, jb3, jb4 ;
	JTextField  jt1;
	JLabel jl1, jl2, jl3 ;
	String fs;

	String[] ListDate = new String[10];
	int[] StrToInt = new int[10];
	int count=0;
	int numOfList=0;
	

	
	GregorianCalendar today = new GregorianCalendar();
	
	int nowYear = today.get(java.util.Calendar.YEAR);
	int nowMonth = today.get(java.util.Calendar.MONTH)+1;
	int nowDate = today.get(java.util.Calendar.DATE);
	
	@SuppressWarnings("resource")
	Calendar(){


		
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		MyActionListener listener = new MyActionListener();
		
		
		JPanel jp1 = new JPanel();
	    jp1.setLayout(new GridLayout(1,4));
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
		jp1.setLocation(20,450);
		jp1.setSize(360,30);
		
		jta = new TextArea("",20, 40, TextArea.SCROLLBARS_NONE);
		JScrollPane js = new JScrollPane(jta);
		js.setSize(370, 400);
		js.setLocation(15, 20);
		
		add(js);
		add(jp1);
	    setSize(415,550);
	    setVisible(true);
		
	    
	    //할일은 총 10개까지 저장할 수 있습니다.
	    int[] arrayintBefor = new int[10];
	    int[] arrayint = new int[10];
	    int[] arrayintNext = new int[10];
	    
	    //저번달 결정하기 : 만약 이번달이 1월이면 12월달로하고 저번년으로 저장함
	    int beforMonth = nowMonth-1;
	    int beforYear = nowYear;
	    if(beforMonth<1){
	    	beforMonth=12;
	    	beforYear--;
	    
	    }
//	    //다음달 결정하기 : 만약 이번달이 12월이면 1월이되고 내년으로 넘어감
	    int nextMonth = nowMonth+1;
	    int nextYear = nowYear;
	    if(nextMonth>12){
	    	nextMonth=1;
	    	nextYear++;
	    }
	    
	    try {
		    Scanner scan = new Scanner(new File("list.txt"));
	    	while(scan.hasNextLine()){

		    String str = scan.nextLine();
		    String[] strArray = str.split(" ");
		   
		    ListDate[numOfList] = strArray[3];
		    StrToInt[numOfList] = Integer.valueOf(ListDate[numOfList]);


		    
		    if((StrToInt[numOfList]%10000)/100==beforMonth){
		    
		    	arrayintBefor[count]=StrToInt[numOfList]%100;
		    	count++;
		    }
		    
		    numOfList++;
		    
			if(count==10)
				count=0;//배열이 10의 크기로 선언되어있으므로 이보다 초과시 0으로 초기화 시키는 안전장치
	    	}
		} catch (Exception e) {
			System.out.println("입출력 오류");
			// TODO: handle exception
		}

	    
	    
	    
	    
	    PrintCal beforCal = new PrintCal();
	    SumDate beforSumDate = new SumDate();
	    beforSumDate.setSumDate(beforMonth, beforYear);
	    beforCal.MakeCalendar(beforSumDate.getSumDate());
	    beforCal.setCal(arrayintBefor,beforMonth, beforYear);
	    jta.setText(beforCal.getCal());
	    count=0;
	    numOfList=0;
	    
	    
	    try {
		    Scanner scan = new Scanner(new File("list.txt"));
	    	while(scan.hasNextLine()){

		    String str = scan.nextLine();
		    String[] strArray = str.split(" ");
		   
		    ListDate[numOfList] = strArray[3];
		    StrToInt[numOfList] = Integer.valueOf(ListDate[numOfList]);


		    
		    if((StrToInt[numOfList]%10000)/100==nowMonth){
		    
		    	arrayint[count]=StrToInt[numOfList]%100;
		    	count++;
		    }
		    
		    numOfList++;
		    
			if(count==10)
				count=0;//배열이 10의 크기로 선언되어있으므로 이보다 초과시 0으로 초기화 시키는 안전장치
	    	}
		} catch (Exception e) {
			System.out.println("입출력 오류");
			// TODO: handle exception
		}
	    
	    
	    
	    
	    PrintCal myCal = new PrintCal();
	    SumDate mySumDate = new SumDate();
	    mySumDate.setSumDate(nowMonth, nowYear);
	    myCal.MakeCalendar(mySumDate.getSumDate());
	    myCal.setCal(arrayint,nowMonth, nowYear);
	    jta.append(myCal.getCal());
	    count=0;
	    numOfList=0;
	    
	    try {
		    Scanner scan = new Scanner(new File("list.txt"));
	    	while(scan.hasNextLine()){

		    String str = scan.nextLine();
		    String[] strArray = str.split(" ");
		   
		    ListDate[numOfList] = strArray[3];
		    StrToInt[numOfList] = Integer.valueOf(ListDate[numOfList]);


		    
		    if((StrToInt[numOfList]%10000)/100==nextMonth){
		    
		    	arrayintNext[count]=StrToInt[numOfList]%100;
		    	count++;
		    }
		    
		    numOfList++;
		    
			if(count==10)
				count=0;//배열이 10의 크기로 선언되어있으므로 이보다 초과시 0으로 초기화 시키는 안전장치
	    	}
		} catch (Exception e) {
			System.out.println("입출력 오류");
			// TODO: handle exception
		}
	    
	    count=0;
	    
	    PrintCal nextCal = new PrintCal();
	    SumDate nextSumDate = new SumDate();
	    nextSumDate.setSumDate(nextMonth, nextYear);
	    nextCal.MakeCalendar(nextSumDate.getSumDate());
	    nextCal.setCal(arrayintNext,nextMonth, nextYear);
	    jta.append(nextCal.getCal());


	 
	}
	
	private class MyActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("오  늘")){
				setVisible(false);
				new Class1();
		    }
		    else if(b.getText().equals("달  력")){
		    	setVisible(false);
		    	new Calendar();

		    }
		    else if(b.getText().equals("과  제")){
		    	setVisible(false);
		    	new Class3();
		    }
		    else if(b.getText().equals("등  록")){
		    	setVisible(false);
		    	new Class2();
		    }
		}
	}
	

}
