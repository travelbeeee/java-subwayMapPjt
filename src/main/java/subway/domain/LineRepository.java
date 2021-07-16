package subway.domain;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(String name, Station startStation, Station endStation) {
        Optional<Line> findLine = findLineByName(name);
        if (findLine.isPresent()) {
            Logger.error("이미 존재하는 노선 이름입니다.");
            return;
        }
        if(name.length() < 2){
            Logger.error("노선 이름은 2글자 이상이어야합니다.");
            return;
        }
        Line newLine = new Line(name);
        newLine.addStation(startStation); // 양방향 추가 
        newLine.addStation(endStation); // 양방향 추가
        lines.add(newLine);
    }

    public static boolean deleteLineByName(String name) {
        Optional<Line> findLine = findLineByName(name);
        if (findLine.isEmpty()) {
            Logger.error("존재하지 않는 노선입니다.");
            return false;
        }
        Line line = findLine.get();
        line.getStations().stream().forEach(s -> line.removeStation(s)); // 역에서도 노선을 삭제
        return lines.remove(line);
    }

    public static Optional<Line> findLineByName(String name){
        return lines.stream().filter(l -> l.getName().equals(name)).findAny();
    }

}
