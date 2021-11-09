package systemTesting.TestAPI;

import com.autumn.executors.annotations.SkipCondition;
import com.autumn.reporting.annotations.TestCategorizer;
import com.autumn.reporting.assertions.CustomAssert;
import com.autumnImp.demo.apiRequestBuilder.getUsers.GetUsers;
import com.autumnImp.demo.global.Environments;
import com.autumnImp.demo.global.Groups;
import com.autumnImp.demo.global.TestCategory;
import com.autumnImp.demo.validators.CommonValidation;
import com.autumnImp.demo.validators.apiStatus.GetUserStatus;
import org.testng.annotations.Test;
import systemTesting.basePackage.Setup;

@SkipCondition(SkipConditions = {Environments.UAT})
public class Execute_GetUsers extends Setup {

    @TestCategorizer(Category = TestCategory.Execute_GetUsers)
    @Test(description = "Get user data", groups = {Groups.SANITY, Groups.SMOKE, Groups.REGRESSION})
    public void TC001_GetUserData() {
        String pageNumber = "2";
        GetUsers getUsers = new GetUsers(pageNumber);
        getUsers.createRequestJsonAndExecute();
        CommonValidation.getInstance().basicAsserts(getUsers, GetUserStatus.UserGetParams.SUCCESS_201);

    }
}
