
class Car {
	public Car() {
		System.out.println("차 입니다.");
	}

}

class UpDown{
	int num =0 ;
	
	void up1(int num) {
		this.num += num;
		System.out.println(num);
	}
	
	void up2(int num,int num2) {
		this.num += (num + num2);
		System.out.println(this.num);
	}
	
	void up3(double num) {
		this.num += num;
		System.out.println(num);
	}
	

	
	void up(String str1,String str2) {		
		System.out.println(num + str1 + str2 );
	}
	
	void upDouble(double num) {
		this.num += num;
		System.out.println(num);
	}
	
	void simple(int p1,char p2) {
		System.out.println(p2);
	}
	
	void simple(int p1,int p2) {
		System.out.println("111111111");
	}
	
	void simple(int p1,double p2) {
		System.out.println(p2);
		System.out.println("22222222");
	}
}

public class CarTest{
	public static void main(String[] args) {
		UpDown up = new UpDown();
		
		up.simple(7, 'A');
		
		up.up("AAA","BBB");
		
		
	}
} 