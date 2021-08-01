package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.INewDAO;
import com.example.mapper.NewMapper;
import com.example.model.NewModel;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

    @Override
    public List<NewModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM news");
        return query(sql.toString(), new NewMapper());
    }
}