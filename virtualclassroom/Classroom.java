package virtualclassroom;

public class Classroom {

      private String className;

    //different types of constructor
    public Classroom(String className) {
        this.className = className;
    }

    public Classroom() {
    }
    
    
    //getter and setter for all attributes  
    public String getclassName() {
        return className;
    }

    public void setclassName(String className) {
        this.className = className;
    }

 
    @Override
    public String toString() {
        return "Classroom{" +
                ", className='" + className + '\'' +
                '}';
    }
}