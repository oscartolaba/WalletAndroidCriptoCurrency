package com.example.oscar.wallet.Presenters;

import com.example.oscar.wallet.Interactors.CalculatorInteractorImpl;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.CalculatorInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.CalculatorPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.CalculatorView;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishCalculator;

/**
 * Created by oscar on 8/12/2017.
 */

public class CalculatorPresenterImpl  implements  CalculatorPresenter, OnListenerFinishCalculator{
    private CalculatorView view;
    private CalculatorInteractor interactor;

    public CalculatorPresenterImpl(CalculatorView view) {
        this.view = view;
        interactor= new CalculatorInteractorImpl(this);
    }


    @Override
    public void addNumberToExpression(String number) {
        if(view!= null){
            interactor.addNumberToExpression(number);
        }
    }

    @Override
    public void addOperatorToExpression(String operator) {
        if(interactor!= null){
            interactor.addOperatorToExpresion(operator);
        }
    }

    @Override
    public void addPointToEspression(String point) {
        if(interactor!= null){
            interactor.addPointToExpression(point);
        }
    }

    @Override
    public void calculateExpression() {
         if(interactor!=null){
             interactor.calculateExpression();
         }
    }

    @Override
    public void deleteValueExpression() {
          interactor.deleteExpressionValue();
    }

    @Override
    public void setExpressionValid(String expressionValid) {
      if(view!= null){
          view.setOutPut(expressionValid);
      }
    }

    @Override
    public void setExpressionError() {
        if(view!= null){
            view.setErrorOutPut();
        }
    }

    @Override
    public void operationSuccesfull() {

    }
}