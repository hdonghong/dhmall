package top.hdonghong.dhmall.coupon.dao;

import top.hdonghong.dhmall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-19 13:44:42
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
