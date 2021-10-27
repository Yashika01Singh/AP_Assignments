public class Player {
    private String Name;
    private int position;
    private int points;
    Player(String name){
        this.Name = name;
        this.points=0;
        this.position=-1;
    }
    public void updatepoints(int temp){
        this.points +=temp;
    }
    public void updatepos(int temp){
        this.position =temp;
    }
    public void Display(Floor f){
        System.out.printf("Player has reached floor- %d \n",this.position);
        System.out.printf("%s has reached %s \n",this.Name,f.name());
        System.out.printf("Total points %d \n", this.points); 
    }
    public int getpos(){
        return this.position;
    }
    public void printpoints(){
        System.out.printf("%s has accumulated %d points" , this.Name , this.points);
    }
    public void reset(){
        this.points=0;
        this.position=-1;
    }
}
