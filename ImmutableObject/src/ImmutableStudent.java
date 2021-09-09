public final class ImmutableStudent {

    private final String name;
    private final Age age;

    public ImmutableStudent(String name, Age age){
        this.name = name;
        Age cloneAge = new Age();
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }

    public String getName(){return this.name;}
    public Age getAge(){
        Age cloneAge = new Age();
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }
    public ImmutableStudent setName(String name){return new ImmutableStudent(name, this.age);}
    public ImmutableStudent setAge(Age age){return new ImmutableStudent(this.name, age);}

}


