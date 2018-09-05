package shoes.serviceImpl;

import java.util.ArrayList;

import shoes.bean.CategoryBean;
import shoes.dao.CategoryDao;
import shoes.daoImpl.CategoryDaoImpl;
import shoes.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao dao;
	
	
	public CategoryServiceImpl() {
		super();
		dao = new CategoryDaoImpl();
	}

	@Override
	public void add(CategoryBean t) {
		dao.add(t);
		
	}

	@Override
	public void delete(CategoryBean t) {
		dao.delete(t);
		
	}

	@Override
	public void deleteById(CategoryBean t) {
		dao.deleteById(t);
		
	}

	@Override
	public void update(CategoryBean t) {
		dao.update(t);
		
	}

	@Override
	public CategoryBean queryByName(CategoryBean t) {
		// TODO Auto-generated method stub
		return dao.queryByName(t);
	}

	@Override
	public CategoryBean queryById(CategoryBean t) {
		// TODO Auto-generated method stub
		return dao.queryById(t);
	}

	@Override
	public ArrayList<CategoryBean> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public ArrayList<CategoryBean> queryAllOrderPage(int begin, int size) {
		// TODO Auto-generated method stub
		return dao.queryAllOrderPage(begin, size);
	}

	@Override
	public int countOfRows() {
		// TODO Auto-generated method stub
		return dao.countOfRows();
	}

}
