package e.sura23.tables2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById (R.id.rv_tables);

        LinearLayoutManager layoutManager = new LinearLayoutManager (this);
        mRecyclerView.setLayoutManager (layoutManager);

        mTableAdapter = new TableAdapter ();
        mRecyclerView.setAdapter (mTableAdapter);
    }
}
