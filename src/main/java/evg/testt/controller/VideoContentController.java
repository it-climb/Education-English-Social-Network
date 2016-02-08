package evg.testt.controller;

import evg.testt.model.VideoContent;
import evg.testt.service.VideoContentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by alex on 31.01.16.
 */
@Controller
public class VideoContentController {

    @Autowired
    VideoContentService videoContentService;

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public ModelAndView videoHome() throws MalformedURLException {

        VideoContent videoContent = new VideoContent();

        videoContent.setUrl(new URL("https://www.youtube.com/embed/VNq9GqHxl6w"));
        videoContent.setName("film_1");
        videoContent.setType("movie");
        videoContentService.save(videoContent);

        List<VideoContent> contentList = videoContentService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("content", contentList.get(0));
        String videoUrl = videoContent.getUrl().toString();
        modelAndView.addObject("videoUrl", videoUrl);



        return new ModelAndView(JspPath.VIDEO_ALL, "videoUrl", videoUrl);
    }

}
