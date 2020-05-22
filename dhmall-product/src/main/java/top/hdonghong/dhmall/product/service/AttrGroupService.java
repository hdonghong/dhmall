package top.hdonghong.dhmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.dhmall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-17 20:42:15
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

