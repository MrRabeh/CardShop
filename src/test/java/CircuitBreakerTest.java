import com.cardshop.model.Product;
import com.cardshop.services.ProductServices;
import com.cardshop.services.impl.ProductServiceImpl;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

//corriger le code via sonarqube cloud
class CircuitBreakerTest {

    ProductServices productServices;

    @BeforeEach
    void init(){
        productServices = new ProductServiceImpl();
    }

    @Test
    void circuitBreaker_test(){
        final int[] i = {0};
        IntStream.range(1,31).forEach($->{
            productServices.servicetimeout(Product.builder().name("pen"+ i[0]).price(9).quantity(1).total(9).build());
                i[0]++;
        });
        Assertions.assertEquals(30,productServices.sizeProduct());
    }
}
