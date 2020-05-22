package top.hdonghong.dhmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.dhmall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 13:19:13
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

