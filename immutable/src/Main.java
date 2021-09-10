public class Main {


    public static void main(String[] args) {
        Age age = new Age();
        age.setYear(10);
        ImmutableStudent immutableStudent = new ImmutableStudent("Viktor",age);
        ImmutableStudent immutableStudent1 = immutableStudent.setName("PAvel");
        age.setYear(12);
        ImmutableStudent immutableStudent2 = immutableStudent.setAge(age);
        System.out.println(immutableStudent.getName()+" "+immutableStudent.getAge().getYear());
        System.out.println(immutableStudent1.getName()+" "+immutableStudent1.getAge().getYear());
        System.out.println(immutableStudent2.getName()+" "+immutableStudent2.getAge().getYear());

    }

}