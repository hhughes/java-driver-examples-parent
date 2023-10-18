package com.datastax.examples;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@ToString
@Builder
@Data
@Table("inventory")
public class Widget {

    @Column
    @PrimaryKey
    private UUID id;

    @Column
    private Type type;

    @Column
    private String notes;

    public enum Type { A, B }
}
