package com.dao;

import com.pojo.Paper;

import java.util.List;

public interface PaperDao {
    boolean addPaper(Paper paper);
    boolean deletePaperById(int id);
    boolean updatePaper(Paper paper);
    List<Paper> getUserById(int id);
    Paper queryById(int id);
    List<Paper> queryAllPaper();
}
