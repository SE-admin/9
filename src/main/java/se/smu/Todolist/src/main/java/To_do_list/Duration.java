package To_do_list;
/* UC06 D-Day 계산 관련*/
public class Duration{
	private int duration;
    
	public void setDuration(int mySumDate_getSumDateDetail,int mySumDateNow_getSumDateNowDetail){
	
		this.duration = mySumDate_getSumDateDetail - mySumDateNow_getSumDateNowDetail;
		
	}
    public int getDuration(){
    	return duration;
    }
    //사용하기전 SumDate.java의 Setter를 사용해서 [할일 등록 날짜를 set]하고 [현재의 시간을 set]하신 후 2개의 Getter를 매개변수로 받아주세요
    
}
