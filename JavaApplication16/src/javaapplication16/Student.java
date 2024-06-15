/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication16;

/**
 *
 * @author Dell
 */
class Student {
    String name;
    String email;
    double score;

    public Student(String name, String email, double score) {
        this.name = name;
        this.email = email;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Score: " + score;
    }

    public String ensucaption() {
        return "Student Summary - Name: " + name + ", Email: " + email + ", Score: " + score;
    }
}

