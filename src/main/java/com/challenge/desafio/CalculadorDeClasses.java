package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {


    public BigDecimal somar(Object obj) throws IllegalAccessException {
        CalcularPontos cp = new CalcularPontos();
        cp.setBd(new BigDecimal("0"));
        cp.calcularPontos(obj,Somar.class,false);
        cp.calcularPontos(obj,Somar.class,true);
        if (cp.getBd() == null) return BigDecimal.ZERO;
        return cp.getBd();
    }

    public BigDecimal subtrair(Object obj) throws IllegalAccessException {
        CalcularPontos cp = new CalcularPontos();
        cp.setBd(new BigDecimal("0"));
        cp.calcularPontos(obj, Subtrair.class,false);
        cp.calcularPontos(obj,Subtrair.class,true);
        if (cp.getBd() == null) return BigDecimal.ZERO;
        return cp.getBd();
    }

    public BigDecimal tatalizar(Object obj) throws IllegalAccessException {
        CalculadorDeClasses c = new CalculadorDeClasses();
        BigDecimal somar = c.somar(obj);
        BigDecimal subtrair = c.subtrair(obj);
        if(somar == subtrair) return somar;
        return somar.subtract(subtrair);
    }

}
