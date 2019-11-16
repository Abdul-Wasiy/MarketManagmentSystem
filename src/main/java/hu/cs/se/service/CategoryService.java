package hu.cs.se.service;


import hu.cs.se.model.MyCategory;

public interface CategoryService {
    void saveCategory(MyCategory myCategory);
    Object findAll();

    MyCategory findCategoryById(Long id);

    void deleteCategoryById(Long id);
}
