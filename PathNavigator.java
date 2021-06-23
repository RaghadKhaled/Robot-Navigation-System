
import java.util.ArrayList;

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
 * Class PathNavigator implements algorithms for finding a path using
 a Stack or a Queue
 */
public class PathNavigator {

    private static final Move[] DIRS_TO_EXPLORE = new Move[]{
        Move.LEFT,
        Move.UP,
        Move.DOWN,
        Move.RIGHT
    };
    private boolean isNotVisited(ArrayList<ChessboardPosition> visited,ChessboardPosition pos){
        for(int i=0;i<visited.size();i++){
            //or maybe copmare with its value
            if(visited.get(i).equals(pos))
                return false;
        }
        return true;
    }

    public DLLPath pathNavigatorUsingStack(Chessboard chessboard) {
        /*  TO DO Task #2: Stack Path Finder
         * 
         * - Create an empty Stack to store chessboard positions for future visits.
         * You can use the LinkedStack class already implemented on ADT.
         * - Start at position (0, 0)
         * - Navigate the given chessboard using depth-first search and stack till reach the goal
         * - Return DLLPath
         */
        final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);
        LinkedStack<ChessboardPosition> posToExplore = new LinkedStack<ChessboardPosition>();
        posToExplore.push(initPos);
        DLLPath path = new DLLPath();
        ChessboardPosition goal =null;
        if(chessboard!=null){
            boolean flag = false;
            while(flag== false){
                
                //1.tack the curr pos
                ChessboardPosition pos = posToExplore.pop();
                
                //2.update starues
                if(chessboard.getPosStatus(pos)==ChessboardStatus.GOAL){
                        flag = true;
                        goal = pos;
                }
                   else
                        chessboard.setPosStatus(pos, ChessboardStatus.VISITED);
                
                //3. find all surroiding pos
                ChessboardPosition Lpos = chessboard.getNeighbour(pos, Move.LEFT);
                ChessboardPosition Upos = chessboard.getNeighbour(pos, Move.UP);
                ChessboardPosition Dpos = chessboard.getNeighbour(pos, Move.DOWN);
                ChessboardPosition Rpos = chessboard.getNeighbour(pos, Move.RIGHT);
                
                //3.push just available surronding position
                 if(Lpos!=null && chessboard.getPosStatus(Lpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Lpos)!=ChessboardStatus.VISITED ){
                     posToExplore.push(Lpos);
                 }
                
                 if(Upos!=null && chessboard.getPosStatus(Upos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Upos)!=ChessboardStatus.VISITED ){
                     posToExplore.push(Upos);
                 }
                 
                  if(Dpos!=null && chessboard.getPosStatus(Dpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Dpos)!=ChessboardStatus.VISITED ){
                      posToExplore.push(Dpos);
                  }
                  
                  if(Rpos!=null && chessboard.getPosStatus(Rpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Rpos)!=ChessboardStatus.VISITED ){
                      posToExplore.push(Rpos);
                    }

                
            }//end while
            
          
          ChessboardPosition From = goal;
          while(From!=null){
                int row = From.getCoords()[0];
                int col = From.getCoords()[1];
                path.addFirst(row,col);
                From = From.getFrom();
          }
            return path;
        }
        return null; // TO DO: modify appropriately

