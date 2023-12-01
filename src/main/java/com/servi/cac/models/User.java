/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servi.cac.models;

import jakarta.servlet.http.HttpSession;
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
public class User {   
        
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public User(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User() {
         this.jdbcTemplate = null;
    }
    
    private int id;
    private String name;
    private String email;
    private String email_verified_at;
    private String password;
    private String two_factor_secret;
    private String two_factor_recovery_codes;
    private String operation;
    private String city;
    private String region;
    private String phone;
    private String nit;
    private String remember_token;
    private String current_team_id;
    private String id_pais;
    private String profile_photo_path;
    private String created_at;
    private String updated_at;
    private String razon_social;
    private String id_portal;
    private String id_supervisor;
    private String last_loguin;
    private String id_bitrix;
    private String id_contac_bi;
    private String userscol;
    private String proceso;
    private String fecha_ingreso;
    private String empleador;
    private String id_regional_bt;
    private String codigo_pvd;
    private String id_compania;
    private String zona;
    private String estado;
    private String id_macaw;
    private String id_sede;
    private String id_rh;
    private String id_arl;
    private String id_eps;
    private String id_fondo_pensiones;
    private String id_caja_compensacion;
    private String id_cargo;
    private String fecha_nacimiento;
    private String lugar_nacimiento;
    private String raza;
    private String genero;
    private String id_estado_civil;
    private String escolaridad;
    private String numero_hijos;
    private String centro_costos;
    private String apellido;
    private String direccion;
    private String barrio;
    private String estrato;
    private String contacto_emergencia;
    private String telefono_emergencia;
    private String parentesco_emergencia;
    private String tipo_empleado;
    private String observaciones_medicas;
    private String alergias;
    private String ingresos;
    private String id_tipo_vendedor;
    private String id_tipo_tecnico;
    private String id_area_empresa;
    private String tipo_vinculacion;
    private String tipo_auxilio_movimiento;
    private String licencia_carro;
    private String fecha_vencimiento_licencia_carro;
    private String licencia_moto;
    private String fecha_vencimiento_licencia_moto;
}
