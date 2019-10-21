package page;

import base.Base;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class PropertyPage extends Base {

    public PropertyPage() {
        PageFactory.initElements(driver, this);
    }
}
