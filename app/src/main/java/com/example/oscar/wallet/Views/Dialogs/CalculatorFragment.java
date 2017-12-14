package com.example.oscar.wallet.Views.Dialogs;

import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscar.wallet.Interfaces.CalculatorPresenter;
import com.example.oscar.wallet.Interfaces.CalculatorView;
import com.example.oscar.wallet.Presenters.CalculatorPresenterImpl;
import com.example.oscar.wallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalculatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends DialogFragment implements CalculatorView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

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
    CalculatorPresenter presenter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        presenter= new CalculatorPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
        Toast.makeText(this.getContext(), "Expresion no valida", Toast.LENGTH_LONG).show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
