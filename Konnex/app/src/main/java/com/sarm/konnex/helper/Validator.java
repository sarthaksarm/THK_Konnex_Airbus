package com.sarm.konnex.helper;

import com.google.android.material.textfield.TextInputEditText;

public class Validator {
    public static boolean validateString(TextInputEditText editText, String msg){
        if(editText.getText().toString().length() == 0) {
            editText.setError(msg);
            return false;
        }

        return true;
    }
}
