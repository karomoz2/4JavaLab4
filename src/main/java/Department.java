enum idDepartment{
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

}


public class Department {

    int iD;
    String name;
    Department(int iD,String name)
    {

        this.iD=iD;
        this.name=name;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + iD +
                ", Name='" + name + '\'' +
                '}';
    }
}
