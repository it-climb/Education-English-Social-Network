package evg.testt.controller;

import evg.testt.model.Contact;
import evg.testt.model.VideoContent;
import evg.testt.service.ContactService;
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
    @Autowired
    ContactService contactService;


    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public ModelAndView videoHome() throws MalformedURLException {

        ModelAndView modelAndView = new ModelAndView();

        VideoContent videoContent = new VideoContent();

        videoContent.setUrl(new URL("https://www.youtube.com/embed/VNq9GqHxl6w"));
        videoContent.setName("film_1");
        videoContent.setType("movie");

        /*Contact contact = new Contact("scA", "asc", "ASC");
        contactService.save(contact);*/

        videoContentService.save(videoContent);
        List<VideoContent> contentList = videoContentService.getAll();
        modelAndView.addObject("content", contentList.get(0));

        String videoUrl = videoContent.getUrl().toString();
        modelAndView.addObject("videoUrl", videoUrl);

        return new ModelAndView(JspPath.VIDEO_ALL, "videoUrl", videoUrl);
    }

}
