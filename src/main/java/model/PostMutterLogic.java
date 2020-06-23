package model;

import dao.MutterDao;
import entity.Mutter;

public class PostMutterLogic {

	public boolean execute(Mutter mutter) {
		
		MutterDao dao = new MutterDao();
		return dao.insertMutterContent(mutter);
	}
}
