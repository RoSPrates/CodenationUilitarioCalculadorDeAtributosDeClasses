package com.challenge.desafio;


import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalcularPontos {

    private BigDecimal bd;

    public void calcularPontos(Object obj,Class annotation,boolean sup) throws IllegalAccessException {
        Class cl;
        if(sup) cl = obj.getClass().getSuperclass();
        else cl = obj.getClass();
        for (Field f : cl.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.getDeclaredAnnotations().equals(annotation) && f.getType().equals(BigDecimal.class)) {
                this.bd = bd.add((BigDecimal) f.get(obj));
            }
        }
    }

    public BigDecimal getBd() {
        return bd;
    }

    public void setBd(BigDecimal bd) {
        this.bd = bd;
    }
}
