/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servi.cac.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Servimercadeo
 */
@Getter
@Setter
@ToString
@Repository
public class deals_recovery_hughescol {
     private final JdbcTemplate jdbcTemplate;
    @Autowired
    public deals_recovery_hughescol(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private int id_bitrix;
    private String category_id;
    private String etapa_id;
    private String fase_id;
    private String aliado_id;
    private String contacto_id;
    private String fecha_inicio;
    private String fecha_cierre;
    private String fecha_cupon;
    private String fecha_creacion;
    private String fecha_modificacion;
    private String fecha_de_nacimiento;
    private String hora_de_consulta;
    private String fecha_inicio_gestion;
    private String fecha_churn;
    private String fecha_activacion;
    private String encargado_validacion;
    private String creado_por;
    private String asignado;
    private String modificado_por;
    private String valor_churn;
    private String tipo_cliente_id;
    private String genero_id;
    private String cedula;
    private String ubicacion_exacta;
    private String estrato;
    private String descuento_churn;
    private String codigo_san;
    private String departamento;
    private String regional_col;
    private String motivo_novedad_sym;
    private String lead_id;
    private String fuente_sym_id;
    private String linea_de_negocio_lead_id;
    private String source_id;
    private String fuente_id;
    private String ciudad_municipio;
    private String zona_instalacion;
    private String comercial_sym;
    private String dealer_sym;
    private String aliado_crm_id;
    private String sucursal;
    private String contratoDigital;
    private String TXT_TELEFONO;
    private String TXT_TELEFONO_2;
    private String TXT_CORREO;
    private String TXT_ALI_SUCURSAL;
    private String NUM_ID_ALIADO;
    private String BIT_FIRMA_HUGHES;
    private String Fec_factura_sym;
    private String Nombre_Cliente;
    private String Apellido_Cliente;
    private String fecha_finalizacion;
    private String Producto;

    public deals_recovery_hughescol(int id_bitrix, String category_id, String etapa_id, String fase_id, String aliado_id, String contacto_id, String fecha_inicio, String fecha_cierre, String fecha_cupon, String fecha_creacion, String fecha_modificacion, String fecha_de_nacimiento, String hora_de_consulta, String fecha_inicio_gestion, String fecha_churn, String fecha_activacion, String encargado_validacion, String creado_por, String asignado, String modificado_por, String valor_churn, String tipo_cliente_id, String genero_id, String cedula, String ubicacion_exacta, String estrato, String descuento_churn, String codigo_san, String departamento, String regional_col, String motivo_novedad_sym, String lead_id, String fuente_sym_id, String linea_de_negocio_lead_id, String source_id, String fuente_id, String ciudad_municipio, String zona_instalacion, String comercial_sym, String dealer_sym, String aliado_crm_id, String sucursal, String contratoDigital, String TXT_TELEFONO, String TXT_TELEFONO_2, String TXT_CORREO, String TXT_ALI_SUCURSAL, String NUM_ID_ALIADO, String BIT_FIRMA_HUGHES, String Fec_factura_sym, String Nombre_Cliente, String Apellido_Cliente, String fecha_finalizacion, String Producto) {
        this.id_bitrix = id_bitrix;
        this.category_id = category_id;
        this.etapa_id = etapa_id;
        this.fase_id = fase_id;
        this.aliado_id = aliado_id;
        this.contacto_id = contacto_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_cierre = fecha_cierre;
        this.fecha_cupon = fecha_cupon;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.hora_de_consulta = hora_de_consulta;
        this.fecha_inicio_gestion = fecha_inicio_gestion;
        this.fecha_churn = fecha_churn;
        this.fecha_activacion = fecha_activacion;
        this.encargado_validacion = encargado_validacion;
        this.creado_por = creado_por;
        this.asignado = asignado;
        this.modificado_por = modificado_por;
        this.valor_churn = valor_churn;
        this.tipo_cliente_id = tipo_cliente_id;
        this.genero_id = genero_id;
        this.cedula = cedula;
        this.ubicacion_exacta = ubicacion_exacta;
        this.estrato = estrato;
        this.descuento_churn = descuento_churn;
        this.codigo_san = codigo_san;
        this.departamento = departamento;
        this.regional_col = regional_col;
        this.motivo_novedad_sym = motivo_novedad_sym;
        this.lead_id = lead_id;
        this.fuente_sym_id = fuente_sym_id;
        this.linea_de_negocio_lead_id = linea_de_negocio_lead_id;
        this.source_id = source_id;
        this.fuente_id = fuente_id;
        this.ciudad_municipio = ciudad_municipio;
        this.zona_instalacion = zona_instalacion;
        this.comercial_sym = comercial_sym;
        this.dealer_sym = dealer_sym;
        this.aliado_crm_id = aliado_crm_id;
        this.sucursal = sucursal;
        this.contratoDigital = contratoDigital;
        this.TXT_TELEFONO = TXT_TELEFONO;
        this.TXT_TELEFONO_2 = TXT_TELEFONO_2;
        this.TXT_CORREO = TXT_CORREO;
        this.TXT_ALI_SUCURSAL = TXT_ALI_SUCURSAL;
        this.NUM_ID_ALIADO = NUM_ID_ALIADO;
        this.BIT_FIRMA_HUGHES = BIT_FIRMA_HUGHES;
        this.Fec_factura_sym = Fec_factura_sym;
        this.Nombre_Cliente = Nombre_Cliente;
        this.Apellido_Cliente = Apellido_Cliente;
        this.fecha_finalizacion = fecha_finalizacion;
        this.Producto = Producto;
        this.jdbcTemplate = null;

    }

    

    
    
}
