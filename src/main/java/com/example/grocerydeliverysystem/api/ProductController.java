package com.example.grocerydeliverysystem.api;

import com.example.grocerydeliverysystem.dto.ProductRequest;
import com.example.grocerydeliverysystem.dto.ProductResponse;
import com.example.grocerydeliverysystem.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/product")
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest){

        return productService.createProduct(productRequest);
    }

    @GetMapping("/findall")
    public List<ProductResponse> getProducts(){

        return productService.getProducts();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id){

        return productService.getProductById(id);
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String name){

        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestParam int id, @RequestBody ProductRequest productRequest){

        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
    }

}
