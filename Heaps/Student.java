public class Student implements Comparable<Student>{
    int rank;
    String name;

    public Student(String name,int rank) {
        this.rank = rank;
        this.name = name;
    }

    public int compareTo(Student s2) {
        return this.rank - s2.rank;
    }
}
