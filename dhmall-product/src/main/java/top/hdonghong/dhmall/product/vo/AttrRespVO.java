package top.hdonghong.dhmall.product.vo;

import lombok.Data;

import java.util.List;

@Data
public class AttrRespVO extends AttrVO {
    /**
     * 			"catelogName": "手机/数码/手机", //所属分类名字
     * 			"groupName": "主体", //所属分组名字
     */
    private String catelogName;
    private String groupName;

    private List<Long> catelogPath;
}
