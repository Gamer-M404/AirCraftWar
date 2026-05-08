package edu.hitsz.music;

import edu.hitsz.prop.PropBlood;

import java.util.HashMap;

public class MusicManager {
    private static BgmPlayer bgm;

    public MusicManager(){}

    public static void setBgm(String filename, boolean isLoop){
        bgm = new BgmPlayer(filename, isLoop);
    }

    public static void playBgm(){
        try {
            bgm.start();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public static void stopBgm(){
        try {
            bgm.setLoop(false);
            bgm.setStop(true);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public static void continueBgm(){
        try {
            bgm.setLoop(true);
            bgm.setStop(false);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public static void playSound(String filename){
        try {
            SoundPlayer sound = new SoundPlayer(filename);
            sound.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
