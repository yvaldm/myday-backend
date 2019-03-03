/*
 * This file is generated by jOOQ.
 */
package com.yvaldm.myday.mydaybackend.dao.generated.tables;


import com.yvaldm.myday.mydaybackend.dao.generated.Indexes;
import com.yvaldm.myday.mydaybackend.dao.generated.Keys;
import com.yvaldm.myday.mydaybackend.dao.generated.Public;
import com.yvaldm.myday.mydaybackend.dao.generated.tables.records.PerformedActionRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class PerformedAction extends TableImpl<PerformedActionRecord> {

    private static final long serialVersionUID = -574331023;

    /**
     * The reference instance of <code>public.performed_action</code>
     */
    public static final PerformedAction PERFORMED_ACTION = new PerformedAction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PerformedActionRecord> getRecordType() {
        return PerformedActionRecord.class;
    }

    /**
     * The column <code>public.performed_action.id</code>.
     */
    public final TableField<PerformedActionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('performed_action_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.performed_action.action_id</code>.
     */
    public final TableField<PerformedActionRecord, Integer> ACTION_ID = createField("action_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.performed_action.user_id</code>.
     */
    public final TableField<PerformedActionRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.performed_action.cts</code>.
     */
    public final TableField<PerformedActionRecord, Timestamp> CTS = createField("cts", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.performed_action</code> table reference
     */
    public PerformedAction() {
        this(DSL.name("performed_action"), null);
    }

    /**
     * Create an aliased <code>public.performed_action</code> table reference
     */
    public PerformedAction(String alias) {
        this(DSL.name(alias), PERFORMED_ACTION);
    }

    /**
     * Create an aliased <code>public.performed_action</code> table reference
     */
    public PerformedAction(Name alias) {
        this(alias, PERFORMED_ACTION);
    }

    private PerformedAction(Name alias, Table<PerformedActionRecord> aliased) {
        this(alias, aliased, null);
    }

    private PerformedAction(Name alias, Table<PerformedActionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PERFORMED_ACTION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PerformedActionRecord, Long> getIdentity() {
        return Keys.IDENTITY_PERFORMED_ACTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PerformedActionRecord> getPrimaryKey() {
        return Keys.PERFORMED_ACTION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PerformedActionRecord>> getKeys() {
        return Arrays.<UniqueKey<PerformedActionRecord>>asList(Keys.PERFORMED_ACTION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PerformedActionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PerformedActionRecord, ?>>asList(Keys.PERFORMED_ACTION__PERFORMED_ACTION_ACTION_ID_FKEY);
    }

    public Action action() {
        return new Action(this, Keys.PERFORMED_ACTION__PERFORMED_ACTION_ACTION_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformedAction as(String alias) {
        return new PerformedAction(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerformedAction as(Name alias) {
        return new PerformedAction(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PerformedAction rename(String name) {
        return new PerformedAction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PerformedAction rename(Name name) {
        return new PerformedAction(name, null);
    }
}