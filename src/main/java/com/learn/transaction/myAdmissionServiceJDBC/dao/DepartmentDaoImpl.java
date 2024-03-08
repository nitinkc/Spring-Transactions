package com.learn.transaction.myAdmissionServiceJDBC.dao;

import com.learn.transaction.myAdmissionService.entity.Department;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

/**
 * Created by nitin on Sunday, February/02/2020 at 8:38 PM
 */

@Repository
public class DepartmentDaoImpl extends JdbcDaoSupport implements DepartmentDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void save(Department department) {
        String sql = "INSERT INTO DEPARTMENT " + "(STUDENT_ENROLLED, DEPT_NAME) VALUES (?, ?)";
        getJdbcTemplate().update(sql, new Object[] {
                        department.getStudentEnrolled(), department.getDeptName().name() }
                );
    }

    @Override
    public Optional<Department> findById(Long studentEnrolled) {

        Department dept = null;
        String query = "select * from DEPARTMENT where STUDENT_ENROLLED=?";
        Object[] inputs = new Object[] {studentEnrolled};
        dept = (Department) getJdbcTemplate().queryForObject(query, inputs,
                new BeanPropertyRowMapper(Department.class));

        Optional<Department> optional = null;
        if (dept != null) {
            optional = Optional.of(dept);
        }
        return optional;
    }

    @Override
    public void delete(Department department) {
        String sql = "DELETE FROM DEPARTMENT WHERE STUDENT_ENROLLED = ?";
        getJdbcTemplate().update(sql, new Object[] { department.getStudentEnrolled() });

    }
}
