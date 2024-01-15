import java.util.Scanner;

class InstCnt {
	static int instNum = 0;

	public InstCnt() {
		instNum++;
		System.out.println("인스턴스 생성: " + instNum);
	}
}

//3.사용자에게 받은 문자열을 역순으로 화면에 출력하는 프로그램을 작성하시오.
//
//
//-scanner 함수와
//-string 함수의 charAt() 함수를 이용해 볼것
//
//입력:abcde
//출력:edcba

class ClassVar {
	public static void main(String[] args) {
		//String str = "123";
		
		StringBuilder stbuf = new StringBuilder(123);

		stbuf.append(45678);
		System.out.println(stbuf.toString());
		//System.out.println(stbuf);

//		stbuf.delete(0, 2);
//		System.out.println(stbuf.toString());
//
//		stbuf.replace(0, 3, "AB");
//		System.out.println(stbuf.toString());
//
//		stbuf.reverse();
//		System.out.println(stbuf.toString());
//
//		String sub = stbuf.substring(2, 4);
//		System.out.println(sub);

	}
}