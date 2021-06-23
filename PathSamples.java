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
 * Examples of paths for testing
 */
public final class PathSamples {

    // Use with ChessboardSample 1
    public static final Move[] movsPath1a = {
        Move.DOWN,
        Move.RIGHT,
        Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN,
        Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT
    };

    // Use with ChessboardSample 1
    public static final Move[] movsPath1b = {
        Move.DOWN, Move.RIGHT,
        Move.DOWN, Move.RIGHT,
        Move.DOWN, Move.RIGHT,
        Move.DOWN, Move.RIGHT,
        Move.DOWN, Move.RIGHT,
        Move.DOWN, Move.RIGHT,
        Move.DOWN, Move.RIGHT,
        Move.DOWN, Move.RIGHT
    };
    // Use with ChessboardSample 1
    public static final Move[] movsPath1c = {
     Move.DOWN,
     Move.RIGHT,Move.RIGHT,Move.RIGHT,Move.RIGHT,Move.RIGHT,Move.RIGHT,Move.RIGHT,Move.RIGHT,
     Move.DOWN,Move.DOWN,Move.DOWN,Move.DOWN,Move.DOWN,Move.DOWN,Move.DOWN
    };
    
    // Use with ChessboardSample 1
    public static final Move[] movsPath2a = {
        Move.DOWN,Move.RIGHT,Move.RIGHT,Move.RIGHT,Move.DOWN,Move.DOWN
    };
    
    
    public static void main(String[] args){
        
        System.out.println("Path A for Chessboard1: ");
        for(Move obj : PathSamples.movsPath1a)
            System.out.print(obj+" ");
        System.out.println();
        
        System.out.println("Path B for Chessboard1: ");
        for(Move obj : PathSamples.movsPath1b)
            System.out.print(obj+" ");
        System.out.println();
        
        System.out.println("Path C for Chessboard1: ");
        for(Move obj : PathSamples.movsPath1c)
            System.out.print(obj+" ");
        System.out.println();
        
        System.out.println("Path A for Chessboard1: ");
        for(Move obj : PathSamples.movsPath2a)
            System.out.print(obj+" ");
        System.out.println();
    }

}

