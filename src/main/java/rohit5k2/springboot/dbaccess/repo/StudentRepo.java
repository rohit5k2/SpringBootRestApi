package rohit5k2.springboot.dbaccess.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rohit5k2.springboot.models.Student;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
    /**
     * Lets find all the students with given first name
     * @param firstName
     * @return
     */
    @Query(value = "SELECT * FROM student WHERE first_name = ?1", nativeQuery = true)
    List<Student> findByFirstName(String firstName);

    /**
     * Lets find all the students with given first name
     * @param lastName
     * @return
     */
    @Query(value = "SELECT * FROM student WHERE last_name = ?1", nativeQuery = true)
    List<Student> findByLastName(String lastName);

    /**
     * Lets find all the students. No pagination and/or sorting as of now.
     * @return
     */
    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> findAll();
}
