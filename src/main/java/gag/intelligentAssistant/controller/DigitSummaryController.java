package gag.intelligentAssistant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gag.intelligentAssistant.common.Result;
import gag.intelligentAssistant.entity.DigitSummary;
import gag.intelligentAssistant.service.DigitSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/digit-summary")
@RequiredArgsConstructor
public class DigitSummaryController {

    private final DigitSummaryService digitSummaryService;

    @GetMapping("/page")
    public Result<IPage<DigitSummary>> queryPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false) String indexName,
            @RequestParam(required = false) String provinceName,
            @RequestParam(required = false) String cityName,
            @RequestParam(required = false) String countyName,
            @RequestParam(required = false) String streetName,
            @RequestParam(required = false) String rateName,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer quarter,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer day) {

        IPage<DigitSummary> page = digitSummaryService.queryPage(
                pageNum, pageSize,
                indexName, provinceName, cityName, countyName,
                streetName, rateName,
                year, quarter, month, day);
        return Result.success(page);
    }

    @GetMapping("/list")
    public Result<List<DigitSummary>> queryList(
            @RequestParam(required = false) String indexName,
            @RequestParam(required = false) String provinceName,
            @RequestParam(required = false) String cityName,
            @RequestParam(required = false) String countyName,
            @RequestParam(required = false) String streetName,
            @RequestParam(required = false) String rateName,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer quarter,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer day) {

        List<DigitSummary> list = digitSummaryService.queryList(
                indexName, provinceName, cityName, countyName,
                streetName, rateName,
                year, quarter, month, day);
        return Result.success(list);
    }
}
