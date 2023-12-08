import com.cardshop.model.Product;
import com.cardshop.services.impl.ProductServiceImpl;
import com.cardshop.services.ProductServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class ProductServicesTest {

    ProductServices productServices;

    @BeforeEach
    void init(){
        productServices = new ProductServiceImpl();
    }

    @Test
    void repeatedTest(){
        productServices.addProductToHandl(Product.builder().name("pen").price(9).quantity(1).total(9).build());
        productServices.addProductToHandl(Product.builder().name("pen").price(4).quantity(1).total(4).build());
        productServices.addProductToHandl(Product.builder().name("Book").price(1).quantity(1).total(1).build());
        Assertions.assertEquals(2, productServices.sizeProduct());
    }


    @Test
    void BillsTotalTest(){
        productServices.addProductToHandl(Product.builder().name("pen").price(9).quantity(1).total(9).build());
        productServices.addProductToHandl(Product.builder().name("Book").price(1).quantity(1).total(1).build());
        Assertions.assertEquals(10,productServices.totalProduct());
    }
}
