package common.routes;

import com.jfinal.core.Controller;

public class BaseController extends Controller {
	public void index() {
		this.forwardAction("/market/createTask");
	}
}