package systemTesting.TestAPI;

import com.autumn.reporting.assertions.CustomAssert;
import com.autumn.utils.commonUtil.CommonUtil;
import com.autumnImp.demo.apiRequestBuilder.createUser.CreateUsers;
import com.autumnImp.demo.global.Groups;
import com.autumnImp.demo.validators.CommonValidation;
import com.autumnImp.demo.validators.apiStatus.GetUserStatus;
import org.testng.annotations.Test;
import systemTesting.basePackage.Setup;


public class Execute_CreateUser extends Setup {

    @Test(description = "Create a single user with valid data", groups = {Groups.SANITY, Groups.SMOKE, Groups.REGRESSION})
    public void TC001_CreateSingleUser() {
        String name  = CommonUtil.getInstance().generateRandomString(5);
        String job = "Test Manager";
        CreateUsers createUsers = new CreateUsers(CreateUsers.DEFAULT_CREATE_USER_REQUEST);
        createUsers.getRequestPojo().setName(name);
        createUsers.getRequestPojo().setJob(job);
        createUsers.createRequestJsonAndExecute();
        CommonValidation.getInstance().basicAsserts(createUsers, GetUserStatus.UserGetParams.SUCCESS_201);
        CustomAssert.assertEquals(createUsers.getResponsePojo().getName(), name, "");
        CustomAssert.assertEquals(createUsers.getResponsePojo().getJob(), job, "");
    }


}
