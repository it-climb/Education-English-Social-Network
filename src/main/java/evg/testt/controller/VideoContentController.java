package evg.testt.controller;

import evg.testt.model.content.*;
import evg.testt.service.videoservices.MovieService;
import evg.testt.service.videoservices.SerialService;
import evg.testt.service.videoservices.TvShowService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/video")
public class VideoContentController {

    @Autowired
    MovieService movieService;
    @Autowired
    SerialService serialService;
    @Autowired
    TvShowService tvShowService;

    /**
     * making start page for choose type of video
     * @return ModelAndView
     * @throws MalformedURLException
     */

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView videoHome(@RequestParam(required = false) String id) throws MalformedURLException {

    //add object in movie,  in serial,  in tv-show
        VideoFile videoFile1 = new VideoFile();
        videoFile1.setName("video_1");
        videoFile1.setDescribe("describing of video_1");
        videoFile1.setUrl("https://www.youtube.com/watch?v=ruxvZGMbGI8");
        VideoFile videoFile2 = new VideoFile();
        videoFile2.setName("video_1");
        videoFile2.setDescribe("describing of video_1");
        videoFile2.setUrl("https://www.youtube.com/watch?v=ruxvZGMbGI8");
        List<VideoFile> videoFiles = new ArrayList<>();
        videoFiles.add(videoFile1);
        videoFiles.add(videoFile2);
        Movie movie1 = new Movie();
        movie1.setMovieContent(videoFiles);
        movie1.setDescribe("describing about this MOVIE");
        movieService.save(movie1);

        Serial serial = new Serial();
        serial.setDescribe("This is SERIAL");
        List<MovieContent> movieContents = new ArrayList<>();
        movieContents.add(movie1);
        serial.setSeason(movieContents);
        serialService.save(serial);

        TvShow tvShow = new TvShow();
        tvShow.setDescribe("This is TV-Show !!");
        tvShow.setSeason(movieContents);
        tvShowService.save(tvShow);


        ModelAndView modelAndView;
        if (id != null) {
            Movie movie = movieService.get(Long.parseLong(id));
            modelAndView = new ModelAndView(JspPath.VIDEO_PLAY, "content", movie);
        } else {
            modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
            List<Movie> contentList = movieService.getAll();
            modelAndView.addObject("contents", contentList);
        }

        return modelAndView;
    }

    /*@RequestMapping(value = "/admin", method = RequestMethod.GET)
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
    }*/


}
