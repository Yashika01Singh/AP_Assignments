public class KingKobra  extends Floor{
    private String name;
    private int pos,points;
    KingKobra(){
        this.name = "King Kobra";
        this.points=-4;
        this.pos = -8;
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