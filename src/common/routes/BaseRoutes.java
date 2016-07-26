package common.routes;

import com.jfinal.config.Routes;
/**
 * 基础跳转路径
 * */
public class BaseRoutes extends Routes {

	@Override
	public void config() {
		this.add("/market", MarketController.class);
	}

}
