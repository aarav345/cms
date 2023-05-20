package cms;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class SelectfromButtonGroup {
	
	ButtonGroup buttonGroup;
	
	public SelectfromButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}
	
	public String getSelectedButtonText() {
	    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = (AbstractButton) buttons.nextElement();

	        if (button.isSelected()) {
	            return button.getText();
	        }
	    }

	    return "";
	}

}
