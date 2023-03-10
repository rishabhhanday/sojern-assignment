package com.sojern.assignment.service;

import com.sojern.assignment.model.*;

public interface MathService {
    MinResponse calculateMin(MinRequest minRequest);

    MaxResponse calculateMax(MaxRequest maxRequest);

    AvgResponse calculateAverage(AvgRequest avgRequest);

    MedianResponse calculateMedian(MedianRequest medianRequest);

    PercentileResponse calculatePercentile(PercentileRequest percentileRequest);
}
