package top.hdonghong.dhmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.dhmall.product.entity.AttrEntity;
import top.hdonghong.dhmall.product.vo.AttrGroupRelationVO;
import top.hdonghong.dhmall.product.vo.AttrRespVO;
import top.hdonghong.dhmall.product.vo.AttrVO;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-17 20:42:15
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 新增属性信息
     * @param attr
     */
    void saveAttr(AttrVO attr);

    /**
     * 分页查询基本属性/销售属性 列表
     * @param params
     * @param catelogId
     * @param type
     * @return
     */
    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    /**
     * 获取属性信息
     * @param attrId
     * @return
     */
    AttrRespVO getAttrInfo(Long attrId);

    /**
     * 修改属性信息
     * @param attr
     */
    void updateAttr(AttrVO attr);

    /**
     * 根据属性组id获取属性列表
     * @param attrgroupId
     * @return
     */
    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVO[] vos);

    /**
     * 获取当前分组没有关联的所有属性
     * @param params
     * @param attrgroupId
     * @return
     */
    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);
}

