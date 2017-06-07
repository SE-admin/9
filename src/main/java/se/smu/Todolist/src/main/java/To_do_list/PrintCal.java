package To_do_list;
/*UC07 �޷� ǥ�� ����*/

import java.util.Calendar;
import java.util.*;

public class PrintCal extends LimitMonth{
	private StringBuffer cal = new StringBuffer();
	private int[][] date = new int[6][7];
	private int row,column;
	private String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    private int cal_num = 0;
    

	GregorianCalendar today = new GregorianCalendar();
		
	int nowYear = today.get(Calendar.YEAR);
	int nowMonth = today.get(Calendar.MONTH)+1;
	int nowDate = today.get(Calendar.DATE);
    
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
    
    public void setCal(int[] date,int month, int year){
        
        setMonth(month, year);
        
        
        this.cal.append("                                   "+month+"��"+"    "+year+"��");
    	cal.append("\n\n");
        for (column = 0; column < 7; column++)
    		cal.append(String.format("%8s", day[column]));
    	for (row = 0; row < 6; row++) {
    		cal.append("\n");
    		for (column = 0; column < 7; column++)
    			if (this.date[row][column] == 0 || this.date[row][column]>getMonth())

    				cal.append(String.format("%11s",""));
    	    		
    			else if(this.date[row][column] ==date[0])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[1])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[2])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[3])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[4])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[5])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[6])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[7])

    				cal.append(String.format("%9s","��"));
    			else if(this.date[row][column] ==date[8])

    				cal.append(String.format("%9s","��"));
    		
    			else if(this.date[row][column] ==date[9])

    				cal.append(String.format("%9s","��"));
    			else
    				if(this.date[row][column]<10){
    				
    					cal.append(String.format("%9s",0));
						cal.append(String.format("%s",this.date[row][column]));
    			
    				}
    				else
    				cal.append(String.format("%10s",this.date[row][column]));
				
    		
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