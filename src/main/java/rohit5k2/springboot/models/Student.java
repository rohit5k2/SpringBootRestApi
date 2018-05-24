package rohit5k2.springboot.models;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(@NotNull LocalDate dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName == null ? "" : middleName;
    }

    public void setMiddleName(@Nullable String middleName) {
        this.middleName = middleName;
    }

    public String getFullName(){
        return this.firstName + " " + (!StringUtils.hasLength(this.middleName) ? "" : this.middleName + " ") + this.lastName;
    }

    public int getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotNull
    private LocalDate dob;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Nullable
    private String middleName;
}
