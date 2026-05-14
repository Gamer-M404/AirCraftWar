package edu.hitsz.observer;

public class FreezeTrigger extends AbstractObserver{
    @Override
    public void notifyResponders() {
        for(PropObserver responder : this.responders){
            responder.onFreezePicked();
        }
    }

    @Override
    public void trigger() {
        this.notifyResponders();
    }
}
