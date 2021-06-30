package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public ArrayList<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        if (this.stations.contains(station)) {
            // 에러 상황! --> 추가하려는 역이 이미 해당 노선에 존재합니다.
            return;
        }
        // 양방향 추가
        stations.add(station);
        station.addLine(this);
    }

    public void removeStation(Station station) {
        if (!this.stations.contains(station)) {
            // 에러 상황! --> 삭제하려는 역이 해당 노선에 존재하지 않습니다.
            return;
        }
        // 양방향 삭제
        stations.remove(station);
        station.removeLine(this);
    }

}
