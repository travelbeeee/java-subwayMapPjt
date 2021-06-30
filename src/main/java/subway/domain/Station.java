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

    // 추가 기능 구현
}
