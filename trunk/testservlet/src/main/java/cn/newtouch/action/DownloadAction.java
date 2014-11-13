package cn.newtouch.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import cn.newtouch.framework.anno.Path;
import cn.newtouch.framework.anno.PathParam;
import cn.newtouch.framework.context.ActionContext;

@Path("common")
public class DownloadAction extends BaseAction
{
    String filepath = "g:";

    // ?filename=DSC_0275.jpg
    @Path("download/{filename}")
    public void download(@PathParam String filename)
    {
        try
        {
            ActionContext.getResponse().setContentType("text/plain");
            ActionContext.getResponse().setHeader("Location", filename);
            ActionContext.getResponse().setHeader("Content-Disposition", "attachment; filename=" + filename);
            OutputStream out = ActionContext.getResponse().getOutputStream();
            InputStream in = new FileInputStream(this.filepath + File.separator + filename);
            byte[] buffer = new byte[1024];
            int i = -1;
            while ((i = in.read(buffer)) != -1)
            {
                out.write(buffer, 0, i);
            }
            in.close();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("系统错误，请及时与管理员联系");
        }
    }
}