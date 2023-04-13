import java.util.*;


/**
 * Represents a University with students a courses.
 * The university class will maintain an index of students and courses using Maps.
 *   - The keys for the students' map is the Student's ID
 *   - The keys for the courses' map is the Course's Code
 *
 * Your task in this class is to finish the constructor and implements the methods flagged with TODO.
 * I've [Juliano] moved all already implemented methods under the ones you have to implement.
 * You can re-organize the code if you want.
 */
public class University {
    private Map<Integer, Student> studentBody;
    private Map<String, Course> availableCourses;
    private String universityName;
    private String universityMotto;


    public University(String universityName, String universityMotto) {
        this.universityName = universityName;
        this.universityMotto = universityMotto;
        studentBody = new HashMap<>();
        availableCourses = new HashMap<>();
    }

    /**
     * Adds a student to the university roster. Student's cannot be added twice.
     * @param student the student to be added
     * @return true if the student was added, false if the student was already on the map
     */
    public boolean addStudent(Student student){
        //TODO: Implement the method according to the javadoc
        if(studentBody.get(student.getIdNumber()) != null){
            return false;
        }
        studentBody.put(student.getIdNumber(),student);
        return true;
    }

    /**
     * Gets a student from the university
     * @param idNumber the student's ID.
     * @return the student or null if not found
     */
    public Student getStudent(int idNumber){
        //TODO: Implement this getter
        return studentBody.get(idNumber);
    }

    /**
     * Returns a list containing all the students from the university
     * You will have to work with maps and lists on this method.
     * Referer to the document on how to ITERATE over maps. You CANNOT use foreach directly with maps
     * What is the best List type to use? ArrayList or LinkedList? Why?
     *
     * @return A list of all students (the list will be empty if the university is empty)
     */
    public List<Student> getStudents(){
        //TODO: Implement this method
        LinkedList<Student> result = new LinkedList<>();
        Iterator<Integer> keys = studentBody.keySet().iterator();
        while (keys.hasNext()){
            result.addLast(studentBody.get(keys.next()));
        }
        return result;
    }

    /**
     * Add a course to the courses offered by the university
     * @param course the course object to be added
     * @return true if the course was added, false if the course was already on the university
     */
    public boolean addCourse(Course course){
        //TODO: Implement this method according to the javadocs
        if(availableCourses.get(course.getCourseCode()) != null){
            return false;
        }
        availableCourses.put(course.getCourseCode(),course);
        return true;
    }


    /**
     * Adds a course as a pre-requisite to another course. Both courses must already exist
     * in the university list of offered courses.
     * @param courseID the id of the course you want to add the pre-requisite to
     * @param preReqCourseID the id of the pre-requisite course
     * @return false if either the courseID or preReqCourseID are invalid, true after adding the pre-requisite
     */
    public boolean addRequisiteToCourse(String courseID, String preReqCourseID){
        //TODO: Implement this method
        Course course = availableCourses.get(courseID);
        Course preReq = availableCourses.get(preReqCourseID);
        if(course == null || preReq == null){
            return false;
        }
        course.getPreRequisites().add(preReq);
        return true;
    }

    /**
     * Gets a course from the university
     * @param courseCode the student's ID.
     * @return the course associated with the code or null if not found
     */
    public Course getCourse(String courseCode){
        //TODO: implement this method
        return availableCourses.get(courseCode);
    }

    /**
     * Get a list containing all the courses offered by the university.
     * You will have to work with maps and lists on this method.
     * Referer to the document on how to ITERATE over maps. You CANNOT use foreach directly with maps
     * What is the best List type to use? ArrayList or LinkedList? Why?
     *
     * @return the list of courses offered by the university
     */
    public List<Course> getCourses(){
        //TODO: Implement this method
        LinkedList<Course> result = new LinkedList<>();
        for (Course course : availableCourses.values()){
            result.addLast(course);
        }
        return result;
    }

