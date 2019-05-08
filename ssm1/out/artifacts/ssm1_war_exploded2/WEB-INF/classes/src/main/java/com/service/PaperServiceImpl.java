package com.service;

import com.dao.PaperDao;
import com.pojo.Paper;
import com.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Override
    public boolean addPaper(Paper paper) {
       return paperDao.addPaper(paper);
    }
    @Override
    public boolean deletePaperById(int id) {
       return paperDao.deletePaperById(id);
    }
    @Override
    public boolean updatePaper(Paper paper){
        return paperDao.updatePaper(paper);
    }
    public Paper queryById(int id){
        return paperDao.queryById(id);
    }
    public List<Paper> getUserById(int id){
        return paperDao.getUserById(id);
    }
    @Override
    public List<Paper> queryAllPaper(){
        return paperDao.queryAllPaper();
    }
    }