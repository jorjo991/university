package org.solvd.student;

public enum StudentStatus {

    FRESHMAN(1, 2),
    SOPHOMORE(3, 4),
    JUNIOR(5, 6),
    SENIOR(7, 8),
    GRADUATE(9, 10);

    private int from;
    private int to;

    StudentStatus(int from, int to) {
        this.from = from;
        this.to = to;
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

    public static StudentStatus assignStudentStatus(int number) {
        if (number < 0) throw new RuntimeException("Number Out of Bound");
        switch (number) {
            case 1, 2 -> {
                return FRESHMAN;
            }
            case 3, 4 -> {
                return SOPHOMORE;
            }
            case 5, 6 -> {
                return JUNIOR;
            }
            case 7, 8 -> {
                return SENIOR;
            }
        }
        return GRADUATE;
    }
}
