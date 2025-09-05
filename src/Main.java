import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Students
        Student johnSmith = new Student("John", "Smith", "20", "S001");
        Student emmaJohnson = new Student("Emma", "Johnson", "21", "S002");
        Student michaelBrown = new Student("Michael", "Brown", "22", "S003");
        Student sophiaWilliams = new Student("Sophia", "Williams", "19", "S004");
        Student davidJones = new Student("David", "Jones", "23", "S005");
        Student oliviaGarcia = new Student("Olivia", "Garcia", "20", "S006");
        Student danielMartinez = new Student("Daniel", "Martinez", "24", "S007");
        Student avaDavis = new Student("Ava", "Davis", "22", "S008");
        Student jamesLopez = new Student("James", "Lopez", "21", "S009");
        Student isabellaHernandez = new Student("Isabella", "Hernandez", "20", "S010");

        //

        //Faculties
        Faculty computerScience = new Faculty("Computer Science", 101);
        Faculty mathematics = new Faculty("Mathematics", 102);
        Faculty physics = new Faculty("Physics", 103);
        Faculty engineering = new Faculty("Engineering", 104);

        //

        //professor
        Professor danielCarter = new Professor("Daniel", "Carter", 41, new ArrayList<>());
        Professor sophiaBennett = new Professor("Sophia", "Bennett", 37, new ArrayList<>());
        Professor michaelTurner = new Professor("Michael", "Turner", 52, new ArrayList<>());
        Professor claraReynolds = new Professor("Clara", "Reynolds", 60, new ArrayList<>());
        Professor oliverHayes = new Professor("Oliver", "Hayes", 36, new ArrayList<>());
        Professor emilyFoster = new Professor("Emily", "Foster", 44, new ArrayList<>());
        Professor williamBrooks = new Professor("William", "Brooks", 55, new ArrayList<>());
        Professor natalieGrant = new Professor("Natalie", "Grant", 48, new ArrayList<>());
        Professor ethanMitchell = new Professor("Ethan", "Mitchell", 50, new ArrayList<>());
        Professor isabellaWright = new Professor("Isabella", "Wright", 40, new ArrayList<>());

        //

       //Courses

        Course algorithms = new Course("Algorithms", 1, new ArrayList<>(), danielCarter);
        Course dataStructures = new Course("Data Structures", 2, new ArrayList<>(), null);
        Course operatingSystems = new Course("Operating Systems", 3, new ArrayList<>(), null);
        Course databases = new Course("Databases", 4, new ArrayList<>(), null);
        Course computerNetworks = new Course("Computer Networks", 5, new ArrayList<>(), null);
        Course softwareEngineering = new Course("Software Engineering", 6, new ArrayList<>(), null);
        Course machineLearning = new Course("Machine Learning", 7, new ArrayList<>(), null);
        Course artificialIntelligence = new Course("Artificial Intelligence", 8, new ArrayList<>(), null);
        Course webDevelopment = new Course("Web Development", 9, new ArrayList<>(), null);
        Course cybersecurity = new Course("Cybersecurity", 10, new ArrayList<>(), null);

     //

        University university = new University("KIU", new ArrayList<>(),new ArrayList<>(),new ArrayList<>(), new ArrayList<>());

     // Enrollment

        // Enrollments
        Enrollment enrollment1 = new Enrollment(johnSmith, algorithms, danielCarter);
        Enrollment enrollment2 = new Enrollment(emmaJohnson, dataStructures, sophiaBennett);
        Enrollment enrollment3 = new Enrollment(michaelBrown, operatingSystems, michaelTurner);
        Enrollment enrollment4 = new Enrollment(sophiaWilliams, databases, claraReynolds);
        Enrollment enrollment5 = new Enrollment(davidJones, computerNetworks, oliverHayes);
        Enrollment enrollment6 = new Enrollment(oliviaGarcia, softwareEngineering, emilyFoster);
        Enrollment enrollment7 = new Enrollment(danielMartinez, machineLearning, williamBrooks);
        Enrollment enrollment8 = new Enrollment(avaDavis, artificialIntelligence, natalieGrant);
        Enrollment enrollment9 = new Enrollment(jamesLopez, webDevelopment, ethanMitchell);
        Enrollment enrollment10 = new Enrollment(isabellaHernandez, cybersecurity, isabellaWright);

       // Administration

        Administration admissionsOffice = new Administration(
                Arrays.asList("Alice Johnson", "Robert King"),
                "Admissions Office",
                "Student Affairs"
        );

        Administration financeOffice = new Administration(
                Arrays.asList("David Miller", "Sophia Brown"),
                "Finance Office",
                "Financial Department"
        );

        Administration itSupport = new Administration(
                Arrays.asList("James Wilson", "Olivia Green", "Ethan White"),
                "IT Support",
                "Technical Services"
        );

        Administration libraryServices = new Administration(
                Arrays.asList("Emma Taylor", "Daniel Lewis"),
                "Library Services",
                "Academic Resources"
        );

        Administration hrDepartment = new Administration(
                Arrays.asList("Michael Clark", "Isabella Hall"),
                "Human Resources",
                "Administration"
        );

        // Classroom objects
        Classroom roomA101 = new Classroom(101, "A101", true);
        Classroom roomA102 = new Classroom(102, "A102", false);
        Classroom roomB201 = new Classroom(201, "B201", true);
        Classroom roomB202 = new Classroom(202, "B202", false);
        Classroom roomC301 = new Classroom(301, "C301", true);
        Classroom roomC302 = new Classroom(302, "C302", true);
        Classroom roomD401 = new Classroom(401, "D401", false);
        Classroom roomD402 = new Classroom(402, "D402", true);
        Classroom roomE501 = new Classroom(501, "E501", false);
        Classroom roomE502 = new Classroom(502, "E502", true);


        //Grades for one exam

        Grade grade1 = new Grade(johnSmith, danielCarter, 95);
        Grade grade2 = new Grade(emmaJohnson, sophiaBennett, 88);
        Grade grade3 = new Grade(michaelBrown, michaelTurner, 92);
        Grade grade4 = new Grade(sophiaWilliams, claraReynolds, 76);
        Grade grade5 = new Grade(davidJones, oliverHayes, 85);
        Grade grade6 = new Grade(oliviaGarcia, emilyFoster, 90);
        Grade grade7 = new Grade(danielMartinez, williamBrooks, 82);
        Grade grade8 = new Grade(avaDavis, natalieGrant, 94);
        Grade grade9 = new Grade(jamesLopez, ethanMitchell, 78);
        Grade grade10 = new Grade(isabellaHernandez, isabellaWright, 89);



        //  creating University by adding courses, professor, students and faculties;

        university.addCourse(algorithms);
        university.addCourse(dataStructures);
        university.addCourse(operatingSystems );
        university.addCourse(databases);
        university.addCourse(computerNetworks);
        university.addCourse(softwareEngineering);

        System.out.println("Created Courses "+Course.getCountCourse());


        algorithms.registration(johnSmith);
        algorithms.registration(emmaJohnson );
        algorithms.registration(michaelBrown );
        algorithms.registration(sophiaWilliams);




        System.out.println("Algorithm Course  Students "+ algorithms.getStudents());
        System.out.println("Algorithm Course "+algorithms.getProfessor());


        // Create Grade objects for the students in Algorithms course
        Grade gradeJohn = new Grade(johnSmith, danielCarter, 95);
        Grade gradeEmma = new Grade(emmaJohnson, danielCarter, 88);
        Grade gradeMichael = new Grade(michaelBrown, danielCarter, 92);
        Grade gradeSophia = new Grade(sophiaWilliams, danielCarter, 76);

        List<Grade> algoGrades = Arrays.asList(gradeJohn, gradeEmma, gradeMichael, gradeSophia);
        List<Student> algoStudents=Arrays.asList(johnSmith,emmaJohnson,michaelBrown,sophiaWilliams);


        LocalDate examDate = LocalDate.of(2025, 6, 15);
        Classroom classroom= new Classroom(12,"Room021",true);


        Exam algorithmExam= new Exam(algoGrades,danielCarter,algorithms,algoStudents, examDate,classroom);
        System.out.println( algorithmExam.examResult(algoStudents));



















    }
}