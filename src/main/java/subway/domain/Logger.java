package subway.domain;

public class Logger {
    public void printInfoMessage(String message){
        System.out.println("[INFO] " + message);
    }

    public void printErrorMessage(String message){
        System.out.println("[ERROR] " + message);
    }
}
