package alarm.cod;

import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("<�˶� ����>");
		System.out.print("��ȿ �Ⱓ(��) �Է�: ");
		int time = scan.nextInt();
		System.out.print("�ݺ� �Ⱓ(��) �Է�: ");
		int period = scan.nextInt();
		
		Timer_Ex alarm = new Timer_Ex(time, period);

	}
}
