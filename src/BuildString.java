class BuildString {
    public static void main(String[] args) {
    	//adfsdafasd
        StringBuilder stbuf = new StringBuilder("123");
        
        System.out.println("�ȳ��ϼ���");
        System.out.println("�ȳ��ϼ���");
        
        stbuf.append(45678);
        System.out.println(stbuf.toString());
        
        stbuf.delete(0, 2);
        System.out.println(stbuf.toString());
        
        stbuf.replace(0, 3, "AB");
        System.out.println(stbuf.toString());

        stbuf.reverse();
        System.out.println(stbuf.toString());

        String sub = stbuf.substring(2, 4);
        System.out.println(sub);
    }
}