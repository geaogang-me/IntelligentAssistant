package gag.intelligentAssistant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gag.intelligentAssistant.entity.DigitSummary;

import java.util.List;

public interface DigitSummaryService {

    IPage<DigitSummary> queryPage(int pageNum, int pageSize,
                                  String indexName, String provinceName,
                                  String cityName, String countyName,
                                  String streetName, String rateName,
                                  Integer year, Integer quarter,
                                  Integer month, Integer day);

    List<DigitSummary> queryList(String indexName, String provinceName,
                                 String cityName, String countyName,
                                 String streetName, String rateName,
                                 Integer year, Integer quarter,
                                 Integer month, Integer day);
}
