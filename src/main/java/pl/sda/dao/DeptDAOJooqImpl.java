package pl.sda.dao;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import pl.sda.domain.Department;
import pl.sda.jooq.Tables;
import pl.sda.jooq.tables.records.DeptRecord;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pzawa on 02.02.2017.
 */
public class DeptDAOJooqImpl implements DeptDAO{

    private final JdbcConnectionManager jdbcConnectionManager;

    public DeptDAOJooqImpl(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }

    @Override
    public Department findById(int id) throws SQLException {
        try(Connection conn = jdbcConnectionManager.getConnection()) {
            DSLContext context = DSL.using(conn, SQLDialect.POSTGRES_9_5);
            List<DeptRecord> result = context.select().from(Tables.DEPT).where(Tables.DEPT.DEPTNO.eq(id))
                    .fetchInto(DeptRecord.class);
            if(result.size() > 0){
                return fromDeptRecord(result.get(0));
            }
        }
        return null;
    }

    private Department fromDeptRecord(DeptRecord deptRecord){
        return new Department(deptRecord.getDeptno(), deptRecord.getDname(), deptRecord.getLocation());
    }

    @Override
    public void create(Department department) throws SQLException {
        try (Connection conn = jdbcConnectionManager.getConnection()){
            DSLContext context = DSL.using(conn, SQLDialect.POSTGRES_9_5);
            int numberOfAffectedRows = context.insertInto(Tables.DEPT, Tables.DEPT.DEPTNO, Tables.DEPT.DNAME, Tables.DEPT.LOCATION)
                    .values(department.getDeptno(), department.getDname(), department.getLocation()).execute();

            System.out.println("DeptDAO.create() number of affected rows: " + numberOfAffectedRows);
        }
    }

    @Override
    public void update(Department department) throws SQLException {
        try (Connection conn = jdbcConnectionManager.getConnection()){
            DSLContext context = DSL.using(conn, SQLDialect.POSTGRES_9_5);
            int numberOfAffectedRows = context.update(Tables.DEPT).set(Tables.DEPT.DNAME, department.getDname()).set(Tables.DEPT.LOCATION, department.getLocation())
                    .where(Tables.DEPT.DEPTNO.eq(department.getDeptno())).execute();

            System.out.println("DeptDAO.update() number of affected rows: " + numberOfAffectedRows);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection conn = jdbcConnectionManager.getConnection()){
            DSLContext context = DSL.using(conn, SQLDialect.POSTGRES_9_5);
            int numberOfAffectedRows = context.delete(Tables.DEPT)
                    .where(Tables.DEPT.DEPTNO.eq(id)).execute();

            System.out.println("DeptDAO.delete() number of affected rows: " + numberOfAffectedRows);
        }
    }
}
