package com.mshcc.cloud.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mshcc
 * @Date 2021/1/13 14:43
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "新增用户参数")
public class GiftDTO {
    @ApiModelProperty(value = "name",required = true,example = "张三")
    private String name;

    private String address;

}
