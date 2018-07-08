import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import e.sura23.tables2.R;

/**
 * Created by SURA23 on 7/8/2018.
 */

public class prefFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource (R.xml.pref_fragment);
    }
}
