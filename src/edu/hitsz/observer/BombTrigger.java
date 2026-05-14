package edu.hitsz.observer;

public class BombTrigger extends AbstractObserver{
    @Override
    public void notifyResponders() {
        // 轮询通知所有响应者
        for(PropObserver responder : this.responders){
            responder.onBombPicked();
        }
    }

    @Override
    public void trigger() {
        this.notifyResponders();
    }
}
