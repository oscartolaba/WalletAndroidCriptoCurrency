package com.example.oscar.wallet.Views.Dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscar.wallet.Interfaces.InterfacesPresenters.CalculatorPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.CalculatorView;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerCalculatorResult;
import com.example.oscar.wallet.Presenters.CalculatorPresenterImpl;
import com.example.oscar.wallet.R;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CalculatorFragment extends DialogFragment implements CalculatorView {


    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;
    @BindView(R.id.btn_three)
    Button btnThree;
    @BindView(R.id.btn_four)
    Button btnFour;
    @BindView(R.id.btn_five)
    Button btnFive;
    @BindView(R.id.btn_six)
    Button btnSix;
    @BindView(R.id.btn_seven)
    Button btnSeven;
    @BindView(R.id.btn_eight)
    Button btnHeight;
    @BindView(R.id.btn_nine)
    Button btnNine;
    @BindView(R.id.btn_zero)
    Button btnZero;
    @BindView(R.id.btn_addition)
    Button btnAddition;

    @BindView(R.id.txt_output)
    TextView txtOutput;

    @BindView(R.id.img_delete)
    ImageButton imageButtonDelete;

    @BindView(R.id.btn_ok)
    Button btnOk;

    @BindView(R.id.btn_cancel)
    Button btnCancel;


    CalculatorPresenter presenter;

    OnListenerCalculatorResult result;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator,container,false);
        presenter= new CalculatorPresenterImpl(this);
        result = (OnListenerCalculatorResult)getActivity();
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.btn_one,R.id.btn_two,R.id.btn_three,R.id.btn_four,R.id.btn_five,R.id.btn_six,R.id.btn_seven,R.id.btn_eight,R.id.btn_nine,R.id.btn_zero})
    public void clickAddNumberToExpression(Button button){
        presenter.addNumberToExpression(button.getText().toString());
    }

    @OnClick({R.id.btn_addition,R.id.btn_subtraction,R.id.btn_multiplication,R.id.btn_division})
    public void clickAddOperatorToExpression(Button button){
        presenter.addOperatorToExpression(button.getText().toString());
    }

     @OnClick(R.id.btn_point)
    public void clickAddPoint(Button button){
       presenter.addPointToEspression(button.getText().toString());
    }

    @OnClick(R.id.btn_calculate)
    public void clickCalculateExpression(){
          presenter.calculateExpression();
    }

    @OnClick({R.id.img_delete})
    public void deleteValueExpression(){
           presenter.deleteValueExpression();
    }

    @Override
    public void setOutPut(String value) {
        txtOutput.setText(value);
    }

    @Override
    public void setErrorOutPut() {
        Toast.makeText(getActivity().getApplicationContext(), "Expresion no valida", Toast.LENGTH_LONG).show();
    }

    @Override
    public void operationSuccesfull(BigDecimal result) {
        this.result.setAmmount(result);
    }

    @OnClick(R.id.btn_cancel)
    public void cancelOperationDialog(){
       dismiss();
    }

    @OnClick(R.id.btn_ok)
    public void okOperationDialog(){
        if(!txtOutput.getText().toString().isEmpty()){
            result.setAmmount(new BigDecimal(txtOutput.getText().toString()));
            dismiss();
        }
    }


}
