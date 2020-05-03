package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.*;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    public BigDecimal somar(Object obj) throws IllegalAccessException {
        int totalDeCampos = 0;
        BigDecimal bd = new BigDecimal("0");
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.getDeclaredAnnotations().equals(Somar.class) && f.getType().equals(BigDecimal.class)) {
                bd = bd.add((BigDecimal) f.get(obj));
                continue;
            }
            totalDeCampos++;
        }
        for (Field f : obj.getClass().getSuperclass().getDeclaredFields()) {
            if (f.getDeclaredAnnotations().equals(Somar.class) && f.getType().equals(BigDecimal.class)) {
                bd = bd.add((BigDecimal) f.get(obj));
                continue;
            }
            totalDeCampos++;
        }
        if (obj.getClass().getFields().length + obj.getClass().getSuperclass().getDeclaredFields().length == totalDeCampos) return BigDecimal.ZERO;
        return bd;
    }

    public BigDecimal subtrair(Object obj) {
        return null;
    }

    public BigDecimal tatalizar(Object obj) {
        return null;
    }
}
