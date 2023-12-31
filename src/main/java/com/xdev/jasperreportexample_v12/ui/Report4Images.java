
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
import com.xdev.jasperreportexample_v12.dal.EmployeeDAO;
import com.xdev.jasperreportexample_v12.domain.Employee;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Route(value = "images", layout = MainLayout.class)
public class Report4Images extends VerticalLayout implements HasTitle
{
	public Report4Images()
	{
		super();
		this.initUI();
	}
	
	@Override
	public String getTitle()
	{
		return "Todos";
	}
	
	/**
	 * Event handler delegate method for the {@link VerticalLayout}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void this_onAttach(final AttachEvent event)
	{
		// final String creator = "Christian";
		// final Date date = new Date();
		//
		// final StreamResource exportToResource =
		// Report.New()
		// .jrxml("/reports/Report 1 - Basic.jrxml")
		// .dataSource(EmployeeDAO.INSTANCE.findAll())
		// .parameter("creator", creator)
		// .parameter("created", date)
		// .exportToResource(Format.Pdf());
		//
		// final HtmlObject content = new HtmlObject(exportToResource);
		// content.setSizeFull();
		// this.add(content);
		
		// StreamResource.StreamSource imagesource = new StreamSource() {
		// @Override
		// public InputStream getStream() {
		// byte[] b = findAll.get(3).getPhoto();
		// return new ByteArrayInputStream(b);
		// }
		// };
		//
		// StreamResource resource = new StreamResource(imagesource, "myimage.png");
		//
		// image.setSource(resource);
		
		final List<Employee>             employeeList = new EmployeeDAO().findAll();
		final JRBeanCollectionDataSource data         = new JRBeanCollectionDataSource(employeeList);
		
		final Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("creator", "Christian Kümmel");
		parameterMap.put("created", new Date());
		
		final ReportCreator report = new ReportCreator();
		report.setDataSource(data);
		report.setParameterMap(parameterMap);
		report.setTemplatePath("reports/Report 4 - Images" + ".jrxml");
		
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
