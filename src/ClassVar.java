import java.util.Scanner;

class InstCnt {
	static int instNum = 0;

	public InstCnt() {
		instNum++;
		System.out.println("�ν��Ͻ� ����: " + instNum);
	}
}

//3.����ڿ��� ���� ���ڿ��� �������� ȭ�鿡 ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//
//-scanner �Լ���
//-string �Լ��� charAt() �Լ��� �̿��� ����
//
//�Է�:abcde
//���:edcba

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