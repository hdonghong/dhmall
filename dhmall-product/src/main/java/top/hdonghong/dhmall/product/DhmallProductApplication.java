package top.hdonghong.dhmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "top.hdonghong.dhmall.product.feign")
@EnableDiscoveryClient
@MapperScan("top.hdonghong.dhmall.product.dao")
@SpringBootApplication
public class DhmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhmallProductApplication.class, args);
    }

}
