package org.example.dao;

import org.example.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

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
          Student student1=(Student)this.hibernateTemplate.get("Student.java",id);
          return student1;
      }



    public HibernateTemplate getHibernateTemplate() {

        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
