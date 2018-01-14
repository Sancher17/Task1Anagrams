package com.example.alex.task1anagrams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alex.task1anagrams.util.Logger;
import com.example.alex.task1anagrams.util.ReverseWords;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static Logger LOGGER = new Logger(MainActivity.class);

    @BindView(R.id.textView_output)
    TextView textView;

    @BindView(R.id.editText_input)
    EditText editText;

    @BindView(R.id.button_start)
    Button button;

    private String outputReverseText;
    private ReverseWords rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            outputReverseText = savedInstanceState.getString("setText");
            textView.setText(outputReverseText);
            LOGGER.log("onRestoreInstanceState");
        }
    }

    @OnClick(R.id.button_start)
    void onClick(View view) {
        LOGGER.log("Button clicked / id.button_start");
        String input = editText.getText().toString();
        rv = new ReverseWords(this);
        outputReverseText = rv.reverse(input);
        textView.setText(outputReverseText);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("setText", outputReverseText);
        LOGGER.log("onSaveInstanceState");
    }
}


