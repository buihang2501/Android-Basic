package hangbt.hust.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ButtonFragment.OnIntergrationListener {

    private TextView textViewNumber;
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        textViewNumber = findViewById(R.id.textViewNumber);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameContent, ButtonFragment.newInstance(null, null))
                .commit();
    }

    @Override
    public void onAdd(int n) {
        this.number += n;
        textViewNumber.setText(String.valueOf(number));
    }
}