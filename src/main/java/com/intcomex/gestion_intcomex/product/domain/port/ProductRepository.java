package com.intcomex.gestion_intcomex.product.domain.port;

import com.intcomex.gestion_intcomex.product.domain.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> {
}
