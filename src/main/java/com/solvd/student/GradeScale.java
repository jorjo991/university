package com.solvd.student;

public enum GradeScale {

    A(91, 100, 4.0),
    B(81, 90, 3.0),
    C(71, 80, 2.0),
    D(61, 70, 1.0),
    E(51, 60, 0.0),
    F(0, 50, 0.0);

    private int from, to;
    private double gpa;

    GradeScale(int from, int to, double gpa) {
        this.from = from;
        this.to = to;
        this.gpa = gpa;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static GradeScale fromGrade(double grade) {
        if (grade > 100 || grade < 0) throw new RuntimeException("Grande out of Bound");
        for (GradeScale gradeScale : GradeScale.values()) {
            if (grade >= gradeScale.getFrom() & grade < gradeScale.getTo()) {
                return gradeScale;
            }
        }
        return F;
    }

    @Override
    public String toString() {
        return switch (this) {
            case A -> "A";
            case B -> "B";
            case C -> "C";
            case D -> "D";
            case E -> "E";
            case F -> "F";
        };
    }
}
