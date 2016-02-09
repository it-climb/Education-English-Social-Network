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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


@Controller
@RequestMapping(value = "/video")
public class VideoContentController {

    @Autowired
    VideoContentService videoContentService;

    /**
     * making start page for choose type of video
     * @return ModelAndView
     * @throws MalformedURLException
     */

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView videoHome(@RequestParam(required = false) String id) throws MalformedURLException {

        ModelAndView modelAndView;
        if (id != null) {
            VideoContent videoContent = videoContentService.get(Long.parseLong(id));
            modelAndView = new ModelAndView(JspPath.VIDEO_PLAY, "content", videoContent);
        } else {
            modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
            List<VideoContent> contentList = videoContentService.getAll();
            modelAndView.addObject("contents", contentList);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView videoAdmin() {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_ADMIN);

        return modelAndView;
    }


}
