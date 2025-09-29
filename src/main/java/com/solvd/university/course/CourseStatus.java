package com.solvd.university.course;

public enum CourseStatus {

    OPEN(true, "Course is open for registration"),
    IN_PROGRESS(false, "Course is in progress"),
    CLOSED(false, "Course is closed");

    private final boolean isRegistrable;
    private final String description;

    CourseStatus(boolean isRegistrable, String description) {
        this.isRegistrable = isRegistrable;
        this.description = description;
    }

    public boolean isRegistrable() {
        return isRegistrable;
    }

    public String getDescription() {
        return description;
    }

    public void updateStatus(CourseStatus newStatus) {
        System.out.println("Updating status from " + this + " to " + newStatus);
    }
}
