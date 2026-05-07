package edu.hitsz.ui;

import edu.hitsz.application.Game;
import edu.hitsz.application.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderBoardTable {
    private JPanel mainPanel;
    private JPanel topPane;
    private JScrollPane tableScrollPane;
    private JPanel bottomPane;
    private JTable leaderBoardTab;
    private JLabel modeName;
    private JButton deleteBottom;
    private JButton returnButton;
    private String dataBasePath;



    public LeaderBoardTable(String[][] tableData, String dataBasePath, String mode) {
        this.modeName.setText("难度:" + mode);
        modeName.setFont(new Font("黑体", Font.BOLD, 20));
        modeName.setPreferredSize(new Dimension(150, 50));
        this.dataBasePath = dataBasePath;
        String[] columnName = {"玩家", "得分", "时间"};

        DefaultTableModel model = new DefaultTableModel(tableData, columnName){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        leaderBoardTab.setModel(model);
        tableScrollPane.setViewportView(leaderBoardTab);
        deleteBottom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(model == null)   return;
                int row = leaderBoardTab.getSelectedRow();
                if(row == -1)   return;
                int result = JOptionPane.showConfirmDialog(deleteBottom, "是否删除这一条记录?");
                if(JOptionPane.YES_OPTION == result){
                    model.removeRow(row);
                }
                System.out.println(Game.leaderBoardDaoImpl.getDataSize());
                System.out.println(row);
                // 还要对应地在DAO里面删
                Game.leaderBoardDaoImpl.doDelete(row);
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 存回总榜
                Game.leaderBoardDaoImpl.saveData(dataBasePath);
                Game.leaderBoardDaoImpl.removeAll();
                // 要消除掉这个页面
                Main.cardJPanel.remove(mainPanel);
                Main.cardJPanel.revalidate();
                Main.cardJPanel.repaint();
                // 这里需要让页面回到菜单
                Main.cardLayout.show(Main.cardJPanel, "startMenu");
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }
}
