package com.offline.jambguide.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.navigation.NavController;

import com.offline.jambguide.R;
import com.offline.jambguide.activity.QuizActivity;
import com.offline.jambguide.helper.CheckNetworkConnection;


public class PanelHandler {

    private final Context context;
    private final NavController navController;

    public PanelHandler(Context context, NavController navController) {
        this.context = context;
        this.navController = navController;

    }

    public void alertdialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        dialog.setTitle("Internet Connection Error!");
        dialog.setMessage("This Property requires an active Internet connetcion, check your  Internet connection");

        dialog.setPositiveButton("OK", (dialogInterface, i) -> {
        });
        dialog.show();
    }

    public void onlineTest() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        dialog.setTitle("Oops,Sorry ");
        dialog.setMessage("We are working on our website,as it will contains many jamb questions to practise for preparation. \nKindly Watch out for our next upgrade.");

        dialog.setPositiveButton("OK", (dialogInterface, i) -> {
        });
        dialog.show();
    }

    public void jambNews(View view) {
        if (!CheckNetworkConnection.isConnectionAvailable(context)) {
            alertdialog();
        } else {
            Bundle args = new Bundle();
            args.putString("type", "News");
            navController.navigate(R.id.jambNews, args);
        }
    }

    public void cbtPractise(View view) {

        context.startActivity(new Intent(context, QuizActivity.class));
    }


    public void onlineCbt(View view) {
        onlineTest();
    }

    public void jambSyllabus(View view) {

        navController.navigate(R.id.jambSyllabus);


    }

    public void cutOffMark(View view) {
        if (!CheckNetworkConnection.isConnectionAvailable(context)) {
            alertdialog();
        } else {
            navController.navigate(R.id.cutOffMark);
        }
    }

    public void admissionStatus(View view) {
        if (!CheckNetworkConnection.isConnectionAvailable(context)) {
            alertdialog();
        } else {
            navController.navigate(R.id.admissionStatus);
        }
    }

    public void aboutUs(View view) {
        navController.navigate((R.id.aboutUs));
    }

    public void pastQuestion(View view) {
        navController.navigate((R.id.questionCategory));
    }
}