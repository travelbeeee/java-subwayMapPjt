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

    public ArrayList<Station> getStations(){
        return stations;
    }

    // 추가 기능 구현
    public void addStation(Station station) { // 양방향 추가
        stations.add(station);
        station.addLine(this);
    }

    public void removeStation(Station station) { // 양방향 삭제
        stations.remove(station);
        station.removeLine(this);
    }

    public void addSection(Station station, int ind){
        if(stations.contains(stations)){
            Logger.error("이미 존재하는 구간입니다.");
            return;
        }
        if(stations.size() < ind){
            Logger.error("노선의 구간 수보다 큰 값입니다.");
            return;
        }
        stations.add(ind, station);
        Logger.info("구간이 등록되었습니다.");
    }
}
