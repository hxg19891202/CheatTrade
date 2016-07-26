package common.routes;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
	public void index() {
		//render("index.html");
		render("/common/error/404.html");
	}
}