package com.example.employeemanagementsystem.repo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.projection.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentID);

    // Custom Query Methods
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    List<EmployeeProjection> findByEmail(@Param("email") String email);

    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<EmployeeProjection> findByName(@Param("name") String name);

    // Projection using Interface
    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    EmployeeProjection findEmpById(@Param("id") Long id);

    // Custom method with a different name to avoid conflict with the default findAll
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email, e.department.name) FROM Employee e")
    Page<EmployeeDTO> findAllEmployees(Pageable pageable);
}
