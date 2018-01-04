package com.example.oscar.wallet.Utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by oscar on 15/12/2017.
 */

public class Format {

    public static String  formatNumberToCurrency(BigDecimal ammount){
        Locale locale = new Locale("es","AR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(ammount);
    }
    public static String formatTwoDigit(int value){
        return (value<=9)? ("0"+value):String.valueOf(value);
    }
}
