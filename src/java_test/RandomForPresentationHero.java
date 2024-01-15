package java_test;


//
// �ڵ�
//

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.*;

class RandomForPresentationHero {
    private final static String[] STUDENTS = {"jk", "�赿��", "���¿�", "����", "�ҿ���", "�ſ�", "���ؼ�", "����", "��yo", "�����", "������", "����", "õ��������"};      //ī���� �̸������� �״�� �����Խ��ϴ�.
    private final static String STR_SITUATION_REMOVE = "�˰ڽ��ϴ�. �׷��ٸ� ��ܿ��� ���ڽ��ϴ�.\n";
    private final static String STR_SITUATION_THANK = "�����մϴ�. ";
    private final static String STR_SITUATION_OK = "�˰ڽ��ϴ�. ";
    private final static String STR_SITUATION_BR = "\n\n";
    
    private static int speakersNeeded = 2;

    private static boolean yesOrNo() {
        //Scanner scanner = new Scanner(System.in, "Cp949");
        Scanner scanner = new Scanner(System.in);
        StringBuilder print = new StringBuilder();
        boolean yn = false;
        
        boolean asking = true;
        while(asking) {
            String answer = (scanner.nextLine().replaceAll("\\s+","")).toLowerCase();
            switch (answer) {
                case "��": case "��": case "yes": case "y": case "��": case "����": case "��": case "���": case "��": case "�׷�": {
                    asking = false;
                    yn = true;
                    break;
                }
                case "�ƴϿ�": case "�ƴϿ�": case "�ƴ�": case "�ƴմϴ�": case "no": case "n": case "��": case "����": case "�ƴ�": {
                    asking = false;
                    yn =  false;
                    break;
                }
                default: {
                    print.append(answer);
                    print.append("\n...? �ٽ� �ѹ� �������ֽðڽ��ϱ�?(y/n): ");
                    System.out.print(print);
                }
            };
        };
        return yn;
    }
    
