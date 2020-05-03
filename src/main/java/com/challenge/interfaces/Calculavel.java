package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

    public BigDecimal somar(Object obj) throws IllegalAccessException;

    public BigDecimal subtrair(Object obj) throws IllegalAccessException;

    public BigDecimal tatalizar(Object obj) throws IllegalAccessException;
}
