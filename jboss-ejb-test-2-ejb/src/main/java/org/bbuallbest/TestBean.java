package org.bbuallbest;

import org.bbuallbest.entity.Student;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.rmi.RemoteException;

public class TestBean implements SessionBean {

    @Override
    public void setSessionContext(SessionContext sessionContext) throws EJBException, RemoteException {

    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {

    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {

    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {

    }

    public String sayHello() {
        return "Helllllo =)";
    }

    public Student getStudent(Integer id) {
        Student student = null;
        try {
            Context initCtx = new InitialContext();
//            initCtx.lookup();
            EntityManagerFactory emf = (EntityManagerFactory) initCtx.lookup("java:jboss/TestUnitEntityManagerFactory");
            EntityManager em = emf.createEntityManager();
            student = em.find(Student.class, id);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return student;
    }
}
