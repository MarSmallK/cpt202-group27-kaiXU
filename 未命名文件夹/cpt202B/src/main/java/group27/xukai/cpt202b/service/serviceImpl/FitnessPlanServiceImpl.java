package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.FitnessPlan;
import group27.xukai.cpt202b.repository.FitnessPlanRepository;
import group27.xukai.cpt202b.service.FitnessPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessPlanServiceImpl implements FitnessPlanService {

    private final FitnessPlanRepository fitnessPlanRepository;

    @Autowired
    public FitnessPlanServiceImpl(FitnessPlanRepository fitnessPlanRepository) {
        this.fitnessPlanRepository = fitnessPlanRepository;
    }

    @Override
    public List<FitnessPlan> getFitnessPlanData() {
        return fitnessPlanRepository.findAll();
    }

    @Override
    public FitnessPlan getFitnessPlanById(int planId) {
        return fitnessPlanRepository.findById(planId).orElse(null);
    }

}
