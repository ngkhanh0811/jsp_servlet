import com.example.reflection.entity.Product;
import com.example.reflection.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepositoryImpl productRepo = new ProductRepositoryImpl();

        List<Product> productList = productRepo.findall();
        System.err.println(productList);
    }
}