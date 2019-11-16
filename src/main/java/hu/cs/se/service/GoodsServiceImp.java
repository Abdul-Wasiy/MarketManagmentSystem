package hu.cs.se.service;

import hu.cs.se.model.Good;
import hu.cs.se.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImp implements GoodsService{

    @Autowired
    private GoodsRepository goodsRepository;
    @Override
    public void saveGoods(Good goods) {
        goodsRepository.save(goods);
    }

    @Override
    public Object findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public Good findGoodsById(Long id) {
        return goodsRepository.getOne(id);
    }

    @Override
    public void deleteGoodsById(Long id) {
        goodsRepository.deleteById(id);
    }
}
