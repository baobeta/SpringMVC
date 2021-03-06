package com.example.controller.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "loginControllerOfWeb")
public class LoginController {
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("login");
        if (request.getParameter("message") != null) {
            mav.addObject("message", "Đăng kí thành công vui lòng đăng nhập!");
            mav.addObject("alert","success" );
        }
        return mav;
    }

    @RequestMapping(value = "/dang-ki", method = RequestMethod.GET)
    public ModelAndView registerPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("register");
        if (request.getParameter("message") != null) {
            mav.addObject("message", "Dang ki that bai, vui long kiem tra lai");
            mav.addObject("alert","danger" );
        }
        return mav;
    }

    @RequestMapping(value = "/thoat", method = RequestMethod.GET)
    public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/trang-chu");
    }
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("redirect:/dang-nhap?accessDenied");
    }
}
