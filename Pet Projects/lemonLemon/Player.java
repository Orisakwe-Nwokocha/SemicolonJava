package lemonLemon;

public class Player {
    private boolean isElimanted;
    private int id;

    public Player(int id) {
        this.id = id;
    }

    public boolean isElimanted() {
        return isElimanted;
    }

    public int getId() {
        return id;
    }

    public void changeStatus() {
        isElimanted = true;
    }

  /*  public String toString() {
        //return

    }*/
}
