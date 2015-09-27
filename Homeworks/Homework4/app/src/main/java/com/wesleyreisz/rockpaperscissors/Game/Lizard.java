package com.wesleyreisz.rockpaperscissors.Game;

import com.wesleyreisz.rockpaperscissors.GameUtils;
import com.wesleyreisz.rockpaperscissors.R;

/**
 * Created by Joe Woodcox on 9/24/2015.
 */
public class Lizard implements GameType {
    @Override
    public String eval(Integer opponentChoice) {
        if (opponentChoice == R.id.btnPaper || opponentChoice == R.id.btnSpock) {
            return GameUtils.BEATS;
        } else if (opponentChoice == R.id.btnRock || opponentChoice == R.id.btnScissors ) {
            return GameUtils.LOSES_TO;
        } else {
            return GameUtils.TIES;
        }
    }
}
