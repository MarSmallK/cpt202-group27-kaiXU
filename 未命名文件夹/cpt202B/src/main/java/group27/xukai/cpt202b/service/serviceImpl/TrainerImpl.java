package group27.xukai.cpt202b.service.serviceImpl;

import group27.xukai.cpt202b.entity.Trainer;
import group27.xukai.cpt202b.mapper.TrainerMapper;
import group27.xukai.cpt202b.service.TrainerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainerImpl implements TrainerInterface {

    @Autowired
    private TrainerMapper trainerMapper;
    //查询
    public List<Trainer> QueryAll() {

        List<Trainer> trainers = trainerMapper.QueryAll();
        return trainers;
    }
    //查询（按trainer_ID)
    public Trainer selectByPrimaryKey(Integer trainerId){
        Trainer trainer = trainerMapper.selectByPrimaryKey(trainerId);
        return trainer;
    }
    //新增
    public boolean Add(Trainer trainer) {
        int i = trainerMapper.insert(trainer);
        if(i>0)
            return true;
        else
            return false;
    }

    //删除
    public boolean Del(int trainer_ID) {
        int i = trainerMapper.deleteByPrimaryKey(trainer_ID);
        if(i>0)
            return true;
        else
            return false;
    }

    //更新
    public boolean Update(Trainer trainer) {
        int i = trainerMapper.updateByPrimaryKey(trainer);
        if(i>0)
            return true;
        else
            return false;
    }
}
