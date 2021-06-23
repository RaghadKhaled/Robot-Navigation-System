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
 * Class ChessboardPosition encapsulates the coordinates
 * of a given position in a chessboard.
 */
public class ChessboardPosition {

    int[] coords;
    ChessboardPosition from;

    ChessboardPosition(int[] coords) {
        this(coords, null);
    }

    ChessboardPosition(int row, int col) {
        this(row, col, null);
    }

    ChessboardPosition(int[] coords, ChessboardPosition from) {
        setCoords(coords);
        this.from = from;
    }

    ChessboardPosition(int row, int col, ChessboardPosition from) {
        setCoords(new int[]{row, col});
        this.from = from;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public ChessboardPosition getFrom() {
        return from;
    }

    public String toString() {
        return ("(" + coords[0] + ", " + coords[1] + ")");
    }

    public boolean equals(Object o) {

        /* 
    	 * Compares the coordinates, NOT the previous position (from)
         */
        ChessboardPosition opos = (ChessboardPosition) o;
        int[] ocoords = opos.getCoords();

        boolean res = this.coords.length == ocoords.length;
        for (int i = 0; res && i < this.coords.length; i++) {
            if (this.coords[i] != ocoords[i]) {
                res = false;
            }
        }

        return res;

    }
    
    public static void main(String[] args){
        /*
 ####
    #
#   #
#  G#
#####
        */
        
        //we create obj postion for each cell
       /* ChessboardPosition pos1 = new ChessboardPosition(0,0);
        ChessboardPosition pos2 = new ChessboardPosition(1,0,pos1);
        
        System.out.println("Coordinate of pos2: "+pos2.toString());
        System.out.println("prev coordivate of pos2: "+pos2.getFrom());
        
        System.out.println("is coordinate of ops2 == coordinate of pos1? "+pos2.equals(pos1));*/
       Chessboard chessboard = new Chessboard(ChessboardSamples.sChessboard1);
       int[] coords = {0,0};
       ChessboardPosition pos1 = new ChessboardPosition(coords);
       ChessboardPosition pos1Dwon = chessboard.getNeighbour(pos1, Move.DOWN);
       ChessboardPosition pos1Right = chessboard.getNeighbour(pos1, Move.RIGHT);
       
       System.out.println(pos1);
       System.out.println(pos1Dwon);
       System.out.println(pos1Right);
       
       System.out.println("Down getFrom? "+pos1Dwon.getFrom());
       System.out.println("Right getFrom? "+pos1Right.getFrom());
       
       
        
    }

}
