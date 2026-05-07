package edu.hitsz.ui;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartMenu {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton easyMode;
    private JButton normalMode;
    private JButton hardMode;

    public StartMenu() {
        easyMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 绑定相应难度的背景
                try {
                    ImageManager.BACKGROUND_IMAGE = ImageIO.read(new File("src/images/bg.jpg"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                // 进入游戏界面
                Main.startGame("src/LeaderBoard/easy.txt");
            }
        });
        normalMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageManager.BACKGROUND_IMAGE = ImageIO.read(new File("src/images/bg3.jpg"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Main.startGame("src/LeaderBoard/normal.txt");
            }
        });
        hardMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageManager.BACKGROUND_IMAGE = ImageIO.read(new File("src/images/bg5.jpg"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Main.startGame("src/LeaderBoard/hard.txt");
            }
        });
    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }


}
