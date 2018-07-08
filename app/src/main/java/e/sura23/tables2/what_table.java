package e.sura23.tables2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class what_table extends AppCompatActivity {

    private EditText multiplier;
    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.what_table);
        multiplier = (EditText) findViewById (R.id.et_multiplier);
        mbutton = (Button) findViewById (R.id.button);
    }

    public void onButtonClick(View v) {
        String getMultiplier = multiplier.getText ().toString ();
        int numberMultiplier = Integer.parseInt (getMultiplier);
        Intent intent = new Intent (what_table.this, MainActivity.class);
        intent.putExtra (Intent.EXTRA_TEXT, numberMultiplier);
        startActivity (intent);
    }
}
