package org.bbuallbest;

import org.bbuallbest.entity.Student;

import javax.ejb.EJBLocalObject;

public interface TestLocal extends EJBLocalObject{
    String sayHello();
    Student getStudent(Integer id);
}
