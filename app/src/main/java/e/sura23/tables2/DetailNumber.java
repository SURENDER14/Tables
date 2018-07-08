package e.sura23.tables2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailNumber extends AppCompatActivity {

    private TextView mDetail_number_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.detail_number);
        mDetail_number_table = (TextView) findViewById (R.id.tv_detail_number_table);
        Intent intent = getIntent ();
        if (intent.hasExtra (Intent.EXTRA_TEXT)) {

            String setText = Table.numberTwoTable (intent.getIntExtra (Intent.EXTRA_TEXT, 0));
            setText = setText + "\n" + Table.textTwoTable ();
            mDetail_number_table.setText (setText);
        }
    }
}
