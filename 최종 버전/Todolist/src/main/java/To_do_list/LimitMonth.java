package To_do_list;
/*UC07 달력 표시 관련*/
public class LimitMonth {
	private int month;
	

	public void  setMonth(int month, int year){

		
		switch(month){
		case 1 : this.month= 31;
		break;
		
		case 2 : if(year%4==0 && year% 100 !=0 || year%400 ==0)
			this.month = 29;
		else this.month = 28;
		break;
		
		case 3 : this.month = 31;
		break;
		case 4 : this.month = 30;
		break;
		case 5 : this.month = 31;
		break;
		case 6 : this.month = 30;
		break;
		case 7 : this.month = 31;
		break;
		case 8 : this.month = 31;
		break;
		case 9 : this.month = 30;
		break;
		case 10 : this.month = 31;
		break;
		case 11 : this.month = 30;
		break;
		case 12 : this.month = 31;
		break;
		}
		
	}
	public int   getMonth(){
		return month;
	}
	// 달을 입력하면 그 달이 몇일까지 있는지를 반환해줍니다. 년도를 받는 이유는 2월달이 28일인지 29일인지를 결정하기 위해서입니다.

}