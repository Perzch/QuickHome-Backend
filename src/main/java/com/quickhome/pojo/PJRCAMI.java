package com.quickhome.pojo;

import com.quickhome.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PJRCAMI {
    RCAMI rcami;
    User user;
    Order order;
    Home home;
}