    /**
     * Enroll a student in a course IF the student has already passed the pre-requisites of the course.
     * Note to students: remember that students keep two lists of course.
     *
     * The method should add the student to the course's list of students and add the course to to the student's
     * list of current courses.
     *
     * @param studentID the id of the student
     * @param courseCode the course code for enrollment.
     * @return false if studentID, courseCode are incorrect, false if the student does not have the pre-requisites
     *         true if the student was enrolled in the course.
     *
     * NOTE2: See how false is representing three different issues? Here the "modern" approach would be to use
     *        exceptions (throw an exception) for the wrong id and code problems.
     */
    public boolean enrollStudentInCourse(int studentID, String courseCode){
        //TODO: Implement this method
        Student st = studentBody.get(studentID);
        Course course = availableCourses.get(courseCode);

        if(st == null || course == null){
            return false;
        }

        //student already in course?
        if(course.getEnrolledStudents().contains(st)){
            return false;
        }

        //Check the pre requisites
        for (Course preReq : course.getPreRequisites()){
            if(!st.getPreviousCourses().contains(preReq)){
                return false;
            }
        }

        //Enroll student by adding it to the course list and adding the course to his list
        course.addStudentToCourse(st);
        st.enrollInCourse(course);

        return true;
    }

    /**
     * Removes a student from a course IF the student is already enrolled in it.
     * @param studentID the student ID
     * @param courseCode the course cod
     * @return false if studentID, courseCode are incorrect, false if the student is not enrolled in the course
     *        true if the student was removed from the course.
     */
    public boolean removeStudentFromCourse(int studentID, String courseCode){
        //TODO: Implement this method
        Student st = studentBody.get(studentID);
        Course course = availableCourses.get(courseCode);

        if(st == null || course == null){
            return false;
        }

        if(!course.getEnrolledStudents().contains(st)){
            return false;
        }

        course.getEnrolledStudents().remove(st);
        st.getEnrolledCourses().remove(course);
        return true;
    }

    /**
     * NOTE TO STUDENTS: Overloaded remove student from course. It might help you (or not) when
     * you are implementing remove student from university
     *
     * In this method you receive a valid student object
     */
    public boolean removeStudentFromCourse(Student student, String courseCode){
        return removeStudentFromCourse(student.getIdNumber(),courseCode);
    }

    /**
     * Removes a student from the university.
     * The student will be removed from the university index AND from the list of students of every course that the
     * student was already enrolled.
     *
     * There are a couple of ways to solve this method. If you iterate over the student's own courses,
     *  you have to be careful not to change the collection while you are iterating (unless you remove with the iterator)
     *
     * @param studentID the id of the student to remove
     * @return false if the studentID is not in the index. True if the student was removed from the index and courses
     */
    public boolean removeStudentFromUniversity(int studentID){
        //TODO: Implement this method
        Student student = studentBody.get(studentID);
        if(student == null){
            return false;
        }

        for (Course course : student.getEnrolledCourses()){
            course.getEnrolledStudents().remove(student);
        }

        student.getEnrolledCourses().clear();


        studentBody.remove(studentID);

        return true;
    }

    /**
     * Removes a course from the university.
     * This method should remove the course from the university offered courses
     *     AND from each student's current courses.
     *
     * The method must remove the course from any other courses that have it as a pre-requisite
     *
     * @param courseCode the course code
     * @return false if the course code does not match to any offered course. True after the course was removed
     */
    public boolean removeCourseFromUniversity(String courseCode){
        //TODO: Implement this method
        Course course = availableCourses.get(courseCode);
        if(course == null){
            return false;
        }

        availableCourses.remove(courseCode);

        for (Student student : course.getEnrolledStudents()){
            student.getEnrolledCourses().remove(course);
            student.getPreviousCourses().remove(course);
        }

        for (String courseCodes : availableCourses.keySet()) {
            Course otherCourse = availableCourses.get(courseCodes);
            otherCourse.getPreRequisites().remove(course);
        }

        return true;

    }


    public String getUniversityMotto() {
        return universityMotto;
    }

    public String getUniversityName() {
        return universityName;
    }

    /**
     * Add a new student using name and ID
     * @param name the student's name
     * @param studentID the student's ID between 0 and 999999
     * @return true if the student was added, false if the student was already on the university
     */
    public boolean addStudent(String name, int studentID){
        return addStudent(new Student(name,studentID));
    }

    public boolean addCourse(String name, String courseID){
        return addCourse(new Course(name,courseID));
    }



    @Override
    public String toString() {
        return String.format("%s (%s)\nNumber of Students: %d\nNumber of Courses %d",
                universityName,universityMotto,studentBody.size(),availableCourses.size());
    }

}
