package top.hdonghong.dhmall.order.dao;

import top.hdonghong.dhmall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 13:16:31
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