           //---------------------
         /*   final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);
        LinkedStack<ChessboardPosition> posToExplore = new LinkedStack<ChessboardPosition>();
        posToExplore.push(initPos);
        DLLPath path = new DLLPath();
        if(chessboard!=null){
            boolean flag = false;
            while(flag== false){
                
                //1.tack the curr pos
                ChessboardPosition pos = posToExplore.top();
                
                //2. find all surroiding pos, but I choice exactly one of them "if any" upon to the order of dirction
                ChessboardPosition Lpos = chessboard.getNeighbour(pos, Move.LEFT);
                ChessboardPosition Upos = chessboard.getNeighbour(pos, Move.UP);
                ChessboardPosition Dpos = chessboard.getNeighbour(pos, Move.DOWN);
                ChessboardPosition Rpos = chessboard.getNeighbour(pos, Move.RIGHT);
                
                //3.push for all surronding position
                posToExplore.push(Lpos);posToExplore.push(Upos);
                posToExplore.push(Dpos);posToExplore.push(Rpos);
                
                //4.compare and find one of its surronding point "not all", stratt with top of stack R D U L
                if(Rpos!=null && chessboard.getPosStatus(Rpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Rpos)!=ChessboardStatus.VISITED ){
                    //1.pop 4 times
                    posToExplore.pop();posToExplore.pop();posToExplore.pop();posToExplore.pop();
                    //2.push Rpos to stack
                    posToExplore.push(Rpos);
                    //3.set visited in 
                    // if its goal?, if not update states
                    if(chessboard.getPosStatus(Rpos)==ChessboardStatus.GOAL)
                        flag = true;
                   else
                        chessboard.setPosStatus(Rpos, ChessboardStatus.VISITED);
                }
                else if(Dpos!=null && chessboard.getPosStatus(Dpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Dpos)!=ChessboardStatus.VISITED ){
                   //1.pop 4 times
                    posToExplore.pop();posToExplore.pop();posToExplore.pop();posToExplore.pop();
                    //2.push Dpos to stack
                    posToExplore.push(Dpos);
                    //3.set visited in 
                    // if its goal?, if not update states
                    if(chessboard.getPosStatus(Dpos)==ChessboardStatus.GOAL)
                        flag = true;
                    else
                        chessboard.setPosStatus(Dpos, ChessboardStatus.VISITED);
                }
                else if(Upos!=null && chessboard.getPosStatus(Upos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Upos)!=ChessboardStatus.VISITED ){
                    //1.pop 4 times
                    posToExplore.pop();posToExplore.pop();posToExplore.pop();posToExplore.pop();
                    //2.push Upos to stack
                    posToExplore.push(Upos);
                    //3.set visited in 
                    // if its goal?, if not update states
                    if(chessboard.getPosStatus(Upos)==ChessboardStatus.GOAL)
                        flag = true;
                     else
                        chessboard.setPosStatus(Upos, ChessboardStatus.VISITED);
                }
                else if(Lpos!=null && chessboard.getPosStatus(Lpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Lpos)!=ChessboardStatus.VISITED ){
                  //1.pop 4 times
                    posToExplore.pop();posToExplore.pop();posToExplore.pop();posToExplore.pop();
                    //2.push Lpos to stack
                    posToExplore.push(Lpos);
                    //3.set visited in 
                    // if its goal?, if not update states
                    if(chessboard.getPosStatus(Lpos)==ChessboardStatus.GOAL)
                        flag = true;
                   else
                        chessboard.setPosStatus(Lpos, ChessboardStatus.VISITED);
                }
                else//backtracing, if all surronding pos is unavailble, pop this curr pos and all its dirction 
                {
                      posToExplore.pop();posToExplore.pop();posToExplore.pop();posToExplore.pop();posToExplore.pop();}
                    
                
                
                
            }//end while
            
            while(!posToExplore.isEmpty()){
                ChessboardPosition pos = posToExplore.pop();
                int row = pos.getCoords()[0];
                int col = pos.getCoords()[1];
                path.addFirst(row,col);
            }
            return path;
        }
        return null; // TO DO: modify appropriately*/
        
     
    
    }

    public DLLPath pathNavigatorUsingQueue(Chessboard chessboard) {
         /*  Task #3: Queue Path Finder
         * 
         * - Create an empty Stack to store chessboard positions for future visits.
         * You can use the LinkedStack class already implemented on ADT.
         * - Start at position (0, 0)
         * - Navigate the given chessboard using breadth-first search and stack till reach the goal
         * - Return DLLPath
         */
         
        final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);
        LinkedQueue<ChessboardPosition> posToExplore = new LinkedQueue<ChessboardPosition>();
        posToExplore.enqueue(initPos);
        DLLPath path = new DLLPath();
        ChessboardPosition goal =null;
        if(chessboard!=null){
            boolean flag = false;
            while(flag== false){
                
                //1.tack the curr pos
                ChessboardPosition pos = posToExplore.dequeue();
                
                //2.update starues
                if(chessboard.getPosStatus(pos)==ChessboardStatus.GOAL){
                        flag = true;
                        goal = pos;
                }
                   else
                        chessboard.setPosStatus(pos, ChessboardStatus.VISITED);
                
                //3. find all surroiding pos
                ChessboardPosition Lpos = chessboard.getNeighbour(pos, Move.LEFT);
                ChessboardPosition Upos = chessboard.getNeighbour(pos, Move.UP);
                ChessboardPosition Dpos = chessboard.getNeighbour(pos, Move.DOWN);
                ChessboardPosition Rpos = chessboard.getNeighbour(pos, Move.RIGHT);
                
                //3.push just available surronding position
                 if(Lpos!=null && chessboard.getPosStatus(Lpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Lpos)!=ChessboardStatus.VISITED ){
                     posToExplore.enqueue(Lpos);
                 }
                
                 if(Upos!=null && chessboard.getPosStatus(Upos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Upos)!=ChessboardStatus.VISITED ){
                     posToExplore.enqueue(Upos);
                 }
                 
                  if(Dpos!=null && chessboard.getPosStatus(Dpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Dpos)!=ChessboardStatus.VISITED ){
                      posToExplore.enqueue(Dpos);
                  }
                  
                  if(Rpos!=null && chessboard.getPosStatus(Rpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Rpos)!=ChessboardStatus.VISITED ){
                      posToExplore.enqueue(Rpos);
                    }

                
            }//end while
            
          
          ChessboardPosition From = goal;
          while(From!=null){
                int row = From.getCoords()[0];
                int col = From.getCoords()[1];
                path.addFirst(row,col);
                From = From.getFrom();
          }
            return path;
        }
        return null; // TO DO: modify appropriately
         //----------------------------------

       /* final ChessboardPosition initPos = new ChessboardPosition(0, 0, null);

        LinkedQueue<ChessboardPosition> posToExplore = new LinkedQueue<ChessboardPosition>();
        DLLPath path = new DLLPath();
        
        //stack to add all severalPaths
        LinkedStack<ChessboardPosition> severalPaths = new LinkedStack<ChessboardPosition>();
        
        if(chessboard!=null){
       
            posToExplore.enqueue(initPos);
            boolean flag =false;
            
            while(flag==false){//while I dont reach to goal.
                
                //1.take curr pos
                ChessboardPosition pos = posToExplore.dequeue();
                
                //2.check if it is goal? add pos to severalPaths stack, then update flage
                if(chessboard.getPosStatus(pos)==ChessboardStatus.GOAL){
                    severalPaths.push(pos);
                    flag = true;
                }
                else{
                  //update status to Visited, becouse in BFS we explore all surronding position
                    chessboard.setPosStatus(pos, ChessboardStatus.VISITED);
                
                //3.take all surronding postion 
                ChessboardPosition Lpos = chessboard.getNeighbour(pos, Move.LEFT);
                ChessboardPosition Upos = chessboard.getNeighbour(pos, Move.UP);
                ChessboardPosition Dpos = chessboard.getNeighbour(pos, Move.DOWN);
                ChessboardPosition Rpos = chessboard.getNeighbour(pos, Move.RIGHT);
              
                int countSurroundingPos =0;//to check if there is any possible postions for this pos?
                
                //4.compare for each surronding positions and check if it is possible pos, push to stack
                if(Lpos!=null && chessboard.getPosStatus(Lpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Lpos)!=ChessboardStatus.VISITED &&!posToExplore.contains(Lpos)){
                    posToExplore.enqueue(Lpos);
                    countSurroundingPos++;
                }
                
                if(Upos!=null && chessboard.getPosStatus(Upos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Upos)!=ChessboardStatus.VISITED &&!posToExplore.contains(Upos)){
                    posToExplore.enqueue(Upos);
                    countSurroundingPos++;
                }
                
                if(Dpos!=null && chessboard.getPosStatus(Dpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Dpos)!=ChessboardStatus.VISITED &&!posToExplore.contains(Dpos)){
                    posToExplore.enqueue(Dpos);
                    countSurroundingPos++;
                }
                
                if(Rpos!=null && chessboard.getPosStatus(Rpos)!=ChessboardStatus.OBSTACLE && chessboard.getPosStatus(Rpos)!=ChessboardStatus.VISITED &&!posToExplore.contains(Rpos)){
                    posToExplore.enqueue(Rpos);
                    countSurroundingPos++;
                }
                //5.if there is at least one available postion for this curr pos, we put this pos in severalPaths stack
                if(countSurroundingPos!=0)
                    severalPaths.push(pos);
                }
            }
            
          
          //after prepare all avalible paths, I want to take shortest path
          
           LinkedStack<ChessboardPosition> shortestPath = new LinkedStack<ChessboardPosition>();
           shortestPath.push(severalPaths.top());
           //to take exctly shortest path from the several paths stack
           //start with goal pos, then take its From attributes "goal come from whitch pos?" until reach to null From pos = [0,0]
           
          ChessboardPosition From = shortestPath.top().getFrom();
          while(From!=null){
              shortestPath.push(From);
              From = shortestPath.top().getFrom();
          }
          
          //then put this shortest path in DLLPath
          
          while(!shortestPath.isEmpty()){
                 ChessboardPosition pos = shortestPath.pop();
                int row = pos.getCoords()[0];
                int col = pos.getCoords()[1];
                path.addLast(row,col);
          }
            
            return path;
        }
        
        // Write your code here ..
        
        return null;  // TO DO: modify appropriately*/
        
          
    }
    public static void main(String[] args){
     /*   PathNavigator obj = new PathNavigator();
        Chessboard chessboard = new Chessboard(ChessboardSamples.sChessboard3);
        DLLPath path = obj.pathNavigatorUsingStack(chessboard);
        System.out.println(path);
        chessboard.followPath(path);
        System.out.println(chessboard);*/
     
        PathNavigator obj = new PathNavigator();
        Chessboard chessboard = new Chessboard(ChessboardSamples.sChessboard3);
        DLLPath path = obj.pathNavigatorUsingQueue(chessboard);
        System.out.println(path);
       chessboard.followPath(path);
        System.out.println(chessboard);
    }

}

