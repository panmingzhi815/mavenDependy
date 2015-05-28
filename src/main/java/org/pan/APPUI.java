package org.pan;

import org.eclipse.swt.widgets.FileDialog;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;

public class APPUI extends Shell {
	private DataBindingContext m_bindingContext;
	
	private APPUIModel model = new APPUIModel();
	
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text txtjarmaven;
	private Text text_4;
	private TableViewer tableViewer;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					Display display = Display.getDefault();
					APPUI shell = new APPUI(display);
					shell.open();
					shell.layout();
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public APPUI(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.RESIZE | SWT.TITLE);
		setImage(SWTResourceManager.getImage(APPUI.class,"/image/download_72.png"));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 1;
		setLayout(gridLayout);
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_composite_2 = new GridLayout(2, false);
		gl_composite_2.horizontalSpacing = 0;
		gl_composite_2.verticalSpacing = 0;
		gl_composite_2.marginWidth = 0;
		gl_composite_2.marginHeight = 0;
		composite_2.setLayout(gl_composite_2);
		
		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_3 = new GridLayout(1, false);
		gl_composite_3.marginHeight = 0;
		gl_composite_3.marginTop = 5;
		gl_composite_3.marginLeft = 5;
		gl_composite_3.verticalSpacing = 8;
		composite_3.setLayout(gl_composite_3);
		composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblNewLabel = new Label(composite_3, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.BOLD));
		lblNewLabel.setText("本地maven目录自动生成器");
		
		txtjarmaven = new Text(composite_3, SWT.WRAP | SWT.MULTI);
		txtjarmaven.setText("本程序用于下载远程的jar来构建本地的maven仓库");
		txtjarmaven.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		txtjarmaven.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_4 = new Composite(composite_2, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_4.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_4 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_composite_4.heightHint = 80;
		gd_composite_4.widthHint = 80;
		composite_4.setLayoutData(gd_composite_4);
		
		Label label = new Label(composite_4, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Image image2 = SWTResourceManager.getImage(APPUI.class, "/image/download_72.png");
		label.setImage(image2);
		
		Composite composite_5 = new Composite(this, SWT.NONE);
		composite_5.setLayout(new GridLayout(1, false));
		composite_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Group composite = new Group(composite_5, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_composite = new GridLayout(3, false);
		composite.setLayout(gl_composite);
		
		Label lblmaven = new Label(composite, SWT.NONE);
		lblmaven.setAlignment(SWT.RIGHT);
		GridData gd_lblmaven = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblmaven.widthHint = 100;
		lblmaven.setLayoutData(gd_lblmaven);
		lblmaven.setText("本地maven目录");
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				DirectoryDialog dd = new DirectoryDialog(getShell());
				text.setText(dd.open());
			}
		});
		btnNewButton.setText("选择");
		
		Group group = new Group(composite_5, SWT.NONE);
		GridLayout gl_group = new GridLayout(3, false);
		group.setLayout(gl_group);
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		group.setText("依赖详情");
		
		Label lblGroup = new Label(group, SWT.NONE);
		lblGroup.setAlignment(SWT.RIGHT);
		GridData gd_lblGroup = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblGroup.widthHint = 100;
		lblGroup.setLayoutData(gd_lblGroup);
		lblGroup.setText("group");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_1 = new Composite(group, SWT.NONE);
		RowLayout rl_composite_1 = new RowLayout(SWT.VERTICAL);
		rl_composite_1.marginTop = 0;
		rl_composite_1.marginRight = 0;
		rl_composite_1.marginLeft = 0;
		rl_composite_1.marginBottom = 0;
		composite_1.setLayout(rl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		
		Button button_2 = new Button(composite_1, SWT.NONE);
		button_2.setText("添加");
		
		Button button = new Button(composite_1, SWT.NONE);
		button.setText("保存");
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		button_1.setText("删除");
		
		Button button_3 = new Button(composite_1, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(getShell());
				fd.setFilterExtensions(new String[]{"*.jar"});
				model.getDependency().setUrl(fd.open());
			}
		});
		button_3.setText("选择");
		
		Label lblAtr = new Label(group, SWT.NONE);
		lblAtr.setAlignment(SWT.RIGHT);
		GridData gd_lblAtr = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblAtr.widthHint = 100;
		lblAtr.setLayoutData(gd_lblAtr);
		lblAtr.setText("artifactId");
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblVersion = new Label(group, SWT.NONE);
		lblVersion.setAlignment(SWT.RIGHT);
		GridData gd_lblVersion = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblVersion.widthHint = 100;
		lblVersion.setLayoutData(gd_lblVersion);
		lblVersion.setText("version");
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblUrl = new Label(group, SWT.NONE);
		lblUrl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUrl.setText("url");
		
		text_4 = new Text(group, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		tableViewer = new TableViewer(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnGroup = tableViewerColumn.getColumn();
		tblclmnGroup.setWidth(169);
		tblclmnGroup.setText("group");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnArtifactid = tableViewerColumn_1.getColumn();
		tblclmnArtifactid.setWidth(140);
		tblclmnArtifactid.setText("artifactId");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnVersion = tableViewerColumn_2.getColumn();
		tblclmnVersion.setWidth(100);
		tblclmnVersion.setText("version");
		createContents();
		m_bindingContext = initDataBindings();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("东陆maven仓库生成器");
		setSize(506, 598);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(text);
		IObservableValue localMavenFloderModelObserveValue = PojoProperties.value("localMavenFloder").observe(model);
		bindingContext.bindValue(observeTextTextObserveWidget, localMavenFloderModelObserveValue, null, null);
		//
		IObservableValue observeTextText_1ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_1);
		IObservableValue dependencygroupModelObserveValue = PojoProperties.value("dependency.group").observe(model);
		bindingContext.bindValue(observeTextText_1ObserveWidget, dependencygroupModelObserveValue, null, null);
		//
		IObservableValue observeTextText_2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_2);
		IObservableValue dependencyartifaceIdModelObserveValue = PojoProperties.value("dependency.artifaceId").observe(model);
		bindingContext.bindValue(observeTextText_2ObserveWidget, dependencyartifaceIdModelObserveValue, null, null);
		//
		IObservableValue observeTextText_3ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_3);
		IObservableValue dependencyversionModelObserveValue = PojoProperties.value("dependency.version").observe(model);
		bindingContext.bindValue(observeTextText_3ObserveWidget, dependencyversionModelObserveValue, null, null);
		//
		IObservableValue observeTextText_4ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_4);
		IObservableValue dependencyurlModelObserveValue = PojoProperties.value("dependency.url").observe(model);
		bindingContext.bindValue(observeTextText_4ObserveWidget, dependencyurlModelObserveValue, null, null);
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), Dependency.class, new String[]{"group", "artifaceId", "version", "url"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList dependenciesModelObserveList = PojoProperties.list("dependencies").observe(model);
		tableViewer.setInput(dependenciesModelObserveList);
		//
		return bindingContext;
	}
}
