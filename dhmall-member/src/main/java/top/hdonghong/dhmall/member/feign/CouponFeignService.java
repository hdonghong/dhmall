package top.hdonghong.dhmall.member.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import top.hdonghong.common.utils.R;

/**
 * CouponFeignService class<br/>
 *
 * @author hdonghong
 * @since 2020/05/19
 */
@FeignClient("dhmall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}
