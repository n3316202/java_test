package java_test;
import java.util.Scanner;

class RspGame {
	private String rock = "바위"; // 바위 데이터
	private String scissor = "가위"; // 가위 데이터
	private String paper = "보"; // 보 데이터
	
	private int rockNum; // 바위 숫자 데이터
	private int scissorNum; // 가위 숫자 데이터
	private int paperNum; // 보 숫자 데이터
	private int rspNum; // 랜덤으로 컴퓨터가 내는 가위 바위 보 연산을 위한 숫자
	private int inputNum; // 입력 데이터를 숫자로 치환한 데이터
	
	private String input; // 입력 데이터
	private String rspCal; // 컴퓨터 가위 바위 보 텍스트 데이터

	private boolean answer = true; // boolean 값. 
	
	Scanner scRSP = new Scanner(System.in); // 키보드 입력을 받기 위한 Scanner
	
	// input 입력
	private void setInput(String input) { 
		this.input = input;		
	}

	// rspCal 데이터 입력 및 승리 적용 과정
	// rspNum : 컴퓨터가 내놓는 랜덤 값. 해당 값에 따라 가위 바위 보 텍스트를 rspCal에 넣는다.
	private void rspCal() {
		rspNum = (int)(Math.random()*3); // 0 이상 3 미만 정수 뽑기
		switch(rspNum){ 		
			case 0 :	// 0이면 바위
				rspCal = rock; // 바위 텍스트값 
                // 가위 바위 보 승리 여부를 판단하기 위해 각각의 Num에 수치 대입
				rockNum =  0;  // rspNum이랑 동일
				scissorNum = -1;
				paperNum = 1; 
				break;
			case 1 :	// 1이면 가위
				rspCal = scissor; // 가위 텍스트값 
                // 가위 바위 보 승리 여부를 판단하기 위해 각각의 Num에 수치 대입
				rockNum = 2; 
				scissorNum = 1; // rspNum이랑 동일
				paperNum = 0;
				break;
			case 2 :	// 2이면 보. 3미만이므로 3은 포함안됨.
				rspCal = paper; // 보 텍스트값 
                // 가위 바위 보 승리 여부를 판단하기 위해 각각의 Num에 수치 대입
				rockNum = 1;
				scissorNum = 3;
				paperNum = 2; // rspNum이랑 동일
				break;
		}
		System.out.println(rspCal);		// 연산 결과 보여주기
		inputCal(input);				
        // input 데이터 기반 inputNum 수치 대입 및 rspNum과의 크기 비교
	}
	
	// 가위 바위 보 승리 판단 과정. 
    // input 데이터를 기반으로 inputNum 수치 대입, rspNum과의 크기 비교를 통한 문구 출력 
	private void inputCal(String input) {
		switch(input){ 		
		case "바위" :	// "바위" 텍스트이면 
			inputNum = rockNum;
			break;
		case "가위" :	// "가위" 텍스트이면 
			inputNum = scissorNum;
			break;
		case "보" :	// "보" 텍스트이면 
			inputNum = paperNum;
			break;
		}
		
		if(inputNum > rspNum) {
			System.out.println("이겼습니다."); 
		}else if(inputNum == rspNum) {
			System.out.println("비겼습니다."); 
		}else if(inputNum < rspNum) {
			System.out.println("졌습니다.");
		}
	}

	
	// 반드시 시작하는 메서드. 강제로 가위 바위 보를 실행시킬 수 있다. 
	public void mustStart() {  
		System.out.println("가위 바위 보 게임을 시작합니다.");
		startEnd(answer);	// answer의 초기값은 true이므로 실행문 조건을 진행한다.
	}
	
	// if와 do while 방식으로 구현. 
    // Y,y,N,n 이외 다른 문자나 텍스트를 입력 시 재시작 과정 재돌입.
	// -> if 와 for문으로 수정해보기. 
	// 텍스트 입력값이 Y,y,N,n일 때만 주사위 게임 진행 함수 호출.
    // -> switch case문으로 수정 	
	// -> compareToIgnoreCase()를 통해 조건을 간단히 표현하고 if문으로 표현
	private void startEnd(String yes) {
		if(yes.compareToIgnoreCase("y") == 0) {
			answer = true;
			startEnd(answer); // 진행
		}else if(yes.compareToIgnoreCase("N") == 0) {
			answer = false;
			startEnd(answer); // 미진행
		}else {
			System.out.println("잘못 입력하셨습니다.");
			rspContinue();
		}
	}
	
	// 시작 여부 체크, 플레이 진행하는 함수. answer 값에 따라 플레이와 종료를 구분한다.
	private void startEnd(Boolean answer) {
		if(answer == false) { // 값이 false 라면 플레이 중지 
			System.out.println("프로그램을 종료합니다.");
			return;
		}else{				  // 값이 true 라면 플레이 실행
			System.out.println("가위, 바위, 보 중 하나를 입력하세요.");
			String rsp = scRSP.next();
			setInput(rsp);		// 입력값 세팅하기
			if(rsp.equals(rock)||rsp.equals(scissor)||rsp.equals(paper)) {
            // 가위, 바위, 보를 제대로 입력했을 때
				rspCal();					// 랜덤값 연산 결과 뽑아내기
				rspContinue();				// 재시작 여부 체크// 재시작 여부 체크
			}else { // 가위 , 바위, 보를 제대로 입력하지 않으면 재시작 여부만 묻는다.
				System.out.println("가위, 바위, 보 중 하나만 입력하셔야 합니다."); 
                // 오류 메세지 출력 
				rspContinue();				// 재시작 여부 체크
			}
		}
	}
	
	// (가위 바위 보 계속 이어서 할 것인가? 아닌가) 재시작 여부를 체크하는 재시작 함수
	private void rspContinue() {
		System.out.println("계속하시겠습니까?(Y/N)"); // 재시작 여부 체크 텍스트
		String yn = scRSP.next(); // 입력값
		startEnd(yn); // 진행 함수 호출
	}
}
