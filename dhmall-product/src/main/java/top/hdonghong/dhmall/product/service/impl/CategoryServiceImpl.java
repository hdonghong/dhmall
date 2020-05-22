package top.hdonghong.dhmall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.common.utils.Query;

import top.hdonghong.dhmall.product.dao.CategoryDao;
import top.hdonghong.dhmall.product.entity.CategoryEntity;
import top.hdonghong.dhmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryList = baseMapper.selectList(null);
        return listWithTree(0L, categoryList);
    }

    /**
     * 获取catId的子分类
     * @param catId
     * @param categoryList
     * @return
     */
    private List<CategoryEntity> listWithTree(Long catId, List<CategoryEntity> categoryList) {
        return categoryList.stream()
                // 获取子分类
                .filter(category -> Objects.equals(catId, category.getParentCid()))
                // 子分类获取子子分类
                .peek(category ->
                    category.setChildren(listWithTree(category.getCatId(), categoryList))
                )
                // 分类排序
                .sorted(Comparator.comparingInt(c -> (c.getSort() == null ? 0 : c.getSort())))
                .collect(Collectors.toList());
    }

}