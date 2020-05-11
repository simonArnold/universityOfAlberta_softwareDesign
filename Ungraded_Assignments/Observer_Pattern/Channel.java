import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String channelName, status;

    public Channel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(status));
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

}