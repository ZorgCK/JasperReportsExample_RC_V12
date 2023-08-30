
package com.xdev.jasperreportexample_v12.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import com.xdev.jasperreportexample_v12.HasTitle;


public class MainLayout extends AppLayout
{
	private final H2 title = new H2();

	public MainLayout()
	{
		this.addToNavbar(new DrawerToggle(), this.title);

		this.addDrawerEntry(VaadinIcon.FILE_TEXT, "Report 1 Basic", Report1Basic.class);
		this.addDrawerEntry(VaadinIcon.FILE_TEXT, "Report 2 Grouping", Report2Group.class);
		this.addDrawerEntry(VaadinIcon.FILE_TEXT, "Report 3 Grid", Report3Grid.class);
		this.addDrawerEntry(VaadinIcon.FILE_TEXT, "Report 4 Images", Report4Images.class);
		this.addDrawerEntry(VaadinIcon.FILE_TEXT, "Report 5 Charts", Report5Charts.class);
		this.addDrawerEntry(VaadinIcon.FILE_TEXT, "Report 6 SubReport", Report6SubReports.class);
	}

	private void addDrawerEntry(final VaadinIcon icon, final String label, final Class<? extends Component> linkTarget)
	{
		final HorizontalLayout layout = new HorizontalLayout(icon.create(), new RouterLink(label, linkTarget));
		layout.setMargin(true);
		layout.setSpacing(true);
		layout.setPadding(false);
		this.addToDrawer(layout);
	}

	@Override
	public void showRouterLayoutContent(final HasElement content)
	{
		this.title.setText(content instanceof HasTitle ? ((HasTitle)content).getTitle() : "");
		super.showRouterLayoutContent(content);
	}
}
