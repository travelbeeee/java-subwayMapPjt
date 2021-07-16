package subway;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        LineRepository lineRepository = new LineRepository();
        StationRepository stationRepository = new StationRepository();

        init(lineRepository, stationRepository);

        String choice;
    }

    private static void init(LineRepository lineRepository, StationRepository stationRepository) {
        String[] nameList = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        for (String s : nameList) {
            stationRepository.addStation(s);
        }
    }
}
