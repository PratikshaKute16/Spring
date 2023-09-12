package org.example.orm;

import org.example.dao.StudentDao;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
        StudentDao studentDao=context.getBean("studentdao",StudentDao.class);

        //inserting student
//        Student student=new Student(104,"Neha","A.nagar");
//        int r=studentDao.insert(student);
//        System.out.println("done"+r);

        //updating student
     Student student1=studentDao.getStudent(101);
        System.out.println(student1);

        Student updatedStudent = new Student();
        updatedStudent.setId(101); // Set the ID of the student you want to update
        updatedStudent.setName("Adhey");
        updatedStudent.setCity("pune");

        studentDao.update(updatedStudent); // Update the student's data

//deleting student
        Student student2=studentDao.getStudent(102);
        System.out.println(student2);
        boolean s=studentDao.delete(student2);
        System.out.println(s);




    }
}
