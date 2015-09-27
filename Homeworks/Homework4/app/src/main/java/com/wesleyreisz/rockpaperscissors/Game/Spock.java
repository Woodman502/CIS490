package com.wesleyreisz.rockpaperscissors.Game;

import com.wesleyreisz.rockpaperscissors.GameUtils;
import com.wesleyreisz.rockpaperscissors.R;

/**
 * Created by Joe Woodcox on 9/24/2015.
 */
public class Spock implements GameType {
    @Override
    public String eval(Integer opponentChoice) {
        if ( opponentChoice == R.id.btnScissors || opponentChoice == R.id.btnRock) {
            return GameUtils.BEATS;
        } else if (opponentChoice == R.id.btnLizard || opponentChoice == R.id.btnPaper) {
            return GameUtils.LOSES_TO;
        } else {
            return GameUtils.TIES;
        }
    }
}
