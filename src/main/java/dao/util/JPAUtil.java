package dao.util;

import javax.persistence.*;
public class JPAUtil {

	public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("syspetjaPU");
	
}
