package top.hdonghong.dhmall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DhmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhmallCouponApplication.class, args);
    }

}
