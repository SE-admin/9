package To_do_list;
/*UC07 �޷� ǥ�� ����*/

import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.color.*;

public class PrintCal extends LimitMonth{
	private StringBuffer cal = new StringBuffer();
	private int[][] date = new int[6][7];
	private int row,column;
	private String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    private int cal_num = 0;
    

	GregorianCalendar today = new GregorianCalendar();
		
	int nowYear = today.get(today.YEAR);
	int nowMonth = today.get(today.MONTH)+1;
	int nowDate = today.get(today.DATE);
    
    private void CleanCalendar(){
    	

	for(row=0;row<6;row++)
		for(column=0;column<7; column++)
			this.date[row][column]=0;
	
	
    }
    

    public void MakeCalendar(int SumDate){
    	CleanCalendar();
    	this.column = (SumDate+4)%7;
    	for(row=0; ; column++){
    		if(column==7){
    			row++;
    		column =0;
    		if(row==6)
    			break;
    		}
    	date[row][column]=++cal_num;
    	}
    }
    //PrintCal�� ����Ͻñ����� ���� �޷��� ����ž� �մϴ�. �� �Լ��� ����ؼ� �޷��� ������ּ���,SumDate�� ��üȭ �� Getter�� �޾��ּ���
    
    public void setCal(int date,int month, int year){
        
        setMonth(month, year);
        
        
        this.cal.append("                    "+month+"��"+"    "+year+"��");
    	cal.append("\n\n");
        for (column = 0; column < 7; column++)
    		cal.append(String.format("%4s", day[column]));
    	for (row = 0; row < 6; row++) {
    		cal.append("\n");
    		for (column = 0; column < 7; column++)
    			if (this.date[row][column] == 0 || this.date[row][column]>getMonth())

    				cal.append(String.format("%7s",""));
    	    		
    			else if(this.date[row][column] ==date && this.date[row][column] !=  nowDate)

    				cal.append(String.format("%6s","O"));
    			
    			else if(this.date[row][column] ==nowDate)
    				cal.append(String.format("%6s","����"));
    		
    			else
    				if(this.date[row][column]<10){
    				
    					cal.append(String.format("%5s",0));
						cal.append(String.format("%s",this.date[row][column]));
    			
    				}
    				else
    				cal.append(String.format("%6s",this.date[row][column]));
				
    		
    	}
    	cal.append("\n\n");
    	
        }
    public String getCal(){
    	
    	return this.cal.toString();
    }

}
//�Լ� ��� ��
/*
PrintCal myCal = new PrintCal();
SumDate mySumDate = new SumDate();
mySumDate.setSumDate(nowMonth, nowYear);
myCal.MakeCalendar(mySumDate.getSumDate());
myCal.PrintCal(nowDate,nowMonth, nowYear);
*/