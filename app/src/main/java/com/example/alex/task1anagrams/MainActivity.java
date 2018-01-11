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
import io.michaelrocks.paranoid.Obfuscate;

@Obfuscate
public class MainActivity extends AppCompatActivity {

    private static Logger LOGGER = new Logger(MainActivity.class);

    @BindView(R.id.textView_output)
    TextView textView;

    @BindView(R.id.editText_input)
    EditText editText;

    @BindView(R.id.button_start)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_start)
    void onClick(View view) {
        String input = editText.getText().toString();
        ReverseWords rv = new ReverseWords();
        textView.setText(rv.reverse(input));
    }
}
