/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servi.cac.controllers;

import com.servi.cac.models.User;
import com.servi.cac.models.deals_dtv;
import com.servi.cac.models.deals_dtv_ecuador2;
import com.servi.cac.models.deals_dtv_recovery;
import com.servi.cac.models.deals_dtv_recovery_ecuador2;
import com.servi.cac.models.deals_recovery_hughescol;
import com.servi.cac.models.deals_recovery_hughes_ecu;
import com.servi.cac.models.deals_hughes_colombia2;
import com.servi.cac.models.deals_hughes_ecu;
import com.servi.cac.models.etapas;
import com.servi.cac.response.respuestaHttp;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Analitica
 */
@Controller
public class Consultas {

    @Autowired
    private HttpSession httpSession;
     
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/dtvcoldata")
    public ResponseEntity<List<deals_dtv>> dtvcol() {
        String sqletapas = "SELECT  status_id_bitrix,etapa_bitrix  FROM dbo.etapas WHERE pipeline_id=0";
        List<etapas> listetapas = jdbcTemplate.query(sqletapas, BeanPropertyRowMapper.newInstance(etapas.class));
        Set<String> status_id_bitrix_unicos = new HashSet<>();
        List<etapas> listetapasUnicos = new ArrayList<>();
        for (etapas etapa : listetapas) {
            if (etapa.getStatus_id_bitrix() != null && status_id_bitrix_unicos.add(etapa.getStatus_id_bitrix())) {
                // Si el nombre no está en el conjunto, agregarlo a la lista
                listetapasUnicos.add(etapa);
            }
        }
        Map<String, etapas> mapaEtapas = listetapasUnicos.stream()
                .filter(etapa -> etapa.getStatus_id_bitrix() != null)
                .distinct()
                .collect(Collectors.toMap(etapas::getStatus_id_bitrix, etapa -> etapa));

        String sql = "SELECT TOP (2000) * FROM dbo.deals_dtv";
        List<deals_dtv> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(deals_dtv.class));
        String sqldealsRecovery = "SELECT  * FROM dbo.deals_dtv_recovery";
        List<deals_dtv> listRecovery = jdbcTemplate.query(sqldealsRecovery, BeanPropertyRowMapper.newInstance(deals_dtv.class));

