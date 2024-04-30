package group27.xukai.cpt202b.mapper;

import group27.xukai.cpt202b.entity.Trainer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface TrainerMapper {
    //删除
    int deleteByPrimaryKey(Integer trainerId);

    //新增
    int insert(Trainer record);

    //新增2
    int insertSelective(Trainer record);

    //查询（按学号）
    Trainer selectByPrimaryKey(Integer trainerId);

    //更新
    int updateByPrimaryKeySelective(Trainer record);

    //更新2
    int updateByPrimaryKey(Trainer record);

    //查询所有
    List<Trainer> QueryAll();
}