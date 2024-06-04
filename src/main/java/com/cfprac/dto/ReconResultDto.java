package com.cfprac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Getter
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReconResultDto {

    LocalDate businessDate;
    String account;
    String source1Qty;
    String source2Qty;
    String status;
    String breakExplanation;

}
