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
		
	    
	    //������ �� 10������ ������ �� �ֽ��ϴ�.
	    int[] arrayintBefor = new int[10];
	    int[] arrayint = new int[10];
	    int[] arrayintNext = new int[10];
	    
	    //������ �����ϱ� : ���� �̹����� 1���̸� 12���޷��ϰ� ���������� ������
	    int beforMonth = nowMonth-1;
	    int beforYear = nowYear;
	    if(beforMonth<1){
	    	beforMonth=12;
	    	beforYear--;
	    
	    }
//	    //������ �����ϱ� : ���� �̹����� 12���̸� 1���̵ǰ� �������� �Ѿ
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
				count=0;//�迭�� 10�� ũ��� ����Ǿ������Ƿ� �̺��� �ʰ��� 0���� �ʱ�ȭ ��Ű�� ������ġ
	    	}
		} catch (Exception e) {
			System.out.println("����� ����");
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
				count=0;//�迭�� 10�� ũ��� ����Ǿ������Ƿ� �̺��� �ʰ��� 0���� �ʱ�ȭ ��Ű�� ������ġ
	    	}
		} catch (Exception e) {
			System.out.println("����� ����");
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
				count=0;//�迭�� 10�� ũ��� ����Ǿ������Ƿ� �̺��� �ʰ��� 0���� �ʱ�ȭ ��Ű�� ������ġ
	    	}
		} catch (Exception e) {
			System.out.println("����� ����");
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
			if(b.getText().equals("��  ��")){
				setVisible(false);
				new Class1();
		    }
		    else if(b.getText().equals("��  ��")){
		    	setVisible(false);
		    	new Calendar();

		    }
		    else if(b.getText().equals("��  ��")){
		    	setVisible(false);
		    	new Class3();
		    }
		    else if(b.getText().equals("��  ��")){
		    	setVisible(false);
		    	new Class2();
		    }
		}
	}
	

}
