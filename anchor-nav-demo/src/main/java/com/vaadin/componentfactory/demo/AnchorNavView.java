package com.vaadin.componentfactory.demo;

/*
 * #%L
 * Vaadin Component Factory Anchor Nav Example for Vaadin 14
 * %%
 * Copyright (C) 2017 - 2018 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file license.html distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */

import com.vaadin.componentfactory.AnchorNav;
import com.vaadin.componentfactory.AnchorNavSection;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * Server-side component Example for the <code>vcf-anchor-nav</code> element.
 *
 * @author Vaadin Ltd
 */
@Route("anchor-nav")
public class AnchorNavView extends DemoView {

	@Override
	protected void initView() {
		basicExample();
	}

	private void basicExample() {
		// begin-source-example
		// source-example-heading: Basic Example
		AnchorNav anchorNav = new AnchorNav();
		anchorNav.setHeight("50vh");
		anchorNav.setHeader(new H1("Main Header"));

		Div introductionContent = new Div(
				new Text("Scroll down to see:"),
				new UnorderedList(
						new ListItem("Tabs sticking to the top"), 
						new ListItem("Tab of visible section being highlighted"), 
						new ListItem("Tabs horizontally scrolling when overflowing")),
				new Text("Click on a tab to jump to section."));
		Div accessibilityContent = new Div(
				new Text("Accessibility has been taken seriously when implementing the component."),
				new OrderedList(
						new ListItem("Try focusing tabs using keyboard, move focus with arrow keys"), 
						new ListItem("Hit ENTER or SPACE to jump to sections"), 
						new ListItem("Move focus to this text field by hitting TAB")),
				new TextField());

		anchorNav.addSection("Introduction", introductionContent);
		anchorNav.addSection("Accessibility", accessibilityContent);

		AnchorNavSection customHeaderSection = anchorNav.addSection("Custom Tab Name", new Span("Headers and tab names are set automatically. You can customize them to your needs."));
		customHeaderSection.setSectionHeader(new H1("Custom Header"));

		AnchorNavSection shortSection = anchorNav.addSection("Section 4", new Span("Section 4 is short."));
		shortSection.setHeight("20vh");

		AnchorNavSection longSection = anchorNav.addSection("Section 5", new Span("Section 5 is long."));
		longSection.setHeight("120vh");

		anchorNav.addSection("Section 6", new Span("Section 6 content."));

		// end-source-example
		addCard("Basic Example", anchorNav);
	}
}
