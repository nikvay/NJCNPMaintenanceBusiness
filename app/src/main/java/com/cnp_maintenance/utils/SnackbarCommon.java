package com.cnp_maintenance.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;

public class SnackbarCommon {

    public static void displayValidation(View view, String message)
    {
        Snackbar snackbar =  Snackbar
                .make(view,message,Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
