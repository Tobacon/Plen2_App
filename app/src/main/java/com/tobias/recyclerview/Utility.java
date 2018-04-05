package com.tobias.recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias
 */

public class Utility {

    public static List<Move> getListPerson(){
        ArrayList<Move> moves = new ArrayList<>();
        moves.add(new Move("up", R.drawable.arrow_up));
        moves.add(new Move("down", R.drawable.arrow_down));
        moves.add(new Move("left", R.drawable.arrow_left));
        moves.add(new Move("right", R.drawable.arrow_right));
        moves.add(new Move("down_left", R.drawable.arrow_down_left));
        moves.add(new Move("down_right", R.drawable.arrow_down_right));
        moves.add(new Move("up_right", R.drawable.arrow_up_right));
        moves.add(new Move("up_left", R.drawable.arrow_up_left));
        return moves;
    }
}
