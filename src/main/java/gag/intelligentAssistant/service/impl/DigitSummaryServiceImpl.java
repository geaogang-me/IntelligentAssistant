package gag.intelligentAssistant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gag.intelligentAssistant.entity.DigitSummary;
import gag.intelligentAssistant.mapper.DigitSummaryMapper;
import gag.intelligentAssistant.service.DigitSummaryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DigitSummaryServiceImpl
        extends ServiceImpl<DigitSummaryMapper, DigitSummary>
        implements DigitSummaryService {

    @Override
    public IPage<DigitSummary> queryPage(int pageNum, int pageSize,
                                          String indexName, String provinceName,
                                          String cityName, String countyName,
                                          String streetName, String rateName,
                                          Integer year, Integer quarter,
                                          Integer month, Integer day) {
        LambdaQueryWrapper<DigitSummary> wrapper = buildQueryWrapper(
                indexName, provinceName, cityName, countyName,
                streetName, rateName, year, quarter, month, day);
        return page(new Page<>(pageNum, pageSize), wrapper);
    }

    @Override
    public List<DigitSummary> queryList(String indexName, String provinceName,
                                        String cityName, String countyName,
                                        String streetName, String rateName,
                                        Integer year, Integer quarter,
                                        Integer month, Integer day) {
        LambdaQueryWrapper<DigitSummary> wrapper = buildQueryWrapper(
                indexName, provinceName, cityName, countyName,
                streetName, rateName, year, quarter, month, day);
        return list(wrapper);
    }

    private LambdaQueryWrapper<DigitSummary> buildQueryWrapper(
            String indexName, String provinceName,
            String cityName, String countyName,
            String streetName, String rateName,
            Integer year, Integer quarter,
            Integer month, Integer day) {

        LambdaQueryWrapper<DigitSummary> wrapper = new LambdaQueryWrapper<>();

        wrapper.like(StringUtils.hasText(indexName),
                DigitSummary::getIndexName, indexName);
        wrapper.like(StringUtils.hasText(provinceName),
                DigitSummary::getProvinceName, provinceName);
        wrapper.like(StringUtils.hasText(cityName),
                DigitSummary::getCityName, cityName);
        wrapper.like(StringUtils.hasText(countyName),
                DigitSummary::getCountyName, countyName);
        wrapper.like(StringUtils.hasText(streetName),
                DigitSummary::getStreetName, streetName);

        wrapper.eq(StringUtils.hasText(rateName),
                DigitSummary::getRateName, rateName);

        wrapper.eq(year != null, DigitSummary::getYear, year);
        wrapper.eq(quarter != null, DigitSummary::getQuarter, quarter);
        wrapper.eq(month != null, DigitSummary::getMonth, month);
        wrapper.eq(day != null, DigitSummary::getDay, day);

        wrapper.orderByDesc(DigitSummary::getYear)
                .orderByDesc(DigitSummary::getQuarter)
                .orderByDesc(DigitSummary::getMonth)
                .orderByAsc(DigitSummary::getProvinceName);

        return wrapper;
    }
}
