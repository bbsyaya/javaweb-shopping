package shoes.dao;

import java.util.ArrayList;

public interface BaseDao<T> {
	void add(T t);
	void delete(T t);
	void deleteById(T t);
	void update(T t);
	T queryByName(T t);
	T queryById(T t);
	ArrayList<T> queryAll();
	ArrayList<T> queryAllOrderPage(int begin,int size);
	int countOfRows();
}