    public static void main(String[] args) {
        List<String> studentsListFromArray = new ArrayList<String>();
        List<String> heroes = new ArrayList<String>();
        
        int studentsHowMany = STUDENTS.length;
        
        for (int i = 0; i < studentsHowMany; i++) {
            studentsListFromArray.add(STUDENTS[i]);
        };
        
        //Scanner scanner = new Scanner(System.in, "Cp949");
        Scanner scanner = new Scanner(System.in);
        
        StringBuilder print = new StringBuilder();
        
        print.append("�̹� ������Ʈ�� 2���� ��ǥ�ϰ� �� �����Դϴ�. ���� ���������� 2���� �����ڽ��ϴ�. ��ǥ�� ����Ͻô� ���� ī��г����� �Է����ֽñ� �ٶ��ϴ�.(x�� Ż��): ");
        System.out.print(print);
        print.setLength(0);
        
        boolean enoughHero = true;
        while ((speakersNeeded > 0) && enoughHero) {
            String hero = (scanner.nextLine().replaceAll("\\s+","")).toLowerCase();
            
            switch (hero) {
                case "jk": case "�赿��": case "���¿�": case "����": case "�ҿ���": case "�ſ�": case "���ؼ�": case "����": case "��yo": case "�����": case "������": case "����": case "õ��������":{
                    print.append(STR_SITUATION_THANK);
                    print.append(hero);
                    print.append("�� �� ��Ź�帳�ϴ�. ");
                    speakersNeeded--;
                    
                    heroes.add(hero);
                    studentsListFromArray.remove(hero);
                    
                    if (speakersNeeded == 1) {
                        print.append("���� �Ѹ� �� ������ �˴ϴ�. �����Ͻ� �� �ֽ��ϱ�?(x�� Ż��): ");
                    } else {
                        print.append("���� ��÷�� ���� �ʿ䵵 �����ϴ�. �����ϰڽ��ϴ�.");
                    };
                    print.append(STR_SITUATION_BR);
                    break;
                }
                case "x": case "exit": case "����": {
                    print.append("������ ��÷�� �����ڽ��ϴ�.");
                    print.append(STR_SITUATION_BR);
                    enoughHero = false;
                    break;
                }
                default: {
                    print.append(hero);
                    print.append("...? �ٽ� �ѹ� �������ֽðڽ��ϱ�?(x�� Ż��): ");
                }
            };
            System.out.print(print);
            print.setLength(0);
        };
        
        studentsHowMany = studentsListFromArray.size();
        
        List<String> studentsList = new ArrayList<String>();
        boolean firstCheck = true;
        
        while (speakersNeeded > 0) {
            
            if (firstCheck) {
                firstCheck = false;
                for (int i = 0; i < studentsHowMany; i++) {
                    String aStudent = studentsListFromArray.get(i);
                    
                    print.append(aStudent);
                    print.append("�Բ����� ���� �����̽��ϱ�?(y/n): ");
                    
                    System.out.print(print);
                    print.setLength(0);
                    
                    boolean answerAttendance = yesOrNo();
                    
                    if (answerAttendance) {
                        studentsList.add(aStudent);
                        print.append(STR_SITUATION_OK);
                        print.append(aStudent);
                        print.append("���� ��ǥ�ĺ����Դϴ�. ��÷�� ���� ��÷�ǽø� �̹� ���� ��ǥ�� �Ͻð� �˴ϴ�.");
                        print.append(STR_SITUATION_BR);
                    } else {
                        print.append(STR_SITUATION_REMOVE);
                        print.append("\n");
                    };
                };
            };
            
            studentsHowMany = studentsList.size();
            
            print.append("���� ��ǥ�ĺ��ڴ� ");
            
            if (studentsHowMany == 0) {
                
                print.append("�����ϴ�.\n����� ������ ��÷�� �� �� �����ϴ�.");
                
                System.out.print(print);
                print.setLength(0);
                print.append(STR_SITUATION_BR);
                break;
            } else {
                for (int i = 0; i < studentsHowMany; i++) {
                    print.append(studentsList.get(i));
                    
                    if (i != (studentsHowMany - 1)) {
                        print.append("��, ");
                    } else {
                        print.append("������ �� ");
                        print.append(studentsHowMany);
                        print.append("���Դϴ�.");
                    };
                };
                
                print.append(STR_SITUATION_BR);
                print.append("�ƹ�Ű�� �Է��Ͻø� ��÷�� ���۵˴ϴ�: ");
                System.out.print(print);
                print.setLength(0);
                print.append(STR_SITUATION_BR);
                
                scanner.nextLine();

                int randomIndex = ThreadLocalRandom.current().nextInt(0, studentsHowMany);
                
                String winner = studentsList.get(randomIndex);
                print.append(100. / (double)studentsHowMany);
                print.append("%�� Ȯ���� ");
                print.append(winner);
                print.append("���� ��÷�Ǽ̽��ϴ�. ���ϵ帳�ϴ�.");
                
                studentsList.remove(winner);
                
                print.append(STR_SITUATION_BR);
                print.append("������Ʈ�� �ϼ̽��ϱ�?(y/n): ");
                System.out.print(print);
                print.setLength(0);
                boolean answerProject = yesOrNo();
                if (answerProject) {
                    print.append(STR_SITUATION_OK);
                    print.append("�׷��ٸ� ��ǥ�غ�� �Ǽ̽��ϱ�?(y/n): ");
                    System.out.print(print);
                    print.setLength(0);
                    
                    boolean answerPresentation = yesOrNo();
                    
                    if (answerPresentation) {
                        print.append(STR_SITUATION_OK);
                        print.append("�׷��ٸ� ��Ƽ���� �������ʴϱ�?(y/n): ");
                        System.out.print(print);
                        print.setLength(0);
                        boolean answerState = yesOrNo();
                        if (answerState) {
                            print.append(STR_SITUATION_OK);
                            print.append("�׷� ��ܿ� �ø��ڽ��ϴ�.");
                            System.out.print(print);
                            print.setLength(0);
                            
                            speakersNeeded--;
                            heroes.add(winner);
                        } else {
                            print.append(STR_SITUATION_REMOVE);
                        };
                    } else {
                        print.append(STR_SITUATION_REMOVE);
                    };
                } else {
                    print.append(STR_SITUATION_REMOVE);
                };
                System.out.print(print);
                print.setLength(0);
                print.append(STR_SITUATION_BR);
            };
        };
        scanner.close();
        
        int sizeHeroes = heroes.size();
        
        for (int i = 0; i < sizeHeroes; i++) {
            if (i != sizeHeroes - 1) {
                print.append(heroes.get(i));
                print.append("�԰� ");
            } else {
                print.append(heroes.get(i));
                print.append("���� ��ǥ���ֽñ� �ٶ��ϴ�. ");
                print.append(STR_SITUATION_THANK);
            };
        };
        print.append(STR_SITUATION_BR);
        System.out.print(print);
        print.setLength(0);
    }
}