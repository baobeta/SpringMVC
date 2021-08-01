package com.example.dao;

import com.example.model.NewModel;

import java.util.List;




public interface INewDAO extends GenericDAO<NewModel> {
    List<NewModel> findAll();
}