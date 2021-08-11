package com.example.controller.admin;

import com.example.dto.NewDTO;
import com.example.dto.UserDTO;
import com.example.service.ICategoryService;
import com.example.service.INewService;
import com.example.service.IRoleService;
import com.example.service.IUserSevice;
import com.example.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private IUserSevice userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/thanh-vien/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        UserDTO model = new UserDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/user/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(userService.findAll(pageable));
        model.setTotalItem(userService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
    @RequestMapping(value = "/quan-tri/thanh-vien/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/edit");
        UserDTO model = new UserDTO();
        if (id != null) {
            model = userService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("role", roleService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
