/*
 * This file is generated by jOOQ.
*/
package pl.sda.jooq;


import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Field;

import pl.sda.jooq.routines.CalculateSalaryByDept;


/**
 * Convenience access to all stored procedures and functions in sda
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>sda.calculate_salary_by_dept</code>
     */
    public static BigDecimal calculateSalaryByDept(Configuration configuration, Integer vDeptno) {
        CalculateSalaryByDept f = new CalculateSalaryByDept();
        f.setVDeptno(vDeptno);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>sda.calculate_salary_by_dept</code> as a field.
     */
    public static Field<BigDecimal> calculateSalaryByDept(Integer vDeptno) {
        CalculateSalaryByDept f = new CalculateSalaryByDept();
        f.setVDeptno(vDeptno);

        return f.asField();
    }

    /**
     * Get <code>sda.calculate_salary_by_dept</code> as a field.
     */
    public static Field<BigDecimal> calculateSalaryByDept(Field<Integer> vDeptno) {
        CalculateSalaryByDept f = new CalculateSalaryByDept();
        f.setVDeptno(vDeptno);

        return f.asField();
    }
}
