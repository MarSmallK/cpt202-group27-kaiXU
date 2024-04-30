package group27.xukai.cpt202b.service;


import group27.xukai.cpt202b.entity.FitnessPlan;

import java.util.List;

public interface FitnessPlanService {
    List<FitnessPlan> getFitnessPlanData();

    FitnessPlan getFitnessPlanById(int planId);

}
