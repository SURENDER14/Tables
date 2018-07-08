package e.sura23.tables2;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailNumber extends AppCompatActivity {

    int multiplier;
    private TextView mDetail_number_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.detail_number);
        mDetail_number_table = (TextView) findViewById (R.id.tv_detail_number_table);

        ActionBar actionBar = this.getSupportActionBar ();
        actionBar.setDisplayHomeAsUpEnabled (true);

        Intent intent = getIntent ();
        if (intent.hasExtra (Intent.EXTRA_TEXT)) {
            multiplier = intent.getIntExtra ("Multiplier", 1);

            String setText = Table.numberTwoTable (intent.getIntExtra (Intent.EXTRA_TEXT, 0), multiplier);
            setText = setText + "\n" + Table.textTwoTable ();
            mDetail_number_table.setText (setText);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask (this);
        }
        return super.onOptionsItemSelected (item);
    }
}
