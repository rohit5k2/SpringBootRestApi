package rohit5k2.springboot.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import rohit5k2.springboot.Exceptions.BaseException;
import rohit5k2.springboot.Exceptions.DBAccessException;
import rohit5k2.springboot.Exceptions.ParameterException;
import rohit5k2.springboot.dbaccess.repo.StudentRepo;
import rohit5k2.springboot.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
@Api(value = "Students Database", description = "All the methods related to Students")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    /**
     * Gets every student in DB. No pagination and sorting support as of now.
     * @return {@link java.util.ArrayList<Student>}
     * @throws BaseException
     */
    @ApiOperation(value = "View a list of all the students", response = Student.class)
    @GetMapping(value = "")
    public ResponseEntity<?> getAll() throws BaseException{
        if(studentRepo == null)
            throw new DBAccessException(null);
        return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
    }

    /**
     * Gets every student in DB. No pagination and sorting support as of now.
     * @return {@link java.util.ArrayList<Student>}
     * @throws BaseException
     */
    @ApiOperation(value = "Get the student represented by the id", response = Student.class)
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) throws BaseException{
        if(studentRepo == null)
            throw new DBAccessException(null);
        return new ResponseEntity<>(studentRepo.findById(id), HttpStatus.OK);
    }

    /**
     * Gets all student with the given first name. If no student is found then blank List.
     * @param firstName First name on which we need to query the DB.
     * @return {@link java.util.ArrayList<Student>}
     * @throws BaseException
     */
    @ApiOperation(value = "View a list of all the students by the first name", response = Student.class)
    @GetMapping(value = "/firstname/{firstName}")
    public ResponseEntity<?> getByFirstName(@PathVariable String firstName) throws BaseException{
        if(studentRepo == null)
            throw new DBAccessException(null);

        if(StringUtils.hasLength(firstName))
            return new ResponseEntity<>(studentRepo.findByFirstName(firstName), HttpStatus.OK);
        else
            throw new ParameterException(null);
    }

    /**
     * Gets all student with the given last name. If no student is found then blank List.
     * @param lastName First name on which we need to query the DB.
     * @return {@link java.util.ArrayList<Student>}
     * @throws BaseException
     */
    @ApiOperation(value = "View a list of all the students by the last name", response = Student.class)
    @GetMapping(value = "/lastname/{lastName}")
    public ResponseEntity<?> getByLastName(@PathVariable String lastName) throws BaseException{
        if(studentRepo == null)
            throw new DBAccessException(null);

        if(StringUtils.hasLength(lastName))
            return new ResponseEntity<>(studentRepo.findByLastName(lastName), HttpStatus.OK);
        else
            throw new ParameterException(null);
    }

    /**
     * Adds a new student.id is not in this DB, updates otherwise
     * @param student Student data which needs to be added/updated
     * @return {@link Student}
     * @throws BaseException
     */
    @ApiOperation(value = "Add a student", responseContainer = "list", response = Student.class)
    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) throws BaseException{
        if(studentRepo != null && student != null)
            return new ResponseEntity<>(studentRepo.save(student), HttpStatus.OK);
        else{
            if(student == null)
                throw new ParameterException(null);
            if(studentRepo == null)
                throw new DBAccessException(null);
        }

        throw new BaseException();
    }

    /**
     * Deletes the student from DB with given id.
     * If no student found with the id returns a prettified message
     * @param id using which delete operation should be performed.
     * @return {@link HttpStatus}
     * @throws BaseException
     */
    @ApiOperation(value = "Delete a students")
    @DeleteMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<?> deleteStudent(@PathVariable long id) throws BaseException{
        if(studentRepo == null)
            throw new DBAccessException(null);

        if(id > 0) {
            try {
                studentRepo.deleteById(id);
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            catch (EmptyResultDataAccessException e){
                throw new ParameterException("No result found for this id");
            }
        }
        else
            throw new ParameterException(null);
    }

    private void test(){
        Objects.isNull(null);

        List<String> s =  new ArrayList<>();
        System.out.println(5);
    }
}
