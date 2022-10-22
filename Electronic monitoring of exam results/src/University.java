import java.util.HashMap;
import java.util.Map;

public class University {



    public static void main(String[] args) {

        addStudent("Петров Петр");
        addStudent("Иванов Иван");
        addStudent("Веселова Галина");
        addStudent("Прямоусова Виктория");
        addStudent("Давыдов Алексей");
        addStudent("Таранов Тарас");
        addStudent("Зайцев Валентин");
        addStudent("Борисова Елена");
        addStudent("Лавина Светлана");
        System.out.println();

        addGroup("K-11");
        addGroup("K-12");
        addGroup("K-13");
        System.out.println();

        addSubject("Физика");
        addSubject("Химия");
        addSubject("Философия");
        addSubject("Математика");
        addSubject("Сопромат");
        addSubject("История");
        System.out.println();

        addStudentToGroup("Петров Петр","K-11");
        addStudentToGroup("Иванов Иван","K-11");
        addStudentToGroup("Веселова Галина","K-11");
        addStudentToGroup("Прямоусова Виктория","K-12");
        addStudentToGroup("Давыдов Алексей","K-12");
        addStudentToGroup("Таранов Тарас","K-12");
        addStudentToGroup("Зайцев Валентин","K-13");
        addStudentToGroup("Борисова Елена","K-13");
        addStudentToGroup("Лавина Светлана","K-13");
        System.out.println();

        addGroupToSubject("Физика","K-11");
        addGroupToSubject("Сопромат","K-11");
        addGroupToSubject("Философия","K-12");
        addGroupToSubject("История","K-12");
        addGroupToSubject("Химия","K-13");
        addGroupToSubject("Математика","K-13");
        System.out.println();

        printAllSubjectsByStudent("Петров Петр");
        printAllSubjectsByStudent("Иванов Иван");
        printAllSubjectsByStudent("Веселова Галина");
        printAllSubjectsByStudent("Прямоусова Виктория");
        printAllSubjectsByStudent("Давыдов Алексей");
        printAllSubjectsByStudent("Таранов Тарас");
        printAllSubjectsByStudent("Зайцев Валентин");
        printAllSubjectsByStudent("Борисова Елена");
        printAllSubjectsByStudent("Лавина Светлана");
        System.out.println();

        printGroupByStudent("Петров Петр");
        printGroupByStudent("Иванов Иван");
        printGroupByStudent("Веселова Галина");
        printGroupByStudent("Прямоусова Виктория");
        printGroupByStudent("Давыдов Алексей");
        printGroupByStudent("Таранов Тарас");
        printGroupByStudent("Зайцев Валентин");
        printGroupByStudent("Борисова Елена");
        printGroupByStudent("Лавина Светлана");
        System.out.println();

        printGroupBySubject("Физика");
        printGroupBySubject("Математика");
        printGroupBySubject("Сопромат");
        printGroupBySubject("Философия");
        printGroupBySubject("Химия");
        printGroupBySubject("История");
        System.out.println();

        setGradeToStudentBySubject("Петров Петр","Физика",5);
        setGradeToStudentBySubject("Петров Петр","Физика",5);
        setGradeToStudentBySubject("Петров Петр","Физика",5);
        setGradeToStudentBySubject("Петров Петр","Физика",5);
        setGradeToStudentBySubject("Петров Петр","Сопромат",3);
        setGradeToStudentBySubject("Веселова Галина","Физика",5);
        setGradeToStudentBySubject("Веселова Галина","Сопромат",4);
        setGradeToStudentBySubject("Таранов Тарас","Философия",3);
        setGradeToStudentBySubject("Таранов Тарас","История",5);
        setGradeToStudentBySubject("Давыдов Алексей","Философия",4);
        setGradeToStudentBySubject("Давыдов Алексей","История",3);
        setGradeToStudentBySubject("Лавина Светлана","Математика",5);
        setGradeToStudentBySubject("Борисова Елена","Химия",4);
        setGradeToStudentBySubject("Борисова Елена","Химия",3);
        System.out.println();

        printAllGradesOfAllStudentsByGroup("K-11");
        System.out.println();

        deleteGroup("K-11");


    }

    private static final String STUDENT_ERROR = "Студент отсутствует в базе данных";
    private static final String SUBJECT_ERROR = "Предмет отсутствует в базе данных";
    private static final String GROUP_ERROR = "Группа отсутствует в базе данных";
    private static final Map<String,Student> STUDENTS = new HashMap<>();
    private static final Map<String,Subject> SUBJECTS = new HashMap<>();
    private static final Map<String,Group> GROUPS = new HashMap<>();

    public static void addStudent(String studentName){
        Student student = new Student(studentName);
        STUDENTS.put(student.getName(),student);
        System.out.println("Добавлен студент: "+studentName);
    }

