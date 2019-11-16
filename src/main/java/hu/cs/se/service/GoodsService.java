package hu.cs.se.service;


import hu.cs.se.model.Good;

public interface GoodsService {
    void saveGoods(Good goods);
    Object findAll();

    Good findGoodsById(Long id);

    void deleteGoodsById(Long id);
}
