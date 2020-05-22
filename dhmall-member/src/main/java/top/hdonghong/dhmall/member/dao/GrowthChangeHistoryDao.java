package top.hdonghong.dhmall.member.dao;

import top.hdonghong.dhmall.member.entity.GrowthChangeHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成长值变化历史记录
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 10:38:43
 */
@Mapper
public interface GrowthChangeHistoryDao extends BaseMapper<GrowthChangeHistoryEntity> {
	
}
