package org.solvd.main;

import org.solvd.administraion.*;
import org.solvd.course.Course;
import org.solvd.course.CourseLevel;
import org.solvd.course.CourseStatus;
import org.solvd.course.Faculty;
import org.solvd.exam.ExamSession;
import org.solvd.exam.FinalExam;
import org.solvd.exam.Result;
import org.solvd.lamdafucntion.AverageCalculator;
import org.solvd.lamdafucntion.CountRank;
import org.solvd.lamdafucntion.CourseFilter;
import org.solvd.person.Gender;
import org.solvd.person.Person;
import org.solvd.professor.Professor;
import org.solvd.professor.ProfessorRank;
import org.solvd.room.ExamRoom;
import org.solvd.student.Student;
import org.solvd.university.Address;
import org.solvd.university.University;

import java.lang.reflect.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class Main {

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
            System.out.println(e.getMessage());
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

        System.out.println(administration.getStudentRepository().getAll());

        //print all faculties ->courses-> students and professor
        System.out.println(university.getName());

        university.getFaculties().forEach(faculty -> {
                    System.out.println("Faculty: " + faculty.getName());
                    System.out.println();

                    faculty.getCourses().forEach(course -> {
                        System.out.println("Course: " + course.getName());
                        System.out.println("Professor teaches course: " + course.getProfessorTeacherCourse().getName());

                        course.getStudents().forEach(student -> {
                            System.out.println("Student: " + student.getName());
                        });

                        System.out.println();
                    });
                }
        );

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
            System.out.println(e.getMessage());
        }
        System.out.println("Exam result");
        List<Result> results = exam.getResults(math, finalExamStudents);
        results.forEach(result -> System.out.println(result.getStudent().getName() + " " + result.getResult() + " " + result.getGradeScale()));

        //print all student at university
        studentService.print(administration);

        //report about one student
        studentService.report(bob);
        System.out.println();
        //print course
        courseService.print(administration);

        //exception check

        //try to register professor with OverAge
        /*
        administration.registerProfessor(new Professor(109,100,"Wolfgang","Paul",Gender.MALE,"ComputerScience"));
         */

        //try to register professor with OverAge
        /*
        administration.registerProfessor(new Professor(109,100,"Wolfgang","Paul",Gender.MALE,"ComputerScience"));

         */
        //try to register student on course who covered  all semester
        /*
        try {
            studentService.registerStudentOnCourse(new Student(10, 23, "Jack", "Taylor", Gender.MALE, LocalDate.of(2002, 8, 14), false, 9, 65), math);
        }
        catch (InvalidRegistrationException e){
            throw  new InvalidAgeException(e.getMessage());
        } catch (RegistrationLimitException e) {
            throw new RuntimeException(e);
        }
         */

        //try to register more than 50 student on course which has limit
        /*
        List<Student> students = new ArrayList<>();

        String[] firstNames = {"Alice", "Bob", "Clara", "David", "Eva", "Frank", "Grace", "Henry", "Isabella", "Jack"};
        String[] lastNames = {"Brown", "Smith", "Johnson", "Williams", "Taylor", "Miller", "Davis", "Wilson", "Moore", "Taylor"};
        Gender[] genders = {Gender.FEMALE, Gender.MALE};

        int id = 1;
        for (int i = 0; i < 5; i++) { // repeat 10 names × 5 = 50
            for (int j = 0; j < 10; j++) {
                // random-ish age between 19-23
                int age = 19 + (j + i) % 5;
                // random-ish semester < 8
                int semester = 1 + (j + i) % 7;
                // some score
                int score = 20 + (j + i) * 5;
                // pick gender alternating
                Gender gender = genders[j % 2];
                // create LocalDate based on age (just example)
                LocalDate dob = LocalDate.of(2025 - age, (j % 12) + 1, (j % 28) + 1);

                Student s = new Student(id++, age, firstNames[j], lastNames[j], gender, dob, true, semester, score);
                students.add(s);
            }
        }

        for(Student student:students){
            try {
                studentService.registerStudentOnCourse(student,math);
            }
            catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
            finally {
                System.out.println("Student registration attempted");
            }
        }
         */

        //iterate Collectins
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Iterating Collections");
        Map<Student, List<Course>> studentCourseMap = studentService.getStudentAttendCourse();

        studentCourseMap.keySet().forEach(student -> {
            System.out.println(student.getName() + " Studies following courses");
            studentCourseMap.get(student).forEach(course -> {
                System.out.println(course.getName());
            });
            System.out.println();
        });

        Map<Professor, List<Course>> professorCourseMap = professorService.getProfessorTeachesCourses();
        professorCourseMap.keySet().forEach(x -> {
            System.out.println("Professor " + x.getName() + " teaches");
            professorCourseMap.get(x).forEach(y -> {
                System.out.println("Course " + y.getName());
                System.out.println();
            });
        });

        //print faculties
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Print Faculties");
        university.getFaculties().forEach(faculty -> System.out.println(faculty.getName()));

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("First Faculty");
        Faculty firstFaculty = university.getFaculties().iterator().next();

        System.out.println(firstFaculty.getName());
        System.out.println();

        //print Courses
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        university.getFaculties().forEach(x -> {
            System.out.println(x.getName());
            System.out.println("Courses " + x.getCourses());
        });
        System.out.println();

        //get first course
        System.out.println("First course");
        System.out.println(firstFaculty.getCourses().getFirst());
        System.out.println();

        //getFirstStudent
        System.out.println("Print first student");
        System.out.println("First Student" + firstFaculty.getCourses().getFirst().getStudents().getFirst());
        System.out.println();

        //generic method
        System.out.println("Reports about Students");
        studentService.report(alice);
        studentService.report(bob);
        studentService.report(clara);
        System.out.println();

        //report about professor
        System.out.println("Report about Professor");
        professorService.report(prof1);
        professorService.report(prof2);

        //print custom lambda expressions

        AverageCalculator averageCalculator = personList -> {
            int answer = 0;
            for (Person person : personList) {
                answer += person.getAge();
            }
            return (double) (answer / personList.size());
        };
        System.out.println();

        System.out.println("Average Age on Course");
        System.out.println(courseService.averageStudentAgeOnCourse(averageCalculator, math));
        System.out.println();

        //Student average age at university
        System.out.println("Student average age at university");
        System.out.println(administration.averageStudentAge(averageCalculator));
        System.out.println();

        //Professor average age at university
        System.out.println("Professor average age at university");
        System.out.println(administration.averageProfessorAge(averageCalculator));
        System.out.println();

        //filter courses by credits
        CourseFilter courseFilter = x -> x.getCredit() > 5;

        System.out.println("Filter courses by credits");
        administration.getCourseRepository().getAll().forEach(course -> {
            if (course.courseFilter(courseFilter)) System.out.println(course.getName());
        });
        System.out.println();

        //count Professor by rank
        CountRank countRank = (x, professor) -> {
            int count = 0;
            if (professor.getProfessorRank().equals(x)) count++;
            return count;
        };
        System.out.println("count Professor by rank");
        System.out.println(administration.countProfessorByRank(countRank, ProfessorRank.ASSISTANT));

        //test java.util.function functional interfaces
        //test is course is available or not
        Predicate<Course> coursePredicate = x -> x.getStudents().size() < 50;
        System.out.println();
        System.out.println("Is course available ");
        System.out.println(courseService.isCourseAvailable(math, coursePredicate));
        System.out.println();

        //test student performance
        Function<Student, Integer> studentIntegerFunction = x -> x.getCredits() * x.getSemester() / 5;

        System.out.println("Student performance point");
        System.out.println(studentService.calculateStudentPerformance(studentIntegerFunction, alice));
        System.out.println();

        //calculate Score compare to other student on course with credits (Not course Grade)

        ToDoubleBiFunction<Student, Course> courseToDoubleBiFunction = (x, y) -> {
            int sum = y.getStudents().stream().mapToInt(Student::getCredits).sum();
            return (double) x.getCredits() / sum;
        };

        System.out.println("Student Name: " + alice.getName() + " Score " + studentService.calculateStudentScoreOnCourse(alice, math, courseToDoubleBiFunction));

        IntPredicate intPredicate = x -> x > 70;

        //supply new Exam Room
        Supplier<ExamRoom> examRoomSupplier = () -> new ExamRoom("105", 50, true);
        System.out.println("New exam room " + examRoomSupplier.get().toString());
        System.out.println();

        BinaryOperator<Integer> integerBinaryOperator = (x, y) -> x / y;
        System.out.println("Calculate credit score");
        System.out.println(studentService.calculateCreditScore(alice, integerBinaryOperator));

        // stream method  test some of them  are tested already
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("STREAMS");

        System.out.println("Get Student names on Course " + math.getName());
        System.out.println(studentService.getStudentsNameOnCourse(math, administration));

        System.out.println("Group Student by age");
        System.out.println(studentService.groupStudentsByAGe(administration));
        System.out.println();

        //chek is there is any  associated Professor at University
        System.out.println("is any associated Professor " + professorService.isAnyAssociatedProfessor(administration));
        System.out.println();

        // get professor sorted buy age
        System.out.println("Professors sorted by age");
        System.out.println(professorService.getSortedProfessorsByAge(administration));

        //get Max age of professors at university
        System.out.println("Professor Max age at university");
        System.out.println(professorService.getMaxAgeOFProfessor(administration));
        System.out.println();

        //reflection
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("REFLECTION");

        Class<Student> studentClass = Student.class;
        for (Field field : studentClass.getFields()) {
            System.out.println("Field: " + field.getName() + ", Type: " + field.getType() + ", Modifiers: " + Modifier.toString(field.getModifiers()));
        }

        for (Method method : studentClass.getMethods()) {
            System.out.println("Method: " + method.getName() +
                    ", Return type: " + method.getReturnType() +
                    ", Modifiers: " + Modifier.toString(method.getModifiers()));
        }
        Constructor<Student> studentConstructor = studentClass.getConstructor(
                Integer.class, Integer.class, String.class, String.class,
                Gender.class, LocalDate.class, Boolean.class,
                Integer.class, Integer.class);
        try {
            Student jack1 = studentConstructor.newInstance(
                    10,
                    25,
                    "Jack",
                    "Taylor",
                    Gender.MALE,
                    LocalDate.of(2002, 8, 14),
                    false,
                    5,
                    65
            );
            System.out.println(jack1.getAge());
            System.out.println(jack1.getName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}