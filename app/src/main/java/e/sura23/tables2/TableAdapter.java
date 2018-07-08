package e.sura23.tables2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by SURA23 on 7/6/2018.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.NumberListItem> {

    int itemCount = 15;
    ListItemClickListener mListItemClickListener;
    boolean TextTableVisiblity;
    String TAG = TableAdapter.class.getSimpleName ();

    TableAdapter(ListItemClickListener itemClickListener, boolean textTableVisiblity) {
        mListItemClickListener = itemClickListener;
        TextTableVisiblity = textTableVisiblity;
    }

    @NonNull
    @Override
    public NumberListItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext ();
        LayoutInflater Inflater = LayoutInflater.from (context);
        int layoutIDForTableListItem = R.layout.table_list_item;
        boolean shouldAttachToParentImmediately = false;
        View view = Inflater.inflate (layoutIDForTableListItem, parent, shouldAttachToParentImmediately);
        NumberListItem numberListItem = new NumberListItem (view);
        if (TextTableVisiblity == true) {
            numberListItem.mTextTwoTable.setVisibility (View.VISIBLE);
        } else {
            numberListItem.mTextTwoTable.setVisibility (View.INVISIBLE);
        }
        Log.d (TAG, String.valueOf (TextTableVisiblity));
        return numberListItem;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberListItem holder, int position) {
        holder.bind (position);
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }


    public interface ListItemClickListener {
        void onListItemClick(int adapterPosition);

    }

    public class NumberListItem extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNumberTwotable;
        private TextView mTextTwoTable;

        public NumberListItem(View itemView) {
            super (itemView);
            mNumberTwotable = itemView.findViewById (R.id.tv_number_two_table);
            mTextTwoTable = itemView.findViewById (R.id.tv_text_two_table);
            itemView.setOnClickListener (this);
        }

        public void bind(int position) {
            mNumberTwotable.setText (Table.numberTwoTable (position));
            mTextTwoTable.setText (Table.textTwoTable ());
        }

        @Override
        public void onClick(View view) {

            int adapterPosition = getAdapterPosition ();
            mListItemClickListener.onListItemClick (adapterPosition);

        }
    }
}
