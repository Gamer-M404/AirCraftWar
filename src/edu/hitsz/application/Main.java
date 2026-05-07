package edu.hitsz.application;

import edu.hitsz.dao.LeaderBoradItem;
import edu.hitsz.ui.LeaderBoardTable;
import edu.hitsz.ui.StartMenu;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 程序入口
 * @author hitsz
 */
public class Main {

    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;

    // 设置页面切换容器
    public static CardLayout cardLayout;
    public static JPanel cardJPanel;

    // 当前在运行的唯一游戏实例
    public static Game currentGame = null;

    public static void startGame(String dataPath){
        // 如果之前currentGame中有残存，把它清除掉
        if(currentGame != null){
            cardJPanel.remove(currentGame);
        }
        // 创建新游戏
        currentGame = new Game();
        currentGame.setDataPath(dataPath);
        // 设置游戏结束要执行的逻辑
        currentGame.setOnGameOver(Main::endGame);
        // 把新游戏装进页面容器中
        cardJPanel.add("game", currentGame);
        // 启动游戏
        cardLayout.show(cardJPanel, "game");
        currentGame.action();
    }

    public static void endGame(){
        String dataBasePath = currentGame.getDataPath();
        String[] tmp = dataBasePath.split("/");
        String mode = firstCharUpper(tmp[tmp.length - 1].replace(".txt", ""));
        // 读取历史得分榜并打印
        Game.leaderBoardDaoImpl.loadData(dataBasePath);
        // 格式化时间
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("MM-dd HH:mm");
        String now = LocalDateTime.now().format(formatter);
        // 创建当局比赛的条目
        LeaderBoradItem item = new LeaderBoradItem("Unknown", currentGame.getScore(), now);
        System.out.println(item.showInfo());
        Game.leaderBoardDaoImpl.doAdd(item);
        // 打印得分榜
        Game.leaderBoardDaoImpl.showTheBoard();
        // 从txt中读数据到table中，然后做展示
        LeaderBoardTable leaderBoardTable = new LeaderBoardTable(Game.leaderBoardDaoImpl.toStringData(), dataBasePath, mode);
        cardJPanel.add("rank", leaderBoardTable.getMainPanel());
        // 切换到rank界面
        cardLayout.show(cardJPanel, "rank");
        // 销毁游戏用例
        if(currentGame != null){
            cardJPanel.remove(currentGame);
            currentGame = null;
        }
        cardJPanel.revalidate();
        cardJPanel.repaint();
    }

    public static void main(String[] args) {

        System.out.println("Hello Aircraft War");

        // 获得屏幕的分辨率，初始化 Frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Aircraft War");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setResizable(false);
        //设置窗口的大小和位置,居中放置
        frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, 0,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardJPanel = new JPanel(cardLayout);

        StartMenu startMenu = new StartMenu();


        cardJPanel.add("startMenu", startMenu.getMainPanel());
        frame.add(cardJPanel);
        cardLayout.show(cardJPanel,"startMenu");
        frame.setVisible(true);
//        Game game = new Game();
//        frame.add(game);
//        frame.setVisible(true);
//        game.action();
    }



    public static String firstCharUpper(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}



