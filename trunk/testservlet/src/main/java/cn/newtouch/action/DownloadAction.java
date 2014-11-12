package cn.newtouch.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import cn.newtouch.framework.anno.Path;
import cn.newtouch.framework.context.ActionContext;

@Path("download")
public class DownloadAction
{
    String filepath = "g:";

    // ?filename=DSC_0275.jpg
    @Path
    public void download()
    {
        try
        {
            String downFilename = ActionContext.getRequest().getParameter("filename");
            ActionContext.getResponse().setContentType("text/plain");
            ActionContext.getResponse().setHeader("Location", downFilename);
            ActionContext.getResponse().setHeader("Content-Disposition", "attachment; filename=" + downFilename);
            OutputStream out = ActionContext.getResponse().getOutputStream();
            InputStream in = new FileInputStream(this.filepath + File.separator + downFilename);
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