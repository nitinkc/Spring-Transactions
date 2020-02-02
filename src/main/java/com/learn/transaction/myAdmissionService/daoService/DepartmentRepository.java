package com.learn.transaction.myAdmissionService.daoService;

import com.learn.transaction.myAdmissionService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:26 PM
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
