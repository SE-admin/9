


/*���� �ϳ� �Է��ϰ� '+' '-' '*' '/' �� �Է� ������
�ٽ� ���ڸ� �Է¹����� ����� ����� ����ϱ�*/


import java.util.*;

public class test_cal
    
{
	public static void main(String[] args) {
		double num1,num2,result;
		char operator;

		Scanner a = new Scanner(System.in);

		System.out.println("ù ��° ���ڸ� �Է����ּ���");
		num1 = a.nextDouble();
		
		System.out.println("�� ��° ���ڸ� �Է����ּ���");
		num2 = a.nextDouble();

		System.out.println("���� ���� �Է����ּ���(+,-,*,/)");
		operator = a.next().charAt(0);

		switch(operator){

		case '+' : result=num1+num2;
		System.out.println(result);
		break;

		case '-' : result=num1-num2;
		System.out.println(result);
		break;

		case '*' : result=num1*num2;
		System.out.println(result);
		break;

		case '/' : result=num1/num2;
		System.out.println(result);
		break;

		default: System.out.println("error");
		break;
		}
	}
}