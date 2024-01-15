class ImmutableString {
    public static void main(String[] args) {
        
    	String str6 = "가" + "나" + "다";
    	
    	System.out.println(str6);
    	
    	String str1 = "Simple String";
        String str2 = "Simple String";
        
        String str5 = "simple String";
        
        
        String str3 = new String("Simple String");
        String str4 = new String("Simple String");
        
        if(str3.equals(str1)) {
        	System.out.println("같은 글자 입니다.");
        }else {
        	System.out.println("다른 글자 입니다.");
        }
        	
        
        if(str1 == str5)
            System.out.println("트루 입니다.");
        else
            System.out.println("폴스 입니다.");
        
        if(str3 == str1)
            System.out.println("트루 입니다.");
        else
            System.out.println("폴스 입니다.");
        
        
        if(str1 == str2)
            System.out.println("str1과 str2는 동일 인스턴스 참조");
        else
            System.out.println("str1과 str2는 다른 인스턴스 참조");

        if(str3 == str4)
            System.out.println("str3과 str4는 동일 인스턴스 참조");
        else
            System.out.println("str3과 str4는 다른 인스턴스 참조");
    }
}