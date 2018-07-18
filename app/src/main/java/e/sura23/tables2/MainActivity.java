package e.sura23.tables2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements TableAdapter.ListItemClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    boolean textTableVisiblity;
    String Multiplier = "Multiplier";
    int multiplier;
    String colorFromPreference = "holo_green";
    int multiplicationFactor = 15;
    String TAG = MainActivity.class.getSimpleName ();
    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        ActionBar actionBar = this.getSupportActionBar ();
        actionBar.setDisplayHomeAsUpEnabled (true);



        mRecyclerView = (RecyclerView) findViewById (R.id.rv_tables);
        Intent intent = getIntent ();

        if (intent.hasExtra (Intent.EXTRA_TEXT)) {
            multiplier = intent.getIntExtra (intent.EXTRA_TEXT, 1);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager (this);
        mRecyclerView.setLayoutManager (layoutManager);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences (this);
        textTableVisiblity = sharedPreferences.getBoolean (getString (R.string.pref_key), false);
        multiplicationFactor = Integer.parseInt (sharedPreferences.getString ((getString (R.string.edit_text_key)), "15"));
        colorFromPreference = sharedPreferences.getString (getString (R.string.list_pref_key), getString (R.string.pref_color_value_default));
        sharedPreferences.registerOnSharedPreferenceChangeListener (this);
        mTableAdapter = new TableAdapter (this, textTableVisiblity, multiplier, colorFromPreference, multiplicationFactor);
        mRecyclerView.setAdapter (mTableAdapter);


    }


    @Override
    public void onListItemClick(int adapterPosition) {

        Intent intent = new Intent (MainActivity.this, DetailNumber.class);
        intent.putExtra (Intent.EXTRA_TEXT, adapterPosition);
        intent.putExtra (Multiplier, multiplier);
        startActivity (intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int getItemID = item.getItemId ();
        if (getItemID == R.id.mi_open_preferences) {
            Intent intent = new Intent (MainActivity.this, Preference_fragment.class);
            startActivity (intent);
            return true;
        }

        if (getItemID == R.id.home) {
            NavUtils.navigateUpFromSameTask (this);
        }
        return super.onOptionsItemSelected (item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {


        if (key.equals (getString (R.string.pref_key))) {
            textTableVisiblity = sharedPreferences.getBoolean (key, true);
            mTableAdapter = new TableAdapter (this, textTableVisiblity, multiplier, colorFromPreference, multiplicationFactor);
            mRecyclerView.setAdapter (mTableAdapter);
        } else if (key.equals ("color_key")) {
            Log.d (TAG, "Executed");
            colorFromPreference = sharedPreferences.getString (key, getString (R.string.pref_color_value_default));
            mTableAdapter = new TableAdapter (this, textTableVisiblity, multiplier, colorFromPreference, multiplicationFactor);
            mRecyclerView.setAdapter (mTableAdapter);
        } else if (key.equals ("edit_text_key")) {

            multiplicationFactor = Integer.parseInt (sharedPreferences.getString ((getString (R.string.edit_text_key)), "15"));
            mTableAdapter = new TableAdapter (this, textTableVisiblity, multiplier, colorFromPreference, multiplicationFactor);
            mRecyclerView.setAdapter (mTableAdapter);
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy ();
        PreferenceManager.getDefaultSharedPreferences (this).unregisterOnSharedPreferenceChangeListener (this);
    }

}
