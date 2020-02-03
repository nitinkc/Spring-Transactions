package com.learn.transaction.myAdmissionServiceJDBC.dao;

import com.learn.transaction.myAdmissionService.entity.Department;

import java.util.Optional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:26 PM
 */
public interface DepartmentDao {
    void save(Department department);

    Optional<Department> findById(Long studentEnrolled);

    void delete(Department department);
}
