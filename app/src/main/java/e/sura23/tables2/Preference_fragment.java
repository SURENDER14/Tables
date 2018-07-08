package e.sura23.tables2;

import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.SpinnerAdapter;

public class Preference_fragment extends AppCompatActivity

{
    @Override
    protected void onCreate(Bundle SavedInstanceState) {

        super.onCreate (SavedInstanceState);
        setContentView (R.layout.preference_fragment);

        ActionBar actionbar = this.getSupportActionBar ();
        actionbar.setDisplayHomeAsUpEnabled (true);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask (this);
        }
        return super.onOptionsItemSelected (item);
    }
}
