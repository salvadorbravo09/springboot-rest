package com.application.rest.controllers;

import com.application.rest.controllers.dtos.ProductDTO;
import com.application.rest.entities.Product;
import com.application.rest.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build()).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
        if (productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build();
        productService.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMaker());
            productService.save(product);
            return ResponseEntity.status(HttpStatus.OK).body("Registro Actualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            productService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Registro Eliminado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
