/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ragha
 */

import java.util.ArrayList;


public class PathsTree {

    private PathsTreeNode root;

    /**
     * Initializes an empty tree
     */
    public PathsTree() {
        this.root = null;
    }

    /**
     * Initializes a tree starting at position (0, 0) of Chessboard chessboard
     */
    public PathsTree(Chessboard chessboard) {
        this.root = new PathsTreeNode(chessboard, new ChessboardPosition(0, 0, null));
    }

    /**
     * Initializes a tree with root at position pos of Chessboard chessboard
     */
    public PathsTree(Chessboard chessboard, ChessboardPosition pos) {
        this.root = new PathsTreeNode(chessboard, pos);
    }

    public void print() {
        print(0);
    }

    private void print(int indent) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }

        System.out.println(root.pos);
        for (PathsTree node : root.children) {
            node.print(indent + 2);
        }
    }

    public ArrayList<DLLPath> findAllPaths() {
        ArrayList<DLLPath> paths = new ArrayList<DLLPath>();
        return findAllPaths(paths);
    }

    public ArrayList<DLLPath> findAllPaths(ArrayList<DLLPath> paths) {
        
      
        
        if(root.chessboard.getPosStatus(root.pos)==ChessboardStatus.GOAL){
             DLLPath newpath = new DLLPath();
                
                ChessboardPosition From = root.pos;
                while(From!=null){
                int row = From.getCoords()[0];
                int col = From.getCoords()[1];
                newpath.addFirst(row,col);
                From = From.getFrom();
                }
                paths.add(newpath);
                 return paths;
            }
           
          for (PathsTree subtree : root.children){
          ArrayList<DLLPath> path= subtree.findAllPaths();
          
          for(int i=0;i<path.size();i++){
              DLLPath newpath = path.get(i);
              paths.add(newpath);
          }
          }
          return paths;
          
         //--------------------------------------
        
       
        
                
   /*     for(int i=0;i<root.children.size();i++){
            PathsTree obj = root.children.get(i);
            
            if(obj.root.chessboard.getPosStatus(obj.root.pos)==ChessboardStatus.GOAL){
                DLLPath newpath = new DLLPath();
                
                ChessboardPosition From = obj.root.pos;
                while(From!=null){
                int row = From.getCoords()[0];
                int col = From.getCoords()[1];
                newpath.addFirst(row,col);
                From = From.getFrom();
                }
                
                paths.add(newpath);
                
            }
             
            
        }
        
        return paths;*/
        //-----------------------------
                
        
        
        /*  Task #4b: Finding all paths  
         * 
         * - This method should return all the valid paths as a DLLPath objects in the ArrayList.
         *
        */
        
        // Write your code here..
        
       // return null;  // TO DO: modify appropriately
        
        
    }

    /**
     * Models each node in the paths tree Contains the position of the current
     * step and references to the next possible steps
     */
    private class PathsTreeNode {
        private Chessboard chessboard;
        private ChessboardPosition pos;
        private ArrayList<PathsTree> children;

        PathsTreeNode(Chessboard chessboard, ChessboardPosition pos) {
            this.chessboard = chessboard;
            this.pos = pos;
            this.children = new ArrayList<PathsTree>();
            this.exploreAllChildren();
        }

        void exploreAllChildren() {
            
            if(chessboard.getPosStatus(pos)==ChessboardStatus.GOAL)
                return;
            
            ChessboardPosition Lpos = chessboard.getNeighbour(pos, Move.LEFT);
            ChessboardPosition Upos = chessboard.getNeighbour(pos, Move.UP);
            ChessboardPosition Rpos = chessboard.getNeighbour(pos, Move.RIGHT);
            ChessboardPosition Dpos = chessboard.getNeighbour(pos, Move.DOWN);
            
            if(Lpos!=null && chessboard.getPosStatus(Lpos)!=ChessboardStatus.OBSTACLE && this.isAncestor(Lpos)==false){
                PathsTree obj = new PathsTree(chessboard,Lpos);
                children.add(obj);
            }
            
            if(Upos!=null && chessboard.getPosStatus(Upos)!=ChessboardStatus.OBSTACLE && this.isAncestor(Upos)==false){
                PathsTree obj = new PathsTree(chessboard,Upos);
                children.add(obj);
            }
            
            if(Rpos!=null && chessboard.getPosStatus(Rpos)!=ChessboardStatus.OBSTACLE && this.isAncestor(Rpos)==false){
                PathsTree obj = new PathsTree(chessboard,Rpos);
                children.add(obj);
            }
            
            if(Dpos!=null && chessboard.getPosStatus(Dpos)!=ChessboardStatus.OBSTACLE && this.isAncestor(Dpos)==false){
                PathsTree obj = new PathsTree(chessboard,Dpos);
                children.add(obj);
            }
            
            
            /*  Task #4a: Explore all children  
            * 
            * - This method should explore all children of a PathsTreeNode.
            * - Moves priority: {LEFT, UP, RIGHT, DOWN}
            * - You can use Move.values() to get the moves.
            * - This method will explore children and add them to 'children' ArrayList as a PathsTree.
            * - If the child is OPEN then you should explore its children
            * - If the child is GOAL then you should just add it to 'children' ArrayList as a PathsTree.
            * - You shouldn't add a child to 'children' ArrayList if it's OBSTACLE or NULL
            * - You shouldn't add a child to 'children' ArrayList if it's already added in the its parents path (You can use isAncestor() method to check)
            */
            
            
            // Write your code here..
            
            
        }

        /**
         * Checks whether pos is an ancestor of this
         */
        boolean isAncestor(ChessboardPosition pos) {

            boolean res = false;
            ChessboardPosition p = this.pos;
            while (p != null) {
                if (p.equals(pos)) {
                    return true;
                }
                p = p.getFrom();
            }
            return res;

        }

    }

    public static void main(String[] args){
        
        PathsTree tree = new PathsTree(new Chessboard(ChessboardSamples.sChessboard1));
        
        tree.print();
        
       /*ArrayList<DLLPath> paths = tree.findAllPaths();
        for(int i=0;i<paths.size();i++){
            DLLPath obj = paths.get(i);
            System.out.println(obj);
        }*/
    }

}

