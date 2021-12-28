package model;
/*  BAH Mamadou Lamine,SOW Papa Laye*/
import view.Observer;

public interface Observable {
    public void notifyAllObservers ();
    public void addObserver (Observer p);
}
