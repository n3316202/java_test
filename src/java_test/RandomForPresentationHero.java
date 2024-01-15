package java_test;


//
// 코드
//

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.*;

class RandomForPresentationHero {
    private final static String[] STUDENTS = {"jk", "김동욱", "류승엽", "성준", "소원준", "신우", "안준섭", "은솔", "정yo", "정재원", "정혁준", "지연", "천도복숭아"};      //카톡의 이름정렬을 그대로 가져왔습니다.
    private final static String STR_SITUATION_REMOVE = "알겠습니다. 그렇다면 명단에서 빼겠습니다.\n";
    private final static String STR_SITUATION_THANK = "감사합니다. ";
    private final static String STR_SITUATION_OK = "알겠습니다. ";
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
                case "네": case "예": case "yes": case "y": case "ㅇ": case "ㅇㅇ": case "어": case "어어": case "응": case "그래": {
                    asking = false;
                    yn = true;
                    break;
                }
                case "아니오": case "아니요": case "아뇨": case "아닙니다": case "no": case "n": case "ㄴ": case "ㄴㄴ": case "아니": {
                    asking = false;
                    yn =  false;
                    break;
                }
                default: {
                    print.append(answer);
                    print.append("\n...? 다시 한번 말씀해주시겠습니까?(y/n): ");
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
        
        print.append("이번 프로젝트는 2명이 발표하게 될 예정입니다. 먼저 선착순으로 2명을 모으겠습니다. 발표를 희망하시는 분의 카톡닉네임을 입력해주시길 바랍니다.(x로 탈출): ");
        System.out.print(print);
        print.setLength(0);
        
        boolean enoughHero = true;
        while ((speakersNeeded > 0) && enoughHero) {
            String hero = (scanner.nextLine().replaceAll("\\s+","")).toLowerCase();
            
            switch (hero) {
                case "jk": case "김동욱": case "류승엽": case "성준": case "소원준": case "신우": case "안준섭": case "은솔": case "정yo": case "정재원": case "정혁준": case "지연": case "천도복숭아":{
                    print.append(STR_SITUATION_THANK);
                    print.append(hero);
                    print.append("님 잘 부탁드립니다. ");
                    speakersNeeded--;
                    
                    heroes.add(hero);
                    studentsListFromArray.remove(hero);
                    
                    if (speakersNeeded == 1) {
                        print.append("이제 한명만 더 있으면 됩니다. 지원하실 분 있습니까?(x로 탈출): ");
                    } else {
                        print.append("이제 추첨을 돌릴 필요도 없습니다. 응원하겠습니다.");
                    };
                    print.append(STR_SITUATION_BR);
                    break;
                }
                case "x": case "exit": case "없음": {
                    print.append("없으면 추첨을 돌리겠습니다.");
                    print.append(STR_SITUATION_BR);
                    enoughHero = false;
                    break;
                }
                default: {
                    print.append(hero);
                    print.append("...? 다시 한번 말씀해주시겠습니까?(x로 탈출): ");
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
                    print.append("님께서는 오늘 나오셨습니까?(y/n): ");
                    
                    System.out.print(print);
                    print.setLength(0);
                    
                    boolean answerAttendance = yesOrNo();
                    
                    if (answerAttendance) {
                        studentsList.add(aStudent);
                        print.append(STR_SITUATION_OK);
                        print.append(aStudent);
                        print.append("님은 발표후보자입니다. 추첨을 통해 당첨되시면 이번 과제 발표를 하시게 됩니다.");
                        print.append(STR_SITUATION_BR);
                    } else {
                        print.append(STR_SITUATION_REMOVE);
                        print.append("\n");
                    };
                };
            };
            
            studentsHowMany = studentsList.size();
            
            print.append("현재 발표후보자는 ");
            
            if (studentsHowMany == 0) {
                
                print.append("없습니다.\n사람이 없으니 추첨을 할 수 없습니다.");
                
                System.out.print(print);
                print.setLength(0);
                print.append(STR_SITUATION_BR);
                break;
            } else {
                for (int i = 0; i < studentsHowMany; i++) {
                    print.append(studentsList.get(i));
                    
                    if (i != (studentsHowMany - 1)) {
                        print.append("님, ");
                    } else {
                        print.append("님으로 총 ");
                        print.append(studentsHowMany);
                        print.append("명입니다.");
                    };
                };
                
                print.append(STR_SITUATION_BR);
                print.append("아무키나 입력하시면 추첨이 시작됩니다: ");
                System.out.print(print);
                print.setLength(0);
                print.append(STR_SITUATION_BR);
                
                scanner.nextLine();

                int randomIndex = ThreadLocalRandom.current().nextInt(0, studentsHowMany);
                
                String winner = studentsList.get(randomIndex);
                print.append(100. / (double)studentsHowMany);
                print.append("%의 확률로 ");
                print.append(winner);
                print.append("님이 당첨되셨습니다. 축하드립니다.");
                
                studentsList.remove(winner);
                
                print.append(STR_SITUATION_BR);
                print.append("프로젝트는 하셨습니까?(y/n): ");
                System.out.print(print);
                print.setLength(0);
                boolean answerProject = yesOrNo();
                if (answerProject) {
                    print.append(STR_SITUATION_OK);
                    print.append("그렇다면 발표준비는 되셨습니까?(y/n): ");
                    System.out.print(print);
                    print.setLength(0);
                    
                    boolean answerPresentation = yesOrNo();
                    
                    if (answerPresentation) {
                        print.append(STR_SITUATION_OK);
                        print.append("그렇다면 컨티션은 괜찮으십니까?(y/n): ");
                        System.out.print(print);
                        print.setLength(0);
                        boolean answerState = yesOrNo();
                        if (answerState) {
                            print.append(STR_SITUATION_OK);
                            print.append("그럼 명단에 올리겠습니다.");
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
                print.append("님과 ");
            } else {
                print.append(heroes.get(i));
                print.append("님은 발표해주시길 바랍니다. ");
                print.append(STR_SITUATION_THANK);
            };
        };
        print.append(STR_SITUATION_BR);
        System.out.print(print);
        print.setLength(0);
    }
}