package top.hdonghong.dhmall.product.dao;

import top.hdonghong.dhmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-17 20:42:15
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
