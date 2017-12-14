package com.example.oscar.wallet.Interactors;

import com.example.oscar.wallet.Interfaces.CalculatorInteractor;
import com.example.oscar.wallet.Interfaces.OnListenerFinishCalculator;


/**
 * Created by oscar on 8/12/2017.
 */

public class CalculatorInteractorImpl  implements CalculatorInteractor{

    private String operators[] = new String[]{"+","-","*","/"};
    private OnListenerFinishCalculator listener;
    private String expression = new String();

    public CalculatorInteractorImpl(OnListenerFinishCalculator listener) {
        this.listener= listener;
    }

    @Override
    public void addNumberToExpression(String number) {
        expression+=number;
        listener.setExpressionValid(expression);
    }

    @Override
    public void addOperatorToExpresion(String operator) {
        if(!isOperatorLast() && !isPointLast() && !expression.isEmpty()){
            expression+=operator;
        }
        listener.setExpressionValid(expression);
    }

    @Override
    public void addPointToExpression(String point)
    {
        if(!isPointLast() && !isOperatorLast() && !expression.isEmpty())
        {
            expression+=point;
        }
        else
        {
            listener.setExpressionError();
        }
        listener.setExpressionValid(expression);
    }

    private boolean isPointLast(){

        String lastValue= expression.substring(expression.length()-1);
            if (lastValue.equals("."))
              return true;

        return false;
    }

    private boolean isOperatorLast(){
    if(!expression.isEmpty())
    {
       String lastValue= expression.substring(expression.length()-1);
       for (String value: operators)
       {
           if(lastValue.equals(value))
               return true;
       }
    }
       return false;
   }

    @Override
    public void calculateExpression() {
         if(!expression.isEmpty() && !isOperatorLast()){
             expression = operar(expression);
             listener.setExpressionValid(expression);
         }else {
              listener.setExpressionError();
         }
    }

    @Override
    public void deleteExpressionValue() {
        if(!expression.isEmpty())
            expression= expression.substring(0,expression.length()-1);

        listener.setExpressionValid(expression);
    }

    private String operar(String expresion){
        int p;
        String subcadena1="",subcadena2="";

        if(expresion.indexOf('+')>=0){
            for(int i=0; i<expresion.length() && expresion.indexOf('+',i)>=0;i++){
                p=expresion.indexOf('+',i);
                subcadena1=operar(expresion.substring(0,p));
                subcadena2=operar(expresion.substring(p+1));
            }
            expresion= calcular(subcadena1,subcadena2,"+");
        }

        if(expresion.indexOf('-',1)>=0){
            for(int i=1; i<expresion.length() && expresion.indexOf('-',i)>=0;i++){
                p=expresion.indexOf('-',i);
                subcadena1=operar(expresion.substring(0,p));
                subcadena2=operar(expresion.substring(p+1));
            }
            expresion= calcular(subcadena1,subcadena2,"-");
        }

        if(expresion.indexOf('*')>=0){
            for(int i=0; i<expresion.length() && expresion.indexOf('*',i)>=0;i++){
                p=expresion.indexOf('*',i);
                subcadena1=operar(expresion.substring(0,p));
                subcadena2=operar(expresion.substring(p+1));
            }
            expresion= calcular(subcadena1,subcadena2,"*");
        }

        if(expresion.indexOf('/')>=0){
            for(int i=0; i<expresion.length() && expresion.indexOf('/',i)>=0;i++){
                p=expresion.indexOf('/',i);
                subcadena1=operar(expresion.substring(0,p));
                subcadena2=operar(expresion.substring(p+1));
            }
            expresion= calcular(subcadena1,subcadena2,"/");
        }

        return expresion;
    }

    private String calcular(String a , String b,String operador){
        String resultado="";
        switch (operador)
        {
            case "/": resultado=String.valueOf(Float.parseFloat(a)/Float.parseFloat(b));break;
            case "*": resultado=String.valueOf(Float.parseFloat(a)*Float.parseFloat(b));break;
            case "-": resultado=String.valueOf(Float.parseFloat(a)-Float.parseFloat(b));break;
            case "+": resultado=String.valueOf(Float.parseFloat(a)+Float.parseFloat(b));break;
        }
        return resultado;
    }

}
