public class Elevator extends Floor{
    private String name;
    private int pos,points;
    Elevator(){
        this.name = "an Elevator Floor";
        this.points=4;
        this.pos = 8;
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