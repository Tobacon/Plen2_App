package com.tobias.recyclerview.static_movelist;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tobias.recyclerview.ItemTouchHelperAdapter;
import com.tobias.recyclerview.ItemTouchHelperClick;
import com.tobias.recyclerview.Move;
import com.tobias.recyclerview.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tobias on 02.04.2018.
 */

public class ItemAdapterBasic extends RecyclerView.Adapter<ItemAdapterBasic.MoveViewHolder> implements ItemTouchHelperAdapter{
    private List<Move> mMoves;
    private Context mContext;
    public ItemTouchHelperClick listener;

    public class MoveViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView v;
        private Context context;
        public ItemTouchHelperClick mlistener;


        public MoveViewHolder(Context context, View itemView, ItemTouchHelperClick listener) {
            super(itemView);
            v = (ImageView) itemView.findViewById(R.id.move_image);
            this.context = context;
            itemView.setOnClickListener((View.OnClickListener) this);
            this.mlistener = listener;
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                Move move = mMoves.get(position);
                mlistener.onClick(move);
            }
        }
    }

    public ItemAdapterBasic(Context context, List<Move> moves, ItemTouchHelperClick mlistener) {
        mMoves = moves;
        mContext = context;
        listener = mlistener;
    }

    @Override
    public MoveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.list_row_layout, parent, false);
        MoveViewHolder moveViewHolder = new MoveViewHolder(context,contactView, listener);
        return moveViewHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(MoveViewHolder moveViewHolder, int position) {
        Move move = mMoves.get(position);
        ImageView imageView = moveViewHolder.v;
        imageView.setImageResource(move.getImagecode());
    }

    @Override
    public int getItemCount() {
        return mMoves.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //Log.v("", "Log position" + fromPosition + " " + toPosition);
        if (fromPosition < mMoves.size() && toPosition < mMoves.size()) {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(mMoves, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(mMoves, i, i - 1);
                }
            }
            notifyItemMoved(fromPosition, toPosition);
        }
        return true;
    }

    @Override
    public void onItemDismiss(int position) {

    }

}
