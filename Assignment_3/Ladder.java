public class Ladder extends Floor{
    private String name;
    private int pos,points;
    Ladder(){
        this.name = "a Ladder";
        this.points=2;
        this.pos = 4;
    }
    public String name(){
        return this.name;
    }
    public int pos(){
        return this.pos;
    }
    public int points(){
        return this.points;
    }

}