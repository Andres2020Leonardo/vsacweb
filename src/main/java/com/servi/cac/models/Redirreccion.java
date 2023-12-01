/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servi.cac.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Analitica
 */
@Getter
@Setter
@Repository
public class Redirreccion {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public Redirreccion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Redirreccion() {
         this.jdbcTemplate = null;
    }
    
    private int id;
    private String rol;
    private String pagina;

    public Redirreccion(int id, String rol, String pagina) {
        this.id = id;
        this.rol = rol;
        this.pagina = pagina;
        this.jdbcTemplate = null;
    }
    
}
