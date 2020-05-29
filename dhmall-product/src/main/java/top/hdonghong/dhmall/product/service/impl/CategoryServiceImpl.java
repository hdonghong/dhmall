package top.hdonghong.dhmall.product.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import top.hdonghong.common.utils.PageUtils;
import top.hdonghong.common.utils.Query;

import top.hdonghong.dhmall.product.dao.CategoryDao;
import top.hdonghong.dhmall.product.entity.CategoryEntity;
import top.hdonghong.dhmall.product.service.CategoryBrandRelationService;
import top.hdonghong.dhmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

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

    @Override
    public void removeMenuByIds(List<Long> catIdList) {
        baseMapper.deleteBatchIds(catIdList);
    }

    @Override
    public List<Long> findCatelogPath(Long catelogId) {
        if (catelogId == null || Objects.equals(0L, catelogId)) {
            return Lists.newArrayList();
        }
        // 当前分类不是根分类，继续向上递归
        CategoryEntity category = this.getById(catelogId);
        List<Long> path = findCatelogPath(category.getParentCid());
        path.add(catelogId);
        return path;
    }

    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
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