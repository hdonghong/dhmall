package top.hdonghong.dhmall.ware.dao;

import top.hdonghong.dhmall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 13:19:13
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
