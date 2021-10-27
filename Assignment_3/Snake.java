public class Snake extends Floor{
    private String name;
    private int pos,points;
    Snake(){
        this.name = "a Snake floor";
        this.points=-2;
        this.pos = -4;
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
