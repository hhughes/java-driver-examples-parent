package com.datastax.examples;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventoryOperations extends CassandraRepository<Widget, UUID> {
}
