public class Parent {
    protected int height;
    protected int weight;
    protected int age;
    String name;
    Parent(String name, int age, int height, int weight){
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.name = name;
        System.out.println("Hello Everyone I am "+name);
    }

    void printInfo(){
        System.out.println("Info\n:"+ "Name: "+ this.name+"\nage:"+this.age);
    }
}
