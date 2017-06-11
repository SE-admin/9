package To_do_list;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.util.*;


public class Class1 extends JFrame { // 오늘, 달력
	private static final long serialVersionUID = 1L; //warning(오류) 처리
	TextArea jta;
	JButton jb1, jb2, jb3, jb4 ;
	JTextField  jt1;
	JLabel jl1, jl2, jl3 ;
	String fs;
	
	String[] ListDate = new String[10];
	int[] StrToInt = new int[10];
	int numOfList=0;
	String sDate = new String();
	
	
	HashMap<String, List> hashList = new HashMap<String, List>();
	class List{
	   String n1;
	   String n2;
	   String n3;
	   String n4;
	   String n5;
	   public List(String n1, String n2, String n3, String n4,String n5){
	      this.n1 = n1;
	      this.n2 = n2;
	      this.n3 = n3;
	      this.n4 = n4;
	      this.n5 = n5;
	   }
	}
	
	GregorianCalendar today = new GregorianCalendar();
		
	int nowYear = today.get(java.util.Calendar.YEAR);
	int nowMonth = today.get(java.util.Calendar.MONTH)+1;
	int nowDate = today.get(java.util.Calendar.DATE);
	
	
	
	
	Class1() {
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
	    
	    jta.append("매우 중요!\n\n");
	    
	    try{
	    	 Scanner scan = new Scanner(new File("list.txt"));
	    	 
	    
	    	 /* 오늘 */
	    	 while(scan.hasNextLine()) {
	    		
	    		 String str = scan.nextLine();
	    		 String[] strArray = str.split(" ");
				    hashList.put(strArray[0], new List(strArray[2],strArray[3],strArray[4],strArray[5],strArray[6]));
				   
				    ListDate[numOfList] = strArray[3];
				    
				    StrToInt[numOfList] = Integer.valueOf(ListDate[numOfList]);
				    

				    //총합날짜구하기
				    SumDate listSumDate = new SumDate();
				    SumDate nowSumDate = new SumDate();
				    
				    //ex) 20170517 을 입력하면 17 05 2017 이렇게 나눠서 입력됩니다.
				    listSumDate.setSumDate(StrToInt[numOfList]%100 ,(StrToInt[numOfList]%10000)/100, StrToInt[numOfList]/10000);
				    nowSumDate.setSumDate(nowDate, nowMonth, nowYear);
				    //기한구하기
				    Duration listDuration = new Duration();
				    listDuration.setDuration(listSumDate.getSumDateDetail(),nowSumDate.getSumDateDetail() );
				    
				    List hashKey = hashList.get(strArray[0]);
					//기한이 0 이면 해당 배열을 출력합니다.
				    int check=0;
				    check=Integer.valueOf(hashKey.n5);
				    
				    
				    if(listDuration.getDuration()==0)
				    	if(check==1)
				    jta.append("☆ "+strArray[0]+" "+ hashKey.n1+" "+hashKey.n2+" "+hashKey.n3+" "+hashKey.n4+"\n\n"); 
				    numOfList++;
			 }
			 scan.close();
	     }catch(IOException e1){
	    	 System.out.println("입출력 오류");
	     }
	    
	    jta.append("-------------------------------\n\n보통\n\n");
	    numOfList=0;//초기화
	    hashList.clear();
	    try{
	    	 Scanner scan = new Scanner(new File("list.txt"));
	    	 
	    
	    	 /* 오늘 */
	    	 while(scan.hasNextLine()) {
	    		
	    		 String str = scan.nextLine();
	    		 String[] strArray = str.split(" ");
				    hashList.put(strArray[0], new List(strArray[2],strArray[3],strArray[4],strArray[5],strArray[6]));
				   
				    ListDate[numOfList] = strArray[3];
				    
				    StrToInt[numOfList] = Integer.valueOf(ListDate[numOfList]);
				    

				    //총합날짜구하기
				    SumDate listSumDate = new SumDate();
				    SumDate nowSumDate = new SumDate();
				    
				    //ex) 20170517 을 입력하면 17 05 2017 이렇게 나눠서 입력됩니다.
				    listSumDate.setSumDate(StrToInt[numOfList]%100 ,(StrToInt[numOfList]%10000)/100, StrToInt[numOfList]/10000);
				    nowSumDate.setSumDate(nowDate, nowMonth, nowYear);
				    //기한구하기
				    Duration listDuration = new Duration();
				    listDuration.setDuration(listSumDate.getSumDateDetail(),nowSumDate.getSumDateDetail() );
				    

				    List hashKey = hashList.get(strArray[0]);
					//기한이 0 이면 해당 배열을 출력합니다.
				    int check=0;
				    check=Integer.valueOf(hashKey.n5);
				    
				    if(listDuration.getDuration()==0)
				    	if(check==0)
				    jta.append(strArray[0]+" "+ hashKey.n1+" "+hashKey.n2+" "+hashKey.n3+" "+hashKey.n4+"\n\n"); 
				    numOfList++;
			 }
			 scan.close();
	     }catch(IOException e1){
	    	 System.out.println("입출력 오류");
	     }	    
		
		

	        
	    
	    
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
	
	public static void main(String[] args) {

		
		
		new Class1();
	}
	

}