        for (deals_dtv object : list) {
            int validacion = 0;
            for (deals_dtv dealsRe : listRecovery) {
                if (object.getId_bitrix() == dealsRe.getId_bitrix()) {
                    validacion = 1;
                    String etapaS2 = "<select id=\"etapa_id" + String.valueOf(dealsRe.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                    for (etapas listx2 : listetapasUnicos) {
                        String selected2 = selectedOption(String.valueOf(listx2.getStatus_id_bitrix()), String.valueOf(dealsRe.getEtapa_id()));

                        etapaS2 += "<option value=\"" + listx2.getStatus_id_bitrix() + "\" " + selected2 + ">" + listx2.getEtapa_bitrix() + "</option>";
                    }
                    etapaS2 += "</select>";
                    mapaEtapas.get(dealsRe.getEtapa_id());
                    dealsRe.setEtapa_id(etapaS2);

                    new deals_dtv().cambiardatos(object, dealsRe);
                }
            }
            if (validacion == 0) {
                String etapaS = "<select id=\"etapa_id" + String.valueOf(object.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                for (etapas listx : listetapasUnicos) {
                    String selected = selectedOption(String.valueOf(listx.getStatus_id_bitrix()), String.valueOf(object.getEtapa_id()));
                    etapaS += "<option value=\"" + listx.getStatus_id_bitrix() + "\" " + selected + ">" + listx.getEtapa_bitrix() + "</option>";
                }
                etapaS += "</select>";
                mapaEtapas.get(object.getEtapa_id());
                object.setEtapa_id(etapaS);
            }

        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/datadtvecu")
    public ResponseEntity<List<deals_dtv_ecuador2>> dtvecu() {

        String sqletapas = "SELECT  status_id_bitrix,etapa_bitrix  FROM dbo.etapas WHERE pipeline_id=25";
        List<etapas> listetapas = jdbcTemplate.query(sqletapas, BeanPropertyRowMapper.newInstance(etapas.class));
        Set<String> status_id_bitrix_unicos = new HashSet<>();
        List<etapas> listetapasUnicos = new ArrayList<>();
        for (etapas etapa : listetapas) {
            if (etapa.getStatus_id_bitrix() != null && status_id_bitrix_unicos.add(etapa.getStatus_id_bitrix())) {
                // Si el nombre no está en el conjunto, agregarlo a la lista
                listetapasUnicos.add(etapa);
            }
        }
        Map<String, etapas> mapaEtapas = listetapasUnicos.stream()
                .filter(etapa -> etapa.getStatus_id_bitrix() != null)
                .distinct()
                .collect(Collectors.toMap(etapas::getStatus_id_bitrix, etapa -> etapa));

        String sql = "SELECT TOP (2000) * FROM dbo.deals_dtv_ecuador2";
        List<deals_dtv_ecuador2> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(deals_dtv_ecuador2.class));
        String sqldealsRecovery = "SELECT  * FROM dbo.deals_dtv_recovery_ecuador2";
        List<deals_dtv_ecuador2> listRecovery = jdbcTemplate.query(sqldealsRecovery, BeanPropertyRowMapper.newInstance(deals_dtv_ecuador2.class));

        for (deals_dtv_ecuador2 object : list) {
            int validacion = 0;
            for (deals_dtv_ecuador2 dealsReecu : listRecovery) {
                if (object.getId_bitrix() == dealsReecu.getId_bitrix()) {
                    validacion = 1;
                    String etapaS2 = "<select id=\"etapa_id" + String.valueOf(dealsReecu.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                    for (etapas listx2 : listetapasUnicos) {
                        String selected2 = selectedOption(String.valueOf(listx2.getStatus_id_bitrix()), String.valueOf(dealsReecu.getEtapa_id()));

                        etapaS2 += "<option value=\"" + listx2.getStatus_id_bitrix() + "\" " + selected2 + ">" + listx2.getEtapa_bitrix() + "</option>";
                    }
                    etapaS2 += "</select>";
                    mapaEtapas.get(dealsReecu.getEtapa_id());
                    dealsReecu.setEtapa_id(etapaS2);

                    new deals_dtv_ecuador2().cambiardatosecuador(object, dealsReecu);
                }
            }
            if (validacion == 0) {
                String etapaS = "<select id=\"etapa_id" + String.valueOf(object.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                for (etapas listx : listetapasUnicos) {
                    String selected = selectedOption(String.valueOf(listx.getStatus_id_bitrix()), String.valueOf(object.getEtapa_id()));
                    etapaS += "<option value=\"" + listx.getStatus_id_bitrix() + "\" " + selected + ">" + listx.getEtapa_bitrix() + "</option>";
                }
                etapaS += "</select>";
                mapaEtapas.get(object.getEtapa_id());
                object.setEtapa_id(etapaS);
            }

        }

        return ResponseEntity.ok(list);

    }

    @GetMapping("/datahgn")
    public ResponseEntity<List<deals_hughes_colombia2>> hughes() {

        String sqletapas = "SELECT  status_id_bitrix,etapa_bitrix  FROM dbo.etapas WHERE pipeline_id=11";
        List<etapas> listetapas = jdbcTemplate.query(sqletapas, BeanPropertyRowMapper.newInstance(etapas.class));
        Set<String> status_id_bitrix_unicos = new HashSet<>();
        List<etapas> listetapasUnicos = new ArrayList<>();
        for (etapas etapa : listetapas) {
            if (etapa.getStatus_id_bitrix() != null && status_id_bitrix_unicos.add(etapa.getStatus_id_bitrix())) {
                // Si el nombre no está en el conjunto, agregarlo a la lista
                listetapasUnicos.add(etapa);
            }
        }
        Map<String, etapas> mapaEtapas = listetapasUnicos.stream()
                .filter(etapa -> etapa.getStatus_id_bitrix() != null)
                .distinct()
                .collect(Collectors.toMap(etapas::getStatus_id_bitrix, etapa -> etapa));

        String sql = "SELECT TOP (2000) * FROM dbo.hughes_colombia2";
        List<deals_hughes_colombia2> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(deals_hughes_colombia2.class));
        String sqldealsRecovery = "SELECT  * FROM dbo.deals_recovery_hughescol";
        List<deals_hughes_colombia2> listRecovery = jdbcTemplate.query(sqldealsRecovery, BeanPropertyRowMapper.newInstance(deals_hughes_colombia2.class));

        for (deals_hughes_colombia2 object : list) {
            int validacion = 0;
            for (deals_hughes_colombia2 dealsRehug : listRecovery) {
                if (object.getId_bitrix() == dealsRehug.getId_bitrix()) {
                    validacion = 1;
                    String etapaS2 = "<select id=\"etapa_id" + String.valueOf(dealsRehug.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                    for (etapas listx2 : listetapasUnicos) {
                        String selected2 = selectedOption(String.valueOf(listx2.getStatus_id_bitrix()), String.valueOf(dealsRehug.getEtapa_id()));

                        etapaS2 += "<option value=\"" + listx2.getStatus_id_bitrix() + "\" " + selected2 + ">" + listx2.getEtapa_bitrix() + "</option>";
                    }
                    etapaS2 += "</select>";
                    mapaEtapas.get(dealsRehug.getEtapa_id());
                    dealsRehug.setEtapa_id(etapaS2);

                    new deals_hughes_colombia2().cambiardatoshughes(object, dealsRehug);
                }
            }
            if (validacion == 0) {
                String etapaS = "<select id=\"etapa_id" + String.valueOf(object.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                for (etapas listx : listetapasUnicos) {
                    String selected = selectedOption(String.valueOf(listx.getStatus_id_bitrix()), String.valueOf(object.getEtapa_id()));
                    etapaS += "<option value=\"" + listx.getStatus_id_bitrix() + "\" " + selected + ">" + listx.getEtapa_bitrix() + "</option>";
                }
                etapaS += "</select>";
                mapaEtapas.get(object.getEtapa_id());
                object.setEtapa_id(etapaS);
            }

        }
        return ResponseEntity.ok(list);
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,@CookieValue("JSESSIONID") String token) {
        
        String sql = "SELECT  *  FROM dbo.users WHERE email='"+email+"'";
        List<User>  list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       
        
        for (User user : list) {
            boolean isMatching = passwordEncoder.matches(password, user.getPassword());
            if(isMatching){
                httpSession.setAttribute("email",user.getEmail());
                httpSession.setAttribute("operacion",user.getOperation());
                httpSession.setAttribute("proceso",user.getProceso());
                        httpSession.setAttribute("token",token);
                break;
             }
        }
        return "redirect:/";
   
        
    }
   @PostMapping("/salir")
    public String salir(@CookieValue("JSESSIONID") String token) {
        
        
        httpSession.setAttribute("email",null);
        httpSession.setAttribute("operacion",null);
        httpSession.setAttribute("proceso",null);
        httpSession.setAttribute("token",null);
      
        return "redirect:/";
   
        
    }
    @GetMapping("/datahgnecu")
    public ResponseEntity<List<deals_hughes_ecu>> hughesecu() {
        
        String sqletapas = "SELECT  status_id_bitrix,etapa_bitrix  FROM dbo.etapas WHERE pipeline_id=9";
        List<etapas> listetapas = jdbcTemplate.query(sqletapas, BeanPropertyRowMapper.newInstance(etapas.class));
        Set<String> status_id_bitrix_unicos = new HashSet<>();
        List<etapas> listetapasUnicos = new ArrayList<>();
        for (etapas etapa : listetapas) {
            if (etapa.getStatus_id_bitrix() != null && status_id_bitrix_unicos.add(etapa.getStatus_id_bitrix())) {
                // Si el nombre no está en el conjunto, agregarlo a la lista
                listetapasUnicos.add(etapa);
            }
        }
        Map<String, etapas> mapaEtapas = listetapasUnicos.stream()
                .filter(etapa -> etapa.getStatus_id_bitrix() != null)
                .distinct()
                .collect(Collectors.toMap(etapas::getStatus_id_bitrix, etapa -> etapa));

        String sql = "SELECT TOP (2000) * FROM dbo.hugHes_EC";
        List<deals_hughes_ecu> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(deals_hughes_ecu.class));
        String sqldealsRecovery = "SELECT  * FROM dbo.deals_recovery_hugHes_EC";
        List<deals_hughes_ecu> listRecovery = jdbcTemplate.query(sqldealsRecovery, BeanPropertyRowMapper.newInstance(deals_hughes_ecu.class));

        for (deals_hughes_ecu object : list) {
            int validacion = 0;
            for (deals_hughes_ecu dealsRehugecu : listRecovery) {
                if (object.getId_bitrix() == dealsRehugecu.getId_bitrix()) {
                    validacion = 1;
                    String etapaS2 = "<select id=\"etapa_id" + String.valueOf(dealsRehugecu.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                    for (etapas listx2 : listetapasUnicos) {
                        String selected2 = selectedOption(String.valueOf(listx2.getStatus_id_bitrix()), String.valueOf(dealsRehugecu.getEtapa_id()));

                        etapaS2 += "<option value=\"" + listx2.getStatus_id_bitrix() + "\" " + selected2 + ">" + listx2.getEtapa_bitrix() + "</option>";
                    }
                    etapaS2 += "</select>";
                    mapaEtapas.get(dealsRehugecu.getEtapa_id());
                    dealsRehugecu.setEtapa_id(etapaS2);

                    new deals_hughes_ecu().cambiardatoshughesecu(object, dealsRehugecu);
                }
            }
            if (validacion == 0) {
                String etapaS = "<select id=\"etapa_id" + String.valueOf(object.getId_bitrix()) + "\" class=\"form-select\" aria-label=\"Default select example\">";
                for (etapas listx : listetapasUnicos) {
                    String selected = selectedOption(String.valueOf(listx.getStatus_id_bitrix()), String.valueOf(object.getEtapa_id()));
                    etapaS += "<option value=\"" + listx.getStatus_id_bitrix() + "\" " + selected + ">" + listx.getEtapa_bitrix() + "</option>";
                }
                etapaS += "</select>";
                mapaEtapas.get(object.getEtapa_id());
                object.setEtapa_id(etapaS);
            }

        }

        return ResponseEntity.ok(list);
    }

    public String selectedOption(String v1, String v2) {
        if (v1.equals(v2)) {
            return "selected";
        } else {
            return "";
        }

    }

    @PostMapping("/guardarinfodtvcol")
    public ResponseEntity<respuestaHttp> guardar(@RequestBody deals_dtv deals) {
        respuestaHttp h = new respuestaHttp(200, "completada");

        deals_dtv_recovery ds = new deals_dtv_recovery(jdbcTemplate);
        deals_dtv dsoriginal = new deals_dtv(jdbcTemplate);
        int id_bitrix = deals.getId_bitrix();
        String category_id = deals.getCategory_id() == null ? "" : deals.getCategory_id().equals("UNKNOWN") ? "" : deals.getCategory_id();
        String etapa_id = deals.getEtapa_id() == null ? "" : deals.getEtapa_id().equals("UNKNOWN") ? "" : deals.getEtapa_id();
        String fase_id = deals.getFase_id() == null ? "" : deals.getFase_id().equals("UNKNOWN") ? "" : deals.getFase_id();
        String aliado_id = deals.getAliado_id() == null ? "" : deals.getAliado_id().equals("UNKNOWN") ? "" : deals.getAliado_id();
        String contacto_id = deals.getContacto_id() == null ? "" : deals.getContacto_id().equals("UNKNOWN") ? "" : deals.getContacto_id();
        String fecha_inicio = deals.getFecha_inicio() == null ? "" : deals.getFecha_inicio().equals("UNKNOWN") ? "" : deals.getFecha_inicio();
        String fecha_cierre = deals.getFecha_cierre() == null ? "" : deals.getFecha_cierre().equals("UNKNOWN") ? "" : deals.getFecha_cierre();
        String asignado = deals.getAsignado() == null ? "" : deals.getAsignado().equals("UNKNOWN") ? "" : deals.getAsignado();
        String creado_por = deals.getCreado_por() == null ? "" : deals.getCreado_por().equals("UNKNOWN") ? "" : deals.getCreado_por();
        String modificado_por = deals.getModificado_por() == null ? "" : deals.getModificado_por().equals("UNKNOWN") ? "" : deals.getModificado_por();
        String fecha_creacion = deals.getFecha_creacion() == null ? "" : deals.getFecha_creacion().equals("UNKNOWN") ? "" : deals.getFecha_creacion();
        String fecha_modificacion = deals.getFecha_modificacion() == null ? "" : deals.getFecha_modificacion().equals("UNKNOWN") ? "" : deals.getFecha_modificacion();
        String source_id = deals.getSource_id() == null ? "" : deals.getSource_id().equals("UNKNOWN") ? "" : deals.getSource_id();
        String lead_id = deals.getLead_id() == null ? "" : deals.getLead_id().equals("UNKNOWN") ? "" : deals.getLead_id();
        String valor_churn = deals.getValor_churn() == null ? "" : deals.getValor_churn().equals("UNKNOWN") ? "" : deals.getValor_churn();
        String linea_de_negocio_lead = deals.getLinea_de_negocio_lead() == null ? "" : deals.getLinea_de_negocio_lead().equals("UNKNOWN") ? "" : deals.getLinea_de_negocio_lead();
        String regional = deals.getRegional() == null ? "" : deals.getRegional().equals("UNKNOWN") ? "" : deals.getRegional();
        String fuente = deals.getFuente() == null ? "" : deals.getFuente().equals("UNKNOWN") ? "" : deals.getFuente();
        String canal = deals.getCanal() == null ? "" : deals.getCanal().equals("UNKNOWN") ? "" : deals.getCanal();
        String tipo_de_tramite = deals.getTipo_de_tramite() == null ? "" : deals.getTipo_de_tramite().equals("UNKNOWN") ? "" : deals.getTipo_de_tramite();
        String asesor_comercial = deals.getAsesor_comercial() == null ? "" : deals.getAsesor_comercial().equals("UNKNOWN") ? "" : deals.getAsesor_comercial();
        String comercial_servi = deals.getComercial_servi() == null ? "" : deals.getComercial_servi().equals("UNKNOWN") ? "" : deals.getComercial_servi();
        String aliado_crm = deals.getAliado_crm() == null ? "" : deals.getAliado_crm().equals("UNKNOWN") ? "" : deals.getAliado_crm();
        String tipo_cliente = deals.getTipo_cliente() == null ? "" : deals.getTipo_cliente().equals("UNKNOWN") ? "" : deals.getTipo_cliente();
        String genero = deals.getGenero() == null ? "" : deals.getGenero().equals("UNKNOWN") ? "" : deals.getGenero();
        String cedula = deals.getCedula() == null ? "" : deals.getCedula().equals("UNKNOWN") ? "" : deals.getCedula();
        String ibs = deals.getIbs() == null ? "" : deals.getIbs().equals("UNKNOWN") ? "" : deals.getIbs();
        String fecha_de_nacimiento = deals.getFecha_de_nacimiento() == null ? "" : deals.getFecha_de_nacimiento().equals("UNKNOWN") ? "" : deals.getFecha_de_nacimiento();
        String ubicacion_exacta = deals.getUbicacion_exacta() == null ? "" : deals.getUbicacion_exacta().equals("UNKNOWN") ? "" : deals.getUbicacion_exacta();
        String departamento = deals.getDepartamento() == null ? "" : deals.getDepartamento().equals("UNKNOWN") ? "" : deals.getDepartamento();
        String estrato = deals.getEstrato() == null ? "" : deals.getEstrato().equals("UNKNOWN") ? "" : deals.getEstrato();
        String tipo_de_venta = deals.getTipo_de_venta() == null ? "" : deals.getTipo_de_venta().equals("UNKNOWN") ? "" : deals.getTipo_de_venta();
        String metodo_pago = deals.getMetodo_pago() == null ? "" : deals.getMetodo_pago().equals("UNKNOWN") ? "" : deals.getMetodo_pago();
        String tipo_de_oferta = deals.getTipo_de_oferta() == null ? "" : deals.getTipo_de_oferta().equals("UNKNOWN") ? "" : deals.getTipo_de_oferta();
        String aplica_maratonazo = deals.getAplica_maratonazo() == null ? "" : deals.getAplica_maratonazo().equals("UNKNOWN") ? "" : deals.getAplica_maratonazo();
        String perimetro = deals.getPerimetro() == null ? "" : deals.getPerimetro().equals("UNKNOWN") ? "" : deals.getPerimetro();
        String disminucion_perimetro = deals.getDisminucion_perimetro() == null ? "" : deals.getDisminucion_perimetro().equals("UNKNOWN") ? "" : deals.getDisminucion_perimetro();
        String estado_de_consulta = deals.getEstado_de_consulta() == null ? "" : deals.getEstado_de_consulta().equals("UNKNOWN") ? "" : deals.getEstado_de_consulta();
        String encargado_consulta = deals.getEncargado_consulta() == null ? "" : deals.getEncargado_consulta().equals("UNKNOWN") ? "" : deals.getEncargado_consulta();
        String fecha_de_consulta = deals.getFecha_de_consulta() == null ? "" : deals.getFecha_de_consulta().equals("UNKNOWN") ? "" : deals.getFecha_de_consulta();
        String hora_de_consulta = deals.getHora_de_consulta() == null ? "" : deals.getHora_de_consulta().equals("UNKNOWN") ? "" : deals.getHora_de_consulta();
        String encargado_validacion = deals.getEncargado_validacion() == null ? "" : deals.getEncargado_validacion().equals("UNKNOWN") ? "" : deals.getEncargado_validacion();
        String estado_evidente = deals.getEstado_evidente() == null ? "" : deals.getEstado_evidente().equals("UNKNOWN") ? "" : deals.getEstado_evidente();
        String acierta = deals.getAcierta() == null ? "" : deals.getAcierta().equals("UNKNOWN") ? "" : deals.getAcierta();
        String fecha_de_validacion = deals.getFecha_de_validacion() == null ? "" : deals.getFecha_de_validacion().equals("UNKNOWN") ? "" : deals.getFecha_de_validacion();
        String fecha_de_inicio = deals.getFecha_de_inicio() == null ? "" : deals.getFecha_de_inicio().equals("UNKNOWN") ? "" : deals.getFecha_de_inicio();
        String fecha_inicio_gestion = deals.getFecha_inicio_gestion() == null ? "" : deals.getFecha_inicio_gestion().equals("UNKNOWN") ? "" : deals.getFecha_inicio_gestion();
        String fecha_finalizacion = deals.getFecha_finalizacion() == null ? "" : deals.getFecha_finalizacion().equals("UNKNOWN") ? "" : deals.getFecha_finalizacion();
        String descuento_churn = deals.getDescuento_churn() == null ? "" : deals.getDescuento_churn().equals("UNKNOWN") ? "" : deals.getDescuento_churn();
        String fecha_churn = deals.getFecha_churn() == null ? "" : deals.getFecha_churn().equals("UNKNOWN") ? "" : deals.getFecha_churn();
        String fecha_hora_lectura_contrato = deals.getFecha_hora_lectura_contrato() == null ? "" : deals.getFecha_hora_lectura_contrato().equals("UNKNOWN") ? "" : deals.getFecha_hora_lectura_contrato();
        String fecha_va = deals.getFecha_va() == null ? "" : deals.getFecha_va().equals("UNKNOWN") ? "" : deals.getFecha_va();
        String motivo_cancelacion = deals.getMotivo_cancelacion() == null ? "" : deals.getMotivo_cancelacion().equals("UNKNOWN") ? "" : deals.getMotivo_cancelacion();
        String directvgo = deals.getDirectvgo() == null ? "" : deals.getDirectvgo().equals("UNKNOWN") ? "" : deals.getDirectvgo();
        String Extension_asesor = deals.getExtension_asesor() == null ? "" : deals.getExtension_asesor().equals("UNKNOWN") ? "" : deals.getExtension_asesor();
        String Lider_Coordinador_SERVIMERCADEO = deals.getLider_Coordinador_SERVIMERCADEO() == null ? "" : deals.getLider_Coordinador_SERVIMERCADEO().equals("UNKNOWN") ? "" : deals.getLider_Coordinador_SERVIMERCADEO();
        String Producto_TV = deals.getProducto_TV() == null ? "" : deals.getProducto_TV().equals("UNKNOWN") ? "" : deals.getProducto_TV();
        String fecha_finalizacion_new = deals.getFecha_finalizacion_new() == null ? "" : deals.getFecha_finalizacion_new().equals("UNKNOWN") ? "" : deals.getFecha_finalizacion_new();
        String Ciudad = deals.getCiudad() == null ? "" : deals.getCiudad().equals("UNKNOWN") ? "" : deals.getCiudad();
        String cliente_nombre = deals.getCliente_nombre() == null ? "" : deals.getCliente_nombre().equals("UNKNOWN") ? "" : deals.getCliente_nombre();
        String apellido_cliente = deals.getApellido_cliente() == null ? "" : deals.getApellido_cliente().equals("UNKNOWN") ? "" : deals.getApellido_cliente();
        String cliente_id = deals.getCliente_id() == null ? "" : deals.getCliente_id().equals("UNKNOWN") ? "" : deals.getCliente_id();
        String sector_economico = deals.getSector_economico() == null ? "" : deals.getSector_economico().equals("UNKNOWN") ? "" : deals.getSector_economico();
        String base_trabajada = deals.getBase_trabajada() == null ? "" : deals.getBase_trabajada().equals("UNKNOWN") ? "" : deals.getBase_trabajada();
        String numero_suscripciones = deals.getNumero_suscripciones() == null ? "" : deals.getNumero_suscripciones().equals("UNKNOWN") ? "" : deals.getNumero_suscripciones();
        String producto_net = deals.getProducto_net() == null ? "" : deals.getProducto_net().equals("UNKNOWN") ? "" : deals.getProducto_net();
        String mercado = deals.getMercado() == null ? "" : deals.getMercado().equals("UNKNOWN") ? "" : deals.getMercado();
        String telefono_1 = deals.getTelefono_1() == null ? "" : deals.getTelefono_1().equals("UNKNOWN") ? "" : deals.getTelefono_1();
        String telefono_2 = deals.getTelefono_2() == null ? "" : deals.getTelefono_2().equals("UNKNOWN") ? "" : deals.getTelefono_2();

        try {
            String sql = "INSERT INTO deals_dtv_recovery (id_bitrix,category_id,etapa_id,fase_id,aliado_id,contacto_id,fecha_inicio,fecha_cierre,asignado,creado_por,modificado_por,fecha_creacion,fecha_modificacion,source_id,lead_id,valor_churn,linea_de_negocio_lead,regional,fuente,canal,tipo_de_tramite,asesor_comercial,comercial_servi,aliado_crm,tipo_cliente,genero,cedula,ibs,fecha_de_nacimiento,ubicacion_exacta,departamento,estrato,tipo_de_venta,metodo_pago,tipo_de_oferta,aplica_maratonazo,perimetro,disminucion_perimetro,estado_de_consulta,encargado_consulta,fecha_de_consulta,hora_de_consulta,encargado_validacion,estado_evidente,acierta,fecha_de_validacion,fecha_de_inicio,fecha_inicio_gestion,fecha_finalizacion,descuento_churn,fecha_churn,fecha_hora_lectura_contrato,fecha_va,motivo_cancelacion,directvgo,Extension_asesor,Lider_Coordinador_SERVIMERCADEO,Producto_TV,fecha_finalizacion_new,Ciudad,cliente_nombre,apellido_cliente,cliente_id,sector_economico,base_trabajada,numero_suscripciones,producto_net,mercado,telefono_1,telefono_2 ) VALUES ( " + String.valueOf(id_bitrix) + ",'" + category_id + "','" + etapa_id + "','" + fase_id + "','" + aliado_id + "','" + contacto_id + "','" + fecha_inicio + "','" + fecha_cierre + "','" + asignado + "','" + creado_por + "','" + modificado_por + "','" + fecha_creacion + "','" + fecha_modificacion + "','" + source_id + "','" + lead_id + "','" + valor_churn + "','" + linea_de_negocio_lead + "','" + regional + "','" + fuente + "','" + canal + "','" + tipo_de_tramite + "','" + asesor_comercial + "','" + comercial_servi + "','" + aliado_crm + "','" + tipo_cliente + "','" + genero + "','" + cedula + "','" + ibs + "','" + fecha_de_nacimiento + "','" + ubicacion_exacta + "','" + departamento + "','" + estrato + "','" + tipo_de_venta + "','" + metodo_pago + "','" + tipo_de_oferta + "','" + aplica_maratonazo + "','" + perimetro + "','" + disminucion_perimetro + "','" + estado_de_consulta + "','" + encargado_consulta + "','" + fecha_de_consulta + "','" + hora_de_consulta + "','" + encargado_validacion + "','" + estado_evidente + "','" + acierta + "','" + fecha_de_validacion + "','" + fecha_de_inicio + "','" + fecha_inicio_gestion + "','" + fecha_finalizacion + "','" + descuento_churn + "','" + fecha_churn + "','" + fecha_hora_lectura_contrato + "','" + fecha_va + "','" + motivo_cancelacion + "','" + directvgo + "','" + Extension_asesor + "','" + Lider_Coordinador_SERVIMERCADEO + "','" + Producto_TV + "','" + fecha_finalizacion_new + "','" + Ciudad + "','" + cliente_nombre + "','" + apellido_cliente + "','" + cliente_id + "','" + sector_economico + "','" + base_trabajada + "','" + numero_suscripciones + "','" + producto_net + "','" + mercado + "','" + telefono_1 + "','" + telefono_2 + "')";

            int res = ds.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        } catch (Exception e) {
            String sql = "UPDATE  deals_dtv_recovery SET category_id='" + category_id + "',etapa_id='" + etapa_id + "',fase_id='" + fase_id + "',aliado_id='" + aliado_id + "',contacto_id='" + contacto_id + "',fecha_inicio='" + fecha_inicio + "',fecha_cierre='" + fecha_cierre + "',asignado='" + asignado + "',creado_por='" + creado_por + "',modificado_por='" + modificado_por + "',fecha_creacion='" + fecha_creacion + "',fecha_modificacion='" + fecha_modificacion + "',source_id='" + source_id + "',lead_id='" + lead_id + "',valor_churn='" + valor_churn + "',linea_de_negocio_lead='" + linea_de_negocio_lead + "',regional='" + regional + "',fuente='" + fuente + "',canal='" + canal + "',tipo_de_tramite='" + tipo_de_tramite + "',asesor_comercial='" + asesor_comercial + "',comercial_servi='" + comercial_servi + "',aliado_crm='" + aliado_crm + "',tipo_cliente='" + tipo_cliente + "',genero='" + genero + "',cedula='" + cedula + "',ibs='" + ibs + "',fecha_de_nacimiento='" + fecha_de_nacimiento + "',ubicacion_exacta='" + ubicacion_exacta + "',departamento='" + departamento + "',estrato='" + estrato + "',tipo_de_venta='" + tipo_de_venta + "',metodo_pago='" + metodo_pago + "',tipo_de_oferta='" + tipo_de_oferta + "',aplica_maratonazo='" + aplica_maratonazo + "',perimetro='" + perimetro + "',disminucion_perimetro='" + disminucion_perimetro + "',estado_de_consulta='" + estado_de_consulta + "',encargado_consulta='" + encargado_consulta + "',fecha_de_consulta='" + fecha_de_consulta + "',hora_de_consulta='" + hora_de_consulta + "',encargado_validacion='" + encargado_validacion + "',estado_evidente='" + estado_evidente + "',acierta='" + acierta + "',fecha_de_validacion='" + fecha_de_validacion + "',fecha_de_inicio='" + fecha_de_inicio + "',fecha_inicio_gestion='" + fecha_inicio_gestion + "',fecha_finalizacion='" + fecha_finalizacion + "',descuento_churn='" + descuento_churn + "',fecha_churn='" + fecha_churn + "',fecha_hora_lectura_contrato='" + fecha_hora_lectura_contrato + "',fecha_va='" + fecha_va + "',motivo_cancelacion='" + motivo_cancelacion + "',directvgo='" + directvgo + "',Extension_asesor='" + Extension_asesor + "',Lider_Coordinador_SERVIMERCADEO='" + Lider_Coordinador_SERVIMERCADEO + "',Producto_TV='" + Producto_TV + "',fecha_finalizacion_new='" + fecha_finalizacion_new + "',Ciudad='" + Ciudad + "',cliente_nombre='" + cliente_nombre + "',apellido_cliente='" + apellido_cliente + "',cliente_id='" + cliente_id + "',sector_economico='" + sector_economico + "',base_trabajada='" + base_trabajada + "',numero_suscripciones='" + numero_suscripciones + "',producto_net='" + producto_net + "',mercado='" + mercado + "',telefono_1='" + telefono_1 + "',telefono_2='" + telefono_2 + "' WHERE id_bitrix=" + String.valueOf(id_bitrix) + "";

            int res = ds.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        }

    }

    @PostMapping("/guardarinfodtvecu")
    public ResponseEntity<respuestaHttp> guardar(@RequestBody deals_dtv_ecuador2 deals) {
        respuestaHttp h = new respuestaHttp(200, "completada");

        deals_dtv_recovery_ecuador2 dse = new deals_dtv_recovery_ecuador2(jdbcTemplate);
        deals_dtv_ecuador2 dsoriginal2 = new deals_dtv_ecuador2(jdbcTemplate);
        int id_bitrix = deals.getId_bitrix();
        String category_id = deals.getCategory_id() == null || "UNKNOWN".equals(deals.getCategory_id()) ? "" : deals.getCategory_id();
        String etapa_id = deals.getEtapa_id() == null || "UNKNOWN".equals(deals.getEtapa_id()) ? "" : deals.getEtapa_id();
        String fase_id = deals.getFase_id() == null || "UNKNOWN".equals(deals.getFase_id()) ? "" : deals.getFase_id();
        String aliado_id = deals.getAliado_id() == null || "UNKNOWN".equals(deals.getAliado_id()) ? "" : deals.getAliado_id();
        String contacto_id = deals.getContacto_id() == null || "UNKNOWN".equals(deals.getContacto_id()) ? "" : deals.getContacto_id();
        String fecha_inicio = deals.getFecha_inicio() == null || "UNKNOWN".equals(deals.getFecha_inicio()) ? "" : deals.getFecha_inicio();
        String fecha_cierre = deals.getFecha_cierre() == null || "UNKNOWN".equals(deals.getFecha_cierre()) ? "" : deals.getFecha_cierre();
        String asignado = deals.getAsignado() == null || "UNKNOWN".equals(deals.getAsignado()) ? "" : deals.getAsignado();
        String creado_por = deals.getCreado_por() == null || "UNKNOWN".equals(deals.getCreado_por()) ? "" : deals.getCreado_por();
        String modificado_por = deals.getModificado_por() == null || "UNKNOWN".equals(deals.getModificado_por()) ? "" : deals.getModificado_por();
        String fecha_creacion = deals.getFecha_creacion() == null || "UNKNOWN".equals(deals.getFecha_creacion()) ? "" : deals.getFecha_creacion();
        String fecha_modificacion = deals.getFecha_modificacion() == null || "UNKNOWN".equals(deals.getFecha_modificacion()) ? "" : deals.getFecha_modificacion();
        String source_id = deals.getSource_id() == null || "UNKNOWN".equals(deals.getSource_id()) ? "" : deals.getSource_id();
        String lead_id = deals.getLead_id() == null || "UNKNOWN".equals(deals.getLead_id()) ? "" : deals.getLead_id();
        String valor_churn = deals.getValor_churn() == null || "UNKNOWN".equals(deals.getValor_churn()) ? "" : deals.getValor_churn();
        String linea_de_negocio_lead = deals.getLinea_de_negocio_lead() == null || "UNKNOWN".equals(deals.getLinea_de_negocio_lead()) ? "" : deals.getLinea_de_negocio_lead();
        String regional = deals.getRegional() == null || "UNKNOWN".equals(deals.getRegional()) ? "" : deals.getRegional();
        String fuente = deals.getFuente() == null || "UNKNOWN".equals(deals.getFuente()) ? "" : deals.getFuente();
        String canal = deals.getCanal() == null || "UNKNOWN".equals(deals.getCanal()) ? "" : deals.getCanal();
        String tipo_de_tramite = deals.getTipo_de_tramite() == null || "UNKNOWN".equals(deals.getTipo_de_tramite()) ? "" : deals.getTipo_de_tramite();
        String asesor_comercial = deals.getAsesor_comercial() == null || "UNKNOWN".equals(deals.getAsesor_comercial()) ? "" : deals.getAsesor_comercial();
        String comercial_servi = deals.getComercial_servi() == null || "UNKNOWN".equals(deals.getComercial_servi()) ? "" : deals.getComercial_servi();
        String aliado_crm = deals.getAliado_crm() == null || "UNKNOWN".equals(deals.getAliado_crm()) ? "" : deals.getAliado_crm();
        String tipo_cliente = deals.getTipo_cliente() == null || "UNKNOWN".equals(deals.getTipo_cliente()) ? "" : deals.getTipo_cliente();
        String genero = deals.getGenero() == null || "UNKNOWN".equals(deals.getGenero()) ? "" : deals.getGenero();
        String cedula = deals.getCedula() == null || "UNKNOWN".equals(deals.getCedula()) ? "" : deals.getCedula();
        String ibs = deals.getIbs() == null || "UNKNOWN".equals(deals.getIbs()) ? "" : deals.getIbs();
        String fecha_de_nacimiento = deals.getFecha_de_nacimiento() == null || "UNKNOWN".equals(deals.getFecha_de_nacimiento()) ? "" : deals.getFecha_de_nacimiento();
        String ubicacion_exacta = deals.getUbicacion_exacta() == null || "UNKNOWN".equals(deals.getUbicacion_exacta()) ? "" : deals.getUbicacion_exacta();
        String provincia = deals.getProvincia() == null || "UNKNOWN".equals(deals.getProvincia()) ? "" : deals.getProvincia();
        String estrato = deals.getEstrato() == null || "UNKNOWN".equals(deals.getEstrato()) ? "" : deals.getEstrato();
        String tipo_de_venta = deals.getTipo_de_venta() == null || "UNKNOWN".equals(deals.getTipo_de_venta()) ? "" : deals.getTipo_de_venta();
        String metodo_pago = deals.getMetodo_pago() == null || "UNKNOWN".equals(deals.getMetodo_pago()) ? "" : deals.getMetodo_pago();
        String tipo_de_oferta = deals.getTipo_de_oferta() == null || "UNKNOWN".equals(deals.getTipo_de_oferta()) ? "" : deals.getTipo_de_oferta();
        String aplica_maratonazo = deals.getAplica_maratonazo() == null || "UNKNOWN".equals(deals.getAplica_maratonazo()) ? "" : deals.getAplica_maratonazo();
        String perimetro = deals.getPerimetro() == null || "UNKNOWN".equals(deals.getPerimetro()) ? "" : deals.getPerimetro();
        String disminucion_perimetro = deals.getDisminucion_perimetro() == null || "UNKNOWN".equals(deals.getDisminucion_perimetro()) ? "" : deals.getDisminucion_perimetro();
        String estado_de_consulta = deals.getEstado_de_consulta() == null || "UNKNOWN".equals(deals.getEstado_de_consulta()) ? "" : deals.getEstado_de_consulta();
        String encargado_consulta = deals.getEncargado_consulta() == null || "UNKNOWN".equals(deals.getEncargado_consulta()) ? "" : deals.getEncargado_consulta();
        String fecha_de_consulta = deals.getFecha_de_consulta() == null || "UNKNOWN".equals(deals.getFecha_de_consulta()) ? "" : deals.getFecha_de_consulta();
        String hora_de_consulta = deals.getHora_de_consulta() == null || "UNKNOWN".equals(deals.getHora_de_consulta()) ? "" : deals.getHora_de_consulta();
        String encargado_validacion = deals.getEncargado_validacion() == null || "UNKNOWN".equals(deals.getEncargado_validacion()) ? "" : deals.getEncargado_validacion();
        String estado_evidente = deals.getEstado_evidente() == null || "UNKNOWN".equals(deals.getEstado_evidente()) ? "" : deals.getEstado_evidente();
        String acierta = deals.getAcierta() == null || "UNKNOWN".equals(deals.getAcierta()) ? "" : deals.getAcierta();
        String fecha_de_validacion = deals.getFecha_de_validacion() == null || "UNKNOWN".equals(deals.getFecha_de_validacion()) ? "" : deals.getFecha_de_validacion();
        String fecha_de_inicio = deals.getFecha_de_inicio() == null || "UNKNOWN".equals(deals.getFecha_de_inicio()) ? "" : deals.getFecha_de_inicio();
        String fecha_inicio_gestion = deals.getFecha_inicio_gestion() == null || "UNKNOWN".equals(deals.getFecha_inicio_gestion()) ? "" : deals.getFecha_inicio_gestion();
        String fecha_finalizacion = deals.getFecha_finalizacion() == null || "UNKNOWN".equals(deals.getFecha_finalizacion()) ? "" : deals.getFecha_finalizacion();
        String descuento_churn = deals.getDescuento_churn() == null || "UNKNOWN".equals(deals.getDescuento_churn()) ? "" : deals.getDescuento_churn();
        String fecha_churn = deals.getFecha_churn() == null || "UNKNOWN".equals(deals.getFecha_churn()) ? "" : deals.getFecha_churn();
        String fecha_hora_lectura_contrato = deals.getFecha_hora_lectura_contrato() == null || "UNKNOWN".equals(deals.getFecha_hora_lectura_contrato()) ? "" : deals.getFecha_hora_lectura_contrato();
        String fecha_va = deals.getFecha_va() == null || "UNKNOWN".equals(deals.getFecha_va()) ? "" : deals.getFecha_va();
        String motivo_cancelacion = deals.getMotivo_cancelacion() == null || "UNKNOWN".equals(deals.getMotivo_cancelacion()) ? "" : deals.getMotivo_cancelacion();
        String directvgo = deals.getDirectvgo() == null || "UNKNOWN".equals(deals.getDirectvgo()) ? "" : deals.getDirectvgo();
        String Producto_TV = deals.getProducto_TV() == null || "UNKNOWN".equals(deals.getProducto_TV()) ? "" : deals.getProducto_TV();
        String Nombre_Asesor = deals.getNombre_Asesor() == null || "UNKNOWN".equals(deals.getNombre_Asesor()) ? "" : deals.getNombre_Asesor();
        String Provincia_asesor = deals.getProvincia_asesor() == null || "UNKNOWN".equals(deals.getProvincia_asesor()) ? "" : deals.getProvincia_asesor();
        String Cantidad_decos_adicionales = deals.getCantidad_decos_adicionales() == null || "UNKNOWN".equals(deals.getCantidad_decos_adicionales()) ? "" : deals.getCantidad_decos_adicionales();
        String Regularizado = deals.getRegularizado() == null || "UNKNOWN".equals(deals.getRegularizado()) ? "" : deals.getRegularizado();
        String Lugar_venta = deals.getLugar_venta() == null || "UNKNOWN".equals(deals.getLugar_venta()) ? "" : deals.getLugar_venta();
        String Producto_NET = deals.getProducto_NET() == null || "UNKNOWN".equals(deals.getProducto_NET()) ? "" : deals.getProducto_NET();
        try {
            String sql = "INSERT INTO deals_dtv_recovery_ecuador2 (id_bitrix, category_id, etapa_id, fase_id, aliado_id, contacto_id, fecha_inicio, fecha_cierre, asignado, creado_por, modificado_por, fecha_creacion, fecha_modificacion, source_id, lead_id, valor_churn, linea_de_negocio_lead, regional, fuente, canal, tipo_de_tramite, asesor_comercial, comercial_servi, aliado_crm, tipo_cliente, genero, cedula, ibs, fecha_de_nacimiento, ubicacion_exacta, provincia, estrato, tipo_de_venta, metodo_pago, tipo_de_oferta, aplica_maratonazo, perimetro, disminucion_perimetro, estado_de_consulta, encargado_consulta, fecha_de_consulta, hora_de_consulta, encargado_validacion, estado_evidente, acierta, fecha_de_validacion, fecha_de_inicio, fecha_inicio_gestion, fecha_finalizacion, descuento_churn, fecha_churn, fecha_hora_lectura_contrato, fecha_va, motivo_cancelacion, directvgo, Producto_TV, Nombre_Asesor, Provincia_asesor, Cantidad_decos_adicionales, Regularizado, Lugar_venta, Producto_NET) VALUES (" + id_bitrix + ",'" + category_id + "','" + etapa_id + "','" + fase_id + "','" + aliado_id + "','" + contacto_id + "','" + fecha_inicio + "','" + fecha_cierre + "','" + asignado + "','" + creado_por + "','" + modificado_por + "','" + fecha_creacion + "','" + fecha_modificacion + "','" + source_id + "','" + lead_id + "','" + valor_churn + "','" + linea_de_negocio_lead + "','" + regional + "','" + fuente + "','" + canal + "','" + tipo_de_tramite + "','" + asesor_comercial + "','" + comercial_servi + "','" + aliado_crm + "','" + tipo_cliente + "','" + genero + "','" + cedula + "','" + ibs + "','" + fecha_de_nacimiento + "','" + ubicacion_exacta + "','" + provincia + "','" + estrato + "','" + tipo_de_venta + "','" + metodo_pago + "','" + tipo_de_oferta + "','" + aplica_maratonazo + "','" + perimetro + "','" + disminucion_perimetro + "','" + estado_de_consulta + "','" + encargado_consulta + "','" + fecha_de_consulta + "','" + hora_de_consulta + "','" + encargado_validacion + "','" + estado_evidente + "','" + acierta + "','" + fecha_de_validacion + "','" + fecha_de_inicio + "','" + fecha_inicio_gestion + "','" + fecha_finalizacion + "','" + descuento_churn + "','" + fecha_churn + "','" + fecha_hora_lectura_contrato + "','" + fecha_va + "','" + motivo_cancelacion + "','" + directvgo + "','" + Producto_TV + "','" + Nombre_Asesor + "','" + Provincia_asesor + "','" + Cantidad_decos_adicionales + "','" + Regularizado + "','" + Lugar_venta + "','" + Producto_NET + "')";

            int res = dse.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        } catch (Exception e) {
            String sql = "UPDATE deals_dtv_recovery_ecuador2 SET " + "category_id='" + category_id + "'," + "etapa_id='" + etapa_id + "'," + "fase_id='" + fase_id + "'," + "aliado_id='" + aliado_id + "'," + "contacto_id='" + contacto_id + "'," + "fecha_inicio='" + fecha_inicio + "'," + "fecha_cierre='" + fecha_cierre + "'," + "asignado='" + asignado + "'," + "creado_por='" + creado_por + "'," + "modificado_por='" + modificado_por + "'," + "fecha_creacion='" + fecha_creacion + "'," + "fecha_modificacion='" + fecha_modificacion + "'," + "source_id='" + source_id + "'," + "lead_id='" + lead_id + "'," + "valor_churn='" + valor_churn + "'," + "linea_de_negocio_lead='" + linea_de_negocio_lead + "'," + "regional='" + regional + "'," + "fuente='" + fuente + "'," + "canal='" + canal + "'," + "tipo_de_tramite='" + tipo_de_tramite + "'," + "asesor_comercial='" + asesor_comercial + "'," + "comercial_servi='" + comercial_servi + "'," + "aliado_crm='" + aliado_crm + "'," + "tipo_cliente='" + tipo_cliente + "'," + "genero='" + genero + "'," + "cedula='" + cedula + "'," + "ibs='" + ibs + "'," + "fecha_de_nacimiento='" + fecha_de_nacimiento + "'," + "ubicacion_exacta='" + ubicacion_exacta + "'," + "provincia='" + provincia + "'," + "estrato='" + estrato + "'," + "tipo_de_venta='" + tipo_de_venta + "'," + "metodo_pago='" + metodo_pago + "'," + "tipo_de_oferta='" + tipo_de_oferta + "'," + "aplica_maratonazo='" + aplica_maratonazo + "'," + "perimetro='" + perimetro + "'," + "disminucion_perimetro='" + disminucion_perimetro + "'," + "estado_de_consulta='" + estado_de_consulta + "'," + "encargado_consulta='" + encargado_consulta + "'," + "fecha_de_consulta='" + fecha_de_consulta + "'," + "hora_de_consulta='" + hora_de_consulta + "'," + "encargado_validacion='" + encargado_validacion + "'," + "estado_evidente='" + estado_evidente + "'," + "acierta='" + acierta + "'," + "fecha_de_validacion='" + fecha_de_validacion + "'," + "fecha_de_inicio='" + fecha_de_inicio + "'," + "fecha_inicio_gestion='" + fecha_inicio_gestion + "'," + "fecha_finalizacion='" + fecha_finalizacion + "'," + "descuento_churn='" + descuento_churn + "'," + "fecha_churn='" + fecha_churn + "'," + "fecha_hora_lectura_contrato='" + fecha_hora_lectura_contrato + "'," + "fecha_va='" + fecha_va + "'," + "motivo_cancelacion='" + motivo_cancelacion + "'," + "directvgo='" + directvgo + "'," + "Producto_TV='" + Producto_TV + "'," + "Nombre_Asesor='" + Nombre_Asesor + "'," + "Provincia_asesor='" + Provincia_asesor + "'," + "Cantidad_decos_adicionales='" + Cantidad_decos_adicionales + "'," + "Regularizado='" + Regularizado + "'," + "Lugar_venta='" + Lugar_venta + "'," + "Producto_NET='" + Producto_NET + "'" + "WHERE id_bitrix=" + String.valueOf(id_bitrix) + "";

            int res = dse.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        }

    }

    @PostMapping("/guardarinfohughes")
    public ResponseEntity<respuestaHttp> guardar(@RequestBody deals_hughes_colombia2 deals) {
        respuestaHttp h = new respuestaHttp(200, "completada");

        deals_recovery_hughescol dsh = new deals_recovery_hughescol(jdbcTemplate);
        deals_hughes_colombia2 dsoriginal3 = new deals_hughes_colombia2(jdbcTemplate);
        int id_bitrix = deals.getId_bitrix();
        String category_id = deals.getCategory_id() == null || "UNKNOWN".equals(deals.getCategory_id()) ? "" : deals.getCategory_id();
        String etapa_id = deals.getEtapa_id() == null || "UNKNOWN".equals(deals.getEtapa_id()) ? "" : deals.getEtapa_id();
        String fase_id = deals.getFase_id() == null || "UNKNOWN".equals(deals.getFase_id()) ? "" : deals.getFase_id();
        String aliado_id = deals.getAliado_id() == null || "UNKNOWN".equals(deals.getAliado_id()) ? "" : deals.getAliado_id();
        String contacto_id = deals.getContacto_id() == null || "UNKNOWN".equals(deals.getContacto_id()) ? "" : deals.getContacto_id();
        String fecha_inicio = deals.getFecha_inicio() == null || "UNKNOWN".equals(deals.getFecha_inicio()) ? "" : deals.getFecha_inicio();
        String fecha_cierre = deals.getFecha_cierre() == null || "UNKNOWN".equals(deals.getFecha_cierre()) ? "" : deals.getFecha_cierre();
        String fecha_cupon = deals.getFecha_cupon() == null || "UNKNOWN".equals(deals.getFecha_cupon()) ? "" : deals.getFecha_cupon();
        String fecha_creacion = deals.getFecha_creacion() == null || "UNKNOWN".equals(deals.getFecha_creacion()) ? "" : deals.getFecha_creacion();
        String fecha_modificacion = deals.getFecha_modificacion() == null || "UNKNOWN".equals(deals.getFecha_modificacion()) ? "" : deals.getFecha_modificacion();
        String fecha_de_nacimiento = deals.getFecha_de_nacimiento() == null || "UNKNOWN".equals(deals.getFecha_de_nacimiento()) ? "" : deals.getFecha_de_nacimiento();
        String hora_de_consulta = deals.getHora_de_consulta() == null || "UNKNOWN".equals(deals.getHora_de_consulta()) ? "" : deals.getHora_de_consulta();
        String fecha_inicio_gestion = deals.getFecha_inicio_gestion() == null || "UNKNOWN".equals(deals.getFecha_inicio_gestion()) ? "" : deals.getFecha_inicio_gestion();
        String fecha_churn = deals.getFecha_churn() == null || "UNKNOWN".equals(deals.getFecha_churn()) ? "" : deals.getFecha_churn();
        String fecha_activacion = deals.getFecha_activacion() == null || "UNKNOWN".equals(deals.getFecha_activacion()) ? "" : deals.getFecha_activacion();
        String encargado_validacion = deals.getEncargado_validacion() == null || "UNKNOWN".equals(deals.getEncargado_validacion()) ? "" : deals.getEncargado_validacion();
        String creado_por = deals.getCreado_por() == null || "UNKNOWN".equals(deals.getCreado_por()) ? "" : deals.getCreado_por();
        String asignado = deals.getAsignado() == null || "UNKNOWN".equals(deals.getAsignado()) ? "" : deals.getAsignado();
        String modificado_por = deals.getModificado_por() == null || "UNKNOWN".equals(deals.getModificado_por()) ? "" : deals.getModificado_por();
        String valor_churn = deals.getValor_churn() == null || "UNKNOWN".equals(deals.getValor_churn()) ? "" : deals.getValor_churn();
        String tipo_cliente_id = deals.getTipo_cliente_id() == null || "UNKNOWN".equals(deals.getTipo_cliente_id()) ? "" : deals.getTipo_cliente_id();
        String genero_id = deals.getGenero_id() == null || "UNKNOWN".equals(deals.getGenero_id()) ? "" : deals.getGenero_id();
        String cedula = deals.getCedula() == null || "UNKNOWN".equals(deals.getCedula()) ? "" : deals.getCedula();
        String ubicacion_exacta = deals.getUbicacion_exacta() == null || "UNKNOWN".equals(deals.getUbicacion_exacta()) ? "" : deals.getUbicacion_exacta();
        String estrato = deals.getEstrato() == null || "UNKNOWN".equals(deals.getEstrato()) ? "" : deals.getEstrato();
        String descuento_churn = deals.getDescuento_churn() == null || "UNKNOWN".equals(deals.getDescuento_churn()) ? "" : deals.getDescuento_churn();
        String codigo_san = deals.getCodigo_san() == null || "UNKNOWN".equals(deals.getCodigo_san()) ? "" : deals.getCodigo_san();
        String departamento = deals.getDepartamento() == null || "UNKNOWN".equals(deals.getDepartamento()) ? "" : deals.getDepartamento();
        String regional_col = deals.getRegional_col() == null || "UNKNOWN".equals(deals.getRegional_col()) ? "" : deals.getRegional_col();
        String motivo_novedad_sym = deals.getMotivo_novedad_sym() == null || "UNKNOWN".equals(deals.getMotivo_novedad_sym()) ? "" : deals.getMotivo_novedad_sym();
        String lead_id = deals.getLead_id() == null || "UNKNOWN".equals(deals.getLead_id()) ? "" : deals.getLead_id();
        String fuente_sym_id = deals.getFuente_sym_id() == null || "UNKNOWN".equals(deals.getFuente_sym_id()) ? "" : deals.getFuente_sym_id();
        String linea_de_negocio_lead_id = deals.getLinea_de_negocio_lead_id() == null || "UNKNOWN".equals(deals.getLinea_de_negocio_lead_id()) ? "" : deals.getLinea_de_negocio_lead_id();
        String source_id = deals.getSource_id() == null || "UNKNOWN".equals(deals.getSource_id()) ? "" : deals.getSource_id();
        String fuente_id = deals.getFuente_id() == null || "UNKNOWN".equals(deals.getFuente_id()) ? "" : deals.getFuente_id();
        String ciudad_municipio = deals.getCiudad_municipio() == null || "UNKNOWN".equals(deals.getCiudad_municipio()) ? "" : deals.getCiudad_municipio();
        String zona_instalacion = deals.getZona_instalacion() == null || "UNKNOWN".equals(deals.getZona_instalacion()) ? "" : deals.getZona_instalacion();
        String comercial_sym = deals.getComercial_sym() == null || "UNKNOWN".equals(deals.getComercial_sym()) ? "" : deals.getComercial_sym();
        String dealer_sym = deals.getDealer_sym() == null || "UNKNOWN".equals(deals.getDealer_sym()) ? "" : deals.getDealer_sym();
        String aliado_crm_id = deals.getAliado_crm_id() == null || "UNKNOWN".equals(deals.getAliado_crm_id()) ? "" : deals.getAliado_crm_id();
        String sucursal = deals.getSucursal() == null || "UNKNOWN".equals(deals.getSucursal()) ? "" : deals.getSucursal();
        String contratoDigital = deals.getContratoDigital() == null || "UNKNOWN".equals(deals.getContratoDigital()) ? "" : deals.getContratoDigital();
        String TXT_TELEFONO = deals.getTXT_TELEFONO() == null || "UNKNOWN".equals(deals.getTXT_TELEFONO()) ? "" : deals.getTXT_TELEFONO();
        String TXT_TELEFONO_2 = deals.getTXT_TELEFONO_2() == null || "UNKNOWN".equals(deals.getTXT_TELEFONO_2()) ? "" : deals.getTXT_TELEFONO_2();
        String TXT_CORREO = deals.getTXT_CORREO() == null || "UNKNOWN".equals(deals.getTXT_CORREO()) ? "" : deals.getTXT_CORREO();
        String TXT_ALI_SUCURSAL = deals.getTXT_ALI_SUCURSAL() == null || "UNKNOWN".equals(deals.getTXT_ALI_SUCURSAL()) ? "" : deals.getTXT_ALI_SUCURSAL();
        String NUM_ID_ALIADO = deals.getNUM_ID_ALIADO() == null || "UNKNOWN".equals(deals.getNUM_ID_ALIADO()) ? "" : deals.getNUM_ID_ALIADO();
        String BIT_FIRMA_HUGHES = deals.getBIT_FIRMA_HUGHES() == null || "UNKNOWN".equals(deals.getBIT_FIRMA_HUGHES()) ? "" : deals.getBIT_FIRMA_HUGHES();
        String Fec_factura_sym = deals.getFec_factura_sym() == null || "UNKNOWN".equals(deals.getFec_factura_sym()) ? "" : deals.getFec_factura_sym();
        String Nombre_Cliente = deals.getNombre_Cliente() == null || "UNKNOWN".equals(deals.getNombre_Cliente()) ? "" : deals.getNombre_Cliente();
        String Apellido_Cliente = deals.getApellido_Cliente() == null || "UNKNOWN".equals(deals.getApellido_Cliente()) ? "" : deals.getApellido_Cliente();
        String fecha_finalizacion = deals.getFecha_finalizacion() == null || "UNKNOWN".equals(deals.getFecha_finalizacion()) ? "" : deals.getFecha_finalizacion();
        String Producto = deals.getProducto() == null || "UNKNOWN".equals(deals.getProducto()) ? "" : deals.getProducto();
        try {
            String sql = "INSERT INTO deals_recovery_hughescol (id_bitrix, category_id, etapa_id, fase_id, aliado_id, contacto_id, fecha_inicio, fecha_cierre, fecha_cupon, fecha_creacion, fecha_modificacion, fecha_de_nacimiento, hora_de_consulta, fecha_inicio_gestion, fecha_churn, fecha_activacion, encargado_validacion, creado_por, asignado, modificado_por, valor_churn, tipo_cliente_id, genero_id, cedula, ubicacion_exacta, estrato, descuento_churn, codigo_san, departamento, regional_col, motivo_novedad_sym, lead_id, fuente_sym_id, linea_de_negocio_lead_id, source_id, fuente_id, ciudad_municipio, zona_instalacion, comercial_sym, dealer_sym, aliado_crm_id, sucursal, contratoDigital, TXT_TELEFONO, TXT_TELEFONO_2, TXT_CORREO, TXT_ALI_SUCURSAL, NUM_ID_ALIADO, BIT_FIRMA_HUGHES, Fec_factura_sym, Nombre_Cliente, Apellido_Cliente, fecha_finalizacion, Producto) VALUES (" + id_bitrix + ",'" + category_id + "','" + etapa_id + "','" + fase_id + "','" + aliado_id + "','" + contacto_id + "','" + fecha_inicio + "','" + fecha_cierre + "','" + fecha_cupon + "','" + fecha_creacion + "','" + fecha_modificacion + "','" + fecha_de_nacimiento + "','" + hora_de_consulta + "','" + fecha_inicio_gestion + "','" + fecha_churn + "','" + fecha_activacion + "','" + encargado_validacion + "','" + creado_por + "','" + asignado + "','" + modificado_por + "','" + valor_churn + "','" + tipo_cliente_id + "','" + genero_id + "','" + cedula + "','" + ubicacion_exacta + "','" + estrato + "','" + descuento_churn + "','" + codigo_san + "','" + departamento + "','" + regional_col + "','" + motivo_novedad_sym + "','" + lead_id + "','" + fuente_sym_id + "','" + linea_de_negocio_lead_id + "','" + source_id + "','" + fuente_id + "','" + ciudad_municipio + "','" + zona_instalacion + "','" + comercial_sym + "','" + dealer_sym + "','" + aliado_crm_id + "','" + sucursal + "','" + contratoDigital + "','" + TXT_TELEFONO + "','" + TXT_TELEFONO_2 + "','" + TXT_CORREO + "','" + TXT_ALI_SUCURSAL + "','" + NUM_ID_ALIADO + "','" + BIT_FIRMA_HUGHES + "','" + Fec_factura_sym + "','" + Nombre_Cliente + "','" + Apellido_Cliente + "','" + fecha_finalizacion + "','" + Producto + "')";

            int res = dsh.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        } catch (Exception e) {
            String sql = "UPDATE deals_recovery_hughescol SET " + "category_id='" + category_id + "'," + "etapa_id='" + etapa_id + "'," + "fase_id='" + fase_id + "'," + "aliado_id='" + aliado_id + "'," + "contacto_id='" + contacto_id + "'," + "fecha_inicio='" + fecha_inicio + "'," + "fecha_cierre='" + fecha_cierre + "'," + "fecha_cupon='" + fecha_cupon + "'," + "fecha_creacion='" + fecha_creacion + "'," + "fecha_modificacion='" + fecha_modificacion + "'," + "fecha_de_nacimiento='" + fecha_de_nacimiento + "'," + "hora_de_consulta='" + hora_de_consulta + "'," + "fecha_inicio_gestion='" + fecha_inicio_gestion + "'," + "fecha_churn='" + fecha_churn + "'," + "fecha_activacion='" + fecha_activacion + "'," + "encargado_validacion='" + encargado_validacion + "'," + "creado_por='" + creado_por + "'," + "asignado='" + asignado + "'," + "modificado_por='" + modificado_por + "'," + "valor_churn='" + valor_churn + "'," + "tipo_cliente_id='" + tipo_cliente_id + "'," + "genero_id='" + genero_id + "'," + "cedula='" + cedula + "'," + "ubicacion_exacta='" + ubicacion_exacta + "'," + "estrato='" + estrato + "'," + "descuento_churn='" + descuento_churn + "'," + "codigo_san='" + codigo_san + "'," + "departamento='" + departamento + "'," + "regional_col='" + regional_col + "'," + "motivo_novedad_sym='" + motivo_novedad_sym + "'," + "lead_id='" + lead_id + "'," + "fuente_sym_id='" + fuente_sym_id + "'," + "linea_de_negocio_lead_id='" + linea_de_negocio_lead_id + "'," + "source_id='" + source_id + "'," + "fuente_id='" + fuente_id + "'," + "ciudad_municipio='" + ciudad_municipio + "'," + "zona_instalacion='" + zona_instalacion + "'," + "comercial_sym='" + comercial_sym + "'," + "dealer_sym='" + dealer_sym + "'," + "aliado_crm_id='" + aliado_crm_id + "'," + "sucursal='" + sucursal + "'," + "contratoDigital='" + contratoDigital + "'," + "TXT_TELEFONO='" + TXT_TELEFONO + "'," + "TXT_TELEFONO_2='" + TXT_TELEFONO_2 + "'," + "TXT_CORREO='" + TXT_CORREO + "'," + "TXT_ALI_SUCURSAL='" + TXT_ALI_SUCURSAL + "'," + "NUM_ID_ALIADO='" + NUM_ID_ALIADO + "'," + "BIT_FIRMA_HUGHES='" + BIT_FIRMA_HUGHES + "'," + "Fec_factura_sym='" + Fec_factura_sym + "'," + "Nombre_Cliente='" + Nombre_Cliente + "'," + "Apellido_Cliente='" + Apellido_Cliente + "'," + "fecha_finalizacion='" + fecha_finalizacion + "'," + "Producto='" + Producto + "'" + " WHERE id_bitrix=" + String.valueOf(id_bitrix);

            int res = dsh.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        }

    }

    @PostMapping("/guardarinfohughesecu")
    public ResponseEntity<respuestaHttp> guardar(@RequestBody deals_hughes_ecu deals) {
        respuestaHttp h = new respuestaHttp(200, "completada");

        deals_recovery_hughes_ecu dsh = new deals_recovery_hughes_ecu(jdbcTemplate);
        deals_hughes_ecu dsoriginal3 = new deals_hughes_ecu(jdbcTemplate);
        int id_bitrix = deals.getId_bitrix();
        String category_id = deals.getCategory_id() == null || "UNKNOWN".equals(deals.getCategory_id()) ? "" : deals.getCategory_id();
        String etapa_id = deals.getEtapa_id() == null || "UNKNOWN".equals(deals.getEtapa_id()) ? "" : deals.getEtapa_id();
        String fase_id = deals.getFase_id() == null || "UNKNOWN".equals(deals.getFase_id()) ? "" : deals.getFase_id();
        String aliado_id = deals.getAliado_id() == null || "UNKNOWN".equals(deals.getAliado_id()) ? "" : deals.getAliado_id();
        String contacto_id = deals.getContacto_id() == null || "UNKNOWN".equals(deals.getContacto_id()) ? "" : deals.getContacto_id();
        String fecha_inicio = deals.getFecha_inicio() == null || "UNKNOWN".equals(deals.getFecha_inicio()) ? "" : deals.getFecha_inicio();
        String fecha_cierre = deals.getFecha_cierre() == null || "UNKNOWN".equals(deals.getFecha_cierre()) ? "" : deals.getFecha_cierre();
        String asignado = deals.getAsignado() == null || "UNKNOWN".equals(deals.getAsignado()) ? "" : deals.getAsignado();
        String creado_por = deals.getCreado_por() == null || "UNKNOWN".equals(deals.getCreado_por()) ? "" : deals.getCreado_por();
        String modificado_por = deals.getModificado_por() == null || "UNKNOWN".equals(deals.getModificado_por()) ? "" : deals.getModificado_por();
        String fecha_creacion = deals.getFecha_creacion() == null || "UNKNOWN".equals(deals.getFecha_creacion()) ? "" : deals.getFecha_creacion();
        String fecha_modificacion = deals.getFecha_modificacion() == null || "UNKNOWN".equals(deals.getFecha_modificacion()) ? "" : deals.getFecha_modificacion();
        String valor_churn = deals.getValor_churn() == null || "UNKNOWN".equals(deals.getValor_churn()) ? "" : deals.getValor_churn();
        String tipo_cliente_id = deals.getTipo_cliente_id() == null || "UNKNOWN".equals(deals.getTipo_cliente_id()) ? "" : deals.getTipo_cliente_id();
        String genero_id = deals.getGenero_id() == null || "UNKNOWN".equals(deals.getGenero_id()) ? "" : deals.getGenero_id();
        String cedula = deals.getCedula() == null || "UNKNOWN".equals(deals.getCedula()) ? "" : deals.getCedula();
        String fecha_de_nacimiento = deals.getFecha_de_nacimiento() == null || "UNKNOWN".equals(deals.getFecha_de_nacimiento()) ? "" : deals.getFecha_de_nacimiento();
        String ubicacion_exacta = deals.getUbicacion_exacta() == null || "UNKNOWN".equals(deals.getUbicacion_exacta()) ? "" : deals.getUbicacion_exacta();
        String estrato = deals.getEstrato() == null || "UNKNOWN".equals(deals.getEstrato()) ? "" : deals.getEstrato();
        String hora_de_consulta = deals.getHora_de_consulta() == null || "UNKNOWN".equals(deals.getHora_de_consulta()) ? "" : deals.getHora_de_consulta();
        String fecha_inicio_gestion = deals.getFecha_inicio_gestion() == null || "UNKNOWN".equals(deals.getFecha_inicio_gestion()) ? "" : deals.getFecha_inicio_gestion();
        String descuento_churn = deals.getDescuento_churn() == null || "UNKNOWN".equals(deals.getDescuento_churn()) ? "" : deals.getDescuento_churn();
        String fecha_churn = deals.getFecha_churn() == null || "UNKNOWN".equals(deals.getFecha_churn()) ? "" : deals.getFecha_churn();
        String fecha_activacion = deals.getFecha_activacion() == null || "UNKNOWN".equals(deals.getFecha_activacion()) ? "" : deals.getFecha_activacion();
        String fecha_cupon = deals.getFecha_cupon() == null || "UNKNOWN".equals(deals.getFecha_cupon()) ? "" : deals.getFecha_cupon();
        String codigo_san = deals.getCodigo_san() == null || "UNKNOWN".equals(deals.getCodigo_san()) ? "" : deals.getCodigo_san();
        String provincia = deals.getProvincia() == null || "UNKNOWN".equals(deals.getProvincia()) ? "" : deals.getProvincia();
        String ciudad_canton = deals.getCiudad_canton() == null || "UNKNOWN".equals(deals.getCiudad_canton()) ? "" : deals.getCiudad_canton();
        String regional_ecu = deals.getRegional_ecu() == null || "UNKNOWN".equals(deals.getRegional_ecu()) ? "" : deals.getRegional_ecu();
        String motivo_novedad_sym = deals.getMotivo_novedad_sym() == null || "UNKNOWN".equals(deals.getMotivo_novedad_sym()) ? "" : deals.getMotivo_novedad_sym();
        String Nombre_1 = deals.getNombre_1() == null || "UNKNOWN".equals(deals.getNombre_1()) ? "" : deals.getNombre_1();
        String Apellido = deals.getApellido() == null || "UNKNOWN".equals(deals.getApellido()) ? "" : deals.getApellido();
        String Telefono = deals.getTelefono() == null || "UNKNOWN".equals(deals.getTelefono()) ? "" : deals.getTelefono();
        String Telefono_2 = deals.getTelefono_2() == null || "UNKNOWN".equals(deals.getTelefono_2()) ? "" : deals.getTelefono_2();
        String E_mail = deals.getE_mail() == null || "UNKNOWN".equals(deals.getE_mail()) ? "" : deals.getE_mail();
        try {
            String sql = "INSERT INTO deals_recovery_hugHes_EC (id_bitrix, category_id, etapa_id, fase_id, aliado_id, contacto_id, fecha_inicio, fecha_cierre, asignado, creado_por, modificado_por, fecha_creacion, fecha_modificacion, valor_churn, tipo_cliente_id, genero_id, cedula, fecha_de_nacimiento, ubicacion_exacta, estrato, hora_de_consulta, fecha_inicio_gestion, descuento_churn, fecha_churn, fecha_activacion, fecha_cupon, codigo_san, provincia, ciudad_canton, regional_ecu, motivo_novedad_sym, Nombre_1, Apellido, Telefono, Telefono_2, E_mail) VALUES (" + id_bitrix + ",'" + category_id + "','" + etapa_id + "','" + fase_id + "','" + aliado_id + "','" + contacto_id + "','" + fecha_inicio + "','" + fecha_cierre + "','" + asignado + "','" + creado_por + "','" + modificado_por + "','" + fecha_creacion + "','" + fecha_modificacion + "','" + valor_churn + "','" + tipo_cliente_id + "','" + genero_id + "','" + cedula + "','" + fecha_de_nacimiento + "','" + ubicacion_exacta + "','" + estrato + "','" + hora_de_consulta + "','" + fecha_inicio_gestion + "','" + descuento_churn + "','" + fecha_churn + "','" + fecha_activacion + "','" + fecha_cupon + "','" + codigo_san + "','" + provincia + "','" + ciudad_canton + "','" + regional_ecu + "','" + motivo_novedad_sym + "','" + Nombre_1 + "','" + Apellido + "','" + Telefono + "','" + Telefono_2 + "','" + E_mail + "')";

            int res = dsh.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        } catch (Exception e) {
            String sql = "UPDATE deals_recovery_hugHes_EC SET " + "category_id='" + category_id + "'," + "etapa_id='" + etapa_id + "'," + "fase_id='" + fase_id + "'," + "aliado_id='" + aliado_id + "'," + "contacto_id='" + contacto_id + "'," + "fecha_inicio='" + fecha_inicio + "'," + "fecha_cierre='" + fecha_cierre + "'," + "fecha_cupon='" + fecha_cupon + "'," + "fecha_creacion='" + fecha_creacion + "'," + "fecha_modificacion='" + fecha_modificacion + "'," + "fecha_de_nacimiento='" + fecha_de_nacimiento + "'," + "hora_de_consulta='" + hora_de_consulta + "'," + "fecha_inicio_gestion='" + fecha_inicio_gestion + "'," + "fecha_churn='" + fecha_churn + "'," + "fecha_activacion='" + fecha_activacion + "'," + "creado_por='" + creado_por + "'," + "asignado='" + asignado + "'," + "modificado_por='" + modificado_por + "'," + "valor_churn='" + valor_churn + "'," + "tipo_cliente_id='" + tipo_cliente_id + "'," + "genero_id='" + genero_id + "'," + "cedula='" + cedula + "'," + "ubicacion_exacta='" + ubicacion_exacta + "'," + "estrato='" + estrato + "'," + "descuento_churn='" + descuento_churn + "'," + "codigo_san='" + codigo_san + "'," + "provincia='" + provincia + "'," + "ciudad_canton='" + ciudad_canton + "'," + "regional_ecu='" + regional_ecu + "'," + "motivo_novedad_sym='" + motivo_novedad_sym + "'," + "Nombre_1='" + Nombre_1 + "'," + "Apellido='" + Apellido + "'," + "Telefono='" + Telefono + "'," + "Telefono_2='" + Telefono_2 + "'," + "E_mail='" + E_mail + "'," + " WHERE id_bitrix=" + String.valueOf(id_bitrix);

            int res = dsh.getJdbcTemplate().update(sql);

            return ResponseEntity.ok(h);
        }

    }
}
