public class Person {

    public static int count = 0;
    private String name;
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void printName(String name, String second){
        System.out.println("имя : " + name);
        System.out.println("фамилия :" + second);
    }
}
