package To_do_list;
/*UC07 �޷� ǥ�� ����*/
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
	// ���� �Է��ϸ� �� ���� ���ϱ��� �ִ����� ��ȯ���ݴϴ�. �⵵�� �޴� ������ 2������ 28������ 29�������� �����ϱ� ���ؼ��Դϴ�.

}