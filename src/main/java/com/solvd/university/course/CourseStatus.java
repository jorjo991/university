package com.solvd.university.course;

import com.solvd.university.administraion.CourseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum CourseStatus {

    OPEN(true, "Course is open for registration"),
    IN_PROGRESS(false, "Course is in progress"),
    CLOSED(false, "Course is closed");

    private static final Logger LOGGER = LogManager.getLogger(CourseStatus.class.getName());

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
        LOGGER.info("Updating status from {} to {}", this, newStatus);
    }
}
