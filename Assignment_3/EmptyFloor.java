public class EmptyFloor extends Floor{
    private String name;
    private int pos,points;
    EmptyFloor(){
        this.name = "an Empty Floor";
        this.points=1;
        this.pos =0;
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
