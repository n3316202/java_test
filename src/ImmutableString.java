class ImmutableString {
    public static void main(String[] args) {
        
    	String str6 = "��" + "��" + "��";
    	
    	System.out.println(str6);
    	
    	String str1 = "Simple String";
        String str2 = "Simple String";
        
        String str5 = "simple String";
        
        
        String str3 = new String("Simple String");
        String str4 = new String("Simple String");
        
        if(str3.equals(str1)) {
        	System.out.println("���� ���� �Դϴ�.");
        }else {
        	System.out.println("�ٸ� ���� �Դϴ�.");
        }
        	
        
        if(str1 == str5)
            System.out.println("Ʈ�� �Դϴ�.");
        else
            System.out.println("���� �Դϴ�.");
        
        if(str3 == str1)
            System.out.println("Ʈ�� �Դϴ�.");
        else
            System.out.println("���� �Դϴ�.");
        
        
        if(str1 == str2)
            System.out.println("str1�� str2�� ���� �ν��Ͻ� ����");
        else
            System.out.println("str1�� str2�� �ٸ� �ν��Ͻ� ����");

        if(str3 == str4)
            System.out.println("str3�� str4�� ���� �ν��Ͻ� ����");
        else
            System.out.println("str3�� str4�� �ٸ� �ν��Ͻ� ����");
    }
}