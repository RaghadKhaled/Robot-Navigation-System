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
 * Possible movements (in 2 dimensional space)
 */
public enum Move {

    /**
     * Each possible movement has as associated data its: text representation,
     * vertical shift, horizontal shift
     */
    LEFT('<', 0, -1), UP('^', -1, 0), RIGHT('>', 0, 1), DOWN('v', 1, 0);

    private char text;
    private int vShift;
    private int hShift;

    Move(char s, int vShift, int hShift) {
        this.text = s;
        this.vShift = vShift;
        this.hShift = hShift;
    }

    public char text() {
        return this.text;
    }

    public int vShift() {
        return this.vShift;
    }

    public int hShift() {
        return this.hShift;
    }

    //I sent to it obj of move , and return the opposite of this direction
    public Move opposite(Move mov) {
        Move undo = null;
        switch (mov) {
            case UP:
                undo = DOWN;
                break;
            case DOWN:
                undo = UP;
                break;
            case LEFT:
                undo = RIGHT;
                break;
            case RIGHT:
                undo = LEFT;
                break;
        }
        return undo;
    }
    public static void main(String[] args){
        
        for(Move obj : Move.values())
            System.out.println("Constant is: "+obj+", text: "+obj.text()+", vertical shift: "+obj.vShift()+", horizontal shift: "+obj.hShift());
        
        Move obj1 = Move.UP;
        Move opp_obj1 = obj1.opposite(obj1);
        
        Move obj2 = Move.DOWN;
        Move opp_obj2 = obj2.opposite(obj2);
        
        Move obj3 = Move.RIGHT;
        Move opp_obj3 = obj3.opposite(obj3);
        
        Move obj4 =Move.LEFT;
        Move opp_obj4 = obj4.opposite(obj4);
        
        System.out.println("-------------");
        
        System.out.println("Obj1 : "+obj1+", its oppsite is: "+opp_obj1);
        System.out.println("Obj2 : "+obj2+", its oppsite is: "+opp_obj2);
        System.out.println("Obj3 : "+obj3+", its oppsite is: "+opp_obj3);
        System.out.println("Obj4 : "+obj4+", its oppsite is: "+opp_obj4);
    }
}
