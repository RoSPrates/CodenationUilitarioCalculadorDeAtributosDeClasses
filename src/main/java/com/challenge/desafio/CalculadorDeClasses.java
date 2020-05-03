package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {


    @Override
    public BigDecimal somar(Object obj) {
        return retornaTotalDaClasse(obj,Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return retornaTotalDaClasse(obj,Subtrair.class);
    }

    @Override
    public BigDecimal tatalizar(Object obj) {
        BigDecimal somar = somar(obj);
        BigDecimal subtrair = subtrair(obj);
        return somar.subtract(subtrair);
    }

    private BigDecimal calcularPontos(Object obj, Class annotation, boolean sup) {
        Class cl;
        BigDecimal bd = BigDecimal.ZERO;
        if (sup) cl = obj.getClass().getSuperclass();
        else cl = obj.getClass();
        for (Field f : cl.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(annotation) && f.getType().equals(BigDecimal.class)) {
                try {
                    bd = bd.add((BigDecimal) f.get(obj));
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return bd;
    }

    private BigDecimal retornaTotalDaClasse(Object obj,Class annotation){
        BigDecimal bd = BigDecimal.ZERO;
        bd = bd.add(calcularPontos(obj, annotation, false));
        bd = bd.add(calcularPontos(obj,annotation,true));
        return bd;
    }

}