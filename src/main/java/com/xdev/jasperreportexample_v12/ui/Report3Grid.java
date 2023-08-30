
package com.xdev.jasperreportexample_v12.ui;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.HtmlObject;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.xdev.jasperreportexample_v12.HasTitle;
import com.xdev.jasperreportexample_v12.core.utils.report.ReportCreator;
import com.xdev.jasperreportexample_v12.dal.OrderdetailDAO;
import com.xdev.jasperreportexample_v12.domain.Orderdetail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Route(value = "grid", layout = MainLayout.class)
public class Report3Grid extends VerticalLayout implements HasTitle
{
	public Report3Grid()
	{
		super();
		this.initUI();
	}

	@Override
	public String getTitle()
	{
		return "Crosstab";
	}

	/**
	 * Event handler delegate method for the {@link VerticalLayout}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void this_onAttach(final AttachEvent event)
	{
		final List<Orderdetail> orderDetailList = new OrderdetailDAO().findAll();

		final JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(orderDetailList);

		final Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("creator", "Christian Kümmel");
		parameterMap.put("created", new Date());

		final ReportCreator report = new ReportCreator();
		report.setDataSource(data);
		report.setParameterMap(parameterMap);
		report.setTemplatePath("reports/Report 3 - Crosstab" + ".jrxml");

		try
		{
			final HtmlObject content = new HtmlObject(report.loadAndFillPDFReport());
			content.setSizeFull();
			this.add(content);

		}
		catch(final JRException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(final IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* WARNING: Do NOT edit!<br>The content of this method is always regenerated by the UI designer. */
	// <generated-code name="initUI">
	private void initUI()
	{
		this.setSizeFull();
		
		this.addAttachListener(this::this_onAttach);
	} // </generated-code>

}