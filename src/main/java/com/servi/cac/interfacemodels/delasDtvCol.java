/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servi.cac.interfacemodels;

import com.servi.cac.models.deals_dtv_recovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Analitica
 */
@Service
public class delasDtvCol{
    
    private final deals_dtv_recovery deals ;
    
    @Autowired
    public delasDtvCol(deals_dtv_recovery deals_dtv_recovery_v) {
        this.deals = deals_dtv_recovery_v;
    }
   

    public int insertarDatos(deals_dtv_recovery deals_dtv_recovery_v) {
        String sql = "INSERT INTO tu_tabla (id_bitrix,category_id,etapa_id,fase_id,aliado_id,contacto_id,fecha_inicio,fecha_cierre,asignado,creado_por,modificado_por,fecha_creacion,fecha_modificacion,source_id,lead_id,valor_churn,linea_de_negocio_lead,regional,fuente,canal,tipo_de_tramite,asesor_comercial,comercial_servi,aliado_crm,tipo_cliente,genero,cedula,ibs,fecha_de_nacimiento,ubicacion_exacta,departamento,estrato,tipo_de_venta,metodo_pago,tipo_de_oferta,aplica_maratonazo,perimetro,disminucion_perimetro,estado_de_consulta,encargado_consulta,fecha_de_consulta,hora_de_consulta,encargado_validacion,estado_evidente,acierta,fecha_de_validacion,fecha_de_inicio,fecha_inicio_gestion,fecha_finalizacion,descuento_churn,fecha_churn,fecha_hora_lectura_contrato,fecha_va,motivo_cancelacion,directvgo,Extension_asesor,Lider_Coordinador_SERVIMERCADEO,Producto_TV,fecha_finalizacion_new,Ciudad,cliente_nombre,apellido_cliente,cliente_id,sector_economico,base_trabajada,numero_suscripciones,producto_net,mercado,telefono_1,telefono_2,) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int res  = deals.getJdbcTemplate().update(sql,  deals_dtv_recovery_v.getId_bitrix(),deals_dtv_recovery_v.getCategory_id(),deals_dtv_recovery_v.getEtapa_id(),deals_dtv_recovery_v.getFase_id(),deals_dtv_recovery_v.getAliado_id(),deals_dtv_recovery_v.getContacto_id(),deals_dtv_recovery_v.getFecha_inicio(),deals_dtv_recovery_v.getFecha_cierre(),deals_dtv_recovery_v.getAsignado(),deals_dtv_recovery_v.getCreado_por(),deals_dtv_recovery_v.getModificado_por(),deals_dtv_recovery_v.getFecha_creacion(),deals_dtv_recovery_v.getFecha_modificacion(),deals_dtv_recovery_v.getSource_id(),deals_dtv_recovery_v.getLead_id(),deals_dtv_recovery_v.getValor_churn(),deals_dtv_recovery_v.getLinea_de_negocio_lead(),deals_dtv_recovery_v.getRegional(),deals_dtv_recovery_v.getFuente(),deals_dtv_recovery_v.getCanal(),deals_dtv_recovery_v.getTipo_de_tramite(),deals_dtv_recovery_v.getAsesor_comercial(),deals_dtv_recovery_v.getComercial_servi(),deals_dtv_recovery_v.getAliado_crm(),deals_dtv_recovery_v.getTipo_cliente(),deals_dtv_recovery_v.getGenero(),deals_dtv_recovery_v.getCedula(),deals_dtv_recovery_v.getIbs(),deals_dtv_recovery_v.getFecha_de_nacimiento(),deals_dtv_recovery_v.getUbicacion_exacta(),deals_dtv_recovery_v.getDepartamento(),deals_dtv_recovery_v.getEstrato(),deals_dtv_recovery_v.getTipo_de_venta(),deals_dtv_recovery_v.getMetodo_pago(),deals_dtv_recovery_v.getTipo_de_oferta(),deals_dtv_recovery_v.getAplica_maratonazo(),deals_dtv_recovery_v.getPerimetro(),deals_dtv_recovery_v.getDisminucion_perimetro(),deals_dtv_recovery_v.getEstado_de_consulta(),deals_dtv_recovery_v.getEncargado_consulta(),deals_dtv_recovery_v.getFecha_de_consulta(),deals_dtv_recovery_v.getHora_de_consulta(),deals_dtv_recovery_v.getEncargado_validacion(),deals_dtv_recovery_v.getEstado_evidente(),deals_dtv_recovery_v.getAcierta(),deals_dtv_recovery_v.getFecha_de_validacion(),deals_dtv_recovery_v.getFecha_de_inicio(),deals_dtv_recovery_v.getFecha_inicio_gestion(),deals_dtv_recovery_v.getFecha_finalizacion(),deals_dtv_recovery_v.getDescuento_churn(),deals_dtv_recovery_v.getFecha_churn(),deals_dtv_recovery_v.getFecha_hora_lectura_contrato(),deals_dtv_recovery_v.getFecha_va(),deals_dtv_recovery_v.getMotivo_cancelacion(),deals_dtv_recovery_v.getDirectvgo(),deals_dtv_recovery_v.getExtension_asesor(),deals_dtv_recovery_v.getLider_Coordinador_SERVIMERCADEO(),deals_dtv_recovery_v.getProducto_TV(),deals_dtv_recovery_v.getFecha_finalizacion_new(),deals_dtv_recovery_v.getCiudad(),deals_dtv_recovery_v.getCliente_nombre(),deals_dtv_recovery_v.getApellido_cliente(),deals_dtv_recovery_v.getCliente_id(),deals_dtv_recovery_v.getSector_economico(),deals_dtv_recovery_v.getBase_trabajada(),deals_dtv_recovery_v.getNumero_suscripciones(),deals_dtv_recovery_v.getProducto_net(),deals_dtv_recovery_v.getMercado(),deals_dtv_recovery_v.getTelefono_1(),deals_dtv_recovery_v.getTelefono_2());
        System.out.println("com.servi.cac.interfacemodels.delasDtvCol.insertarDatos()"+res);
        return res;
    }
    
}
