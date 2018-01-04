package com.example.oscar.wallet.Interfaces.InterfacesPresenters;

/**
 * Created by oscar on 8/12/2017.
 */

public interface CalculatorPresenter {
    public void addNumberToExpression(String number);

    public void addOperatorToExpression(String operator);

    public void addPointToEspression(String point);

    public void calculateExpression();

    public void deleteValueExpression();
}
