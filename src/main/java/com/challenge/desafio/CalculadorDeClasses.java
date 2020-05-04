package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {


    @Override
    public BigDecimal somar(Object obj) {
        return retornaTotalDaClasse(obj, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return retornaTotalDaClasse(obj, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return somar(obj).subtract(subtrair(obj));
    }

    private BigDecimal calcularPontos(Object obj, Class annotation, boolean sup) {
        Class cl;
        BigDecimal result = BigDecimal.ZERO;
        if (sup) cl = obj.getClass().getSuperclass();
        else cl = obj.getClass();
        for (Field f : cl.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(annotation) && f.getType().equals(BigDecimal.class)) {
                try {
                    result = result.add((BigDecimal) f.get(obj));
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

    private BigDecimal retornaTotalDaClasse(Object obj, Class annotation) {
        BigDecimal result = BigDecimal.ZERO;
        result = result.add(calcularPontos(obj, annotation, false));
        result = result.add(calcularPontos(obj, annotation, true));
        return result;
    }

}