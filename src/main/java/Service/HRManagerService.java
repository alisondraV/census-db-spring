package Service;

import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hrManagerService")
public class HRManagerService {
    @Autowired
    private EmployeeRepository repository;
}
