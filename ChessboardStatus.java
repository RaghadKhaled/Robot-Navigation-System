/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ragha
 */
/**
 * Possible states for each position of a chessboard
 */
public enum ChessboardStatus {

    //create obj here , so this is reson I cant crate new in main, here is ready
    OPEN(' '), OBSTACLE('#'), GOAL('G'), VISITED('.');

    private char text;

    ChessboardStatus(char s) {
        this.text = s;
    }

    public char text() {
        return this.text;
    }
    public static void main(String[] args){
        for(ChessboardStatus obj : ChessboardStatus.values())
            System.out.println("Status name: "+obj+", text: "+obj.text());
    }

}
