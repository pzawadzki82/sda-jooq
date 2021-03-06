/*
 * This file is generated by jOOQ.
*/
package pl.sda.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import pl.sda.jooq.Keys;
import pl.sda.jooq.Sda;
import pl.sda.jooq.tables.records.DeptRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Dept extends TableImpl<DeptRecord> {

    private static final long serialVersionUID = 2016117308;

    /**
     * The reference instance of <code>sda.dept</code>
     */
    public static final Dept DEPT = new Dept();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DeptRecord> getRecordType() {
        return DeptRecord.class;
    }

    /**
     * The column <code>sda.dept.deptno</code>.
     */
    public final TableField<DeptRecord, Integer> DEPTNO = createField("deptno", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sda.dept.dname</code>.
     */
    public final TableField<DeptRecord, String> DNAME = createField("dname", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>sda.dept.location</code>.
     */
    public final TableField<DeptRecord, String> LOCATION = createField("location", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>sda.dept</code> table reference
     */
    public Dept() {
        this("dept", null);
    }

    /**
     * Create an aliased <code>sda.dept</code> table reference
     */
    public Dept(String alias) {
        this(alias, DEPT);
    }

    private Dept(String alias, Table<DeptRecord> aliased) {
        this(alias, aliased, null);
    }

    private Dept(String alias, Table<DeptRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sda.SDA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DeptRecord> getPrimaryKey() {
        return Keys.DEPT_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DeptRecord>> getKeys() {
        return Arrays.<UniqueKey<DeptRecord>>asList(Keys.DEPT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dept as(String alias) {
        return new Dept(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dept rename(String name) {
        return new Dept(name, null);
    }
}
