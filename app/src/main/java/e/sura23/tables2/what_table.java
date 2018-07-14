package e.sura23.tables2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        if ((numberMultiplier >= 1)&&(numberMultiplier <= 50)) {

            Intent intent = new Intent (what_table.this, MainActivity.class);
            intent.putExtra (Intent.EXTRA_TEXT, numberMultiplier);
            startActivity (intent);
        } else {
            String displayToast = "Enter numbers only between 1 and 50";
            Toast.makeText (this, displayToast, Toast.LENGTH_LONG).show ();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId ();
        if (itemID == R.id.mi_open_preferences) {
            Intent intent = new Intent (this, Preference_fragment.class);
            startActivity (intent);
        }
        return super.onOptionsItemSelected (item);
    }


}
