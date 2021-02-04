package com.febatis.customsnackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbar();
            }
        });

    }

    private void showSnackbar() {

        String text = "Hello Snackbar!!!";

        LayoutInflater mInflater = LayoutInflater.from(this);

        View rootView = findViewById(android.R.id.content);
        Snackbar snackBar = Snackbar.make(rootView, text, Snackbar.LENGTH_LONG);

        // Get the Snackbar's layout view
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackBar.getView();

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        layout.setLayoutParams(lp);

        layout.setPadding(0, 0, 0, 0);

        snackBar.getView().setBackground(ContextCompat.getDrawable(this, R.drawable.bg_snackbar));

        // Hide the text
        TextView textView = (TextView) layout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);

        // Inflate our custom view
        View snackView = mInflater.inflate(R.layout.my_snackbar, null);

        TextView newTextView = snackView.findViewById(R.id.text);
        newTextView.setText(text);

        layout.addView(snackView);

        snackBar.show();
    }
}