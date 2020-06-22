package alarm.cod;

import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("<알람 생성>");
		System.out.print("유효 기간(분) 입력: ");
		int time = scan.nextInt();
		System.out.print("반복 기간(분) 입력: ");
		int period = scan.nextInt();
		
		Timer_Ex alarm = new Timer_Ex(time, period);

	}
}
