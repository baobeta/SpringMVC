package com.example.controller.web;

import com.example.dto.NewDTO;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
    @Autowired
    private INewService newService;

    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage() {

        NewDTO model = new NewDTO();
        ModelAndView mav = new ModelAndView("web/home");
        model.setListResult(newService.findAll());
        model.setTotalItem(newService.getTotalItem());
        mav.addObject("model", model);
        return mav;
    }
    @RequestMapping(value = "/trang-chu/bai-viet/{id}", method = RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable("id") Long id) {
        NewDTO model = new NewDTO();
        ModelAndView mav = new ModelAndView("web/detail");
        model = newService.findById(id);
        mav.addObject("model", model);
        return mav;
    }






}