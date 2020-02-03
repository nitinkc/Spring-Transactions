package com.learn.transaction.myAdmissionServiceJDBC.dao;

import com.learn.transaction.myAdmissionService.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:28 PM
 */
public interface StudentDao {
    void save(Student student);

    void delete(Student student);
}
