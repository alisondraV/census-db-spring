package Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "HR")
public class EmployeesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id", nullable = false)
    private int employeeId;
    @Basic
    @Column(name = "first_name", nullable = true, length = 20)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 20)
    private String phoneNumber;
    @Basic
    @Column(name = "hire_date", nullable = false)
    private Date hireDate;
    @Basic
    @Column(name = "job_id", nullable = false)
    private int jobId;
    @Basic
    @Column(name = "salary", nullable = false, precision = 2)
    private BigDecimal salary;
    @Basic
    @Column(name = "Commission_Pct", nullable = true)
    private Integer commissionPct;
    @Basic
    @Column(name = "manager_id", nullable = true)
    private Integer managerId;
    @Basic
    @Column(name = "department_id", nullable = true)
    private Integer departmentId;
    @OneToMany(mappedBy = "employeesByEmployeeId")
    private Collection<DependentsEntity> dependentsByEmployeeId;
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false, insertable = false, updatable = false)
    private JobsEntity jobsByJobId;
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private EmployeesEntity employeesByManagerId;
    @OneToMany(mappedBy = "employeesByManagerId")
    private Collection<EmployeesEntity> employeesByEmployeeId;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", insertable = false, updatable = false)
    private DepartmentsEntity departmentsByDepartmentId;

    @Override
    public String toString() {
        return "EmployeesEntity {" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Integer commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return employeeId == that.employeeId && jobId == that.jobId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(hireDate, that.hireDate) && Objects.equals(salary, that.salary) && Objects.equals(commissionPct, that.commissionPct) && Objects.equals(managerId, that.managerId) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commissionPct, managerId, departmentId);
    }

    public Collection<DependentsEntity> getDependentsByEmployeeId() {
        return dependentsByEmployeeId;
    }

    public void setDependentsByEmployeeId(Collection<DependentsEntity> dependentsByEmployeeId) {
        this.dependentsByEmployeeId = dependentsByEmployeeId;
    }

    public JobsEntity getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(JobsEntity jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    public EmployeesEntity getEmployeesByManagerId() {
        return employeesByManagerId;
    }

    public void setEmployeesByManagerId(EmployeesEntity employeesByManagerId) {
        this.employeesByManagerId = employeesByManagerId;
    }

    public Collection<EmployeesEntity> getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    public void setEmployeesByEmployeeId(Collection<EmployeesEntity> employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }

    public DepartmentsEntity getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(DepartmentsEntity departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }
}
