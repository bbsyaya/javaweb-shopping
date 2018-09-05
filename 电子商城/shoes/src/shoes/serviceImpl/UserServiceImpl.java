package shoes.serviceImpl;

import java.util.ArrayList;

import shoes.bean.UserBean;
import shoes.dao.UserDao;
import shoes.daoImpl.UserDaoImpl;
import shoes.service.UserService;



public class UserServiceImpl implements UserService{
	private UserDao dao;
	
	public UserServiceImpl() {
		super();
		dao = new UserDaoImpl();
	}

	@Override
	public void add(UserBean t) {
		// TODO Auto-generated method stub
		dao.add(t);
	}

	@Override
	public void delete(UserBean t) {
		// TODO Auto-generated method stub
		dao.delete(t);
	}

	@Override
	public void update(UserBean t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public UserBean queryByName(UserBean t) {
		// TODO Auto-generated method stub
		return dao.queryByName(t);
	}

	@Override
	public ArrayList<UserBean> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public UserBean queryById(UserBean t) {
		// TODO Auto-generated method stub
		return dao.queryById(t);
	}

	@Override
	public void deleteById(UserBean t) {
		// TODO Auto-generated method stub
		dao.deleteById(t);
	}

	@Override
	public ArrayList<UserBean> queryAllOrderPage(int begin, int size) {
		// TODO Auto-generated method stub
		return dao.queryAllOrderPage(begin, size);
	}

	@Override
	public int countOfRows() {
		// TODO Auto-generated method stub
		return dao.countOfRows();
	}

}
