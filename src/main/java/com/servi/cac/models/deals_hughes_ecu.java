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
public class deals_hughes_ecu {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public deals_hughes_ecu(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public deals_hughes_ecu() {
        this.jdbcTemplate = null;
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
    private String valor_churn;
    private String tipo_cliente_id;
    private String genero_id;
    private String cedula;
    private String fecha_de_nacimiento;
    private String ubicacion_exacta;
    private String estrato;
    private String hora_de_consulta;
    private String fecha_inicio_gestion;
    private String descuento_churn;
    private String fecha_churn;
    private String fecha_activacion;
    private String fecha_cupon;
    private String codigo_san;
    private String provincia;
    private String ciudad_canton;
    private String regional_ecu;
    private String motivo_novedad_sym;
    private String Nombre_1;
    private String Apellido;
    private String Telefono;
    private String Telefono_2;
    private String E_mail;

    public deals_hughes_ecu(int id_bitrix, String category_id, String etapa_id, String fase_id, String aliado_id, String contacto_id, String fecha_inicio, String fecha_cierre, String asignado, String creado_por, String modificado_por, String fecha_creacion, String fecha_modificacion, String valor_churn, String tipo_cliente_id, String genero_id, String cedula, String fecha_de_nacimiento, String ubicacion_exacta, String estrato, String hora_de_consulta, String fecha_inicio_gestion, String descuento_churn, String fecha_churn, String fecha_activacion, String fecha_cupon, String codigo_san, String provincia, String ciudad_canton, String regional_ecu, String motivo_novedad_sym, String Nombre_1, String Apellido, String Telefono, String Telefono_2, String E_mail) {
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
        this.valor_churn = valor_churn;
        this.tipo_cliente_id = tipo_cliente_id;
        this.genero_id = genero_id;
        this.cedula = cedula;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.ubicacion_exacta = ubicacion_exacta;
        this.estrato = estrato;
        this.hora_de_consulta = hora_de_consulta;
        this.fecha_inicio_gestion = fecha_inicio_gestion;
        this.descuento_churn = descuento_churn;
        this.fecha_churn = fecha_churn;
        this.fecha_activacion = fecha_activacion;
        this.fecha_cupon = fecha_cupon;
        this.codigo_san = codigo_san;
        this.provincia = provincia;
        this.ciudad_canton = ciudad_canton;
        this.regional_ecu = regional_ecu;
        this.motivo_novedad_sym = motivo_novedad_sym;
        this.Nombre_1 = Nombre_1;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Telefono_2 = Telefono_2;
        this.E_mail = E_mail;
        this.jdbcTemplate = null;

    }
    @Override
    public String toString() {
        return "deals_hughes_ecu{" + "id_bitrix=" + id_bitrix + ", category_id=" + category_id + ", etapa_id=" + etapa_id + ", fase_id=" + fase_id + ", aliado_id=" + aliado_id + ", contacto_id=" + contacto_id + ", fecha_inicio=" + fecha_inicio + ", fecha_cierre=" + fecha_cierre + ", asignado=" + asignado + ", creado_por=" + creado_por + ", modificado_por=" + modificado_por + ", fecha_creacion=" + fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + ", valor_churn=" + valor_churn + ", tipo_cliente_id=" + tipo_cliente_id + ", genero_id=" + genero_id + ", cedula=" + cedula + ", fecha_de_nacimiento=" + fecha_de_nacimiento + ", ubicacion_exacta=" + ubicacion_exacta + ", estrato=" + estrato + ", hora_de_consulta=" + hora_de_consulta + ", fecha_inicio_gestion=" + fecha_inicio_gestion + ", descuento_churn=" + descuento_churn + ", fecha_churn=" + fecha_churn + ", fecha_activacion=" + fecha_activacion + ", fecha_cupon=" + fecha_cupon + ", codigo_san=" + codigo_san + ", provincia=" + provincia + ", ciudad_canton=" + ciudad_canton + ", regional_ecu=" + regional_ecu + ", motivo_novedad_sym=" + motivo_novedad_sym + ", Nombre_1=" + Nombre_1 + ", Apellido=" + Apellido + ", Telefono=" + Telefono + ", Telefono_2=" + Telefono_2 + ", E_mail=" + E_mail + '}';

    }

    public void cambiardatoshughesecu(deals_hughes_ecu object, deals_hughes_ecu dealsRehugecu) {
        object.setId_bitrix(dealsRehugecu.getId_bitrix());
        object.setCategory_id(dealsRehugecu.getCategory_id());
        object.setEtapa_id(dealsRehugecu.getEtapa_id());
        object.setFase_id(dealsRehugecu.getFase_id());
        object.setAliado_id(dealsRehugecu.getAliado_id());
        object.setContacto_id(dealsRehugecu.getContacto_id());
        object.setFecha_inicio(dealsRehugecu.getFecha_inicio());
        object.setFecha_cierre(dealsRehugecu.getFecha_cierre());
        object.setAsignado(dealsRehugecu.getAsignado());
        object.setCreado_por(dealsRehugecu.getCreado_por());
        object.setModificado_por(dealsRehugecu.getModificado_por());
        object.setFecha_creacion(dealsRehugecu.getFecha_creacion());
        object.setFecha_modificacion(dealsRehugecu.getFecha_modificacion());
        object.setValor_churn(dealsRehugecu.getValor_churn());
        object.setTipo_cliente_id(dealsRehugecu.getTipo_cliente_id());
        object.setGenero_id(dealsRehugecu.getGenero_id());
        object.setCedula(dealsRehugecu.getCedula());
        object.setFecha_de_nacimiento(dealsRehugecu.getFecha_de_nacimiento());
        object.setUbicacion_exacta(dealsRehugecu.getUbicacion_exacta());
        object.setEstrato(dealsRehugecu.getEstrato());
        object.setHora_de_consulta(dealsRehugecu.getHora_de_consulta());
        object.setFecha_inicio_gestion(dealsRehugecu.getFecha_inicio_gestion());
        object.setDescuento_churn(dealsRehugecu.getDescuento_churn());
        object.setFecha_churn(dealsRehugecu.getFecha_churn());
        object.setFecha_activacion(dealsRehugecu.getFecha_activacion());
        object.setFecha_cupon(dealsRehugecu.getFecha_cupon());
        object.setCodigo_san(dealsRehugecu.getCodigo_san());
        object.setProvincia(dealsRehugecu.getProvincia());
        object.setCiudad_canton(dealsRehugecu.getCiudad_canton());
        object.setRegional_ecu(dealsRehugecu.getRegional_ecu());
        object.setMotivo_novedad_sym(dealsRehugecu.getMotivo_novedad_sym());
        object.setNombre_1(dealsRehugecu.getNombre_1());
        object.setApellido(dealsRehugecu.getApellido());
        object.setTelefono(dealsRehugecu.getTelefono());
        object.setTelefono_2(dealsRehugecu.getTelefono_2());
        object.setE_mail(dealsRehugecu.getE_mail());
    }
    
}
