package top.hdonghong.dhmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.dhmall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author hdonghong
 * @email im.hdonghong@gmail.com
 * @date 2020-05-17 20:42:15
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取树形结构的商品分类
     * @return
     */
    List<CategoryEntity> listWithTree();
}

