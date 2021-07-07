package subway;

import subway.domain.LineRepository;
import subway.domain.Logger;
import subway.domain.StationRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        LineRepository lineRepository = new LineRepository();
        StationRepository stationRepository = new StationRepository();
        Logger logger = new Logger();
        String choice;

        while(true){
            System.out.println("## 메인 화면");
            System.out.println("1. 역 관리");
            System.out.println("2. 노선 관리");
            System.out.println("3. 구간 관리");
            System.out.println("4. 지하철 노선도 출력");
            System.out.println("Q 종료");
            System.out.println();
            System.out.println("## 원하는 기능을 선택하세요.");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.println("## 구간 관리 화면");
                System.out.println("1. 구간 등록");
                System.out.println("2. 구간 삭제");
                System.out.println("B. 돌아가기");
                System.out.println();
                System.out.println("## 원하는 기능을 선택하세요.");
                choice = scanner.nextLine();
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {

            } else if (choice.equals("4")) {

            } else if (choice.equals("Q")) {
                break;
            }
        }
    }
}
