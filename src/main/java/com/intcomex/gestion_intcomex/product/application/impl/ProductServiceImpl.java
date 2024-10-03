package com.intcomex.gestion_intcomex.product.application.impl;

import com.intcomex.gestion_intcomex.category.domain.model.Category;
import com.intcomex.gestion_intcomex.category.domain.port.CategoryRepository;
import com.intcomex.gestion_intcomex.exception.ResourceNotFoundException;
import com.intcomex.gestion_intcomex.product.application.DTOs.ProductDTO;
import com.intcomex.gestion_intcomex.product.application.mappers.ProductMapper;
import com.intcomex.gestion_intcomex.product.application.service.ProductService;
import com.intcomex.gestion_intcomex.product.domain.model.Product;
import com.intcomex.gestion_intcomex.product.domain.port.ProductRepository;
import com.intcomex.gestion_intcomex.supplier.domain.model.Supplier;
import com.intcomex.gestion_intcomex.supplier.domain.port.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              SupplierRepository supplierRepository,
                              CategoryRepository categoryRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

        Product product = new Product();
        fillProduct(product, productDTO);
        product = productRepository.save(product);
        return productMapper.convertToDTO(product);
    }

    @Override
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        Page<Product> productsPage = productRepository.findAll(pageable);
        return productsPage.map(productMapper::convertToDTO);
    }

    @Override
    public Optional<ProductDTO> getProduct(Long id) {

        return productRepository.findById(id).map(productMapper::convertToDTO);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow();
        fillProduct(product, productDTO);
        product = productRepository.save(product);
        return productMapper.convertToDTO(product);

    }

    private void fillProduct(Product product, ProductDTO productDTO) {
        product.setProductName(productDTO.getProductName());
        product.setQuantityPerUnit(productDTO.getQuantityPerUnit());
        product.setUnitPrice(productDTO.getUnitPrice());
        product.setStock(productDTO.getStock());
        product.setUnitsOnOrder(productDTO.getUnitsOnOrder());
        product.setReorderLevel(productDTO.getReorderLevel());
        product.setDiscontinued(productDTO.getDiscontinued());


        Optional<Supplier> supplier = supplierRepository.findById(productDTO.getSupplierId());
        if (supplier.isPresent()) {
            product.setSupplier(supplier.get());
        }
        Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());
        if (category.isPresent()) {
            product.setCategory(category.get());
        }


    }
}
