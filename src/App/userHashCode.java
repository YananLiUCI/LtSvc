package App;

public class userHashCode {
    private long id;
    private String name;
    private String email;

    // standard getters/setters/constructors

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (email == null ? 0 : email.hashCode());
        System.out.print("hashCode() called - Computed hash: " + hash);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        userHashCode user = (userHashCode) o;
        return id == user.id
                && (name.equals(user.name)
                && email.equals(user.email));
    }
}
