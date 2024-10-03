package com.intcomex.gestion_intcomex.supplier.domain.port;

import com.intcomex.gestion_intcomex.supplier.domain.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long>, CrudRepository<Supplier, Long> {
}
