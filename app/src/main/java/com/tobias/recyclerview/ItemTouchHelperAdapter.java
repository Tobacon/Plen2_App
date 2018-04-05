package com.tobias.recyclerview;

/**
 * Created by Tobias
 */
public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}

