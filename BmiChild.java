public class BmiChild extends Parent{ //inheritance
    double bmi;
    BmiChild(String name, int age, int height, int weight){
        super(name, age, height, weight);
    }

    void calculateBMI(){
        double height = (double)super.height;
        int weight = super.weight;
        height = height/100;
        this.bmi = weight/((double)height*height);
    }

    //method overriding
    @Override
    void printInfo(){
        super.printInfo();
        if(bmi == 0) calculateBMI();
        System.out.printf("BMI: %.2f",this.bmi);
    }

    //copy constructor
    BmiChild(BmiChild bmiChild, String name){
        super(name, bmiChild.age, bmiChild.height, bmiChild.weight);
        this.bmi = 0;
    }
}
