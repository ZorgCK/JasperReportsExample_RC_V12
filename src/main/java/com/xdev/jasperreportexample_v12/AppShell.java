
package com.xdev.jasperreportexample_v12;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;


@Theme("Default")
@PWA(name = "Example with applayout", shortName = "Example with applayout")
public class AppShell implements AppShellConfigurator
{
	@Override
	public void configurePage(final AppShellSettings settings)
	{
		settings.addFavIcon("icon", "frontend/images/favicon256.png", "256x256");
		settings.addLink("shortcut icon", "frontend/images/favicon.ico");
	}
	
}
