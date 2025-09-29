package com.solvd.professor;

public enum ProfessorRank {

    ASSISTANT(1, "Assistant Professor", 50000.0),
    ASSOCIATE(2, "Associate Professor", 75000.0),
    FULL(3, "Full Professor", 100000.0);

    private final int seniorityLevel;
    private final String title;
    private final double baseSalary;

    ProfessorRank(int seniorityLevel, String title, double baseSalary) {
        this.seniorityLevel = seniorityLevel;
        this.title = title;
        this.baseSalary = baseSalary;
    }

    public int getSeniorityLevel() {
        return seniorityLevel;
    }

    public String getTitle() {
        return title;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public boolean isTenureEligible() {
        return this == ASSOCIATE || this == FULL;
    }

    public double calculateAdjustedSalary(double yearsOfExperience) {
        double bonus = yearsOfExperience > 5 ? 0.1 * baseSalary : 0.0; // 10% bonus after 5 years
        return baseSalary + bonus;
    }
}
