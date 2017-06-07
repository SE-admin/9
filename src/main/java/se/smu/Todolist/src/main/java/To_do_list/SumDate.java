package To_do_list;
/*UC06 D-Day 관련 */
/*UC07 달력 표시 관련 : PrintCal.java -> makeCalendar 관련 함수 */
public class SumDate{
	private int sumDate;
	private int sumDateDetail;
	
	public void setSumDate(int month,int year){
		this.sumDate = (year-1970)*365;
		sumDate += (year/4-1970/4)-(year/100-1970/100)+(year/400-1970/400);
		
		if(year%4==0 && year%100 !=0 || year % 400 == 0)
			if(month<3)
			sumDate--;
		
		if(month>1)
			sumDate += 31;
		if(month>2)
			sumDate += 28;
		if(month>3)
			sumDate += 31;
		if(month>4)
			sumDate += 30;
		if(month>5)
			sumDate += 31;
		if(month>6)
			sumDate += 30;
		if(month>7)
			sumDate += 31;
		if(month>8)
			sumDate += 31;
		if(month>9)
			sumDate += 30;
		if(month>10)
			sumDate += 31;
		if(month>11)
			sumDate += 30;
		
			
			
	}
	public int getSumDate(){

		return sumDate;
	}
	//달과 년도를 입력하면 총합 날짜를 반환합니다.
	
	public void setSumDate(int date,int month,int year){
		this.sumDateDetail = (year-1970)*365;
		sumDateDetail += (year/4-1970/4)-(year/100-1970/100)+(year/400-1970/400);
		
		if(year%4==0 && year%100 !=0 || year % 400 == 0)
			if(month<3)
			sumDateDetail--;
		
		if(month>1)
			sumDateDetail += 31;
		if(month>2)
			sumDateDetail += 28;
		if(month>3)
			sumDateDetail += 31;
		if(month>4)
			sumDateDetail += 30;
		if(month>5)
			sumDateDetail += 31;
		if(month>6)
			sumDateDetail += 30;
		if(month>7)
			sumDateDetail += 31;
		if(month>8)
			sumDateDetail += 31;
		if(month>9)
			sumDateDetail += 30;
		if(month>10)
			sumDateDetail += 31;
		if(month>11)
			sumDateDetail += 30;
		
			
			sumDateDetail += date;
	}
	public int getSumDateDetail(){
	return sumDateDetail;	
	}
	//일과 달과 년도를 입력하면 총합 날짜를 반환합니다.
}
