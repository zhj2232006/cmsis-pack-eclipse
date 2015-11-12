/*******************************************************************************
* Copyright (c) 2015 ARM Ltd. and others
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* ARM Ltd and ARM Germany GmbH - Initial API and implementation
*******************************************************************************/
package com.arm.cmsis.pack.ui.widgets;

import org.eclipse.swt.widgets.Composite;

import com.arm.cmsis.pack.events.IRteEventListener;
import com.arm.cmsis.pack.rte.IRteModelController;
import com.arm.cmsis.pack.ui.tree.IColumnAdvisor;

public abstract class RteWidget implements IRteEventListener {

	protected IRteModelController fModelController = null;		// contains RteComponents
	protected IColumnAdvisor fColumnAdvisor = null;

	/**
	 * Sets an RTE model to bu used by the widget 
	 * @param IRteModel
	 */
	public void setModelController(IRteModelController modelController) {
		if(fModelController == modelController)
			return;
		if(fModelController != null)
			fModelController.removeListener(this);
		fModelController = modelController;
		if(fModelController != null)
			fModelController.addListener(this);
	}
	
	/**
	 * Returns RTE model used by the widget
	 * @return RTE model
	 */
	public IRteModelController getModelController() {
		return fModelController;
	}

	/**
	 * Returns Column adviser 
	 * @return IColumnAdvisor
	 */
	public IColumnAdvisor getColumnAdvisor() {
		return fColumnAdvisor;
	}

	/**
	 * Sets column adviser
	 * @param columnAdvisor IColumnAdvisor
	 */
	public void setColumnAdvisor(IColumnAdvisor columnAdvisor) {
		fColumnAdvisor = columnAdvisor;
	}


	
	/**
	 * Refresh UI without changing configuration 
	 */
	public abstract void refresh();
	
	/**
	 * refresh UI after having changed configuration 
	 */
	public abstract void update();

	/**
	 * Creates actual control
	 * @param parent parent composite
	 * @return created control
	 */
	public abstract Composite createControl(Composite parent);

	/**
	 * Returns Composite that should be used as focus widget
	 * @return widget to set focus to 
	 */
	public abstract Composite getFocusWidget();
	
}