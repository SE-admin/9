package To_do_list;
/* UC06 D-Day ��� ����*/
public class Duration{
	private int duration;
    
	public void setDuration(int mySumDate_getSumDateDetail,int mySumDateNow_getSumDateNowDetail){
	
		this.duration = mySumDate_getSumDateDetail - mySumDateNow_getSumDateNowDetail;
		
	}
    public int getDuration(){
    	return duration;
    }
    //����ϱ��� SumDate.java�� Setter�� ����ؼ� [���� ��� ��¥�� set]�ϰ� [������ �ð��� set]�Ͻ� �� 2���� Getter�� �Ű������� �޾��ּ���
    
}
