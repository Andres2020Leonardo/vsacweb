/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servi.cac.controllers;

import ch.qos.logback.core.model.Model;
import com.servi.cac.models.Redirreccion;
import com.servi.cac.models.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Analitica
 */
@Controller
public class vistas {
    
    @Autowired
    private HttpSession httpSession;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping("/dtvcol")
    public String home(Model model){
        
        String re = redirectUl("dtvcol");
        return re;
    }
    @RequestMapping("/dtvecu") 
    public String dtvecu(Model model){
        
        String re = redirectUl("dtvecu");
        return re;
        
    }
    @RequestMapping("/hughescol") 
    public String hughes_col(Model model){
        
        String re = redirectUl("hughes_col");
        return re;
    }
    @RequestMapping("/hughesecu") 
    public String hughes_ecu(Model model){
        
        String re = redirectUl("hughes_ecu");
        return re;
        
    }
    @RequestMapping("/login") 
    public String login(Model model){
        
        return "login"; 
    }
    
    
    @RequestMapping("/") 
    public String INDEX(Model mode) throws Exception{
       
       String operacion = (String) httpSession.getAttribute("operacion");
       
       String sql = "SELECT  *  FROM dbo.redireccion";
       List<Redirreccion>  list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Redirreccion.class));
        
        boolean enc = false;
        if (operacion==null) {
            return "login"; 
        }
        for (Redirreccion redirreccion : list) {
            
            if (redirreccion.getRol().equals(operacion)) {
                String redirect = "redirect:/"+redirreccion.getPagina();
                
                enc = true;
                return redirect;
            }
        }
        
     
        if (enc) {
            return "login"; 
        }else{
            return "sinermiso"; 
        }
 
       
       
    }
    
    public String redirectUl(String r){
       
       String operacion ="";
       try{
       operacion = (String) httpSession.getAttribute("operacion");
       }catch(Exception e){
        operacion =""; 
       }
       String sql = "SELECT  *  FROM dbo.redireccion";
       List<Redirreccion>  list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Redirreccion.class));
       
        
        boolean enc = false;
        if (operacion==null) {
            return "login"; 
        }
        for (Redirreccion redirreccion : list) {
            
            if (redirreccion.getRol().equals(operacion)) {               
                enc = true;
                System.out.println(redirreccion.getPagina());
                System.out.println(r);
                if(r.equals(redirreccion.getPagina())){
                   
                    return r;
                }else{
                    String redirect = "redirect:/"+redirreccion.getPagina();
                
                    enc = true;
                    return redirect; 
                }
                
            }
        }
        
     
        if (enc) {
            return "login"; 
        }else{
            return "sinermiso"; 
        }
    }
}
