package com.tobias.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tobias.recyclerview.Curr_movelist.EditItemTouchHelperCallback;
import com.tobias.recyclerview.Curr_movelist.ItemAdapter;
import com.tobias.recyclerview.static_movelist.EditItemTouchHelperCallbackBasic;
import com.tobias.recyclerview.static_movelist.ItemAdapterBasic;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tobias
 */

public class MainActivity extends AppCompatActivity implements OnStartDragListener{

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    ItemTouchHelper mItemTouchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); fab.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) { Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();}});*/
        ArrayList<Move> list = (ArrayList<Move>) Utility.getListPerson();

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ItemAdapter mAdapter = new ItemAdapter(this, list, this);
        ItemTouchHelper.Callback callback =
                new EditItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.setAdapter(mAdapter);





        //Set up basic list here
        RecyclerView mBasicRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_moves);
        ArrayList<Move> basiclist = (ArrayList<Move>) Utility.getListPerson();
        mBasicRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mBasicLineatLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mBasicRecyclerView.setLayoutManager(mBasicLineatLayoutManager);
        ItemAdapterBasic mBasicAdapter =new ItemAdapterBasic(this, basiclist, new ItemTouchHelperClick() {
            @Override
            public void onClick(Move move) {
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
            }
        });
        mBasicRecyclerView.setAdapter(mBasicAdapter);
        //Finished setting up the basic list
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
