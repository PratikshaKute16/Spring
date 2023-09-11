package org.example.orm;

import org.example.dao.StudentDao;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        Student student=new Student(101,"pari","Pune");
        int r=studentDao.insert(student);
        System.out.println("done"+r);
    }
}
