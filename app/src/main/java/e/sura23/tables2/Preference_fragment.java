package e.sura23.tables2;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

public class Preference_fragment extends AppCompatActivity

{
    @Override
    protected void onCreate(Bundle SavedInstanceState) {

        super.onCreate (SavedInstanceState);
        setContentView (R.layout.preference_fragment);
    }
}
