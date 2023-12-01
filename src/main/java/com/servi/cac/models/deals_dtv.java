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
public class deals_dtv {
     private final JdbcTemplate jdbcTemplate;
    @Autowired
    public deals_dtv(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public deals_dtv() {
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
    private String departamento;
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
    private String Extension_asesor;
    private String Lider_Coordinador_SERVIMERCADEO;
    private String Producto_TV;
    private String fecha_finalizacion_new;
    private String Ciudad;
    private String cliente_nombre;
    private String apellido_cliente;
    private String cliente_id;
    private String sector_economico;
    private String base_trabajada;
    private String numero_suscripciones;
    private String producto_net;
    private String mercado;
    private String telefono_1;
    private String telefono_2;

    public deals_dtv(int id_bitrix, String category_id, String etapa_id, String fase_id, String aliado_id, String contacto_id, String fecha_inicio, String fecha_cierre, String asignado, String creado_por, String modificado_por, String fecha_creacion, String fecha_modificacion, String source_id, String lead_id, String valor_churn, String linea_de_negocio_lead, String regional, String fuente, String canal, String tipo_de_tramite, String asesor_comercial, String comercial_servi, String aliado_crm, String tipo_cliente, String genero, String cedula, String ibs, String fecha_de_nacimiento, String ubicacion_exacta, String departamento, String estrato, String tipo_de_venta, String metodo_pago, String tipo_de_oferta, String aplica_maratonazo, String perimetro, String disminucion_perimetro, String estado_de_consulta, String encargado_consulta, String fecha_de_consulta, String hora_de_consulta, String encargado_validacion, String estado_evidente, String acierta, String fecha_de_validacion, String fecha_de_inicio, String fecha_inicio_gestion, String fecha_finalizacion, String descuento_churn, String fecha_churn, String fecha_hora_lectura_contrato, String fecha_va, String motivo_cancelacion, String directvgo, String Extension_asesor, String Lider_Coordinador_SERVIMERCADEO, String Producto_TV, String fecha_finalizacion_new, String Ciudad, String cliente_nombre, String apellido_cliente, String cliente_id, String sector_economico, String base_trabajada, String numero_suscripciones, String producto_net, String mercado, String telefono_1, String telefono_2) {
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
        this.departamento = departamento;
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
        this.Extension_asesor = Extension_asesor;
        this.Lider_Coordinador_SERVIMERCADEO = Lider_Coordinador_SERVIMERCADEO;
        this.Producto_TV = Producto_TV;
        this.fecha_finalizacion_new = fecha_finalizacion_new;
        this.Ciudad = Ciudad;
        this.cliente_nombre = cliente_nombre;
        this.apellido_cliente = apellido_cliente;
        this.cliente_id = cliente_id;
        this.sector_economico = sector_economico;
        this.base_trabajada = base_trabajada;
        this.numero_suscripciones = numero_suscripciones;
        this.producto_net = producto_net;
        this.mercado = mercado;
        this.telefono_1 = telefono_1;
        this.telefono_2 = telefono_2;
         this.jdbcTemplate = null;
    }
   
    @Override
    public String toString() {
        return "deals_dtv{" + "id_bitrix=" + id_bitrix + ", category_id=" + category_id + ", etapa_id=" + etapa_id + ", fase_id=" + fase_id + ", aliado_id=" + aliado_id + ", contacto_id=" + contacto_id + ", fecha_inicio=" + fecha_inicio + ", fecha_cierre=" + fecha_cierre + ", asignado=" + asignado + ", creado_por=" + creado_por + ", modificado_por=" + modificado_por + ", fecha_creacion=" + fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + ", source_id=" + source_id + ", lead_id=" + lead_id + ", valor_churn=" + valor_churn + ", linea_de_negocio_lead=" + linea_de_negocio_lead + ", regional=" + regional + ", fuente=" + fuente + ", canal=" + canal + ", tipo_de_tramite=" + tipo_de_tramite + ", asesor_comercial=" + asesor_comercial + ", comercial_servi=" + comercial_servi + ", aliado_crm=" + aliado_crm + ", tipo_cliente=" + tipo_cliente + ", genero=" + genero + ", cedula=" + cedula + ", ibs=" + ibs + ", fecha_de_nacimiento=" + fecha_de_nacimiento + ", ubicacion_exacta=" + ubicacion_exacta + ", departamento=" + departamento + ", estrato=" + estrato + ", tipo_de_venta=" + tipo_de_venta + ", metodo_pago=" + metodo_pago + ", tipo_de_oferta=" + tipo_de_oferta + ", aplica_maratonazo=" + aplica_maratonazo + ", perimetro=" + perimetro + ", disminucion_perimetro=" + disminucion_perimetro + ", estado_de_consulta=" + estado_de_consulta + ", encargado_consulta=" + encargado_consulta + ", fecha_de_consulta=" + fecha_de_consulta + ", hora_de_consulta=" + hora_de_consulta + ", encargado_validacion=" + encargado_validacion + ", estado_evidente=" + estado_evidente + ", acierta=" + acierta + ", fecha_de_validacion=" + fecha_de_validacion + ", fecha_de_inicio=" + fecha_de_inicio + ", fecha_inicio_gestion=" + fecha_inicio_gestion + ", fecha_finalizacion=" + fecha_finalizacion + ", descuento_churn=" + descuento_churn + ", fecha_churn=" + fecha_churn + ", fecha_hora_lectura_contrato=" + fecha_hora_lectura_contrato + ", fecha_va=" + fecha_va + ", motivo_cancelacion=" + motivo_cancelacion + ", directvgo=" + directvgo + ", Extension_asesor=" + Extension_asesor + ", Lider_Coordinador_SERVIMERCADEO=" + Lider_Coordinador_SERVIMERCADEO + ", Producto_TV=" + Producto_TV + ", fecha_finalizacion_new=" + fecha_finalizacion_new + ", Ciudad=" + Ciudad + ", cliente_nombre=" + cliente_nombre + ", apellido_cliente=" + apellido_cliente + ", cliente_id=" + cliente_id + ", sector_economico=" + sector_economico + ", base_trabajada=" + base_trabajada + ", numero_suscripciones=" + numero_suscripciones + ", producto_net=" + producto_net + ", mercado=" + mercado + ", telefono_1=" + telefono_1 + ", telefono_2=" + telefono_2 + '}';
    }
    
    public void cambiardatos(deals_dtv object,deals_dtv dealsRe){
                    object.setId_bitrix(dealsRe.getId_bitrix());
                    object.setCategory_id(dealsRe.getCategory_id());
                    object.setEtapa_id(dealsRe.getEtapa_id());
                    object.setFase_id(dealsRe.getFase_id());
                    object.setAliado_id(dealsRe.getAliado_id());
                    object.setContacto_id(dealsRe.getContacto_id());
                    object.setFecha_inicio(dealsRe.getFecha_inicio());
                    object.setFecha_cierre(dealsRe.getFecha_cierre());
                    object.setAsignado(dealsRe.getAsignado());
                    object.setCreado_por(dealsRe.getCreado_por());
                    object.setModificado_por(dealsRe.getModificado_por());
                    object.setFecha_creacion(dealsRe.getFecha_creacion());
                    object.setFecha_modificacion(dealsRe.getFecha_modificacion());
                    object.setSource_id(dealsRe.getSource_id());
                    object.setLead_id(dealsRe.getLead_id());
                    object.setValor_churn(dealsRe.getValor_churn());
                    object.setLinea_de_negocio_lead(dealsRe.getLinea_de_negocio_lead());
                    object.setRegional(dealsRe.getRegional());
                    object.setFuente(dealsRe.getFuente());
                    object.setCanal(dealsRe.getCanal());
                    object.setTipo_de_tramite(dealsRe.getTipo_de_tramite());
                    object.setAsesor_comercial(dealsRe.getAsesor_comercial());
                    object.setComercial_servi(dealsRe.getComercial_servi());
                    object.setAliado_crm(dealsRe.getAliado_crm());
                    object.setTipo_cliente(dealsRe.getTipo_cliente());
                    object.setGenero(dealsRe.getGenero());
                    object.setCedula(dealsRe.getCedula());
                    object.setIbs(dealsRe.getIbs());
                    object.setFecha_de_nacimiento(dealsRe.getFecha_de_nacimiento());
                    object.setUbicacion_exacta(dealsRe.getUbicacion_exacta());
                    object.setDepartamento(dealsRe.getDepartamento());
                    object.setEstrato(dealsRe.getEstrato());
                    object.setTipo_de_venta(dealsRe.getTipo_de_venta());
                    object.setMetodo_pago(dealsRe.getMetodo_pago());
                    object.setTipo_de_oferta(dealsRe.getTipo_de_oferta());
                    object.setAplica_maratonazo(dealsRe.getAplica_maratonazo());
                    object.setPerimetro(dealsRe.getPerimetro());
                    object.setDisminucion_perimetro(dealsRe.getDisminucion_perimetro());
                    object.setEstado_de_consulta(dealsRe.getEstado_de_consulta());
                    object.setEncargado_consulta(dealsRe.getEncargado_consulta());
                    object.setFecha_de_consulta(dealsRe.getFecha_de_consulta());
                    object.setHora_de_consulta(dealsRe.getHora_de_consulta());
                    object.setEncargado_validacion(dealsRe.getEncargado_validacion());
                    object.setEstado_evidente(dealsRe.getEstado_evidente());
                    object.setAcierta(dealsRe.getAcierta());
                    object.setFecha_de_validacion(dealsRe.getFecha_de_validacion());
                    object.setFecha_de_inicio(dealsRe.getFecha_de_inicio());
                    object.setFecha_inicio_gestion(dealsRe.getFecha_inicio_gestion());
                    object.setFecha_finalizacion(dealsRe.getFecha_finalizacion());
                    object.setDescuento_churn(dealsRe.getDescuento_churn());
                    object.setFecha_churn(dealsRe.getFecha_churn());
                    object.setFecha_hora_lectura_contrato(dealsRe.getFecha_hora_lectura_contrato());
                    object.setFecha_va(dealsRe.getFecha_va());
                    object.setMotivo_cancelacion(dealsRe.getMotivo_cancelacion());
                    object.setDirectvgo(dealsRe.getDirectvgo());
                    object.setExtension_asesor(dealsRe.getExtension_asesor());
                    object.setLider_Coordinador_SERVIMERCADEO(dealsRe.getLider_Coordinador_SERVIMERCADEO());
                    object.setProducto_TV(dealsRe.getProducto_TV());
                    object.setFecha_finalizacion_new(dealsRe.getFecha_finalizacion_new());
                    object.setCiudad(dealsRe.getCiudad());
                    object.setCliente_nombre(dealsRe.getCliente_nombre());
                    object.setApellido_cliente(dealsRe.getApellido_cliente());
                    object.setCliente_id(dealsRe.getCliente_id());
                    object.setSector_economico(dealsRe.getSector_economico());
                    object.setBase_trabajada(dealsRe.getBase_trabajada());
                    object.setNumero_suscripciones(dealsRe.getNumero_suscripciones());
                    object.setProducto_net(dealsRe.getProducto_net());
                    object.setMercado(dealsRe.getMercado());
                    object.setTelefono_1(dealsRe.getTelefono_1());
                    object.setTelefono_2(dealsRe.getTelefono_2());
    }

    
}
