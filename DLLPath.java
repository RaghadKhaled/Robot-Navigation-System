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
 * Class DLLPath represents a path through a chessboard composed of a
 * doubly-linked list of ChessboardSteps (positions)
 */
public class DLLPath { 

    private PathStepNode head;
    private PathStepNode tail;
    private int size;

    public DLLPath() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(int row, int col) {
        PathStepNode n = new PathStepNode(row, col);
        if (this.head == null) {  // empty list
            this.head = n;
            this.tail = n;
        } else {  // non-empty list
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }
        size++;
    }

    public void addLast(int row, int col) {
        // TO DO (Task #1 - c)
        // Adding last node in DLL
        
        // Write your code here ..
          PathStepNode n = new PathStepNode(row, col);
        if (this.head == null) {  // empty list
            this.head = n;
            this.tail = n;
        } else {  // non-empty list
            tail.setNext(n);
            n.setPrev(tail);
            tail=n;
        }
        size++;
        
        
    }

    public int[] removeFirst() {
        // TO DO (Task #1 - d)
        // Removing first node in DLL
        
        int[] coords = null;

        // Write your code here ..
        if(this.head==null && this.tail==null)
            return null;
        else{
            coords = new int[]{head.getRow(),head.getCol()};
            if(head==tail)
                head = tail = null;
            else{
                head = head.getNext();
                head.setPrev(null);
            }
            size--;
        }
        
        return coords;
    }

    public int[] removeLast() {
        // TO DO (Task #1 - d)
        // Removing last node in DLL
        
        int[] coords = null;

        // Write your code here ..
        if(this.head==null && this.tail==null)
            return null;
        else{
            coords = new int[]{tail.getRow(),tail.getCol()};
            if(head==tail)
                head = tail = null;
            else{
                tail = tail.getPrev();
                tail.setNext(null);
            }
            size--;
        }
        
        return coords;
    }

    /**
     * Text-based representation of DLLPath.
     * with the format: (row1, col1), (row2, col2), ..., (rowN, colN)
     */
    public String toString() {

        String sPath = "";
        PathStepNode s = null;

        if (head != null) {
            sPath = "(" + head.getRow() + ", " + head.getCol() + ")";
            s = head.getNext();
        }
        while (s != null) {
            sPath = sPath + ", " + "(" + s.getRow() + ", " + s.getCol() + ")";
            s = s.getNext();
        }

        return sPath;
    }


    /* 
	 * Compares two DLLPaths.
	 * Two DLLPaths are equals if they containing the same sequence of steps. 
     */
    public boolean equals(Object o) {

        DLLPath otherPath = (DLLPath) o;

        if (this.size != otherPath.size) {
            return false;
        }

        PathStepNode s = head;
        PathStepNode os = otherPath.head;

        while ((s != null) && (os != null)) {
            if ((s.getRow() != os.getRow()) || (s.getCol() != os.getCol())) {
                return false;
            }
            s = s.getNext();
            os = os.getNext();
        }

        return s == os;

    }
    public static void main(String[] args){
        DLLPath p1 = new DLLPath();
        p1.addLast(0, 0);p1.addLast(1, 0);p1.addLast(1, 1);p1.addLast(1, 2);p1.addLast(1, 3);p1.addLast(2, 3);p1.addLast(3, 3);
        System.out.println("Size of path: "+p1.size()+"\n");
        System.out.println(p1);
        
        /*while(p1.size()!=0){
        int[] c1 = p1.removeFirst();
        System.out.println("Remove First: "+c1[0]+","+c1[1]);}
        
        int[] c1 = p1.removeFirst();
        if(c1==null)
            System.out.println("Empty Path");*/
        
        /*while(p1.size()!=0){
        int[] c1 = p1.removeLast();
        System.out.println("Remove Last: "+c1[0]+","+c1[1]);}
        
        int[] c1 = p1.removeLast();
        if(c1==null)
            System.out.println("Empty Path");*/
        
        DLLPath p2 = new DLLPath();
        p2.addLast(0, 0);p2.addLast(1, 0);p2.addLast(1, 1);p2.addLast(1, 2);p2.addLast(1, 3);p2.addLast(2, 3);p2.addLast(3, 3);
        
        System.out.println("Path 1 and 2 are equals? "+p1.equals(p2));
        p2.removeFirst();
        System.out.println("Path 1 and 2 are equals? "+p1.equals(p2));
        
        
    }
    
}
