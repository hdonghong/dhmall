package top.hdonghong.dhmall.coupon.dao;

import top.hdonghong.dhmall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-19 13:44:42
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
