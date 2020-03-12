package com.trananson.lifecycle_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public TextView v1, v2, v3, v4, v5, v6, v7;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public State state = new State();
    Button resetButton;
    int onCreateA = 0;
    int onStartA = 0;
    int onResumeA = 0;
    int onPauseA = 0;
    int onStopA = 0;
    int onRestartA = 0;
    int onDestroyA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        resetButton = findViewById(R.id.resetButton);
        v1 = findViewById(R.id.textView1);
        v2 = findViewById(R.id.textView2);
        v3 = findViewById(R.id.textView3);
        v4 = findViewById(R.id.textView4);
        v5 = findViewById(R.id.textView5);
        v6 = findViewById(R.id.textView6);
        v7 = findViewById(R.id.textView7);
        state.sCr(state.gCr()+1);
        onCreateA = sharedPreferences.getInt("onCreate", 0);
        onCreateA++;
        editor.putInt("onCreate", onCreateA);
        editor.apply();

        onStartA = sharedPreferences.getInt("onStart", 0);
        onResumeA = sharedPreferences.getInt("onResume", 0);
        onPauseA = sharedPreferences.getInt("onPause", 0);
        onStopA = sharedPreferences.getInt("onStop", 0);
        onRestartA = sharedPreferences.getInt("onRestart", 0);
        onDestroyA = sharedPreferences.getInt("onDestroy", 0);
        String newText1 = "onCreateR: " + state.gCr() + ", onCreate: " + onCreateA;
        v1.setText(newText1);
        String newText2 = "onStartR: " + state.gSt() + ", onStart: " + onStartA;
        v2.setText(newText2);
        String newText3 = "onResumeR: " + state.gRe() + ", onResume: " + onResumeA;
        v3.setText(newText3);
        String newText4 = "onPauseR: " + state.gPa() + ", onPause: " + onPauseA;
        v4.setText(newText4);
        String newText5 = "onStopR: " + state.gSp() + ", onStop: " + onStopA;
        v5.setText(newText5);
        String newText6 = "onRestartR: " + state.gRt() + ", onRestart: " + onRestartA;
        v6.setText(newText6);
        String newText7 = "onDestroyR: " + state.gDe() + ", onDestroy: " + onDestroyA;
        v7.setText(newText7);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("onCreate", 0);
                editor.putInt("onStart", 0);
                editor.putInt("onResume", 0);
                editor.putInt("onPause", 0);
                editor.putInt("onStop", 0);
                editor.putInt("onRestart", 0);
                editor.putInt("onDestroy", 0);
                editor.apply();
                onCreateA = sharedPreferences.getInt("onCreate", 0);
                onStartA = sharedPreferences.getInt("onStart", 0);
                onResumeA = sharedPreferences.getInt("onResume", 0);
                onPauseA = sharedPreferences.getInt("onPause", 0);
                onStopA = sharedPreferences.getInt("onStop", 0);
                onRestartA = sharedPreferences.getInt("onRestart", 0);
                onDestroyA = sharedPreferences.getInt("onDestroy", 0);
                state = new State();
                String newText1 = "onCreateR: " + state.gCr() + ", onCreate: " + onCreateA;
                v1.setText(newText1);
                String newText2 = "onStartR: " + state.gSt() + ", onStart: " + onStartA;
                v2.setText(newText2);
                String newText3 = "onResumeR: " + state.gRe() + ", onResume: " + onResumeA;
                v3.setText(newText3);
                String newText4 = "onPauseR: " + state.gPa() + ", onPause: " + onPauseA;
                v4.setText(newText4);
                String newText5 = "onStopR: " + state.gSp() + ", onStop: " + onStopA;
                v5.setText(newText5);
                String newText6 = "onRestartR: " + state.gRt() + ", onRestart: " + onRestartA;
                v6.setText(newText6);
                String newText7 = "onDestroyR: " + state.gDe() + ", onDestroy: " + onDestroyA;
                v7.setText(newText7);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        state.sSt(state.gSt()+1);
        onStartA = sharedPreferences.getInt("onStart", 0);
        onStartA++;
        editor.putInt("onStart", onStartA);
        editor.apply();
        String newText2 = "onStartR: " + state.gSt() + ", onStart: " + onStartA;
        v2.setText(newText2);
    }

    protected void onResume() {
        super.onResume();
        state.sRe(state.gRe()+1);
        onResumeA = sharedPreferences.getInt("onResume", 0);
        onResumeA++;
        editor.putInt("onResume", onResumeA);
        editor.apply();
        String newText3 = "onResumeR: " + state.gRe() + ", onResume: " + onResumeA;
        v3.setText(newText3);
    }

    protected void onPause() {
        super.onPause();
        state.sPa(state.gPa()+1);
        onPauseA = sharedPreferences.getInt("onPause", 0);
        onPauseA++;
        editor.putInt("onPause", onPauseA);
        editor.apply();
        String newText4 = "onPauseR: " + state.gPa() + ", onPause: " + onPauseA;
        v4.setText(newText4);
    }

    protected void onStop() {
        super.onStop();
        state.sSp(state.gSp()+1);
        onStopA = sharedPreferences.getInt("onStop", 0);
        onStopA++;
        editor.putInt("onStop", onStopA);
        editor.apply();
        String newText5 = "onStopR: " + state.gSp() + ", onStop: " + onStopA;
        v5.setText(newText5);
    }

    protected void onRestart() {
        super.onRestart();
        state.sRt(state.gRt()+1);
        onRestartA = sharedPreferences.getInt("onRestart", 0);
        onRestartA++;
        editor.putInt("onRestart", onRestartA);
        editor.apply();
        String newText6 = "onRestartR: " + state.gRt() + ", onRestart: " + onRestartA;
        v6.setText(newText6);
    }

    protected void onDestroy() {
        super.onDestroy();
        state.sDe(state.gDe()+1);
        onDestroyA = sharedPreferences.getInt("onDestroy", 0);
        onDestroyA++;
        editor.putInt("onDestroy", onDestroyA);
        editor.apply();
        String newText7 = "onDestroyR: " + state.gDe() + ", onDestroy: " + onDestroyA;
        v7.setText(newText7);
    }

}

class State {
    private int cr, st, re, pa, sp, rt, de;

    public int gCr(){
        return cr;
    }
    public int gSt(){
        return st;
    }
    public int gRe(){
        return re;
    }
    public int gPa(){
        return pa;
    }
    public int gSp(){
        return sp;
    }
    public int gRt(){
        return rt;
    }
    public int gDe(){
        return de;
    }

    public void sCr(int x){
        cr = x;
    }
    public void sSt(int x){
        st = x;
    }
    public void sRe(int x){
        re = x;
    }
    public void sPa(int x){
        pa = x;
    }
    public void sSp(int x){
        sp = x;
    }
    public void sRt(int x){
        rt = x;
    }
    public void sDe(int x){
        de = x;
    }
}