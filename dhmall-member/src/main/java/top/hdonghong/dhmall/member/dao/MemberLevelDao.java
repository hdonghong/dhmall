package top.hdonghong.dhmall.member.dao;

import top.hdonghong.dhmall.member.entity.MemberLevelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员等级
 * 
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 10:38:43
 */
@Mapper
public interface MemberLevelDao extends BaseMapper<MemberLevelEntity> {
	
}
