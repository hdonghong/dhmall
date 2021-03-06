package top.hdonghong.dhmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.dhmall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-19 13:44:42
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

