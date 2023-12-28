package com.kyle.vo;

/*import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;*/
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LoginVO {



    private Integer id;


    private String userName;


    private String name;


    private String token;
}
