package com.offline.jambguide.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.offline.jambguide.R;
import com.offline.jambguide.activity.QuizActivity;

import androidx.navigation.NavController;


public class PanelHandler {

    private final Context context;
    private final NavController navController;

    public PanelHandler(Context context, NavController navController) {
        this.context = context;
        this.navController = navController;

    }

    public void jambNews(View view) {
        // context.startActivity(new Intent(context, SettingsActivity.class));
        navController.navigate(R.id.jambNews);
    }
    public void cbtPractise(View view){

       context.startActivity(new Intent(context, QuizActivity.class));
    }

    public void jambBrochure(View view) {
        navController.navigate(R.id.jambBrochure);
    }

    public void jambSyllabus(View view) {
        navController.navigate(R.id.jambSyllabus);

    }

    public void cutOffMark(View view) {
        // context.startActivity(new Intent(context, MainActivity.class));
        navController.navigate(R.id.cutOffMark);
    }

    public void admissionStatus(View view) {

        navController.navigate(R.id.admissionStatus);
    }
    public void aboutUs(View view){
        navController.navigate((R.id.aboutUs));
    }
    public void pastQuestion(View view){
        navController.navigate((R.id.practiseQuestion));
    }
}