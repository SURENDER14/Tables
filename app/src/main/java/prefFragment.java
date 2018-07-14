import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

import e.sura23.tables2.R;

/**
 * Created by SURA23 on 7/8/2018.
 */

public class prefFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource (R.xml.pref_fragment);

        SharedPreferences sharedPreferences = getPreferenceScreen ().getSharedPreferences ();
        PreferenceScreen preferenceScreen = getPreferenceScreen ();

        int preferenceCount = preferenceScreen.getPreferenceCount ();

        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceScreen.getPreference (i);

            if (preference instanceof ListPreference) {
                String listPreferenceValueFromSharedPreferences = sharedPreferences.getString (preference.getKey (), "");
                setListPreferenceSummary (preference, listPreferenceValueFromSharedPreferences);
            }
        }
    }

    public void setListPreferenceSummary(Preference preferences, String listPreferenceValue) {
        ListPreference listPreference = (ListPreference) preferences;
        int indexofListPreferenceValue = listPreference.findIndexOfValue (listPreferenceValue);
        listPreference.setSummary (listPreference.getEntries ()[indexofListPreferenceValue]);

    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference (key);

        if (preference instanceof ListPreference) {
            String listPreferenceValueFromSharedPreferences = sharedPreferences.getString (preference.getKey (), "");
            setListPreferenceSummary (preference, listPreferenceValueFromSharedPreferences);
        }

    }

    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate (SavedInstanceState);
        getPreferenceScreen ().getSharedPreferences ().registerOnSharedPreferenceChangeListener (this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy ();
        getPreferenceScreen ().getSharedPreferences ().unregisterOnSharedPreferenceChangeListener (this);
    }
}
