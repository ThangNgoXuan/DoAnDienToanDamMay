package com.qlsv.Application.Repository;

import com.qlsv.Application.model.Student;
import com.qlsv.Application.until.HibernaterUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentRepositoryDAO implements StudentRepository {
    @Override
    public List<Student> getStudents() {
        Transaction transaction = null;
        List<Student> students = null;
        try (Session session = HibernaterUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            students = session.createQuery("from Student ").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student getStudent(String MSSV) {
        Transaction transaction=null;
        Student student=null;
        try(Session session=HibernaterUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            student=session.get(Student.class,MSSV);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void Update(Student student) {
        Transaction transaction=null;
        try(Session session= HibernaterUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(student);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void Save(Student student) {
        Transaction transaction=null;
        try(Session session= HibernaterUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
