package gag.intelligentAssistant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("digit_summary")
public class DigitSummary {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String indexName;

    private String provinceName;

    private String cityName;

    private String countyName;

    private String streetName;

    private String rateName;

    private Integer year;

    private Integer quarter;

    private Integer month;

    private Integer day;

    private BigDecimal data;
}
