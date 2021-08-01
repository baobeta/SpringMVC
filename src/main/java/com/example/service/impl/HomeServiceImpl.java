package com.example.service.impl;

import com.example.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public List<String> loadMenu() {
        List<String> menus = new ArrayList<String>();
        menus.add("Blog java");
        menus.add("Huong dan hoc java ");
        menus.add("lien he");
        menus.add("Thanh toan");
        return menus;
    }
}
