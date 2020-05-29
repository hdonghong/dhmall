package top.hdonghong.dhmall.product.excetion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.hdonghong.common.exception.BizCodeEnum;
import top.hdonghong.common.utils.R;

import java.util.HashMap;
import java.util.Map;

/**
 * DhmallExceptionControllerAdvice class<br/>
 *
 * @author hdonghong
 * @since 2020/05/24
 */
@Slf4j
@RestControllerAdvice(basePackages = "top.hdonghong.dhmall.product.controller")
public class DhmallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题 {}, 异常类型：{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return R.error(BizCodeEnum.INVALID_EXCEPTION.getCode(), BizCodeEnum.INVALID_EXCEPTION.getMsg())
                .put("data", errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {
        throwable.printStackTrace();
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
