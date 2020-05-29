package top.hdonghong.common.exception;

import lombok.Getter;

/**
 * BizCodeEnum enum<br/>
 *
 * @author hdonghong
 * @since 2020/05/24
 */
@Getter
public enum BizCodeEnum {

    UNKNOWN_EXCEPTION(10000, "系统未知异常"),

    INVALID_EXCEPTION(10001, "参数校验异常"),
    ;

    private Integer code;
    private String msg;

    BizCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
