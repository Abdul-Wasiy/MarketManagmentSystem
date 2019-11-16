package hu.cs.se.service;

import hu.cs.se.model.MyCategory;
import hu.cs.se.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void saveCategory(MyCategory myCategory) {
        categoryRepository.save(myCategory);
    }

    @Override
    public Object findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public MyCategory findCategoryById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public void deleteCategoryById(Long id) {
            categoryRepository.deleteById(id);
    }
}
