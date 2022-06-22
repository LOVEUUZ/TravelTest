package com.example.uuz.controller;

import com.example.uuz.responseResult.ResponseResult;
import com.example.uuz.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

@Api(tags = {"bing壁纸"})
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation("bing壁纸")
    @GetMapping("/getBackground")
    public ResponseResult getBackground(HttpServletResponse response) throws IOException {
        return testService.getBackground(response);
    }

    @ApiOperation("bing壁纸信息")
    @GetMapping("/getBackgroundMsg")
    public ResponseResult getBackgroundMsg() throws InterruptedException {
        return testService.getBackgroundMsg();
    }

    @ApiOperation("图片测试")
    @GetMapping("/PicTest")
    public ResponseResult<String> getPic(HttpServletResponse response) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/pic/EyRwZKwVIAIvI8T.png");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            int len;
            byte[] b = new byte[1024 * 10];

            while ((len = bufferedInputStream.read(b)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }

            response.getOutputStream().flush();
            response.getOutputStream().close();
            bufferedInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseResult.okResult("成功");
    }

    //视频播放
    @ApiOperation("单个MP4播放")
    @GetMapping(value = "/video")
    public void aloneVideoPlay(HttpServletResponse response) {
        InputStream is;
        OutputStream os = null;
        try {
            response.setContentType("video/mp4");
            File file = new File("E:\\新建文件夹\\[BYYM][相對世界。明日終結？The Relative Worlds _ Ashita Sekai ga Owaru to Shite mo][2019][Web-Dl 1080p AVC AAC BIG5][JAP][MP4].mp4");
            response.addHeader("Content-Length", "" + file.length());
            is = Files.newInputStream(file.toPath());
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (Exception e) {
            System.out.println("播放MP4失败");
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
