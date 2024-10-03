package com.intcomex.gestion_intcomex.product.application.service;

import com.intcomex.gestion_intcomex.product.application.DTOs.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    Page<ProductDTO> getAllProducts(Pageable pageable) ;

    Optional<ProductDTO> getProduct(Long id);

    void deleteProduct(Long id);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);


}
