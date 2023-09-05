package com.joostit.productdb.repos;

import com.joostit.productdb.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

     Product findByEan(String ean);

}
