


/*숫자 하나 입력하고 '+' '-' '*' '/' 를 입력 받은후
다시 숫자를 입력받으면 계산한 결과를 출력하기*/


import java.util.*;

public class test_cal
    
{
	public static void main(String[] args) {
		double num1,num2,result;
		char operator;

		Scanner a = new Scanner(System.in);

		System.out.println("첫 번째 숫자를 입력해주세요");
		num1 = a.nextDouble();
		
		System.out.println("두 번째 숫자를 입력해주세요");
		num2 = a.nextDouble();

		System.out.println("연산 식을 입력해주세요(+,-,*,/)");
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
