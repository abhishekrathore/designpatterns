class Singleton {

    private static Singleton instance;
    private String name;    
    private Singleton(){}
    
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

public class SingletonTest{

 public static void main(String[] args) {
     Singleton s1 = Singleton.getInstance();
     Singleton s2 = Singleton.getInstance();

     s1.setName("Object1");
     s2.setName("Object2");

     System.out.println(s1.getName());
     System.out.println(s2.getName());

     
 }

}