class NumberPrinter {
    private  int myNum = 0;

    static void showInt(int n){ 
        System.out.println(n); 
    }
    
    static void showDouble(double n) { 
        System.out.println(n); 
        //System.out.println(myNum);
        
    }

    void setMyNumber(int n) {  	
    	   	
        myNum = n;
        System.out.println(myNum);
    }

    void showMyNumber() {
        showInt(myNum);
    }    
}

class Circle2{
	
	double r;
	static NumberPrinter memberPrinter; //참조형
	String name = "원";
	
	
	public Circle2(double r) {
		this.r = r;
	}
	
	double getArea() {
		return r * r * Math.PI;
	}
	
	static double getStaticArea(double radius) {
		return radius * radius * Math.PI;
	}
	
}

class ClassMethod {
	
    public static void main(String[] args) {
    	
    	System.out.println(10);
    	
    	Circle2.memberPrinter.setMyNumber(10);
    	
        NumberPrinter.showInt(20);
        NumberPrinter np = new NumberPrinter();
        np.showDouble(3.15);
    
        np.setMyNumber(75);
        np.showMyNumber();
    }
}