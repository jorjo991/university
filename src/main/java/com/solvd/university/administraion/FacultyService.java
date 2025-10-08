package com.solvd.university.administraion;

import com.solvd.university.course.Faculty;
import com.solvd.university.exception.DuplicateEntityException;
import com.solvd.university.university.University;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FacultyService implements Printable {

    private static final Logger LOGGER = LogManager.getLogger(FacultyService.class.getName());

    public final void registerFacultyOnUniversity(Faculty faculty, University university) {
        if (university.getFaculties().contains(faculty))
            throw new DuplicateEntityException("Duplicated Faculty Detected");
        university.getFaculties().add(faculty);
    }

    @Override
    public void print(Administration administration) {
        LOGGER.info("all faculties");
        LOGGER.info(administration.getFacultyRepository().getAll());
    }

}

