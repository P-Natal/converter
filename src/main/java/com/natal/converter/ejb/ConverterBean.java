package com.natal.converter.ejb;

import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class ConverterBean implements ConverterLocal{

    private BigDecimal yenRate = new BigDecimal("106.55");
    private BigDecimal euroRate = new BigDecimal("0.0079");

    public BigDecimal dollarToYen(BigDecimal dollars) {
        BigDecimal result = dollars.multiply(yenRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal yenToEuro(BigDecimal yen) {
        BigDecimal result = yen.multiply(euroRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }
    
}
