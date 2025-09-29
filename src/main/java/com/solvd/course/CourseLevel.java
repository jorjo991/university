package com.solvd.course;

public enum CourseLevel {

    BEGINNER(1, "Suitable for new learners"),
    INTERMEDIATE(2, "Requires some prior knowledge"),
    ADVANCED(3, "Challenging, for experienced students");

    // Fields
    private final int difficultyScore;
    private final String description;

    // Constructor
    CourseLevel(int difficultyScore, String description) {
        this.difficultyScore = difficultyScore;
        this.description = description;
    }

    public int getDifficultyScore() {
        return difficultyScore;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBeginner() {
        return this == BEGINNER;
    }

    public boolean isIntermediate() {
        return this == INTERMEDIATE;
    }

    public boolean isAdvanced() {
        return this == ADVANCED;
    }

    @Override
    public String toString() {
        return name() + " (Difficulty: " + difficultyScore + ") - " + description;
    }
}

