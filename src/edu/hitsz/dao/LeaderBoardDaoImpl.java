package edu.hitsz.dao;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class LeaderBoardDaoImpl implements LeaderBoardDao{
    private List<LeaderBoradItem> items;
    private static LeaderBoardDaoImpl singleImpl = new LeaderBoardDaoImpl();

    public LeaderBoardDaoImpl(){
        items = new LinkedList<>();
    }

    public static LeaderBoardDaoImpl getInstance(){
        return singleImpl;
    }

    @Override
    public void doAdd(LeaderBoradItem item) {
        // 插入新数据的时候，使用二分插入算法
        int target = 0;
        for(int l=0, r=this.items.size()-1;l<=r;){
            target = ((l + r) >> 1);
            if(item.getScore() > this.items.get(target).getScore()){
                // 大了，往左找
                r = target - 1;
            }else{
                // 小了，往右找
                l = target + 1;
            }
        }
        this.items.add(target, item);
    }

    @Override
    public void doDelete(LeaderBoradItem item) {
        this.items.remove(item);
    }

    @Override
    public List<LeaderBoradItem> getAllItems() {
        if(this.items.isEmpty()){
            return List.of();
        }
        return List.copyOf(this.items);
    }

    @Override
    public void showTheBoard() {
        System.out.println("************************************");
        System.out.println("                得分榜                ");
        System.out.println("************************************");
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("第" + (i+1) + "名:" + this.items.get(i).showInfo());
        }
    }

    @Override
    public void loadData(String path) {
        // 打开文件，然后依次读入条目
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = "";
            while((line = br.readLine()) != null && !line.isEmpty()){
                // 从line中解析出各个信息
                String[] infos = line.split(",");
                this.items.add(new LeaderBoradItem(infos[0], Integer.parseInt(infos[1]), infos[2]));
            }
        } catch (IndexOutOfBoundsException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveData(String path) {
        // 打开文件，然后依次写入条目
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (LeaderBoradItem item : this.items) {
                bw.write(item.showInfo());
                bw.newLine();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
