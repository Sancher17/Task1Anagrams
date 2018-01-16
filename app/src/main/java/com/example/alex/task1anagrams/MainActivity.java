package com.example.alex.task1anagrams;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.TextView;

import com.example.alex.task1anagrams.util.Logger;
import com.example.alex.task1anagrams.util.ReverseWords;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

import static butterknife.OnTextChanged.Callback.AFTER_TEXT_CHANGED;

public class MainActivity extends AppCompatActivity {

    private static Logger LOGGER = new Logger(MainActivity.class);

    @BindView(R.id.textView_output)
    TextView textView;

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

    @OnTextChanged(value = R.id.editText_input, callback = AFTER_TEXT_CHANGED)
    public void afterTextChanged(Editable s) {
        rv = new ReverseWords(this);
        outputReverseText = rv.reverse(s.toString());
        textView.setText(outputReverseText);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("setText", outputReverseText);
        LOGGER.log("onSaveInstanceState");
    }
}


