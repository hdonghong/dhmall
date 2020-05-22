package top.hdonghong.dhmall.order.dao;

import top.hdonghong.dhmall.order.entity.OrderReturnReasonEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退货原因
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 13:16:31
 */
@Mapper
public interface OrderReturnReasonDao extends BaseMapper<OrderReturnReasonEntity> {
	
}
