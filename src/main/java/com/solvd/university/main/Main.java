package com.solvd.university.main;

import com.solvd.university.administraion.*;
import com.solvd.university.anotation.Execution;
import com.solvd.university.course.Course;
import com.solvd.university.course.CourseLevel;
import com.solvd.university.course.CourseStatus;
import com.solvd.university.course.Faculty;
import com.solvd.university.exam.ExamSession;
import com.solvd.university.exam.FinalExam;
import com.solvd.university.exam.Result;
import com.solvd.university.lamdafucntion.AverageCalculator;
import com.solvd.university.lamdafucntion.CountRank;
import com.solvd.university.lamdafucntion.CourseFilter;
import com.solvd.university.person.Gender;
import com.solvd.university.person.Person;
import com.solvd.university.professor.Professor;
import com.solvd.university.professor.ProfessorRank;
import com.solvd.university.room.ExamRoom;
import com.solvd.university.student.Student;
import com.solvd.university.university.Address;
import com.solvd.university.university.University;


import java.lang.reflect.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws NoSuchMethodException {

        Administration administration = new Administration();
        University university = new University("KIU");
        Address universityAddress = new Address("Rustaveli Avenue", 25, "Building A", "Tbilisi");
        university.setAddress(universityAddress);

        //professor
        Professor prof1 = new Professor(1, 45, " Emily", "Smith", Gender.FEMALE, "Computer Science", ProfessorRank.ASSISTANT);
        Professor prof2 = new Professor(2, 50, "James", "Johnson", Gender.MALE, "Mathematics", ProfessorRank.FULL);
        Professor prof3 = new Professor(3, 38, "Eva", "Williams", Gender.FEMALE, "Physics", ProfessorRank.ASSISTANT);

        //Courses
        Course math = new Course("Mathematics", 6, CourseLevel.ADVANCED, CourseStatus.OPEN);
        Course cs = new Course("Computer Science", 8, CourseLevel.ADVANCED, CourseStatus.OPEN);
        Course physics = new Course("Physics", 5, CourseLevel.BEGINNER, CourseStatus.CLOSED);

        //Students
        Student alice = new Student(1, 20, "Alice", "Brown", Gender.FEMALE, LocalDate.of(2005, 1, 10), true, 2, 30);
        Student bob = new Student(2, 21, "Bob", "Smith", Gender.MALE, LocalDate.of(2004, 3, 15), false, 3, 40);
        Student clara = new Student(3, 22, "Clara", "Johnson", Gender.FEMALE, LocalDate.of(2003, 5, 20), true, 4, 50);
        Student david = new Student(4, 19, "David", "Williams", Gender.MALE, LocalDate.of(2006, 7, 25), false, 1, 20);
        Student eva = new Student(5, 23, "Eva", "Taylor", Gender.FEMALE, LocalDate.of(2002, 9, 30), true, 5, 60);
        Student frank = new Student(6, 20, "Frank", "Miller", Gender.MALE, LocalDate.of(2005, 11, 12), false, 2, 35);
        Student grace = new Student(7, 21, "Grace", "Davis", Gender.FEMALE, LocalDate.of(2004, 2, 8), true, 3, 45);
        Student henry = new Student(8, 22, "Henry", "Wilson", Gender.MALE, LocalDate.of(2003, 4, 18), false, 4, 55);
        Student isabella = new Student(9, 30, "Isabella", "Moore", Gender.FEMALE, LocalDate.of(2006, 6, 22), true, 1, 25);
        Student jack = new Student(10, 25, "Jack", "Taylor", Gender.MALE, LocalDate.of(2002, 8, 14), false, 5, 65);

        //Faculties
        Faculty scienceFaculty = new Faculty("Science Faculty", 1L);
        Faculty engineeringFaculty = new Faculty("Engineering Faculty", 2L);

        FacultyService facultyService = new FacultyService();
        facultyService.registerFacultyOnUniversity(scienceFaculty, university);
        facultyService.registerFacultyOnUniversity(engineeringFaculty, university);

        // register student on course
        StudentService studentService = new StudentService();
        try {
            studentService.registerStudentOnCourse(alice, math);
            studentService.registerStudentOnCourse(bob, math);
            studentService.registerStudentOnCourse(clara, math);

            studentService.registerStudentOnCourse(david, cs);
            studentService.registerStudentOnCourse(eva, cs);
            studentService.registerStudentOnCourse(frank, cs);
            studentService.registerStudentOnCourse(grace, cs);

            studentService.registerStudentOnCourse(henry, physics);
            studentService.registerStudentOnCourse(isabella, physics);
            studentService.registerStudentOnCourse(jack, physics);

            // try to register same student which must lead DuplicationException
            studentService.registerStudentOnCourse(jack, physics);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }

        CourseService courseService = new CourseService();

        courseService.registerCourseOnFaculty(math, scienceFaculty);
        courseService.registerCourseOnFaculty(cs, scienceFaculty);
        courseService.registerCourseOnFaculty(physics, engineeringFaculty);

        ProfessorService professorService = new ProfessorService();

        //register professor on course
        professorService.registerProfessorOnCourse(prof1, math);
        professorService.registerProfessorOnCourse(prof2, cs);
        professorService.registerProfessorOnCourse(prof3, physics);

        //register student, professor, course and faculties
        // Register professors
        administration.registerProfessor(prof1);
        administration.registerProfessor(prof2);
        administration.registerProfessor(prof3);

        // Register courses
        administration.registerCourse(math);
        administration.registerCourse(cs);
        administration.registerCourse(physics);

        // Register students
        administration.registerStudent(alice);
        administration.registerStudent(bob);
        administration.registerStudent(clara);
        administration.registerStudent(david);
        administration.registerStudent(eva);
        administration.registerStudent(frank);
        administration.registerStudent(grace);
        administration.registerStudent(henry);
        administration.registerStudent(isabella);
        administration.registerStudent(jack);

        // Register faculties
        administration.registerFaculty(scienceFaculty);
        administration.registerFaculty(engineeringFaculty);

        LOGGER.info("size{}", administration.getStudentRepository().getAll().size());

        //print all faculties ->courses-> students and professor
        LOGGER.info(university.getName());

        university.getFaculties().
                forEach(faculty -> {
                    LOGGER.info("Faculty: {}", faculty.getName());
                    faculty.getCourses().
                            forEach(course -> {
                                LOGGER.info("Course: {}", course.getName());
                                LOGGER.info("Professor teaches course: {}", course.getProfessorTeacherCourse().getName());

                                course.getStudents().
                                        forEach(student -> {
                                            LOGGER.info("Student: " + student.getName());
                                        });
                            });
                });

        //create Exam
        ExamRoom room101 = new ExamRoom("Room101", 30, true);
        ExamRoom room102 = new ExamRoom("Room102", 50, true);

        List<Student> finalExamStudents = new ArrayList<>();
        finalExamStudents.add(alice);
        finalExamStudents.add(bob);
        finalExamStudents.add(clara);

        FinalExam exam = new FinalExam(finalExamStudents, math);
        try (ExamSession examSession = new ExamSession(room101)) {
            examSession.conductExam();
            exam.startExam(prof1, finalExamStudents, room101);
            exam.endExam(room101);
        } catch (RuntimeException e) {
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("Exam result");
        List<Result> results = exam.getResults(math, finalExamStudents);
        results.
                forEach(result -> LOGGER.info(result.getStudent().getName() + " " + result.getResult() + " " + result.getGradeScale()));

        //print all student at university
        studentService.print(administration);

        //report about one student
        studentService.report(bob);
        //print course
        courseService.print(administration);
        //iterate Collectins
        LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.info("Iterating Collections");
        Map<Student, List<Course>> studentCourseMap = studentService.getStudentAttendCourse();

        studentCourseMap.keySet().
                forEach(student -> {
                    LOGGER.info(student.getName() + " Studies following courses");
                    studentCourseMap.get(student).
                            forEach(course -> {
                                LOGGER.info(course.getName());
                            });

                });

        Map<Professor, List<Course>> professorCourseMap = professorService.getProfessorTeachesCourses();
        professorCourseMap.keySet().
                forEach(x -> {
                    LOGGER.info("Professor " + x.getName() + " teaches");
                    professorCourseMap.get(x).
                            forEach(y -> {
                                LOGGER.info("Course " + y.getName());
                            });
                });

        //print faculties
        LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.info("Print Faculties");
        university.getFaculties().
                forEach(faculty -> LOGGER.info(faculty.getName()));

        LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.info("First Faculty");
        Faculty firstFaculty = university.getFaculties().iterator().next();

        LOGGER.info(firstFaculty.getName());

        //print Courses
        LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        university.getFaculties().
                forEach(x -> {
                    LOGGER.info(x.getName());
                    LOGGER.info("Courses " + x.getCourses());
                });

        //get first course
        LOGGER.info("First course");
        LOGGER.info(firstFaculty.getCourses().getFirst());


        //getFirstStudent
        LOGGER.info("Print first student");
        LOGGER.info("First Student" + firstFaculty.getCourses().getFirst().getStudents().getFirst());

        //generic method
        LOGGER.info("Reports about Students");
        studentService.report(alice);
        studentService.report(bob);
        studentService.report(clara);

        //report about professor
        LOGGER.info("Report about Professor");
        professorService.report(prof1);
        professorService.report(prof2);

        //print custom lambda expressions

        AverageCalculator averageCalculator = personList -> {
            int answer = personList.stream()
                    .mapToInt(Person::getAge)
                    .sum();
            return (double) (answer / personList.size());
        };

        LOGGER.info("Average Age on Course");
        LOGGER.info(courseService.averageStudentAgeOnCourse(averageCalculator, math));

        //Student average age at university
        LOGGER.info("Student average age at university");
        LOGGER.info(administration.averageStudentAge(averageCalculator));

        //Professor average age at university
        LOGGER.info("Professor average age at university");
        LOGGER.info(administration.averageProfessorAge(averageCalculator));

        //filter courses by credits
        CourseFilter courseFilter = x -> x.getCredit() > 5;

        LOGGER.info("Filter courses by credits");
        administration.getCourseRepository().getAll().
                forEach(course -> {
                    if (course.courseFilter(courseFilter)) LOGGER.info(course.getName());
                });

        //count Professor by rank
        CountRank countRank = (x, professor) -> {
            int count = 0;
            if (professor.getProfessorRank().equals(x)) count++;
            return count;
        };
        LOGGER.info("count Professor by rank");
        LOGGER.info(administration.countProfessorByRank(countRank, ProfessorRank.ASSISTANT));

        //test java.util.function functional interfaces
        //test is course is available or not
        Predicate<Course> coursePredicate = x -> x.getStudents().size() < 50;

        LOGGER.info("Is course available ");
        LOGGER.info(courseService.isCourseAvailable(math, coursePredicate));


        //test student performance
        Function<Student, Integer> studentIntegerFunction = x -> x.getCredits() * x.getSemester() / 5;

        LOGGER.info("Student performance point");
        LOGGER.info(studentService.calculateStudentPerformance(studentIntegerFunction, alice));

        //calculate Score compare to other student on course with credits (Not course Grade)

        ToDoubleBiFunction<Student, Course> courseToDoubleBiFunction = (x, y) -> {
            int sum = y.getStudents().stream().
                    mapToInt(Student::getCredits).
                    sum();
            return (double) x.getCredits() / sum;
        };

        LOGGER.info("Student Name: " + alice.getName() + " Score " + studentService.calculateStudentScoreOnCourse(alice, math, courseToDoubleBiFunction));

        IntPredicate intPredicate = x -> x > 70;

        //supply new Exam Room
        Supplier<ExamRoom> examRoomSupplier = () -> new ExamRoom("105", 50, true);
        LOGGER.info("New exam room " + examRoomSupplier.get().toString());

        BinaryOperator<Integer> integerBinaryOperator = (x, y) -> x / y;
        LOGGER.info("Calculate credit score");
        LOGGER.info(studentService.calculateCreditScore(alice, integerBinaryOperator));

        // stream method  test some of them  are tested already
        LOGGER.info("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.info("STREAMS");

        LOGGER.info("Get Student names on Course " + math.getName());
        LOGGER.info(studentService.getStudentsNameOnCourse(math, administration));

        LOGGER.info("Group Student by age");
        LOGGER.info(studentService.groupStudentsByAGe(administration));

        //chek is there is any  associated Professor at University
        LOGGER.info("is any associated Professor " + professorService.isAnyAssociatedProfessor(administration));

        // get professor sorted buy age
        LOGGER.info("Professors sorted by age");
        LOGGER.info(professorService.getSortedProfessorsByAge(administration));

        //get Max age of professors at university
        LOGGER.info("Professor Max age at university");
        LOGGER.info(professorService.getMaxAgeOFProfessor(administration));

        //flatMap
        LOGGER.info("FlatMap ");
        LOGGER.info(studentService.getStudentsNameOnCourse(math, administration).stream().flatMap(studentName -> studentName.chars().mapToObj(c -> (char) c)).toList());

        //reflection
        LOGGER.info("---------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.info("REFLECTION");

        Class<Student> studentClass = Student.class;

        Arrays.stream(studentClass.getFields()).
                forEach(field -> LOGGER.info("Field: " + field.getName() + ", Type: " + field.getType() + ", Modifiers: " + Modifier.toString(field.getModifiers())));

        Arrays.stream(studentClass.getMethods()).
                forEach(method -> LOGGER.info("Method: " + method.getName() + ", Return type: " + method.getReturnType() + ", Modifiers: " + Modifier.toString(method.getModifiers())));

        Constructor<Student> studentConstructor = studentClass.getConstructor(Integer.class, Integer.class, String.class, String.class, Gender.class, LocalDate.class, Boolean.class, Integer.class, Integer.class);
        try {
            Student jack1 = studentConstructor.newInstance(10, 25, "Jack", "Taylor", Gender.MALE, LocalDate.of(2002, 8, 14), false, 5, 65);
            LOGGER.info(jack1.getAge());
            LOGGER.info(jack1.getName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Class<Administration> administrationClass = Administration.class;

        LOGGER.info("Annotations in Administration class ");
        Arrays.stream(administrationClass.getMethods())
                .forEach(method -> {
                    if (method.isAnnotationPresent(Execution.class)) {
                        Execution annotation = method.getAnnotation(Execution.class);
                        LOGGER.info("Method: " + method.getName() + ", Execution message: " + annotation.message());
                    }
                });
    }
}