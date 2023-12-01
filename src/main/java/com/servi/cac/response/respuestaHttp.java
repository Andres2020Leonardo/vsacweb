/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servi.cac.response;

import lombok.Data;

/**
 *
 * @author Analitica
 */

public class respuestaHttp {
    private int codigo;
    private String repuesta;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRepuesta() {
        return repuesta;
    }

    public void setRepuesta(String repuesta) {
        this.repuesta = repuesta;
    }

    public respuestaHttp(int codigo, String repuesta) {
        this.codigo = codigo;
        this.repuesta = repuesta;
    }
    
}
