package com.example.oscar.wallet.Interfaces.InterfacesViews;

import java.math.BigDecimal;

/**
 * Created by oscar on 8/12/2017.
 */

public interface CalculatorView {

    public void setOutPut(String value);
    public void setErrorOutPut();
    public void operationSuccesfull(BigDecimal result);

}
