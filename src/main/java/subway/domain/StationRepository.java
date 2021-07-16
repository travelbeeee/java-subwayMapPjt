package subway.domain;

import java.util.*;
import java.util.stream.Stream;

/**
 * 역 관리 관련된 모든 책임을 가진다.
 * 1) 역 등록
 * 2) 역 삭제
 * 3) 역 목록조회
 */
public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String name) {
        Optional<Station> duplicateStation = stations.stream().filter(s -> s.getName().equals(name)).findAny();
        if(duplicateStation.isPresent()) {
            Logger.error("이미 존재하는 지하철 역 이름입니다.");
            return;
        }
        if(name.length() < 2){
            Logger.error("역 이름은 2글자 이상입니다.");
            return;
        }
        stations.add(new Station(name));
        Logger.info("지하철 역이 등록되었습니다.");
    }

    public static boolean deleteStation(String name) {
        Optional<Station> deletedStation = findStationByName(name);
        if (deletedStation.isEmpty()) {
            Logger.error("존재하지 않는 지하철 역 이름입니다.");
            return false;
        }
        if(!deletedStation.get().getLines().isEmpty()){
            Logger.error("이미 노선에 등록된 역 입니다. 삭제가 불가능합니다.");
            return false;
        }
        stations.removeIf(s -> s.getName().equals(name));
        Logger.info("지하철 역을 삭제했습니다.");
        return true;
    }

    public static Optional<Station> findStationByName(String name){
        return stations.stream().filter(s -> s.getName().equals(name)).findFirst();
    }

}
