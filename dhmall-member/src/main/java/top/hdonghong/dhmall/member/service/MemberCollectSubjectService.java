package top.hdonghong.dhmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.dhmall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 10:38:43
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

