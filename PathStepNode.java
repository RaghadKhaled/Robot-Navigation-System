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
 * Class PathStep represents each step in a Path through a Chessboard,
 * with links to the previous and following steps.
 */

//each step I want to now 1. what its row 2.that its colom 3.what its prev step(Prev strp also it is step with row and colom) 4. what its next step(next strp also it is step with row and colom)
//so the shape of content this class = node with 2 reference next and prev"Double node" and the elements are row and colom
public class PathStepNode {

    private int row;
    private int col;

    private PathStepNode next, prev;

    public PathStepNode(int row, int col) {
        this(row, col, null, null);
    }

    public PathStepNode(int row, int col, PathStepNode next, PathStepNode prev) {
        this.row = row;
        this.col = col;
        this.next = next;
        this.prev = prev;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public PathStepNode getNext() {
        return next;
    }

    public PathStepNode getPrev() {
        return prev;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setNext(PathStepNode next) {
        this.next = next;
    }

    public void setPrev(PathStepNode prev) {
        this.prev = prev;
    }

    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }
    
    public static void main(String[] args){
        
        //we create all step of path A for Chessboard1
        /*
                                        " #########\n" +
					"         #\n" +
					"#        #\n" +
					"#        #\n" +
					"#        #\n" +
					"#        #\n" +
					"#        #\n" +
					"#        #\n" +
					"#       G#\n" +
					"##########\n";
        */
         /*
        // Use with ChessboardSample 1
        public static final Move[] movsPath1a = {
        Move.DOWN,
        Move.RIGHT,
        Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN, Move.DOWN,
        Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT, Move.RIGHT
    };*/
         PathStepNode s1 = new PathStepNode(0,0);
         PathStepNode s2 = new PathStepNode(1,0);
         PathStepNode s3 = new PathStepNode(1,1);
         PathStepNode s4 = new PathStepNode(2,1);
         PathStepNode s5 = new PathStepNode(3,1);
         PathStepNode s6 = new PathStepNode(4,1);
         PathStepNode s7 = new PathStepNode(5,1);
         PathStepNode s8 = new PathStepNode(6,1);
         PathStepNode s9 = new PathStepNode(7,1);
         PathStepNode s10 = new PathStepNode(8,1);
         PathStepNode s11 = new PathStepNode(8,2);
         PathStepNode s12 = new PathStepNode(8,3);
         PathStepNode s13 = new PathStepNode(8,4);
         PathStepNode s14 = new PathStepNode(8,5);
         PathStepNode s15 = new PathStepNode(8,6);
         PathStepNode s16 = new PathStepNode(8,7);
         PathStepNode s17 = new PathStepNode(8,8);
         
         s1.setPrev(null);s1.setNext(s2);
         s2.setPrev(s1);s2.setNext(s3);
         s3.setPrev(s2);s3.setNext(s4);
         s4.setPrev(s3);s4.setNext(s5);
         s5.setPrev(s4);s5.setNext(s6);
         s6.setPrev(s5);s6.setNext(s7);
         s7.setPrev(s6);s7.setNext(s8);
         s8.setPrev(s7);s8.setNext(s9);
         s9.setPrev(s8);s9.setNext(s10);
         s10.setPrev(s9);s10.setNext(s11);
         s11.setPrev(s10);s11.setNext(s12);
         s12.setPrev(s11);s12.setNext(s13);
         s13.setPrev(s12);s13.setNext(s14);
         s14.setPrev(s13);s14.setNext(s15);
         s15.setPrev(s14);s15.setNext(s16);
         s16.setPrev(s15);s16.setNext(s17);
         s17.setPrev(s16);s17.setNext(null);
         
         System.out.println("ALL steps is: ");
         System.out.println(s1);System.out.println(s2);System.out.println(s3);
         System.out.println(s4);System.out.println(s5);System.out.println(s6);
         System.out.println(s7);System.out.println(s8);System.out.println(s9);
         //and so on.
        
    }

}

