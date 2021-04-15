import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class HelloHibernate {

    public static void main(String[] args) {

        // EntityManager initialization
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT dep FROM Department dep");
        for (Object obj : query.getResultList()) {
            Department dep = (Department) obj;
            System.out.println(dep);
        }

//        // create a key for event build=1, room=1, id=101
//        EventPK key = new EventPK(1, 1, 101);
//        Event event = em.find(Event.class, key);
//        System.out.println(event);

//        // create a key for build=2 and room=1
//        LocationPK key = new LocationPK();
//        key.setBuild(2);
//        key.setRoom(1);
//        Location location = em.find(Location.class, key);
//        System.out.println(location);

//        Employee perry = em.find(Employee.class, 1);
//        System.out.println(perry);
//
//        Employee mary = em.find(Employee.class, 4);
//        System.out.println(mary);

//        Department it = em.find(Department.class, 2);
//        System.out.println(it);

//        Department sales = new Department();
//        sales.setDescrip("sales");
//        List<Employee> employeeList = new LinkedList<>();
//        employeeList.add(em.find(Employee.class, 1));
//        employeeList.add(em.find(Employee.class, 2));
//        sales.setEmployees(employeeList);
//        em.getTransaction().begin();
//        em.persist(sales);
//        em.getTransaction().commit();

//        Employee emp = new Employee();
//        emp.setId(30);
//        em.getTransaction().begin();
//        em.persist(emp);
//        em.getTransaction().commit();


//        Employee emp = em.find(Employee.class, 20);
//        if (emp == null)
//            System.out.println("Employee not found");
//        else
//            System.out.println("Employee " + emp.getName() + " found!");

//
//
//        em.getTransaction().begin();
//        thyago.setSal(thyago.getSal() + 500);
//        em.getTransaction().commit();

        // updating an existing entity

        // EntityManager commit/close
        em.close();
    }
}