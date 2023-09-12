package org.example.dao;

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
    @Transactional
    public void delete(int id)
    {
        Student student=(Student)this.hibernateTemplate.get(Student.class,id);
         this.hibernateTemplate.delete(id);
    }

    //update data
    @Transactional
    public  void update(Student updateStudent)
    {
        Student existingStudent=(Student) this.hibernateTemplate.get(Student.class,updateStudent.getId());


        if (existingStudent!=null)
        {
            existingStudent.setId(updateStudent.getId());
            existingStudent.setName(updateStudent.getName());
            existingStudent.setCity(updateStudent.getCity());
        }
        this.hibernateTemplate.update(existingStudent);
    }

    public HibernateTemplate getHibernateTemplate() {

        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
