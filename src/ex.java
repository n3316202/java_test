import java.util.Scanner;

public class Rock_Paper_Scissors {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			int i = 0;
			System.out.println("���� ���� �� �� �� �ϳ��� �Է��Ͻÿ�: ");
			String rps = sc.next(); // ���� 0, ���� 1, �� 2
			if (rps.equals("����"))
				i = 0;
			else if (rps.equals("����"))
				i = 1;
			else if (rps.equals("��"))
				i = 2;
			else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. ");
				break;
			}
			int rnd = (int) (Math.random() * 3);
			if (rnd == 0)
				System.out.println("����");
			else if (rnd == 1)
				System.out.println("����");
			else
				System.out.println("��");
			if (i == 0) { // ����ڰ� ������ �� ���
				if (rnd == 0)
					System.out.println("�����ϴ�.");
				else if (rnd == 1)
					System.out.println("�����ϴ�.");
				else
					System.out.println("�̰���ϴ�.");
			} else if (i == 1) { // ����ڰ� ������ �� ���
				if (rnd == 0)
					System.out.println("�̰���ϴ�.");
				else if (rnd == 1)
					System.out.println("�����ϴ�.");
				else
					System.out.println("�����ϴ�.");
			} else { // ����ڰ� ���� �� ���
				if (rnd == 0)
					System.out.println("�����ϴ�.");
				else if (rnd == 1)
					System.out.println("�̰�ϴ�.");
				else
					System.out.println("�����ϴ�.");
			}
			Scanner sc1 = new Scanner(System.in);
			System.out.println("������ ����Ͻðڽ��ϱ�?(y/n)");
			String y_n = sc1.next();
			if ("n".compareToIgnoreCase(y_n) == 0)
				break;
		}
	}
}