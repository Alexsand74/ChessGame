package org.example;

/*
        StringUtils.isBlank(null)      = true
        StringUtils.isBlank("")        = true
        StringUtils.isBlank(" ")       = true
        StringUtils.isBlank("bob")     = false
        StringUtils.isBlank("  bob  ") = false

        StringUtils.isEmpty(null)      = true
        StringUtils.isEmpty("")        = true
        StringUtils.isEmpty(" ")       = false
        StringUtils.isEmpty("bob")     = false
        StringUtils.isEmpty("  bob  ") = false
*/

import java.util.Objects;

public class Player {
    private String name;
    private String email;
    private boolean white;
    private int rank;
    private int age;

    public Player(String name, String email, boolean white, int rank, int age){

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException( "Name entered incorrectly ! in method Player");
        }
        this.name = name;
        if(email == null || name.isBlank() || !email.contains(".") || email.contains("@") == false ) {
            throw new IllegalArgumentException("The email address entered is not correct ! in method Player");
        }
        this.email = email;
        this.white = white;
        if(rank < 100 || rank > 3000) {
            throw new IllegalArgumentException("The rank argument being input is not in the range 100 to 3000 ! in method Player");
        }
        this.rank = rank;
        if(age < 4 || age > 140) {
            throw new IllegalArgumentException("Age entered is incorrect ! in method Player");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException( "Name entered incorrectly ! in method Player");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || name.isBlank() || !email.contains(".") || !email.contains("@")) {
            throw new IllegalArgumentException("The email address entered is not correct ! in method Player");
        }
        this.email = email;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if(rank < 100 || rank > 3000){
            throw new IllegalArgumentException( "The rank argument being input is not in the range 100 to 3000 ! in method Player");
        }
        System.out.println("old rank "+ this.rank + ", replaced with a new rank " + rank);
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 4 || age > 140) {
            throw new IllegalArgumentException("Age entered is incorrect ! in method Player");
        }
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Player)) return false;
//        Player player = (Player) o;
//        return isWhite() == player.isWhite() && getRank() == player.getRank() && getAge() == player.getAge() && getName().equals(player.getName()) && getEmail().equals(player.getEmail());
//    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), isWhite(), getRank(), getAge());
    }

    @Override
    public String toString() {
        return "Player{" +
                "\n name='" + name + '\'' +
                ",\n email='" + email + '\'' +
                ",\n white=" + white +
                ",\n rank=" + rank +
                ",\n age=" + age +
                '}';
    }
}
