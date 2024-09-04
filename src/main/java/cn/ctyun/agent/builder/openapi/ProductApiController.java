package cn.ctyun.agent.builder.openapi;

import cn.ctyun.agent.builder.openapi.product.api.ProductApi;
import cn.ctyun.agent.builder.openapi.product.model.ProductVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductApiController implements ProductApi {

    @Override
    public ResponseEntity<List<ProductVO>> getAllProducts() {
        ProductVO productVO = mockProductVO();
        return ResponseEntity.of(Optional.of(List.of(productVO)));
    }

    @Override
    public ResponseEntity<ProductVO> addProduct(ProductVO body) {
        // 创建一个包含状态码、响应头和主体的 ResponseEntity 对象
        return new ResponseEntity<>(mockProductVO(), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<ProductVO> getProductById(Long id) {
        ProductVO productVO = mockProductVO();
        return ResponseEntity.of(Optional.of(mockProductVO()));
    }

    @Override
    public ResponseEntity<ProductVO> updateProduct(Long id, ProductVO body) {
        ProductVO productVO = mockProductVO();
        // 创建一个包含状态码、响应头和主体的 ResponseEntity 对象
        return new ResponseEntity<>(productVO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) {
        return ResponseEntity.noContent().build();
    }

//    @Override
//    public ResponseEntity<ProductPageVO> getPage(Pageable pageable) {
//        return null;
//    }


    private static ProductVO mockProductVO() {
        ProductVO productVO = new ProductVO();
        productVO.setId(1000001L);
        productVO.setName("test");
        productVO.setPrice(100.0);
        productVO.setShow(true);
        productVO.setType(1);
        productVO.setCreateTime(LocalDateTime.now());
        productVO.setPassword("test");
        return productVO;
    }
}
