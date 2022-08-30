package dev.evanishyn.entities;

public class HighScore {

    private int id;
    private String initials;
    private int highScore;

    public HighScore() {
    }

    public HighScore(int id, String initials, int highScore) {
        this.id = id;
        this.initials = initials;
        this.highScore = highScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public String toString() {
        return "HighScore{" +
                "id=" + id +
                ", initials='" + initials + '\'' +
                ", highScore=" + highScore +
                '}';
    }
}
