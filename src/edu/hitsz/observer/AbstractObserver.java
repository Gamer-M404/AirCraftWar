package edu.hitsz.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObserver {
    protected List<PropObserver> responders = new ArrayList<>();
    public void addResponders(PropObserver responder){
        this.responders.add(responder);
    }

    public void deleteResponder(PropObserver responder){
        this.responders.remove(responder);
    }

    public abstract void notifyResponders();
    public abstract void trigger();
}
