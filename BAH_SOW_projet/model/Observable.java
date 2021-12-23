package model;
import view.Observer;

public interface Observable {
    public void notifyAllObservers ();
    public void addObserver (Observer p);
}
