/*
 * This file is generated by jOOQ.
 */
package com.yvaldm.myday.mydaybackend.dao.generated;


import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;

import javax.annotation.Generated;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Sequences {

    /**
     * The sequence <code>public.action_id_seq</code>
     */
    public static final Sequence<Long> ACTION_ID_SEQ = new SequenceImpl<Long>("action_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.performed_action_id_seq</code>
     */
    public static final Sequence<Long> PERFORMED_ACTION_ID_SEQ = new SequenceImpl<Long>("performed_action_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}