package shoes.serviceImpl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.CommodityBean;
import shoes.dao.CommodityDao;
import shoes.daoImpl.CommodityDaoImpl;
import shoes.service.CommodityService;

public class CommodityServiceImpl implements CommodityService{
	private CommodityDao dao;
	
	
	public CommodityServiceImpl() {
		super();
		dao = new CommodityDaoImpl();
	}

	@Override
	public void add(CommodityBean t) {
		// TODO Auto-generated method stub
		dao.add(t);
	}

	@Override
	public void delete(CommodityBean t) {
		// TODO Auto-generated method stub
		dao.delete(t);
	}

	@Override
	public void deleteById(CommodityBean t) {
		// TODO Auto-generated method stub
		dao.deleteById(t);
	}

	@Override
	public void update(CommodityBean t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public CommodityBean queryByName(CommodityBean t) {
		// TODO Auto-generated method stub
		return dao.queryByName(t);
	}

	@Override
	public CommodityBean queryById(CommodityBean t) {
		// TODO Auto-generated method stub
		return dao.queryById(t);
	}

	@Override
	public ArrayList<CommodityBean> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public ArrayList<CommodityBean> queryAllOrderPage(int begin, int size) {
		// TODO Auto-generated method stub
		return dao.queryAllOrderPage(begin, size);
	}

	@Override
	public int countOfRows() {
		// TODO Auto-generated method stub
		return dao.countOfRows();
	}

	@Override
	public void upload(HttpServletRequest req, HttpServletResponse res, CommodityBean t) {
		// TODO Auto-generated method stub
		dao.upload(req, res, t);
	}

	@Override
	public void updateUploadImage(CommodityBean t) {
		// TODO Auto-generated method stub
		dao.updateUploadImage(t);
	}

}