    public static void addGroup(String groupName){
        Group group = new Group(groupName);
        GROUPS.put(group.getName(),group);
        System.out.println("Добавлена группа: "+groupName);
    }

    public static void addSubject(String subjectName){
        Subject subject = new Subject(subjectName);
        SUBJECTS.put(subject.getName(),subject);
        System.out.println("Добавлена дисциплина: "+subjectName);
    }

    public static void addStudentToGroup(String studentName, String groupName){
        Student tempStudent = STUDENTS.get(studentName);
        Group tempGroup = GROUPS.get(groupName);
        if(tempStudent!=null){
            if(tempGroup!=null){
                tempGroup.getStudents().put(studentName,tempStudent);
                tempStudent.setGroup(tempGroup);
                System.out.println("Студент "+studentName+" определен в группу "+groupName);
            }
            else System.out.println(GROUP_ERROR);
        }
        else System.out.println(STUDENT_ERROR);

    }

    public static void addGroupToSubject(String subjectName, String groupName){
        Subject tempSubject = SUBJECTS.get(subjectName);
        Group tempGroup = GROUPS.get(groupName);
        if(tempSubject!=null){
            if(tempGroup!=null){
                tempSubject.getGroups().add(tempGroup);
                tempGroup.getSubjects().put(subjectName, tempSubject);
                System.out.println("Группа "+groupName+" начинает изучать дисциплину: "+subjectName);
            }
            else System.out.println(GROUP_ERROR);
        }
        else System.out.println(SUBJECT_ERROR);
    }

    public static void printAllSubjectsByStudent(String studentName){
        Group tempGroup = STUDENTS.get(studentName).getGroup();
        if(tempGroup!=null){
            System.out.print(studentName+" изучает следующие дисциплины: ");
            for(Subject subject: tempGroup.getSubjects().values()){
                System.out.print(subject.getName()+" ");
            }
            System.out.println();
        }
        else System.out.println(STUDENT_ERROR);
    }

    public static void printGroupByStudent(String studentName){
        Group tempGroup = STUDENTS.get(studentName).getGroup();
        if(tempGroup!=null){
            System.out.println(studentName+" учится в группе "+tempGroup.getName());
        }
        else System.out.println(STUDENT_ERROR);
    }

    public static void printGroupBySubject(String subjectName){
        Subject tempSubject = SUBJECTS.get(subjectName);
        if(tempSubject!=null){
            System.out.print(subjectName+" посещают следующие группы: ");
            for(Group group: tempSubject.getGroups()){
                System.out.println(group.getName());
            }
        }
        else System.out.println(SUBJECT_ERROR);
    }

    public static void setGradeToStudentBySubject(String studentName, String subjectName, Integer grade){
        Student tempStudent = STUDENTS.get(studentName);
        if(tempStudent!=null){
            Subject tempSubject = tempStudent.getGroup().getSubjects().get(subjectName);
            if(tempSubject!=null){
                tempStudent.getGrades().put(subjectName,grade);
                System.out.println("Студент "+studentName+" получает оценку "+grade+" по дисциплине: "+ subjectName);
            }
            else System.out.println("Студент " + studentName + " не обучается на данной дисциплине");
        }
        else System.out.println(STUDENT_ERROR);
    }

    public static void printAllGradesOfAllStudentsByGroup(String groupName){
        Group tempGroup = GROUPS.get(groupName);
        if(tempGroup!=null){
            System.out.println("Оценки учеников из группы "+ groupName +":");
            for(Student student: tempGroup.getStudents().values()){
                System.out.println(student.getName()+":");
                for(Map.Entry<String,Integer> pair: student.getGrades().entrySet()){
                    System.out.println("По дисциплине "+pair.getKey()+" оценка: "+pair.getValue());
                }
            }
        }
        else System.out.println(STUDENT_ERROR);
    }

    public static void deleteGroup(String groupName){
        Group tempGroup = GROUPS.get(groupName);
        if(tempGroup!=null){
            GROUPS.remove(groupName);
            System.out.println("Группа "+ groupName+ " была расформированна. Следующие ученики были отчислены:");
            for(String studentsName: tempGroup.getStudents().keySet()){
                STUDENTS.remove(studentsName);
                System.out.println(studentsName);
            }
            for(Subject subject: SUBJECTS.values()){
                subject.getGroups().remove(tempGroup);
            }

        }
        else System.out.println(GROUP_ERROR);
    }

    public static void changeGradeToStudentBySubject(String studentName, String subjectName, Integer grade){
        Student tempStudent = STUDENTS.get(studentName);
        if(tempStudent!=null){
            tempStudent.getGrades().replace(subjectName,grade);
            System.out.println("Студент "+studentName+" изменил свою оценку на "+grade+" по дисциплине: "+ subjectName);
        }
        else System.out.println(STUDENT_ERROR);
    }









}
