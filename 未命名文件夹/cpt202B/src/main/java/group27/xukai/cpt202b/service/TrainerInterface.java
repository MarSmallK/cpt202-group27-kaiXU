package group27.xukai.cpt202b.service;

import group27.xukai.cpt202b.entity.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TrainerInterface {
    //查询
    List<Trainer> QueryAll();
    //按trainerId查询
    Trainer selectByPrimaryKey(Integer trainerId);
    //新增
    boolean Add(Trainer trainer);
    //删除
    boolean Del(int trainer_ID);
    //修改
    boolean Update(Trainer trainer);

}
