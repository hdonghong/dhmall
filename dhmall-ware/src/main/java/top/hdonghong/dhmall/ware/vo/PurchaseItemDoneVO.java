package top.hdonghong.dhmall.ware.vo;

import lombok.Data;

@Data
public class PurchaseItemDoneVO {
    //{itemId:1,status:4,reason:""}
    private Long itemId;
    private Integer status;
    private String reason;
}
