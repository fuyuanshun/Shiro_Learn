package com.fys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping("/")
    public String defaultView(){
        return "index";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String loginDeal(Model model, String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return "redirect:index";
        } catch(AuthenticationException e) {
            model.addAttribute("error", "验证失败");
            return "login";
        }
    }

    @RequestMapping("listProduct")
    @RequiresAuthentication
    public String listProduct(){
        return "listProduct";
    }

    @RequestMapping("deleteProduct")
    @RequiresPermissions("deleteProduct")
    public String deleteProduct() {
        return "deleteProduct";
    }

    @RequestMapping("deleteOrder")
    @RequiresRoles("admin")
    public String deleteOrder(){
        return "deleteOrder";
    }
}
