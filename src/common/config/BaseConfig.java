package common.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import common.routes.BaseRoutes;
import common.routes.HelloController;

public class BaseConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		PropKit.use("config.properties");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setViewType(ViewType.FREE_MARKER);
		me.setError404View("/common/error/404.html");
		me.setError500View("/common/error/500.html");
		me.setBaseDownloadPath(PropKit.get("download_path"));
		me.setBaseUploadPath(PropKit.get("upload_path"));
	}

	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
		me.add(new BaseRoutes());
	}

	public void configPlugin(Plugins me) {
		C3p0Plugin C3p0Plugin = new C3p0Plugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.user"), PropKit.get("jdbc.password").trim());
		me.add(C3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
		me.add(arp);
		
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}