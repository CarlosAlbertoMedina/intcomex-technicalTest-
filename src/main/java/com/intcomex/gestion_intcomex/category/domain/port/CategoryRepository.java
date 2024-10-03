package com.intcomex.gestion_intcomex.category.domain.port;

import com.intcomex.gestion_intcomex.category.domain.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>, CrudRepository<Category, Long> {
}
