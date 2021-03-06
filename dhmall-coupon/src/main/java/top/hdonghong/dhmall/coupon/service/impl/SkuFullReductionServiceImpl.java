package top.hdonghong.dhmall.coupon.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.hdonghong.common.to.MemberPrice;
import top.hdonghong.common.to.SkuReductionTO;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.common.utils.Query;

import top.hdonghong.dhmall.coupon.dao.SkuFullReductionDao;
import top.hdonghong.dhmall.coupon.entity.MemberPriceEntity;
import top.hdonghong.dhmall.coupon.entity.SkuFullReductionEntity;
import top.hdonghong.dhmall.coupon.entity.SkuLadderEntity;
import top.hdonghong.dhmall.coupon.service.MemberPriceService;
import top.hdonghong.dhmall.coupon.service.SkuFullReductionService;
import top.hdonghong.dhmall.coupon.service.SkuLadderService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    private SkuLadderService skuLadderService;

    @Autowired
    private MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTO skuReductionTO) {
        //1、// //5.4）、sku的优惠、满减等信息；gulimall_sms->sms_sku_ladder\sms_sku_full_reduction\sms_member_price
        //sms_sku_ladder
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(skuReductionTO.getSkuId());
        skuLadderEntity.setFullCount(skuReductionTO.getFullCount());
        skuLadderEntity.setDiscount(skuReductionTO.getDiscount());
        skuLadderEntity.setAddOther(skuReductionTO.getCountStatus());
        if(skuReductionTO.getFullCount() > 0){
            skuLadderService.save(skuLadderEntity);
        }




        //2、sms_sku_full_reduction
        SkuFullReductionEntity reductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionTO,reductionEntity);
        if(reductionEntity.getFullPrice().compareTo(new BigDecimal("0"))==1){
            this.save(reductionEntity);
        }


        //3、sms_member_price
        List<MemberPrice> memberPrice = skuReductionTO.getMemberPrice();

        List<MemberPriceEntity> collect = memberPrice.stream()
                .map(item -> {
                    MemberPriceEntity priceEntity = new MemberPriceEntity();
                    priceEntity.setSkuId(skuReductionTO.getSkuId());
                    priceEntity.setMemberLevelId(item.getId());
                    priceEntity.setMemberLevelName(item.getName());
                    priceEntity.setMemberPrice(item.getPrice());
                    priceEntity.setAddOther(1);
                    return priceEntity;
                })
                .filter(item-> item.getMemberPrice().compareTo(new BigDecimal("0")) > 0)
                .collect(Collectors.toList());

        memberPriceService.saveBatch(collect);
    }

}