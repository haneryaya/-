package com.djtu.fywz.controller;

import com.djtu.fywz.pojo.User;
import com.djtu.fywz.service.UserRoleService;
import com.djtu.fywz.service.UserService;
import com.djtu.fywz.util.UploadUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 后台登陆
 */
@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(Model model, String name, String password){//throws ParseException
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
            User us = userService.getByName(name);
            String lastLoginTime = "";
            if(us!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //上次时间
                Date time = new Date();
                if(us.getLasttime()!=null){
                    time = us.getLasttime();
                }else {
                    time = new Date();
                }

                lastLoginTime = sdf.format(time);
                //新时间
                String format = sdf.format(new Date());
                //string转date  不处理时间格式会不理想
                ParsePosition pos = new ParsePosition(0);
                Date strtodate = sdf.parse(format, pos);
                us.setLasttime(strtodate);
                userService.update(us);
            }
            if (us.getStatus()==1){
                Session session=subject.getSession();
                session.setAttribute("subject", subject);
                session.setAttribute("user",name);
                session.setAttribute("id",us.getId());
                session.setAttribute("lastLoginTime",lastLoginTime);
                return "redirect:index";
            }else {
                model.addAttribute("error", "账号已被停用！");
                return "/login";
            }

        } catch (AuthenticationException e) {
            model.addAttribute("error", "验证失败！");
            return "/login";
        }
    }

    @RequestMapping("/foreuserRegisterUI")
    public String foreuserRegisterUI(){
        return "foreuserRegister";
    }


    @RequestMapping("foreRegistersss")
    public String regedieUser(String name, String password, String address, String phone, String shopid, MultipartFile upload, HttpSession session) throws IOException {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        if (upload != null) {
            String imageName = uuid+".jpg";
            File file = new File(session.getServletContext().getRealPath("/images/product"),imageName);
            file.getParentFile().mkdirs();
            upload.transferTo(file);
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setAddress(address);
            user.setPhone(phone);
            user.setShopid(shopid);
            user.setStatus(0);
            user.setImg("images/product/"+imageName);
            System.out.println(imageName+">>>>>>"+shopid);
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();//生成随机数
            int times = 2;
            String algorithmName = "md5";
            String encodedPassword = new SimpleHash(algorithmName,user.getPassword(),salt,times).toString();
            user.setPassword(encodedPassword);
            user.setSalt(salt);
            userService.add(user);
            long i = (long) 2;
            long[] roleIds = {i};

            userRoleService.setRoles(user,roleIds);
        }
        return "redirect:/fore/foreIndex";
    }

}