package com.cfprac.client;

import com.cfprac.dto.ReconResultDto;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SourceClient {

    public List<ReconResultDto> fetchReconResult(){

        ReconResultDto reconResultDto1 = ReconResultDto.builder()
                .businessDate(LocalDate.of(2024,05,31))
                .account("10022")
                .source1Qty("1000")
                .source2Qty("1000")
                .status("Reconciled")
                .breakExplanation(null)
                .build();

        ReconResultDto reconResultDto2 = ReconResultDto.builder()
                .businessDate(LocalDate.of(2024,05,31))
                .account("20022")
                .source1Qty("1500")
                .source2Qty("1200")
                .status("Unreconciled")
                .breakExplanation("Break - Difference - 300")
                .build();

        ReconResultDto reconResultDto3 = ReconResultDto.builder()
                .businessDate(LocalDate.of(2024,05,31))
                .account("30022")
                .source1Qty("1000")
                .source2Qty(null)
                .status("Unreconciled")
                .breakExplanation("Break - Missing in source 2")
                .build();

        ReconResultDto reconResultDto4 = ReconResultDto.builder()
                .businessDate(LocalDate.of(2024,05,31))
                .account("40022")
                .source1Qty(null)
                .source2Qty("1000")
                .status("Unreconciled")
                .breakExplanation("Break - Missing in source 1")
                .build();

        ReconResultDto reconResultDto5 = ReconResultDto.builder()
                .businessDate(LocalDate.of(2024,05,31))
                .account("50022")
                .source1Qty("2000")
                .source2Qty("2000")
                .status("Reconciled")
                .breakExplanation(null)
                .build();

        ReconResultDto reconResultDto6 = ReconResultDto.builder()
                .businessDate(LocalDate.of(2024,05,31))
                .account("60022")
                .source1Qty("2500")
                .source2Qty("2100")
                .status("Unreconciled")
                .breakExplanation("Break - Difference - 300")
                .build();

        List<ReconResultDto> reconResultDtos = new ArrayList<>();
        reconResultDtos.add(reconResultDto1);
        reconResultDtos.add(reconResultDto2);
        reconResultDtos.add(reconResultDto3);
        reconResultDtos.add(reconResultDto4);
        reconResultDtos.add(reconResultDto5);
        reconResultDtos.add(reconResultDto6);
        return reconResultDtos;

    }


}
