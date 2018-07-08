package e.sura23.tables2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
}
