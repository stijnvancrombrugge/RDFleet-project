package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.services.CarModelService;
import com.realdolmen.fleet.services.EmployeeService;
import com.realdolmen.fleet.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by SVCAX33 on 3/11/2015.
 */
@Controller
public class ImageController {

    private CarModelService carModelService;
    private UserDetailService userService;

    @Autowired
    public ImageController(CarModelService carModelService, UserDetailService userService){
        this.carModelService = carModelService;
        this.userService = userService;
    }

    @RequestMapping(value = "/image/{type}/{image_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Integer imageId, @PathVariable("type") String type) throws IOException {
        byte[] imageContent = null;
        if(type.equals("model")){
            imageContent = carModelService.findImageByCarModelId(imageId);
        }
        else if(type.equals("profile")){
            imageContent = userService.findImageByUserId(imageId);
        }
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
}
