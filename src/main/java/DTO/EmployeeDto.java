package DTO;

public class EmployeeDto {
    String lastName;
    String job;
    int departmentNumber;
    String departmentName;

    public EmployeeDto(String lastName, String job, int departmentNumber, String departmentName) {
        this.lastName = lastName;
        this.job = job;
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "lastName='" + lastName + '\'' +
                ", job='" + job + '\'' +
                ", departmentNumber=" + departmentNumber +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
