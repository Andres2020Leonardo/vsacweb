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
public class deals_dtv_recovery_ecuador2 {
     private final JdbcTemplate jdbcTemplate;
    @Autowired
    public deals_dtv_recovery_ecuador2(JdbcTemplate jdbcTemplate) {
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
    private String asignado;
    private String creado_por;
    private String modificado_por;
    private String fecha_creacion;
    private String fecha_modificacion;
    private String source_id;
    private String lead_id;
    private String valor_churn;
    private String linea_de_negocio_lead;
    private String regional;
    private String fuente;
    private String canal;
    private String tipo_de_tramite;
    private String asesor_comercial;
    private String comercial_servi;
    private String aliado_crm;
    private String tipo_cliente;
    private String genero;
    private String cedula;
    private String ibs;
    private String fecha_de_nacimiento;
    private String ubicacion_exacta;
    private String provincia;
    private String estrato;
    private String tipo_de_venta;
    private String metodo_pago;
    private String tipo_de_oferta;
    private String aplica_maratonazo;
    private String perimetro;
    private String disminucion_perimetro;
    private String estado_de_consulta;
    private String encargado_consulta;
    private String fecha_de_consulta;
    private String hora_de_consulta;
    private String encargado_validacion;
    private String estado_evidente;
    private String acierta;
    private String fecha_de_validacion;
    private String fecha_de_inicio;
    private String fecha_inicio_gestion;
    private String fecha_finalizacion;
    private String descuento_churn;
    private String fecha_churn;
    private String fecha_hora_lectura_contrato;
    private String fecha_va;
    private String motivo_cancelacion;
    private String directvgo;
    private String Producto_TV;
    private String Nombre_Asesor;
    private String Provincia_asesor;
    private String Cantidad_decos_adicionales;
    private String Regularizado;
    private String Lugar_venta;
    private String Producto_NET;

    public deals_dtv_recovery_ecuador2(int id_bitrix, String category_id, String etapa_id, String fase_id, String aliado_id, String contacto_id, String fecha_inicio, String fecha_cierre, String asignado, String creado_por, String modificado_por, String fecha_creacion, String fecha_modificacion, String source_id, String lead_id, String valor_churn, String linea_de_negocio_lead, String regional, String fuente, String canal, String tipo_de_tramite, String asesor_comercial, String comercial_servi, String aliado_crm, String tipo_cliente, String genero, String cedula, String ibs, String fecha_de_nacimiento, String ubicacion_exacta, String provincia, String estrato, String tipo_de_venta, String metodo_pago, String tipo_de_oferta, String aplica_maratonazo, String perimetro, String disminucion_perimetro, String estado_de_consulta, String encargado_consulta, String fecha_de_consulta, String hora_de_consulta, String encargado_validacion, String estado_evidente, String acierta, String fecha_de_validacion, String fecha_de_inicio, String fecha_inicio_gestion, String fecha_finalizacion, String descuento_churn, String fecha_churn, String fecha_hora_lectura_contrato, String fecha_va, String motivo_cancelacion, String directvgo, String Producto_TV, String Nombre_Asesor, String Provincia_asesor, String Cantidad_decos_adicionales, String Regularizado, String Lugar_venta, String Producto_NET) {
        this.id_bitrix = id_bitrix;
        this.category_id = category_id;
        this.etapa_id = etapa_id;
        this.fase_id = fase_id;
        this.aliado_id = aliado_id;
        this.contacto_id = contacto_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_cierre = fecha_cierre;
        this.asignado = asignado;
        this.creado_por = creado_por;
        this.modificado_por = modificado_por;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.source_id = source_id;
        this.lead_id = lead_id;
        this.valor_churn = valor_churn;
        this.linea_de_negocio_lead = linea_de_negocio_lead;
        this.regional = regional;
        this.fuente = fuente;
        this.canal = canal;
        this.tipo_de_tramite = tipo_de_tramite;
        this.asesor_comercial = asesor_comercial;
        this.comercial_servi = comercial_servi;
        this.aliado_crm = aliado_crm;
        this.tipo_cliente = tipo_cliente;
        this.genero = genero;
        this.cedula = cedula;
        this.ibs = ibs;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.ubicacion_exacta = ubicacion_exacta;
        this.provincia = provincia;
        this.estrato = estrato;
        this.tipo_de_venta = tipo_de_venta;
        this.metodo_pago = metodo_pago;
        this.tipo_de_oferta = tipo_de_oferta;
        this.aplica_maratonazo = aplica_maratonazo;
        this.perimetro = perimetro;
        this.disminucion_perimetro = disminucion_perimetro;
        this.estado_de_consulta = estado_de_consulta;
        this.encargado_consulta = encargado_consulta;
        this.fecha_de_consulta = fecha_de_consulta;
        this.hora_de_consulta = hora_de_consulta;
        this.encargado_validacion = encargado_validacion;
        this.estado_evidente = estado_evidente;
        this.acierta = acierta;
        this.fecha_de_validacion = fecha_de_validacion;
        this.fecha_de_inicio = fecha_de_inicio;
        this.fecha_inicio_gestion = fecha_inicio_gestion;
        this.fecha_finalizacion = fecha_finalizacion;
        this.descuento_churn = descuento_churn;
        this.fecha_churn = fecha_churn;
        this.fecha_hora_lectura_contrato = fecha_hora_lectura_contrato;
        this.fecha_va = fecha_va;
        this.motivo_cancelacion = motivo_cancelacion;
        this.directvgo = directvgo;
        this.Producto_TV = Producto_TV;
        this.Nombre_Asesor = Nombre_Asesor;
        this.Provincia_asesor = Provincia_asesor;
        this.Cantidad_decos_adicionales = Cantidad_decos_adicionales;
        this.Regularizado = Regularizado;
        this.Lugar_venta = Lugar_venta;
        this.Producto_NET = Producto_NET;
        this.jdbcTemplate = null;

    }
    
}
