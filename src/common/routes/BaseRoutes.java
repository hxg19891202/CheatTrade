package common.routes;

import com.jfinal.config.Routes;

public class BaseRoutes extends Routes {

	@Override
	public void config() {
		this.add("/market", MarketController.class);
	}

}
