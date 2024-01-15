import java.util.Scanner;

public class Rock_Paper_Scissors {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			int i = 0;
			System.out.println("가위 바위 보 셋 중 하나를 입력하시오: ");
			String rps = sc.next(); // 가위 0, 바위 1, 보 2
			if (rps.equals("가위"))
				i = 0;
			else if (rps.equals("바위"))
				i = 1;
			else if (rps.equals("보"))
				i = 2;
			else {
				System.out.println("잘못입력하셨습니다. ");
				break;
			}
			int rnd = (int) (Math.random() * 3);
			if (rnd == 0)
				System.out.println("가위");
			else if (rnd == 1)
				System.out.println("바위");
			else
				System.out.println("보");
			if (i == 0) { // 사용자가 가위를 낸 경우
				if (rnd == 0)
					System.out.println("비겼습니다.");
				else if (rnd == 1)
					System.out.println("졌습니다.");
				else
					System.out.println("이겼습니다.");
			} else if (i == 1) { // 사용자가 바위를 낸 경우
				if (rnd == 0)
					System.out.println("이겼습니다.");
				else if (rnd == 1)
					System.out.println("비겼습니다.");
				else
					System.out.println("졌습니다.");
			} else { // 사용자가 보를 낸 경우
				if (rnd == 0)
					System.out.println("졌습니다.");
				else if (rnd == 1)
					System.out.println("이겼니다.");
				else
					System.out.println("비겼습니다.");
			}
			Scanner sc1 = new Scanner(System.in);
			System.out.println("게임을 계속하시겠습니까?(y/n)");
			String y_n = sc1.next();
			if ("n".compareToIgnoreCase(y_n) == 0)
				break;
		}
	}
}