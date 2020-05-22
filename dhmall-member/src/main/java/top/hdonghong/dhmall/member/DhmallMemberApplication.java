package top.hdonghong.dhmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "top.hdonghong.dhmall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class DhmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhmallMemberApplication.class, args);
    }

}
