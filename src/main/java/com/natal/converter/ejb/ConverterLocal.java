package com.natal.converter.ejb;

import java.math.BigDecimal;
import javax.ejb.Local;

@Local
public interface ConverterLocal {
    
    BigDecimal dollarToYen(BigDecimal value);
    BigDecimal yenToEuro(BigDecimal value);
    
}
