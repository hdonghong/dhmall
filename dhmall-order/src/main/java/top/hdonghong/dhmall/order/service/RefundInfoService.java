package top.hdonghong.dhmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.dhmall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-18 13:16:30
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

