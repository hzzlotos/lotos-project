package cn.newtouch.action;

import cn.newtouch.annotation.Path;
import cn.newtouch.annotation.PathParam;
import cn.newtouch.enums.Content_Type;
import cn.newtouch.service.TestService;

@Path("ajax")
public class TestAjaxAction extends BaseAction
{
    @Path(value = "testAjax", ContentType = Content_Type.JSON)
    public String ajax()
    {
        TestService ts = new TestService();
        return this.ajaxJson(ts.dosomething());
    }

    @Path(value = "getprogress/{threadId}", ContentType = Content_Type.JSON)
    public String getprogress(@PathParam Long threadId)
    {
        return this.ajaxJson(TestService.getprogress(threadId));
    }
}
