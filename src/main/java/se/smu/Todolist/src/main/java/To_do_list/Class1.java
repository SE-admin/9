package To_do_list;

import javax.swing.*;

import To_do_list.Class2.List;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.util.*;


public class Class1 extends JFrame { // 오늘, 달력
	TextArea jta;
	JButton jb1, jb2, jb3, jb4 ;
	JTextField  jt1;
	JLabel jl1, jl2, jl3 ;
	String fs;
	String[] ListDate = new String[10];
	int[] StrToInt = new int[10];
	int numOfList=0;
	int[] saveList = new int[10];
	String sDate = new String();
	
	
	HashMap<String, List> hashList = new HashMap<String, List>();
	class List{
	   String n1;
	   String n2;
	   String n3;
	   String n4;
	   public List(String n1, String n2, String n3, String n4){
	      this.n1 = n1;
	      this.n2 = n2;
	      this.n3 = n3;
	      this.n4 = n4;
	   }
	}
	
	GregorianCalendar today = new GregorianCalendar();
		
	int nowYear = today.get(today.YEAR);
	int nowMonth = today.get(today.MONTH)+1;
	int nowDate = today.get(today.DATE);
	
	
	
	
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
		jp1.setLocation(15,470);
		jp1.setSize(435,30);
		
		jta = new TextArea("",20, 40, TextArea.SCROLLBARS_NONE);
		JScrollPane js = new JScrollPane(jta);
		js.setSize(435, 440);
		js.setLocation(15, 20);
		
		add(js);
		add(jp1);
	    setSize(480,550);
	    setVisible(true);
	    
	    
	    
	    try{
	    	 Scanner scan = new Scanner(new File("list.txt"));
	    	 
	    
	    	 /* 오늘 */
	    	 while(scan.hasNextLine()) {
	    		
	    		 String str = scan.nextLine();
	    		 String[] strArray = str.split(" ");
				    hashList.put(strArray[0], new List(strArray[2],strArray[3],strArray[4],strArray[5]));
				   
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
				    if(listDuration.getDuration()==0)
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

		    	/*달력 표시 : 이번달~다음달까지*/
		    	int beforMonth,beforYear;
		    	int afterMonth,afterYear;

		    	if(nowMonth-1<0){

		    		beforMonth=12;
		    		beforYear=nowYear-1;
		    	}
		    	else{
		    		beforMonth=nowMonth-1;
		    		beforYear=nowYear;
		    	}
		    	
		    	if(nowMonth+1>12){
		    		afterMonth=1;
		    		afterYear=nowYear+1;
		    	}
		    	else{
		    		afterMonth=nowMonth+1;
		    		afterYear=nowYear;	
		    	}


		    	int count=0;
		    	/*저번달*/
		    	PrintCal beforCal = new PrintCal();
		    	SumDate beforSumDate = new SumDate();
		    	beforSumDate.setSumDate(beforMonth, beforYear);
		    	beforCal.MakeCalendar(beforSumDate.getSumDate());
		    	while(count<numOfList-1){

		    		if((StrToInt[count]%10000)/100==beforMonth)
		    		beforCal.setCal(StrToInt[count]%100,beforMonth, beforYear);
		    		else
		    		beforCal.setCal(0,beforMonth, beforYear);
		    		count++;
		    	}
		    	jta.setText(beforCal.getCal());
		    	count=0;
		    	

		    	/*이번달 */
		    	PrintCal nowCal = new PrintCal();
		    	SumDate nowSumDate = new SumDate();
		    	nowSumDate.setSumDate(nowMonth, nowYear);
		    	nowCal.MakeCalendar(nowSumDate.getSumDate());

		    	while(count<numOfList-1){
		    		if((StrToInt[count]%10000)/100==nowMonth)
		    		nowCal.setCal(StrToInt[count]%100,nowMonth, nowYear);
		    		else
		    		nowCal.setCal(0,nowMonth, nowYear);
		    		
		    		count++;
		    		
		    	}
		    	jta.append(nowCal.getCal());
		    	count=0;
		    	
		    	/*다음달*/
		    	PrintCal afterCal = new PrintCal();
		    	SumDate afterSumDate = new SumDate();
		    	afterSumDate.setSumDate(afterMonth, afterYear);
		    	afterCal.MakeCalendar(afterSumDate.getSumDate());
		    	
		    	while(count<numOfList-1){
		    		if((StrToInt[count]%10000)/100==afterMonth)
			    		afterCal.setCal(StrToInt[count]%100,afterMonth, afterYear);
			    		else
			    		afterCal.setCal(0,afterMonth, afterYear);
			    		
			    	count++;	
		    	}// 요기 첫번째에 날짜 입력해주시면 o표시가 되요
		    	
		    	jta.append(afterCal.getCal());
		    	
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


