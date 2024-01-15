package java_test;
import java.util.Scanner;

class RspGame {
	private String rock = "����"; // ���� ������
	private String scissor = "����"; // ���� ������
	private String paper = "��"; // �� ������
	
	private int rockNum; // ���� ���� ������
	private int scissorNum; // ���� ���� ������
	private int paperNum; // �� ���� ������
	private int rspNum; // �������� ��ǻ�Ͱ� ���� ���� ���� �� ������ ���� ����
	private int inputNum; // �Է� �����͸� ���ڷ� ġȯ�� ������
	
	private String input; // �Է� ������
	private String rspCal; // ��ǻ�� ���� ���� �� �ؽ�Ʈ ������

	private boolean answer = true; // boolean ��. 
	
	Scanner scRSP = new Scanner(System.in); // Ű���� �Է��� �ޱ� ���� Scanner
	
	// input �Է�
	private void setInput(String input) { 
		this.input = input;		
	}

	// rspCal ������ �Է� �� �¸� ���� ����
	// rspNum : ��ǻ�Ͱ� ������ ���� ��. �ش� ���� ���� ���� ���� �� �ؽ�Ʈ�� rspCal�� �ִ´�.
	private void rspCal() {
		rspNum = (int)(Math.random()*3); // 0 �̻� 3 �̸� ���� �̱�
		switch(rspNum){ 		
			case 0 :	// 0�̸� ����
				rspCal = rock; // ���� �ؽ�Ʈ�� 
                // ���� ���� �� �¸� ���θ� �Ǵ��ϱ� ���� ������ Num�� ��ġ ����
				rockNum =  0;  // rspNum�̶� ����
				scissorNum = -1;
				paperNum = 1; 
				break;
			case 1 :	// 1�̸� ����
				rspCal = scissor; // ���� �ؽ�Ʈ�� 
                // ���� ���� �� �¸� ���θ� �Ǵ��ϱ� ���� ������ Num�� ��ġ ����
				rockNum = 2; 
				scissorNum = 1; // rspNum�̶� ����
				paperNum = 0;
				break;
			case 2 :	// 2�̸� ��. 3�̸��̹Ƿ� 3�� ���Ծȵ�.
				rspCal = paper; // �� �ؽ�Ʈ�� 
                // ���� ���� �� �¸� ���θ� �Ǵ��ϱ� ���� ������ Num�� ��ġ ����
				rockNum = 1;
				scissorNum = 3;
				paperNum = 2; // rspNum�̶� ����
				break;
		}
		System.out.println(rspCal);		// ���� ��� �����ֱ�
		inputCal(input);				
        // input ������ ��� inputNum ��ġ ���� �� rspNum���� ũ�� ��
	}
	
	// ���� ���� �� �¸� �Ǵ� ����. 
    // input �����͸� ������� inputNum ��ġ ����, rspNum���� ũ�� �񱳸� ���� ���� ��� 
	private void inputCal(String input) {
		switch(input){ 		
		case "����" :	// "����" �ؽ�Ʈ�̸� 
			inputNum = rockNum;
			break;
		case "����" :	// "����" �ؽ�Ʈ�̸� 
			inputNum = scissorNum;
			break;
		case "��" :	// "��" �ؽ�Ʈ�̸� 
			inputNum = paperNum;
			break;
		}
		
		if(inputNum > rspNum) {
			System.out.println("�̰���ϴ�."); 
		}else if(inputNum == rspNum) {
			System.out.println("�����ϴ�."); 
		}else if(inputNum < rspNum) {
			System.out.println("�����ϴ�.");
		}
	}

	
	// �ݵ�� �����ϴ� �޼���. ������ ���� ���� ���� �����ų �� �ִ�. 
	public void mustStart() {  
		System.out.println("���� ���� �� ������ �����մϴ�.");
		startEnd(answer);	// answer�� �ʱⰪ�� true�̹Ƿ� ���๮ ������ �����Ѵ�.
	}
	
	// if�� do while ������� ����. 
    // Y,y,N,n �̿� �ٸ� ���ڳ� �ؽ�Ʈ�� �Է� �� ����� ���� �絹��.
	// -> if �� for������ �����غ���. 
	// �ؽ�Ʈ �Է°��� Y,y,N,n�� ���� �ֻ��� ���� ���� �Լ� ȣ��.
    // -> switch case������ ���� 	
	// -> compareToIgnoreCase()�� ���� ������ ������ ǥ���ϰ� if������ ǥ��
	private void startEnd(String yes) {
		if(yes.compareToIgnoreCase("y") == 0) {
			answer = true;
			startEnd(answer); // ����
		}else if(yes.compareToIgnoreCase("N") == 0) {
			answer = false;
			startEnd(answer); // ������
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			rspContinue();
		}
	}
	
	// ���� ���� üũ, �÷��� �����ϴ� �Լ�. answer ���� ���� �÷��̿� ���Ḧ �����Ѵ�.
	private void startEnd(Boolean answer) {
		if(answer == false) { // ���� false ��� �÷��� ���� 
			System.out.println("���α׷��� �����մϴ�.");
			return;
		}else{				  // ���� true ��� �÷��� ����
			System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ���.");
			String rsp = scRSP.next();
			setInput(rsp);		// �Է°� �����ϱ�
			if(rsp.equals(rock)||rsp.equals(scissor)||rsp.equals(paper)) {
            // ����, ����, ���� ����� �Է����� ��
				rspCal();					// ������ ���� ��� �̾Ƴ���
				rspContinue();				// ����� ���� üũ// ����� ���� üũ
			}else { // ���� , ����, ���� ����� �Է����� ������ ����� ���θ� ���´�.
				System.out.println("����, ����, �� �� �ϳ��� �Է��ϼž� �մϴ�."); 
                // ���� �޼��� ��� 
				rspContinue();				// ����� ���� üũ
			}
		}
	}
	
	// (���� ���� �� ��� �̾ �� ���ΰ�? �ƴѰ�) ����� ���θ� üũ�ϴ� ����� �Լ�
	private void rspContinue() {
		System.out.println("����Ͻðڽ��ϱ�?(Y/N)"); // ����� ���� üũ �ؽ�Ʈ
		String yn = scRSP.next(); // �Է°�
		startEnd(yn); // ���� �Լ� ȣ��
	}
}
