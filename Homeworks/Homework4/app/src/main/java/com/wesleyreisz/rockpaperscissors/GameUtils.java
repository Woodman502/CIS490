package com.wesleyreisz.rockpaperscissors;

import android.graphics.Color;

import com.wesleyreisz.rockpaperscissors.Game.GameType;
import com.wesleyreisz.rockpaperscissors.Game.Lizard;
import com.wesleyreisz.rockpaperscissors.Game.Paper;
import com.wesleyreisz.rockpaperscissors.Game.Rock;
import com.wesleyreisz.rockpaperscissors.Game.Scissors;
import com.wesleyreisz.rockpaperscissors.Game.Spock;

import java.util.Random;

/**
 * Created by wesleyreisz on 9/13/15.
 */
public class GameUtils {
    public static final String BEATS = "beats";
    public static final String LOSES_TO = "loses to";
    public static final String TIES = "ties";

    public static Integer getComputerChoice() {
        Integer selectedValue;
        Random r = new Random(System.currentTimeMillis());

        selectedValue = r.nextInt(5);//
        if (selectedValue == 0) {
            return R.id.btnRock;
        } else if (selectedValue == 1) {
            return R.id.btnPaper;
        } else if (selectedValue == 2) {
            return R.id.btnScissors;
        } else if (selectedValue == 3) {
            return R.id.btnLizard;
        } else {
            return R.id.btnSpock;
        }
    }


    public static Integer convertButtonToImage(Integer buttonChoice) {
        if(buttonChoice==R.id.btnRock){
            return R.drawable.rock;
        }else if (buttonChoice==R.id.btnPaper) {
            return R.drawable.paper;
        }else if(buttonChoice==R.id.btnScissors){
            return R.drawable.scissors;
        }else if (buttonChoice==R.id.btnLizard){
                return R.drawable.lizard;
        }else{
            return R.drawable.spock;
        }
    }

    public static String evaluateWinner(Integer playerSelectedChoice, Integer computerSelectedChoice) {
        GameType gameType;

        if (playerSelectedChoice==R.id.btnRock){
            gameType = new Rock();
        }else if  (playerSelectedChoice==R.id.btnPaper){
            gameType = new Paper();
        }else if (playerSelectedChoice==R.id.btnScissors){
            gameType = new Scissors();
        } else if (playerSelectedChoice==R.id.btnLizard){
            gameType = new Lizard();
        } else {
            gameType = new Spock();
        }
        return gameType.eval(computerSelectedChoice);
    }

    public static int defineTextColor(String msg) {
        if(GameUtils.LOSES_TO.equalsIgnoreCase(msg)){
            return Color.RED;
        }else if(GameUtils.BEATS.equalsIgnoreCase(msg)){
            return Color.GREEN;
        }else{
            return Color.BLACK;
        }
    }
}

