import java.util.Scanner;

public class Chap3_16 {
	public static void main(String[] args) {
		String str[] = {"가위", "바위", "보"};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[컴퓨터와 가위 바위 보 게임]");
		System.out.println("종료 : \"종료\" 입력");
		
		boolean exit = true;
		
		while(exit) {
			System.out.print("가위 / 바위 / 보 >> ");
			String input = sc.nextLine();
			
			int n = (int)(Math.random()*3);
			
			switch(input) {
			case "가위":
				if (input.equals(str[n]) == true) { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("비겼습니다"); }
				else if (str[n].equals("바위")) { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("컴퓨터 승!"); }
				else { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("사용자 승!"); }
				break;
			case "바위":
				if (input.equals(str[n]) == true) { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("비겼습니다"); }
				else if (str[n].equals("보")) { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("컴퓨터 승!"); }
				else { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("사용자 승!"); }
				break;
			case "보":
				if (input.equals(str[n]) == true) { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("비겼습니다"); }
				else if (str[n].equals("가위")) { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("컴퓨터 승!"); }
				else { System.out.print("사용자 = " + input + ", 컴퓨터 = " + str[n] + ", "); System.out.println("사용자 승!"); }
				break;
			case "종료": System.out.println("종료..."); exit = false;
				break;
			default:
				System.out.println("다시 입력하세요...");
			}
		}
		
		sc.close();
	}
}