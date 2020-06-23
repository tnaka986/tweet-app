package model;

import java.util.List;

import dao.MutterDao;
import entity.Mutter;

public class GetMutterListLogic {

	public List<Mutter> execute() {
		
		MutterDao dao = new MutterDao();
		return dao.findAll();
	}
}
