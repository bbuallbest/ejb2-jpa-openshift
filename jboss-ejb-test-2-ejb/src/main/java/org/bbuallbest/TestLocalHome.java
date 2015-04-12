package org.bbuallbest;

import javax.ejb.EJBLocalHome;

public interface TestLocalHome extends EJBLocalHome {
    TestLocal create();
}
