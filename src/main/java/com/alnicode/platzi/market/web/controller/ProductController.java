package com.alnicode.platzi.market.web.controller;

import com.alnicode.platzi.market.domain.Product;
import com.alnicode.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(this.productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    @ApiOperation("Search a products list with an Category ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    public ResponseEntity<List<Product>> getByCategory(@ApiParam(value = "The category id", required = true, example = "3")
                                                       @PathVariable("id") int categoryId) {
        return ResponseEntity.of(this.productService.getByCategory(categoryId));
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with and ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Product found"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The product id", required = true, example = "7")
                                              @PathVariable("id") int productId) {
        return ResponseEntity.of(this.productService.getProduct(productId));
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(this.productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int productId) {
        return new ResponseEntity<>(this.productService.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
