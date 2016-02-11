package evg.testt.controller;

import evg.testt.model.content.VideoFile;
import evg.testt.service.impl.VideoContentServiceImpl;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;
import java.util.List;


@Controller
@RequestMapping(value = "/video")
public class VideoContentController {

    @Autowired
    VideoContentServiceImpl videoContentServiceImpl;

    /**
     * making start page for choose type of video
     * @return ModelAndView
     * @throws MalformedURLException
     */

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView videoHome(@RequestParam(required = false) String id) throws MalformedURLException {

        ModelAndView modelAndView;
        if (id != null) {
            VideoFile videoFile = videoContentServiceImpl.get(Long.parseLong(id));
            modelAndView = new ModelAndView(JspPath.VIDEO_PLAY, "content", videoFile);
        } else {
            modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
            List<VideoFile> contentList = videoContentServiceImpl.getAll();
            modelAndView.addObject("contents", contentList);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView videoAdmin() {
        List<VideoFile> contentList = videoContentServiceImpl.getAll();
        return new ModelAndView(JspPath.VIDEO_ADMIN, "contents", contentList);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editContent(@RequestParam(required = false) String id) {

        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDIT);
        if (id != null) {
            VideoFile videoFile = videoContentServiceImpl.get(Long.parseLong(id));
            modelAndView.addObject("content", videoFile);
            modelAndView.addObject("contenturl", videoFile.getUrl().toString());
        }

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContent(@ModelAttribute VideoFile videoFile) {
        videoContentServiceImpl.save(videoFile);
        return "redirect:/video/admin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteVideo(@RequestParam(required = true) String id) {
        videoContentServiceImpl.remove(Long.parseLong(id));
        return "redirect:/video/admin";
    }


}
