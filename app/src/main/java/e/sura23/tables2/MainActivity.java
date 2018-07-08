package e.sura23.tables2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements TableAdapter.ListItemClickListener {

    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById (R.id.rv_tables);

        LinearLayoutManager layoutManager = new LinearLayoutManager (this);
        mRecyclerView.setLayoutManager (layoutManager);

        mTableAdapter = new TableAdapter (this);
        mRecyclerView.setAdapter (mTableAdapter);


    }

    @Override
    public void onListItemClick(int adapterPosition) {

        Intent intent = new Intent (MainActivity.this, DetailNumber.class);
        intent.putExtra (Intent.EXTRA_TEXT, adapterPosition);
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
        return super.onOptionsItemSelected (item);
    }

}
