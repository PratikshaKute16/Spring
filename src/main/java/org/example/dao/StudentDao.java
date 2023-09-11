package org.example.dao;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.example.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao
{
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student) {
        //save student
        Integer integer = (Integer) this.hibernateTemplate.save(student);
        return integer;
    }
      //getting single data
      public Student getStudent(int id)
      {
          Student student1=(Student)this.hibernateTemplate.get(Student.class,id);
          return student1;
      }

//get all data
    public List<Student> getAllData(int StudentId)
    {
        List<Student> list= (List<Student>) this.hibernateTemplate.loadAll(Student.class);
        return list;
    }

    //delete data
    public void delete(int id)
    {
        Student student=this.hibernateTemplate.get(Student.class,id);
                this.hibernateTemplate.delete(id);
    }

    //update data
    public  void update(int id)
    {
        this.hibernateTemplate.update(id);
    }

    public HibernateTemplate getHibernateTemplate() {

        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
