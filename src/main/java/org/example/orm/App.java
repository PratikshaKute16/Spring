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
        Student student=new Student(105,"Aish","Pune");
        int r=studentDao.insert(student);
        System.out.println("done"+r);

     Student student1=studentDao.getStudent(101);
        System.out.println(student1);

        Student student2=studentDao.delete(101);
        System.out.println(student2);

    }
}
