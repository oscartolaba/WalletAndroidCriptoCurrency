package com.example.oscar.wallet.Interfaces;

/**
 * Created by oscar on 8/12/2017.
 */

public interface CalculatorInteractor {

    public void addNumberToExpression(String number);

    public void addOperatorToExpresion(String operator);

    public void addPointToExpression(String point);

    public void calculateExpression();

    public void deleteExpressionValue();

    }
