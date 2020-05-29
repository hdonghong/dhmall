package top.hdonghong.dhmall.product.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.hdonghong.dhmall.product.service.CategoryService;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void findCatelogPath() {
        List<Long> catelogPath = categoryService.findCatelogPath(225L);
        log.info("catelogPath = {}", catelogPath);
    }
}