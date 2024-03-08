package com.learn.transaction.myAdmissionServiceJDBC.dao;

import com.learn.transaction.myAdmissionService.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by nitin on Sunday, February/02/2020 at 8:42 PM
 */
@Repository
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO STUDENT " + "(ENROLLMENT_NUM, FIRST_NAME, LAST_NAME, GENDER) VALUES (?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[] {
                student.getEnrollmentNum(), student.getFirstName(), student.getLastName(), student.getGender() }
        );
    }

    @Override
    public void delete(Student student) {
        String sql = "DELETE FROM STUDENT WHERE ENROLLMENT_NUM = ?";
        getJdbcTemplate().update(sql, new Object[] { student.getEnrollmentNum()});
    }
}
