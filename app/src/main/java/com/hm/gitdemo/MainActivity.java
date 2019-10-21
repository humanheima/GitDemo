package com.hm.gitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: dmw");
        Log.d(TAG, "onCreate: dev1");
        Log.d(TAG, "onCreate: dev2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void backToLastCommit() {
        Log.d(TAG, "backToLastCommit: ");
    }

    private void testReset() {

    }

    private void testResetSingleFile() {

    }

    private void testResetSingleFile1() {

    }

    private void testResetNoConflict() {
        Log.d(TAG, "testResetNoConflict:i am dev");

    }

    private void mainV1(){

    }
}
