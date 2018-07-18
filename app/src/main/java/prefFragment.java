import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.util.Log;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

import e.sura23.tables2.MainActivity;
import e.sura23.tables2.R;

/**
 * Created by SURA23 on 7/8/2018.
 */

public class prefFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceChangeListener {


    String TAG = prefFragment.class.getSimpleName ();
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
            } else if (preference instanceof EditTextPreference) {
                String EditTextValueFromSharedPreference = sharedPreferences.getString (preference.getKey (), "");
                setEditTextSummary (preference, EditTextValueFromSharedPreference);
            }
        }
        Preference preference = findPreference (getString (R.string.edit_text_key));
        preference.setOnPreferenceChangeListener (this);
    }

    public void setListPreferenceSummary(Preference preferences, String listPreferenceValue) {
        ListPreference listPreference = (ListPreference) preferences;
        int indexofListPreferenceValue = listPreference.findIndexOfValue (listPreferenceValue);
        listPreference.setSummary (listPreference.getEntries ()[indexofListPreferenceValue]);

    }

    public void setEditTextSummary(Preference preference, String EditTextValueFromSharedPreference) {
        EditTextPreference editTextpreference = (EditTextPreference) preference;
        editTextpreference.setSummary (EditTextValueFromSharedPreference);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference (key);

        if (preference instanceof ListPreference) {
            String listPreferenceValueFromSharedPreferences = sharedPreferences.getString (preference.getKey (), "");
            setListPreferenceSummary (preference, listPreferenceValueFromSharedPreferences);
        } else if (preference instanceof EditTextPreference) {
            String editTextValueFromSharedPreferences = sharedPreferences.getString (preference.getKey (), "");
            setEditTextSummary (preference, editTextValueFromSharedPreferences);
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


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        Toast showerror = Toast.makeText (getContext (), "Enter values between 1 and 15", Toast.LENGTH_SHORT);
        Log.d (TAG, "editTextConstraint");
        if (preference.getKey ().equals (getString (R.string.edit_text_key))) {
            String editTextValue = (String) newValue;
            try {
                Float value = Float.parseFloat (editTextValue);

                if ((value <= 0)||(value > 15)) {
                    showerror.show ();
                    return false;
                }

            } catch (NumberFormatException nfe) {
                showerror.show ();
                return false;
            }

        }
        return true;
    }
}
