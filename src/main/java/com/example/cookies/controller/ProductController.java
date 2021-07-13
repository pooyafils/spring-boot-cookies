package com.example.cookies.controller;

import com.example.cookies.entity.Product;
import com.example.cookies.repository.ProductRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * pooya mahmoodi 7/13/2021
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        ResponseCookie responseCookie=ResponseCookie.fromClientResponse("user-id","pooya2020")
                .httpOnly(true).secure(true).path("/").domain("localhost").build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,responseCookie.toString()).build();
    }
    @GetMapping("/cookievalue")
    public ResponseEntity readCookie(@CookieValue(name ="user-id",defaultValue = "default-user-id")String cookieName){
        return ResponseEntity.ok("kcookie name is "+cookieName);
    }
    @GetMapping("/delete")
    public ResponseEntity deleteCookie(){
        ResponseCookie responseCookie=ResponseCookie.from("user-id",null).build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,responseCookie.toString()).build();
    }
    @GetMapping("/create cookie")
    public ResponseEntity createCookie(HttpServletResponse httpServletResponse){
        Cookie cookie=new Cookie("create-cookie","pooya-cookie");
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(7*27*60*60);
        httpServletResponse.addCookie(cookie);
        return ResponseEntity.ok("cookie has been created");
    }
}
