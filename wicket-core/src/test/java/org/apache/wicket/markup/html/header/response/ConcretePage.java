/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.markup.html.header.response;

import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.head.PriorityHeaderItem;

/**
 * Page with a wicket:head (markup inheritance), a header contribution and 2 panels, one in the
 * header and one in the body
 */
public class ConcretePage extends AbstractPage
{
	private static final long serialVersionUID = 1L;

	/**
	 * Construct.
	 */
	public ConcretePage()
	{
		add(new HeaderPanel("headerPanel"));
		add(new PanelWithHeader("panel"));
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		response.render(StringHeaderItem.forString("<title>HeaderContributionInConcretePage</title>\n"));
		response.render(new PriorityHeaderItem(
			StringHeaderItem.forString("<title>PriorityHeaderContributionInConcretePage</title>\n")));
	}
}