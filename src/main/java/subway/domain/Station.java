package subway.domain;

import java.util.ArrayList;

public class Station {
    private String name;
    private ArrayList<Line> lines = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Line> getLines(){
        return lines;
    }

    // 추가 기능 구현
    public void addLine(Line line) {
        this.lines.add(line);
    }

    public void removeLine(Line line) {
        this.lines.remove(line);
    }
}
