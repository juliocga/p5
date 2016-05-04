package com.juliocgutierrez.p5;

/**
 * Created by Julioc on 01/05/2016.
 */
public class lista_entrada {
    private int idimagen;
    private String nombres;


    public lista_entrada(int idimagen, String nombres) {
        this.idimagen = idimagen;
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public int getIdimagen() {
        return idimagen;
    }

}