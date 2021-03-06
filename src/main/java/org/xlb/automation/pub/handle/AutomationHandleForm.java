package org.xlb.automation.pub.handle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xlb.automation.pub.AutomationFind;
import org.xlb.automation.pub.bean.Operator;

/**
 * 
 * 表单操作
 * @author Lingbo Xie
 * @date 2018-08-23
 * @version V1.0
 *
 */
public class AutomationHandleForm extends AbstractAutomationHandle {

	@Override
	public String handle(Operator oper , WebDriver driver) throws Exception {
		WebElement element = (WebElement) AutomationFind.find(oper.getFind(), oper.getFind_text(), driver);
		String retStr = "";
		 element.submit();
		try{
			retStr = this.endCheck(oper, driver);
		}catch(Exception e){
			throw e;
		}
		 return retStr;
	}

}
