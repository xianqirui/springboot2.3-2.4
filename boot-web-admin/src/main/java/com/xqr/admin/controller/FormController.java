package com.xqr.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
    /*
    * MultipartFile:自动封装
    * */
    @PostMapping("/upload")
    public String upload(@RequestParam("email")String email,
                         @RequestParam("username")String username,
                         @RequestPart("headImage") MultipartFile headImage,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        //保存
        if (!headImage.isEmpty()){
            String filename = headImage.getOriginalFilename();
            headImage.transferTo(new File("E:\\IDEwork\\spring-boot 2.3-2.4\\img\\"+filename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\IDEwork\\spring-boot 2.3-2.4\\img\\cath\\"+filename));
                }
            }
        }
        return "main";
    }

}
