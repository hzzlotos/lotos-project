package cn.newtouch.web;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.newtouch.util.FileUtils;

import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/fileupload")
public class FileUploadController
{
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartHttpServletRequest mrequest)
    {
        Map<String, Object> result = Maps.newHashMap();
        try
        {
            Map<String, MultipartFile> fileMap = mrequest.getFileMap();
            for (String field : fileMap.keySet())
            {
                MultipartFile mFile = fileMap.get(field);
                File tempFile = FileUtils.createTempFile(FileUtils
                        .getFileExtension(mFile.getOriginalFilename()));
                mFile.transferTo(tempFile);
                result.put("fileName", mFile.getOriginalFilename());
                result.put("filePath", tempFile.getAbsolutePath());
                System.out.println("=======fileName======"
                        + mFile.getOriginalFilename());
                System.out.println("=======filePath======"
                        + tempFile.getAbsolutePath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            result = Maps.newHashMap();
            result.put("error", "error");
            return result;
        }
        return result;
    }
}
