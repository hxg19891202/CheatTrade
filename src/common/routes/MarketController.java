package common.routes;

import com.jfinal.core.Controller;

public class MarketController extends Controller{
	//默认访问方法
	public void index() {
		render("/common/createTask.html");
	}
	//假设controller的访问路径是/market,则该方法访问路径是/market/createTask
	public void createTask() throws Exception {
		render("/common/createTask.html");
	}
	public void importInfo() throws Exception {
		
	}
	public void globalAnalysis() throws Exception {
		render("/common/globalAnalysis.html");
	}
	public void acctAnalysis() throws Exception {
		render("/common/acctAnalysis.html");
	}
	public void report() throws Exception {
		render("/common/report.html");
	}
}
