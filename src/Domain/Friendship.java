package Domain;

public class Friendship {
    private int id;

    public Friendship(int id, int id1, int id2) {
        this.id = id;
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", id1=" + id1 +
                ", id2=" + id2 +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    private int id1;
    private int id2;
}