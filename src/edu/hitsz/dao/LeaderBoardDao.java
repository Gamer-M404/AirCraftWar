package edu.hitsz.dao;

import java.io.IOException;
import java.util.List;

public interface LeaderBoardDao {
    public abstract void doAdd(LeaderBoradItem item);
    public abstract void doDelete(LeaderBoradItem item);
    public abstract List<LeaderBoradItem> getAllItems();
    public abstract void showTheBoard();
    public abstract void loadData(String path);
    public abstract void saveData(String path) throws IOException;
}
